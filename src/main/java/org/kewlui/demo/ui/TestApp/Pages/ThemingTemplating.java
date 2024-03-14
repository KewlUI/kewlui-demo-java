package org.kewlui.demo.ui.TestApp.Pages;

/*
MIT License

Copyright (c) 2024 GoFintec Ltd

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.template.GenFromTemplate;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


/**
 * Examples of theming, localisation and templating within the system
 */
public class ThemingTemplating extends BasePage {

    protected static final Logger Log = LogManager.getLogger(ThemingTemplating.class);

    public ThemingTemplating () {
        super(false);
    }


    public void addThemingExamples(VisualControl parent, StateData state) {
        VStack vs = VStack.appendTo(parent,state);

        String chartMarkup = """
# Theming and Localisation/Templates

A number of themes are available by default, and the user may also add themes to the application.

Templates/Localisation allow Text fields within objects to have their own translations {{moustache}} syntax


""";
        Markdown.appendTo(vs, state,chartMarkup, Markdown.ControlsEnum.NONE);

        addLocalisationExamples(vs, state);

        addTemplateConcepts(vs, state);

        addThemeBasic(vs, state);
        addThemeColors(vs, state);
        addThemeExamples(vs, state);

        String markdownDescription = """
### Other controls

More will be added in the future
""";
        Markdown.appendTo(vs,state,markdownDescription, Markdown.ControlsEnum.NONE);
    }



    private void addLocalisationExamples (VStack parent, StateData state) {

        var vs = new VStack(state);

        String markdownDescription = """
    ## Client Side Templating
        
    Client side templating can be used for filling in user specific information into a control (such as user name),
    and also for localization.
        
    - Client templating system modifies a controls "Text" field, which will perform optional translation.
    
    - The templating system uses moustache.  That is, "{{templateName}}" will perform a lookup in the client side templating system
    and replace it with the result. 
    
    For example, we could define a button that has Text="{{saveText}}, where saveText is replace with "Save" in English and "Speichern" in German.
            
    ### TemplateValues Container
    
    A TemplateValues container allows setting key/value lookups for all controls under it.
    One of these is included by default in every form, but you are free to create your own.
    
    - TemplateValues.setValue(String key, Object value)
        - used for setting a large number of key value pairs
        - key is a string, value can be either a key/value map, or a json string containing a dictionary
        
    - TemplateValues.setTemplate(String key, String name)
       - Optional way of selecting an sub template to be active
       - If given the name of a key in a key/value map where the value is also a key/value map, the sub map will be moved to the top level
       - Used for such things as selecting languages.  A number of languages could be added (languagename->key/value map), with the user selecting a language to be used
       - See examples below
               
    ### Form.TemplateValues
    
    Each form also has a TemplateValues container automatically included.
    
    To use these, the form provides the following functions:
    
        - form.setFormKeyValues(StateData state, Map<String,String> data)
            - Can be given a Map<String,Object> to supply key-values to set key/value lookups.
            - This can be used to set key/value lookups, e.g. "{{userName}}", would look up "userName" in the provided map.-
            
        - form.setTemplateValues(StateData state, Object data)
            - Can be given a json with a dictionary of key/value lookups
                
        - form.setTemplateName(StateData state, String name)
            - Calls the 'setTemplate' of the TemplateValues container 
                    
    ### Example:
    
    In the example below, we will make a select to choose between two languages.
    
    - One Button will have the static {{username}} in its text
    - The other button will have {{local.save}} in its text
    
    By using the select, we call setTemplateName to choose whether lang.en or lang.de is used
    
    ```java
        String jsonTemplateConfig = '
            {
                "lang.en": {
                    "local.save": "Save"
                },
                "lang.de": {
                    "local.save": "Speichern"
                },
                
                "local.exclamation": "!"
            }
        ';
        String userName = "Bob";
    ```
    
       What happens:  On choosing setTemplate "lang.en", all the key/values under "lang.en" are moved to the top level.
       Thus, "{{local.save}}" will translate to "Save"
     
    """;

        // create a template values container using a json dictionary
        TemplateValues locale = TemplateValues.appendTo(vs, state);
        String jsonTemplateConfig = """
            {
                "lang.en": {
                    "local.save": "Save"
                },
                "lang.de": {
                    "local.save": "Speichern"
                }
            }        
        """;
        locale.setValue(state, jsonTemplateConfig);
        locale.setTemplate(state, "lang.en"); // default

        // create another sub template container, which contains information on the current session/user
        TemplateValues userConfig = TemplateValues.appendTo(locale, state);
        var userKV = new HashMap<String,Object>();
        userKV.put("userName", "Bob");
        userConfig.setValue(state, userKV);

        VStack container = VStack.appendTo(userConfig, state);

        var select = Select.appendTo(container, state, "lang.en,lang.de");
        select.setValue(state, "lang.en");
        select.setOnChange(state, (e)-> {
            var templateName = select.getValue(e.clientState());
            locale.setTemplate(e.clientState(), templateName);
        });

        Text.appendTo(container, state, "Following button Text is populated based on chosen lang template");
        Button.appendTo(container, state, "{{local.save}}");

        Text.appendTo(container, state, "Hi {{userName}}! Welcome to the system");
        Button.appendTo(container, state, "UserName: {{userName}}");

        String java = """
    // create a template values container using a json dictionary
    TemplateValues locale = TemplateValues.appendTo(vs, state);
    String jsonTemplateConfig = ""\"
        {
            "lang.en": {
                "local.save": "Save"
            },
            "lang.de": {
            "local.save": "Speichern"
            }
        } 
    ""\";
    locale.setValue(state, jsonTemplateConfig);
    locale.setTemplate(state, "lang.en"); // set default tree used, will be copied to top level

    // create another sub template container, which contains information on the current session/user
    TemplateValues userConfig = TemplateValues.appendTo(locale, state);
    var userKV = new HashMap<String,Object>();
    userKV.put("userName", "Bob");
    userConfig.setValue(state, userKV);

    // Create a VStack container under the TemplateValues container above and start adding controls 
    VStack container = VStack.appendTo(userConfig, state);

    var select = Select.appendTo(container, state, "lang.en,lang.de");
    select.setValue(state, "lang.en");
    select.setOnChange(state, (e)-> {
        var templateName = select.getValue(e.clientState());
        locale.setTemplate(e.clientState(), templateName);
    });

    Text.appendTo(container, state, "Following button Text is populated based on chosen lang template");
    Button.appendTo(container, state, "{{local.save}}");

    Text.appendTo(container, state, "Hi {{userName}}! Welcome to the system");       
    Button.appendTo(container, state, "UserName: {{userName}}");                
                                
""";

        addExplanationPages(parent, state, "Client Side Templating", markdownDescription, vs, java);
    }



    public void addTemplateConcepts (VisualControl parent, StateData globalState) {

        String markdownDescription = """
### Server Template Example 

This example illustrates the use of templating engines on both the client and server sides. On the server side, the template can simplify the codebase by enabling the storage of component definitions either in a file or directly within a text block.

The GenFromTemplate class facilitates the process of importing definitions from an XML text and integrating them into the existing structure.

Elements tagged with "xcontrol" are specifically designed to be customizable, allowing users to make modifications as required.

Additionally, text blocks within the template are processed as markdown, providing an enhanced text formatting capability.

The template supports Moustache-style syntax for dynamic content insertion. For example, using {{SomeVariable}} within the template automatically replaces this placeholder with the corresponding value from the provided map or dictionary, if such a value exists.
    
""";
        var vs = new VStack(globalState);

        var templateDefiniiton = """
<VStack bgColor="#B0E2FF">
     ## Server Template example\n
     
     This allows a mixture of Markdown and Html, with added controls being accessible from the server code.
     
     <HStack padding="5px">
        <Box padding=5 shadow="md" borderWidth="1px" height="200px" width="400px" justifyItems="stretch" textAlign="start" bgColor='white'>
          <Heading fontSize="xl">{{FirstControlHeading}}</Heading>
          <Text mt=4>Current Performance Metrics</Text>
          <Text mt=4 xcontrol="responseTime">Response Time: 1.2s</Text>
          <Text xcontrol="uptime">System Uptime: 99.9%</Text>          
         </Box>
         <Box padding=5 shadow="md" borderWidth="1px" height="200px" width="200px" justifyItems="stretch" textAlign="start" bgColor='white'>
            <Heading fontSize="xl">Mini Chart</Heading>
            <Chart xcontrol="chart" variant='LineBasic' value=[1,4,3,5,2,3,1] sparkLines={true} height='50px' width='100%'/>
            <Button xcontrol="theButton">Click Me</Button>
            <PopupMessage xcontrol="popup" status='success' description='Button was pushed' />
         </Box>
     <HStack>
</VStack>
""";
        // we will replace all moustache {{FirstControlHeading}} in our template text with the value "Performance Metrics"
        var exampleTemplateMatch = Map.of("FirstControlHeading", "Performance Metrics");

        // given a template, append the controls to the defined parent, and return GenFromTemplate which provides
        // mappings to the newly created controls
        GenFromTemplate genTemplate = GenFromTemplate.appendFromTemplate(vs, globalState, templateDefiniiton, exampleTemplateMatch);
        // now we can access the controls that were created
        Text responseTime = genTemplate.getControl("responseTime");
        Text upTime = genTemplate.getControl("uptime");
        Chart chart = genTemplate.getControl("chart");
        Button theButton = genTemplate.getControl("theButton");
        PopupMessage popupMessage = genTemplate.getControl("popup");

        // add a click event to the button
        theButton.setOnClick(globalState,(e)-> {
            popupMessage.setValue(e.clientState(), UUID.randomUUID().toString());
        });

        // create a timer that changes the text of two of the Text fields
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                responseTime.setText(globalState, "Response Time: " + String.format("%.1f", (Math.random() * 100) / 10.0) + "s");
                upTime.setText(globalState, "System Uptime: " + String.format("%.1f", (90 + (Math.random() * 100) / 10)) + "%");
            }
        }, 1000, 2000);

        String javaDescription = """
```java
    var templateDefiniiton = ""\"
    <VStack bgColor="#B0E2FF">
     ## Server Template example\\n
    \s
     This allows a mixture of Markdown and Html, with added controls being accessible from the server code.
    \s
     <HStack padding="5px">
        <Box padding=5 shadow="md" borderWidth="1px" height="200px" width="400px" justifyItems="stretch" textAlign="start" bgColor='white'>
          <Heading fontSize="xl">{{FirstControlHeading}}</Heading>
          <Text mt=4>Current Performance Metrics</Text>
          <Text mt=4 xcontrol="responseTime">Response Time: 1.2s</Text>
          <Text xcontrol="uptime">System Uptime: 99.9%</Text>         \s
         </Box>
         <Box padding=5 shadow="md" borderWidth="1px" height="200px" width="200px" justifyItems="stretch" textAlign="start" bgColor='white'>
            <Heading fontSize="xl">Mini Chart</Heading>
            <Chart xcontrol="chart" variant='LineBasic' value=[1,4,3,5,2,3,1] sparkLines={true} height='50px' width='100%'/>
            <Button xcontrol="theButton">Click Me</Button>
            <PopupMessage xcontrol="popup" status='success' description='Button was pushed' />
         </Box>
     <HStack>
</VStack>
""\";
        // we will replace all moustache {{FirstControlHeading}} in our template text with the value "Performance Metrics"
        var exampleTemplateMatch = Map.of("FirstControlHeading", "Performance Metrics");

        // given a template, append the controls to the defined parent, and return GenFromTemplate which provides
        // mappings to the newly created controls
        GenFromTemplate genTemplate = GenFromTemplate.appendFromTemplate(vs, globalState, templateDefiniiton, exampleTemplateMatch);
        // now we can access the controls that were created
        Text responseTime = genTemplate.getControl("responseTime");
        Text upTime = genTemplate.getControl("uptime");
        Chart chart = genTemplate.getControl("chart");
        Button theButton = genTemplate.getControl("theButton");
        PopupMessage popupMessage = genTemplate.getControl("popup");

        // add a click event to the button
        theButton.setOnClick(globalState,(e)-> {
            popupMessage.setValue(e.clientState(), UUID.randomUUID().toString());
        });

        // create a timer that changes the text of two of the Text fields
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                responseTime.setText(globalState, "Response Time: " + String.format("%.1f", (Math.random() * 100) / 10.0) + "s");
                upTime.setText(globalState, "System Uptime: " + String.format("%.1f", (90 + (Math.random() * 100) / 10)) + "%");
            }
        }, 1000, 2000);
```
""";
        addExplanationPages(parent, globalState, "Server Side Templating", markdownDescription, vs, javaDescription);
    }

    /////////////////

    private void addThemeBasic (VStack parent, StateData state) {
        var vs = new VStack(state);

        String markdownDescription = """
## Themes Basics

KewlUI comes with inbuilt themes and the ability to create your own.  

Once a theme is selected, the following becomes available
    1. Color defaults - general palettes with colors such as primary, secondary etc
    2. Colors for components - bgColor and color defaults to be used for a component type
    3. Components defaults - default properties such as size, border radius etc
    4. Component variants - properties that are specific to a component variant, e.g button of variant 'myRoundedButton'


Adding/changing themes is done in two steps
    1. Adding/Editing a theme: using form.setThemeConfig to upload theme information
    2. Selecting a theme: using form.setTheme to select an active theme     

""";
        addExplanationPages(parent, state, "Theming - Basic Concepts", markdownDescription, vs, null);
    }

    private void addThemeColors (VStack parent, StateData state) {

        var vs = new VStack(state);

        String markdownDescription = """
## Theme Colors

A number of colors are available in a theme, and are selected by controls using "theme.colors.[[colorName]]".


#### Main settable colors

The primary colors that need to be set in a new theme are:

    - primary:  Choose the most vibrant or dominant color from the palette as the primary color. This color will be used for the most important interactive elements like primary action buttons, navbar and sidebar.
    - secondary: Select a color that complements the primary color yet is distinct enough to be used for secondary actions, such as secondary buttons, hover states, or less critical information. This could be a lighter or more subdued tone within the same color family or a contrasting color from the palette that works well with the primary color.
    - page:  Pick a neutral or very subtle color from the palette for the background. This should be a color that can recede to the back, allowing content and interactive elements to stand out. If the palette includes a light grey or a very soft blue, it could effectively serve as a calm, unobtrusive background that complements the other colors.
    - accent:  Use the most attention-grabbing color in the palette (that isn't the primary color) for accents such as notifications, alerts, and indicators. This color should be used sparingly to ensure it remains effective in drawing the user's eye to important information or status changes within the dashboard.
 
#### Recommended settable colors

The above colors are generally used for background colors. Once set, the system will look for text colors:

    - primaryText: Text color that complements the primary color.
    - secondaryText: Text color that complements the secondary color.
    - pageText: Text color that complements the page color.
    - accentText: Text color that complements the accent color.

Note that if these are not set, the system will attempt to calculate a complementary color based on the background color.  This can have mixed results.


#### Base, and interpolated colors

The color 'theme.colors.base' (defaults to value 'theme.colors.page').  This is used to give lighter or darker versions of a particular color using interpolation.  

For example, by choosing "theme.colors.primary_70", you will get a lighter version of the primary color. (70% primary, 30% base color).


### Additional Colors

The following base colors are also available (and may be overridden):

    Success, Error, Warning, Info, Gray

In a similar manner, Success_50 or Gray_50 will be lighter versions of Success/Gray (interpolated with base color).


### 'Other' block colors

'Other' colors are used as additional available colors, and are typically used by chart controls for line colors..

    otherA,otherB,otherC,otherD,otherE,otherF,otherG,otherH,otherI,otherJ,otherK,otherL,otherM,otherN,otherO

### Hover and lesser colors

    'hover' is set for the background color in hover states.

    rowOdd/rowEven: for odd/even rows in a table

""";
        String[] colors = new String[]{
                "primary", "secondary", "accent", "success", "error", "warning", "info", "gray"
        };

        // show the colors, and then show the interpolated colors
        for (String color : colors) {
            Divider.appendTo(vs, state);

            String c = (color.equals("gray")) ? "white" : ("theme.colors."+color+"Text");
            String bg = "theme.colors."+color;

            Markdown.appendTo(vs, state, "bgColor:**"+bg+"** , text:**"+c+"**")
                    .setBgColor(state, bg).setColor(state, c)
                    .setWidth(state, "500px").setHeight(state, "50px");

            AutoWrap wrap = AutoWrap.appendTo(vs, state);
            wrap.setPadding(state, "10px");
            for (int pct = 10; pct <=100; pct +=20) {

                Text.appendTo(wrap, state, color+"_"+pct)
                        .setBgColor(state, bg+"_"+pct).setColor(state, c)
                        .setWidth(state, "150px").setHeight(state, "50px");
            }
        }

        String java = """
```java
    String[] colors = new String[]{
            "primary", "secondary", "accent", "success", "error", "warning", "info", "gray"
    };

    // show the colors, and then show the interpolated colors
    for (String color : colors) {
        Divider.appendTo(vs, state);

        String c = (color.equals("gray")) ? "white" : ("theme.colors."+color+"Text");
        String bg = "theme.colors."+color;

        Markdown.appendTo(vs, state, "bgColor:**+"+bg+"** , text:**"+c+"**")
                .setBgColor(state, bg).setColor(state, c)
                .setWidth(state, "500px").setHeight(state, "50px");

        AutoWrap wrap = AutoWrap.appendTo(vs, state);
        wrap.setPadding(state, "10px");
        for (int pct = 10; pct <=100; pct +=20) {

            Text.appendTo(wrap, state, color+"_"+pct)
                    .setBgColor(state, bg+"_"+pct).setColor(state, c)
                    .setWidth(state, "150px").setHeight(state, "50px");
        }
    }
```""";
        addExplanationPages(parent, state, "Theming - Colors", markdownDescription, vs, java);
    }



    private void addThemeExamples (VStack parent, StateData state) {
        var vs = new VStack(state);

        String markdownDescription = """
## Themes: Setting

Every form has contains a ThemeState container which allows theming all children below it.

- VisualStyle class defining a theme, which includes colors and default properties for controls (including variants)
- form.setThemeConfig - Given a dictionary/map <String,VisualStyle>, mapping theme names to their definitions
- form.setTheme - used to choose a theme by name
    
### VisualStyle 

VisualStyle class holds colors and components sections.
<br/>
    1. Color defaults - general palettes with colors such as primary, secondary etc
    2. Colors for components - bgColor and color defaults to be used for a component type
    3. Components defaults - default properties such as size, border radius etc
    4. Component variants - properties that are specific to a component variant, e.g button of variant 'myRoundedButton'.
<br/>
Each of these can be set using the VisualStyle class.
\s
a) **Initialising with json** 

VisualStyle can either be:
- Created by constructor, initialise colors directly using function calls, or
- Use a json string explaining settings to create a prepopulated object. VisualStyle.fromJson(json).
<br/>

```java
    var customThemeJson = ""\"
    {\s
          "colors": {
                "page": "#FFFFFF",    "pageText": "#37474F",\s
                "primary": "#FBC02D", "primaryText": "263238",\s
                "secondary": "#FF9800", "secondaryText": "white",\s
                "accent": "#C2185B", "accentText": "white",
            \s
                "otherA": "#FF8360", "otherB": "#E8E288", "otherC": "#7DCE82", "otherD": "#51A3A3",
                "otherE": "#B2C326", "otherF": "#C879FF", "otherG": "#FF61A6", "otherH": "#FFAA4C",
                "otherI": "#55DDE0", "otherJ": "#F76B8A", "otherK": "#9B5DE5", "otherL": "#F7B32B",
                "otherM": "#FCCB69", "otherN": "#00BBF9", "otherO": "#FFD166",
               \s
                "Button": { "bgColor": "theme.colors.accent", "color": "theme.colors.accentText" }\s
            }
    }""\";
    VisualStyle myThemeStyle = VisualStyle.fromJson(customThemeJson); // load custom theme from json above, at least the colors.
```    
<br/>
b) **Initialising by color name**

VisualStyle also provides a method to set directly set colors
e.g.

```java 
    myThemeStyle.setPage("white").setPageText("#304040"); // set page bg color and page text color
```
<br/>
c) **Setting default colors for controls**

setComponentBgColor and setComponentColor can be used to set default colors for a control type.

```java                
    myThemeStyle.setComponentBgColor(Button.class, "theme.colors.accent");
```
<br/>
d) **Setting default properties for controls**

Properties can be set on a per control basis.  If a variant is not specified, it is assumed to change the default (non variant) control type.
<br/><br/>
First, define a control and put in the settings you wish to make a default, e.g:
<br/><br/>
        
```java
    Button b = new Button(globalState);
    b.setWidth(globalState, "300px").setBgColor(globalState, "theme.colors.secondary").setColor(globalState, "theme.colors.secondaryText");
    b.setIcon(globalState, "MdCall").setBorderRadius(globalState, "4px");
```
        
<br/>                
Note, it is not necessary to add this control to a parent, though it should be added to globalState.

We can then specify that the above properties should be applied whenever a Button is created with "variant" = "customButton";.
                
```java                
    myThemeStyle.setComponent(b, globalState, "customButton"); // create a new variant called customButton
```
<br>
The config can be accessed in child controls as follows:
 
```java                
    Button myButton = Button.appendTo(parent, globalState, "Do Something");
    myButton.setVariant(globalState, "customButton"); // will default to properties above
    myButton.setColor(globalState, "white"); // overrides variant defaults on this control
```

<br/>
e) **Setting a theme**                                   

Lets use the theme defined above:

```java
    Map<String,VisualStyle> themes = new HashMap<>();
    themes.put("customTheme", myThemeStyle); // add in a custom theme called "customTheme", we could add many themes...
    form.setThemeConfig(globalState, themes);
    
    form.setTheme("customTheme"); // select that the form should use 'customTheme'    
```
""";
        addExplanationPages(parent, state, "Theming - Setting,  Creating Control Variants", markdownDescription, vs, null);
    }

}

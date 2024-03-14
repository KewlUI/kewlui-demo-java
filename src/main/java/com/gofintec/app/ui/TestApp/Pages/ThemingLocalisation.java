package com.gofintec.app.ui.TestApp.Pages;

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
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;


/**
 * Examples of theming, localisation and templating within the system
 */
public class ThemingLocalisation extends BasePage {

    protected static final Logger Log = LogManager.getLogger(com.gofintec.app.ui.TestApp.Pages.ControlPage.class);

    public ThemingLocalisation() {
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

        addThemeExamples(vs, state);
        addLocalisationExamples(vs, state);

        String markdownDescription = """
### Other controls

More will be added in the future
""";
        Markdown.appendTo(vs,state,markdownDescription, Markdown.ControlsEnum.NONE);
    }

    private void addLocalisationExamples (VStack parent, StateData state) {

        var vs = new VStack(state);

        String markdownDescription = """
    ## Templating and Localisation 
    
    Our system includes a templating feature that supports localization, allowing dynamic text fields in controls to be automatically translated.
    It can also be used for "current user" information purposes.
    
    The templating system modifies a controls "Text" field, which will perform optional translation.
    
    The templating system uses moustache.  That is, "{{templateName}}" will perform a lookup in the client side templating system
    and replace it with the result. 
    
    For example, we could define a button that has Text="{{saveText}}, where saveText is replace with "Save" in English and "Speichern" in German.
            
    ### TemplateValues
    
    A TemplateValues container allows setting key/value lookups for all controls under it.
    This is included by default in every form.
    
    - TemplateValues.setValue(String key, Object value)
        - value can be either a key/value map with lookups, or a json containing a dictionary
        
    - TemplateValues.setTemplate(String key, String name)
       - if template name is set, we look through the map hierarchy given in setValue for the name
       - if found, we move all key/values under that name to the top level
       
    ### Form.TemplateValues
    
    Each form has a TemplateValues container automatically included.
    
    To use these, the form has the following :
        - form.setTemplateValues(StateData state, Object data)
            - Can be given a Map<String,Object> to supply keyvalues to set key/value lookups
            - Can be given a json with a dictionary of key/value lookups
    
        - form.setFormKeyValues(StateData state, Map<String,String> data)    
    
    - form.setTemplateName(StateData state, Map<String,String> data)
        - This can be used to set key/value lookups, e.g. "{{userName}}", would look up "userName" in the provided map.
        
    ### Example:
    
    In the example below, we will make a select to choose between two languages.
    One Button will have the static {{username}} in its text
    The other button will have {{local.save}} in its text
    
    By using the select, we call setTemplateName to choose whether lang.en or lang.de is used
    
    ```java
        String jsonTemplateConfig = '
            {
                "lang.en": {
                    "local.save": "Save"
                },
                "lang.de": {
                    "local.save": "Speichern"
                }   
            }
        ';
        String userName = "Bob";
    ``` 
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
        select.setOnChange(state, (eventName, clientContext, control, clientState, event)-> {
            var templateName = select.getValue(clientState);
            locale.setTemplate(clientState, templateName);
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
    select.setOnChange(state, (eventName, clientContext, control, clientState, event)-> {
        var templateName = select.getValue(clientState);
        locale.setTemplate(clientState, templateName);
    });

    Text.appendTo(container, state, "Following button Text is populated based on chosen lang template");
    Button.appendTo(container, state, "{{local.save}}");

    Text.appendTo(container, state, "Hi {{userName}}! Welcome to the system");       
    Button.appendTo(container, state, "UserName: {{userName}}");                
                                
""";

        addExplanationPages(parent, state, "Templating", markdownDescription, vs, java);
    }

    private void addThemeExamples (VStack parent, StateData state) {
        var vs = new VStack(state);

        String markdownDescription = """
## Themes 

Every form has contains a ThemeState container which allows theming all children below it.

### Setting the themes and which one to use

- form.setThemeConfig(globalState, json);
    - Used for uploading json of custom theme(s)
 
- form.setTheme(themeName);
    - Used for selecting a theme
    
### form.setThemeConfig

This accepts a json object that contains one or more theme configurations.

for example:

```java

    String json =
    "{
      "customTheme": {
        "theme": {
          "colors": {
            "pageBgColor": "#FFFFFF",
            "borderColor": "#FCCB69",
            "mainColor": "#2B8A3E", "altColor": "#F4F5F7",
            "cardBgColor": "#FEF9C3", "cardColor": "#2B8A3E",
            "buttonBgColor": "#FF8360", "buttonColor": "#FFFFFF",
            "rowOdd": "#FFFFFF", "rowEven": "#FEF9C3",
            "hover": "#FF8360",        
            "Chart": {
              "a": "#FF8360", "b": "#E8E288", "c": "#7DCE82", "d": "#51A3A3", "e": "#B2C326", "f": "#C879FF",
              "g": "#FF61A6", "h": "#FFAA4C", "i": "#55DDE0", "j": "#F76B8A", "k": "#9B5DE5", "l": "#F7B32B",
              "m": "#FCCB69", "n": "#00BBF9", "o": "#FFD166"
            }
          }
        }
      }
    }"
    form.setThemeConfig(globalState, json);
    
```    

### form.setTheme 

Selects which theme to use, can be the name of an in built them or a user supplied custom theme

For example, we could use the theme defined above:

```java
    form.setTheme("customTheme");
    
```

""";
        addExplanationPages(parent, state, "Theming", markdownDescription, vs, null);
    }


}

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
import com.gofintec.kewlui.controls.base.settings.*;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Control example page - shows a number of examples of controls, along with source code on how to achieve it
 *
 */
public class ControlPage extends BasePage {

    protected static final Logger Log = LogManager.getLogger(ControlPage.class);

    public ControlPage() {
        super(false);
    }

    public void AddControlOverview (VisualControl parent, StateData state)
    {
        VStack vs = VStack.appendTo(parent,state);

        String contolMarkup = """
# Controls

KewlUI offers a wide range of controls that can be used in your application.

- Avatar:  Display a user's profile picture
- Button: Button control that cause callbacks on the server side.
- Checkbox: A checkbox is a graphical control element that allows for multiple options to be selected or deselected by the user. It is often used to represent boolean values, such as on/off or true/false, in a user interface. 
- Editable:  The Editable control allows users to edit text in a GUI by clicking on it and typing directly into it.
- TextArea: The Textarea control allows users to edit multi-line text within a GUI by clicking on it and typing directly into it.
- Input: The Input control is a user interface element that allows users to input and edit text or numerical data.  It could be used to create forms for data collection or search bars for filtering information.
- FormInput:  Input that adds in helpers, Performs field validation  
- PinInput: The PinInput control is used to create a hidden and customizable input field for entering PIN codes.
- Radio: Radio control is a GUI element that allows users to select one option out of multiple options presented in a list.
- Slider:  A slider control is a user interface element that enables the selection of a value by sliding a thumb-like element along a horizontal or vertical track. 
- Select: The Select control is a form element that enables users to select an option from a pre-defined list or input values.
- Switch: The Switch control is a user interface element that allows users to toggle between two states.
- Badge: The badge control enables the display of a small label or indicator on a user interface to provide information or functionality. It allows for easy identification of specific items or actions and can provide context to users.
- Markdown: Component that allows rendering of text areas using markdown, including code sections
- Divider: The Divider displays a thin horizontal or vertical line that can be used to separate content.
- List: List control is a used for displaying a list of items.
- StatVanilla: Visual control for showing statistics in a system


If a control offers an Icon, this can be set to the icons name (if the icon pack has been loaded) 

""";
        Markdown.appendTo(vs,state,contolMarkup, Markdown.ControlsEnum.NONE);

        addAvatar(vs,state);
        addBadges(vs, state);
        addButton(vs,state);
        addCheckbox(vs,state);
        addDivider(vs, state);

        addEditable(vs, state);
        addEditableTextArea(vs,state);
        addIcon(vs,state);
        addIFrame(vs,state);
        addImage(vs,state);
        addInput(vs,state);
        addFormInput(vs,state);

        addMarkdown(vs, state);
        addPinInput(vs,state);
        addRadioGroup(vs, state);
        addSlider(vs, state);
        addSelect(vs, state);
        addStats(vs, state);
        addSwitch(vs, state);
        addTooltip(vs, state);



        String markdownDescription = """
### Other controls

Other controls have been implemented, and will be added to the control showcase in the future.
""";
        Markdown.appendTo(vs,state,markdownDescription, Markdown.ControlsEnum.NONE);
    }

    private void addEditable(VStack parent, StateData state) {
        String markdownDescription = """
### Editable

The Editable control allows for text to be edited inline with options for confirmation and customization.

Click on the edit button to edit the text - you can then also choose to accept or reject the changes

""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Example of an Editable control allowing inline text editing with confirmation");

        // Add Editable control
        var editable = Editable.appendTo(vs, state, "Script to run");
        editable.setValue(state, "#!/bin/bash\n# Example Bash script\necho Hello World!\n");
        editable.setPlaceholder(state, "Edit with change confirmation");
        editable.setEditIcon(state, "MdModeEdit");

        String java = """
```java
    Markdown.appendTo(vs, state, "Example of an Editable control allowing inline text editing with confirmation");

    // Add Editable control
    var editable = Editable.appendTo(vs, state, "Script to run");
    editable.setValue(state, "#!/bin/bash\\n# Example Bash script\\necho Hello World!\\n");
    editable.setPlaceholder(state, "Edit with change confirmation");
    editable.setEditIcon(state, "MdModeEdit");
```
""";

        addExplanationPages(parent, state, "Editable", markdownDescription, vs, java);
    }


    private void addImage(VStack parent, StateData state) {
        String markdownDescription = """
### Image

The Image control is used to display images in a UI, with support for various formats and customizations.

setSrc is used to set the image url

CrossOrigin: tells the browser to request cross-origin access when trying to download the image data.

fallbackSrc: Fallback image to show if main image fails

""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        // Add Image control - customized
        var image = Image.appendTo(vs, state);
        image.setSrc(state, "https://pixabay.com/photos/cosplay-fantasy-assassins-creed-7157780/");
        image.setWidth(state, "150px");
        image.setFallbackSrc(state, "https://images.pexels.com/photos/3770254/pexels-photo-3770254.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        String java = """
###Example Java code: \n\n
```java
    var image = Image.appendTo(vs, state);
    image.setSrc(state, "https://pixabay.com/photos/cosplay-fantasy-assassins-creed-7157780/");
    image.setWidth(state, "150px");
    image.setFallbackSrc(state, "https://images.pexels.com/photos/3770254/pexels-photo-3770254.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
```
""";

        addExplanationPages(parent, state, "Image", markdownDescription, vs, java);
    }




    private void addIcon(VStack parent, StateData state) {
        String markdownDescription = """
### Icon

The Icon control is used to display a graphical icon from various icon sets.

Once an Icon set has been registered with the framework, simply using its name will display the icon.

Some controls (Such as button) also have in built support for displaying icons 

setIcon, setIconBgColor, setIconColor, setIconSize are the primary functions for setting the icon

""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Displaying different types of icons with customizations");

        var al = Arrays.asList( 6, 8, 10, 12);
        for (var size : al) {
            var hs = HStack.appendTo(vs, state);
            var icon = Icon.appendTo(hs, state);
            icon.setIcon(state, "MdDescription");
            icon.setIconBgColor(state, "yellow.500");
            icon.setIconColor(state, "blue.500");
            icon.setIconSize(state, size);
            icon.setTooltip(state, "This is tooltip text on a Icon, size "+size);
            Text.appendTo(hs, state, "Icon Size: "+size);
        }

        String java = """
###Example Java code: \n\n
```java
    var al = Arrays.asList( 6, 8, 10, 12);
    for (var size : al) {
        var hs = HStack.appendTo(vs, state);
        var icon = Icon.appendTo(hs, state);
        icon.setIcon(state, "MdDescription");
        icon.setIconBgColor(state, "yellow.500");
        icon.setIconColor(state, "blue.500");
        icon.setIconSize(state, size);
        icon.setTooltip(state, "This is tooltip text on a Icon, size "+size);
        Text.appendTo(hs, state, "Icon Size: "+size);
    }

```
""";

        addExplanationPages(parent, state, "Icon", markdownDescription, vs, java);
    }


    private void addTooltip(VStack parent, StateData state) {
        String markdownDescription = """
### Tooltip

The Tooltip control provides additional information when hovering over an element.

Most controls implement tooltip as an attribute, e.g. add a tooltip to a button by calling setTooltip

""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Example of a Tooltip attached to a text element");

        // Add Tooltip control
        var textWithTooltip = Text.appendTo(vs, state, "Hover over me!");
        textWithTooltip.setTooltip(state, "This is the tooltip for Text");
        var button = Button.appendTo(vs, state, "Hover over me!");
        button.setTooltip(state, "This is tooltip text on a button");

        String java = """
###Example Java code: \n\n
```java
    // Add Tooltip control
    var textWithTooltip = Text.appendTo(vs, state, "Hover over me!");
    textWithTooltip.setTooltip(state, "This is the tooltip for Text");
    var button = Button.appendTo(vs, state, "Hover over me!");
    button.setTooltip(state, "This is tooltip text on a button");
```
""";

        addExplanationPages(parent, state, "Tooltip", markdownDescription, vs, java);
    }


    private void addAvatar(VStack parent, StateData state) {
        String markdownDescription = """
### Avatar

The Avatar control is used to display a user's profile picture or initials in a circular frame.
""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Displaying a user's avatar with default and customized settings");

        // Add Avatar control with default settings

        var al = Arrays.asList(SizeEnum.SM, SizeEnum.MD, SizeEnum.XL, SizeEnum.XL2);
        for (var size : al) {
            var hs = HStack.appendTo(vs, state);
            // Add Avatar control with custom settings
            var avatar = Avatar.appendTo(hs, state);
            avatar.setSrc(state, "https://cdn.pixabay.com/photo/2017/11/19/07/30/girl-2961959_960_720.jpg");
            avatar.setName(state, "User Name");
            avatar.setSize(state, size);
            avatar.setShowBorder(state, true);
            Text.appendTo(hs, state, "Size: " + size);
        }

        String java = """
###Example Java code: \n\n
```java
    var al = Arrays.asList(SizeEnum.SM, SizeEnum.MD, SizeEnum.XL, SizeEnum.XL2);
    for (var size : al) {
        var hs = HStack.appendTo(vs, state);
        // Add Avatar control with custom settings
        var avatar = Avatar.appendTo(hs, state);
        avatar.setSrc(state, "https://cdn.pixabay.com/photo/2017/11/19/07/30/girl-2961959_960_720.jpg");
        avatar.setName(state, "User Name");
        avatar.setSize(state, size);
        avatar.setShowBorder(state, true);
        Text.appendTo(hs, state, "Size: " + size);
    }
```
""";

        addExplanationPages(parent, state, "Avatar", markdownDescription, vs, java);
    }


    private void addIFrame(VStack parent, StateData state) {
        String markdownDescription = """
### IFrame

The IFrame control is used to embed external web content within the application.

You can set the src as a url or a path to a file. 

""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Embedding a YouTube video with full screen option");

        // Add IFrame control
        var iFrame = IFrame.appendTo(vs, state);
        iFrame.setSrc(state, "https://www.youtube.com/embed/dQw4w9WgXcQ");
        iFrame.setAllowFullScreen(state, true);
        iFrame.setTitle(state, "An IFrame");
        iFrame.setLoading(state, "lazy");
        iFrame.setWidth(state, "300px");

        String java = """
###Example Java code: \n\n
```java
    // Add IFrame control
    var iFrame = IFrame.appendTo(vs, state);
    iFrame.setSrc(state, "https://www.youtube.com/embed/dQw4w9WgXcQ");
    iFrame.setAllowFullScreen(state, true);
    iFrame.setTitle(state, "An IFrame");
    iFrame.setLoading(state, "lazy");
```
""";

        addExplanationPages(parent, state, "IFrame", markdownDescription, vs, java);
    }


    private void addStats(VStack parent, StateData state) {
        String markdownDescription = """
### StatsCard

The Stats control is used to display system statistics in a visually appealing format.
""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Displaying system message rate with percentage difference and icon customization");

        // Add StatsCard control
        var stats = StatsCard.appendTo(vs, state, "System Message Rate");
        stats.setDifference(state, 1.0);
        stats.setDifferenceUnit(state, "%");
        stats.setValue(state,"134k");
        stats.setIcon(state,"MdSpeed");
        stats.setIconColor(state,"white");
        stats.setIconBgColor(state,"teal.300");
        stats.setIconSize(state,12);
        stats.setWidth(state,"300px");

        String java = """
###Example Java code: \n\n
```java
    // Add StatsVanilla control
    var stats = StatsCard.appendTo(vs, state, "System Message Rate");
    stats.setDifference(state, 1.0);
    stats.setDifferenceUnit(state, "%");
    stats.setValue(state,"134k");
    stats.setIcon(state,"MdSpeed");
    stats.setIconColor(state,"white");
    stats.setIconBgColor(state,"teal.300");
    stats.setIconSize(state,12);
    stats.setWidth(state,"300px");
```
""";
        addExplanationPages(parent, state, "StatsCard", markdownDescription, vs, java);
    }



    private void addDivider(VStack parent, StateData state) {
        String markdownDescription = """
### Divider

Divider is either a horizontal or vertical bar used to divide sections of the page 
""";
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Some Text followed by divider");
        Divider.appendTo(vs, state);

        var hs = HStack.appendTo(vs, state);
        Markdown.appendTo(hs, state, "text1");
        Divider.appendTo(hs, state).setOrientation(state, Divider.OrientationEnum.VERTICAL).setHeight(state, "50px");
        Markdown.appendTo(hs, state, "horizontal");
        Divider.appendTo(hs, state).setOrientation(state, Divider.OrientationEnum.VERTICAL).setHeight(state, "50px");;
        Markdown.appendTo(hs, state, "text3");

        Divider.appendTo(vs, state);


        String java = """
### Example Java code: \n\n
```java
    Markdown.appendTo(vs, state, "Some Text followed by divider");
    Divider.appendTo(vs, state);
    
    var hs = HStack.appendTo(vs, state);
    Markdown.appendTo(hs, state, "text1");
    Divider.appendTo(hs, state).setOrientation(state, Divider.OrientationEnum.VERTICAL).setHeight(state, "50px").setWidth(state, "50px");
    Markdown.appendTo(hs, state, "horizontal");
    Divider.appendTo(hs, state).setOrientation(state, Divider.OrientationEnum.VERTICAL).setHeight(state, "50px");;
    Markdown.appendTo(hs, state, "text3");
    
    Divider.appendTo(vs, state);
    Markdown.appendTo(vs, state, "Also supports dashed divider");
    Divider.appendTo(vs, state).setVariant(state, Divider.VariantEnum.DASHED);
```
""";

        addExplanationPages(parent, state, "Divider", markdownDescription, vs, java);
    }

    private void addMarkdown(VStack parent, StateData state) {
        String markdownDescription = """
    ### Markdown

    The Markdown control is used to render text written in Markdown syntax into formatted HTML. 
    
    This control can display headings, paragraphs, lists, blockquotes, tables, and code snippets.
    
    Note: You can select security level of the markdown box.  e.g. if you select 'All', then html tags will be rendered,
    otherwise they will be escaped. 
    
    - Markdown.ControlsEnum.ALL: Allow all HTML tags.
    - Markdown.ControlsEnum.NONE: sanitize all HTML tags.
    
    """;

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Markdown TextArea with live preview:");
        var syncControls = FormContext.appendTo(vs, state); // allows both controls below to sync under the name 'Sliders'

        var hstack = HStack.appendTo(syncControls, state, TextAlignEnum.LEFT);
        hstack.setWidth(state,"90%").setHeight(state,"100%");

        var box = VStack.appendTo(hstack, state);
        box.setWidth(state,"45%").setHeight(state,"100%");

        Text.appendTo(box, state, "Any markdown below will be auto-rendered into matching control").setHeight(state,"50px");
        var ta = TextArea.appendTo(box, state);
        ta.setWidth(state,"100%").setHeight(state,"600px");
        ta.setName(state,"markdown");

        Spacer.appendTo(hstack, state);

        var markdown = Markdown.appendTo(hstack, state, Markdown.ControlsEnum.ALL);
        markdown.setWidth(state,"45%").setHeight(state,"100%");
        markdown.setName(state,"markdown");

        String multilineString = """
                # Title (Level 1 Heading)
                This is a paragraph. You just write your content directly. Markdown will automatically wrap your paragraphs with the correct HTML. If you want to create a new paragraph, just insert a blank line.
                ## Subtitle (Level 2 Heading)
                ### Sub-subtitle (Level 3 Heading)
                Here's how to make things **bold**. You can also make things *italic* or ~~strike them through~~.
                Now let's make a list:
                - Item 1
                - Item 2
                    - Subitem 2.1
                    - Subitem 2.2
                - Item 3
                You can also make numbered lists:
                1. First item
                2. Second item
                3. Third item
                    
                It's also possible to create a table:
                    
                | Column 1 | Column 2 | Column 3 |
                | -------- | -------- | -------- |
                | Cell 1   | Cell 2   | Cell 3   |
                | Cell 4   | Cell 5   | Cell 6   |
                    
                If you want to add some code, you can use backticks:
                    
                `This is inline code`
                    
                For blocks of code, you use triple backticks and specify the language:

                ```python
                def hello_world():
                    print("Hello, world!")
                ```
                <br>

                               
                This MarkDown control has been set to **ControlsEnum.ALL**, thus we can add in HTML. \n
                As this has the potential for being unsafe (e.g. injection attacks), it should only be used when you are sure that the html is safe - Otherwise use ControlsEnum.NONE.
                               
                <h1>This is embedded HTML</h1>

                <buttonstyle="background-color: blue; color: white;">Click Me</button>
                                
                """;

        ta.setValue(state, multilineString);

        String java = """
                    ###Example Java code: \n\n
```java

    // here use a FormContext to sync the controls (both have same name) 
    var syncControls = FormContext.appendTo(vs, state); // allows both controls below to sync under the name 'Sliders'

    var hstack = HStack.appendTo(syncControls, state, TextAlignEnum.LEFT);
    hstack.setWidth(state,"90%").setHeight(state,"100%");

    var box = VStack.appendTo(hstack, state);
    box.setWidth(state,"45%").setHeight(state,"100%");

    Text.appendTo(box, state, "Any markdown below will be auto-rendered into matching control").setHeight(state,"50px");
    var ta = TextArea.appendTo(box, state);
    ta.setWidth(state,"100%").setHeight(state,"600px");
    ta.setName(state, "markdown"); 
    
    var markdown = Markdown.appendTo(hstack, state, Markdown.ControlsEnum.ALL);
    markdown.setWidth(state,"45%").setHeight(state,"100%");
    markdown.setName(state,"markdown");    
```
                    """;

        addExplanationPages(parent, state, "Markdown", markdownDescription, vs, java);
    }


    private void addBadges(VStack parent, StateData state) {
        String markdownDescription = """
### Badges

The Badges control is used to create small count and labeling components. 
""";
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Default Badge");
        Badge.appendTo(vs, state, "Default");

        Markdown.appendTo(vs, state, "Success Badge - Green");
        Badge.appendTo(vs, state, "Success", ColorSchemeEnum.GREEN);

        Markdown.appendTo(vs, state, "Error Badge - Red");
        Badge.appendTo(vs, state, "Error", ColorSchemeEnum.RED);

        Markdown.appendTo(vs, state, "New Message Badge - Teal");
        Badge.appendTo(vs, state, "New Message", ColorSchemeEnum.TEAL);

        Markdown.appendTo(vs, state, "Timeout Badge - Purple");
        Badge.appendTo(vs, state, "Timeout", ColorSchemeEnum.PURPLE);

        Markdown.appendTo(vs, state, "Outline Badge - Green");
        Badge.appendTo(vs, state, "Outline", ColorSchemeEnum.GREEN, Badge.VariantEnum.OUTLINE);

        Markdown.appendTo(vs, state, "Solid Badge - Green");
        Badge.appendTo(vs, state, "Solid", ColorSchemeEnum.GREEN, Badge.VariantEnum.SOLID);

        Markdown.appendTo(vs, state, "Subtle Badge - Green");
        Badge.appendTo(vs, state, "Subtle", ColorSchemeEnum.GREEN, Badge.VariantEnum.SUBTLE);

        String java = """
### Example Java code: \n\n
```java
    Markdown.appendTo(vs, state, "Default Badge");
    Badge.appendTo(vs, state, "Default");

    Markdown.appendTo(vs, state, "Success Badge - Green");
    Badge.appendTo(vs, state, "Success", ColorSchemeEnum.GREEN);

    Markdown.appendTo(vs, state, "Error Badge - Red");
    Badge.appendTo(vs, state, "Error", ColorSchemeEnum.RED);

    Markdown.appendTo(vs, state, "New Message Badge - Teal");
    Badge.appendTo(vs, state, "New Message", ColorSchemeEnum.TEAL);

    Markdown.appendTo(vs, state, "Timeout Badge - Purple");
    Badge.appendTo(vs, state, "Timeout", ColorSchemeEnum.PURPLE);

    Markdown.appendTo(vs, state, "Outline Badge - Green");
    Badge.appendTo(vs, state, "Outline", ColorSchemeEnum.GREEN, Badge.VariantEnum.OUTLINE);

    Markdown.appendTo(vs, state, "Solid Badge - Green");
    Badge.appendTo(vs, state, "Solid", ColorSchemeEnum.GREEN, Badge.VariantEnum.SOLID);

    Markdown.appendTo(vs, state, "Subtle Badge - Green");
    Badge.appendTo(vs, state, "Subtle", ColorSchemeEnum.GREEN, Badge.VariantEnum.SUBTLE);
```
""";

        addExplanationPages(parent, state, "Badge", markdownDescription, vs, java);
    }


    protected void addSwitch(VStack parent, StateData state) {
        String markdownDescription = """
### Switch

The Switch control is used to toggle between two states, typically representing an on/off or true/false scenario.
""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Simple Toggle Switch in Orange Color");
        var toggleSwitch = Switch.appendTo(vs, state, "Toggle Me", ColorSchemeEnum.ORANGE);
        toggleSwitch.setValue(state, true);
        Divider.appendTo(vs, state);

        Markdown.appendTo(vs, state, "Toggle Switch in Blue Color, large");
        var text = Text.appendTo(vs, state, "Toggle Me");
        var toggleSwitch2 = Switch.appendTo(vs, state, "Toggle Me", ColorSchemeEnum.BLUE);
        toggleSwitch2.setSize(state, SizeEnum.LG).setValue(state, true);
        toggleSwitch2.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            var val = toggleSwitch2.getValue(clientState);
            text.setText(clientState, "Value: "+val); // remember update text not value here
        });
        Divider.appendTo(vs, state);
        Markdown.appendTo(vs, state, "disabled");
        toggleSwitch = Switch.appendTo(vs, state, "Toggle Me", ColorSchemeEnum.ORANGE);
        toggleSwitch.setDisabled(state, true);

        Divider.appendTo(vs, state);
        Markdown.appendTo(vs, state, "readonly");
        toggleSwitch = Switch.appendTo(vs, state, "Toggle Me", ColorSchemeEnum.GREEN);
        toggleSwitch.setValue(state, true).setIsReadOnly(state, true);

        String java = """
### Example Java code: \n\n
```java

        Markdown.appendTo(vs, state, "Simple Toggle Switch in Orange Color");
        var toggleSwitch = Switch.appendTo(vs, state, "Toggle Me", ColorSchemeEnum.ORANGE);
        toggleSwitch.setValue(state, false);

        Markdown.appendTo(vs, state, "Toggle Switch in Blue Color, large");
        var text = Text.appendTo(vs, state, "Toggle Me");
        var toggleSwitch2 = Switch.appendTo(vs, state, "Toggle Me", ColorSchemeEnum.BLUE);
        toggleSwitch2.setSize(state, SizeEnum.LG).setValue(state, true);
        toggleSwitch2.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            var val = toggleSwitch2.getValue(clientState);
            text.setText(clientState, "Value: "+val); // remember update text not value here
        });

        Markdown.appendTo(vs, state, "disabled");
        toggleSwitch = Switch.appendTo(vs, state, "Toggle Me", ColorSchemeEnum.ORANGE);
        toggleSwitch.setDisabled(state, true);

        Markdown.appendTo(vs, state, "readonly");
        toggleSwitch = Switch.appendTo(vs, state, "Toggle Me", ColorSchemeEnum.GREEN);
        toggleSwitch.setValue(state, true).setIsReadOnly(state, true);
```
""";

        addExplanationPages(parent, state, "Switch", markdownDescription, vs, java);
    }




    private void addSelect(VStack parent, StateData state) {
        String markdownDescription = """
### Select

The Select control allows users to choose from a list of options. 

Options for selection may be added in 2 ways
- A comma seperated string passing in via setText (or constructor)
- A list of options passed in via setOptions on Select control

Use setValue to set the selected option

""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Style 1: Comma separated list of options with default value 'Option 3'");
        // Style 1, comma separated list of options
        var select = Select.appendTo(vs, state, "Option 1,Option 2,Option 3,Option 4", DefaultValue.set("Option 3"), ColorSchemeEnum.GREEN);
        select.setWidth(state, "200px");

        Markdown.appendTo(vs, state, "Style 2: List of options with 'Dolphin' as the selected value");
        // Style 2, give a list of options
        select = Select.appendTo(vs, state, DefaultValue.set("Option 1"), ColorSchemeEnum.GREEN);
        select.setOptions(state, Arrays.asList("Duck", "Chicken", "Dolphin", "Godzilla"));
        select.setValue(state, "Dolphin");
        select.setWidth(state, "200px");

        Markdown.appendTo(vs, state, "Fancier looks: Select with custom icon and variant=filled ");
        // Fancier looks
        select = Select.appendTo(vs, state, "Norway,Sweden,Denmark,Hades", ColorSchemeEnum.GREEN);
        select.setIcon(state, "MdPlayForWork"); // will be used as opening icon
        select.setVariant(state, Select.VariantEnum.FILLED);
        select.setWidth(state, "200px");
        //select.setSize(state, SizeEnum.LG);

        String java = """
###Example Java code: \n\n
""";

        addExplanationPages(parent, state, "Select", markdownDescription, vs, java);
    }


    private void addSlider(VStack parent, StateData state) {
        String markdownDescription = """
### Slider

The Slider control is used to create a slider input for user interactions. 

Each slider has a minimum, maximum, and step value.  You can set the Icon for the Slider, as well as the icons color.

In this example, we have placed 3 controls (2 sliders and a NumberInput) inside a FormContext.  
As all controls have the same name within that Context, changing one control on the client will change all controls.
[The variable name will be available within the context] 

""";

        var vs = new VStack(state);
        var text =  Text.appendTo(vs, state, "FormContext state: ");
        var hs = HStack.appendTo(vs, state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        var formContext = FormContext.appendTo(hs, state);
        formContext.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            text.setText(clientState,  "FormContext state: " + formContext.getValue(clientState));
        }); // set the text field to equal the FormContext value on change (the var name is Sliders)

        var box = VStack.appendTo(formContext, state);

        Markdown.appendTo(box, state, "Horizontal Slider with predefined values and custom icon");
        var sliderInput = Slider.appendTo(box, state, DefaultValue.set(0));
        sliderInput.setWidth(state, "200px");
        sliderInput.setOrientation(state, Slider.OrientationEnum.HORIZONTAL);
        sliderInput.setMin(state, 0.0);
        sliderInput.setMax(state, 1.0);
        sliderInput.setStep(state, 0.1);
        sliderInput.setName(state, "Sliders");
        sliderInput.setIcon(state, "MdGraphicEq");
        sliderInput.setIconSize(state, 6);
        sliderInput.setIconColor(state, "orange.500");
        sliderInput.setMarks(state, Arrays.asList("0", "0.2", "0.5", "0.8", "1"));
        sliderInput.setTooltip(state, "Value is ${value}");

        box = VStack.appendTo(formContext, state);

        Markdown.appendTo(box, state, "Vertical Slider with custom icon");
        sliderInput = Slider.appendTo(box, state, DefaultValue.set(0));
        sliderInput.setHeight(state, "200px");
        sliderInput.setOrientation(state, Slider.OrientationEnum.VERTICAL);
        sliderInput.setMin(state, 0.0);
        sliderInput.setMax(state, 1.0);
        sliderInput.setStep(state, 0.1);
        sliderInput.setName(state, "Sliders");
        sliderInput.setIcon(state, "MdTagFaces");
        sliderInput.setIconSize(state, 3);

        box = VStack.appendTo(formContext, state);

        Markdown.appendTo(box, state, "Number Input synced with Sliders");
        var numberInput = NumberInput.appendTo(box, state);
        numberInput.setMin(state, 0.0);
        numberInput.setMax(state, 1.0);
        numberInput.setStep(state, 0.1);
        numberInput.setName(state, "Sliders");
        numberInput.setValue(state, 0.1);

        String java = """
### Example Java code: \n\n
```java
      var formContext = FormContext.appendTo(hs, state);
        formContext.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            text.setText(clientState,  "FormContext state: " + formContext.getValue(clientState));
        }); // set the text field to equal the FormContext value on change (the var name is Sliders)

        var box = VStack.appendTo(formContext, state);

        Markdown.appendTo(box, state, "Horizontal Slider with predefined values and custom icon");
        var sliderInput = Slider.appendTo(box, state, DefaultValue.set(0));
        sliderInput.setWidth(state, "200px");
        sliderInput.setOrientation(state, Slider.OrientationEnum.HORIZONTAL);
        sliderInput.setMin(state, 0.0);
        sliderInput.setMax(state, 1.0);
        sliderInput.setStep(state, 0.1);
        sliderInput.setName(state, "Sliders");
        sliderInput.setIcon(state, "MdGraphicEq");
        sliderInput.setIconSize(state, 6);
        sliderInput.setIconColor(state, "orange.500");
        sliderInput.setMarks(state, Arrays.asList("0", "0.2", "0.5", "0.8", "1"));
        sliderInput.setTooltip(state, "Value is ${value}");

        box = VStack.appendTo(formContext, state);

        Markdown.appendTo(box, state, "Vertical Slider with custom icon");
        sliderInput = Slider.appendTo(box, state, DefaultValue.set(0));
        sliderInput.setHeight(state, "200px");
        sliderInput.setOrientation(state, Slider.OrientationEnum.VERTICAL);
        sliderInput.setMin(state, 0.0);
        sliderInput.setMax(state, 1.0);
        sliderInput.setStep(state, 0.1);
        sliderInput.setName(state, "Sliders");
        sliderInput.setIcon(state, "MdTagFaces");
        sliderInput.setIconSize(state, 3);

        box = VStack.appendTo(formContext, state);

        Markdown.appendTo(box, state, "Number Input synced with Sliders");
        var numberInput = NumberInput.appendTo(box, state);
        numberInput.setMin(state, 0.0);
        numberInput.setMax(state, 1.0);
        numberInput.setStep(state, 0.1);
        numberInput.setName(state, "Sliders");
        numberInput.setValue(state, 0.1);
```
""";

        addExplanationPages(parent, state, "Slider", markdownDescription, vs, java);
    }


    private void addRadioGroup(VStack parent, StateData state) {
        String markdownDescription = """
### RadioGroup/ Radio

This allows the creation of radio button controls.  Radio buttons are placed in a group, with only one button 
being selectable in that group at a time.

Two ways to use RadioGroup:
1. Create a RadioGroup with manually added Radio buttons (ie create your own Radio controls and add to RadioGroup)
2. Create a RadioGroup with automatically added radio options (takes a comma seperated list of strings) 

                """;
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);
        var header = "RadioGroup status: ";
        var text = Text.appendTo(vs, state, "RadioGroup status: ");

        Markdown.appendTo(vs, state, "RadioGroup with manually added Radio buttons for programming languages");
        final var cbg = RadioGroup.appendTo(vs, state, DefaultValue.set("Java"), ColorSchemeEnum.MESSENGR);

        cbg.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            // Note: we need to setText (not value) on a text field.
            // We must read from and set to the clientState, not the global state
            text.setText(clientState, header + cbg.getValue(clientState)+"!");
        });

        var cb = Radio.appendTo(cbg, state, "I use Java", DefaultValue.set("Java"), ColorSchemeEnum.RED);
        cb.setName(state, "language");

        cb = Radio.appendTo(cbg, state, "I use Python", DefaultValue.set("Python"), ColorSchemeEnum.BLUE);
        cb.setName(state, "language");

        cb = Radio.appendTo(cbg, state, "I use C++", DefaultValue.set("C++"), ColorSchemeEnum.YELLOW);
        cb.setName(state, "language");

        Markdown.appendTo(vs, state, "RadioGroup with automatically added options for professions");
        var cbg2 = RadioGroup.appendTo(vs, state, "Doctor,Nurse,Other", DefaultValue.set("Other"), ColorSchemeEnum.RED);
        cbg2.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            text.setText(clientState, header + cbg2.getValue(clientState)+"!");
        });

        String java = """
```java
 var header = "RadioGroup status: ";
        var text = Text.appendTo(vs, state, "RadioGroup status: ");

        Markdown.appendTo(vs, state, "RadioGroup with manually added Radio buttons for programming languages");
        final var cbg = RadioGroup.appendTo(vs, state, DefaultValue.set("Java"), ColorSchemeEnum.MESSENGR);

        cbg.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            // Note: we need to setText (not value) on a text field.
            // We must read from and set to the clientState, not the global state
            text.setText(clientState, header + cbg.getValue(clientState)+"!");
        });

        var cb = Radio.appendTo(cbg, state, "I use Java", DefaultValue.set("Java"), ColorSchemeEnum.RED);
        cb.setName(state, "language");

        cb = Radio.appendTo(cbg, state, "I use Python", DefaultValue.set("Python"), ColorSchemeEnum.BLUE);
        cb.setName(state, "language");

        cb = Radio.appendTo(cbg, state, "I use C++", DefaultValue.set("C++"), ColorSchemeEnum.YELLOW);
        cb.setName(state, "language");

        Markdown.appendTo(vs, state, "RadioGroup with automatically added options for professions");
        var cbg2 = RadioGroup.appendTo(vs, state, "Doctor,Nurse,Other", DefaultValue.set("Other"), ColorSchemeEnum.RED);
        cbg2.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            text.setText(clientState, header + cbg2.getValue(clientState)+"!");
        });
```""";
        addExplanationPages(parent, state, "RadioGroup", markdownDescription, vs, java);
    }


        private void addPinInput (VStack parent, StateData state) {
        String markdownDescription = """
### PinInput

The PinInput control is used to create a hidden and customizable input field for entering PIN codes. 
""";
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Simple 4 value pin input (already filled in), not masked, numbers only");
        // this is best for One time passpwords/pin
        var input = PinInput.appendTo(vs, state, DefaultValue.set("1234"));
        input.setNumFields(state, 4); // make this a pin input

        Markdown.appendTo(vs, state, "Simple 4 value pin input, masked (1 character set), numbers only");
        input =  PinInput.appendTo(vs,state, DefaultValue.set("1"));
        input.setNumFields(state, 4); // make this a pin input
        input.setMask(state, true);  // hidden

        Markdown.appendTo(vs, state, "Simple 12 value pin input (ALPHANUMERIC), not masked");
        var text = PinInput.appendTo(vs,state,ColorSchemeEnum.BLUE, SizeEnum.LG);
        text.setNumFields(state, 12);
        text.setType(state, PinInput.TypeEnum.ALPHANUMERIC); // allow chars

        Markdown.appendTo(vs, state, "4 Digit Pin, masked, with Smiley set as the empty character");
        input = PinInput.appendTo(vs,state,ColorSchemeEnum.GREEN );
        input.setNumFields(state, 4); // make this a pin input
        input.setPlaceholder(state, "😊");
        input.setMask(state, true);

        String java = """
```java
   var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs, state, "Simple 4 value pin input (already filled in), not masked, numbers only");
        // this is best for One time passpwords/pin
        var input = PinInput.appendTo(vs, state, DefaultValue.set("1234"));
        input.setNumFields(state, 4); // make this a pin input

        Markdown.appendTo(vs, state, "Simple 4 value pin input, masked (1 character set), numbers only");
        input =  PinInput.appendTo(vs,state, DefaultValue.set("1"));
        input.setNumFields(state, 4); // make this a pin input
        input.setMask(state, true);  // hidden

        Markdown.appendTo(vs, state, "Simple 12 value pin input (ALPHANUMERIC), not masked");
        var text = PinInput.appendTo(vs,state,ColorSchemeEnum.BLUE, SizeEnum.LG);
        text.setNumFields(state, 12);
        text.setType(state, PinInput.TypeEnum.ALPHANUMERIC); // allow chars

        Markdown.appendTo(vs, state, "4 Digit Pin, masked, with Smiley set as the empty character");
        input = PinInput.appendTo(vs,state,ColorSchemeEnum.GREEN );
        input.setNumFields(state, 4); // make this a pin input
        input.setPlaceholder(state, "😊");
        input.setMask(state, true);
``` 
""";

        addExplanationPages(parent, state,"PinInput", markdownDescription, vs, java);
    }

    private void addFormInput (VStack parent, StateData state) {
        String markdownDescription = """
### FormInput

The is a component that provides a wrapper around form controls such as input, textarea, and select. 

It provides:

- Text around the input control
- Optional input validation
- Helper text outside of the input control

You can add an input control inside the FormInput, if so this will be used.

If no control is added inside it, then it will default to an inputbox.

""";
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);
        vs.setWidth(state, "75%");
        vs.setTextAlign(state, TextAlignEnum.LEFT);

        var box2 = VStack.appendTo(Box.appendTo(vs, state).setBorderRadius(state,"3px solid"), state);
        Markdown.appendTo(box2, state, "### FormInput Examples\n\n");


        {
            Divider.appendTo(box2, state);
            Text.appendTo(box2, state, "Simple FormInput - FormInput is providing the text box");
            var box = Box.appendTo(box2, state);
            box.setBorder(state, "1px solid").setBorderRadius(state, "15px").setPadding(state, "10px");
            var formInput = FormInput.appendTo(box, state, "Email");
            // not adding an inputField, so one will be auto generated - we just work with formControl
            formInput.setValue(state, "a@b.com");
            formInput.setOnChange(state, (eventName, clientContext, control, clientState, event)->{ Log.info("changed:" + formInput.getValue(clientState)); });

        }
        {
            Divider.appendTo(box2, state);
            Text.appendTo(box2, state, "Create a simple FormInput - with input field for email - show helper text, namePosition==NORTH");
            var box = Box.appendTo(box2, state);
            box.setBorder(state, "1px solid").setBorderRadius(state, "15px").setPadding(state, "10px");

            var formInput = FormInput.appendTo(box, state, "Email");
            formInput.setNamePosition(state, FormInput.NamePositionEnum.NORTH);
            formInput.setHelperText(state, "setNamePosition->NORTH");
            formInput.setHelperText(state, "Helper text - e.g. We will never share your email");
        }
        {
            Divider.appendTo(box2, state);
            Text.appendTo(box2, state, "FormInput with a name box, name is mandatory (non-empty), if not given it will show an error.");

            var box = Box.appendTo(box2, state);
            box.setBorder(state, "1px solid").setBorderRadius(state, "15px").setPadding(state, "10px");

            var formInput = FormInput.appendTo(box, state, "Name");
            formInput.setHelperText(state, "This is always validating - text value passes validation"); // visible when ok
            formInput.setErrorText(state, "This is always validating - currently error"); // shown when invalid
            formInput.setValidationRegex(state, "^\\s*\\S"); // not empty
            formInput.setValidateFocusLeave(state, false); // always show error
        }
        {
            Divider.appendTo(box2, state);
            Text.appendTo(box2, state, "Another email box, however we only validate the email when we lose focus");
            Text.appendTo(box2, state, "as part of this example, we will also use a list of regexes, one allowing email, one allowing 'none' in any casing");
            Text.appendTo(box2, state, "We also pass an explicit Input field into the FormInput container");

            var box = Box.appendTo(box2, state);
            box.setBorder(state, "1px solid").setBorderRadius(state, "15px").setPadding(state, "10px");

            var formInput = FormInput.appendTo(box, state, "Email:");
            formInput.setHelperText(state, "This validates on focus loss"); // visible when ok
            formInput.setErrorText(state, "Incorrect, should be a valid email, or the word none."); // shown when invalid
            formInput.setValidationRegex(state, Arrays.asList("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", "none"));
            formInput.setValidateFocusLeave(state, true); // always show error

            var inputField = Input.appendTo(formInput, state);
            inputField.setBgColor(state, "#99ecfc");
        }


        String java = """
```java
    {
        Text.appendTo(box2, state, "Simple FormInput - FormInput is providing the text box");
        var box = Box.appendTo(box2, state);
        box.setBorder(state, "1px solid").setBorderRadius(state, "15px").setPadding(state, "10px");
        var formInput = FormInput.appendTo(box, state, "Email");
        // not adding an inputField, so one will be auto generated - we just work with formControl
        formInput.setValue(state, "a@b.com");
        formInput.setOnChange(state, (eventName, clientContext, control, clientState, event)->{ Log.info("changed:" + formInput.getValue(clientState)); });

    }
    {
        Text.appendTo(box2, state, "Create a simple FormInput - with input field for email - show helper text, namePosition==west");
        var box = Box.appendTo(box2, state);
        box.setBorder(state, "1px solid").setBorderRadius(state, "15px").setPadding(state, "10px");

        var formInput = FormInput.appendTo(box, state, "Email");
        formInput.setNamePosition(state, FormInput.NamePositionEnum.NORTH);
        formInput.setHelperText(state, "setNamePosition->NORTH");
        formInput.setHelperText(state, "Helper text - e.g. We will never share your email");
    }
    {
        Text.appendTo(box2, state, "FormInput with a name box, name is mandatory (non-empty), if not given it will show an error.");

        var box = Box.appendTo(box2, state);
        box.setBorder(state, "1px solid").setBorderRadius(state, "15px").setPadding(state, "10px");

        var formInput = FormInput.appendTo(box, state, "Name");
        formInput.setHelperText(state, "This is always validating - text value passes validation"); // visible when ok
        formInput.setErrorText(state, "This is always validating - currently error"); // shown when invalid
        formInput.setValidationRegex(state, "^\\\\s*\\\\S"); // not empty
        formInput.setValidateFocusLeave(state, false); // always show error
    }
    {
        Text.appendTo(box2, state, "Another email box, however we only validate the email when we lose focus");
        Text.appendTo(box2, state, "as part of this example, we will also use a list of regexes, one allowing email, one allowing 'none' in any casing");
        Text.appendTo(box2, state, "We also pass an explicit Input field into the FormInput container");

        var box = Box.appendTo(box2, state);
        box.setBorder(state, "1px solid").setBorderRadius(state, "15px").setPadding(state, "10px");

        var formInput = FormInput.appendTo(box, state, "Email:");
        formInput.setHelperText(state, "This validates on focus loss"); // visible when ok
        formInput.setErrorText(state, "Incorrect, should be a valid email, or the word none."); // shown when invalid
        formInput.setValidationRegex(state, Arrays.asList("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$", "none"));
        formInput.setValidateFocusLeave(state, true); // always show error

        var inputField = Input.appendTo(formInput, state);
        inputField.setBgColor(state, "#99ecfc");
    }
```
                """;
        addExplanationPages(parent, state,"FormInput", markdownDescription, vs, java);
    }

    private void addInput (VStack parent, StateData state) {
        String markdownDescription = """
### Input / NumberInput / InputGroup

- Input: This provides a standard input text box, useful for entering in fields, e.g. firstname etc
- NumberInput: Input which allows only numbers, and will only accept numbers within range
- InputGroup:  Used to create an input with configurable beginning and ending hints

""";
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);
        vs.setTextAlign(state, TextAlignEnum.LEFT);
        Text.appendTo(vs, state, "Input:");

        var input = Input.appendTo(vs, state, "This is a simple Input - enter something here");
        input.setOnChange(state, (eventName, clientContext, control, clientState, event)->{ Log.info("changed" + input.getValue(clientState)); });

        Text.appendTo(vs, state, "NumberInput, step 0.5 between 0 and 100");
        var numberInput =  NumberInput.appendTo(vs, state, DefaultValue.set(10));
        numberInput.setMin(state,0.0);
        numberInput.setMax(state,100.0);
        numberInput.setStep(state,0.5);
        numberInput.setPrecision(state,1);
        numberInput.setPreText(state,"$");

        // create example html input, where we might accept an url
        Text.appendTo(vs, state, "InputGroup:");
        var rest = Text.appendTo(vs, state, "Value: ");
        var group = InputGroup.appendTo(vs, state);
        InputLeftAddon.appendTo(group, state, "https://");
        var input2 = Input.appendTo(group, state, "enter website", ColorSchemeEnum.GREEN);
        input2.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            rest.setText(clientState, "Value: " + input2.getValue(clientState));
        });
        InputRightAddon.appendTo(group, state, "/index.html");

        var java = """
```java    
    var input = Input.appendTo(vs, state, "This is a simple Input - enter something here");
    input.setOnChange(state, (eventName, clientContext, control, clientState, event)->{ Log.info("changed" + input.getValue(clientState)); });

    Text.appendTo(vs, state, "NumberInput, step 0.5 between 0 and 100");
    var numberInput =  NumberInput.appendTo(vs, state, DefaultValue.set(10));
    numberInput.setMin(state,0.0);
    numberInput.setMax(state,100.0);
    numberInput.setStep(state,0.5);
    numberInput.setPrecision(state,1);
    numberInput.setPreText(state,"$");

    // create example html input, where we might accept an url
    Text.appendTo(vs, state, "InputGroup:");
    var rest = Text.appendTo(vs, state, "Value: ");
    var group = InputGroup.appendTo(vs, state);
    InputLeftAddon.appendTo(group, state, "https://");
    var input2 = Input.appendTo(group, state, "enter website", ColorSchemeEnum.GREEN);
    input2.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
        rest.setText(clientState, "Value: " + input2.getValue(clientState));
    });
    InputRightAddon.appendTo(group, state, "/index.html");
```    
                """;
        addExplanationPages(parent, state,"Input / NumberInput / InputGroup", markdownDescription, vs, java);
    }

    private void addEditableTextArea (VStack parent, StateData state) {
        String markdownDescription = """
### TextArea 

Provides a editable field control.  Data is synced between the client and server.

In the example below,  we create a FormContext which holds TextArea (client input) and a Markdown window (client output)

As both controls are given the same name, as soon as TextArea is changed, the value is automatically sent to Markdown

Note that you can also use this simply - simply add a TextArea and use server side getValue and setValue to get/set values

""";
var  text = """
# TextArea Demo (left)

Here, data in a TextArea can be modified, with changes sent back to the server.

In this case, we have also synced the TextArea (*left*) with a markdown output control (*right*)

Thus, any change to the left **TextArea** will be sent to the **markdown** control.

[Click here to load markdown syntax](https://www.markdownguide.org/basic-syntax/)

- One
- Two
    - a
    - b
- Three
""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);
        var syncControls = FormContext.appendTo(vs, state); // allows both controls below to sync under the name 'Sliders'

        var hs = HStack.appendTo(syncControls, state, TextAlignEnum.LEFT);
        hs.setWidth(state,"90%").setHeight(state,"100%");

        var ta = TextArea.appendTo(hs, state);
        ta.setWidth(state,"45%").setHeight(state,"300px");
        ta.setName(state,"markdown");
        ta.setValue(state, text);

        Spacer.appendTo(hs, state);

        Box b = Box.appendTo(hs, state);
        b.setWidth(state,"45%").setHeight(state,"100%").setBgColor(state,"0x080808");
        var markdown = Markdown.appendTo(b, state, Markdown.ControlsEnum.NONE);
        markdown.setName(state,"markdown");

        String java = """
```java
    var syncControls = FormContext.appendTo(vs, state); // allows both controls below to sync under the name 'Sliders'

    var hs = HStack.appendTo(syncControls, state, TextAlignEnum.LEFT);
    hs.setWidth(state,"90%").setHeight(state,"100%");

    var ta = TextArea.appendTo(hs, state);
    ta.setWidth(state,"45%").setHeight(state,"300px");
    ta.setName(state,"markdown");
    ta.setValue(state, text);

    Spacer.appendTo(hs, state);

    Box b = Box.appendTo(hs, state);
    b.setWidth(state,"45%").setHeight(state,"100%").setBgColor(state,"0x080808");
    var markdown = Markdown.appendTo(b, state, Markdown.ControlsEnum.NONE);
    markdown.setName(state,"markdown");
```
""";
        addExplanationPages(parent, state,"TextArea", markdownDescription, vs, java);
    }

    private void addCheckbox (VStack parent, StateData state) {
        String markdownDescription = """
### Checbox and CheckboxGroup

Allows one or more boxes to be checked/set.  


Once changed on the client, the values will automatically be synced to the server (client state updated).

Checkbox is a single checkbox.  getValue and setValue are used to get/set  values.\n
CheckboxGroup allows adding multiple checkboxes, each with difference state.  get/setValue returns a list of values

Examples:

""";
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        var text1 = Text.appendTo(vs, state, "Checkbox callback text - toggle below checkbox");
        var cb = Checkbox.appendTo(vs, state, "This is a checkbox", DefaultValue.set(true), ColorSchemeEnum.ORANGE);
        cb.setOnChange( state, (eventName, clientContext, control, clientState, event)->{ text1.setText(clientState, cb.getValue(clientState).toString()); });

        var text2 = Text.appendTo(vs, state, "CheckboxGroup callback text - change something below");
        var cbg =  CheckboxGroup.appendTo(vs,state,"Milk,Sugar,Sweetener,Vanilla", DefaultValue.set("Milk,Vanilla"), ColorSchemeEnum.GREEN);
        cbg.setOnChange( state, (eventName, clientContext, control, clientState, event)->{ text2.setText(clientState, cbg.getValue(clientState).toString()); });

        String java = """
```java
    var text1 = Text.appendTo(vs, state, "Checkbox callback text - toggle below checkbox");
    var cb = Checkbox.appendTo(vs, state, "This is a checkbox", DefaultValue.set(true), ColorSchemeEnum.ORANGE);
    cb.setOnChange( state, (eventName, clientContext, control, clientState, event)->{ text1.setText(clientState, cb.getValue(clientState).toString()); });

    var text2 = Text.appendTo(vs, state, "CheckboxGroup callback text - change something below");
    var cbg =  CheckboxGroup.appendTo(vs,state,"Milk,Sugar,Sweetener,Vanilla", DefaultValue.set("Milk,Vanilla"), ColorSchemeEnum.GREEN);
    cbg.setOnChange( state, (eventName, clientContext, control, clientState, event)->{ text2.setText(clientState, cbg.getValue(clientState).toString()); });
```""";
        addExplanationPages(parent, state,"Checkbox", markdownDescription, vs, java);
    }

    private void addButton (VStack parent, StateData state)
    {
        String markdownDescription = """
### Buttons

The Button control is a user interface component that displays text or an icon and responds to user clicks. 

It allows users to trigger an action or navigate to a different section of an application.

Some fields of button:
- Text: what text should be displayed on the button.
- Size: Size of button
- Color: Color of button
- Icon: Icon to use

Call backs are added using the event mechanism

setOnClick/setOnMouseOver/setOnMouseOut/setOnMouseDown/setOnMouseDown/

Examples:

""";
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Markdown.appendTo(vs,state,"### Sizes:\n");

        var l = Arrays.asList(SizeEnum.XS,SizeEnum.SM,SizeEnum.MD,SizeEnum.LG);
        var hs = HStack.appendTo(vs,state);
        for (var size : l) {
            var b = Button.appendTo(hs, state, "Size: "+size, size);
            b.setTooltip(state, "Size = "+size);
        }

        Markdown.appendTo(vs,state,"### Color examples:\n");
        var s = Arrays.asList( "#90e0ef", "gray", "red", "green", "blue", "orange", "purple", "yellow",  "teal", "cyan", "pink", "indigo",
                "theme.colors.pageBgColor", "theme.colors.borderColor", "theme.colors.mainColor", "theme.colors.cardBgColor",
                "theme.colors.cardColor", "theme.colors.buttonBgColor", "theme.colors.buttonColor", "theme.colors.rowOdd", "theme.colors.rowEven");
        var aw = AutoWrap.appendTo(vs,state);
        for (var col : s) {
            var b = Button.appendTo(aw, state, ""+col);
            b.setBgColor(state, col);
            b.setColor(state, "black").setBorder(state, "1px solid black");
        }

        Markdown.appendTo(vs,state,"### Icon Example:\n");
        hs = HStack.appendTo(vs,state);
        var b = Button.appendTo(hs, state, "MdCall icon");
        b.setIcon(state, "MdCall");

        Markdown.appendTo(vs,state,"### Events:\n");
        hs = HStack.appendTo(vs,state);
        var button = Button.appendTo(hs, state, "OnMouseOver/OnMouseOut/OnClick");
        button.setOnMouseOver(state,  (eventName, clientContext, control, clientState, event)->{ button.setText(clientState, "OnMouseOver"); });
        button.setOnMouseOut(state,  (eventName, clientContext, control, clientState, event)->{ button.setText(clientState, "OnMouseOut"); });
        button.setOnClick(state,  (eventName, clientContext, control, clientState, event)->{ button.setText(clientState, "OnClick"); });

        String java = """
```java
    Markdown.appendTo(vs,state,"### Sizes:\\n");

    var l = Arrays.asList(SizeEnum.XS,SizeEnum.SM,SizeEnum.MD,SizeEnum.LG);
    var hs = HStack.appendTo(vs,state);
    for (var size : l) {
        var b = Button.appendTo(hs, state, "Size: "+size, size);
        b.setTooltip(state, "Size = "+size);
    }

    Markdown.appendTo(vs,state,"### Color examples:\\n");
    var s = Arrays.asList( "#90e0ef", "gray", "red", "green", "blue", "orange", "purple", "yellow",  "teal", "cyan", "pink", "indigo",
            "theme.colors.pageBgColor", "theme.colors.borderColor", "theme.colors.mainColor", "theme.colors.cardBgColor",
            "theme.colors.cardColor", "theme.colors.buttonBgColor", "theme.colors.buttonColor", "theme.colors.rowOdd", "theme.colors.rowEven");
    var aw = AutoWrap.appendTo(vs,state);
    for (var col : s) {
        var b = Button.appendTo(aw, state, ""+col);
        b.setBgColor(state, col);
        b.setColor(state, "black").setBorder(state, "1px solid black");
    }

    Markdown.appendTo(vs,state,"### Icon Example:\\n");
    hs = HStack.appendTo(vs,state);
    var b = Button.appendTo(hs, state, "MdCall icon");
    b.setIcon(state, "MdCall");

    Markdown.appendTo(vs,state,"### Events:\\n");
    hs = HStack.appendTo(vs,state);
    var button = Button.appendTo(hs, state, "OnMouseOver/OnMouseOut/OnClick");
    button.setOnMouseOver(state,  (eventName, clientContext, control, clientState, event)->{ button.setText(clientState, "OnMouseOver"); });
    button.setOnMouseOut(state,  (eventName, clientContext, control, clientState, event)->{ button.setText(clientState, "OnMouseOut"); });
    button.setOnClick(state,  (eventName, clientContext, control, clientState, event)->{ button.setText(clientState, "OnClick"); });
```
                """;

        addExplanationPages(parent, state,"Button", markdownDescription, vs, java);
    }
}

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


import com.gofintec.app.ui.TestApp.CustomControls.ExampleJSControl;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.custom.CustomControl;
import com.gofintec.kewlui.controls.base.settings.*;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

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

- Avatar - Display a user's profile picture
- Badge - The badge control enables the display of a small label or indicator on a user interface to provide information or functionality. It allows for easy identification of specific items or actions and can provide context to users.
- Button - Button control that cause callbacks on the server side.
- Checkbox - A checkbox is a graphical control element that allows for multiple options to be selected or deselected by the user. It is often used to represent boolean values, such as on/off or true/false, in a user interface.
- Datepicker - Simple DatePicker Control
- Divider - The Divider displays a thin horizontal or vertical line that can be used to separate content.
- Editable - The Editable control allows users to edit text in a GUI by clicking on it and typing directly into it.
- FormInput - Input that adds in helpers, Performs field validation
- Heartbeat - Invisible client control that sends regular updates to the server
- Icon - Icon control that displays an icon or image.
- IFrame - The IFrame control allows users to embed a web page within a GUI.
- Image - The Image control allows users to display an image within a GUI.
- Input - The Input control is a user interface element that allows users to input and edit text or numerical data. It could be used to create forms for data collection or search bars for filtering information.
- Markdown - Component that allows rendering of text areas using markdown, including code sections
- PinInput - The PinInput control is used to create a hidden and customizable input field for entering PIN codes.
- Radio - Radio control is a GUI element that allows users to select one option out of multiple options presented in a list.
- Select - The Select control is a form element that enables users to select an option from a pre-defined list or input values.
- Slider - A slider control is a user interface element that enables the selection of a value by sliding a thumb-like element along a horizontal or vertical track.
- StatVanilla - Visual control for showing statistics in a system
- Switch - The Switch control is a user interface element that allows users to toggle between two states.
- TextArea - The Textarea control allows users to edit multi-line text within a GUI by clicking on it and typing directly into it.
- Tooltip - The Tooltip feature allows users to display a tooltip when they hover over an element.
- Uploader - Allows file uploading

If a control offers an Icon, this can be set to the icons name (if the icon pack has been loaded) 

""";
        Markdown.appendTo(vs,state,contolMarkup, Markdown.ControlsEnum.NONE);

        addAvatar(vs,state);
        addBadges(vs, state);
        addButton(vs,state);
        addCheckbox(vs,state);
        addDatePicker(vs, state);
        addDivider(vs, state);

        addEditable(vs, state);
        addFormInput(vs,state);

        addHeartbeat(vs,state);

        addIcon(vs,state);
        addIFrame(vs,state);
        addImage(vs,state);
        addInput(vs,state);

        addMarkdown(vs, state);
        addPinInput(vs,state);
        addRadioGroup(vs, state);
        addSelect(vs, state);
        addSlider(vs, state);
        addStats(vs, state);
        addSwitch(vs, state);

        addTextArea(vs,state);
        addTooltip(vs, state);
        addUploader(vs, state);
        addCommon(vs,state);

        String markdownDescription = """
### Other controls

Other controls have been implemented, and will be added to the control showcase in the future.
""";
        Markdown.appendTo(vs,state,markdownDescription, Markdown.ControlsEnum.NONE);
    }

    private void addCommon (VStack parent, StateData state) {
        String markdownDescription = """
## Common Attributes (Comonents and Containers)


## Width and Height

- **setWidth (width)**: Controls the width of the component. e.g., `setWidth(state, "300px");`
- **setHeight (height)**: Controls the height of the component. e.g., `setHeight(state, "200px");`
- **setMaxWidth (maxWidth)**: Sets the maximum width of the component. e.g., `setMaxWidth(state, "500px");`
- **setMaxHeight (maxHeight)**: Sets the maximum height of the component. e.g., `setMaxHeight(state, "400px");`
- **setMinWidth (minWidth)**: Sets the minimum width of the component. e.g., `setMinWidth(state, "100px");`
- **setMinHeight (minHeight)**: Sets the minimum height of the component. e.g., `setMinHeight(state, "100px");`

## Margin and Padding

- **setMargin (margin)**: Applies margin space on all sides of an element. e.g., `setMargin(state, "20px");`
- **setMarginTop (marginTop)**: Applies margin to the top side. e.g., `setMarginTop(state, "20px");`
- **setMarginRight (marginRight)**: Applies margin to the right side. e.g., `setMarginRight(state, "20px");`
- **setMarginBottom (marginBottom)**: Applies margin to the bottom side. e.g., `setMarginBottom(state, "20px");`
- **setMarginLeft (marginLeft)**: Applies margin to the left side. e.g., `setMarginLeft(state, "20px");`
- **setPadding (padding)**: Applies padding space on all sides of an element. e.g., `setPadding(state, "20px");`
- **setPaddingTop (paddingTop)**: Applies padding to the top side. e.g., `setPaddingTop(state, "20px");`
- **setPaddingRight (paddingRight)**: Applies padding to the right side. e.g., `setPaddingRight(state, "20px");`
- **setPaddingBottom (paddingBottom)**: Applies padding to the bottom side. e.g., `setPaddingBottom(state, "20px");`
- **setPaddingLeft (paddingLeft)**: Applies padding to the left side. e.g., `setPaddingLeft(state, "20px");`

## Colors

- **setColor (color)**: Sets the foreground color of the component. e.g., `setColor(state, "blue");`
- **setBgColor (bgColor)**: Sets the background color of the component. e.g., `setBgColor(state, "gray");`

## Borders

- **setBorder (border)**: Sets the border width, style, and color. e.g., `setBorder(state, "2px solid black");`
- **setBorderWidth (borderWidth)**: Controls the width of the border. e.g., `setBorderWidth(state, "2px");`
- **setBorderStyle (borderStyle)**: Sets the style of the border. e.g., `setBorderStyle(state, "dashed");`
- **setBorderColor (borderColor)**: Specifies the color of the border. e.g., `setBorderColor(state, "red");`
- **setBorderRadius (borderRadius)**: Controls the rounding of the corners. e.g., `setBorderRadius(state, "8px");`

## Typography

- **setFontSize (fontSize)**: Sets the size of the font. e.g., `setFontSize(state, "16px");`
- **setFontWeight (fontWeight)**: Controls the weight of the font. e.g., `setFontWeight(state, "bold");`
- **setLineHeight (lineHeight)**: Sets the height of a line. e.g., `setLineHeight(state, "1.5");`
- **setLetterSpacing (letterSpacing)**: Controls the spacing between letters. e.g., `setLetterSpacing(state, "0.1em");`
- **setTextAlign (textAlign)**: Aligns text within the component. e.g., `setTextAlign(state, "center");`
- **setFontFamily (fontFamily)**: Sets the font family. e.g., `setFontFamily(state, "'Roboto', sans-serif");`

## Layout

- **setOverflow (overflow)**: Controls how overflowed content is handled. e.g., `setOverflow(state, "hidden");`

## Other

- **setControlHidden (controlHidden)**: If true, hides the component. e.g., `setControlHidden(state, true);`
- **setControlPulseOnChange (controlPulseOnChang)**: If true, the component will pulse on change. e.g., `setControlPulseOnChange(state, true);`

## Fallback

If a direct function is not found on the control (e.g. setLetterSpacing), you can try setProperty on the short name (state, "letterSpacing", "0.1em");

""";
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        var input = Input.appendTo(vs, state, "Input box with various attributes set"); // set placeholder
        input.setBorder(state, "2px solid blue");
        input.setBorderRadius(state, "md");
        input.setPadding(state, "16px");
        input.setBgColor(state, "theme.colors.page");
        input.setColor(state, "theme.colors.pageText");
        input.setFontSize(state, "md");
        input.setBoxShadow(state, "sm");
        input.setWidth(state, "100%");
        input.setMargin(state, "8px");
        input.setFontFamily(state, "'Comic Sans MS', cursive");

        String java = """
###Example Java code: \n\n
```java
    var input = Input.appendTo(vs, state, "Input box with various attributes set"); // set placeholder
    input.setBorder(state, "2px solid blue");
    input.setBorderRadius(state, "md");
    input.setPadding(state, "16px");
    input.setBgColor(state, "theme.colors.page");
    input.setColor(state, "theme.colors.pageText");
    input.setFontSize(state, "md");
    input.setBoxShadow(state, "sm");
    input.setWidth(state, "100%");
    input.setMargin(state, "8px");
    input.setFontFamily(state, "'Comic Sans MS', cursive");
```
""";

        addExplanationPages(parent, state, "(Common visual styling)", markdownDescription, vs, java);
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

    private void addHeartbeat(VStack parent, StateData state) {
        String markdownDescription = """
### Heartbeat

The heartbeat control will cause a callback for all connected users every X seconds.

Setting the heartbeatInterval to 0 will disable the heartbeat.  If not set, default is 15 seconds.

Heartbeat code is achieved by the client sending back a ISO timestamp (and timezone) in the Value field.

The heartbeat control is otherwise invisible.

This might be useful as a timer to update user specific controls at a regular interval.

""";

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        Divider.appendTo(vs, state);
        Text.appendTo(vs, state, "Heartbeat Example");

        var text = Text.appendTo(vs, state, "");
        text.setControlPulseOnChange(state, true); // momentary highlight on change

        var heartbeat = Heartbeat.appendTo(vs, state);
        heartbeat.setHeartbeatInterval(state, 3);
        heartbeat.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
            var val = heartbeat.getValue(clientState);
            text.setText(clientState, "Client sent Heartbeat: '" + val + "' to the server."); // remember update text not value here
        });

        String java = """
###Example Java code: \n\n
```java       
    Text.appendTo(vs, state, "Heartbeat Example");

    var text = Text.appendTo(vs, state, "");
    text.setControlPulseOnChange(state, true); // momentary highlight on change

    var heartbeat = Heartbeat.appendTo(vs, state);
    heartbeat.setHeartbeatInterval(state, 3);
    heartbeat.setOnChange(state, (eventName, clientContext, control, clientState, event)->{
        var val = heartbeat.getValue(clientState);
        text.setText(clientState, "Client sent Heartbeat: '" + val + "' to the server."); // remember update text not value here
    });
```
""";

            addExplanationPages(parent, state, "Heartbeat", markdownDescription, vs, java);
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

    private void addTextArea (VStack parent, StateData state) {
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
                "theme.colors.page", "theme.colors.primary", "theme.colors.secondary", "theme.colors.accent",
                 "theme.colors.rowOdd", "theme.colors.rowEven");
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

        var txt = Text.appendTo(vs, state, "When the customTheme is used, 'customButton' variant will be made available and below will change style");
        b = Button.appendTo(vs, state,"variant=customButton");
        b.setVariant(state, "customButton");
        b.setOnClick(state,  (eventName, clientContext, control, clientState, event)->{ txt.setText(clientState, "customButton pushed"); });

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
                               "theme.colors.page", "theme.colors.primary", "theme.colors.secondary", "theme.colors.accent",
                               "theme.colors.rowOdd", "theme.colors.rowEven");                                                     
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

    private void addUploader (VStack parent, StateData globalState) {
        String markdownDescription = """
## Uploader

The `Uploader` component enables users to upload files to the server. It provides customizable settings for file types, multiple file uploads, and limits on file size and number.

### Properties

- ***accept*** 
string - Sets the types of files that are accepted. By default, it accepts all file types (`*`). Can be used to restrict to specific file types, like `"image/*"` for all images, or `".pdf"` for PDF files only.
- ***multiple*** 
boolean - If `true`, allows multiple files to be uploaded simultaneously. Defaults to `true`.
- ***maxSizeBytes*** 
long - Maximum file size allowed for upload, in bytes. This is a client-side check.
- ***maxFiles*** 
integer - Maximum number of files that can be uploaded at once.
- ***submitButtonText*** 
string - Text displayed on the submit button. Supports Mustache templating for dynamic text.
- ***addFilesText*** 
string - Text for the add files section, e.g., "Drag Files Here or Click to Browse." Also supports Mustache templating for dynamic content.

Callback:  onUpload is called when uploading is performed
    - Value is set to List<MultipartFile>.  (value reset to null after callback)
    - Throwing exception will result in upload error

""";
        var vs = new VStack(globalState);
        vs.setAlignItems(globalState, AlignItemsEnum.FLEX_START);

        var hs = HStack.appendTo(vs,globalState);
        var up = Uploader.appendTo(hs, globalState);
        var information = Markdown.appendTo(hs, globalState, Markdown.ControlsEnum.ALL);

        // Uploader/OnUpload callback is a bit different - a List<MultipartFile> is temporarily stored
        // in the clientState value for this control.  At the end of this process, the value is cleared back to null
        up.setOnUpload(globalState,  (eventName, clientContext, control, clientState, event)-> {
            var downloadedFiles = new ArrayList<File>();
            StringBuilder sb = new StringBuilder("### Result of upload\n<br/>List of files uploaded:\n<br/>\n");
            try {
                List<MultipartFile> files = up.getValue(clientState);
                for (var file : files) {
                    // download the file to a temp file on this machine....
                    var destFile = new File(UUID.randomUUID().toString()+".tmp");
                    downloadedFiles.add(destFile);

                    try (InputStream inputStream = file.getInputStream()) {
                        Files.copy(inputStream, destFile.toPath().toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    sb.append(String.format("Name: %s  OriginalFileName: %s ContentType: %s Reported Size: %d Actual Size: %d.\n<br/>", file.getName(), file.getOriginalFilename(), file.getContentType(), file.getSize(), destFile.length()));
                }
                information.setText(clientState, sb.toString());
            }
            catch (Exception ex) {
                Log.error("Exception thrown in upload processor", ex);
                information.setText(clientState, "Exception thrown in upload processor "+ex.getMessage());
            } finally {
                // finally, we are done, clean up the temp files we downloaded.
                for (var file : downloadedFiles) {
                    if (file.exists())
                        file.delete();
                }
            }
        });

        String java = """
```java
  var hs = HStack.appendTo(vs,globalState);
        var up = Uploader.appendTo(hs, globalState);
        var information = Markdown.appendTo(hs, globalState, Markdown.ControlsEnum.ALL);

        // Uploader/OnUpload callback is a bit different - a List<MultipartFile> is temporarily stored
        // in the clientState value for this control.  At the end of this process, the value is cleared back to null
        up.setOnUpload(globalState,  (eventName, clientContext, control, clientState, event)-> {
            var downloadedFiles = new ArrayList<File>();
            StringBuilder sb = new StringBuilder("### Result of upload\\n<br/>List of files uploaded:\\n<br/>\\n");
            try {
                List<MultipartFile> files = up.getValue(clientState);
                for (var file : files) {
                    // download the file to a temp file on this machine....
                    var destFile = new File(UUID.randomUUID().toString()+".tmp");
                    downloadedFiles.add(destFile);

                    try (InputStream inputStream = file.getInputStream()) {
                        Files.copy(inputStream, destFile.toPath().toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    sb.append(String.format("Name: %s  OriginalFileName: %s ContentType: %s Reported Size: %d Actual Size: %d.\\n<br/>", file.getName(), file.getOriginalFilename(), file.getContentType(), file.getSize(), destFile.length()));
                }
                information.setText(clientState, sb.toString());
            }
            catch (Exception ex) {
                Log.error("Exception thrown in upload processor", ex);
                information.setText(clientState, "Exception thrown in upload processor "+ex.getMessage());
            } finally {
                // finally, we are done, clean up the temp files we downloaded.
                for (var file : downloadedFiles) {
                    if (file.exists())
                        file.delete();
                }
            }
        });
```
""";
        addExplanationPages(parent, globalState,"Uploader", markdownDescription, vs, java);
    }

    private void addDatePicker(VStack parent, StateData state) {
        String markdownDescription = """
    ### DatePicker

    The DatePicker control allows users to select a date from a visual calendar interface. 
    Has Options to set min and max dates

    In the example below, we demonstrate how to add a DatePicker and handle date selection events.
    """;

        // Creating the container
        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);
        vs.setTextAlign(state, TextAlignEnum.LEFT);

        // Adding explanatory text
        Text.appendTo(vs, state, "Select a date:");

        // Adding DatePicker -  can be ms or YYYY-MM-DD
        var datePicker = DatePicker.appendTo(vs, state);
        datePicker.setMinDate(state, "1900-01-01"); // Set minimum date - can be ms or YYYY-MM-DD
        datePicker.setMaxDate(state, "2050-01-01"); // Set maximum date

        //2024-03-21T20:43:05.547Z

        // Adding a callback to handle date selection
        var selectedDateText = Text.appendTo(vs, state, "No date selected");
        datePicker.setOnChange(state, (eventName, clientContext, control, clientState, event) -> {
            var selectedDate = datePicker.getValue(clientState); // Get selected date
            selectedDateText.setText(clientState, "Selected date: " + selectedDate);
        });

        var cb = Checkbox.appendTo(vs,state,"Include time", DefaultValue.set(false) );
        cb.setOnChange(state, (eventName, clientContext, control, clientState, event) -> {
            Boolean value = cb.getValue(clientState); // Get selected date
            datePicker.setHasTime(clientState,value);
        });

        String javaCode = """
```java

   // Adding explanatory text
   Text.appendTo(vs, state, "Select a date:");

   // Adding DatePicker -  can be ms or YYYY-MM-DD
   var datePicker = DatePicker.appendTo(vs, state);
   datePicker.setMinDate(state, "1900-01-01"); // Set minimum date - can be ms or YYYY-MM-DD
   datePicker.setMaxDate(state, "2050-01-01"); // Set maximum date

   //2024-03-21T20:43:05.547Z

   // Adding a callback to handle date selection
   var selectedDateText = Text.appendTo(vs, state, "No date selected");
   datePicker.setOnChange(state, (eventName, clientContext, control, clientState, event) -> {
       var selectedDate = datePicker.getValue(clientState); // Get selected date
       selectedDateText.setText(clientState, "Selected date: " + selectedDate);
   });

   var cb = Checkbox.appendTo(vs,state,"Include time", DefaultValue.set(false) );
   cb.setOnChange(state, (eventName, clientContext, control, clientState, event) -> {
       Boolean value = cb.getValue(clientState); // Get selected date
       datePicker.setHasTime(clientState,value);
   });
```
""";
        // Add explanation pages (assuming this method is available and works similarly to other examples)
        addExplanationPages(parent, state, "DatePicker", markdownDescription, vs, javaCode);
    }


    public void addExtendControl (VisualControl parent, StateData globalState) {

        var vs = VStack.appendTo(parent, globalState);

        Markdown.appendTo(vs, globalState, Markdown.ControlsEnum.ALL, """
## Extending KewlUI

KewlUI simplifies adding your own controls to the system.

Controls are added by registering a Javascript rendering function (Js or React) which can be called by a custom control.

This can be done in 2 ways:

1. Adding Javascript/React links/scripts to your html page, and using CustomControl to run them.
2. Creating a new class that extends CustomControl - which contains the javascript/css - and registering it.

<br/>           

While both are possible, it is most likely you will want the second option - detailed in "Part 2" below.                
<br/>
""");

        addExtendControl1(vs, globalState);
        addExtendControl2(vs, globalState);
    }


    public void addExtendControl1 (VisualControl parent, StateData globalState) {

        String markdownDescription = """
## Custom Controls - Part 1

KEWLUI can be extended with React Components, JavaScript components, and so on.
    
The Custom control allows integrating external controls into the framework.

Note: Part2 describes creating a Java class with Javascript/Css encapsulated within the user defined custom class

<br/>
    
### Registering functions
    
Load the javascript in your html before KewlUI loads.
Then in a script block:

        // Initialize the registry if it does not already exist
        window.KEWLUI_CONTROLS = window.KEWLUI_CONTROLS || {};

<br/>
KEWLUI_CONTROLS holds a dictionary that maps between names and functions.

The function is passed a **param** object, which has the following fields
    - targetId - location where to render the control
    - props - props to pass to the control
    - eventHandlers - dictionary (name->function) of event handlers registered, e.g "onMouseOver"
    - text - translated text field
    - value - value field
    - setValue(value) - function to call if the value of this contol changes    
    - isSmallScreen - set true if this appears to be mobile
    - rebuild() - function to call to perform a complete rerender  (will stop this control, clean up, build a new one)
    - colors - dictionary containing color names, such as "primary", "pageText" etc - used to pass on theming.
    - state - state dictionary for this control, can be used by user js code as a storage area
    - paramsChanged - boolean, true if paint is due to parameters changing.  False== only value may have has changed.
<br/>
The function should return either null/unknown, or another function that should be called on destruction of the control. 
    - Cleanup function receives **param** dictionary, which contains targetId above.

<br/>
### Registering a function (Javascript control)

In the below example, we register a function 'plainJSFunction', which when called will update the innerHTML of a target ID.
<br/>

```js
<script>
    window.KEWLUI_CONTROLS = window.KEWLUI_CONTROLS || {};
    
    window.KEWLUI_CONTROLS['plainJSFunction'] = function(params) {
      const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, rebuild, colors} = params;
      const element = document.getElementById(targetId);
      if(element) {
         element.innerHTML = `<div>Updated by plain JavaScript function: Value: ${value} Username ${props.userName}</div>`;
      }
      return null; // returning null == no cleanup necessary
    };
</script>
```

<br/>

### Registering a React control via Function

The React case is slightly more complicated, as react needs compilation into a final js file.

An example react app which registers a control:

```js
    // index.js/index.jsx 
    import ReactDOM from 'react-dom';
    import MyReactComponent from './MyReactComponent'; // Path to your React component
            
    window.KEWLUI_CONTROLS = window.KEWLUI_CONTROLS || {};
    
    window.KEWLUI_CONTROLS['renderReactComponent'] = function(params) {
      const {targetId, props, text, value, setValue} = params;
      const element = document.getElementById(targetId);
      if(element) {
        // Use ReactDOM.render to render the React component into the target element
        ReactDOM.render(<MyReactComponent {...props} />, element);
      }
    };
    
    
```

React will then build a js file, which should be included in the html before the KEWLUI js.

<br/><br/>
### Calling the control

The control is different in that most normal props (such as width etc) are simply passed through to the final control and visual style is not interpreted. 
Ie setWidth will not change the width of the control.  If this is needed, surround it with a Box of the dimensions needed.

```java
    var custom = Custom.appendTo(parent, state);
    custom.setControlName(state, "plainJSFunction");
    custom.setValue(state, 1234); // value will be passed in params.value    
    custom.setProperty(state, "userName", "Bob Gnarley"); // gets added to props
```
<br/>

Note - above controls will be rendered 100ms after other controls are rendered.    
This is done as a kind of "debounce" to reduce painting calls.
<br/>
""";

        // Creating the container
        var vs = new VStack(globalState);
        vs.setAlignItems(globalState, AlignItemsEnum.FLEX_START);
        vs.setTextAlign(globalState, TextAlignEnum.LEFT);

        Text.appendTo(vs,globalState, "Rendering Custom control within box below");

        var box = Box.appendTo(vs, globalState);
        box.setPadding(globalState, "10px").setBorder(globalState, "1px solid black").setAlign(globalState, AlignItemsEnum.FLEX_START);
        box.setBgColor(globalState, "theme.colors.secondary_50");

        var custom = CustomControl.appendTo(box, globalState);
        custom.setControlName(globalState, "plainJSFunction"); // this has been added to index.html as an example
        custom.setValue(globalState, 1234); // value will be passed in params.value
        custom.setProperty(globalState, "userName", "Bob Gnarley"); // gets added to props

        Divider.appendTo(vs,globalState);

        Timer timer = new Timer();
        Random r = new Random();
        timer.scheduleAtFixedRate(new TimerTask() {  // test updating value on custom element
            @Override
            public void run() {
                custom.setValue(globalState, r.nextInt(1000)); // update control with random value
            }
        }, 1000, 2000);

        Divider.appendTo(vs,globalState);

        var java = """
```java
       Text.appendTo(vs,globalState, "Rendering Custom control within box below");

       var box = Box.appendTo(vs, globalState);
       box.setPadding(globalState, "10px").setBorder(globalState, "1px solid black").setAlign(globalState, AlignItemsEnum.FLEX_START);
       box.setBgColor(globalState, "theme.colors.secondary_50");

       var custom = CustomControl.appendTo(box, globalState);
       custom.setControlName(globalState, "plainJSFunction");
       custom.setValue(globalState, 1234); // value will be passed in params.value
       custom.setProperty(globalState, "userName", "Bob Gnarley"); // gets added to props

       Divider.appendTo(vs,globalState);

       Timer timer = new Timer();
       Random r = new Random();
       timer.scheduleAtFixedRate(new TimerTask() {  // test updating value on custom element
           @Override
           public void run() {
               custom.setValue(globalState, r.nextInt(1000)); // update control with random value
           }
       }, 1000, 2000);
```
""";

        // Add explanation pages (assuming this method is available and works similarly to other examples)
        addExplanationPages(parent, globalState, "Extending Basics", markdownDescription, vs, java, true);

    }


    public void addExtendControl2 (VisualControl parent, StateData globalState) {

        String markdownDescription = """
## Custom Controls - Part 2 - Java classes

You can create your own custom controls by doing the following:

1. Create your custom control, inheriting/extending from "CustomControl" class
2. Add in constructor and appendTo functions
3. Add in static functions to the class, getControlJavascript and (optionally) getControlCss() / getControlIncludes()
4. Call static CustomControl.registerClass to startup to add make your class usable.

Registering the class means that the Css/Javascript will automatically be added to KewlUI pages/forms.

<br/>

Let's start with an example - ExampleJSControl - which creates a colorful control that adds 2 numbers (x/y) together.
<br/>

### 1. Create ExampleJSControl

```java
    public class ExampleJSControl extends CustomControl....
```
<br/>
### 2. Add Constructor + appendTo static function

```java
    public ExampleJSControl (StateData state) {
        super(state);
    }

    public static ExampleJSControl appendTo(VisualControl parent, StateData state, Object... modifiers) {
        return appendTo( new ExampleJSControl(state), parent, state, modifiers);
    }
```
<br/>

### 3. Create static functions

1. Let's create function getControlCss

Note: we can use theme colors in our css using vars, however instead of . separators we need - separators
e.g. use: var(--theme-colors-primaryText)

```java
    public static String getControlCss() {
        return ""\"
                /* Styles for the funky-color-fade custom class */
                      .funky-color-fade {
                          color: var(--theme-colors-primaryText); /* Text color - taken from theme palette */
                          
                          /* Gradient background for color fade effect - using theme colors */
                           background: linear-gradient(to right, var(--theme-colors-primary), var(--theme-colors-secondary));
                          
                          /* Additional styles for visual appeal */
                          padding: 20px;
                          border-radius: 10px;
                          text-align: center;
                          font-size: 18px;
                      }\s
                ""\";
    }
``` 
<br/>

2. Now let's create the getControlJavascript to return JS:
<br/>  

```java
public static String getControlJavascript() {
    return ""\"
    // Register function in JS
    window.KEWLUI_CONTROLS['ExampleJSControl'] = function(params) {
          // function params, which has a number of fields within it:
          const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, rebuild, colors, state} = params;
          
          // we have the targetId - get the document element
          const element = document.getElementById(targetId);
          if(element) {
             // set the elements innerHTML - note we set the class thus get the css defined earlier
             const answer = (props.x ?? 0)  * (props.y ?? 0);
             element.innerHTML = `< div class="funky-color-fade"> Multiplying ${props.x} with ${props.y} gives answer ${answer}</div>`;
          }
          return null; // returning null == no cleanup necessary
    };
    ""\";
    }                
```
<br/>
<br/>


### 4. Register the control

<br/>
Finally in our code, we need to register the new control.  We do this by calling: CustomControl.registerClass.
<br/>
CustomControl.registerClass(ExampleJSControl.class);
<br/>

The control is now ready to use:            
<br/>
""";

        // Creating the container
        var vs = new VStack(globalState);
        vs.setAlignItems(globalState, AlignItemsEnum.FLEX_START);
        vs.setTextAlign(globalState, TextAlignEnum.LEFT);

        Divider.appendTo(vs,globalState);

        Text.appendTo(vs, globalState, "Following control is Java 'ExampleJsControl' which contains Javascript/Css within the class");
        var example = ExampleJSControl.appendTo(vs,globalState);
        example.setX(globalState, 6);
        example.setY(globalState, 7);

        var java = """
```java
    Divider.appendTo(vs,globalState);

    Text.appendTo(vs, globalState, "Following control is Java 'ExampleJsControl' which contains Javascript/Css within the class");
    var example = ExampleJSControl.appendTo(vs,globalState);
    example.setX(globalState, 6);
    example.setY(globalState, 7);
```
""";

        // Add explanation pages (assuming this method is available and works similarly to other examples)
        addExplanationPages(parent, globalState, "Extending - Java Custom Controls", markdownDescription, vs, java, true);
    }
}

package org.kewlui.demo.ui.TestApp.Pages.Components;

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


import org.kewlui.demo.ui.TestApp.Pages.BasePage;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.settings.AlignItemsEnum;
import com.gofintec.kewlui.controls.base.settings.ContainerPositionEnum;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.UUID;

/**
 * Example page for popups etc
 *
 */
public class PopupPage extends BasePage {

    private static final Logger Log = LogManager.getLogger(PopupPage.class);

    public PopupPage () {

        super(true);
    }


    public void AddEventExample(VisualControl parent, StateData state) {
        VStack vs = VStack.appendTo(parent,state);

        String chartMarkup = """
# Popups

The following are available as popups

- PopupMessage: A simple information message popup that auto closes within a certain amount of time 
- DialogWindow

""";
        Markdown.appendTo(vs, state,chartMarkup, Markdown.ControlsEnum.NONE);

        addPopupMessage(vs, state);
        addPopoverSimple (vs,  state);

        addModalDialog(vs, state);


        String markdownDescription = """
### Other controls

Other controls have been implemented, and will be added to the control showcase in the future.
""";
        Markdown.appendTo(vs,state,markdownDescription, Markdown.ControlsEnum.NONE);
    }

    private void addPopupMessage (VStack parent, StateData state) {

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        String markdownDescription = """
                ## PopupMessage

                PopupMessage present a short text message to the user.  It has the following fields:
                
                - duration: number of millieconds before auto closing
                - position: where to display the popup , "top", "top-right", "top-left", "bottom", "bottom-right", "bottom-left"
                - status: "success", "error", "warning", "info" - controls the color of the popup
                - isClosable: if `true`, the toast will have a close button, allowing the user to dismiss it before the timeout
                - variant: "solid", "subtle", "left-accent", "top-accent"
                - title: title of the popup

                A popup can be shown by defining it in the window, and making it show by setting the value to a UID
                Once the popup closes, the value will be reset to null
                
                In the following example, we create a button that will activate the PopupMessage
                """;
        Button button = Button.appendTo(vs, state, "Push to activate popup");

        var statusTypes = Arrays.asList(PopupMessage.StatusEnum.values());

        // this is hidden by default until we set a string uid
        PopupMessage msg = PopupMessage.appendTo(vs, state);
        msg.setDuration(state, 3000);
        msg.setPosition(state, PopupMessage.PositionEnum.BOTTOM);
        msg.setStatus(state, PopupMessage.StatusEnum.SUCCESS);
        msg.setIsClosable(state, true);
        msg.setVariant(state, PopupMessage.VariantEnum.SOLID);
        msg.setDescription(state,"The button was successfully pushed");

        // set up callback on button - set the popup message type, and setValue to a unique id to show it
        button.setOnClick(state, (e)->{
            var oldState = (int) e.clientState().getOurUserData().getOrDefault("lastStatusType", 0);
            var status = statusTypes.get(oldState % statusTypes.size());
            msg.setTitle(e.clientState(),status+"!");
            msg.setStatus(e.clientState(),status);
            msg.setValue(e.clientState(), UUID.randomUUID().toString());
            e.clientState().getOurUserData().put("lastStatusType", (oldState+1));
        });

        String java = """
###Example Java code: \n\n
```java
     Button button = Button.appendTo(vs, state, "Push to activate popup");

    var statusTypes = Arrays.asList(PopupMessage.StatusEnum.values());

    // this is hidden by default until we set a string uid
    PopupMessage msg = PopupMessage.appendTo(vs, state);
    msg.setDuration(state, 3000);
    msg.setPosition(state, PopupMessage.PositionEnum.BOTTOM);
    msg.setStatus(state, PopupMessage.StatusEnum.SUCCESS);
    msg.setIsClosable(state, true);
    msg.setVariant(state, PopupMessage.VariantEnum.SOLID);
    msg.setDescription(state,"The button was successfully pushed");

    // set up callback on button - set the popup message type, and setValue to a unique id to show it
    button.setOnClick(state, (e)->{
        var oldState = (int) e.clientState().getOurUserData().getOrDefault("lastStatusType", 0);
        var status = statusTypes.get(oldState % statusTypes.size());
        msg.setTitle(e.clientState(),status+"!");
        msg.setStatus(e.clientState(),status);
        msg.setValue(e.clientState(), UUID.randomUUID().toString());
        e.clientState().getOurUserData().put("lastStatusType", (oldState+1));
    });
```
""";
        addExplanationPages(parent, state, "PopupMessage", markdownDescription, vs, java, true);
    }


    private void addPopoverSimple (VStack parent, StateData state) {

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        String markdownDescription = """
                ## PopoverSimple

                The Popover control is a UI container that displays content in a small window that appears on top of other content. 
                
                It allows users to access additional information without disrupting their workflow. It can be used to provide context or to display related options or actions.

                Other controls can be added to the container using the ContainerPosition/ContainerPositionEnum.
                
                For example,                 
                - ContainerPositionEnum.BUTTON: Any button placed here will cause activation/opening of the window
                - header/footer: Used to add a header or footer to the window
                - '' (or without setting ContainerPositionEnum): Place in the main area  
                 
                In the following example, we will make a ImageButton open up a PopoverSimple container                
                """;
        var popover = PopoverSimple.appendTo(vs,state, ContainerPositionEnum.EAST);
        {
            // add ImageButton to the 'Button' location of the popover
            var hs = HStack.appendTo(popover,state, ContainerPositionEnum.BUTTON);
            var ib = ImageButton.appendTo(hs,state);
            ib.setBorderRadius(state, "full").setWidth(state, "40px").setHeight(state, "40px");
            ib.setSrc(state, "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=50&h=50&q=80");
            Text.appendTo(hs,state,"< Push to open");

            // add header and footer text
            Text.appendTo(popover,state,"Header", ContainerPositionEnum.HEADER);
            Text.appendTo(popover,state,"Footer", ContainerPositionEnum.FOOTER);

            // add buttons into the default main area of the container
            var b = Button.appendTo(popover,state,"Settings");
            b.setIcon(state,"MdOutlineSettings");
            b.setWidth(state, "100%");
            Divider.appendTo(popover,state);
            b = Button.appendTo(popover,state,"Some other button");
            b.setWidth(state, "100%");
        }

        String java = """
###Example Java code: \n\n
```java
     var popover = PopoverSimple.appendTo(vs,state, ContainerPositionEnum.EAST);

       // Add ImageButton to the 'Button' location of the popover container
       var hs = HStack.appendTo(popover,state, ContainerPositionEnum.BUTTON);
       var ib = ImageButton.appendTo(hs,state);
       ib.setBorderRadius(state, "full").setWidth(state, "40px").setHeight(state, "40px");
       ib.setSrc(state, "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=50&h=50&q=80");
       Text.appendTo(hs,state,"< Push to open");

       // add header and footer text
       Text.appendTo(popover,state,"Header", ContainerPositionEnum.HEADER);
       Text.appendTo(popover,state,"Footer", ContainerPositionEnum.FOOTER);

       // add buttons into the default main area of the container
       var b = Button.appendTo(popover,state,"Settings");
       b.setIcon(state,"MdOutlineSettings");
       b.setWidth(state, "100%");
       Divider.appendTo(popover,state);
       b = Button.appendTo(popover,state,"Some other button");
       b.setWidth(state, "100%");

```
""";

        addExplanationPages(parent, state, "PopoverSimple", markdownDescription, vs, java, true);
    }



    private void addModalDialog (VStack parent, StateData state) {

        var vs = new VStack(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        var text = Text.appendTo(vs,state,"ModalDialog Output goes here");

        String markdownDescription = """
                ## ModalDialog

                ModalDialog is a dialog that displays content in a small window that appears on top of other content.
                
                Controls can be put within the window
                
                For example,
                - ContainerPositionEnum.BUTTON: Any button placed here will cause Opening of the window                 
                - ContainerPositionEnum.FOOTER: Any button placed here will cause closing of the window
                - header: Used to add a header to the window
                - '' (or without setting ContainerPositionEnum): Place in the main area  
                 
                In the following example, we will make a ImageButton open up a PopoverSimple container                
                """;
        var modalDialog = ModalDialog.appendTo(vs,state, ContainerPositionEnum.EAST);
        {
            // add button to open dialog
            Button.appendTo(modalDialog,state,"Save", ContainerPositionEnum.BUTTON);

            // add header
            Text.appendTo(modalDialog,state,"Dialog Header", ContainerPositionEnum.HEADER);

            // add buttons to footer
            var ok  = Button.appendTo(modalDialog,state,"OK", ContainerPositionEnum.FOOTER);
            var cancel  = Button.appendTo(modalDialog,state,"CANCEL", ContainerPositionEnum.FOOTER);
            ok.setOnClick(state, (e)->{
                text.setText(state, "OK");
            });
            cancel.setOnClick(state, (e)->{
                text.setText(state, "CANCEL");
            });

            // add markdown in main section of modelDialog
            var mu = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.";
            Markdown.appendTo(modalDialog,state,mu);
        }

        String java = """
###Example Java code: \n\n
```java
    var modalDialog = ModalDialog.appendTo(vs,state, ContainerPositionEnum.EAST);
    {
        // add button to open dialog
        Button.appendTo(modalDialog,state,"Save", ContainerPositionEnum.BUTTON);

        // add header
        Text.appendTo(modalDialog,state,"Dialog Header", ContainerPositionEnum.HEADER);

        // add buttons to footer
        var ok  = Button.appendTo(modalDialog,state,"OK", ContainerPositionEnum.FOOTER);
        var cancel  = Button.appendTo(modalDialog,state,"CANCEL", ContainerPositionEnum.FOOTER);
        ok.setOnClick(state, (e)->{
            text.setText(state, "OK");
        });
        cancel.setOnClick(state, (e)->{
            text.setText(state, "CANCEL");
        });

        // add markdown in main section of modelDialog
        var mu = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.";
        Markdown.appendTo(modalDialog,state,mu);
    }
```
""";

        addExplanationPages(parent, state, "ModalDialog", markdownDescription, vs, java, true);
    }

}

package com.gofintec.app.ui.TestApp.Component;

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
import com.gofintec.kewlui.controls.base.settings.TextAlignEnum;
import com.gofintec.kewlui.controls.std.*;

/**
 * Example Utility class to create card views for UI representation in applications.
 * This class is designed to generate a horizontal description card that includes
 * a top text section along with left and right panels for additional information.
 * The card's appearance and content are customizable through parameters.
 */
public class MyCardComponent {

    private Card outerCard;
    private Markdown topTextBox;
    private VisualControl leftPanel;
    private VisualControl rightPanel;

    // Private constructor to prevent instantiation
    private MyCardComponent() {}

    /**
     * Creates a horizontal description card and appends it to a parent visual control.
     *
     * @param parent The parent visual control to which the card will be appended.
     * @param globalState The global state object containing configuration and state information.
     * @param markdownText The markdown text to be displayed in the top text box of the card.
     * @return An instance of MyCardComponent containing the created card and its components.
     */
    public static MyCardComponent addHorizontalDescriptionCard(VisualControl parent, StateData globalState, String markdownText) {
        MyCardComponent cd = new MyCardComponent();

        Card card = Card.appendTo(parent, globalState);
        card.setWidth(globalState, "99%");
        
        cd.outerCard = card;

        VStack vstack = VStack.appendTo(card, globalState);
        vstack.setBgColor(globalState, "theme.NavBar.bg");

        Card card2 = Card.appendTo(vstack, globalState);
        card2.setWidth(globalState, "90%").setBorderRadius(globalState, "50px");
        

        Markdown markdown = Markdown.appendTo(card2, globalState, Markdown.ControlsEnum.ALL, TextAlignEnum.LEFT);
        markdown.setWidth(globalState, "95%").setHeight(globalState, "100%");
        markdown.setText(globalState, markdownText);
        cd.topTextBox = markdown;

        HStack hstack = HStack.appendTo(card, globalState);
        hstack.setWidth(globalState, "100%");

        cd.leftPanel = VStack.appendTo(hstack, globalState);
        cd.leftPanel.setWidth(globalState, "50%");
        cd.rightPanel = VStack.appendTo(hstack, globalState);
        cd.rightPanel.setWidth(globalState, "50%");

        return cd;
    }

    // Public getter methods for class fields
    public Card getOuterCard() {
        return outerCard;
    }

    public Markdown getTopTextBox() {
        return topTextBox;
    }

    public VisualControl getLeftPanel() {
        return leftPanel;
    }

    public VisualControl getRightPanel() {
        return rightPanel;
    }
}

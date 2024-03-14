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


import com.gofintec.kewlui.KewlUI;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.settings.TextAlignEnum;
import com.gofintec.kewlui.controls.std.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Provides common functionality for all pages
 *
 * addExplanationPages adds markup description, the actual example, and a java code tab
 */
public class BasePage {

    protected boolean defaultIsOpen = true;


    public BasePage(boolean defaultOpen) {
        this.defaultIsOpen = defaultOpen;;
    }

    protected void addExplanationPages(VisualControl tparent, StateData state, String accordionName, String description, VisualControl theControl, String java )
    {
        addExplanationPages(tparent, state, accordionName, description, theControl, java, defaultIsOpen);
    }

    protected void addExplanationPages(VisualControl tparent, StateData state, String accordionName, String description, VisualControl theControl, String java, boolean isOpen )
    {
        var ac = SimpleAccordion.appendTo(tparent, state, accordionName);
        ac.setBgColor(state, "theme.colors.accent_40");
        ac.setDefaultOpen(state, isOpen);

        Markdown.appendTo(ac, state, description, Markdown.ControlsEnum.ALL);

        VStack vs = null;
        TabPanels tabPanels = null;
        String docs = getDocs(accordionName);

        // Set up the Tabs, general style etc
        if (java != null || docs != null) {

            var tabBar = Tabs.appendTo(ac, state);
            tabBar.setVariant(state, Tabs.VariantEnum.ENCLOSED);
            tabBar.setIsFitted(state, true);

            // create the list of Tab headers, can be any type of control
            var tabList = TabList.appendTo(tabBar, state);
            var ar = new ArrayList<String>(Arrays.asList("Description"));

            tabList.setSelectedBgColor(state, "theme.colors.secondary_20");
            tabList.setSelectedColor(state, "theme.colors.secondaryText_20");

            // create the list of Tab panels - must be in the same order as the tablist above...
            tabPanels = TabPanels.appendTo(tabBar, state);
            vs = VStack.appendTo(tabPanels,state);
            if (java !=null) {
                ar.add("Java");
                Markdown.appendTo(tabPanels, state, java, Markdown.ControlsEnum.ALL);
            }
            if (docs!=null) {
                ar.add("Docs");
                Markdown.appendTo(tabPanels, state, docs, Markdown.ControlsEnum.ALL);
            }
            tabList.setTabs(state, ar);  // simplest way to add tabs, otherwise just add children

        }
        else {
            vs = VStack.appendTo(ac, state);
        }

        vs.addChild(state,theControl);


    }

    private static ConcurrentHashMap<String,String> docs;

    private String getDocs (String name) {
        if (docs == null) {
            docs = new ConcurrentHashMap<>();
            InputStream resource = KewlUI.getResourceAsStream("static/docs/componentdocs.md");
            StringBuilder retData = new StringBuilder();
            boolean insideBlock = false;
            String lastName = null;

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("# ")) {
                        String l = line.substring(2).trim();
                        insideBlock = true;
                        if (lastName != null)
                            docs.put(lastName, retData.toString());
                        retData.setLength(0);
                        lastName=l;
                    } else if (insideBlock) {
                        retData.append(line).append("\n");
                    }
                }
                docs.put(lastName, retData.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return docs.get(name);
    }

    /**
     * Example Utility class to create card views for UI representation in applications.
     * This class is designed to generate a horizontal description card that includes
     * a top text section along with left and right panels for additional information.
     * The card's appearance and content are customizable through parameters.
     */
    public static class MyCardComponent {

        private Card outerCard;
        private Markdown topTextBox;
        private VisualControl descriptionPanel;
        private VisualControl codePanel;
        private VisualControl docPanel;



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

            cd.descriptionPanel = VStack.appendTo(hstack, globalState);
            cd.descriptionPanel.setWidth(globalState, "50%");
            cd.codePanel = VStack.appendTo(hstack, globalState);
            cd.codePanel.setWidth(globalState, "50%");
            cd.docPanel = VStack.appendTo(hstack, globalState);

            return cd;
        }

        // Public getter methods for class fields
        public Card getOuterCard() {
            return outerCard;
        }

        public Markdown getTopTextBox() {
            return topTextBox;
        }

        public VisualControl getDescriptionPanel () {
            return descriptionPanel;
        }

        public VisualControl getCodePanel () {
            return codePanel;
        }
    }
}

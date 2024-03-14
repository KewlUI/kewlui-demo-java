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

import java.util.Arrays;

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
        // Set up the Tabs, general style etc
        if (java != null) {
            var tabBar = Tabs.appendTo(ac, state);
            tabBar.setVariant(state, Tabs.VariantEnum.ENCLOSED);
            tabBar.setIsFitted(state, true);

            // create the list of Tab headers, can be any type of control
            var tabList = TabList.appendTo(tabBar, state);
            tabList.setTabs(state, Arrays.asList("Description", "Java"));  // simplest way to add tabs, otherwise just add children
            tabList.setBgColor(state, "blue.9 00");

            // create the list of Tab panels - must be in the same order as the tablist above...
            tabPanels = TabPanels.appendTo(tabBar, state);
            vs = VStack.appendTo(tabPanels,state);
        }
        else {
            vs = VStack.appendTo(ac, state);
        }


        vs.addChild(state,theControl);

        if (tabPanels != null)
            Markdown.appendTo(tabPanels,state,java, Markdown.ControlsEnum.ALL);
    }
}

package org.kewlui.demo.ui.TestApp.Pages.Examples;

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

import org.kewlui.demo.ui.TestApp.Forms.DashboardForm;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.builders.DraggableGridBuilder;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.charting.XYPoint;
import com.gofintec.kewlui.controls.base.settings.*;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Example page for some 'financial like realtime data'
 *
 * This shows an example of the draggable grid, positioning a number of test windows within it
 * Updating grouping tables and charts are included within the windows
 */
public class RealtimePage {
    private static final Logger Log = LogManager.getLogger(DashboardForm.class);

    public void addPage (VisualControl parent, StateData globalState) {

        parent.setOverflowY(globalState, OverflowEnum.HIDDEN);
        var vstack = VStack.appendTo(parent,globalState);

        addTopText( vstack, globalState);

        var gridWindow = DraggableGridBuilder.appendDraggableGridDefault(parent,globalState,20,30);

        var window = DraggableGridBuilder.appendWindow(gridWindow,globalState,"Grouping Table - large data table auto streamed from server, grouped/aggregated on client",0,0,12,10);
        AddGroupTable(globalState, window);

        int scaledWidthPixels = 600, scaledHeightPixels = 480;
        window =  DraggableGridBuilder.appendWindow(gridWindow,globalState,"Chart - client side SQL on realtime updating table" ,12,0,8,10);
        AddSqlChart(globalState,window);

        window = DraggableGridBuilder.appendWindow(gridWindow,globalState,"Draggable window - DRAG ME!" ,8,10,4,7);
        AddButtons(globalState, window);

        window = DraggableGridBuilder.appendWindow(gridWindow,globalState,"Zoomable chart example" ,0,10,8,13);
        AddCandleChart(globalState, window);
    }

    // Add a text card to the top of the window, giving a quick description of the page
    protected void addTopText(VisualControl vstack, StateData globalState) {
        ///////////////
        var card = BorderCard.appendTo(vstack,globalState);
        card.setMaxWidth(globalState,"1200px");
        card.setWidth(globalState,"95%");
        card.setBgGradient(globalState, "linear-gradient(to right, var(--theme-colors-primary_80), var(--theme-colors-primary_10))");

        card.setVariant(globalState, "simpleDropShadow").setBgColor(globalState,"theme.colors.page").setBorderRadius(globalState,"6px");

        var mobileDisclaimer = Markdown.appendTo(card,globalState, "***( Note: KewlUI excels on full-screen browsers. Mobile viewing may not be optimal)***");
        mobileDisclaimer.setClientSidePreRender(globalState, """
                return params.mobile; // when mobile==false, we return false, which hides the control                
                """);

        var text = """
## 100% Server Side creation of Web Applications 

- Write Java to create complex interfaces. Future support for C# and C++ backends.

- Web front-end automatically created by and synced with server side code.

- See Examples and Components pages on left.  Try different themes in top right of page.

- This realtime Finance example Page uses a GridWindow control to demonstrate multiple moveable windows, some with server->client updating values.  
""";
        var md = Markdown.appendTo(card,globalState, text);
        md.setFontSize(globalState, "md").setTextAlign(globalState, TextAlignEnum.JUSTIFY);

    }


    protected void AddButtons(StateData state, VisualControl flex) {

        var bb = Box.appendTo(flex,state);

        var stack = VStack.appendTo(bb, state);
        stack.setAlignItems(state,AlignItemsEnum.CENTER).setTextAlign(state, TextAlignEnum.CENTER);
        Text.appendTo(stack,state, "Showcase some 'bling' controls");

        var line1 = HStack.appendTo(stack, state);
        line1.setWidth(state,"").setAlignSelf(state, AlignItemsEnum.CENTER);
        Text.appendTo(line1, state, "Custom Control:");
        var toggleBox = AnimationBox.appendTo(line1, state); // AnimationBox holds graphics, with another invisible control on top
        toggleBox.setSrc(state, "{urlBase}/images/dayslider.json");
        toggleBox.setValue(state, false); // animation stuck at off
        toggleBox.setOpacity(state, 0); // the children (hiddenButton) bellow must be invisible
        toggleBox.setWidth(state, "50px").setHeight(state, "30px");
        toggleBox.setZoomLevel(state, 2.2); // make the animated control larger within its box
        toggleBox.setTranslateX(state,0.0).setTranslateY(state,0.0); // put here for illustrative purposes
        toggleBox.setTooltip(state, "Custom graphical controls can be built");
        var valueText = Text.appendTo(line1, state, "value is false");

        // allow clicking on control to change the value on the clients view
        toggleBox.setOnClick(state, (e)-> {
            var value = (Boolean) toggleBox.getValue(e.clientState());
            value = !value;
            toggleBox.setValue(e.clientState(), value);
            valueText.setText(e.clientState(),"value is "+value);
        });
    
        var b = Button.appendTo(stack, state, "Button - press me", SizeEnum.LG);
        b.setWidth(state, "95%");
        b.setBorderEffects(state, "cyberpunk");
        b.setTooltip(state, "Controls/Containers can have effects applied to them, such as this glow border");

        // please note that the callbacks clientState can/will be different to the components default/global state
        b.setOnClick(state, (event)->{
            var counter = event.clientState().getOurUserData("counter", ()->new AtomicLong());
            b.setText(event.clientState(), "Server reply: "+counter.incrementAndGet());
        });
    }

    private void AddGroupTable (StateData state, VisualControl parent) {
        var groupingTable = TablePlus.appendTo(parent,state);
        groupingTable.setHeight(state, "100%").setWidth(state,"100%");
        groupingTable.setGrouping(state,  Arrays.asList("symbol","tenor"));
        groupingTable.setDataSource(state, "testRiskTable");
        //groupingTable.setIdField(state, "id").setSeqNumField(state, "seqNum").setDeleteField(state, "deleteTime"); // these are default values anyway
    }

    private void AddSqlChart(StateData state, VisualControl parent) {

        var box = VStack.appendTo(parent,state);

        // Style 1, comma separated list of options
        var hs = HStack.appendTo(box, state);
        Text.appendTo(hs, state, "Chart type: ");
        var select = Select.appendTo(hs, state,"LineBasic,LineSmooth,LineStep,AreaBasic,AreaSmooth,AreaStep,AreaStacked", DefaultValue.set("LineBasic"), ColorSchemeEnum.GREEN);
        select.setBgColor(state, "lightblue");
        select.setTooltip(state, "Select chart type");
        select.setWidth(state,"300px");

        Text.appendTo(box,state, "Charts - Client side sql on a realtime updating table")
                .setTooltip(state, "select symbol as label, sum(delta) as [Delta], sum(gamma) as [Gamma], sum(vega) as [Vega], sum (theta) as [Theta], sum(rho) as [Rho] from testRiskTable group by symbol");

        var chart1 = Chart.appendTo(box,state, "SQL and realtime updating");

        chart1.setVariant(state, (String) select.getValue(state));

        chart1.setSql(state, "select symbol as label, sum(delta) as [Delta], sum(gamma) as [Gamma], sum(vega) as [Vega], sum (theta) as [Theta], sum(rho) as [Rho] from testRiskTable group by symbol");

        // labels and sql should give us enough information to update the chart
        chart1.setWatch(state, Arrays.asList("testRiskTable")); // update on change to testRiskTable
        chart1.setDataLabelsEnabled(state, false);
        chart1.setYTitle(state,"Dollar Risk");
        chart1.setYAxisFormat(state,"%.0f");
        chart1.setMaxUpdateMs(state, 5000); // only update the chart every 5 seconds
        final Chart chart = chart1;

        // allow changing of the type of chart
        select.setOnChange(state, (e)->{
            chart.setVariant(e.clientState(), (String) select.getValue(e.clientState()));
        });
    }

    private void AddCandleChart(StateData state, VisualControl parent) {
        var vs = Box.appendTo(parent, state);
        vs.setHeight(state,"100%").setMinHeight(state, "100%");

        var txt = Text.appendTo(vs, state, "Candle Chart");

        var close = 6629.81;        // generate some example data
        var data = new ArrayList<XYPoint<Double>>();
        for (long dateMs = 1538778600000L; dateMs < 1539778600000L; dateMs += (1000 * 60 * 5)) {
            var open = close;
            close = close + ((Math.random() - 0.5) * (close * 0.02));
            var high = Math.max(open, close);
            high += ((Math.random()) * (high * 0.01));
            var low = Math.min(open, close);
            low -= ((Math.random()) * (high * 0.01));
            XYPoint p = new XYPoint(dateMs, open, high, low, close);
            data.add(p);
        }

        var chart = Chart.appendTo(vs, state);

        chart.setVariant(state, Chart.VariantEnum.CANDLESTICK);
        chart.setValue(state, data);
    }

}

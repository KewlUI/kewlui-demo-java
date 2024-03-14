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


import com.gofintec.app.ui.TestApp.Forms.DashboardForm;
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
        vstack.setBgColor(globalState, "theme.colors.pageBgColor");

        addTopText( vstack, globalState);

        var gridWindow = DraggableGridBuilder.appendDraggableGridDefault(parent,globalState,20,30);
        gridWindow.setBgColor(globalState,"#f0f0f0");


        var window = DraggableGridBuilder.appendWindow(gridWindow,globalState,"Grouping Table - data auto streamed from server and grouped on client",0,0,12,14);
        AddGroupTable(globalState, window);

        window =  DraggableGridBuilder.appendWindow(gridWindow,globalState,"Chart - client side SQL on realtime updating table" ,12,0,8,13);
        AddSqlChart(globalState,window);

        window = DraggableGridBuilder.appendWindow(gridWindow,globalState,"Draggable window - DRAG ME!" ,16,14,4,3);
        AddButtons(globalState, window);

        window = DraggableGridBuilder.appendWindow(gridWindow,globalState,"Zoomable chart example" ,0,14,8,12);
        AddCandleChart(globalState, window);
    }

    // Add a text card to the top of the window, giving a quick description of the page
    protected void addTopText(VisualControl vstack, StateData globalState) {
        ///////////////
        var card = Card.appendTo(vstack,globalState);
        card.setWidth(globalState,"90%");
        card.setBgColor(globalState, "theme.colors.cardBgColor");

        var mobileDisclaimer = Markdown.appendTo(card,globalState, "***( Note: KewlUI excels on full-screen browsers. Mobile viewing may not be optimal)***");
        mobileDisclaimer.setClientSidePreRender(globalState, """
                // hide mobile disclaimer if not mobile, returning false hides the control
                return params.mobile;                
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


    protected void AddButtons(StateData self, VisualControl flex) {
        var box = Box.appendTo(flex, self);
        box.setCenterContent(self, true);

        var b = Button.appendTo(box, self, "Button - press me", SizeEnum.LG);
        b.setTooltip(self, "OnClick: Client sends a message to the server,\n server replies with updates");

        // please note that the callbacks clientState can/will be different to the components default/global state
        b.setOnClick(self, (eventName, clientContext, control, clientState, event)->{
            var counter = clientState.getOurUserData("counter", ()->new AtomicLong());

            b.setText(clientState, "Server reply: "+counter.incrementAndGet());
            Log.info("Received click event!!!");
        });
    }

    private void AddGroupTable (StateData state, VisualControl parent) {
        var gridTable = GroupTable.appendTo(parent,state);
        gridTable.setMaxHeight(state,"100%").setWidth(state,"100%");

        gridTable.setTableName(state, "testRiskTable"); // source data from this data table
        gridTable.setGrouping(state, Arrays.asList("symbol","tenor")); // set default data source

        gridTable.setMaxUpdateRateMs(state, 1000);
        gridTable.setMinUpdateRateMs(state, 10000); // force update every 10 seconds if no data inputs
    }

    private void AddSqlChart(StateData state, VisualControl parent) {
        var box = VStack.appendTo(parent,state);
        box.setWidth(state,"100%").setHeight(state,"100%");
        box.setBorder(state,"1px solid black").setBorderRadius(state,"5px");


        // Style 1, comma separated list of options
        var hs = HStack.appendTo(box, state);
        Text.appendTo(hs, state, "Chart type: ");
        var select = Select.appendTo(hs, state,"LineBasic,LineSmooth,LineStep,AreaBasic,AreaSmooth,AreaStep,AreaStacked", DefaultValue.set("LineBasic"), ColorSchemeEnum.GREEN);
        select.setBgColor(state, "lightblue").setJustifyContent(state, JustifyContentEnum.CENTER);
        select.setTooltip(state, "Select chart type");
        select.setWidth(state,"50%");

        Text.appendTo(box,state, "Charts - Client side sql on a realtime updating table")
                .setTooltip(state, "select symbol as label, sum(delta) as [Delta], sum(gamma) as [Gamma], sum(vega) as [Vega], sum (theta) as [Theta], sum(rho) as [Rho] from testRiskTable group by symbol");

        var chart1 = Chart.appendTo(box,state, "SQL and realtime updating");
        chart1.setWidth(state,"575px");
        chart1.setVariant(state, (String) select.getValue(state));
        //chart1.setLabels(state,Arrays.asList("Delta", "Gamma", "Vega", "Theta", "Rho"));
        chart1.setSql(state, "select symbol as label, sum(delta) as [Delta], sum(gamma) as [Gamma], sum(vega) as [Vega], sum (theta) as [Theta], sum(rho) as [Rho] from testRiskTable group by symbol");

        // labels and sql should give us enough information to update the chart
        chart1.setWatch(state, Arrays.asList("testRiskTable")); // update on change to testRiskTable
        chart1.setDataLabelsEnabled(state, false);
        chart1.setYTitle(state,"Dollar Risk");
        chart1.setYAxisFormat(state,"%.0f");
        chart1.setMaxUpdateMs(state, 5000); // only update the chart every 5 seconds
        final Chart chart = chart1;

        // allow changing of the type of chart
        select.setOnChange(state, (eventName, context,  control,  clientstate,  event)->{
            chart.setVariant(state, (String) control.getValue(clientstate));
        });
    }

    private void AddCandleChart(StateData state, VisualControl parent) {
        var vs = Box.appendTo(parent, state);
        vs.setBorder(state,"2px solid black");
        vs.setHeight(state,"100%");

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



    protected static VisualControl createWindow(VisualControl parent, StateData globalState, String title, int x, int y, int w, int h) {
        var window = GridWindow.appendTo(parent,globalState, title);
        window.setHeight(globalState,h).setWidth(globalState,w).setX(globalState,x).setY(globalState,y);
        window.setBorder(globalState,"2px solid black").setBorderRadius(globalState,"5px");

        var box = Box.appendTo(window,globalState);
        //box.setWidth(globalState,"100%").setHeight(globalState,"100%");
        box.setBgColor(globalState, "theme.colors.cardBgColor").setColor(globalState, "theme.colors.cardColor");
        box.setBorderRadius(globalState, "md");
        box.setOverflowY(globalState, OverflowEnum.AUTO);

        return box;
    }
}

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
import com.gofintec.kewlui.controls.base.charting.XYPoint;
import com.gofintec.kewlui.controls.base.settings.AlignItemsEnum;
import com.gofintec.kewlui.controls.base.settings.ColorSchemeEnum;
import com.gofintec.kewlui.controls.base.settings.DefaultValue;
import com.gofintec.kewlui.controls.base.settings.JustifyContentEnum;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Chart example page - shows a number of examples of charting, along with source code on how to achieve it
 *
 */
public class ChartPage extends BasePage
{
    private static final Logger Log = LogManager.getLogger(ContainerPage.class);

    public ChartPage() {
        super(true);
    }

    public void AddChartOverview (VisualControl parent, StateData state)
    {
        VStack vs = VStack.appendTo(parent,state);

        String chartMarkup = """
# Charts

The chart control allows visualisation of data across multiple dimensions.

A Number of chart types are available:

 - LineBasic / LineSmooth/ LineStep
 - BarBasic / BarsChiseled / BarStep
 - AreaBasic / AreaSmooth / AreaStep / AreaStacked
 - ColumnBasic / Column100 / ColumnProfitLoss /  
 - RangeArea 
 - CandleStick

More are coming soon...


""";
        Markdown.appendTo(vs, state,chartMarkup, Markdown.ControlsEnum.NONE);

        add2dChartExamples(vs, state);
        AddTimelineExample(vs, state);
        AddCandlesExample(vs, state);
        AddRangeArea(vs, state);
        AddPieDonut(vs, state);
        AddSparkline(vs, state);

        addChartExamples(vs, state);
        AddSqlXyExample(vs, state);
        addDataSources(vs, state);

        String markdownDescription = """
### Other controls

Other controls have been implemented, and will be added to the control showcase in the future.
""";
        Markdown.appendTo(vs,state,markdownDescription, Markdown.ControlsEnum.NONE);
    }



    private void addDataSources(VStack parent, StateData globalState) {
        String markdownDescription = """
## Data sources

Charts use a client side sql engine that can pull data from different sources via SQL:

1 A server->client synchronised table, e.g. server data that is updating in real time
2 Client side table, for example created with a sql query from a remote URL
3 Directly from a remote URL

Remember to use a watch on a datatable, so the chart will be auto updated as data arrives
 
<hr>

## SQL

- fully functional compact sql server with JOINs, GROUPs, UNIONs, ANY, ALL, IN, subqueries
- ROLLUP(), CUBE() and GROUPING SETS() functions
- Allows reading of URLs in CSV, TAB, JSON

### CSV

select * from CSV(\"https://media.githubusercontent.com/media/datablist/sample-csv-files/main/files/organizations/organizations-100.csv\", {headers:true})

### TAB

select * from TSV("https://raw.githubusercontent.com/tyarkoni/PPS2016/0847fe70951d7d00843166d4418f25eb4b8d77ce/data/diabetes.tab.txt", {headers:true})

### TXT

get a list of lines from a file, order by line length:
select [0] as line from TXT(\"https://raw.githubusercontent.com/jjgod/vim-cocoa/master/README.txt\") order by LEN([0])

### JSON

Let's get some stats from reddit r/funny, max 100, where data is extracted from subnodes

```sql
WITH JsonSubData as (
    select data->children->data from JSON("https://www.reddit.com/r/funny.json") where quarantine=false LIMIT 100  
)
select upvote_ratio, URL from JsonSubData

```

""";
        var vs = new VStack(globalState);
        vs.setAlignItems(globalState, AlignItemsEnum.FLEX_START);

        var sqlQuery = "select * from CSV(\"https://datahub.io/core/gdp/r/gdp.csv\", {headers:true}) where upper([Country Name]) like 'U%'";
        var dataTable = DbTable.appendTo(parent, globalState);
        dataTable.setTableName(globalState,"gdpTable");
        dataTable.setColumnIndexes(globalState, Arrays.asList("symbol","name"));

        dataTable.setDataSql(globalState, sqlQuery );
        dataTable.setReloadMs(globalState,1000*60*10); // every 10 minutes, reload the url, update dependent controls

        // allow the user to edit the query
        var ed = Editable.appendTo(vs,globalState);
        // if someone updates the sql query, update the table
        ed.setValue(globalState,sqlQuery).setOnChange(globalState,  (eventName, clientContext, control, clientState, event) -> {
            dataTable.setDataSql(clientState, ed.getValue(clientState));

        });

        ;

        String java = """
###Example Java code: \n\n
```java
        var sqlQuery = "select * from CSV(\\"https://datahub.io/core/gdp/r/gdp.csv\\", {headers:true}) where upper([Country Name]) like 'U%'";
        var dataTable = DbTable.appendTo(parent, globalState);
        dataTable.setTableName(globalState,"gdpTable");
        dataTable.setColumnIndexes(globalState, Arrays.asList("symbol","name"));

        dataTable.setDataSql(globalState, sqlQuery );
        dataTable.setReloadMs(globalState,1000*60*10); // every 10 minutes, reload the url, update dependent controls

        // allow the user to edit the query
        var ed = Editable.appendTo(vs,globalState);
        // if someone updates the sql query, update the table
        ed.setValue(globalState,sqlQuery).setOnChange(globalState,  (eventName, clientContext, control, clientState, event) -> {
            dataTable.setDataSql(clientState, ed.getValue(clientState));
        });
```
""";

        addExplanationPages(parent, globalState, "SQL Data Sources", markdownDescription, vs, java, false);
    }


    private void add2dChartExamples(VStack parent, StateData state) {
        String markdownDescription = """
### Charts - Explicitly set data - 2d, array of arrays

Charts can be given values explicitly using the setValue function - either a single array or array of arrays

When 2d (array of arrays) are given, labels are required to describe each array.
With a 1d array (or the inner array of a 2d), each point should match a legend name. 

Use the chart selector to switch between charts.
""";
        var vs = new AutoWrap(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);

        int[][] array2D = {
                {44, 55, 57, 56, 61, 58, 63, 60, 66},    // 'Net Profit'
                {76, 85, 101, 98, 87, 105, 91, 114, 94}, // 'Revenue'
                {35, 41, 36, 26, 45, 48, 52, 53, 41}     // 'Free Cash Flow'
        };
        List<String> labels = Arrays.asList("Net Profit", "Revenue", "Free Cash Flow");
        List<String> fieldNames = Arrays.asList("Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct");

        var box = VStack.appendTo(vs, state);

        var select = Select.appendTo(box, state,"BarsBasicVertical,BarsChiseledVertical,BarsStackedVertical,BarsStacked100Vertical,BarsProfitLossVertical,LineBasic,LineSmooth,LineStep,AreaBasic,AreaSmooth,AreaStep,AreaStacked,BarsBasicHorizontal,BarsChiseledHorizontal,BarsStackedHorizontal,BarsStacked100Horizontal",
                DefaultValue.set("BarsBasicVertical"), ColorSchemeEnum.GREEN);
        select.setBgColor(state, "lightblue").setJustifyContent(state, JustifyContentEnum.CENTER);
        select.setTooltip(state, "Select chart type");
        select.setWidth(state,"50%");

        Text.appendTo(box,state, "Charts - 2d Data example");

        var chart1 = Chart.appendTo(box,state, "Chart, 2d Data");
        chart1.setWidth(state,"575px");
        chart1.setVariant(state, (String) select.getValue(state));
        chart1.setDataLabelsEnabled(state, false); // don't show the labels on the data itself
        chart1.setYTitle(state,"$ (thousands)");
        //chart1.setYAxisFormat(state,"$%.0f");

        chart1.setLabels(state, labels);
        chart1.setValue(state, array2D);
        chart1.setFieldNames(state, fieldNames);

        select.setOnChange(state, (eventName, clientContext, control, clientState, event) -> {
            chart1.setVariant(clientState, (String) select.getValue(clientState));
        });

        String java = """
###Example Java code: \n\n
```java
        int[][] array2D = {
                {44, 55, 57, 56, 61, 58, 63, 60, 66},    // 'Net Profit'
                {76, 85, 101, 98, 87, 105, 91, 114, 94}, // 'Revenue'
                {35, 41, 36, 26, 45, 48, 52, 53, 41}     // 'Free Cash Flow'
        };
        List<String> labels = Arrays.asList("Net Profit", "Revenue", "Free Cash Flow");
        List<String> fieldNames = Arrays.asList("Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct");

        var box = VStack.appendTo(vs, state);

        var select = Select.appendTo(box, state,"BarsBasicVertical,BarsChiseledVertical,BarsStackedVertical,BarsStacked100Vertical,BarsProfitLossVertical,LineBasic,LineSmooth,LineStep,AreaBasic,AreaSmooth,AreaStep,AreaStacked,BarsBasicHorizontal,BarsChiseledHorizontal,BarsStackedHorizontal,BarsStacked100Horizontal",
                DefaultValue.set("BarsBasicVertical"), ColorSchemeEnum.GREEN);
        select.setBgColor(state, "lightblue").setJustifyContent(state, JustifyContentEnum.CENTER);
        select.setTooltip(state, "Select chart type");
        select.setWidth(state,"50%");

        Text.appendTo(box,state, "Charts - 2d Data example");

        var chart1 = Chart.appendTo(box,state, "Chart, 2d Data");
        chart1.setWidth(state,"575px");
        chart1.setVariant(state, (String) select.getValue(state));
        chart1.setDataLabelsEnabled(state, false); // don't show the labels on the data itself
        chart1.setYTitle(state,"$ (thousands)");
        //chart1.setYAxisFormat(state,"$%.0f");

        chart1.setLabels(state, labels);
        chart1.setValue(state, array2D);
        chart1.setFieldNames(state, fieldNames);

        select.setOnChange(state, (eventName, clientContext, control, clientState, event) -> {
            chart1.setVariant(clientState, (String) select.getValue(clientState));
        });
```
""";

        addExplanationPages(parent, state, "Chart- Explicitly Set Data - 2d array", markdownDescription, vs, java);
    }


    private void addChartExamples(VStack parent, StateData state) {
        String markdownDescription = """
### Charts - Explicitly set data - list of objects/dictionary

Charts can be given values explicitly using the setValue function, in this case a list of dictionaries/objects 

When giving a list of objects/dictionary, labels are required to describe each object.  
The label can either be given seperately (via labels array), or by adding a "label" field within the object.

Note:  There is a special case when objects contain only "label","x","y" fields - in this case, these are assumed to be category point data.
This is useful in Timeline charts, OHLC charts, etc
 

Use the chart selector to switch between charts.
""";
        var vs = new AutoWrap(state);
        vs.setAlignItems(state, AlignItemsEnum.FLEX_START);
        List<HashMap<String,Object>> array2D = new ArrayList<HashMap<String,Object>>() {{
            add(new HashMap<String, Object>() {{
                put("label", "Net Profit");
                put("Feb", 44);
                put("Mar", 55);
                put("Apr", 57);
                put("May", 56);
                put("Jun", 61);
                put("Jul", 58);
                put("Aug", 63);
                put("Sep", 60);
                put("Oct", 66);
            }});
            add(new HashMap<String, Object>() {{
                put("label", "Revenue");
                put("Feb", 76);
                put("Mar", 85);
                put("Apr", 101);
                put("May", 98);
                put("Jun", 87);
                put("Jul", 105);
                put("Aug", 63);
                put("Sep", 60);
                put("Oct", 66);
        }});
        }};

        var box = VStack.appendTo(vs, state);

        var select = Select.appendTo(box, state,"BarsBasicVertical,BarsChiseledVertical,BarsStackedVertical,BarsStacked100Vertical,BarsProfitLossVertical,LineBasic,LineSmooth,LineStep,AreaBasic,AreaSmooth,AreaStep,AreaStacked,BarsBasicHorizontal,BarsChiseledHorizontal,BarsStackedHorizontal,BarsStacked100Horizontal",
                DefaultValue.set("BarsBasicVertical"), ColorSchemeEnum.GREEN);
        select.setBgColor(state, "lightblue").setJustifyContent(state, JustifyContentEnum.CENTER);
        select.setTooltip(state, "Select chart type");
        select.setWidth(state,"50%");

        Text.appendTo(box,state, "Charts - 2d Data example");

        var chart1 = Chart.appendTo(box,state, "Chart, 2d Data");
        chart1.setWidth(state,"575px");
        chart1.setVariant(state, (String) select.getValue(state));
        chart1.setDataLabelsEnabled(state, false); // don't show the labels on the data itself
        chart1.setYTitle(state,"$ (thousands)");
        //chart1.setYAxisFormat(state,"$%.0f");

        chart1.setValue(state, array2D);

        select.setOnChange(state, (eventName, clientContext, control, clientState, event) -> {
            chart1.setVariant(clientState, (String) select.getValue(clientState));
        });

        String java = """
###Example Java code: \n\n
```java
        List<HashMap<String,Object>> array2D = new ArrayList<HashMap<String,Object>>() {{
            add(new HashMap<String, Object>() {{
                put("label", "Net Profit");
                put("Feb", 44);
                put("Mar", 55);
                put("Apr", 57);
                put("May", 56);
                put("Jun", 61);
                put("Jul", 58);
                put("Aug", 63);
                put("Sep", 60);
                put("Oct", 66);
            }});
            add(new HashMap<String, Object>() {{
                put("label", "Revenue");
                put("Feb", 76);
                put("Mar", 85);
                put("Apr", 101);
                put("May", 98);
                put("Jun", 87);
                put("Jul", 105);
                put("Aug", 63);
                put("Sep", 60);
                put("Oct", 66);
        }});
        }};

        var box = VStack.appendTo(vs, state);

        var select = Select.appendTo(box, state,"BarsBasicVertical,BarsChiseledVertical,BarsStackedVertical,BarsStacked100Vertical,BarsProfitLossVertical,LineBasic,LineSmooth,LineStep,AreaBasic,AreaSmooth,AreaStep,AreaStacked,BarsBasicHorizontal,BarsChiseledHorizontal,BarsStackedHorizontal,BarsStacked100Horizontal",
                DefaultValue.set("BarsBasicVertical"), ColorSchemeEnum.GREEN);
        select.setBgColor(state, "lightblue").setJustifyContent(state, JustifyContentEnum.CENTER);
        select.setTooltip(state, "Select chart type");
        select.setWidth(state,"50%");

        Text.appendTo(box,state, "Charts - 2d Data example");

        var chart1 = Chart.appendTo(box,state, "Chart, 2d Data");
        chart1.setWidth(state,"575px");
        chart1.setVariant(state, (String) select.getValue(state));
        chart1.setDataLabelsEnabled(state, false); // don't show the labels on the data itself
        chart1.setYTitle(state,"$ (thousands)");
        //chart1.setYAxisFormat(state,"$%.0f");

        chart1.setValue(state, array2D);

        select.setOnChange(state, (eventName, clientContext, control, clientState, event) -> {
            chart1.setVariant(clientState, (String) select.getValue(clientState));
        });
```
""";

        addExplanationPages(parent, state, "Chart- Explicitly Set Data - List of objects", markdownDescription, vs, java);
    }

    private void AddSqlXyExample (VisualControl parent, StateData state) {

        String markdownDescription = """
## Charts - Sql from remote URL, XY points

Each chart  can use SQL to read from a remote URL (CSV, JSON, XML, etc). 

### Example

We load GDP information from a URL, which contains CSV data

In this example, the sql will feed an array of objects (containing x,y fields) to the chart.

select [Country Name] as label, [Year] as x, [Value] as y  from CSV('https://pkgstore.datahub.io/core/gdp/gdp_csv/data/0048bc8f6228d0393d41cac4b663b90f/gdp_csv.csv', {headers:true}) where [Country Name] like '%United%'


Note that it is good form to surround column names with square brackets in the sql, e.g. [Country Name], [Value] 

Use the chart selector to switch between charts.
""";
        var vs = new AutoWrap(state);

        var box = VStack.appendTo(vs,state);
        box.setWidth(state,"100%").setHeight(state,"100%");
        box.setBorder(state,"1px solid black").setBorderRadius(state,"5px");

        // Style 1, comma separated list of options
        var select = Select.appendTo(box, state,"BarsBasicVertical,BarsChiseledVertical,BarsStackedVertical,BarsStacked100Vertical,BarsProfitLossVertical,LineBasic,LineSmooth,LineStep,AreaBasic,AreaSmooth,AreaStep,AreaStacked,BarsBasicHorizontal,BarsChiseledHorizontal,BarsStackedHorizontal,BarsStacked100Horizontal",
                DefaultValue.set("LineBasic"), ColorSchemeEnum.BLUE);
        select.setBgColor(state, "lightblue").setJustifyContent(state, JustifyContentEnum.CENTER);
        select.setTooltip(state, "Select chart type");
        select.setWidth(state,"50%");

        Text.appendTo(box,state, "Example 2, list of objects containing label, x and y values");

        var chart1 = Chart.appendTo(box,state, "Chart, GDP Data");
        chart1.setWidth(state,"575px");
        chart1.setVariant(state, (String) select.getValue(state));
        chart1.setSql(state, "select [Country Name] as label, [Year] as x, [Value] as y from CSV('https://pkgstore.datahub.io/core/gdp/gdp_csv/data/0048bc8f6228d0393d41cac4b663b90f/gdp_csv.csv', {headers:true}) where [Country Name] like '%United%' and Year > 2000");

        // labels and sql should give us enough information to update the chart
        chart1.setDataLabelsEnabled(state, false);
        chart1.setYTitle(state,"GDP");
        chart1.setYAxisFormat(state,"%.0f");
        chart1.setMaxUpdateMs(state, 5000); // only update the chart every 5 seconds
        final Chart chart = chart1;
        // allow changing of the type of chart
        select.setOnChange(state, ( eventName, context, control, clientstate, event)->{
            chart.setVariant(state, (String) control.getValue(clientstate));
        });

        String java = """
###Example Java code: \n\n
```java
 var box = VStack.appendTo(vs,state);
        box.setWidth(state,"100%").setHeight(state,"100%");
        box.setBorder(state,"1px solid black").setBorderRadius(state,"5px");

        // Style 1, comma separated list of options
        var select = Select.appendTo(box, state,"BarsBasicVertical,BarsChiseledVertical,BarsStackedVertical,BarsStacked100Vertical,BarsProfitLossVertical,LineBasic,LineSmooth,LineStep,AreaBasic,AreaSmooth,AreaStep,AreaStacked,BarsBasicHorizontal,BarsChiseledHorizontal,BarsStackedHorizontal,BarsStacked100Horizontal",
                DefaultValue.set("LineBasic"), ColorSchemeEnum.BLUE);
        select.setBgColor(state, "lightblue").setJustifyContent(state, JustifyContentEnum.CENTER);
        select.setTooltip(state, "Select chart type");
        select.setWidth(state,"50%");

        Text.appendTo(box,state, "Example 2, list of objects containing label, x and y values");

        var chart1 = Chart.appendTo(box,state, "Chart, GBP Data");
        chart1.setWidth(state,"575px");
        chart1.setVariant(state, (String) select.getValue(state));
        chart1.setSql(state, "select [Country Name] as label, [Year] as x, [Value] as y from CSV('https://pkgstore.datahub.io/core/gdp/gdp_csv/data/0048bc8f6228d0393d41cac4b663b90f/gdp_csv.csv', {headers:true}) where [Country Name] like '%United%' and Year > 2000");

        // labels and sql should give us enough information to update the chart
        chart1.setDataLabelsEnabled(state, false);
        chart1.setYTitle(state,"GDP");
        chart1.setYAxisFormat(state,"$%.0f");
        chart1.setMaxUpdateMs(state, 5000); // only update the chart every 5 seconds
        final Chart chart = chart1;
        // allow changing of the type of chart
        select.setOnChange(state, (String eventName, Control control, StateData clientstate, Event event)->{
            chart.setVariant(state, (String) control.getValue(clientstate));
        });
```
""";
        addExplanationPages(parent, state, "Chart- SQL on URL, XY data", markdownDescription, vs, java);
    }

    private void AddTimelineExample (VisualControl parent, StateData state) {

        String markdownDescription = """
## Charts - Timelines

Here we  use setValue to allocate a list of dictionaries/objects to the chart

The fields:
- label - optional category label
- x - date
- y - an array, containing start and end times (long int format)
- fillColor: optional fill color of the bars

""";
        var vs = new AutoWrap(state);

        var box = VStack.appendTo(vs,state);
        box.setWidth(state,"100%").setHeight(state,"100%");
        box.setBorder(state,"1px solid black").setBorderRadius(state,"5px");

        List<Map<String, Object>> data = Arrays.asList(
                createDataItem("Analysis", "2019-02-27", "2019-03-04", "#008FFB"),
                createDataItem("Design", "2019-03-04", "2019-03-08", "#00E396"),
                createDataItem("Coding", "2019-03-07", "2019-03-10", "#775DD0"),
                createDataItem("Testing", "2019-03-08", "2019-03-12", "#FEB019"),
                createDataItem("Deployment", "2019-03-12", "2019-03-17", "#FF4560")
        );
        var chart1 = Chart.appendTo(box,state, "Chart, Timelines");
        chart1.setWidth(state,"600px");
        chart1.setVariant(state, Chart.VariantEnum.TIMELINE);
        chart1.setValue(state, data);

        String java = """
###Example Java code: \n\n
```java

        List<Map<String, Object>> data = Arrays.asList(
                createDataItem("Analysis", "2019-02-27", "2019-03-04", "#008FFB"),
                createDataItem("Design", "2019-03-04", "2019-03-08", "#00E396"),
                createDataItem("Coding", "2019-03-07", "2019-03-10", "#775DD0"),
                createDataItem("Testing", "2019-03-08", "2019-03-12", "#FEB019"),
                createDataItem("Deployment", "2019-03-12", "2019-03-17", "#FF4560")
        );
        var chart1 = Chart.appendTo(box,state, "Chart, Timelines");
        chart1.setWidth(state,"600px");
        chart1.setVariant(state, Chart.VariantEnum.TIMELINE);
        chart1.setValue(state, data);

private static Map<String, Object> createDataItem(String x, String startDate, String endDate, String fillColor) {
        try {
            Map<String, Object> item = new HashMap<>();
            item.put("x", x);
            item.put("y", Arrays.asList(sdf.parse(startDate).getTime(), sdf.parse(endDate).getTime()));
            item.put("fillColor", fillColor);
            return item;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
```
""";
        addExplanationPages(parent, state, "Chart- Timelines", markdownDescription, vs, java, true);
    }

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static Map<String, Object> createDataItem(String x, String startDate, String endDate, String fillColor) {
        try {
            Map<String, Object> item = new HashMap<>();
            item.put("x", x);
            item.put("y", Arrays.asList(sdf.parse(startDate).getTime(), sdf.parse(endDate).getTime()));
            item.put("fillColor", fillColor);
            return item;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void AddCandlesExample (VisualControl parent, StateData state) {

        var vs = new VStack(state);

        String markdownDescription = """
## Charts - Candles

A candle chart is populated with x,y data, with x being the date (in long format)
The fields:
- x - date in long format
- y - array containing open, high, low and close values
- fillColor: optional fill color of the bars
""";

        var txt = Text.appendTo(vs, state, "Candle Chart - Zoomable");

        var close = 6629.81;        // generate some example data
        var data = new ArrayList<XYPoint<Double>>();
        for (long dateMs = 1538778600000L;  dateMs < 1539778600000L; dateMs+=(1000*60*5)) {
            var open = close;
            close= close +    ((Math.random()-0.5) * (close*0.02));
            var high = Math.max(open,close);
            high +=  ((Math.random()) * (high*0.01));
            var low = Math.min(open,close);
            low -=  ((Math.random()) * (high*0.01));
            XYPoint p = new XYPoint(dateMs, open,high,low,close);
            data.add(p);
        }

        var chart = Chart.appendTo(vs,state);
        chart.setWidth(state,"600px");
        chart.setVariant(state, Chart.VariantEnum.CANDLESTICK);
        chart.setValue(state, data);

        String java = """
###Example Java code: \n\n
```java
        var close = 6629.81;        // generate some example data
        var data = new ArrayList<XYPoint<Double>>();
        for (long dateMs = 1538778600000L;  dateMs < 1539778600000L; dateMs+=(1000*60*5)) {
            var open = close;
            close= close +    ((Math.random()-0.5) * (close*0.02));
            var high = Math.max(open,close);
            high +=  ((Math.random()) * (high*0.01));
            var low = Math.min(open,close);
            low -=  ((Math.random()) * (high*0.01));
            XYPoint p = new XYPoint(dateMs, open,high,low,close);
            data.add(p);
        }

        var chart = Chart.appendTo(vs,state);
        chart.setWidth(state,"600px");
        chart.setVariant(state, Chart.VariantEnum.CANDLESTICK);
        chart.setValue(state, data);
```
""";

        addExplanationPages(parent, state, "Chart- Candles", markdownDescription, vs, java, true);
    }


    private void AddRangeArea (VisualControl parent, StateData state) {

        var vs = new VStack(state);

        String markdownDescription = """
## Charts - RangeArea

A range area chart is populated with x,y data, with x being the label 

The value fields:
- x - label
- y - array containing low and high values for the range
""";
        var chart1 = Chart.appendTo(vs,state, "RangeArea - Given an array with X (months) and Y (low/high)");
        chart1.setWidth(state,"600px");
        chart1.setVariant(state, Chart.VariantEnum.RANGEAREA);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart1.setValue(state, "[{\"x\":\"Jan\",\"y\":[-2,4]},{\"x\":\"Feb\",\"y\":[-1,6]},{\"x\":\"Mar\",\"y\":[3,10]},{\"x\":\"Apr\",\"y\":[8,16]},{\"x\":\"May\",\"y\":[13,22]},{\"x\":\"Jun\",\"y\":[18,26]},{\"x\":\"Jul\",\"y\":[21,29]},{\"x\":\"Aug\",\"y\":[21,28]},{\"x\":\"Sep\",\"y\":[17,24]},{\"x\":\"Oct\",\"y\":[11,18]},{\"x\":\"Nov\",\"y\":[6,12]},{\"x\":\"Dec\",\"y\":[1,7]}]");

        String java = """
###Example Java code: \n\n
```java
    var chart1 = Chart.appendTo(vs,state, "RangeArea - Given an array with X (months) and Y (low/high)");
    chart1.setWidth(state,"600px");
    chart1.setVariant(state, Chart.VariantEnum.RANGEAREA);
    // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
    chart1.setValue(state, "[{\\"x\\":\\"Jan\\",\\"y\\":[-2,4]},{\\"x\\":\\"Feb\\",\\"y\\":[-1,6]},{\\"x\\":\\"Mar\\",\\"y\\":[3,10]},{\\"x\\":\\"Apr\\",\\"y\\":[8,16]},{\\"x\\":\\"May\\",\\"y\\":[13,22]},{\\"x\\":\\"Jun\\",\\"y\\":[18,26]},{\\"x\\":\\"Jul\\",\\"y\\":[21,29]},{\\"x\\":\\"Aug\\",\\"y\\":[21,28]},{\\"x\\":\\"Sep\\",\\"y\\":[17,24]},{\\"x\\":\\"Oct\\",\\"y\\":[11,18]},{\\"x\\":\\"Nov\\",\\"y\\":[6,12]},{\\"x\\":\\"Dec\\",\\"y\\":[1,7]}]");
```
""";

        addExplanationPages(parent, state, "Chart - Range Area", markdownDescription, vs, java, true);
    }

    private void AddPieDonut (VisualControl parent, StateData state) {

        var hs = new HStack(state);

        String markdownDescription = """
## Charts - Pi/Donut

Pi or Donut chart is populated with a list of quantities, along with  labels 

Value :  set to an array of values
Labels:  Names of the data points

""";

        var values = Arrays.asList(44, 55, 13, 43, 22);
        var labels = Arrays.asList("Product A", "Product B", "Product C", "Product D", "Product E");

        var chart1 = Chart.appendTo(hs,state, "Pi Chart");
        chart1.setWidth(state,"300px");
        chart1.setVariant(state, Chart.VariantEnum.PIE);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart1.setValue(state, values);
        chart1.setLabels(state, labels);

        var chart2 = Chart.appendTo(hs,state, "Donut chart");
        chart2.setWidth(state,"300px");
        chart2.setVariant(state, Chart.VariantEnum.DONUT);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart2.setValue(state, values);
        chart2.setLabels(state, labels);


        String java = """
###Example Java code: \n\n
```java
   var values = Arrays.asList(44, 55, 13, 43, 22);
    var labels = Arrays.asList("Product A", "Product B", "Product C", "Product D", "Product E");

    var chart1 = Chart.appendTo(hs,state, "Pi Chart");
    chart1.setWidth(state,"300px");
    chart1.setVariant(state, Chart.VariantEnum.PIE);
    // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
    chart1.setValue(state, values);
    chart1.setLabels(state, labels);

    var chart2 = Chart.appendTo(hs,state, "Donut chart");
    chart2.setWidth(state,"300px");
    chart2.setVariant(state, Chart.VariantEnum.DONUT);
    // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
    chart2.setValue(state, values);
    chart2.setLabels(state, labels);
```
""";

        addExplanationPages(parent, state, "Chart - Pi/Donut", markdownDescription, hs, java, true);
    }


    private void AddSparkline (VisualControl parent, StateData state) {

        var vs = new VStack(state);
        vs.setAlign(state, AlignItemsEnum.FLEX_START);

        String markdownDescription = """
## Charts - Sparkline

Charts can be converted to sparklines by setting "setSparkline" to true

The chart will then be minimally rendered without legends,labels, paddings etc

""";
        Divider.appendTo(vs,state);

        var values = Arrays.asList(44, 55, 13, 43, 22,50,15,34,50);
        var chart1 = Chart.appendTo(vs,state);
        chart1.setHeight(state,"30px").setWidth(state,"90px");
        chart1.setVariant(state, Chart.VariantEnum.LINEBASIC);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart1.setValue(state, values);
        chart1.setSparkLines(state, true);
        chart1.setLineWidth(state, 2);

        Divider.appendTo(vs,state);

        String java = """
###Example Java code: \n\n
```java
    var values = Arrays.asList(44, 55, 13, 43, 22,50,15,34,50);
	var chart1 = Chart.appendTo(vs,state);
	chart1.setHeight(state,"30px").setWidth(state,"90px");
	chart1.setVariant(state, Chart.VariantEnum.LINEBASIC);
	// you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
	chart1.setValue(state, values);
	chart1.setSparkLines(state, true);
	chart1.setLineWidth(state, 2);
```
""";

        addExplanationPages(parent, state, "Chart - Pi/Donut", markdownDescription, vs, java, true);
    }


}

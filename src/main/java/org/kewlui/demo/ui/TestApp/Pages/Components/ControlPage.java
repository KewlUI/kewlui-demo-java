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


import org.kewlui.demo.ui.TestApp.CustomControls.AgGrid.AgGridControl;
import org.kewlui.demo.ui.TestApp.CustomControls.ExampleJSControl;
import org.kewlui.demo.ui.TestApp.Pages.BasePage;
import org.kewlui.demo.ui.TestApp.Pages.Examples.TablePage;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.settings.*;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
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

- AnimationBox - Display an animation
- Avatar - Display a user's profile picture
- Badge - The badge control enables the display of a small label or indicator on a user interface to provide information or functionality. It allows for easy identification of specific items or actions and can provide context to users.
- Button - Button control that cause callbacks on the server side.
- Chart - Chart control that provides simplified charting and data visualization capabilities.
- EChart - Comprehensive chart contorl (Apache Echarts)
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
- Map - Used for displaying maps, markers within maps, and lines/routes
- Markdown - Component that allows rendering of text areas using markdown, including code sections
- PinInput - The PinInput control is used to create a hidden and customizable input field for entering PIN codes.
- Radio - Radio control is a GUI element that allows users to select one option out of multiple options presented in a list.
- Select - The Select control is a form element that enables users to select an option from a pre-defined list or input values.
- Slider - A slider control is a user interface element that enables the selection of a value by sliding a thumb-like element along a horizontal or vertical track.
- StatVanilla - Visual control for showing statistics in a system
- Switch - The Switch control is a user interface element that allows users to toggle between two states.
- TablePlus - Table control
- TextArea - The Textarea control allows users to edit multi-line text within a GUI by clicking on it and typing directly into it.
- Tooltip - The Tooltip feature allows users to display a tooltip when they hover over an element.
- Uploader - Allows file uploading

If a control offers an Icon, this can be set to the icons name (if the icon pack has been loaded) 

""";
        Markdown.appendTo(vs,state,contolMarkup, Markdown.ControlsEnum.NONE);

        addAnimationBox(vs,state);
        addAvatar(vs,state);
        addBadges(vs, state);
        addButton(vs,state);
        addChart(vs,state);
        addEChart(vs,state);
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

        addMap(vs, state);
        addMarkdown(vs, state);
        addPinInput(vs,state);
        addRadioGroup(vs, state);
        addSelect(vs, state);
        addSlider(vs, state);
        addStats(vs, state);
        addSwitch(vs, state);

        addTablePlus(vs, state);
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

    private void addEChart (VStack parent, StateData state) {
        String markdownDescription = """
## EChart

EChart control is a wrapper around Apache ECharts, and provides a more complex charting and data visualization capabilities.

Please see the chart page for a list of supported charts.  

Configuration can be done via the Options class, or via a JSON string.

EChart control can take its options from multiple sources, which is then merged together with the following (low-high) precedence:

1] Text (string) Json Option defining the chart

2] optionsJson (string) Json string options

3] Values (Object) Which will update the options.series fields

Thus it is possible to mix and match sources to build the final chart.

Values - if an array:
- if a single string, we will assume it is a json string and it will be parsed into one of the items below.
- is a single array of numbers - series[0].data is set to the value
- is an array of arrays
    - if all series entries have data set, the values placed there 
    - otherwise values will be put in options.dataset.source exists
- is an array of objects
    - clear series.data if set
    - values will be put in options.dataset.source
    - dimensions will pulled from the object keys if not set

ECharts require height and width to be set in pixels.  e.g. "600px"

""";
        var vs = new VStack(state);

        // see https://echarts.apache.org/examples/en/editor.html?c=line-smooth
        // note double quotes in json string for keys and values - for strings
        var echart  = EChart.appendTo(vs, state);
        var jsonStr = """
            {"option" : {
              "xAxis": {
                "type": "category",
                "data": ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
              },
              "yAxis": {
                "type": "value"
              },
              "series": [
                {
                  "data": [820, 932, 901, 934, 1290, 1330, 1320],
                  "smooth": true,
                  "type": "line"
                }
              ]
            }
        }                
                """;
        // lowest priority in setting options - via text
        echart.setText(state, jsonStr);         // example - set some options on the echart via text, json, lowest priority
        echart.setWidth(state, "600px").setHeight(state, "400px");

        var s = Select.appendTo(vs, state, "area,lines,bar", DefaultValue.set("lines"));
        s.setWidth(state, "300px");
        // higher priority config to merge in - here we merge in "type:line"


        // to make this interesting, add in extra options
        Map<String, Object> options = new LinkedHashMap<>();
        // when chosen, change the options - override
        options.put("lines", "{\"series\":[{\"smooth\":\"true\", \"type\":\"line\",\"itemStyle\":{\"color\":\"#5470c6\"}}]}\n");
        options.put("bar", "{\"series\":[{\"type\":\"bar\",\"barWidth\":\"60%\",\"itemStyle\":{\"color\":\"#5470c6\",\"barBorderRadius\":4}}]}\n");
        options.put("area", "{\"series\":[{\"type\":\"line\",\"areaStyle\":{},\"itemStyle\":{\"color\":\"#5470c6\"}}]}\n");

        s.setOnChange(state, (e) -> {
            var val = s.getValue(e.clientState());
            echart.setOptionsJson(e.clientState(), options.get(val).toString());
        });
        /////////////////////////////
        // set the chart.value
        // highest priority is value, which will only update the series.data
        echart.setValue(state, Arrays.asList(82, 93, 90, 93, 129, 133, 132)); // override the options.series[0].data above

        var java = """
```java
        echart.setText(state, jsonStr);         // example - set some options on the echart via text, json, lowest priority

        var s = Select.appendTo(vs, state, "area,lines,bar", DefaultValue.set("lines"));
        s.setWidth(state, "300px");

        // higher priority config to merge in - here we merge in "type:line"


        // to make this interesting, add in extra options
        Map<String, Object> options = new LinkedHashMap<>();
        // when chosen, change the options - override
        options.put("lines", "{\\"series\\":[{\\"smooth\\":\\"true\\", \\"type\\":\\"line\\",\\"itemStyle\\":{\\"color\\":\\"#5470c6\\"}}]}\\n");
        options.put("bar", "{\\"series\\":[{\\"type\\":\\"bar\\",\\"barWidth\\":\\"60%\\",\\"itemStyle\\":{\\"color\\":\\"#5470c6\\",\\"barBorderRadius\\":4}}]}\\n");
        options.put("area", "{\\"series\\":[{\\"type\\":\\"line\\",\\"areaStyle\\":{},\\"itemStyle\\":{\\"color\\":\\"#5470c6\\"}}]}\\n");

        s.setOnChange(state, (e) -> {
            var val = s.getValue(e.clientState());
            echart.setOptionsJson(e.clientState(), options.get(val).toString());
        });
        /////////////////////////////
        // set the chart.value
        // highest priority is value, which will only update the series.data
        echart.setValue(state, Arrays.asList(10, 20, 30, 40, 50, 60, 70)); // override the options.series[0].data above
```
                        """;

        addExplanationPages(parent, state, "EChart", markdownDescription, vs, java, false);
    }

    private void addChart (VStack parent, StateData state) {
        String markdownDescription = """
## Chart

Chart provides a simplified method to create charts in KewlUI.  Based around ApexCharts js, but with some additional features.

Chart data can either be supplied directly or via a SQL query.

The following variants are supported.

LineBasic, LineSmooth, LineStep, AreaBasic, AreaSmooth, AreaStep, AreaStacked, BarsBasicVertical, BarsChiseledVertical, BarsStackedVertical, BarsStacked100Vertical, BarsProfitLossVertical, 
BarsBasicHorizontal, BarsStackedHorizontal, BarsStacked100Horizontal, BarsProfitLossHorizontal, Timeline, RangeArea, CandleStick, Donut, Pie

""";
        var vs = new VStack(state);
        vs.setTextAlign(state, TextAlignEnum.LEFT);

        var values = Arrays.asList(44, 55, 13, 43, 22);
        var labels = Arrays.asList("Product A", "Product B", "Product C", "Product D", "Product E");
        // Pi chart
        Text.appendTo(vs,state,"Pi Chart").setFontSize(state,"20px");
        var chart1 = Chart.appendTo(vs,state, "Pi Chart");
        chart1.setWidth(state,"300px").setHeight(state,"300px");
        chart1.setVariant(state, Chart.VariantEnum.PIE);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart1.setValue(state, values);
        chart1.setLabels(state, labels);
        Divider.appendTo(vs,state);
        // Donut chart
        Text.appendTo(vs,state,"Donut Chart").setFontSize(state,"20px");
        var chart2 = Chart.appendTo(vs,state, "Donut chart");
        chart2.setWidth(state,"300px").setHeight(state,"300px");
        chart2.setVariant(state, Chart.VariantEnum.DONUT);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart2.setValue(state, values);
        chart2.setLabels(state, labels);

        Divider.appendTo(vs,state);

        Text.appendTo(vs,state,"Sparklines").setFontSize(state,"20px");
        // Sparklines
        values = Arrays.asList(44, 55, 13, 43, 22,50,15,34,50);
        chart1 = Chart.appendTo(vs,state);
        chart1.setHeight(state,"30px").setWidth(state,"90px");
        chart1.setVariant(state, Chart.VariantEnum.LINEBASIC);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart1.setValue(state, values);
        chart1.setSparkLines(state, true);
        chart1.setLineWidth(state, 2);

        var java = """
```java
        var values = Arrays.asList(44, 55, 13, 43, 22);
        var labels = Arrays.asList("Product A", "Product B", "Product C", "Product D", "Product E");
        // Pi chart
        var chart1 = Chart.appendTo(vs,state, "Pi Chart");
        chart1.setWidth(state,"300px").setHeight(state,"300px");
        chart1.setVariant(state, Chart.VariantEnum.PIE);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart1.setValue(state, values);
        chart1.setLabels(state, labels);
        Divider.appendTo(vs,state);
        // Donut chart
        var chart2 = Chart.appendTo(vs,state, "Donut chart");
        chart2.setWidth(state,"300px").setHeight(state,"300px");
        chart2.setVariant(state, Chart.VariantEnum.DONUT);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart2.setValue(state, values);
        chart2.setLabels(state, labels);

        Divider.appendTo(vs,state);

        // Sparklines
        values = Arrays.asList(44, 55, 13, 43, 22,50,15,34,50);
        chart1 = Chart.appendTo(vs,state);
        chart1.setHeight(state,"30px").setWidth(state,"90px");
        chart1.setVariant(state, Chart.VariantEnum.LINEBASIC);
        // you can also give an array of objects that contain x and y - in this case we are giving a json string which will be parsed
        chart1.setValue(state, values);
        chart1.setSparkLines(state, true);
        chart1.setLineWidth(state, 2);
```
                """;

        addExplanationPages(parent, state, "Chart", markdownDescription, vs, java, false);
    }

    private void addTablePlus (VStack parent , StateData state) {
        String markdownDescription = """
## TablePlus

TablePlus is a table control that has a number of features

- Multi column sorting (ctrl click)
- Multi column selection
- Embeddable controls (e.g. buttons)
- Can display data from either Value field or via SQL.
    - Setting 'SQL' with an sql query can load from remote URL (json/csv etc)
    - Rows selected will be sent to the server via a callback
    
Properties:
- sql - perform SQL on remote URL
- setData - allows server side setting of a list of rows
- columnDefinitions - If given, list of columns to display. e.g. {"key":"utilization","name":"Utilization","type":"%.2f"}
- selection - if true rows can be selected by the user
- onClick - if set,  event.getContext(); will return Map<String,object> containing fields of the row last clicked on
      
    """;

        var vs = new VStack(state);

        List<TablePage.ProcessInfo> testData = TablePage.generateTestData();
        var t = TablePage.addMachineTableExample(vs, state, testData);

        String java = """
###Example Java code: \n\n
```java       
    var description = Markdown.appendTo(vs,globalState,"Clicking on the table below can cause a callback");
    Divider.appendTo(vs,globalState);

    List<ProcessInfo> testData = generateTestData();
    // create a table, set its data directly
    TablePlus table = TablePlus.appendTo(vs,globalState);
    table.setData(globalState, testData);

    var columnDefinitions = ""\"
    [{"key":"machineName","name":"MachineName"},{"key":"processName","name":"ProcessName"},
     {"key":"status","name":"Status"},{"key":"utilization","name":"Utilization","type":"%.2f"},
     {"key":"startTime","name":"StartTime","type":"DateTime"} , {"key":"controlButtons","name":"Control"}                                                                                                                                                                                                                                      \s
    ]
    ""\";
    // add column definiitons - we could add a list of column objects, or json string to do the same
    table.setColumns(globalState, columnDefinitions);
    // if they click on a row, we want to know which one - fill in detail
    table.setOnClick(globalState,
            (e)-> {
                var row = (Map<String,Object>) event.getContext();
                var txt = "**Last Row Clicked on: ** " + row;
                description.setText(e.clientState(), txt); // update just for this user
            });

    var hs = HStack.appendTo(table,globalState).setName(globalState,"controlButtons");

    // add some names controls to the table.  We are adding controls for virtual column 'control' (match on key)
    // Any user can update the state here, and every other user will see it as here we are re-writing to global state
    var buttonStart = Button.appendTo(hs,globalState,"Start", Button.VariantEnum.ROUNDED);
    var buttonStop = Button.appendTo(hs,globalState,"Stop", Button.VariantEnum.ROUNDED);
    buttonStart.setHeight(globalState,"30px");
    buttonStop.setHeight(globalState,"30px");
    buttonStart.setOnClick(globalState,
            (e)-> {
                var row = (Map<String,Object>) event.getContext();
                var id = (Number) row.get("id");
                updateTestDataStatus(testData, id.longValue(), "Running");
                table.setData(globalState, testData);
            });
    // Prerender - note we could also return false if the button doesn't make sense, which would stop it from rendering
    buttonStart.setClientSidePreRender(globalState, "params.props.bgColor =  (params.row['status'] === 'Running') ? 'lightgray' : 'Green';");
    buttonStop.setOnClick(globalState,
            (e)-> {
                var row = (Map<String,Object>) event.getContext();
                var id = (Number) row.get("id");
                updateTestDataStatus(testData, id.longValue(), "Stopped");
                table.setData(globalState, testData);
            });
    buttonStop.setClientSidePreRender(globalState, "params.props.bgColor =  (params.row['status'] === 'Running') ? 'Red' : 'lightgray';");

    var badge = Badge.appendTo(table,globalState);
    badge.setName(globalState, "status"); // call this status, thus this will be used to show status
    badge.setWidth(globalState,"100px");
    badge.setClientSidePreRender(globalState, ""\"
        params.text = params.value; // set the badge text to the value passed from the row
        params.props.colorScheme = (params.value === "Running") ? "green" : "red";\s
    ""\"); // yes, we can modify behaviour on the client side before control is rendered

    // simulate realtime update - every few seconds update the utilisation - this will be seen by all users
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            updateTestDataUtilisation(testData);
            table.setData(globalState, testData);
            var val = Math.random() * 100;
            stats2.setValue(globalState,String.format("%.0f%%",val));
            prog2.setValue(globalState,(int)val);
            stats2.setDescription(globalState,String.format("Total free %.1f GB", 6*(val/100.0)));
            var vals = (ArrayList<Integer>) ch.getValue(globalState);
            vals.add(vals.get(0));
            vals.remove(0);
            ch.setValue(globalState, vals);
        }
    }, 1000, 2000);
``` """;

        addExplanationPages(parent, state, "TablePlus", markdownDescription, vs, java);

    }

    private void addCommon (VStack parent, StateData state) {
        String markdownDescription = """
## Common Attributes (Components and Containers)


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
        heartbeat.setOnChange(state, (e)->{
            var val = heartbeat.getValue(e.clientState());
            text.setText(e.clientState(), "Client sent Heartbeat: '" + val + "' to the server."); // remember update text not value here
        });

        String java = """
###Example Java code: \n\n
```java       
    Text.appendTo(vs, state, "Heartbeat Example");

    var text = Text.appendTo(vs, state, "");
    text.setControlPulseOnChange(state, true); // momentary highlight on change

    var heartbeat = Heartbeat.appendTo(vs, state);
    heartbeat.setHeartbeatInterval(state, 3);
    heartbeat.setOnChange(state, (e)->{
        var val = heartbeat.getValue(e.clientState());
        text.setText(e.clientState(), "Client sent Heartbeat: '" + val + "' to the server."); // remember update text not value here
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

    private void addAnimationBox(VStack parent, StateData state) {
        String markdownDescription = """
### AnimationBox

AnimationBox allows showing an animation within an area.  It allows playing, and time shifting the animation based on around a value.

It allows you to give a new visual 'look and feel' to an existing control.

It supports the following animations formats:

- Lottie format (preferred - best quality and smallest)
- Images in CSSSprite format
- Videos

The playing of the animation is controlled by the value field, and changes in value will cause a forward/reverse animation to the new value:

- boolean - false = show first frame, true = show last frame
- integer - (0-100) percentage position in the animation to play to
- string - 'play'= play once, 'loop' play in a loop

Note children can be added to the control, and will be overlayed on top of the animation.  Opaque setting can be used to make the children controls invisible.

In this way, it is possible to overlay an invisible slider control on top of a AnimationBox to create a custom slider control.

[SVG to Lottie utilities are avaialble](https://lottiefiles.com/svg-to-lottie)

""";

        var box = new AutoWrap(state);
        box.setAlignItems(state, AlignItemsEnum.FLEX_START);
        { // Lottie animation - toggle control
            var line1 = HStack.appendTo(box, state);
            Text.appendTo(line1, state, "Lottie Switch:");
            var toggleBox = AnimationBox.appendTo(line1, state); // AnimationBox holds graphics, with another invisible control on top
            toggleBox.setSrc(state, "{urlBase}/images/dayslider.json");
            toggleBox.setValue(state, false); // animation starts at off/false/0
            toggleBox.setWidth(state, "100px").setHeight(state, "60px");
            toggleBox.setZoomLevel(state, 2.2); // make the animated control larger within its box
            toggleBox.setTranslateX(state, 0.0).setTranslateY(state, 0.0); // put here for illustrative purposes
            var valueText = Text.appendTo(line1, state, "value is false");
            toggleBox.setOnClick(state, (e)-> {
                var value = (Boolean) toggleBox.getValue(e.clientState());
                value = !value;
                toggleBox.setValue(e.clientState(), value);
                valueText.setText(e.clientState(),"value is "+value);
            });
        }
        { // CSSSprites : Slider in 6 frames
            var line1 = HStack.appendTo(box, state);
            Text.appendTo(line1, state, "CSS Sprites with invisible slider overlayed:");
            var sliderBox = AnimationBox.appendTo(line1, state); // AnimationBox holds graphics, with another invisible control on top
            sliderBox.setWidth(state, "200px").setHeight(state, "60px");

            sliderBox.setSrc(state, "{urlBase}/images/cssSprite.webp");
            final int numFrames = 6;
            sliderBox.setImageWidth(state, 643).setImageHeight(state, 99).setNumFrames(state,numFrames);
            sliderBox.setValue(state, 50.0); // animation starts at off/false/0

            sliderBox.setOpacity(state, 0);  // slider in invisible, though it works...
            var slider = Slider.appendTo(sliderBox, state);
            slider.setWidth(state,"160px").setHeight(state, "100%");
            slider.setMin(state, 0.0).setMax(state,100.0).setStep(state, 100.0 / numFrames); // controls 6 frames

            var valueText = Text.appendTo(line1, state, "value is 0");

            slider.setOnChange(state, (e)-> {
                var value = (Number) slider.getValue(e.clientState()); // get the slider value
                sliderBox.setValue(e.clientState(), value); // update the visual
                valueText.setText(e.clientState(),"value is "+ Math.round(value.doubleValue())); // and the text
            });

        }

        String java = """

```
""";

        addExplanationPages(parent, state, "AnimationBox", markdownDescription, box, java);
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
        var d = Divider.appendTo(vs, state);
        d.setBgColor(state, "theme.colors.primary_50").setColor(state, "theme.colors.primaryText_50");

        var hs = HStack.appendTo(vs, state);
        Markdown.appendTo(hs, state, "text1");
        Divider.appendTo(hs, state)
                .setOrientation(state, Divider.OrientationEnum.VERTICAL).setHeight(state, "50px")
                .setBgColor(state, "theme.colors.primary_50").setColor(state, "theme.colors.primaryText_50");

        Markdown.appendTo(hs, state, "horizontal");
        Divider.appendTo(hs, state)
                .setOrientation(state, Divider.OrientationEnum.VERTICAL).setHeight(state, "50px")
                .setBgColor(state, "theme.colors.primary_50").setColor(state, "theme.colors.primaryText_50");

        Markdown.appendTo(hs, state, "text3");

        Divider.appendTo(vs, state)
                .setBgColor(state, "theme.colors.primary_50").setColor(state, "theme.colors.primaryText_50");


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




    private void addMap(VStack parent, StateData globalState) {
        String markdownDescription = """
### Maps

The Map Component displays a customizable, interactive map that supports zooming and panning. 

It places markers for specified locations, each with custom text in popups. 

Additionally, it optionally draws polylines through selected locations to illustrate connections or routes. 

Value holds a list of Map.Position/Circle/Polygon objects.  

- Position: used for Markers and lines.  They have lat/lon/marker text, draw line color (if null, no line)
- Circle: used for Circles and circle markers. They have lat/lon/text/line color/radius,circle color
- Polygon: Points with a group polygonId - allows filling areas with a colour

The first Position given will be the centre of the map.

Markers will only be shown if text is set (not null).  Lines between Positions will only be shown if line color is not null.

""";

        var vs = new VStack(globalState);

        var maps = Maps.appendTo(vs, globalState);
        maps.setCenter(globalState, List.of(40.7128, -74.0060)) // New York City coordinates, with 'line' as false
                .setZoom(globalState, 12)
                .setZoomControl(globalState, true);

        // line from Times Square to WallStreet
        var interestingPoints = List.of(
                Maps.Position.of(40.7580, -73.9855, null, null), // Centre of map : New York City coordinates, no text so marker not shown, with 'lineColor' as null/off

                Maps.Position.of(40.7580, -73.9855, "Times Square", "green"), // Times Square
                Maps.Position.of(40.730610, -73.935242, "East Village", null), // East Village
                Maps.Position.of(40.7061, -74.0087, "Wall Street", "green"), // Wall Street

                // Circle - if text is given, the radius is treated as pixels.  If text is null, the radius is treated as metres
                Maps.Circle.of(40.748817, -73.985428, "Empire State Building", null, 20, "red" ), // "Empire State Building" marker, red circle around marker with radius 20 PIXELS
                Maps.Circle.of(40.762500, -73.974167, null, null, 200, "blue" ), // yellow circle around position with  radius == 200 metres

                // add purple areas around central park
                Maps.Polygon.of(40.767272, -73.981307, "purple", 1 ),
                Maps.Polygon.of(40.800833, -73.958000, "purple", 1 ),
                Maps.Polygon.of(40.786387, -73.949516, "purple", 1 ),
                Maps.Polygon.of(40.764357, -73.973017, "purple", 1 ) // yellow circle around position with radius 200m
        );
        maps.setValue(globalState, interestingPoints);
        maps.setHeight(globalState, "600px").setWidth(globalState, "90%");

        String java = """
###Example Java code: \n\n
```java
       var maps = Maps.appendTo(vs, globalState);
       maps.setCenter(globalState, List.of(40.7128, -74.0060)) // New York City coordinates, with 'line' as false
               .setZoom(globalState, 12)
               .setZoomControl(globalState, true);

       // line from Times Square to WallStreet
       var interestingPoints = List.of(
               new Maps.Position(40.7580, -73.9855, null, null), // Centre of map : New York City coordinates, no text so marker not shown, with 'lineColor' as null/off

               new Maps.Position(40.7580, -73.9855, "Times Square", "green"), // Times Square
               new Maps.Position(40.730610, -73.935242, "East Village", null), // East Village
               new Maps.Position(40.7061, -74.0087, "Wall Street", "green"), // Wall Street

               // Circle - if text is given, the radius is treated as pixels.  If text is null, the radius is treated as metres
               new Maps.Circle(40.748817, -73.985428, "Empire State Building", null, 20, "red" ), // "Empire State Building" marker, red circle around marker with radius 20 PIXELS
               new Maps.Circle(40.762500, -73.974167, null, null, 200, "blue" ), // yellow circle around position with  radius == 200 metres

               // add purple areas around central park
               new Maps.Polygon(40.767272, -73.981307, "purple", 1 ),
               new Maps.Polygon(40.800833, -73.958000, "purple", 1 ),
               new Maps.Polygon(40.786387, -73.949516, "purple", 1 ),
               new Maps.Polygon(40.764357, -73.973017, "purple", 1 ) // yellow circle around position with radius 200m
       );
       maps.setValue(globalState, interestingPoints);
       maps.setHeight(globalState, "600px").setWidth(globalState, "90%");
```
""";
        addExplanationPages(parent, globalState, "Maps", markdownDescription, vs, java);
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
        toggleSwitch2.setOnChange(state, (e)->{
            var val = toggleSwitch2.getValue(e.clientState());
            text.setText(e.clientState(), "Value: "+val); // remember update text not value here
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
        toggleSwitch2.setOnChange(state, (e)->{
            var val = toggleSwitch2.getValue(e.clientState());
            text.setText(e.clientState(), "Value: "+val); // remember update text not value here
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
        formContext.setOnChange(state, (e)->{
            text.setText(e.clientState(),  "FormContext state: " + formContext.getValue(e.clientState()));
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
        formContext.setOnChange(state, (e)->{
            text.setText(e.clientState(),  "FormContext state: " + formContext.getValue(e.clientState()));
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

        cbg.setOnChange(state, (e)->{
            // Note: we need to setText (not value) on a text field.
            // We must read from and set to the clientState, not the global state
            text.setText(e.clientState(), header + cbg.getValue(e.clientState())+"!");
        });

        var cb = Radio.appendTo(cbg, state, "I use Java", DefaultValue.set("Java"), ColorSchemeEnum.RED);
        cb.setName(state, "language");

        cb = Radio.appendTo(cbg, state, "I use Python", DefaultValue.set("Python"), ColorSchemeEnum.BLUE);
        cb.setName(state, "language");

        cb = Radio.appendTo(cbg, state, "I use C++", DefaultValue.set("C++"), ColorSchemeEnum.YELLOW);
        cb.setName(state, "language");

        Markdown.appendTo(vs, state, "RadioGroup with automatically added options for professions");
        var cbg2 = RadioGroup.appendTo(vs, state, "Doctor,Nurse,Other", DefaultValue.set("Other"), ColorSchemeEnum.RED);
        cbg2.setOnChange(state, (e)->{
            text.setText(e.clientState(), header + cbg2.getValue(e.clientState())+"!");
        });

        String java = """
```java
 var header = "RadioGroup status: ";
        var text = Text.appendTo(vs, state, "RadioGroup status: ");

        Markdown.appendTo(vs, state, "RadioGroup with manually added Radio buttons for programming languages");
        final var cbg = RadioGroup.appendTo(vs, state, DefaultValue.set("Java"), ColorSchemeEnum.MESSENGR);

        cbg.setOnChange(state, (e)->{
            // Note: we need to setText (not value) on a text field.
            // We must read from and set to the clientState, not the global state
            text.setText(e.clientState(), header + cbg.getValue(e.clientState())+"!");
        });

        var cb = Radio.appendTo(cbg, state, "I use Java", DefaultValue.set("Java"), ColorSchemeEnum.RED);
        cb.setName(state, "language");

        cb = Radio.appendTo(cbg, state, "I use Python", DefaultValue.set("Python"), ColorSchemeEnum.BLUE);
        cb.setName(state, "language");

        cb = Radio.appendTo(cbg, state, "I use C++", DefaultValue.set("C++"), ColorSchemeEnum.YELLOW);
        cb.setName(state, "language");

        Markdown.appendTo(vs, state, "RadioGroup with automatically added options for professions");
        var cbg2 = RadioGroup.appendTo(vs, state, "Doctor,Nurse,Other", DefaultValue.set("Other"), ColorSchemeEnum.RED);
        cbg2.setOnChange(state, (e)->{
            text.setText(e.clientState(), header + cbg2.getValue(e.clientState())+"!");
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
            formInput.setOnChange(state, (e)->{ Log.info("changed:" + formInput.getValue(e.clientState())); });

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
        formInput.setOnChange(state, (e)->{ Log.info("changed:" + formInput.getValue(e.clientState())); });

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
        input.setOnChange(state, (e)->{ Log.info("changed" + input.getValue(e.clientState())); });

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
        input2.setOnChange(state, (e)->{
            rest.setText(e.clientState(), "Value: " + input2.getValue(e.clientState()));
        });
        InputRightAddon.appendTo(group, state, "/index.html");

        var java = """
```java    
    var input = Input.appendTo(vs, state, "This is a simple Input - enter something here");
    input.setOnChange(state, (e)->{ Log.info("changed" + input.getValue(e.clientState())); });

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
    input2.setOnChange(state, (e)->{
        rest.setText(e.clientState(), "Value: " + input2.getValue(e.clientState()));
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
        cb.setOnChange( state, (e)->{ text1.setText(e.clientState(), cb.getValue(e.clientState()).toString()); });

        var text2 = Text.appendTo(vs, state, "CheckboxGroup callback text - change something below");
        var cbg =  CheckboxGroup.appendTo(vs,state,"Milk,Sugar,Sweetener,Vanilla", DefaultValue.set("Milk,Vanilla"), ColorSchemeEnum.GREEN);
        cbg.setOnChange( state, (e)->{ text2.setText(e.clientState(), cbg.getValue(e.clientState()).toString()); });

        String java = """
```java
    var text1 = Text.appendTo(vs, state, "Checkbox callback text - toggle below checkbox");
    var cb = Checkbox.appendTo(vs, state, "This is a checkbox", DefaultValue.set(true), ColorSchemeEnum.ORANGE);
    cb.setOnChange( state, (e)->{ text1.setText(e.clientState(), cb.getValue(e.clientState()).toString()); });

    var text2 = Text.appendTo(vs, state, "CheckboxGroup callback text - change something below");
    var cbg =  CheckboxGroup.appendTo(vs,state,"Milk,Sugar,Sweetener,Vanilla", DefaultValue.set("Milk,Vanilla"), ColorSchemeEnum.GREEN);
    cbg.setOnChange( state, (e)->{ text2.setText(e.clientState(), cbg.getValue(e.clientState()).toString()); });
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
        button.setOnMouseOver(state,  (e)->{ button.setText(e.clientState(), "OnMouseOver"); });
        button.setOnMouseOut(state,  (e)->{ button.setText(e.clientState(), "OnMouseOut"); });
        button.setOnClick(state,  (e)->{ button.setText(e.clientState(), "OnClick"); });

        var txt = Text.appendTo(vs, state, "When the customTheme is used, 'customButton' variant will be made available and below will change style");
        b = Button.appendTo(vs, state,"variant=customButton");
        b.setVariant(state, "customButton");
        b.setOnClick(state,  (e)->{ txt.setText(e.clientState(), "customButton pushed"); });

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
        button.setOnMouseOver(state,  (e)->{ button.setText(e.clientState(), "OnMouseOver"); });
        button.setOnMouseOut(state,  (e)->{ button.setText(e.clientState(), "OnMouseOut"); });
        button.setOnClick(state,  (e)->{ button.setText(e.clientState(), "OnClick"); });
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
        up.setOnUpload(globalState,  (e)-> {
            var downloadedFiles = new ArrayList<File>();
            StringBuilder sb = new StringBuilder("### Result of upload\n<br/>List of files uploaded:\n<br/>\n");
            try {
                Map<String,File> files = up.getValue(e.clientState());
                for (var info : files.entrySet()) {
                    // download the file to a temp file on this machine....
                    var destFile = new File(UUID.randomUUID().toString()+".tmp");
                    downloadedFiles.add(destFile);
                    var inputFile = info.getValue();
                    Files.copy(inputFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    sb.append(String.format("Name: %s  Size: %d.\n<br/>", info.getKey(), inputFile.length()));
                }
                information.setText(e.clientState(), sb.toString());
            }
            catch (Exception ex) {
                Log.error("Exception thrown in upload processor", ex);
                information.setText(e.clientState(), "Exception thrown in upload processor "+ex.getMessage());
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
        up.setOnUpload(globalState,  (e)-> {
            var downloadedFiles = new ArrayList<File>();
            StringBuilder sb = new StringBuilder("### Result of upload\\n<br/>List of files uploaded:\\n<br/>\\n");
            try {
                List<MultipartFile> files = up.getValue(e.clientState());
                for (var file : files) {
                    // download the file to a temp file on this machine....
                    var destFile = new File(UUID.randomUUID().toString()+".tmp");
                    downloadedFiles.add(destFile);

                    try (InputStream inputStream = file.getInputStream()) {
                        Files.copy(inputStream, destFile.toPath().toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    sb.append(String.format("Name: %s  OriginalFileName: %s ContentType: %s Reported Size: %d Actual Size: %d.\\n<br/>", file.getName(), file.getOriginalFilename(), file.getContentType(), file.getSize(), destFile.length()));
                }
                information.setText(e.clientState(), sb.toString());
            }
            catch (Exception ex) {
                Log.error("Exception thrown in upload processor", ex);
                information.setText(e.clientState(), "Exception thrown in upload processor "+ex.getMessage());
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
        datePicker.setOnChange(state, (e) -> {
            var selectedDate = datePicker.getValue(e.clientState()); // Get selected date
            selectedDateText.setText(e.clientState(), "Selected date: " + selectedDate);
        });

        var cb = Checkbox.appendTo(vs,state,"Include time", DefaultValue.set(false) );
        cb.setOnChange(state, (e) -> {
            Boolean value = cb.getValue(e.clientState()); // Get selected date
            datePicker.setHasTime(e.clientState(),value);
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
   datePicker.setOnChange(state, (e) -> {
       var selectedDate = datePicker.getValue(e.clientState()); // Get selected date
       selectedDateText.setText(e.clientState(), "Selected date: " + selectedDate);
   });

   var cb = Checkbox.appendTo(vs,state,"Include time", DefaultValue.set(false) );
   cb.setOnChange(state, (e) -> {
       Boolean value = cb.getValue(e.clientState()); // Get selected date
       datePicker.setHasTime(e.clientState(),value);
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
    }



    public void addExtendControl1 (VisualControl parent, StateData globalState) {

        String markdownDescription = """
                ## Custom Controls -  Java classes

                You can create your own custom controls that are rendered client side via the CustomControl base class.

                Controls inheriting from custom control can define their own Javascript and CSS and will be rendered client side when the control is used.

                Quick overview of how to do this:

                1. Create your custom control, inheriting/extending from "CustomControl" class
                2. Add in constructor and appendTo functions etc
                3. Add in static function getControlInfo() to the class to define client side rendering options.
                4. Call static CustomControl.registerClass at startup to add make your class usable.

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

                **1. Let's create function public static ControlInfo getControlInfo()** 

                When registering a class, getControlInfo() will be called, returning ControlInfo class.  ControlInfo contains the following fields:
                
                - javascript
                    - string: Javascript function that normally returns a string.  The html string is rendered into the innerHTML of the target. 
                - css (optional)
                    - string: CSS for the control
                - includes (optional)
                    - string: Optionally allows include statements for javascript and css files
                - initJs (optional)
                    - string: Javascript to be called on initialisation of the control
                - destroyJs (optional)
                    - string: Javascript to be called on destruction of the control
                - backgroundJs (optional)
                    - string: If set, every render will run javascript in a background worker thread.  The results will be passed to the normal javascript in the state.backgroundData field.

                **2. css - CSS for the control**                                    

                Note: we can use theme colors in our css using vars, however instead of **.** separators we need **-** separators.
                e.g. use: var(--theme-colors-primaryText)

                ```java
                        .setCss(""\"
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
                                ""\");                    
                ``` 
                <br/>

                **3. Javascript**
                <br/>  
                All javascript functions are called given **params** object, which has the following fields:
                    
                    - targetId - id/location where the control will be rendered
                    - props - props to pass to the control 
                    - eventHandlers - dictionary (name->function) of event handlers registered, e.g "onMouseOver"
                    - text - translated text field
                    - value - value field
                    - setValue(value) - function to call if the value of this control changes    
                    - isSmallScreen - set true if this appears to be mobile
                    - colors - dictionary containing color names, such as "primary", "pageText" etc - used to pass on theming.
                    - state - state dictionary for this control, can be used by user js code as a storage area
                    
                <br/> 
                By default, if the javascript function returns a string containing html, it will be rendered into the target location.
                Returning null (or nothing) will not cause any rendering.

                ```java
                
                    setJavascript(""\"
                          const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, colors, state} = params;
                          const answer = (props.x ?? 0)  * (props.y ?? 0);
                          return `< div class="funky-color-fade"> Multiplying ${props.x} with ${props.y} gives answer ${answer}</div>`;
                    ""\");
                    }
                ```
                
                <br/>We consider 'javascript' section to me the main "update" rendering of the control.
                <br/>
                
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
                <br/>
                    
                **4. backgroundJs**
                
                BackgroundJs allows running javascript in a background thread.  This is useful for running javascript that takes a long time.
                
                When backgroundJs is set, the javascript will be run in a background worker thread initially - with the result sent to the normal javascript code via the state.backgroundData field.
                                                
                Please note - the background thread does not have any access to the DOM or window, nor can it be passed any functions.
                                    
                5. initJs and destroyJs, etc 
                
                Both optional, initJs is javascript called at creation of the control, while destroyJs is called at shutdown of the control.
                
                On a change to the controls state:
                    1) Properties change - full re-render - destroyJs is called, then initJs is called, then javascript is called for rendering the latest update.
                    2) Value only change - only 'javascript' function is called  (or 'backgroundJs'/'javascript' chain if defined)              
                ```
                <br/>
                <br/>


                ### 4. Register the control

                <br/>
                Finally in our code, we need to register the new control.  We do this by calling: CustomControl.registerClass.
                <br/>
                    **CustomControl.registerClass(ExampleJSControl.class);**
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

        Timer timer = new Timer();
        Random r = new Random();
        timer.scheduleAtFixedRate(new TimerTask() {  // test updating value on custom element
            @Override
            public void run() {
                example.setX(globalState, r.nextInt(10));
            }
        }, 1000, 2000);

        Divider.appendTo(vs,globalState);

        Text.appendTo(vs, globalState, "Following example control is Java 'AgGridControl' which links in the ag grid lib");

        var box = Box.appendTo(vs, globalState);
        box.setWidth(globalState, "800px").setHeight(globalState, "400px");
        box.setBgGradient(globalState, "linear-gradient(to right, var(--theme-colors-secondary_20), var(--theme-colors-primary_20))");
        AgGridControl agGridControl = AgGridControl.appendTo(box, globalState);
        List<AgGridControl.ColumnDef> columnDefs = List.of(
                new AgGridControl.ColumnDef("make", true, true, null, null),
                new AgGridControl.ColumnDef("model", true, true, null, null),
                new AgGridControl.ColumnDef("price", true, true, null, null)
        );
        agGridControl.setColumnDefs(globalState, columnDefs);
        agGridControl.setValue(globalState, generateTestData());

        var java = """
```java                
        ///////////////////////
        // getControlInfo() - Returns information for rendering the control on the client side
        // This function is called by KEWLUI when the control is registered
        // used to supply information about the control, e.g. javascript code, css, include files, etc
        public static ControlInfo getControlInfo() {
            var controlInfo = ControlInfo.create();

            // BackgroundJs - optional, if the following is set:
            // this javascript code will be run in a background thread on the client - no DOM access available
            // data returned from this javascript will be passed to the (JavaScript codeblock) state under backgroundData
            // this function does not have access to any mutating properties like setValue
            controlInfo.setBackgroundJs(""\"
                  const {targetId, props, text, value, isSmallScreen, colors} = params;
                  // background running, some long running process to calculate something
                  return { info: "Random: "+Math.floor(Math.random() * 10) };
              ""\");

            // javascript to return the HTML for the control - consider this standard UPDATE/draw logic
            // the script given should return a string (capable of being put in innerHTML) or NULL if nothing to update
            // this code is run on the main client thread so has access to DOM if necessary....
            controlInfo.setJavascript(""\"
                  const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, rebuild, colors, state} = params;
                  const answer = (props.x ?? 0)  * (props.y ?? 0);
                  return `< div class="funky-color-fade"> Multiplying ${props.x} with ${props.y} gives answer ${answer}.  Background processor says "${state.backgroundData?.info}".</div>`;
            ""\");

            controlInfo.setCss(""\"
                   /* Styles for the funky-color-fade custom class */
                   .funky-color-fade {
                      color: var(--theme-colors-primaryText); /* Text color - taken from theme palette */
                      background: var(--theme-colors-secondary); /* Fallback color */
                      /* Gradient background for color fade effect - using theme colors */
                       background: linear-gradient(to right, var(--theme-colors-primary), var(--theme-colors-secondary));
                     \s
                      /* Additional styles for visual appeal */
                      padding: 20px;\s
                      border-radius: 10px;
                      text-align: center;
                      font-size: 18px;
                  }
                    ""\");

            controlInfo.setInitJs(null); // js to run at control initialisation - not used in this example
            controlInfo.setDestroyJs(null); // js to run at control destruction - not used in this example

            /*
            Map<String, String> includes = new HashMap<>();
            includes.put("JQUERY", "<script src=\\"https://code.jquery.com/jquery-3.6.0.min.js\\"></script>");
            includes.put("BOOTSTRAP", "<link rel=\\"stylesheet\\" href=\\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\\">");
            includes.put("FONTAWESOME", "<link rel=\\"stylesheet\\" href=\\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\\">");
            controlInfo.setIncludes(includes);
            */
            return controlInfo;
        }
        
//////////////////////////// rendering:

        Text.appendTo(vs, globalState, "Following control is Java 'ExampleJsControl' which contains Javascript/Css within the class");
        var example = ExampleJSControl.appendTo(vs,globalState);
        example.setX(globalState, 6);
        example.setY(globalState, 7);

        Timer timer = new Timer();
        Random r = new Random();
        timer.scheduleAtFixedRate(new TimerTask() {  // test updating value on custom element
            @Override
            public void run() {
                example.setX(globalState, r.nextInt(10));
            }
        }, 1000, 2000);
```""";

        // Add explanation pages (assuming this method is available and works similarly to other examples)
        addExplanationPages(parent, globalState, "Extending KewlUI via Java Custom Controls", markdownDescription, vs, java, true);
    }

    public static List<Car> generateTestData() {
        return List.of(
                new Car("Toyota", "Corolla", 20000),
                new Car("Ford", "Focus", 18000),
                new Car("Porsche", "911", 90000)
        );
    }

    public record Car(String make, String model, int price) {}


}

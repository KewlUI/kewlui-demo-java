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


import com.fasterxml.jackson.core.type.TypeReference;
import org.kewlui.demo.ui.TestApp.Pages.BasePage;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.settings.ContainerPositionEnum;
import com.gofintec.kewlui.controls.base.settings.DefaultValue;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.*;


/**
 * Example page for some 'financial like realtime data'
 *
 * This shows an example of the draggable grid, positioning a number of test windows within it
 * Updating grouping tables and charts are included within the windows
 */
public class TablePage extends BasePage
{
    private static final Logger Log = LogManager.getLogger(TablePage.class);

    public TablePage() {
        super(true);
    }


    public void addTable (VisualControl parent, StateData globalState) {

        String markdownDescription = """
### Table, Sourcing data from URL

Here we supply a dropdown box to choose the data source.  Each data source has its own URL and data format.
 
setSelection is set to true, so a checkbox is added to the row.  On selecting the checkbox, the server is informed of all selected items. 
    
""";
        var vs = new VStack(globalState);

        var dataSources = new LinkedHashMap<String,String>();
        dataSources.put("CUSTOMERS CSV","select * from CSV('{urlBase}/customers-100.csv', {headers:true})");
        dataSources.put("IRIS JSON","select * from JSON('{urlBase}/iris.json')");
        dataSources.put("ORGANISATIONS TAB DELIM","select * from TSV('{urlBase}/organisations.tab', {headers:true})  ");
        var deflt = "CUSTOMERS CSV";
        var defVal = dataSources.get(deflt);

        var hs = HStack.appendTo(vs,globalState);
        Text.appendTo(hs,globalState,"Data Source: ");
        var selection = Select.appendTo(hs,globalState, DefaultValue.set(deflt));
        selection.setOptions(globalState,dataSources.keySet().stream().toList());
        selection.setWidth(globalState,"300px");

        hs = HStack.appendTo(vs,globalState);
        hs.setBgColor(globalState,"theme.colors.secondary_30");

        Text.appendTo(hs,globalState,"SQL Query: ");
        var editPane = Editable.appendTo(hs,globalState);
        editPane.setValue(globalState, defVal);

        Markdown.appendTo(vs,globalState,"\nAbove query is run against URLs on the CLIENT side, populating the table below\n\n");

        Divider.appendTo(vs,globalState);
        var selectedText = Text.appendTo(vs,globalState,"None Selected");
        var editedText = Text.appendTo(vs,globalState,"No Edits");
        Divider.appendTo(vs,globalState);
        hs = HStack.appendTo(vs, globalState);
        var pg = Checkbox.appendTo(hs, globalState, "Enable paging", DefaultValue.set(true));
        var ed = Checkbox.appendTo(hs, globalState, "Enable editing", DefaultValue.set(true));

        Divider.appendTo(vs,globalState);

        TablePlus table = TablePlus.appendTo(vs,globalState);
        table.setSql(globalState,defVal);
        table.setSelection(globalState,true);
        table.setRowCount(globalState, 8);   // turn on paging, 10 items
        table.setHeight(globalState, "100%");
        table.setAllowEditing(globalState, true);

        // when the user changes the 'enable paging' checkbox
        pg.setOnChange(globalState,  (e) -> {
            var pagify = pg.getValue(e.clientState());
            table.setRowCount(e.clientState(), pagify ? 8 : null);   // turn on paging
        });
        // when the user changes the 'editable' checkbox
        ed.setOnChange(globalState,  (e) -> {
            var editable = (Boolean) ed.getValue(e.clientState());
            table.setAllowEditing(e.clientState(), editable);   // turn on/off editable
        });

        // as selection is on, value will be updated with all SELECTED entries.  Array of rowdata
        table.setOnClick(globalState,  (e) -> {
            var typeRef = new TypeReference<TablePlus.TableState< Map<String, Object> >>(){}; // convert to this form
            var state = e.event().getState( typeRef );
            var selectedRows = state.getSelected(); //List<Map<String,Object>>
            selectedText.setText(e.clientState(), "Server knows you selected: " + ( (selectedRows!=null)?selectedRows.size():0) + " rows: "+ selectedRows);
        });
        table.setOnChange(globalState,  (e) -> {
            var typeRef = new TypeReference<TablePlus.TableChange<Map<String, Object>>>(){}; // convert to this form
            var rawValue = table.getValue(e.clientState()); // data in a map/dictionary format
            var value = table.getValue(e.clientState(), typeRef); // same data converted to tablechange object
            var changedRows = value.getChangedRows();
            var changedFields = value.getCells(); // changes/inserts/deletes

            editedText.setText(e.clientState(), "User requested modification of: " + rawValue);
        });

        // If they choose a new data source, update the sql in edit box and table
        selection.setOnChange(globalState,  (e) -> {
            var selected = selection.getValue(e.clientState());
            var sql = dataSources.get(selected);
            editPane.setValue(e.clientState(), sql);
            table.setSql(e.clientState(),sql);
            table.setValue(e.clientState(), null);
            selectedText.setText(e.clientState(), "None Selected");
        });
        // if they manually update the sql, run it...
        editPane.setOnChange(globalState,  (e) -> {
            var sql = editPane.getValue(e.clientState());
            table.setSql(e.clientState(),sql);
            table.setValue(e.clientState(), null);
            selectedText.setText(e.clientState(), "None Selected");
        });


        String javaDescription = """
```java
    var dataSources = new LinkedHashMap<String,String>();
    dataSources.put("CUSTOMERS CSV","select * from CSV('{urlBase}/customers-100.csv', {headers:true})");
    dataSources.put("IRIS JSON","select * from JSON('{urlBase}/iris.json')");
    dataSources.put("ORGANISATIONS TAB DELIM","select * from TSV('{urlBase}/organisations.tab', {headers:true})  ");
    var deflt = "CUSTOMERS CSV";
    var defVal = dataSources.get(deflt);

    var hs = HStack.appendTo(vs,globalState);
    Text.appendTo(hs,globalState,"Data Source: ");
    var selection = Select.appendTo(hs,globalState, DefaultValue.set(deflt));
    selection.setOptions(globalState,dataSources.keySet().stream().toList());
    selection.setWidth(globalState,"300px");

    hs = HStack.appendTo(vs,globalState);
    Text.appendTo(hs,globalState,"SQL Query: ");
    var editPane = Editable.appendTo(hs,globalState);
    editPane.setValue(globalState, defVal);

    Markdown.appendTo(vs,globalState,"\\nAbove query is run against URLS, populating the table below\\n\\n");

    Divider.appendTo(vs,globalState);
    var selectedText = Text.appendTo(vs,globalState,"None Selected");
    Divider.appendTo(vs,globalState);

    TablePlus table = TablePlus.appendTo(vs,globalState);
    table.setSql(globalState,defVal);
    table.setSelection(globalState,true);

    // as selection is on, value will be updated with all SELECTED entries.  Array of rowdata
    table.setOnChange(globalState,  (e) -> {
        var selectedRows = (List<Map<String,Object>>)table.getValue(e.clientState());
        selectedText.setText(e.clientState(), "Selected: " + ( (selectedRows!=null)?selectedRows.size():0) + selectedRows.toString());
    });

    // If they choose a new data source, update the sql in edit box and table
    selection.setOnChange(globalState,  (e) -> {
        var selected = (String)selection.getValue(e.clientState());
        var sql = dataSources.get(selected);
        editPane.setValue(e.clientState(), sql);
        table.setSql(e.clientState(),sql);
        table.setValue(e.clientState(), null);
    });
    // if they manually update the sql, run it...
    editPane.setOnChange(globalState,  (e) -> {
        var sql = editPane.getValue(e.clientState());
        table.setSql(e.clientState(),sql);
    });              
```        
""";
        addExplanationPages(parent, globalState, "Table via Sql", markdownDescription, vs, javaDescription);
    }


    protected StatsCard createStatsCard (VisualControl parent, StateData globalState, String text) {
        var card = StatsCard.appendTo(parent,globalState, text);
        card.setWidth(globalState,"300px");
        card.setHeight(globalState,"100px");
        card.setBorderRadius(globalState,"10px");
        card.setBoxShadow(globalState,"2px 2px 2px black");
        return card;
    }

    public void addDashboard (VisualControl parent, StateData globalState) {

        String markdownDescription = """
## Server Side creation of Web Applications

### Dashboard example 

A few examples within interactive dashboard.   

""";
        var vs = new VStack(globalState);

        var aw = AutoWrap.appendTo(vs,globalState);

        ///////////////////////////
        // Add StatsCard control
        var stats1 = createStatsCard(aw,globalState, "System Message Rate");
        stats1.setDifference(globalState, 1.0).setDifferenceUnit(globalState, "%");
        stats1.setIcon(globalState,"MdSpeed");
        stats1.setValue(globalState,"134k");
        ///////////////////////////
        var stats2 =  createStatsCard(aw,globalState, "Free Disk Space");
        stats2.setValue(globalState,"67%");
        stats2.setIconPosition(globalState,"left").setIcon(globalState,"MdStorage");
        stats2.setDescription(globalState,"Total free 3.7 GB");
        var prog2 = Progress.appendTo(stats2,globalState).setProperty(globalState,"value",67);
        ///////////////////////////
        var statsV =  createStatsCard(aw,globalState, "Coffee Consumption");
        statsV.setWidth(globalState,"200px").setValue(globalState,"142");
        statsV.setDescription(globalState,"Cups per day");
        statsV.setVariant(globalState,"vertical");
        Image.appendTo(statsV,globalState,"{urlBase}/coffee-cup.gif", ContainerPositionEnum.NORTH).setHeight(globalState,"50px");
        ///////////////////////////
        var statsC =  createStatsCard(aw,globalState, "Safety Score");
        CircularProgress.appendTo(statsC,globalState, ContainerPositionEnum.EAST)
                .setThickness(globalState,"12px")
                .setSize(globalState,"120px")
                .setColor(globalState,"green")
                .setValue(globalState,67)
                .setText(globalState,"6.7");

        statsC.setHeight(globalState,"150px").setWidth(globalState,"250px");
        // make a background gradient color
        statsC.setBgGradient(globalState,"linear(to-r, teal.300, blue.500)");

        ///////////////////////////
        var statsSpark =  createStatsCard(aw,globalState, "Network usage");
        statsSpark.setDescription(globalState,"Total network egress usage");
        statsSpark.setBgGradient(globalState,"conic(to-t, #f0e, #f06, #f0e)");
        statsSpark.setHeight(globalState,"150px");
        var ch = Chart.appendTo(statsSpark, globalState, ContainerPositionEnum.NORTH);
        ch.setSparkLines(globalState, true).setVariant(globalState, Chart.VariantEnum.LINEBASIC );
        ch.setValue(globalState, new ArrayList<Integer>(List.of(10,20,50,20,10,60,50,30,20,40)));
        ch.setLabels(globalState, List.of("Network %")).setHeight(globalState,"50px").setWidth(globalState,"200px");
        PopupMessage msg = PopupMessage.appendTo(aw, globalState);
        msg.setStatus(globalState, PopupMessage.StatusEnum.SUCCESS);
        Button.appendTo(statsSpark,globalState,"Ping",ContainerPositionEnum.EAST).setOnClick(globalState, (e) -> {
            msg.setDescription(e.clientState(), "All Servers Pinged OK");
            msg.setValue(e.clientState(), UUID.randomUUID().toString());
        });
        ///////////////////////////

        List<ProcessInfo> testData = generateTestData();
        var table = addMachineTableExample(vs, globalState, testData);

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
        }, 1000, 2000); //

        Divider.appendTo(vs,globalState).setPadding(globalState,"30px");
        Markdown.appendTo(vs,globalState, "[Coffee cup animated icon created by Freepik - Flaticon](https://www.flaticon.com/free-animated-icons/coffee-cup)");


        String javaDescription = """
                ```java
                var aw = AutoWrap.appendTo(vs,globalState);

                    ///////////////////////////
                    // Add StatsCard control
                    var stats1 = createStatsCard(aw,globalState, "System Message Rate");
                    stats1.setDifference(globalState, 1.0).setDifferenceUnit(globalState, "%");
                    stats1.setIcon(globalState,"MdSpeed");
                    stats1.setValue(globalState,"134k");
                    ///////////////////////////
                    var stats2 =  createStatsCard(aw,globalState, "Free Disk Space");
                    stats2.setValue(globalState,"67%");
                    stats2.setIconPosition(globalState,"left").setIcon(globalState,"MdStorage");
                    stats2.setDescription(globalState,"Total free 3.7 GB");
                    var prog2 = Progress.appendTo(stats2,globalState).setProperty(globalState,"value",67);
                    ///////////////////////////
                    var statsV =  createStatsCard(aw,globalState, "Coffee Consumption");
                    statsV.setWidth(globalState,"200px").setValue(globalState,"142");
                    statsV.setDescription(globalState,"Cups per day");
                    statsV.setVariant(globalState,"vertical");
                    Image.appendTo(statsV,globalState,"{urlBase}/coffee-cup.gif", ContainerPositionEnum.NORTH).setHeight(globalState,"50px");
                    ///////////////////////////
                    var statsC =  createStatsCard(aw,globalState, "Safety Score");
                    var cp = CircularProgress.appendTo(statsC,globalState, ContainerPositionEnum.EAST)
                            .setThickness(globalState,"12px")
                            .setSize(globalState,"120px")
                            .setColor(globalState,"green")
                            .setValue(globalState,67)
                            .setText(globalState,"6.7");

                    statsC.setHeight(globalState,"150px").setWidth(globalState,"250px");
                    // make a background gradient color
                    statsC.setBgGradient(globalState,"linear(to-r, teal.300, blue.500)");

                    ///////////////////////////
                    var statsSpark =  createStatsCard(aw,globalState, "Network usage");
                    statsSpark.setDescription(globalState,"Total network egress usage");
                    statsSpark.setBgGradient(globalState,"conic(to-t, #f0e, #f06, #f0e)");
                    statsSpark.setHeight(globalState,"50px");
                    var ch = Chart.appendTo(statsSpark, globalState, ContainerPositionEnum.NORTH);
                    ch.setSparkLines(globalState, true).setVariant(globalState, Chart.VariantEnum.LINEBASIC );
                    ch.setValue(globalState, new ArrayList<Integer>(List.of(10,20,50,20,10,60,50,30,20,40)));
                    ch.setLabels(globalState, List.of("Network %")).setHeight(globalState,"50px").setWidth(globalState,"200px");
                    PopupMessage msg = PopupMessage.appendTo(aw, globalState);
                    msg.setStatus(globalState, PopupMessage.StatusEnum.SUCCESS);
                    Button.appendTo(statsSpark,globalState,"Ping",ContainerPositionEnum.EAST).setOnClick(globalState, (e) -> {
                        msg.setDescription(e.clientState(), "All Servers Pinged OK");
                        msg.setValue(e.clientState(), UUID.randomUUID().toString());
                    });
                    ///////////////////////////
                    Divider.appendTo(vs,globalState);

                    var description = Markdown.appendTo(vs,globalState,"Clicking on the table below can cause a callback");

                    Divider.appendTo(vs,globalState);

                    List<ProcessInfo> testData = generateTestData();
                                                                         
                   // create a table, set its data directly
                   TablePlus table = TablePlus.appendTo(vs,globalState);
                   table.setData(globalState, testData);
           
                   /* json string definitions also work
                   var columnDefinitions = ""\"
                   [{"key":"machineName","name":"MachineName"},{"key":"processName","name":"ProcessName"},
                    {"key":"status","name":"Status"},{"key":"utilization","name":"Utilization","type":"%.2f"},
                    {"key":"startTime","name":"StartTime","type":"DateTime"} , {"key":"controlButtons","name":"Control"}                                                                                                                                                                                                                                      \s
                   ]
                   ""\";*/
                   List<TablePlus.Column> columnDefinitions = List.of(
                           TablePlus.Column.of("machineName", "MachineName"),
                           TablePlus.Column.of("processName", "ProcessName", null, true),
                           TablePlus.Column.of("status", "Status"),
                           TablePlus.Column.of("utilization", "Utilization", "%.2f"), // sprintf format for the data
                           TablePlus.Column.of("startTime", "StartTime", "DateTime:YYYY-MM-DD HH:mm:ss"), 
                           TablePlus.Column.of("controlButtons", "Control")
                   );
           
                   // add column definiitons - we could add a list of column objects, or json string to do the same
                   table.setColumns(globalState, columnDefinitions);
                   // if they click on a row, we want to know which one - fill in detail
                   table.setOnClick(globalState,
                           (e)-> {
                               var row = event.getContext();
                               var txt = "** Table, Last Row Clicked on: ** " + row;
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
                               var typeRef = new TypeReference<TablePlus.TableState<List<Map<String, Object>>, Map<String, Object>>>(){}; // convert to this form
                               var state = e.event().getState( typeRef );
                               if (state != null) {
                                   var row = state.lastRowClicked(); //Map<String,Object>
                                   var id = (Number) row.get("id");
                                   updateTestDataStatus(testData, id.longValue(), "Running");
                                   table.setData(globalState, testData);
                               }
                           });
                   // Prerender - note we could also return false if the button doesn't make sense, which would stop it from rendering
                   buttonStart.setClientSidePreRender(globalState, "params.props.bgColor =  (params.row['status'] === 'Running') ? 'lightgray' : 'Green';");
                   buttonStop.setOnClick(globalState,
                           (e)-> {
                               var typeRef = new TypeReference<TablePlus.TableState<List<Map<String, Object>>, Map<String, Object>>>(){}; // convert to this form
                               var state = e.event().getState( typeRef );
                               if (state != null) {
                                   var row = state.lastRowClicked(); //Map<String,Object>
                                   var id = (Number) row.get("id");
                                   updateTestDataStatus(testData, id.longValue(), "Stopped");
                                   table.setData(globalState, testData);
                               }
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
                    }, 1000, 2000); //

                    Divider.appendTo(vs,globalState).setPadding(globalState,"30px");
                    Markdown.appendTo(vs,globalState, "[Coffee cup animated icon created by Freepik - Flaticon](https://www.flaticon.com/free-animated-icons/coffee-cup)");
                ```
                                """;
        addExplanationPages(parent, globalState, "Table With Controls", markdownDescription, vs, javaDescription);
    }

    public static TablePlus addMachineTableExample (VStack vs, StateData globalState, List<ProcessInfo> testData) {

        Divider.appendTo(vs,globalState);
        var description = Markdown.appendTo(vs,globalState,"Clicking on the table below can cause a callback");
        Divider.appendTo(vs,globalState);


        // create a table, set its data directly
        TablePlus table = TablePlus.appendTo(vs,globalState);
        table.setData(globalState, testData);

        /* json string definitions also work
        var columnDefinitions = """
        [{"key":"machineName","name":"MachineName"},{"key":"processName","name":"ProcessName"},
         {"key":"status","name":"Status"},{"key":"utilization","name":"Utilization","type":"%.2f"},
         {"key":"startTime","name":"StartTime","type":"DateTime"} , {"key":"controlButtons","name":"Control"}                                                                                                                                                                                                                                       
        ]
        """;*/
        List<TablePlus.Column> columnDefinitions = List.of(
                TablePlus.Column.of("machineName", "MachineName"),
                TablePlus.Column.of("processName", "ProcessName", null, true),
                TablePlus.Column.of("status", "Status"),
                TablePlus.Column.of("utilization", "Utilization", "%.2f"), // sprintf format for the data
                TablePlus.Column.of("startTime", "StartTime", "DateTime:YYYY-MM-DD HH:mm:ss"),
                TablePlus.Column.of("controlButtons", "Control")
        );

        // add column definiitons - we could add a list of column objects, or json string to do the same
        table.setColumns(globalState, columnDefinitions);
        // if they click on a row, we want to know which one - fill in detail
        table.setOnClick(globalState,
                (e)-> {
                    //var typeRef = new TypeReference<TablePlus.TableState<List<ProcessInfo>, ProcessInfo>>(){}; // convert to specific object
                    var typeRef = new TypeReference<TablePlus.TableState< Map<String, Object>>>(){}; // alternate way to accept any data types as map
                    var state = e.event().getState( typeRef );
                    if (state != null) {
                        var row = state.getLastRowClicked();
                        var txt = "** Table, Last Row Clicked on: ** " + row;
                        description.setText(e.clientState(), txt); // update just for this user
                    }
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
                    var typeRef = new TypeReference<TablePlus.TableState<Map<String, Object>>>(){}; // alternate way to accept any data types as map

                    var state = e.event().getState( typeRef );
                    if (state != null) {
                        var row = state.getLastRowClicked(); //Map<String,Object>
                        if (row!=null) {
                            var id = (Number) row.get("id");
                            updateTestDataStatus(testData, id.longValue(), "Running");
                            table.setData(globalState, testData);
                        }
                    }
                });
        // Prerender - note we could also return false if the button doesn't make sense, which would stop it from rendering
        buttonStart.setClientSidePreRender(globalState, "params.props.bgColor =  (params.row['status'] === 'Running') ? 'lightgray' : 'Green';");
        buttonStop.setOnClick(globalState,
                (e)-> {
                    var typeRef = new TypeReference< TablePlus.TableState< Map<String, Object> > >(){}; // convert to this form
                    var state = e.event().getState( typeRef );
                    if (state != null) {
                        var row = state.getLastRowClicked(); //Map<String,Object>
                        var id = (Number) row.get("id");
                        updateTestDataStatus(testData, id.longValue(), "Stopped");
                        table.setData(globalState, testData);
                    }
                });
        buttonStop.setClientSidePreRender(globalState, "params.props.bgColor =  (params.row['status'] === 'Running') ? 'Red' : 'lightgray';");

        var badge = Badge.appendTo(table,globalState);
        badge.setName(globalState, "status"); // call this status, thus this will be used to show status
        badge.setWidth(globalState,"100px");
        badge.setClientSidePreRender(globalState, """
            params.text = params.value; // set the badge text to the value passed from the row
            params.props.colorScheme = (params.value === "Running") ? "green" : "red"; 
        """); // yes, we can modify behaviour on the client side before control is rendered

        return table;
    }

    protected static void updateTestDataStatus (List<ProcessInfo> testData, long id, String status) {
        for (ProcessInfo process : testData) {
            if (process.getId() == id) {
                process.setStatus(status);
                break; // Stop searching once the matching ID is found and updated
            }
        }
    }

    protected static void updateTestDataUtilisation (List<ProcessInfo> testData) {
        for (ProcessInfo process : testData) {
            double utilisation = ((Math.random() * 100) + 3*process.getUtilization())/4.0;
            process.setUtilisation(utilisation);
        }
    }

    public static List<ProcessInfo> generateTestData() {
            List<ProcessInfo> processes = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                processes.add(new ProcessInfo(
                        i, // ID
                        "Machine " + (i*127)%4,
                        "Process " + i,
                        (i % 2 == 0) ? "Running" : "Stopped",
                        Math.random() * 100,
                        LocalDateTime.now().minusMinutes(i * 10)
                ));
            }
            return processes;
        }

    public static class ProcessInfo {
        private long id;
        private String machineName;
        private String processName;
        private String status;
        private double utilization;
        private LocalDateTime startTime;

        public ProcessInfo () {

        }

        // Constructor
        public ProcessInfo (long id, String machineName, String processName, String status, double utilization, LocalDateTime startTime) {
            this.id = id;
            this.machineName = machineName;
            this.processName = processName;
            this.status = status;
            this.utilization = utilization;
            this.startTime = startTime;
        }

        // Getters for each field
        public long getId () {
            return id;
        }

        public String getMachineName () {
            return machineName;
        }

        public String getProcessName () {
            return processName;
        }

        public String getStatus () {
            return status;
        }

        public double getUtilization () {
            return utilization;
        }

        public LocalDateTime getStartTime () {
            return startTime;
        }

        public void setStatus (String status) {
            this.status = status;
        }

        public void setUtilisation (double status) {
            this.utilization = status;
        }
    }

}

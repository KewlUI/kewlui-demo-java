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


import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.settings.OverflowEnum;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Data example page - gives an explanation of the data binding within the client/server system
 *
 */
public class DataBindingPage
{
    private static final Logger Log = LogManager.getLogger(DataBindingPage.class);

    public void addMainPage (VisualControl parent, StateData globalState) {

        parent.setOverflowY(globalState, OverflowEnum.HIDDEN);
        var vstack = VStack.appendTo(parent,globalState);

        addTopText( vstack, globalState);
    }

    public void addStatePage (VisualControl parent, StateData globalState) {
        var vstack = VStack.appendTo(parent,globalState);
        addStateExplanation( vstack, globalState);
    }


    // Add a text card to the top of the window, giving a quick description of the page
    protected void addTopText(VisualControl vstack, StateData globalState)
    {
        String markdownDescription = """
## KewlUI Data Binding
        """;

        BasePage.MyCardComponent cd = BasePage.MyCardComponent.addHorizontalDescriptionCard(vstack, globalState, markdownDescription);
        var leftMarkdown = Markdown.appendTo(cd.getDescriptionPanel(), globalState, Markdown.ControlsEnum.ALL);
        leftMarkdown.setWidth(globalState,"95%").setHeight(globalState,"100%");
        var text = """
###Data Binding

Data and controls can be auto-synchronized between client and server, simplifying building a dashboard.

Some examples include:

- Global/User states
    - Dashboard controls have state - either for all users (global), or for a specific user (user state)
    - Changes on the server side control will be auto-sent to client UIs
    - Values updated on the client side will be auto sent to the server
- DataTable SQL.  "Client side SQL engine"
    - Client UI contains a SQL engine that can query data (CSV,JSON,etc) from your given URLS into client data table
    - Client controls can use SQL to query local data table, allowing filtering, sorting, etc
    - Regular sql re-query - set the data to update from the server(s) at regular intervals
- Synchronized DataTable
    - Server side DataTable can be updated, all subscribed clients will receive any updates
    - Client controls can use SQL to query Synced DataTables, updated table will auto update linked controls
- FormContext Allows multiple controls to be associated with a single data name
- Callbacks Client events calling back on the server side code        
    
See specific examples under the "Data Binding" bar on the left of the dashboard.          
           """;
        leftMarkdown.setText(globalState, text);

    }

    private void addStateExplanation (VStack vstack, StateData globalState)
    {
        String markdownDescription = """
## GlobalState vs User State

Within application forms, there are two types of states: Global State and User State.\n

The single Global State contains controls and data shared across the application, shared across ALL users, 
typically used for base setup - common controls and look and feel.\n
 
On the other hand, User State holds controls and data specific to an individual user - typically anything that has changed or is specific to a user.
 
What any user sees at any time is the based on initial global state, overridden by any specific changes in the user state.

This helps keep memory usage low while still allowing configurability.

Whenever a control is altered in a (client or global) state, these changes are automatically synchronized with the appropriate users.
 
This ensures a seamless and personalized experience for each user while maintaining common functionalities through the Global State.
        """;

        BasePage.MyCardComponent cd = BasePage.MyCardComponent.addHorizontalDescriptionCard(vstack, globalState, markdownDescription);
        var leftMarkdown = Markdown.appendTo(cd.getDescriptionPanel(), globalState, Markdown.ControlsEnum.ALL);
        leftMarkdown.setWidth(globalState,"95%").setHeight(globalState,"100%");
        var text = """
###Global State
KewlUI utilize a "global" state that is shared among all users.  This forms the "base default look" of the application.

This state includes components and controls, contributing to reduced complexity and memory usage of the application. 

Any update to the global state data reflects across all users, ensuring consistency. 

- There is single Global State for a form, reducing memory usage when many users.
 -Updating global state it will cause updates for all users 
- Global state is first set up at initial form creation time though can be modified at runtime
                      
           """;
        leftMarkdown.setText(globalState, text);

        var rightMarkdown = Markdown.appendTo(cd.getCodePanel(), globalState, Markdown.ControlsEnum.ALL);
        rightMarkdown.setWidth(globalState,"95%").setHeight(globalState,"100%");
         text = """
###User State
          
- The User State is unique to each individual user who is logged in. 
- Changes made within this state are only visible to the respective user.
- Examples of user state changes include:
    - User changing the value in a text box, causing the text box value to be updated in the server user state
    - Adding or modifying controls on the server user state, update only visible to the respective user.  
    - Updating a user data store (e.g. data table), causing other controls to be updated
       
For example, the following button starts using the "global" definition
           
Clicking on the button below will set/change the user state for the control, which has a higher priority than the global state.   
           """;

        rightMarkdown.setText(globalState, text);

        // add button with callback
        Button theButton = Button.appendTo(cd.getCodePanel(), globalState);
        theButton.setText(globalState, "Global State Text - press me");

        // please note that the callbacks clientState can/will be different to the components default/global state
        theButton.setOnClick(globalState, (e)->{
            var counter = e.clientState().getOurUserData("counter", ()->new AtomicLong());
            theButton.setText(e.clientState(), "User State Text, Count: "+counter.incrementAndGet());
        });
    }


    public void addUserTablePage (VisualControl parent, StateData globalState)
    {
        var vstack = VStack.appendTo(parent,globalState);

        String markdownDescription = """
## Data Table - Sql Engine
Each client has a mini sql engine that can be used to retrieve data from external data sources.
Various controls (charts,tables,lists,etc) can then be driven from this data, which may be set to update at regular intervals       
        """;

        BasePage.MyCardComponent cd = BasePage.MyCardComponent.addHorizontalDescriptionCard(vstack, globalState, markdownDescription);
        var leftMarkdown = Markdown.appendTo(cd.getDescriptionPanel(), globalState, Markdown.ControlsEnum.ALL);
        leftMarkdown.setWidth(globalState,"95%").setHeight(globalState,"100%");
        var text = """

###DataTable - SQL query driven

Client side tables are driven by sql, and can be used to retrieve data from external data sources
  
- Can load data from external data sources using sql, supported load formats:
    - CSV
    - JSON
    - XML
    - TAB delimited
-  Data tables can be reference other client side data tables
    - RAW_PRICES -> select * from JSON(...URL...)
    - AGG_PRICES -> select symbol, avg(price) from RAW_PRICES group by symbol  
-  SQL can first apply moustache substitution, 
    - e.g. select * from TABLE where username='{{name}}'
    - This allows queries (including URLS) to be parameterized on a per client basis 
- setReloadMs - if set, the query will be rerun every reload X milliseconds
    - Any watchers of this table (e.g. controls) will automatically be re-rendered
           """;
        leftMarkdown.setText(globalState, text);

        var rightMarkdown = Markdown.appendTo(cd.getCodePanel(), globalState, Markdown.ControlsEnum.ALL);
        rightMarkdown.setWidth(globalState,"95%").setHeight(globalState,"100%");
        text =
                """
                ###Example server side code (java)
                ```java
                var dataTable = DbTable.appendTo(parent, globalState);                
                dataTable.setTableName(globalState,"TEST_ORGS");
                dataTable.setColumnIndexes(globalState, Arrays.asList("symbol","name")); 
                dataTable.setDataSql(globalState, "select * from CSV(\\"https://media.githubusercontent.com/media/datablist/sample-csv-files/main/files/organizations/organizations-100.csv\\", {headers:true})");
                dataTable.setReloadMs(globalState,1000*60*10); // every 10 minutes, reload the url, update dependent controls
                // later - use the data table "TEST_ORGS" - populate control
                var gridTable = GroupTable.appendTo(container,globalState);
                gridTable.setTableName(globalState, "TEST_ORGS");
                ```          
                """;

        rightMarkdown.setText(globalState, text);

        AddExternalData(globalState, cd.getCodePanel());
    }

    private static void AddExternalData (StateData globalState, VisualControl parent)
    {
        // Create a table that is downloaded from https://github.com/datablist/sample-csv-files/raw/main/files/people/people-1000.csv
        // in this case, the data is in CSV format, so we load the data by using a sql statement
        var dataTable = DbTable.appendTo(parent,globalState);
        dataTable.setTableName(globalState,"ORGANISATIONS");
        dataTable.setColumnIndexes(globalState, Arrays.asList("symbol","tenor,strike"));
        dataTable.setDataSql(globalState,"select * from CSV(\"https://media.githubusercontent.com/media/datablist/sample-csv-files/main/files/organizations/organizations-100.csv\", {headers:true})");
        dataTable.setReloadMs(globalState,1000*60*10); // every 10 minutes, reload the url, replace the data in the table, re-render to watchers

        var rightMarkdown = Markdown.appendTo(parent, globalState, Markdown.ControlsEnum.ALL);
        rightMarkdown.setWidth(globalState,"95%").setHeight(globalState,"100%");

        var text = """
                ### Example 2
                Following chart control source from client side DbTable 'ORGANISATIONS'\n
                Firstly, 'ORGANISATIONS' datatable is loaded from CSV via url: \"https://media.githubusercontent.com/media/datablist/sample-csv-files/main/files/organizations/organizations-100.csv\"\n
                
                We can then tell chart to loads from the 'ORGANISATIONS' table using the following sql: 
                - select Country as [Label], count(*) as [Value] from ORGANISATIONS where Country like 'U%' group by Country order by Country\n
                
                here [Label] is the y-axis text, [Value] is the x-axis value
                
                ** Note if this chart stops working in the future, it is because the data source has stopped cross origin sharing **
                """;
        rightMarkdown.set(globalState, text);

        var chart1 = Chart.appendTo(parent,globalState, "Organisations by Country, starting with U");
        chart1.setWidth(globalState,"500px");
        chart1.setVariant(globalState, Chart.VariantEnum.BARSBASICVERTICAL);
        chart1.setSql(globalState,"select Country as [label], count(*) as [value] from ORGANISATIONS where Country like 'U%' group by Country order by Country");
        chart1.setWatch(globalState, Arrays.asList("ORGANISATIONS")); // watch the CONSTITUENTS table and auto update on change
    }


    public void addSyncedDatatable (VisualControl parent, StateData globalState)
    {
        var vstack = VStack.appendTo(parent,globalState);

        String markdownDescription = """
## Synced Datatable
A datatable on the server may be defined in either the global or the user state.  
Once added to the form, the contents of the table will be auto synced to the clients. 
        """;

        BasePage.MyCardComponent cd = BasePage.MyCardComponent.addHorizontalDescriptionCard(vstack, globalState, markdownDescription);
        var leftMarkdown = Markdown.appendTo(cd.getDescriptionPanel(), globalState, Markdown.ControlsEnum.ALL);

        leftMarkdown.setWidth(globalState,"95%").setHeight(globalState,"100%");
        var text = """
###Synced DataTable Features

- After initial sync, only changes to the datatable will be sent to the clients
- Client has a named local copy of the datatable which can be used by controls:
    - Directly to control, e.g. aggregating grid control
    - Using the SQL engine, data may be flexibly transformed into the control      
    
Note - for safety, server side requires write locking to occur on the datatable while it is being updated
This avoid partial updates/state being sent to the clients.                 
           """;
        leftMarkdown.setText(globalState, text);

        var rightMarkdown = Markdown.appendTo(cd.getCodePanel(), globalState, Markdown.ControlsEnum.ALL);

        cd.getDescriptionPanel().setWidth(globalState,"40%");
        cd.getCodePanel().setWidth(globalState,"60%");

        rightMarkdown.setWidth(globalState,"75%").setHeight(globalState,"100%");
        text = """
                ###Server Side example:

                Firstly we create a recordstore for holding the table data.  A RecordStore is a collection of updatable record objects.
                Each record has a change sequence number for tracking changes.

                We then create a datatable, which gets its data from the record store.

                ```java
                    // Create a record store for storing the data - this is where we update the data
                    RecordStore<RiskReportRow> recordStore = new RecordStore<RiskReportRow>();
                    
                    // create datatable, which gets its data from the record store
                    var dataTable = DbTable.appendTo(parent,global); 
                    dataTable.setTableName(global,"testRiskTable");
                    dataTable.setValue(global,recordStore);
                ```
                \n
                As an example of Updating the recordstore, we lock and update the sequence

                ```java

                    try (var guard = new LockGuard.Write(globalState)) {
                                                           
                        // Step 1 - perform updates to the data (here just simple insert/add)
                        for (int ii = 0; ii < 10000; ++ii) {
                            var rr = new RiskReportRow(symbols.get(ii%symbols.size()), tenors.get(ii%tenors.size()), strikes.get(ii%strikes.size()), types.get(ii%types.size()),
                                    randNum.get(), randNum.get(), randNum.get(), randNum.get(), randNum.get());
                            recordStore.upsertRecord(rr);
                        }
                        
                        var row = recordStore.getByPos(0); // to update, use getByPos
                        row.setDelta(roundCents((rr.getDelta() + randNum.get())  *0.99)); // update row value
                        row.upsertRecord(row); // update the record
                        
                        // step 2 - update the dataTable as "changed", so it will be reflected on the clients
                        dataTable.setChanged(globalState);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                ```
                The datatable "testRiskTable" will then be updated/sent to the clients 
""";

        rightMarkdown.setText(globalState, text);

    }

}

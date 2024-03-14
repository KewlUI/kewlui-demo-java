package org.kewlui.demo.ui.TestApp.Forms;

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
import org.kewlui.demo.ui.TestApp.CustomControls.ThemeVariants;
import org.kewlui.demo.ui.TestApp.Model.RiskReportRow;
import org.kewlui.demo.ui.TestApp.Pages.Components.ChartPage;
import org.kewlui.demo.ui.TestApp.Pages.Components.ContainerPage;
import org.kewlui.demo.ui.TestApp.Pages.Components.ControlPage;
import org.kewlui.demo.ui.TestApp.Pages.Components.PopupPage;
import org.kewlui.demo.ui.TestApp.Pages.DataBindingPage;
import org.kewlui.demo.ui.TestApp.Pages.Examples.ChartExamples;
import org.kewlui.demo.ui.TestApp.Pages.Examples.RealtimePage;
import org.kewlui.demo.ui.TestApp.Pages.Examples.TablePage;
import org.kewlui.demo.ui.TestApp.Pages.Examples.TemplateExamples;
import org.kewlui.demo.ui.TestApp.Pages.ThemingTemplating;
import com.gofintec.kewlui.base.*;
import com.gofintec.kewlui.base.databinding.RecordStore;
import com.gofintec.kewlui.base.databinding.SequenceNumberGenerator;
import com.gofintec.kewlui.base.util.LockGuard;
import com.gofintec.kewlui.builders.SidebarBuilder;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.custom.CustomControl;
import com.gofintec.kewlui.controls.base.settings.ContainerPositionEnum;
import com.gofintec.kewlui.controls.base.settings.FontWeightEnum;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Supplier;

import static com.gofintec.kewlui.base.ControlRequestReply.Ok;


/**
 * Constructs a dashboard form with various interactive components.
 * This class demonstrates the creation of a top-level dashboard page, integrating components
 * and pages through a tree structure for navigation.
 *
 * This page is registered by ui.getComponentFactory().setBuilder to map a component endpoint to a page
 */
public class DashboardForm {
    private static final Logger Log = LogManager.getLogger(DashboardForm.class);

    // Pages used within the dashboard
    private final RealtimePage realtimePage = new RealtimePage();
    private final DataBindingPage dataBindingPage = new DataBindingPage();
    private final ContainerPage containerPage = new ContainerPage();
    private final ControlPage controlPage = new ControlPage();
    private final ChartPage chartPage = new ChartPage();
    private final PopupPage eventPage = new PopupPage();
    private final ThemingTemplating localisationPage = new ThemingTemplating();
    private final TablePage tablePage = new TablePage();
    private final TemplateExamples templatePage = new TemplateExamples();

    private final ChartExamples chartExamplesPage = new ChartExamples();


    private static final String USER_NAME = "userName";

    /**
     * Creates the dashboard page, organizing its layout and content.
     *
     * @param type The type of dashboard to create.
     * @param optionalCreationInfo Additional information for dashboard creation.
     * @return The constructed Form object representing the dashboard.
     */
    public Form createDashboardPage(String type, String optionalCreationInfo) {
        Form form = Form.create();
        var top = form.getMainPanel();
        var globalState = form.getGlobalState();
        top.setFontFamily(globalState, "Calibri, Arial, sans-serif");
        addCustomControls();

        // add from json file, all Material Design icons, e.g. 'MdDescription'
        form.setIconUrls(List.of("{urlBase}/resources/mdicons.json"));

        try  {
            var dashboard = DashboardLayout.appendTo(top, globalState);

            addSyncedDataTable(globalState, dashboard);
            addApplicationPages(globalState, dashboard);
            var navbar = NavBarSimple.appendTo(dashboard, globalState, ContainerPositionEnum.HEADER);
            addNavbarSimple(globalState, navbar);
            ThemeVariants.addThemesAndVariants(globalState, form);
            return form;
        } catch (Exception e) {
            Log.error("");
            throw new RuntimeException(e);
        }
    }

    /**
     * Register custom controls with the central registry
     * This allows control javascript etc to be automatically be added to
     */
    private void addCustomControls () throws RuntimeException {
        try {
            CustomControl.registerClass(ExampleJSControl.class);
            CustomControl.registerClass(AgGridControl.class);
        } catch (Exception ex) {
            Log.error("Error in demo, could not register custom controls!!!");
            throw new RuntimeException(ex);
        }
    }


    /**
     * Adds application pages to the dashboard.
     *
     * @param globalState The global state shared across pages.
     * @param dashboard The dashboard layout to add pages to.
     */
    private void addApplicationPages(StateData globalState, DashboardLayout dashboard) {

        //Create a tree of application pages on the sidebar
        // first param, tree representation of the page
        // second param, MarkDown to show the user
        // third param, page that will open on click
        var sideBar = SidebarBuilder.begin()
                .addPage("Examples","**Examples**", null, true)
                .addPage("Examples/Realtime","Realtime", (parent, state)-> realtimePage.addPage(parent,state))
                .addPage("Examples/Dashboard","Dashboard", (parent, state)-> tablePage.addDashboard(parent,state))
                .addPage("Examples/Tables","Tables", (parent, state)-> tablePage.addTable(parent,state))
                .addPage("Examples/ServerTemplate","Templates ", (parent, state)-> templatePage.addTemplatingExamples(parent,state))
                .addPage("Examples/ChartTemplate","Charts ", (parent, state)-> chartExamplesPage.addTemplatingExamples(parent,state))


                .addPage("Components", "**Components**", null, false)
                .addPage("Components/Containers","Containers", (parent, state)-> containerPage.AddOtherPositions(parent,state))
                .addPage("Components/Controls","Controls", (parent, state)-> controlPage.AddControlOverview(parent,state))
                .addPage("Components/Charts","Charts", (parent, state)-> chartPage.AddChartOverview(parent,state))
                .addPage("Components/Window","GridWindow", (parent, state)-> containerPage.addGridPage(parent,state))
                .addPage("Components/Popups","Popups", (parent, state)-> eventPage.AddEventExample(parent,state))
                .addPage("Components/Extending","Extending (JS/React)", (parent, state)-> controlPage.addExtendControl(parent,state))

                .addPage("Data","Data Binding", (parent, state)-> dataBindingPage.addMainPage(parent,state))
                .addPage("Data/State","Global/User states", (parent, state)-> dataBindingPage.addStatePage(parent,state))
                .addPage("Data/DatatableSql","DataTable SQL", (parent, state)-> dataBindingPage.addUserTablePage(parent,state))
                .addPage("Data/Synced","Synced DataTable", (parent, state)-> dataBindingPage.addSyncedDatatable(parent,state))

                .addPage("Theming","Templating/Theming", (parent, state)-> localisationPage.addThemingExamples(parent,state))
                .addPage("GitHub","[GitHub](https://github.com/KewlUI)", null)

                .appendTo(dashboard,globalState);
        Text.appendTo(sideBar, globalState, "Version 1.24.1", ContainerPositionEnum.SOUTH);
    }


    /**
     * Rounds a double value to two decimal places.
     *
     * @param value The value to round.
     * @return The rounded value.
     */
    private static double roundCents(double value) {
        return Math.round(value*100)/100.0;
    }

    /**
     * Adds a synchronized data table to the dashboard.
     *
     * @param global The global state object.
     * @param parent The parent visual control.
     */
    private void addSyncedDataTable (StateData global, VisualControl parent) {

        var dataTable = DbTable.appendTo(parent,global);
        dataTable.setTableName(global,"testRiskTable");
        dataTable.setColumnIndexes(global,Arrays.asList("symbol","tenor,strike"));

        // lets store the global record store in the global state
        RecordStore<RiskReportRow> rs = global.getOurUserData("testRiskTable", ()-> new RecordStore<>());
        dataTable.setValue(global,rs);

        var symbols = Arrays.asList("EURUSD","GBPUSD","USDJPY","AUDUSD","USDCHF","USDNOK","USDSEK");
        var tenors = Arrays.asList("  1M","  3M","  6M"," 1Y"," 3Y"," 5Y","10Y","20Y");
        var strikes = Arrays.asList("100","200","300","400","500","600","700","800","900","1000");
        var types = Arrays.asList("CALL","PUT");

        Random r = new Random();
        double rangeMin = -20000;
        double rangeMax = 20000;
        var range = rangeMax - rangeMin;
        Supplier<Double> randNum = ()-> rangeMin+(roundCents(r.nextDouble()*range));

        try (var guard = new LockGuard.Write(rs)) {
            // On any update, step 1 - update the global sequence number
            SequenceNumberGenerator.getNextSeqNum();
            // Step 2 - perform updates to the data (here just simple insert/add)
            for (int ii = 0; ii < 10000; ++ii) {
                var rr = new RiskReportRow(symbols.get( getRand(symbols.size()) ), tenors.get(  getRand(tenors.size()) ), strikes.get(  getRand(strikes.size())), types.get(  getRand(types.size())),
                        randNum.get(), randNum.get(), randNum.get(), randNum.get(), randNum.get());
                rs.upsertRecord(rr);
            }
            // step 3 - update the control as "changed", so it will be reflected on the client
            dataTable.setChanged(global);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // set some updates....
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Random rand = new Random(System.currentTimeMillis());
                try (var guard = new LockGuard.Write(global))
                {
                    SequenceNumberGenerator.getNextSeqNum(); // tick forward the sequence number - IMPORTANT

                    for (int ii = 0; ii < 1000; ++ii) {
                        int pos = rand.nextInt(rs.size());
                        var rr = rs.getByPos(pos);
                        switch(rand.nextInt(5)) {
                            case 0:
                                rr.setDelta(roundCents((rr.getDelta() + randNum.get())  *0.99));
                                rs.upsertRecord(rr);
                                break;
                            case 1:
                                rr.setGamma(roundCents((rr.getGamma() + randNum.get())  *0.99));
                                rs.upsertRecord(rr);
                                break;
                            case 2:
                                rr.setTheta(roundCents((rr.getTheta() + randNum.get())  *0.99));
                                rs.upsertRecord(rr);
                                break;
                            case 3:
                                rr.setVega(roundCents((rr.getVega() + randNum.get())  *0.99));
                                rs.upsertRecord(rr);
                                break;
                            case 4:
                                rr.setRho(roundCents((rr.getRho() + randNum.get())  *0.99));
                                rs.upsertRecord(rr);
                                break;
                        }
                    }
                    dataTable.setChanged(global); // update the control - will be elligble for update (global data)

                    // guard will now unlock, and all changes will in effect be bundles in a transaction upload
                } catch (Exception e) {
                    Log.error(e);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 800);
    }

    Random rnd = new Random();
    private int getRand(int maxVal) {
        int x = (rnd.nextInt(0,maxVal));
        return x;
    }

    /**
     * Adds a simple navigation bar to the dashboard.
     *
     * @param state The state data to use.
     * @param nb The visual control representing the navigation bar.
     */
    private static void addNavbarSimple (StateData state, VisualControl nb) {

        var text = Heading.appendTo(nb,state,"KewlUI");
        text.setContainerPosition(state, ContainerPositionEnum.WEST);
        text.setProperty(state, "transform", "skewY(-5deg)");
        text.setFontWeight(state, FontWeightEnum.BOLD);

        var select = Select.appendTo(nb,state,"defaultTheme,solarFlare,green,darkFrost,darkMono,darkMoss,darkLilac,darkForest,darkMatrix,newElegance,vibrantContrast,girlChic,grayPrecision,customTheme,defaultTheme", ContainerPositionEnum.EAST);
        select.setOnChange(state, (e)->{
            var theme = select.getValue(e.clientState()); // get the theme key chosen
            e.clientContext().getForm().setTheme(e.clientState(), theme); // on the form, set the theme
        });
        select.setBorderEffects(state, "cyberpunk");

        var popover = PopoverSimple.appendTo(nb,state, ContainerPositionEnum.EAST);
        {
            var ib = ImageButton.appendTo(popover,state,ContainerPositionEnum.BUTTON);
            ib.setBorderRadius(state, "full").setWidth(state, "40px").setHeight(state, "40px");
            ib.setSrc(state, "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=50&h=50&q=80");

            var b = Button.appendTo(popover,state,"Example");
            b.setWidth(state, "100%");
            Divider.appendTo(popover,state);
            b = Button.appendTo(popover,state,"Settings");
            b.setIcon(state,"MdOutlineSettings");
            b.setWidth(state, "100%");
            Divider.appendTo(popover,state);
            b = Button.appendTo(popover,state,"Billing");
            b.setWidth(state, "100%");
        }

        var modalDialog = ModalDialog.appendTo(nb,state);
        {
            // add header
            Text.appendTo(modalDialog,state,"Example Modal Dialog Header", ContainerPositionEnum.HEADER);

            // add buttons to footer
            var ok  = Button.appendTo(modalDialog,state,"OK", ContainerPositionEnum.FOOTER);
            var cancel  = Button.appendTo(modalDialog,state,"CANCEL", ContainerPositionEnum.FOOTER);
            ok.setOnClick(state, (e)->{});
            cancel.setOnClick(state, (e)->{});

            // add markdown in main section of modelDialog
            var mu = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.";
            Markdown.appendTo(modalDialog,state,mu);
        }
        EventCallback openDialogFunc =  (e)-> modalDialog.setValue(e.clientState(),true); // open dialog

        var menuDrop = MenuDrop.appendTo(nb,state, "Dashboard");
        MenuItem.appendTo(menuDrop,state,"Example Option").setOnClick(state, openDialogFunc);
        MenuItem.appendTo(menuDrop,state,"Load Page").setOnClick(state, openDialogFunc);
        MenuItem.appendTo(menuDrop,state,"Save Page").setOnClick(state, openDialogFunc);


        menuDrop = MenuDrop.appendTo(nb,state, "Design");
        var b = MenuItem.appendTo(menuDrop,state,"Amazing Designs");
        Divider.appendTo(menuDrop,state);
        b = MenuItem.appendTo(menuDrop,state,"Great Guacamole");
    }



    /**
     * Handles user requests for the DashboardForm.
     *
     * @param requestEvent The event triggered by a user request.
     * @return A ControlRequestReply indicating the result of the request.
     */
    public static ControlRequestReply setupUniqueStateForClient (ControlRequestEvent requestEvent)
    {
        ClientSession clientSession = requestEvent.getClientSession(); // browser tab
        ClientOverview overview = clientSession.getClientOwner();  // browser user, holds many possible tabs

        if (!overview.isLoggedIn()) {
            //return ControlRequestReply.Fail("User not logged in");
        }
        Log.info("Dashboard load  for session "+clientSession.getSessionId()+ " for user " + overview.getUserName());
        return Ok();
    }




}

package com.gofintec.app.ui.TestApp.Forms;

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


import com.gofintec.app.ui.TestApp.CustomControls.ExampleJSControl;
import com.gofintec.app.ui.TestApp.Pages.*;
import com.gofintec.app.ui.TestApp.Model.RiskReportRow;
import com.gofintec.kewlui.base.*;
import com.gofintec.kewlui.base.databinding.RecordStore;
import com.gofintec.kewlui.base.databinding.SequenceNumberGenerator;
import com.gofintec.kewlui.base.util.LockGuard;
import com.gofintec.kewlui.builders.SidebarBuilder;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.custom.CustomControl;
import com.gofintec.kewlui.controls.base.settings.*;
import com.gofintec.kewlui.controls.base.theme.VisualStyle;
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
    private final DataPage dataPage = new DataPage();
    private final ContainerPage containerPage = new ContainerPage();
    private final ControlPage controlPage = new ControlPage();
    private final ChartPage chartPage = new ChartPage();
    private final EventPage eventPage = new EventPage();
    private final ThemingTemplating localisationPage = new ThemingTemplating();
    private final TablePage tablePage = new TablePage();
    private final TemplateExamples templatePage = new TemplateExamples();


    private static final String USER_NAME = "userName";

    /**
     * Creates the dashboard page, organizing its layout and content.
     *
     * @param type The type of dashboard to create.
     * @param optionalCreationInfo Additional information for dashboard creation.
     * @return The constructed Form object representing the dashboard.
     */
    public Form createDashboardPage(String type, String optionalCreationInfo) {
        Form form = new Form();
        var top = form.getMainPanel();
        var globalState = form.getGlobalState();
        addCustomControls();

        try (var guard = new LockGuard.Write(globalState)) {
            var dashboard = DashboardLayout.appendTo(top, globalState);

            addSyncedDataTable(globalState, dashboard);
            addApplicationPages(globalState, dashboard);
            var navbar = NavBarSimple.appendTo(dashboard, globalState, ContainerPositionEnum.HEADER);
            addNavbarSimple(globalState, navbar);
            addCustomTheme(globalState, form);
            return form;
        } catch (Exception e) {
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

                .addPage("Components", "**Components**", null, true)
                .addPage("Components/Containers","Containers", (parent, state)-> containerPage.AddOtherPositions(parent,state))
                .addPage("Components/Controls","Controls", (parent, state)-> controlPage.AddControlOverview(parent,state))
                .addPage("Components/Charts","Charts", (parent, state)-> chartPage.AddChartOverview(parent,state))
                .addPage("Components/Window","GridWindow", (parent, state)-> containerPage.addGridPage(parent,state))
                .addPage("Components/Popups","Popups", (parent, state)-> eventPage.AddEventExample(parent,state))
                .addPage("Components/Extending","Extending (JS/React)", (parent, state)-> controlPage.addExtendControl(parent,state))

                .addPage("Data","Data Binding", (parent, state)-> dataPage.addMainPage(parent,state))
                .addPage("Data/State","Global/User states", (parent, state)-> dataPage.addStatePage(parent,state))
                .addPage("Data/DatatableSql","DataTable SQL", (parent, state)-> dataPage.addUserTablePage(parent,state))
                .addPage("Data/Synced","Synced DataTable", (parent, state)-> dataPage.addSyncedDatatable(parent,state))

                .addPage("Theming","Templating/Theming", (parent, state)-> localisationPage.addThemingExamples(parent,state))
                .addPage("GitHub","[GitHub](https://github.com/KewlUI)", null)

                .appendTo(dashboard,globalState);
        Text.appendTo(sideBar, globalState, "Alpha Version 0.0.1", ContainerPositionEnum.SOUTH);
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
                var rr = new RiskReportRow(symbols.get(ii%symbols.size()), tenors.get(ii%tenors.size()), strikes.get(ii%strikes.size()), types.get(ii%types.size()),
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

        var select = Select.appendTo(nb,state,"defaultTheme,solarFlare,green,newElegance,vibrantContrast,girlChic,grayPrecision,customTheme", ContainerPositionEnum.EAST);
        select.setOnChange(state, (eventName, context,  control, clientstate, event)->{
                var theme = select.getValue(clientstate);
                context.getForm().setTheme(clientstate,theme);
        });

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
            ok.setOnClick(state, (eventName, clientContext, control, clientState, event)->{});
            cancel.setOnClick(state, (eventName, clientContext, control, clientState, event)->{});

            // add markdown in main section of modelDialog
            var mu = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.";
            Markdown.appendTo(modalDialog,state,mu);
        }
        EventCallback openDialogFunc =  (eventName, clientContext, control, clientState, event)-> modalDialog.setValue(clientState,true); // open dialog

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
    public static ControlRequestReply userPageRequest (ControlRequestEvent requestEvent)
    {
        Log.info("Requesting dashboard for session "+requestEvent.getSessionInfo().getSessionId()+ " for user "+requestEvent.getSessionInfo().getUserServerStorage().get("userName"));

        var userInfo = setupClientSessionInformation(requestEvent.getSessionInfo());

        if (userInfo.containsKey(USER_NAME)) {
            var componentAndUserState = requestEvent.getComponentAndState();
            ////////////////////////////////
            // use control and state to add in any  controls/values which are completely specific to this user
            // in this example, we are routed here so we'll just use the parent controls values for any templating....
            return Ok();
        }
        return ControlRequestReply.Fail("User not logged in");
    }


    // Here we either get or create any information we wish to store about the user
    protected static Map<String, Object> setupClientSessionInformation (ClientSession sessionInfo)
    {
        // in this case, we check ClientSession information, check or add to general info on the session/user etc
        Map<String, Object> userServeSideInfo = sessionInfo.getUserServerStorage();
        String userName = (String)userServeSideInfo.get(USER_NAME); // check if it contains the users name
        if (userName==null) {
            // user is not logged in, so we could throw an exception to stop the user going any further
            // or show a login screen, or perform some other action
            // in this case though, we'll let them proceed and just setup a dummy username
            userName = "Users Name";
            userServeSideInfo.put(USER_NAME, userName); // pretend we have logged in etc
        }
        return userServeSideInfo;
    }


    /**
     * Adds custom theming to the dashboard.
     *
     * @param globalState The global state to apply the theme to.
     * @param form The form to add the custom theme to.
     */
    private void addCustomTheme (StateData globalState, Form form) {
        /*
            Primary Color: Choose the most vibrant or dominant color from the palette as the primary color. This color will be used for the most important interactive elements like primary action buttons, active menu items, and key highlights. If "The Deep Blue" palette includes a standout blue, for instance, it could serve as a strong primary color that draws attention and encourages interaction.
            Secondary Color: Select a color that complements the primary color yet is distinct enough to be used for secondary actions, such as secondary buttons, hover states, or less critical information. This could be a lighter or more subdued tone within the same color family or a contrasting color from the palette that works well with the primary color.
            page Color: Pick a neutral or very subtle color from the palette for the background. This should be a color that can recede to the back, allowing content and interactive elements to stand out. If the palette includes a light grey or a very soft blue, it could effectively serve as a calm, unobtrusive background that complements the other colors.
            Accent Color: Use the most attention-grabbing color in the palette (that isn't the primary color) for accents such as notifications, alerts, and indicators. This color should be used sparingly to ensure it remains effective in drawing the user's eye to important information or status changes within the dashboard.
            other<letter> is used for charts etc
            base: used color for interpolating colors, e.g. primary_50 = 50% of primary color and 50% of base

            You can also add default colors for components, e.g. Button below
         */
        var customTheme = """
                {                           
                      "colors": {
                            "base": "white",
                            "page": "#FFFFFF",    "pageText": "#37474F",                    
                            "primary": "#FBC02D", "primaryText": "263238",                    
                            "secondary": "#FF9800", "secondaryText": "white",                    
                            "accent": "#C2185B", "accentText": "white",
                         
                            "otherA": "#FF8360", "otherB": "#E8E288", "otherC": "#7DCE82", "otherD": "#51A3A3",
                            "otherE": "#B2C326", "otherF": "#C879FF", "otherG": "#FF61A6", "otherH": "#FFAA4C",
                            "otherI": "#55DDE0", "otherJ": "#F76B8A", "otherK": "#9B5DE5", "otherL": "#F7B32B",
                            "otherM": "#FCCB69", "otherN": "#00BBF9", "otherO": "#FFD166",
                            
                            "Button": { "bgColor": "theme.colors.accent", "color": "theme.colors.accentText" }                            
                      }                   
                 
                }""";

        VisualStyle myThemeStyle = VisualStyle.fromJson(customTheme); // load custom theme from json above, at least the colors
        myThemeStyle.setPage("white").setPageText("#304040"); // we can also set colors this way

        // lets create a custom button style - we will call this variant 'customButton'
        // to use it later, use setVariant(state,"customButton") on the button, and the default you set here will be applied
        myThemeStyle.setComponentBgColor(Button.class, "theme.colors.accent");

        Button b = new Button(globalState);
        b.setWidth(globalState, "300px").setBgColor(globalState, "theme.colors.secondary").setColor(globalState, "theme.colors.secondaryText");
        b.setIcon(globalState, "MdCall").setBorderRadius(globalState, "50%");
        myThemeStyle.setComponent(b, globalState, "customButton");

        Map<String,VisualStyle> themes = new HashMap<>();
        themes.put("customTheme", myThemeStyle); // add in a custom theme called "customTheme", it will be selectable in top right dropdown
        form.setThemeConfig(globalState, themes);
    }

}

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


import com.gofintec.kewlui.base.*;

import com.gofintec.kewlui.controls.std.ComponentBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static com.gofintec.kewlui.base.ControlRequestReply.Ok;

/**
  *  This is a simple example router page that can be used to route requests to a different page.
  *  This is achieved by mapping a request against '*' which is a catch all, and adding a component box to the page.
  *  The component box is then set to display whichever actual page is desired
  *
  *  It isn't necessary to have such a router, this is just to show some options how things can be done
 */
public class RouterForm
{
    private static String USER_NAME = "userName";

    private static final Logger Log = LogManager.getLogger(RouterForm.class);

    public Form createRouterPage (String page, String info)
    {
        return new Form(); // empty panel for everyone by default
    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    // This page can act as our router page, in that we can choose to show login controls (if that is needed)
    // and replace the page with something else if logged in ok
    // this function has been mapped against '*' which is a catch all...
    public  ControlRequestReply handleAndRouteUserRequest (ControlRequestEvent request) {
        var browserInfo = request.getBrowserInfo();

        var componentAndState = request.getComponentAndState();
        Form form = (Form)componentAndState.getForm();
        StateData clientState = componentAndState.getClientState();

        var sessioninfo = request.getSessionInfo(); // get any info retrieved during login phase...

        var userServeSideInfo = setupClientSessionInformation(sessioninfo);
        var userName = (String) userServeSideInfo.get(USER_NAME) ;
        setupClientSideTemplateValues(form, clientState, userName, browserInfo);

        Log.info("Set up default page for user "+userName+" on sessionid "+sessioninfo.getSessionId()+ " with browser: "+browserInfo);

        // just a loader of another component - the dashboard Form in this case....
        displayDestinationPage(form, clientState, "dashboard", userServeSideInfo);

        return Ok();
    }

    // Here we either get or create any information we wish to store about the user
    protected Map<String, Object> setupClientSessionInformation (ClientSession sessionInfo)
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


    protected void displayDestinationPage (Form form , StateData clientState, String pageName, Map<String, Object> rawInfo)
    {
        var page = form.getMainPanel();

        page.getChildren(clientState).clear();
        ComponentBox box = ComponentBox.appendTo(page, clientState);
        box.setWidth(clientState,"100%").setHeight(clientState,"100%");
        box.setControlName(clientState,pageName); // window the dashboard form in the default form

    }

    // This is the place to setup any template values for the user
    // One primary usage of templates is handlebar substitution,
    // e.g if we set form.userName to a value, any text {{form.userName}} in controls will be automatically replaced with that value
    protected void setupClientSideTemplateValues (Form form , StateData clientState, String userName, String  browserInfo)
    {
        // set up any template values for the user
        // any text in any controls will be automatically replaced
        // e.g. {{form.username}} will be replaced with userName
        Map<String,String> clientTemplatevalues = Map.of("form.userName", userName,  "form.browserInfo", browserInfo);
        form.setTemplateValues(clientState, clientTemplatevalues);
    }


}

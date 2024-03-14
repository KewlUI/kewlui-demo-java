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

    private Form form;
    private ComponentBox componentBox;

    public Form createRouterPage (String page, String info)
    {
        this.form = Form.create(); // empty panel for everyone by default
        var globalState = form.getGlobalState();
        var mainPanel = form.getMainPanel();
        this.componentBox = ComponentBox.appendTo(mainPanel, globalState);
        componentBox.setWidth(globalState,"100%").setHeight(globalState,"100%");
        return form;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    // This page can act as our router page, in that we can choose to show login controls (if that is needed)
    // and replace the page with something else if logged in ok
    // this function has been mapped against '*' which is a catch all...
    public ControlRequestReply setupUniqueStateForClient (ControlRequestEvent request) {
        var componentAndState = request.getComponentAndState();
        var owner = request.getClientSession().getClientOwner();

        Form form = (Form)componentAndState.getForm();
        var mainPanel = form.getMainPanel();
        var clientState = componentAndState.getClientState();

        var userServeSideInfo = setupClientSessionInformation(request, form, clientState);
        owner.setLoggedInTime(null);

        var componentBox = (ComponentBox) mainPanel.getChildren(clientState).get(0);
        componentBox.setControlName(clientState, getDestPage(owner.isLoggedIn()));

        mainPanel.setOnMouseUp(clientState, (e) -> {
            var oldPage = componentBox.getControlName(clientState);
            var newPage = getDestPage(owner.isLoggedIn());
            if (!newPage.equals(oldPage)) {
                componentBox.setControlName(clientState, newPage);
            }
        });
        componentBox.setOnChange(clientState, (e) -> {
            var value = componentBox.getValue(clientState);
            Log.info("On change: " + value);
        });
        return Ok();
    }

    protected static String getDestPage(boolean isLoggedIn) {
        return isLoggedIn ? "/dashboard/" : "/login/";
    }


    // Here we either get or create any information we wish to store about the user
    protected static Map<String, Object> setupClientSessionInformation (ControlRequestEvent request, Form form, StateData clientState)
    {
        var sessionInfo = request.getClientSession();

        // in this case, we check ClientSession information, check or add to general info on the session/user etc
        Map<String, Object> userServeSideInfo = sessionInfo.getUserSessionStorage();

        String userName = sessionInfo.getClientOwner().getUserName(); // check if it contains the users name
        if (userName!=null) {
            // user is not logged in, so we could throw an exception to stop the user going any further
            // or show a login screen, or perform some other action
            // in this case though, we'll let them proceed and just setup a dummy username
            userServeSideInfo.put(USER_NAME, userName); // pretend we have logged in etc
        } else {
            userName = "";
        }

        // e.g. {{form.username}} will be replaced with userName
        Map<String,String> clientTemplatevalues = Map.of("form.userName", userName,  "form.sessionId", sessionInfo.getSessionId());
        form.setTemplateValues(clientState, clientTemplatevalues);

        return userServeSideInfo;
    }



}

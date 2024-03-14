package org.kewlui.demo.ui.TestApp.Forms;


import com.gofintec.kewlui.KewlUI;
import com.gofintec.kewlui.base.*;
import com.gofintec.kewlui.base.util.StringUtils;
import com.gofintec.kewlui.controls.base.settings.AlignItemsEnum;
import com.gofintec.kewlui.controls.base.settings.JustifyContentEnum;
import com.gofintec.kewlui.controls.base.template.GenFromTemplate;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Map;

import static com.gofintec.kewlui.base.ControlRequestReply.Ok;

/* This is a simple Login Form that is used by the Router Form.

Uses templates for look and feel and thus simplified usage here
 */
public class LoginForm {
    private static final Logger Log = LogManager.getLogger(LoginForm.class);

    private Form form;

    public LoginForm() {
    }

    public Form createPage (String page, String info)
    {
        this.form = Form.create();
        var panel = form.getMainPanel();
        var globalState = form.getGlobalState();
        panel.setWidth(globalState, "100%").setHeight(globalState, "100%");

        panel.setAlignItems(globalState, AlignItemsEnum.CENTER);
        panel.setJustifyContent(globalState, JustifyContentEnum.CENTER);
        var box = Box.appendTo(panel, globalState, AlignItemsEnum.CENTER, JustifyContentEnum.CENTER);
        box.setWidth(globalState, "100%").setHeight(globalState, "100%");
        box.setCenterContent(globalState, true);

        var urlbar = URLBar.appendTo(box, globalState);
        urlbar.setOnChange(globalState, (e) -> {
            Log.info("url changed: " + urlbar.getValue(e));
        });

        try {
            // load template from classpath - login window.  appendFromTemplate will generate all controls

            InputStream resource = KewlUI.getResourceLoader().getResourceAsStream("static/templates/components/login.kmd");
            String content = new String(resource.readAllBytes());

            Map<String, String> moustacheValues = Map.of("SiteName", "##KewlUI (demo)");
            var generated = GenFromTemplate.appendFromTemplate(box, globalState, content, moustacheValues);
            var controls = generated.getControls();
            var loginPage = controls.get("loginPage");
            loginPage.setMinWidth(globalState, "300px");

            var emailInput = controls.get("emailInput");
            emailInput.setValue(globalState,"username@example.com");
            var passwordInput = controls.get("passwordInput");
            passwordInput.setValue(globalState,"password");
            var errorText = (Text) controls.get("errorText");
            errorText.setText(globalState, "This will auto login in a few secs for demo purposes");

            var loginButton = controls.get("loginButton");
            var hid = Slider.appendTo(box, globalState);
            hid.setName(globalState, "Login").setControlHidden(globalState, true);

            EventCallback loginCallback = (e) -> {
                String email = emailInput.getValue(e);
                String password = emailInput.getValue(e);
                var result = performLogin(e, email, password, errorText);
                hid.setValue(e.clientState(), result);
                Log.info("setting url value to " + result);
                if (result==true){ // if logged in - CHANGE URL  (well reload page in this example)

                    var dest = URLBar.URLBarValue.of("",null); // url=='' means simply reload the clients current page
                    urlbar.setValue(e.clientState(), dest);
                }
            };
            loginButton.setOnClick(globalState, loginCallback);

        } catch (Exception ex) {
            Log.error("Error: ", ex);
        }

        return form;
    }

    private boolean performLogin (EventData e, String email, String password, Text errorText) {
        var clientState = e.clientState();
        if (email!=null && password!=null && !StringUtils.isNullOrWhitespace(email) && !StringUtils.isNullOrWhitespace(password)) {
            var clientOverview = e.clientOverview();
            var userName = attemptLogin(clientOverview, email, password);
            if (userName==null) {
                errorText.setText(clientState, "Unknown username or password");
            } else {
                errorText.setText(clientState, "Ok, you are logged in as " + userName);
                return true;
            }
        } else {
            errorText.setText(clientState, "Invalid email or password");
        }
        return false;
    }

    private String attemptLogin(ClientOverview clientOverview, String email, String password) {
        // don't do any real validation here, in this example we just return the users name
        // return null if login fails

        var userName = "MyUserName";
        clientOverview.setLoggedIn(); // set the user as logged in
        clientOverview.setUserName(userName); // we now know the users name
        clientOverview.getUserData().put("email", email); // store the email in the user data, or any other data there may be

        return userName;
    }

    public ControlRequestReply setupUniqueStateForClient (ControlRequestEvent request) {
        return Ok(); // do nothing
    }

}

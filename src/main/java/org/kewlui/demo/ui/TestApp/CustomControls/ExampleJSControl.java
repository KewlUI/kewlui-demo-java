/**
 * ExampleJSComponent is a custom control that extends CustomControl. It provides an example control that writes out the result of multiplying x and y as "x * y = answer".
 */
package org.kewlui.demo.ui.TestApp.CustomControls;

import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.custom.ControlInfo;
import com.gofintec.kewlui.controls.base.custom.CustomControl;


/*
  Example class which shows extending KewlUI with a custom javascript control

  Note the static functions getControlCss() and getControlJavascript() which provide client side code
  At some stage at startup, CustomControl.registerClass(ExampleJSComponent.class); should be run which will use above static functions
 */
public class ExampleJSControl extends CustomControl {

    /**
     * Constructs an ExampleJSComponent with the given StateData.
     * @param state The StateData object representing the state of the component.
     */
    public ExampleJSControl (StateData state) {
        super(state);
    }

    /**
     * static Builder/Constructor.  Accepts optional modifiers:
     * @param parent destination parent control to attach to
     * @param state destination state where object will be created
     * @param modifiers List of optional modifiers.  Any string is put into text field
     * @return descriptor of newly created object     */
    public static ExampleJSControl appendTo(VisualControl parent, StateData state, Object... modifiers) {
        return appendTo(new ExampleJSControl(state), parent, state, modifiers);
    }

    /**
     * Sets the x property of the component's StateData.
     * @param state The StateData object to set the property on.
     * @param x The value to set for the x property.
     */
    public void setX(StateData state, int x) {
        setProperty(state, "x", x);
    }

    /**
     * Sets the y property of the component's StateData.
     * @param state The StateData object to set the property on.
     * @param y The value to set for the y property.
     */
    public void setY(StateData state, int y) {
        setProperty(state, "y", y);
    }

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
        controlInfo.setBackgroundJs("""
              const {targetId, props, text, value, isSmallScreen, colors} = params;
              // background running, some long running process to calculate something
              return { info: "Random: "+Math.floor(Math.random() * 10) };
          """);

        // javascript to return the HTML for the control - consider this standard UPDATE/draw logic
        // the script given should return a string (capable of being put in innerHTML) or NULL if nothing to update
        // this code is run on the main client thread so has access to DOM if necessary....
        controlInfo.setJavascript("""
              const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, rebuild, colors, state} = params;
              const answer = (props.x ?? 0)  * (props.y ?? 0);
              return `<div class="funky-color-fade"> Multiplying ${props.x} with ${props.y} gives answer ${answer}.  Background processor says "${state.backgroundData?.info}".</div>`;
        """);

        controlInfo.setCss("""
               /* Styles for the funky-color-fade custom class */
               .funky-color-fade {
                  color: var(--theme-colors-primaryText); /* Text color - taken from theme palette */
                  background: var(--theme-colors-secondary); /* Fallback color */
                  /* Gradient background for color fade effect - using theme colors */
                   background: linear-gradient(to right, var(--theme-colors-primary), var(--theme-colors-secondary));
                  
                  /* Additional styles for visual appeal */
                  padding: 20px; 
                  border-radius: 10px;
                  text-align: center;
                  font-size: 18px;
              }
                """);

        controlInfo.setInitJs(null); // js to run at control initialisation - not used in this example
        controlInfo.setDestroyJs(null); // js to run at control destruction - not used in this example

        /*
        Map<String, String> includes = new HashMap<>();
        includes.put("JQUERY", "<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>");
        includes.put("BOOTSTRAP", "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">");
        includes.put("FONTAWESOME", "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">");
        controlInfo.setIncludes(includes);
        */
        return controlInfo;
    }

}

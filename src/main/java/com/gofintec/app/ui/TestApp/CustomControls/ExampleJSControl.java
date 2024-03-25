/**
 * ExampleJSComponent is a custom control that extends CustomControl. It provides an example control that writes out the result of multiplying x and y as "x * y = answer".
 */
package com.gofintec.app.ui.TestApp.CustomControls;

import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.custom.CustomControl;

import java.util.Map;


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

    /**
     * Generates JavaScript code for the ExampleJSComponent.
     * This JavaScript code defines the behavior of the component when rendered on the client side.
     * @return A string containing the JavaScript code for the component.
     */
    public static String getControlJavascript() {
        return """
        window.KEWLUI_CONTROLS['ExampleJSControl'] = function(params) {
              const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, rebuild, colors} = params;
              const element = document.getElementById(targetId);
              if(element) {
                 const answer = (props.x ?? 0)  * (props.y ?? 0);
                 element.innerHTML = `<div class="funky-color-fade"> Multiplying ${props.x} with ${props.y} gives answer ${answer}</div>`;
              }
              return null; // returning null == no cleanup necessary
        };
""";
    }

    /**
     * Generates CSS code for the ExampleJSComponent.
     * This CSS code defines the styles applied to the component when rendered on the client side.
     * @return A string containing the CSS code for the component.
     */
    public static String getControlCss() {
        return """
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
                """;
    }

    /**
     * Retrieves any necessary include files for the ExampleJSComponent.
     * These include files (e.g., JavaScript, CSS) are required for the proper functioning of the component.
     * NOTE!: Although deduplication occurs at a system level based on keys (ie one JQUERY will be chosen across all components),
     * you might also consider instead adding includes to the start of your index.html....
     * @return Map<String, String> of includes
     */
    public static Map<String,String> getControlIncludes() {
        return null; // return no includes
        /*
        Map<String, String> includes = new HashMap<>();
        includes.put("JQUERY", "<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>");
        includes.put("BOOTSTRAP", "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">");
        includes.put("FONTAWESOME", "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">");
        return includes;
         */
    }
}

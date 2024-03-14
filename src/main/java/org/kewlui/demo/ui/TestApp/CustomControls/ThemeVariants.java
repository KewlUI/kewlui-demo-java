package org.kewlui.demo.ui.TestApp.CustomControls;

import com.gofintec.kewlui.base.Form;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.theme.VisualStyle;
import com.gofintec.kewlui.controls.std.BorderCard;
import com.gofintec.kewlui.controls.std.Button;

import java.util.HashMap;
import java.util.Map;

//////
// in this example, we
// 1] create a custom theme on the form
// 2] we make some new global variants/defaults for common controls which can be used later
public class ThemeVariants {

    public static void addThemesAndVariants (StateData globalState, Form form) {
        Map<String,VisualStyle> themes = new HashMap<>();
        addCustomTheme(globalState, themes);
        addBespokeControlVariants(globalState, themes);
        form.setThemeConfig(globalState, themes);
    }

    private static void addCustomTheme (StateData globalState, Map<String,VisualStyle> themes) {
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

        VisualStyle customThemeStyle = VisualStyle.fromJson(customTheme); // load custom theme from json above, at least the colors
        customThemeStyle.setPage("white").setPageText("#304040"); // we can also set colors this way

        // lets create a custom button style - we will call this variant 'customButton'
        // to use it later, use setVariant(state,"customButton") on the button, and the default you set here will be applied
        customThemeStyle.setComponentBgColor(Button.class, "theme.colors.accent");

        //myThemeStyle.setComponent(b, globalState, "customButton"); // we could create a custom variant purely under the theme

        themes.put("customTheme", customThemeStyle); // add in a custom theme called "customTheme", it will be selectable in top right dropdown
    }


    // Variants allow storing config for controls under various names.  These can used by doing setVariant on a new button.
    // ie if we create a define a button 'customButton' with a number of default,
    // to use these defaults on other buttons we do otherButton.setVariant(state,"customButton");
    private static void addBespokeControlVariants (StateData globalState, Map<String, VisualStyle> themes) {
        VisualStyle myThemeStyle =  new VisualStyle();

        { // create a Button variant 'customButton'
            Button b = new Button(globalState);
            b.setWidth(globalState, "300px").setBgColor(globalState, "theme.colors.secondary").setColor(globalState, "theme.colors.secondaryText");
            b.setIcon(globalState, "MdCall").setBorderRadius(globalState, "50%");
            myThemeStyle.setComponentVariant(b, globalState, "customButton");
        }

        { // create a 'BorderCard' variant 'techBorder'
            // yeah maybe its ugly, feel free to make your own border style, this is a demo
            var card = new BorderCard(globalState);
            card.setWidth(globalState,"300px").setHeight(globalState,"200px"); // this can be overridden in final control
            card.setSrc(globalState, "{urlBase}/images/techBorder.jpg");
            card.setSlice(globalState,"55 55 55 55"); // top right bottom left
            card.setBorderWidth(globalState,"30");
            card.setRepeat(globalState, false);
            myThemeStyle.setComponentVariant(card, globalState, "techBorder");
        }
        {
            var card = new BorderCard(globalState);
            card.setWidth(globalState,"100%").setHeight(globalState,"100%"); // this can be overridden in final control
            card.setSrc(globalState, "{urlBase}/images/border1.jpg");
            card.setSlice(globalState,"20 18 15 15"); // top right bottom left
            myThemeStyle.setComponentVariant(card, globalState, "gameLike");
        }

        themes.put("", myThemeStyle); // add in controls into the global space
    }
}

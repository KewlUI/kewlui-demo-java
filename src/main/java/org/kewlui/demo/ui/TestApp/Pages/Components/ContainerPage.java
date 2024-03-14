package org.kewlui.demo.ui.TestApp.Pages.Components;

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


import org.kewlui.demo.ui.TestApp.Pages.BasePage;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.settings.*;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Container example page - shows a number of examples of containers, along with source code on how to achieve it
 *
 */
public class ContainerPage extends BasePage
{
    private static final Logger Log = LogManager.getLogger(ContainerPage.class);

    public ContainerPage() {
        super(true);
    }


    public void AddOtherPositions (VisualControl parent, StateData globalState )
    {
        var vstack = VStack.appendTo(parent,globalState);

        String markdownDescription = """
## Containers

Kewl UI offers a number of containers that can affect the positioning and styling of child controls within them

- AspectRatio: allows a child to be shown in a fixed aspect ratio, useful for video, pictures etc
- AutoWrap: adds all sub controls after each other, automatically wrapping to the next row if necessary
- Box: is a container that can add backgrounds, border etc around the child controls
- BorderCard: Provides images and effects in the border.  Allows images to be turned into a border.
- Card: allows children to be added in Header, Body and Footer positions
- CardPricing: card  optimised for pricing information
- CardSocialProfile: card optimised for social profile
- Carousel: allows children to be added in a carousel structure
- CompassBox:  allows child controls to be added in compass positions (North,South,East,West,Center)
- ComponentBox: allows a named component (e.g. page) to be included within a container
- FormContext: syncs values with all child controls
- Flex: allows children to be added in a flex box structure
- HStack: - Create a horizontal stack of child elements
- SimpleAccordion: Accordions display a list of options that can expand/collapse to reveal more information.
- SimpleGrid: allows children to be added in a simple grid structure, with set spacing between the items
- Spacer: adds a spacing element to Flex containers
- Tabs: Allows adding children as tabs in a container
- TabSelectControl : allows child controls to be added in a named tabs, with tabs being selectively enabled
- TextContainer : Container with extra functions for text
- VStack:  Create a vertical stack of child elements

Examples available below
""";
        Markdown.appendTo(vstack,globalState,markdownDescription);

        addAspectRatio(vstack,globalState);

        addAutoWrap(vstack,globalState);
        addBox(vstack,globalState);
        addBorderCard(vstack,globalState);
        addCard(vstack,globalState);

        addCardPricing(vstack,globalState);
        addCardSocialProfile(vstack,globalState);

        addCarousel(vstack,globalState);

        addCompassBox(vstack,globalState);
        addComponentBox(vstack,globalState);

        addFlex(vstack,globalState);
        addFormContext(vstack,globalState);

        addStack(vstack,globalState);

        addSimpleAccordion(vstack,globalState);
        addSimpleGrid(vstack,globalState);

        addTabs (vstack, globalState);
        addTabSelectControl(vstack, globalState);

        addTextContainer(vstack, globalState);

        Divider.appendTo(vstack,globalState);
        Text.appendTo(vstack,globalState,"More containers coming....");
    }

    private void addCarousel (VStack parent, StateData globalState) {
        String markdownDescription = """
### Carousel 

Carousel allows putting child controls in a carousel structure

""";
        var box = new Box(globalState);
        box.setCenterContent(globalState, true).setWidth(globalState,"1000px");//.setHeight(globalState,"400px");
        var carousel = Carousel.appendTo(box,globalState);
        carousel.setDots(globalState, true)
                .setSlidesToShow(globalState, 1).setSlidesToScroll(globalState, 1)
                .setAutoplay(globalState, true)
                .setArrows(globalState, true)
                .setInfinite(globalState, true)
                .setSpeed(globalState, 500)
                .setAdaptiveHeight(globalState, false)
                .setAutoplaySpeed(globalState, 3000)
                .setFade(globalState, false)
                .setCenterMode(globalState, true)
                .setPauseOnHover(globalState, true);
        for (int ii = 0; ii < 8; ++ii) {
            int l = 300+ii;
            Image.appendTo(carousel,globalState).setSrc(globalState,"https://picsum.photos/200/"+l);
        }

        String java = """
Fields:

- **accessibility** (boolean): Enables tab control and arrow key navigation. Default value: `true`.
- **adaptiveHeight** (boolean): Automatically adjusts the carousel height to the height of the currently displayed slide. Default value: `false`.
- **autoplay** (boolean): Enables automatic cycling through slides. Default value: `false`.
- **autoplaySpeed** (integer): The delay in milliseconds between automatically cycling an item. Default value: `3000`.
- **arrows** (boolean): Shows Prev/Next arrows. Default value: `true`.
- **centerMode** (boolean): Enables centered view with partial prev/next slides. Default value: `false`.
- **centerPadding** (string): Side padding when in center mode, in pixels or percentage. Default value: `50px`.
- **cssEase** (string): CSS3 easing function name. Default value: `ease`.
- **dots** (boolean): Show dotted indicators at the bottom of the slider. Default value: `false`.
- **fade** (boolean): Enables fade effects for transitioning between slides. Default value: `false`.
- **focusOnSelect** (boolean): Go to slide on click. Default value: `false`.
- **infinite** (boolean): Enables infinite looping of slides. Default value: `true`.
- **initialSlide** (integer): Index of the initial slide to display. Default value: `0`.
- **lazyLoad** (String): Delays loading of images. Options: 'ondemand', 'progressive'. Default value: `ondemand`.
- **pauseOnHover** (boolean): Pauses autoplay when the carousel is hovered over. Default value: `true`.
- **slidesToShow** (integer): Number of slides to show at a time. Default value: `1`.
- **slidesToScroll** (integer): Number of slides to scroll at a time. Default value: `1`.
- **speed** (integer): Transition speed in milliseconds. Default value: `500`.
- **swipe** (boolean): Enables swipe functionality for touch devices. Default value: `true`.
- **vertical** (boolean): Enables vertical sliding mode. Default value: `false`.
- **rows** (integer): Number of rows per slide in the slider's grid. Default value: `1`.
- **slidesPerRow** (integer): Number of slides to display in each row of the grid. Default value: `1`.
- **variableWidth** (boolean): Variable width for each slide in the carousel. Default value: `false`.
- **rtl** (boolean): Changes the carousel's direction to right-to-left. Default value: `false`.
    
```java
        var carousel = Carousel.appendTo(vs, globalState);
        carousel.setWidth(globalState, "100%");
        carousel.setDots(globalState, true)
                .setSlidesToShow(globalState, 1).setSlidesToScroll(globalState, 1)
                .setAutoplay(globalState, true)
                .setArrows(globalState, true)
                .setInfinite(globalState, true)
                .setSpeed(globalState, 500)
                .setAdaptiveHeight(globalState, false)
                .setAutoplaySpeed(globalState, 3000)
                .setFade(globalState, false)
                .setCenterMode(globalState, true)
                .setPauseOnHover(globalState, true);
        for (int ii = 0; ii < 15; ++ii) {
            int l = 300+ii;
            Image.appendTo(carousel,globalState).setSrc(globalState,"https://picsum.photos/200/"+l);
        }
```    
    """;
        addExplanationPages(parent, globalState, "Carousel", markdownDescription, box, java);
    }


    private void addAspectRatio (VisualControl parent, StateData globalState) {

        String markdownDescription = """
### Aspect Ratio

AspectRatio control is a component that allows you to maintain a fixed aspect ratio for an element.

It adjusts the height or width of the element depending on the aspect ratio specified.
 
It can be used to ensure that images or videos maintain their intended dimensions on different screen sizes without stretching or distorting.
    
""";
        String javaDescription = """
```java
        // Example:  Create a container with an aspect ratio of 1.5:1, insert iframe video into it   
        var aspectRatio = AspectRatio.appendTo(parent,globalState);
        aspectRatio.setRatio(self, 1.5);
        aspectRatio.setMaxWidth(self, "300px");
        aspectRatio.setWidth(self, "300px");
        aspectRatio.setBgColor(self, "black");

        // add iframe video inside aspectRatio container (1.5:1 ratio set above)
        var iFrame = IFrame.appendTo(aspectRatio, globalState); 
        iFrame.setSrc(self, "https://www.youtube.com/embed/dQw4w9WgXcQ");
        iFrame.setAllowFullScreen(self, true);
        iFrame.setTitle(self, "An IFrame");
        iFrame.setLoading(self, "lazy");                        
                ```        
""";
        var aspectRatio = new AspectRatio(globalState);
        aspectRatio.setRatio(globalState, 1.5);
        aspectRatio.setMaxWidth(globalState, "300px");
        aspectRatio.setWidth(globalState, "300px");
        aspectRatio.setBgColor(globalState, "black");

        var iFrame = IFrame.appendTo(aspectRatio,globalState);
        iFrame.setSrc(globalState, "https://www.youtube.com/embed/dQw4w9WgXcQ");
        iFrame.setAllowFullScreen(globalState, true);
        iFrame.setTitle(globalState, "An IFrame");
        iFrame.setLoading(globalState, "lazy");

        addExplanationPages(parent, globalState, "AspectRatio", markdownDescription, aspectRatio, javaDescription);
    }


    private void addAutoWrap (VisualControl parent, StateData globalState)
    {
        String markdownDescription = """
### AutoWrap

The Wrap control allows for the wrapping of child elements within a container, creating a layout that adjusts to available space and can be responsive on different screen sizes.
 
It can be useful when displaying a dynamic number of elements that need to be arranged in a specific order without requiring a fixed grid layout
    
""";
        String java = """
```java
        
        var autoWrap = AutoWrap.appendTo(parent,globalState);
        var colours = Arrays.asList("tomato","green","blue","yellow","pink");
        for (int ii = 0; ii < 15; ++ii)
        {
            var bx = Box.appendTo(autoWrap,globalState, "sub container box "+(ii+1));;
            bx.setWidth(globalState,"150px").setHeight(globalState,"80px").setBgColor(globalState,colours.get(ii % colours.size()));
        }
```        
""";
        var autoWrap = new AutoWrap(globalState);
        var colours = Arrays.asList("tomato","green","blue","yellow","pink");
        for (int ii = 0; ii < 15; ++ii)
        {
            var bx = Box.appendTo(autoWrap,globalState, "sub container box "+(ii+1));;
            bx.setWidth(globalState,"150px").setHeight(globalState,"80px").setBgColor(globalState,colours.get(ii % colours.size()));
        }

        addExplanationPages(parent, globalState, "AutoWrap", markdownDescription, autoWrap, java);
    }

    private void addBox (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### Box

A Box control is a basic layout element used to group and organize other UI components within a rectangular frame.

It's customizable for size, color, border, and spacing, commonly used for text, images, buttons, and interactive elements in UIs. 

Content may be optionally centred.        
""";
        AutoWrap w = new AutoWrap(globalState);

        {
            var box = Box.appendTo(w, globalState);
            box.setBgColor(globalState, "tomato").setColor(globalState, "white");
            box.setWidth(globalState, "80%");
            box.setHeight(globalState, "100px");

            var text = Text.appendTo(box, globalState); // add a Text to the Box Control
            text.setText(globalState, "This is a simple box container with two text controls");
            var text2 = Text.appendTo(box, globalState, "This is the second text contol"); // add a Text to the Box Control
        }
        { // centrered box
            var box = Box.appendTo(w, globalState, "Box container, CenterContent=true, and added border radius");

            box.setBgColor(globalState, "green.300").setWidth(globalState, "80%").setHeight(globalState, "100px");
            box.setCenterContent(globalState, true);
            box.setBorderRadius(globalState, "40px");
            // note that if you pass in text into box (like we did in the constructor above), it will
            // add that text to the end of the box entries - thus actually don't need  to create a Text object....
        }

        var java = """
```java
        
    {
        var box = Box.appendTo(parent, globalState);
        box.setBgColor(globalState, "tomato").setColor(globalState, "white");
        box.setWidth(globalState, "80%");
        box.setHeight(globalState, "100px");
    
        var text = Text.appendTo(box, globalState); // add a Text to the Box Control
        text.setText(globalState, "This is a simple box container with two text controls");
        var text2 = Text.appendTo(box, globalState, "This is the second text contol"); // add a Text to the Box Control
    }
    { // centrered box
        var box = Box.appendTo(parent, globalState, "Box container, CenterContent=true, and added border radius");
    
        box.setBgColor(globalState, "green.300").setWidth(globalState, "80%").setHeight(globalState, "100px");
        box.setCenterContent(globalState, true);
        box.setBorderRadius(globalState, "40px");
        // note that if you pass in text into box (like we did in the constructor above), it will
        // add that text to the end of the box entries - thus actually don't need  to create a Text object....
    }
```
""";
        addExplanationPages(parent, globalState, "Box", markdownDescription, w, java);
    }


    private void addBorderCard (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### BorderCard

A customizable box component with styleable borders using images or predefined styles.

If src prop is provided, the specified image will be used for the border. Otherwise, the variant prop can be used to choose from predefined border styles.

Supplying a source image will cause it to be shown on the BorderCards borders.
                                        
The logic splits the image into 9 zones, with the corner zones static, and the other zones implementing resizing code.
                    
- slice - sets the '9 slice' zone in pixels on the source image, (top, right, bottom, left).  e.g. '20 20 20 20'
- borderWidth - sets the border size on the output box. (top, right, bottom, left) e.g. "10 10 10 10" , or just "10" to set all
                    
Select some examples:                                                                                
""";
        var w = new VStack(globalState);

        {
            var v = VStack.appendTo(w, globalState);
            var h = HStack.appendTo(v, globalState);
            Text.appendTo(h, globalState, "Image:"); // add a Text to the Box Control
            var sel = Select.appendTo(h, globalState, "grayGame,chromeBorder,steampunkPixel");
            sel.setWidth(globalState, "300px");

            Text.appendTo(h, globalState, "Fill:"); // add a Text to the Box Control
            var fillCheckbox = Checkbox.appendTo(h, globalState, DefaultValue.set(false));

            Text.appendTo(h, globalState, "Repeat mode scaling?"); // add a Text to the Box Control
            var repeatCheckbox = Checkbox.appendTo(h, globalState, DefaultValue.set(true));


            var card = BorderCard.appendTo(v, globalState);
            card.setSrc(globalState, "{urlBase}/images/border1.jpg");
            card.setSlice(globalState, "20 18 15 15"); // top right bottom left

            // add some generic text inside the card
            var text = """
                    ### Some text
                                        
                    Other controls and containers can be placed inside the the BorderCard.
                                        
                    When fill is set false, the middle of the image will be removed.            
                    
                    The source image is split into 9 sectors, with corners remaining static, and the other zones being either repeated or stretched;                          
                      
                    """;
            Markdown.appendTo(card, globalState, text);

            ////////////
            // Logic allowing people to play with the settings
            fillCheckbox.setOnChange(globalState, (e) -> {
                boolean b = fillCheckbox.getValue(e.clientState());
                card.setFill(e.clientState(), b);
            });
            repeatCheckbox.setOnChange(globalState, (e) -> {
                boolean b = repeatCheckbox.getValue(e.clientState());
                card.setRepeat(e.clientState(), b);
            });


            var srcs = Map.of("grayGame", "{urlBase}/images/border1.jpg", "chromeBorder", "{urlBase}/images/techBorder.jpg", "steampunkPixel", "{urlBase}/images/steampunkPixel.png");
            var slices = Map.of("grayGame", "20 18 15 15", "chromeBorder", "55 55 55 55", "steampunkPixel", "150");
            var widths = Map.of("grayGame", "20", "chromeBorder", "30", "steampunkPixel", "35 25 35 25");
            var repeats = Map.of("grayGame", true, "chromeBorder", false, "steampunkPixel", true);

            // change the image source
            sel.setOnChange(globalState, (e) -> {
                String chosen = sel.getValue(e.clientState()); // get the value from the client
                card.setBorderWidth(e.clientState(), widths.get(chosen));
                card.setSlice(e.clientState(), slices.get(chosen));
                card.setSrc(e.clientState(), srcs.get(chosen));
                card.setRepeat(e.clientState(), repeats.get(chosen));
                repeatCheckbox.setValue(e.clientState(), repeats.get(chosen));
            });
        }

        Divider.appendTo(w, globalState);
        var text = """
                    Alternately, if src is not set, then using setVariant can access a number of present styles.                                              
                      
                    """;
        Markdown.appendTo(w, globalState, text);
        {
            var h = HStack.appendTo(w, globalState);
            var ht = Text.appendTo(h, globalState, "HueRotate: 0");
            var slider = Slider.appendTo(h, globalState);
            slider.setMax(globalState, 359.0).setMin(globalState, 0.0).setStep(globalState,10.0);

            var ab = AutoWrap.appendTo(w, globalState);
            ab.setPadding(globalState, "60px");
            String[] variantNames = {
                    "diagonalStripes", "gradientBorder", "glowingBorder",
                    "shineBorder", "dashedEffect", "insetShadowBox", "resizeBox", "gradientBorderEffect",
                    "cornerBorderEffect", "sketchy", "simpleBoxShadow", "blurryBoxShadow",
                    "colorfulBoxShadow", "offsetBoxShadow", "multiLayeredBoxShadow",
                    "simpleDropShadow",
                    "primaryDropShadow", "secondaryDropShadow", "blueDropShadow", "blurryDropShadow", "verticalDropShadow"
            };


            var al = new ArrayList<BorderCard>();

            for (String variant : variantNames) {
                var card = BorderCard.appendTo(ab, globalState);
                card.setVariant(globalState, variant);
                card.setWidth(globalState,"200px").setHeight(globalState, "150px").setBgColor(globalState,"theme.colors.page");
                Text.appendTo(card, globalState, "Variant: "+variant);
                al.add(card);
            }
            // when hueRotate changes -  set the hueRotate for all cards....
            slider.setOnChange(globalState, (e) -> {
                double val = slider.getValue(e.clientState());
                al.forEach(v-> v.setHueRotate(e.clientState(), (int)val));
                ht.setText(e.clientState(), "HueRotate: "+val);
            });
        }

        var java = """
""";
        addExplanationPages(parent, globalState, "BorderCard", markdownDescription, w, java);
    }

    private void addCard (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### Card

The Card control organizes information in a visually appealing container with flexible sizing, positioning, and content types. 

It could be used to display information such as news articles, user profiles, or product details.

Examples:

""";
        var hs = new AutoWrap(globalState);

        ///////////////
        // Simple card - set size to small, add some text boxes to the three positions (header, body, footer)
        var card = Card.appendTo(hs,globalState);
        card.setBorder(globalState, "2px dashed blue");
        card.setMaxWidth(globalState,"sm"); // sm, md, lg

        var text = Text.appendTo(card,globalState,"Card, text in header pos", ContainerPositionEnum.HEADER);
        text = Text.appendTo(card,globalState,"Text in body pos", ContainerPositionEnum.BODY);

        var button1 = Button.appendTo(card, globalState,"Interactive Button added ", ContainerPositionEnum.BODY);
        button1.setTooltip(globalState,"We can add tooltips to most controls");
        button1.setOnClick(globalState, (e) -> {
            var str = button1.getText(e.clientState());
            button1.setText(e.clientState(), str.substring(1) + str.substring(0,1));
        });
        text = Text.appendTo(card,globalState,"Card, text in footer pos", ContainerPositionEnum.FOOTER);

        /////////////////////////////////////////////////////////////////////////////

        card = Card.appendTo(hs,globalState);
        card.setBorder(globalState, "2px outset rgba(0,0,0,0.5)").setMargin(globalState, "2");
        card.setMaxWidth(globalState,"sm"); // small size card
        card.setWidth(globalState,"100%");

        var vstack = VStack.appendTo(card,globalState,ContainerPositionEnum.BODY);

        var image = Image.appendTo(vstack,globalState);
        image.setSrc(globalState,"https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80");

        image.setBorderRadius(globalState, "lg");
        image.setLoading(globalState, Image.LoadingEnum.LAZY).setMargin(globalState, "6");

        var heading = Heading.appendTo(vstack,globalState,"High quality sofa", SizeEnum.MD);
        text = Text.appendTo(vstack,globalState,"Unwind in ultimate comfort on our high-quality sofa that's expertly crafted with premium materials for long-lasting durability. Its timeless design seamlessly complements any décor, making it the perfect addition to any living space.");
        text.setFontSize(globalState, "md").setTextAlign(globalState, TextAlignEnum.JUSTIFY);

        var box = HStack.appendTo(vstack,globalState);
        box.setSpacing(globalState, "24px").setAlignItems(globalState, AlignItemsEnum.CENTER);
        text = Text.appendTo(box,globalState,"$299.99", FontWeightEnum.BOLD);
        text = Text.appendTo(box,globalState,"$499.99", TextDecorationEnum.LINE_THROUGH);

        var divider = Divider.appendTo(vstack,globalState);

        var buttonGroup = ButtonGroup.appendTo(card,globalState, ContainerPositionEnum.FOOTER, JustifyContentEnum.CENTER);
        buttonGroup.setSpacing(globalState, "2");
        var button = Button.appendTo(buttonGroup,globalState,"Buy Now", ColorSchemeEnum.GREEN);
        button.setTooltip(globalState,"Buy now and enjoy an extra 10% off");
        button = Button.appendTo(buttonGroup,globalState,"Add to cart", ColorSchemeEnum.BLUE);
        button.setVariant(globalState, Button.VariantEnum.GHOST);

        var java = """
## Example source code:

A card container has a header, body, and footer areas that children can be appended to.  
If no position is specified, BODY is assumed.

### Simple card with dashed border

```java
    ///////////////
    // Simple card - set size to small, add some text boxes to the three positions (header, body, footer)
    var card = Card.appendTo(hs,globalState);
    card.setBorder(globalState, "2px dashed blue");
    card.setMaxWidth(globalState,"sm"); // sm, md, lg

    var text = Text.appendTo(card,globalState,"Card, text in header pos", ContainerPositionEnum.HEADER);
    text = Text.appendTo(card,globalState,"Text in body pos", ContainerPositionEnum.BODY);
    var button1 = Button.appendTo(card,globalState,"Interactive Button added ", ContainerPositionEnum.BODY);
    button1.setTooltip(globalState,"We can add tooltips to most controls");
    button1.setOnClick(globalState, (e) -> {
        var str = button1.getText(state);
        button1.setText(state, str.substring(1) + str.substring(0,1));
    });
    text = Text.appendTo(card,self,"Card, text in footer pos", ContainerPositionEnum.FOOTER);
```
\n
### Sofa sales card

```java
    card = Card.appendTo(hs,globalState);
    card.setBorder(globalState, "2px outset rgba(0,0,0,0.5)").setMargin(self, "2");
    card.setMaxWidth(globalState,"sm"); // small size card
    card.setWidth(globalState,"100%");

    var vstack = VStack.appendTo(card,globalState,ContainerPositionEnum.BODY);

    var image = Image.appendTo(vstack,globalState);
    image.setSrc(globalState,"https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80");

    image.setBorderRadius(globalState, "lg");
    image.setLoading(globalState, Image.LoadingEnum.LAZY).setMargin(self, "6");

    var heading = Heading.appendTo(vstack,globalState,"High quality sofa", SizeEnum.MD);
    text = Text.appendTo(vstack,globalState,"Unwind in ultimate comfort on our high-quality sofa that's expertly crafted with premium materials for long-lasting durability. Its timeless design seamlessly complements any décor, making it the perfect addition to any living space.");
    text.setFontSize(globalState, "md").setTextAlign(globalState, TextAlignEnum.JUSTIFY);

    var box = HStack.appendTo(vstack,globalState);
    box.setSpacing(globalState, "24px").setAlignItems(globalState, AlignItemsEnum.CENTER);
    text = Text.appendTo(box,globalState,"$299.99", FontWeightEnum.BOLD);
    text = Text.appendTo(box,globalState,"$499.99", TextDecorationEnum.LINE_THROUGH);

    var divider = Divider.appendTo(vstack,globalState);

    var buttonGroup = ButtonGroup.appendTo(card,globalState, ContainerPositionEnum.FOOTER, JustifyContentEnum.CENTER);
    buttonGroup.setSpacing(globalState, "2");
    var button = Button.appendTo(buttonGroup,globalState,"Buy Now", ColorSchemeEnum.GREEN);
    button.setTooltip(globalState,"Buy now and enjoy an extra 10% off");
    button = Button.appendTo(buttonGroup,globalState,"Add to cart", ColorSchemeEnum.BLUE);
    button.setVariant(globalState, Button.VariantEnum.GHOST);
```

""";
        addExplanationPages(parent,globalState,"Card", markdownDescription,hs,java);
    }


    private void addCardPricing (VisualControl parent, StateData globalState)
    {
        String markdownDescription = """
### CardPricing

A specialisation of Card, normally used for displaying pricing options 

Examples:

""";
        var pricingCard = new CardPricing(globalState);

        pricingCard.setCategory(globalState, "Premium FizzBuzz");
        pricingCard.setPricePreText(globalState,"$");
        pricingCard.setPriceText(globalState,"99");
        pricingCard.setPriceFrequency(globalState,"/month");
        pricingCard.setFeatures(globalState, Arrays.asList("All premium controls", "Email support", "Visual Builder", "All features"));

        var compassBox = CompassBox.appendTo(pricingCard,globalState, ContainerPositionEnum.HEADER);
        var badge = Badge.appendTo(compassBox,globalState, ContainerPositionEnum.EAST, "Most Popular");
        badge.setBgColor(globalState, "red.300");
        badge.setVariant(globalState, Badge.VariantEnum.SUBTLE);

        // add button to footer
        final var button1 = Button.appendTo(pricingCard,globalState, "Start your trial");
        button1.setContainerPosition(globalState, ContainerPositionEnum.FOOTER);
        button1.setOnClick(globalState, (e)->{
            Log.info("button was pushed");
        });

        var java = """
## Example source code:

CardPricing example above

```java
        var pricingCard = CardPricing.appendTo(parent,globalState);

        pricingCard.setCategory(globalState, "Premium FizzBuzz");
        pricingCard.setPricePreText(globalState,"$");
        pricingCard.setPriceText(globalState,"99");
        pricingCard.setPriceFrequency(globalState,"/month");
        pricingCard.setFeatures(globalState, Arrays.asList("All premium controls", "Email support", "Visual Builder", "All features"));

        var compassBox = CompassBox.appendTo(pricingCard, globalState, ContainerPositionEnum.HEADER);
        var badge = Badge.appendTo(compassBox,globalState, ContainerPositionEnum.EAST, "Most Popular");
        badge.setBgColor(globalState, "red.300");
        badge.setVariant(globalState, Badge.VariantEnum.SUBTLE);

        // add button to footer
        final var button1 = Button.appendTo(pricingCard,globalState, "Start your trial");
        button1.setContainerPosition(globalState, ContainerPositionEnum.FOOTER);
        button1.setOnClick(globalState, (e)->{
            Log.info("button was pushed");
        });
```
""";
        addExplanationPages(parent,globalState,"CardPricing", markdownDescription,pricingCard,java);
    }


    private void addCardSocialProfile (VisualControl parent, StateData globalState)
    {
        String markdownDescription = """
### CardSocialProfile

A specialisation of Card, normally used for displaying social profile information

Examples:

""";

        var socialProfile = new CardSocialProfile(globalState);
        socialProfile.setBorder(globalState, "1px solid black");

        socialProfile.setBackgroundImage(globalState,"https://images.unsplash.com/photo-1527154964564-fb23cd9b47a8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=634&q=80");
        socialProfile.setProfileImage(globalState,"https://images.unsplash.com/photo-1544348817-5f2cf14b88c8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=200&h=200&q=80");
        socialProfile.setUserName(globalState,"John Smith");
        socialProfile.setUserRole(globalState,"Sous Chef");
        socialProfile.setBadges(globalState, Arrays.asList("#Knife Skills","#Cooking", "#Soufflés"));
        socialProfile.setStats(globalState, Map.of("Followers", "23k", "Following", 5678, "Likes", "201k"));
        socialProfile.setOnlineColor(globalState, "green.300"); // put a little green online circle next to the mans face

        // note - you can add custom content by adding children with ContainerPositionEnum header,footer, body
        // Add buttons to the footer of the social profile....
        final var button1 = Button.appendTo(socialProfile,globalState, "Follow");
        button1.setBgColor(globalState, "blue.500");
        button1.setContainerPosition(globalState, ContainerPositionEnum.FOOTER);
        button1.setOnClick(globalState, (e)->{
            button1.setBgColor(e.clientState(), "red");
            Log.info("Received Follow event!!!");
        });

        final var button2 = Button.appendTo(socialProfile,globalState, "Message");
        button2.setContainerPosition(globalState, ContainerPositionEnum.FOOTER);
        button2.setOnClick(globalState, (e)->{
            button2.setBgColor(e.clientState(), "blue.800");
            Log.info("Received Message event!!!");
        });

        var java  = """
## Example source code:

CardSocialProfile example above

```java
    var socialProfile = CardSocialProfile.appendTo(parent,globalState);
    socialProfile.setBorder(globalState, "1px solid black");

    socialProfile.setBackgroundImage(globalState,"https://images.unsplash.com/photo-1527154964564-fb23cd9b47a8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=634&q=80");
    socialProfile.setProfileImage(globalState,"https://images.unsplash.com/photo-1544348817-5f2cf14b88c8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=200&h=200&q=80");
    socialProfile.setUserName(globalState,"John Smith");
    socialProfile.setUserRole(globalState,"Sous Chef");
    socialProfile.setBadges(globalState, Arrays.asList("#Knife Skills","#Cooking", "#Soufflés"));
    socialProfile.setStats(globalState, Map.of("Followers", "23k", "Following", 5678, "Likes", "201k"));
    socialProfile.setOnlineColor(globalState, "green.300"); // put a little green online circle next to the mans face

    // note - you can add custom content by adding children with ContainerPositionEnum header,footer, body
    // Add buttons to the footer of the social profile....
    final var button1 = Button.appendTo(socialProfile,globalState, "Follow");
    button1.setBgColor(globalState, "blue.500");
    button1.setContainerPosition(globalState, ContainerPositionEnum.FOOTER);
    button1.setOnClick(globalState, (e)->{
        button1.setBgColor(e.clientState(), "red");
        Log.info("Received Follow event!!!");
    });

    final var button2 = Button.appendTo(socialProfile,globalState, "Message");
    button2.setContainerPosition(globalState, ContainerPositionEnum.FOOTER);
    button2.setOnClick(globalState, (e)->{
        button2.setBgColor(e.clientState(), "blue.800");
        Log.info("Received Message event!!!");
    });
```


""";
        addExplanationPages(parent, globalState,"CardSocialProfile", markdownDescription, socialProfile, java);
    }

    private void addCompassBox (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### CompassBox

This creates a Box where children can be added north south east west center using ContainerPosition

Examples:

""";
        var box = new CompassBox(globalState);
        box.setBorder(globalState, "1px solid black").setWidth(globalState,"70%").setHeight(globalState,"300px");

        var text = Text.appendTo(box,globalState,"North", ContainerPositionEnum.NORTH);
        text = Text.appendTo(box,globalState,"South", ContainerPositionEnum.SOUTH);
        text = Text.appendTo(box,globalState,"East", ContainerPositionEnum.EAST);
        text = Text.appendTo(box,globalState,"West", ContainerPositionEnum.WEST);

        var b2 = Box.appendTo(box,globalState);
        b2.setCenterContent(globalState,true).setBgColor(globalState, "blue.400").setWidth(globalState,"80%").setHeight(globalState,"80%");
        text = Text.appendTo(b2,globalState,"Center in a CompassBox", ContainerPositionEnum.CENTER);
        text.setColor(globalState, "black");

        var java  = """
## Example source code:

```java
    var box = CompassBox.appendTo(parent,globalState);
    box.setBorder(globalState, "1px solid black").setWidth(globalState,"70%").setHeight(globalState,"300px");

    var text = Text.appendTo(box,globalState,"North", ContainerPositionEnum.NORTH);
    text = Text.appendTo(box,globalState,"South", ContainerPositionEnum.SOUTH);
    text = Text.appendTo(box,globalState,"East", ContainerPositionEnum.EAST);
    text = Text.appendTo(box,globalState,"West", ContainerPositionEnum.WEST);

    var b2 = Box.appendTo(box,globalState);
    b2.setCenterContent(globalState,true).setBgColor(globalState, "blue.400").setWidth(globalState,"80%").setHeight(globalState,"80%");
    text = Text.appendTo(b2,globalState,"Center in a CompassBox", ContainerPositionEnum.CENTER);
    text.setColor(globalState, "black");
```
""";
        addExplanationPages(parent, globalState,"CompassBox", markdownDescription, box, java);

    }

    private void addComponentBox (VStack parent, StateData globalState) {
        String markdownDescription = """
### ComponentBox 

ComponentBox allows you to 'open a form' within the current form, encapsulated within a component.

For example, you could define a Data entry Form, and then use that within another form.

Each ComponentBox has its own FormContext which can be used to populate entry fields within it. 

Setting the value of the ComponentBox to a dictionary/map, will set the default template values of within that form.

Thus, giving a data value FullName="John Smith", means that any data input field named 'FullName' be set to "John Smith".

""";

        var box = new Box(globalState);

        var java  = """
## Example source code:

```java

    ComponentBox box = ComponentBox.appendTo(page, clientState);
    box.setWidth(e.clientState(),"100%").setHeight(e.clientState(),"100%");    
    box.setControlName(e.clientState(), "DataDisplayForm"); // window the dashboard form in the default form
    
    Dictionary<String, Object> data = new Dictionary<>();
    data.put("FullName", "John Smith");
    data.put("address", "18 Middle of Nowhere street");
    
    box.setValue(e.clientState(), data);
    
```
""";
        addExplanationPages(parent, globalState,"CompassBox", markdownDescription, box, java);
    }

    protected String MapToString(Map<String,Object> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n\n");
        }
        return sb.toString();
    }


    private void addFormContext (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### FormContext

 FormContext container syncs values with all child controls.  
 
 It contains a dictionary of key/value pairs which can be supplied to child controls, and also receives updates from child controls.
 
 When a control is given a "name" (via setName) call, the system will automatically see if there is a containing FormContext.
 
 If this is the case:
 - We see if FormContext has a value for "name", and if so, we set the control's value to that value
 - Any change to the controls value will cause the FormContext dictionary entry for that name to be updated
 - If multiple controls have the same name, any change will be propagated to all. 

""";
        var vs = new VStack(globalState);

        var initialState = new HashMap<String,Object>();
        initialState.put("FullName", "John Smith");
        initialState.put("Address", "18 No Where street");
        initialState.put("SliderValue", 10);

        var initialText = MapToString(initialState);

        Text.appendTo(vs,globalState, "FormContext Value:", TextAlignEnum.LEFT);
        var md = Markdown.appendTo(vs,globalState, initialText);
        md.setBorder(globalState, "1px solid black");

        FormContext context = FormContext.appendTo(vs,globalState);
        context.setValue(globalState, initialState);
        context.setOnChange(globalState,  (e) -> {
            var value = (Map<String,Object>) context.getValue(e.clientState());
            // update textbox to new value
            md.setText(e.clientState(), MapToString(value));
        });

        var verticalStack = VStack.appendTo(context,globalState);
        verticalStack.setWidth(globalState, "90%");
        verticalStack.setBorder(globalState, "1px solid black");
        Text.appendTo(verticalStack,globalState, "Following Controls are within the FormContext:", TextAlignEnum.LEFT);


        var formInput = FormInput.appendTo(verticalStack, globalState, "Full Name");
        formInput.setName(globalState, "FullName");
        formInput = FormInput.appendTo(verticalStack, globalState, "Address");
        formInput.setName(globalState, "Address");

        var sliderInput = Slider.appendTo(verticalStack, globalState, DefaultValue.set(0));
        sliderInput.setHeight(globalState, "200px");
        sliderInput.setOrientation(globalState, Slider.OrientationEnum.HORIZONTAL);
        sliderInput.setMin(globalState, 0.0);
        sliderInput.setMax(globalState, 20.0);
        sliderInput.setStep(globalState, 1.0);
        sliderInput.setIcon(globalState, "MdGraphicEq");
        sliderInput.setIconSize(globalState, 6);
        sliderInput.setName(globalState, "SliderValue");


        var java  = """
## Example source code:

```java
   var initialState = new HashMap<String,Object>();
   initialState.put("FullName", "John Smith");
   initialState.put("Address", "18 No Where street");
   initialState.put("SliderValue", 10);

   var initialText = MapToString(initialState);

   Text.appendTo(vs,globalState, "FormContext Value:", TextAlignEnum.LEFT);
   var md = Markdown.appendTo(vs,globalState, initialText);
   md.setBorder(globalState, "1px solid black");

   FormContext context = FormContext.appendTo(vs,globalState);
   context.setValue(globalState, initialState);
   context.setOnChange(globalState,  (e) -> {
        var value = (Map<String,Object>) context.getValue(e.clientState());
        // update textbox to new value
        md.setText(e.clientState(), MapToString(value));
   });

   var verticalStack = VStack.appendTo(context,globalState);
   verticalStack.setWidth(globalState, "90%");
   verticalStack.setBorder(globalState, "1px solid black");

   var formInput = FormInput.appendTo(verticalStack, globalState, "Full Name");
   formInput.setName(globalState, "FullName");
   formInput = FormInput.appendTo(verticalStack, globalState, "Address");
   formInput.setName(globalState, "Address");

   var sliderInput = Slider.appendTo(verticalStack, globalState, DefaultValue.set(0));
   sliderInput.setHeight(globalState, "200px");
   sliderInput.setOrientation(globalState, Slider.OrientationEnum.HORIZONTAL);
   sliderInput.setMin(globalState, 0.0);
   sliderInput.setMax(globalState, 20.0);
   sliderInput.setStep(globalState, 1.0);
   sliderInput.setIcon(globalState, "MdGraphicEq");
   sliderInput.setIconSize(globalState, 6);
   sliderInput.setName(globalState, "SliderValue");
```
""";
        addExplanationPages(parent, globalState,"FormContext", markdownDescription, vs, java);
    }

    private void addFlex (VisualControl xp, StateData globalState) {
        String markdownDescription = """
### Flex

The Flex control mimics the  CSS 'flex' layout property.  Allows for flexible positioning and sizing of elements within a container, allowing for responsive design and dynamic layouts. 

It is useful for creating complex and adaptable user interfaces.

Examples:
""";
        var parent = new VStack(globalState);

        // Left/right example
        // this is equivalent to display='flex'.  We use a Spacer, that expands to fill all available space
        // Note that if you have more than one spacer, the spacers will all be the same size
        var flex = Flex.appendTo(parent, globalState);
        flex.setWidth(globalState,"80%").setBorder(globalState, "1px").setAlignItems(globalState,"center");

        var s1 = Box.appendTo(flex,globalState);

        var text  = Heading.appendTo(s1,globalState);
        text.setColor(globalState,"purple").setFontSize(globalState,"lg").setText(globalState,"El Zombo App");

        var spacer = Spacer.appendTo(flex,globalState);

        var bg = ButtonGroup.appendTo(flex, globalState);
        var b1 = Button.appendTo(bg,globalState,ColorSchemeEnum.TEAL,"Sign Up");
        var b2 = Button.appendTo(bg,globalState,ColorSchemeEnum.TEAL,"Log In");


        // this is equivalent to display='flex'.
        // Note that if you have more than one spacer, the spacers will all be the same size
        flex = Flex.appendTo(parent, globalState);
        flex.setWidth(globalState,"80%");
        var sq = Square.appendTo(flex,globalState,"Box1");
        sq.setBgColor(globalState,"blue").setColor(globalState,"white");

         spacer = Spacer.appendTo(flex,globalState);

        var s2 = Box.appendTo(flex,globalState,"3 boxes, with Spacers between them");
        s2.setBgColor(globalState,"green").setColor(globalState,"white");

        spacer = Spacer.appendTo(flex,globalState);

        var s3 = Square.appendTo(flex,globalState,"Box 3 Data");
        s3.setBgColor(globalState,"red").setColor(globalState,"white");

        var java  = """
## Example source code:

```java
    { // Left/right example
        // this is equivalent to display='flex'.  We use a Spacer, that expands to fill all available space
        // Note that if you have more than one spacer, the spacers will all be the same size
        var flex = Flex.appendTo(parent,globalState);
        flex.setWidth(globalState,"80%").setBorder(globalState, "1px").setAlignItems(globalState,"center");

        var s1 = Box.appendTo(flex,globalState);

        var text  = Heading.appendTo(s1,globalState);
        text.setColor(globalState,"purple").setFontSize(globalState,"lg").setText(globalState,"El Zombo App");

        var spacer = Spacer.appendTo(flex,globalState);

        var bg = ButtonGroup.appendTo(flex, globalState);
        var b1 = Button.appendTo(bg,globalState,ColorSchemeEnum.TEAL,"Sign Up");
        var b2 = Button.appendTo(bg,globalState,ColorSchemeEnum.TEAL,"Log In");
    }
```

```java

    {
        // this is equivalent to display='flex'.
        // Note that if you have more than one spacer, the spacers will all be the same size
        var flex = Flex.appendTo(parent,globalState);
        flex.setWidth(globalState,"80%");
        var s1 = Square.appendTo(flex,globalState,"Box1");
        s1.setBgColor(globalState,"blue").setColor(globalState,"white");

        var spacer = Spacer.appendTo(flex,globalState);

        var s2 = Box.appendTo(flex,globalState,"3 boxes, with Spacers between them");
        s2.setBgColor(globalState,"green").setColor(globalState,"white");

        spacer = Spacer.appendTo(flex,globalState);

        var s3 = Square.appendTo(flex,globalState,"Box 3 Data");
        s3.setBgColor(globalState,"red").setColor(globalState,"white");
    }
```
""";
        addExplanationPages(xp, globalState,"Flex", markdownDescription,  parent, java);
    }


    private void addStack (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### HStack/VStack

VStack (Vertical Stack)  allows for positioning in the vertical direction (i.e. single column, multi row)

HStack (Horizontal Stack) allows for positioning in the horizontal direction (ie multi column, single row) 

Example of VStack, with one row containing a HStack:

""";
        var vs = new VStack(globalState);
        vs.setWidth(globalState,"80%");
        vs.setBorder(globalState, "2px dashed blue");

        Text.appendTo(vs, globalState,"First row in vstack, Text Control");
        Button.appendTo(vs, globalState,"Button in vstack, row 2");
        Text.appendTo(vs, globalState,"Text, row 3");
        var hs = HStack.appendTo(vs,globalState);

        Text.appendTo(hs, globalState,"Hstack col 1");
        Text.appendTo(hs, globalState,"Hstack col 2").setBgColor(globalState,"green.300");
        Text.appendTo(hs, globalState,"Hstack col 3");

        Text.appendTo(vs, globalState,"Text, Last row in VStack");

        var java  = """
## Example source code:

```java
    var vs = new VStack(globalState);
    vs.setWidth(globalState,"80%");
    vs.setBorder(globalState, "2px blue");    

    Text.appendTo(vs, globalState, "First row in vstack, Text Control");
    Button.appendTo(vs, globalState, "Button in vstack, row 2");
    Text.appendTo(vs, globalState, "Next row is a HStack");#
    
    var hs = HStack.appendTo(vs,globalState);
    Text.appendTo(hs, globalState, "Hstack col 1");
    Text.appendTo(hs, globalState, "Hstack col 2").setBgColor(globalState,"green.300");
    Text.appendTo(hs, globalState, "Hstack col 3");

    Text.appendTo(vs, globalState, "Text, Last row in VStack");
```
""";
        addExplanationPages(parent, globalState,"Stack", markdownDescription, vs, java);
    }


    private void addSimpleAccordion (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### SimpleAccordion

A simple control for openable sections (default closed)

Examples:

""";
        var vs = new VStack(globalState);

        var sa = SimpleAccordion.appendTo(vs,globalState, "Title of accordion");
        Text.appendTo(sa,globalState,"Data within accordion");
        Image.appendTo(sa,globalState).setSrc(globalState,"https://picsum.photos/200/300");

        var java  = """
## Example source code:

```java
     var sa = SimpleAccordion.appendTo(vs,globalState, "Title of accordion");
     Text.appendTo(sa , globalState, "Text Data within accordion");
     Image.appendTo(sa,globalState).setSrc(globalState,"https://picsum.photos/200/300");
```
""";
        addExplanationPages(parent, globalState,"SimpleAccordion", markdownDescription, vs, java);
    }

    private void addSimpleGrid (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### SimpleGrid

The SimpleGrid control allows children to be added in a simple grid structure, with set spacing between the items

Examples:

""";
        var vs = new VStack(globalState);

        var grid = SimpleGrid.appendTo(vs,globalState);
        grid.setWidth(globalState,"90%");
        grid.setMinChildWidth(globalState, "120px"); // any items added will be made 120px in size
        grid.setSpacingX(globalState,"20px").setSpacingY(globalState,"20px"); //  spacing around all grid items

        var colours = Arrays.asList("tomato","green","blue","yellow","pink");
        for (int ii = 0; ii < 15; ++ii) {
            int l = 300+ii;
            Image.appendTo(grid,globalState).setSrc(globalState,"https://picsum.photos/200/"+l);
        }
        var java  = """
## Example source code:

```java
    var grid = SimpleGrid.appendTo(vs,globalState);
    grid.setWidth(globalState,"90%");
    grid.setMinChildWidth(globalState, "120px"); // any items added will be made 120px in size
    grid.setSpacingX(globalState,"20px").setSpacingY(globalState,"20px"); //  spacing around all grid items

    var colours = Arrays.asList("tomato","green","blue","yellow","pink");
    for (int ii = 0; ii < 15; ++ii) {
        int l = 300+ii;
        Image.appendTo(grid,globalState).setSrc(globalState,"https://picsum.photos/200/"+l);
    }
```
""";
        addExplanationPages(parent, globalState,"SimpleGrid", markdownDescription, vs, java);
    }

    private void addTabs (VisualControl parent, StateData state) {
        String markdownDescription = """
### Tabs

The Tabs control allows users to easily switch between different sections of content within a page or application. 

It organizes multiple tabs, each representing a distinct section of content, and allows users to click on them to display the associated content. 

It’s commonly used to create multi-step forms, navigation menus, or dashboard views.

Examples:

""";
        var vs = new VStack(state);

        // Set up the Tabs, general style etc
        var tabBar = Tabs.appendTo(vs,state);
        tabBar.setVariant(state, Tabs.VariantEnum.ENCLOSED);
        tabBar.setIsFitted(state,true);

        // create the list of Tab headers, can be any type of control
        var tabList = TabList.appendTo(tabBar,state);
        tabList.setTabs(state,Arrays.asList("Tab 1","Tab 2","Tab 3"));  // simplest way to add tabs, otherwise just add children

        // create the list of Tab panels - must be in the same order as the tablist above...
        var tabPanels = TabPanels.appendTo(tabBar,state);
        var data1 = Box.appendTo(tabPanels,state,"This is tab 1!");
        var data2 = Box.appendTo(tabPanels,state,"and this is tab 2!");
        var data3 = Box.appendTo(tabPanels,state,"and this is tab 3!");
        var java  = """
## Example source code:

```java
    // Set up the Tabs, general style etc
    var tabBar = Tabs.appendTo(parent,state);
    tabBar.setVariant(state, Tabs.VariantEnum.ENCLOSED);
    tabBar.setIsFitted(state,true);

    // create the list of Tab headers, can be any type of control
    var tabList = TabList.appendTo(tabBar,state);
    tabList.setTabs(state,Arrays.asList("Tab 1","Tab 2","Tab 3"));  // simplest way to add tabs, otherwise just add children

    // create the list of Tab panels - must be in the same order as the tablist above...
    var tabPanels = TabPanels.appendTo(tabBar,state);
    var data1 = Box.appendTo(tabPanels,state,"This is tab 1!");
    var data2 = Box.appendTo(tabPanels,state,"and this is tab 2!");
    var data3 = Box.appendTo(tabPanels,state,"and this is tab 3!");
```
""";
        addExplanationPages(parent, state,"Tabs", markdownDescription, vs, java);
    }


    private void addTabSelectControl (VisualControl parent, StateData state) {
        String markdownDescription = """
### TabSelect

The TabSelect control allows users to easily switch between different sections of content within a page or application.

However, It also allows tabs to be enabled or disabled 

By default, using setValue on the control with a comma separated list of Tab Names to select which tabs are visible.

Examples:

""";
        var vs = new VStack(state);

        var syncControls = FormContext.appendTo(vs, state); // allows both controls below to sync under the name 'tabz'

        var box = VStack.appendTo(syncControls,state);
        box.setWidth(state,"100%").setHeight(state,"100%").setBgColor(state,"darkgray");

        var text = Text.appendTo(box,state,"TabSelectControl");

        // make a control to choose tab
        var cbg = CheckboxGroup.appendTo(box, state ,"LightBlue,Orange,Green,White", DefaultValue.set("LightBlue,Green"), ColorSchemeEnum.GREEN);
        cbg.setName(state, "tabz");
        Divider.appendTo(box,state);

        var tsc = TabSelectControl.appendTo(box,state);
        tsc.setName(state, "tabz"); // sync values from checkbox with same name
        //tsc.setValue(state,"LightBlue,Green"); // if not using name for source, you can set value directly to choose what is enabled

        var vals = Arrays.asList("lightblue","orange","green","white");
        for (var color : vals) {
            var t1 = TabSelectEntry.appendTo(tsc,state, "This is a "+color+" tab");
            t1.setTabName(state,color).setTabText(state,color.toUpperCase()+" Tab").setBgColor(state,color);
        }

        var java  = """
## Example source code:

```java
    // Set up the Tabs, general style etc
    var tabBar = Tabs.appendTo(parent,state);
    tabBar.setVariant(state, Tabs.VariantEnum.ENCLOSED);
    tabBar.setIsFitted(state,true);

    // create the list of Tab headers, can be any type of control
    var tabList = TabList.appendTo(tabBar,state);
    tabList.setTabs(state,Arrays.asList("Tab 1","Tab 2","Tab 3"));  // simplest way to add tabs, otherwise just add children

    // create the list of Tab panels - must be in the same order as the tablist above...
    var tabPanels = TabPanels.appendTo(tabBar,state);
    var data1 = Box.appendTo(tabPanels,state,"This is tab 1!");
    var data2 = Box.appendTo(tabPanels,state,"and this is tab 2!");
    var data3 = Box.appendTo(tabPanels,state,"and this is tab 3!");
```
""";
        addExplanationPages(parent, state,"TabSelect", markdownDescription, vs, java);
    }



    private void addTextContainer (VisualControl parent, StateData globalState) {
        String markdownDescription = """
### TextContainer

TextContainer is used to constrain a content's width to the current breakpoint, while keeping it fluid

use setMaxWidth to set the maximum width of the data within it, e.g
"md" / "550px" / "60ch"

Examples:

""";
        var vs = new VStack(globalState);

        // TextContainer
        var box = TextContainer.appendTo(vs, globalState);
        box.setMaxWidth(globalState, "60ch");
        box.setCenterContent(globalState, true);
        var text = Text.appendTo(box, globalState);
        text.setText(globalState, "TextContainer class is best suited for text, here width is set to '60ch' (60 characters), thus once text is larger than 60 characters wrapping occurs...");

        var java  = """
## Example source code:

```java
    // TextContainer
    var box = TextContainer.appendTo(vs, globalState);
    box.setMaxWidth(globalState, "60ch");
    box.setCenterContent(globalState, true);
    var text = Text.appendTo(box, globalState);
    text.setText(globalState, "TextContainer class is best suited for text, here width is set to '60ch' (60 characters), thus once text is larger than 60 characters wrapping occurs...");
```
""";
        addExplanationPages(parent, globalState,"TextContainer", markdownDescription, vs, java);
    }



    public void addGridPage (VisualControl parent, StateData globalState)
    {
        var vstack = VStack.appendTo(parent,globalState);

        String markdownDescription = """
## GridLayout/GridWindow container

Think of it like a windowing system within the browser, where different windows could be moved, added, resized etc

GridLayout offers a grid like container than can store multiple GridWindow controls.\n

Each Gridwindow instance added to the GridLayout can contain its own title and content

- Gridwindow may optionally contain a Title Text, explaining what is within it
- Gridwindow may be set to "drag and drop", allowing the user to reposition the window within the GridLayout
- Gridwindow may be set to be resizeable, allowing the content within it to resize based on chosen dimensions

Example: (try moving the windows around)

""";
        Markdown.appendTo(vstack,globalState,markdownDescription);

        var gl = new GridLayout(globalState); // create it here, note we haven't added it to the tree yet
        vstack.addChild(globalState,gl); // add GridLayout

        gl.setCols(globalState,20).setRowHeight(globalState,20);
        gl.setWidth(globalState,"95%").setHeight(globalState,"400px");
        gl.setCompactType(globalState, GridLayout.CompactTypeEnum.NONE);
        // Create GridWindow, with inner text area
        var window = GridWindow.appendTo(gl,globalState, "Optional Title");
        window.setHeight(globalState,3).setWidth(globalState,3).setX(globalState,0).setY(globalState,0);
        window.setBgColor(globalState,"#C2DFFF");
        Text.appendTo(window,globalState,"Text Control inside window"); // add text control to window
        ////////////////
        window = GridWindow.appendTo(gl,globalState );
        window.setHeight(globalState,3).setWidth(globalState,3).setX(globalState,3).setY(globalState,0);
        window.setResizeable(globalState,false);
        Text.appendTo(window,globalState,"No Title, draggable, not resizeable").setBgColor(globalState,"white");
        ////////////////
        window = GridWindow.appendTo(gl,globalState );
        window.setHeight(globalState,1).setWidth(globalState,6).setX(globalState,6).setY(globalState,0);
        window.setResizeable(globalState,false).setHeader(globalState,false).setDraggable(globalState,false);
        window.setBorder(globalState,"");
        Text.appendTo(window,globalState,"No Title,No Border,No Resize,No Drag").setBgColor(globalState,"white");
        ////////////////
        // Add Sub container to Window, in this case "AutoWrap".  Add boxes to AutoWrap sub container
        window = GridWindow.appendTo(gl,globalState, "Drag Me, Resize Me");
        window.setHeight(globalState,5).setWidth(globalState,6).setX(globalState,0).setY(globalState,3);
        window.setOverflowY(globalState, OverflowEnum.AUTO);  // allow scrollbar in Y direction

        var autoWrap = AutoWrap.appendTo(window,globalState);
        var colours = Arrays.asList("tomato","green","blue","yellow","pink");
        for (int ii = 0; ii < 15; ++ii) {
            var bx = Box.appendTo(autoWrap,globalState, "sub container "+(ii+1));;
            bx.setWidth(globalState,"150px").setHeight(globalState,"80px").setBgColor(globalState,colours.get(ii % colours.size()));
        }
        /////////////////
        // Add example chart control
        window = GridWindow.appendTo(gl,globalState, "Chart Control inside window");
        window.setHeight(globalState,10).setWidth(globalState,7).setX(globalState,13).setY(globalState,0);

        var chart1 = Chart.appendTo(window,globalState, "LineBasic chart");
        chart1.setWidth(globalState,"400px");
        chart1.setVariant(globalState, Chart.VariantEnum.LINEBASIC);
        chart1.setFieldNames(globalState,Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));

        chart1.setLabels(globalState,Arrays.asList("Fizz Sales","Buzz Sales","FizzBuzz Sales"));
        var fizzSeries = Arrays.asList(12, 9, 7, 8, 5);
        var buzzSeries = Arrays.asList(2, 1, 3.5, 7, 3);
        var fizzBuzzSeries = Arrays.asList(1, 3, 4, 5, 6);
        chart1.setValue(globalState,Arrays.asList(fizzSeries,buzzSeries,fizzBuzzSeries));

        var hstack = HStack.appendTo(vstack,globalState);
        Text.appendTo(hstack,globalState,"Grid Compaction Type:");

        // Add a RadioGroup - when they select the compaction type, update the GridLayout
        var rg = RadioGroup.appendTo(hstack, globalState, "NONE,HORIZONTAL,VERTICAL", DefaultValue.set("NONE"), ColorSchemeEnum.RED);
        rg.setOnChange(globalState, (e) -> {
            gl.setCompactType(e.clientState(), GridLayout.CompactTypeEnum.valueOf( rg.getValue(e.clientState() ).toString()));
        });

        String explanation = """

###Example java code for above:\n

```java
    // create GridLayout
    var gl = GridLayout.appendTo(vstack,globalState);
    gl.setCols(globalState,20).setRowHeight(globalState,20);
    gl.setWidth(globalState,"95%").setHeight(globalState,"450px");

    // Create GridWindow, with inner text area
    var window = GridWindow.appendTo(gl,globalState, "Optional Title");
    window.setHeight(globalState,3).setWidth(globalState,3).setX(globalState,0).setY(globalState,0);
    window.setBgColor(globalState,"#C2DFFF");
    Text.appendTo(window,globalState,"Text Control inside window"); // add text control to window
    ////////////////
    window = GridWindow.appendTo(gl,globalState );  // create GridWindow
    window.setHeight(globalState,3).setWidth(globalState,3).setX(globalState,3).setY(globalState,0);
    window.setResizeable(globalState,false);
    Text.appendTo(window,globalState,"No Title, draggable, not resizeable").setBgColor(globalState,"white");
    ////////////////
    window = GridWindow.appendTo(gl,globalState );  // create GridWindow
    window.setHeight(globalState,1).setWidth(globalState,6).setX(globalState,6).setY(globalState,0);
    window.setResizeable(globalState,false).setHeader(globalState,false).setDraggable(globalState,false);
    window.setBorder(globalState,"");
    Text.appendTo(window,globalState,"No Title,No Border,No Resize,No Drag").setBgColor(globalState,"white");
    ////////////////
    // Add Sub container to Window, in this case "AutoWrap".  Add boxes to AutoWrap sub container
    window = GridWindow.appendTo(gl,globalState, "Drag Me, Resize Me");
    window.setHeight(globalState,5).setWidth(globalState,6).setX(globalState,0).setY(globalState,3);
    window.setOverflowY(globalState, OverflowEnum.AUTO);  // allow scrollbar in Y direction
    
    var autoWrap = AutoWrap.appendTo(window,globalState);
    var colours = Arrays.asList("tomato","green","blue","yellow","pink");
    for (int ii = 0; ii < 15; ++ii) {
    
        var bx = Box.appendTo(autoWrap,globalState, "sub container "+(ii+1));;
        bx.setWidth(globalState,"150px").setHeight(globalState,"80px").setBgColor(globalState,colours.get(ii % colours.size()));
    }
    /////////////////
    // Add example chart control
    window = GridWindow.appendTo(gl,globalState, "Chart Control inside window");
    window.setHeight(globalState,10).setWidth(globalState,7).setX(globalState,13).setY(globalState,0);
    
    var chart1 = Chart.appendTo(window,globalState, "LineBasic chart");
    chart1.setWidth(globalState,"400px");
    chart1.setVariant(globalState, Chart.VariantEnum.LINEBASIC);
    chart1.setLegends(globalState,Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
    
    chart1.setLabels(globalState,Arrays.asList("Fizz Sales","Buzz Sales","FizzBuzz Sales"));
    var fizzSeries = Arrays.asList(12, 9, 7, 8, 5);
    var buzzSeries = Arrays.asList(2, 1, 3.5, 7, 3);
    var fizzBuzzSeries = Arrays.asList(1, 3, 4, 5, 6);
    chart1.setValue(globalState,Arrays.asList(fizzSeries,buzzSeries,fizzBuzzSeries));
```
                                """;
        var accordion = SimpleAccordion.appendTo(vstack, globalState,"Example Code");
        accordion.setBgColor(globalState,"white");
        Markdown.appendTo(accordion,globalState,explanation);
    }

}

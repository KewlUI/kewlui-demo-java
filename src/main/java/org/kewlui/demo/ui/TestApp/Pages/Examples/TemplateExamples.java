package org.kewlui.demo.ui.TestApp.Pages.Examples;

/*
Demo - MIT License

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
import com.gofintec.kewlui.KewlUI;
import com.gofintec.kewlui.base.EventCallback;
import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.settings.AlignItemsEnum;
import com.gofintec.kewlui.controls.base.template.GenFromTemplate;
import com.gofintec.kewlui.controls.std.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.stream.Collectors;

public class TemplateExamples extends BasePage {
    protected static final Logger Log = LogManager.getLogger(TemplateExamples.class);


    public TemplateExamples () {
        super(true);
    }


    public void addTemplatingExamples(VisualControl parent, StateData state) {

        var vs = VStack.appendTo(parent, state);

        var markdown = """
# Server side templating

As mentioning under Templating/Theming, server side Templating allows you to load files/string on the server:

- use them as a template to generate a collections of controls
- use {{moustache}} notation to inject data into the template
- all controls given a xcontrol name will have their instantiated java classes returned GenFromTemplate 

Following are some example templates rendered into controls.
""";
        Markdown.appendTo(vs, state, markdown, Markdown.ControlsEnum.ALL);
        addExamples(vs, state);
    }

    private void addExamples (VisualControl parent, StateData globalState) {
        var vs = new VStack(globalState);

        var markdownDescription = """
# Example controls from server side templating

This example scans the local filesystem for *.kmd files and renders them as controls.

We will show these controls first in carosel, then in a AutoWrap container.

""";



        Divider.appendTo(vs, globalState);
        AutoWrap wr = AutoWrap.appendTo(vs, globalState);
        Divider.appendTo(vs, globalState);


        try {
            var resources = KewlUI.getResourceLoader().getResourceStreamsByPattern("static/templates/components/*.kmd");

            for (var resource : resources.entrySet()) {
                String name = resource.getKey();
                String content = new String(resource.getValue().get().readAllBytes());

                var vstck = VStack.appendTo(wr, globalState);
                vstck.setWidth(globalState, "400px");
                vstck.setPadding(globalState, "10px");
                vstck.setBoxShadow(globalState,"5px").setBorder(globalState, "5px solid black");

                var templateDesc = Markdown.appendTo(vstck, globalState, "", Markdown.ControlsEnum.ALL);
                var box = Box.appendTo(vstck, globalState);
                box.setPadding(globalState, "10px").setBorder(globalState, "1px solid black").setAlignItems(globalState, AlignItemsEnum.FLEX_START);

                // ok, we can give template KVs which modify {{moustache}} variables within the Text field (p.s. many controls use Value rather than Text as a way of showing values)
                // So a better use of these templates might be filling in input values sourced from a database
                Map<String,String> moustacheValues = name.contains("moustache") ? Map.of("newVisitors", "100", "sales","120") : null;

                var generated = GenFromTemplate.appendFromTemplate(box, globalState, content, moustacheValues);

                // Set top level description from file and any metadata in the file
                var metaDesc = generated.getMetaData().get("description");
                templateDesc.setText(globalState, String.format("Template file: %s\n\n<br/>%s<br/>", name, metaDesc==null ?"": "Desc: "+metaDesc+".\n<br/>"));

                var description = String.format("%s Contains the following Controls:\n\n- %s", name, generated.getControls().keySet().stream().collect(Collectors.joining(".\n- ")));
                var componentMarkDown = Markdown.appendTo(vstck, globalState, description, Markdown.ControlsEnum.ALL);

                EventCallback onChangeHandler = (e)-> {
                    StringBuilder desc = new StringBuilder(String.format("%s Contains the following Controls:\n\n", name));
                    generated.getControls().forEach((key, vcontrol) -> {
                        var val = vcontrol.getValue(e.clientState());
                        if (val==null)
                            desc.append("- "+key+"\n");
                        else
                            desc.append("- "+key+" = "+val+"\n");
                    });
                    componentMarkDown.setText(globalState, desc.toString());
                };

                generated.getControls().forEach((key, vcontrol) -> {
                    vcontrol.setOnChange(globalState, onChangeHandler);
                });


            }

        } catch (Exception e) {
            Text.appendTo(vs, globalState, "Error: "+e.getMessage());
        }


        var java = """
```java
    Divider.appendTo(vs, state);

    try {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:templates/**/*.kmd");

        AutoWrap wr = AutoWrap.appendTo(vs, state);


        for (Resource resource : resources) {
            String name = resource.getFilename();
            String content = new String(resource.getInputStream().readAllBytes());

            var vstck = VStack.appendTo(wr, state);
            vstck.setWidth(state, "400px");
            vstck.setPadding(state, "10px");
            vstck.setBoxShadow(state,"5px").setBorder(state, "5px solid black");

            var templateDesc = Markdown.appendTo(vstck, state, "", Markdown.ControlsEnum.ALL);
            var box = Box.appendTo(vstck, state);
            box.setPadding(state, "10px").setBorder(state, "1px solid black").setAlignItems(state, AlignItemsEnum.FLEX_START);

            // ok, we can give template KVs which modify {{moustache}} variables within the Text field (p.s. many controls use Value rather than Text as a way of showing values)
            // So a better use of these templates might be filling in input values sourced from a database
            Map<String,String> moustacheValues = name.contains("moustache") ? Map.of("newVisitors", "100", "sales","120") : null;

            var generated = GenFromTemplate.appendFromTemplate(box, state, content, moustacheValues);

            // Set top level description from file and any metadata in the file
            var metaDesc = generated.getMetaData().get("description");
            templateDesc.setText(state, String.format("Template file: %s\\n\\n<br/>%s<br/>", name, metaDesc==null ?"": "Desc: "+metaDesc+".\\n<br/>"));

            var description = String.format("%s Contains the following Controls:\\n\\n- %s", name, generated.getControls().keySet().stream().collect(Collectors.joining(".\\n- ")));
            var componentMarkDown = Markdown.appendTo(vstck, state, description, Markdown.ControlsEnum.ALL);

            EventCallback onChangeHandler = (e)-> {
                StringBuilder desc = new StringBuilder(String.format("%s Contains the following Controls:\\n\\n", name));
                generated.getControls().forEach((key, vcontrol) -> {
                    var val = vcontrol.getValue(e.clientState());
                    if (val==null)
                        desc.append("- "+key+"\\n");
                    else
                        desc.append("- "+key+" = "+val+"\\n");
                });
                componentMarkDown.setText(state, desc.toString());
            };

            generated.getControls().forEach((key, vcontrol) -> {
                vcontrol.setOnChange(state, onChangeHandler);
            });
        }
    } catch (Exception e) {
        Text.appendTo(vs, state, "Error: "+e.getMessage());
    }
```
""";

        addExplanationPages(parent, globalState, "Server side templating examples", markdownDescription, vs, java);
    }
}

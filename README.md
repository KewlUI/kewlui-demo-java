# KewlUI - Java Demo app

KewlUI is a platform for building modern web apps using Java backend code.  It is ideal for server devs who need to get an application up quickly.

KewlUI has a large number of controls and containers - as well as automatic client<->server rendering and data sharing capabilities.

This project is a demo of many of KewlUI's features, and contains basic documentation of the controls.

<img src="https://i.imgur.com/xFbFmLU.gif" alt="drawing" width="600"/>

## Table of Contents

- [Demos](#demos)
- [Features](#features)
- [Runnning] (#running)
- [Status](#status)
- [Performance](#performance)
- [Contribute](#contribute)
- [To-Do List](#to-do-list)

## Demos

This demo code providing visual examples - and documentation on controls. 
Click here to see the demo running:

[Demo - This code in this repo running on the cloud](https://kewlui.com/kewlui/index.html)


## Features

- Web front-end automatically created by and synced with server side code.

- Large number of Containers, Controls, Charts and Event system

- Built-in Theming, template, and localisation support
  - Client side and server side templating support
  - Ability to create own themes
  - Create your own component styles (variants)
  - Localisation - Allow controls have dynamic text based on language settings
  
- Data binding 
  - Server and client are synced in their value changes
  - Ability to define server side tables that are sent to clients via delta encoding
  - Client side Sql engine allows data to be filtered and arranged
  - Client Can retrieve data from REST endpoints (json/csv/tab etc), view in tables, charts etc

- Contains an optional grid window system, allowing windows to be added, moved, resized etc

- Java code uses Spring for /kewlui endpoints, thus spring security and other features can be added as needed


## Running

This demo uses Java 17.  Running main in KewlUiDemoApplication will start spring and register endpoints under /kewui

By default, this will serve the demo pages under http://localhost:8080/kewlui/index.html


## Performance

KewlUI is optimised for creating internal web applications, where large screen size and good network bandwidth can maximise the feature set.
While some support for mobile exists, it is currently a secondary use case.

While performance is currently good, this library certainly can be optimised further, making it smaller and faster in future releases (todo) 


## Status

KewlUI is currently in version 0.0.1 Alpha.  The main task at the moment is to add more documentation (outside of what is available in the demo app).

Happy for suggestions or feature requests - feedback is welcome!


## Contribute

If you have a feature request, please add it as an issue or make a pull request.

If you have a bug to report, please add relevant code (+ ideally screenshots) so we can reproduce the error.


## To-Do List

- [x] KewlUI - Main JavaScript/Java libraries 
- [x] Java Demo App
- [ ] AI generation/support on demo
- [ ] Set up documentation website at https://kewlui.com
- [ ] Additional performance optimisations
- [ ] Drag and drop builder
- [ ] C#/C++ back ends (start on this once Java is stabilised)


## Dependencies Copyright

Minified js and packaged jar files are Copyrighted and may NOT be decompiled/deminified for any use including AI training.  

## Disclaimer

 Like most/all other code on github: 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 Hopefully that makes the lawyers happy.


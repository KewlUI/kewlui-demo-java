# KewlUI - Demo app

KewlUI is a platform for building modern web apps using Java backend code.  It is ideal for server devs who need to get an application up quickly.

KewlUI has a large number of controls and containers - as well as automatic client<->server rendering and data sharing capabilities.

This project is a demo of many of KewlUI's features, and contains basic documentation of the controls.

<img src="https://i.imgur.com/xFbFmLU.gif" alt="drawing" width="750"/>

## Table of Contents

- [Demos](#demos)
- [Features](#features)
- [Runnning](#running)
- [Lower server memory usage](#Lower-server-memory-usage)
- [Status](#status)
- [Performance](#performance)
- [Contribute](#contribute)
- [To-Do List](#to-do-list)

## Demos

This demo code providing visual examples - and documentation on controls.

_As the demo showcases many controls and lots of streaming data, it should be seen on a desktop browser._

Click here to see the demo running:

**[Demo - This code in this repo running on the cloud](https://kewlui.com/kewlui/index.html)**


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
    - Client side **SQL ENGINE** engine allows data to be filtered and arranged    
    - Client Can retrieve data from REST endpoints (json/csv/tab etc), view in tables, charts etc

- Contains an optional grid window system, allowing windows to be added, moved, resized etc

- Global/Client state system reduce memory footprint per user, making it easier to scale

- /kewlui server handled with internal websocket/fallback to long polling, mimimising memory use

## Running

This demo uses Java 17.  Running main in KewlUiDemoApplication will register endpoints under /kewui/index.html

ie: By default, this will serve the demo pages under http://localhost:8080/kewlui/index.html

## 'Blank' starter project

You can find a minimal java starter project here [https://github.com/KewlUI/kewlui-start-java](https://github.com/KewlUI/kewlui-start-java) as a base for your own projects.


## Lower server memory usage

The design reduces server-side processing and memory requirements.  Charting, processing, data manipulation etc tends to be done on the client side. 

Server memory is split between global and 'per-user' client states:
  - Global state - controls and user interfaces designed here are shared between all users and synced to each client
  - Client state - any UI changes specific to a particular client session are stored in client state
  - The result is that a client will see a superset of global state and their personal state in one merged view.

For example, this could mean 99% of server side UI memory is shared, with say 1% showing anything specific per client.

This results in a drastic reduction in memory usage compared to systems that 'instantiate a complete UI per user', enabling better scalability and resource utilization.

## Performance

KewlUI is optimised for creating internal web applications, where large screen size and good network bandwidth can maximise the feature set.
While some support for mobile exists, it is currently a secondary use case.

While performance is currently good, this library certainly can be optimised further, making it smaller and faster in future releases (todo)

Communication is normally performed via websockets, however will use long polling if that is unavailable.

## Status

KewlUI is currently in version 1.24.1. (Alpha)   

Happy for suggestions or feature requests - feedback is welcome!

## Contribute

If you have a feature request, please add it as an issue or make a pull request.

If you have a bug to report, please add relevant code (+ ideally screenshots) so we can reproduce the error.

## To-Do List

- [x] KewlUI - Main JavaScript/Java libraries
- [x] Java Demo App
- [ ] Additional performance optimisations
- [ ] Drag and drop builder (paid version)
- [ ] AI generation/support on demo (paid version)
- [ ] C#/C++ back ends (start on this once Java is more stabilised)


## Dependencies Copyright

Minified KewlUI js and packaged jar files are Copyrighted and may NOT be decompiled/deminified for any use, including and especially AI training.

## Disclaimer

Like most/all other code on github:
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
We take no warantee or guaranteee
Hopefully that makes the lawyers happy.


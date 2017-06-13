# ExampleChartApp
Example app which uses SciChart library for dispaying simple local datasource points

App uses LocalPointService as data source, which can be replaced with other class(implementneeded),
e.g. remote point source service, etc. Just implement  IPointPeeker interface with your class, and replace 
source dependency in PointServiceModule (dagger2 approach).
A lot of ToDo`s leaved(caching, configuration change processing,..) as not being a point of test in task

Test Apk file: https://github.com/Sushinski/ExampleChartApp/blob/master/app-debug.apk

<img src="https://github.com/Sushinski/ExampleChartApp/blob/master/device-2017-06-13-220842.gif?raw=true" alt="Demo">

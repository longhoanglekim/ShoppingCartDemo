# ShoppingCartDemo
A simple shopping web with fundamental functions for studying how to make a web.
Written in Java,using HttpServlet to run server Apache Tomcat 10.
###Database

###Installation
-Clone the resporisity.
-Download Apache Tomcat at https://tomcat.apache.org/ and choose the suitable version for your computer.
###Configuration
Let IntelliJ IDEA know where the Tomcat application server is located.
1.Press Ctrl + Alt + 0S to open the IDE settings and then select Build, Execution, Deployment | Application Servers.
2.Click the Add button and select Tomcat.
3.Specify the path to the Tomcat server install location. IntelliJ IDEA detects and sets the name and version appropriately.
Create a run configuration﻿
IntelliJ IDEA needs a run configuration to build the artifacts and deploy them to your application server.
1.In the main menu, go to Run | Edit Configurations.
2.In the Run/Debug Configurations dialog, click the Add button, expand the Tomcat Server node, and select Local.
3.Fix any warnings that appear at the bottom of the run configuration settings dialog.
Most likely, you will need to fix the following:
+On the Deployment tab, add the artifact that you want to deploy:Ex: JavaEEHelloWorld:war exploded
4.On the Server tab, set the URL to point to the root resource:
5.Click OK to save the run configuration.
###Run
To run the configuration, press Alt + Shift + F10 and select the created application server configuration.
Alternatively, if you have your run configuration selected in the main toolbar at the top, you can click The Run icon in the main toolbar or press Shift + F10 to run it.
Once this is done, IntelliJ IDEA opens the specified URL in your web browser.

Setup Appium and Run automation test script on real device

We will need below software and drivers for Appium to run on Windows 10

1. Java JDK
 url: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
•	Download and install Java
•	Go to Environment variables and set JAVA_HOME and Path variables
Example: 
JAVA_HOME: C:\Program Files\Java\jdk1.8.0_201;
Path: %JAVA_HOME%/bin;
2. Android Studio
•	https://developer.android.com/studio
•	Download and install android studio
•	Once download is completed. Launch it
•	On the initial page click on ‘Configure’ on bottom right corner and select SDK Manager
•	Select API Level from SDK Platforms option depending on the Android version in your device refer: https://en.wikipedia.org/wiki/Android_version_history#Code_names
•	Select ok
•	After SDK Platforms are installed, select ”configure” and this time select SDK Tools option and verify all the required tools are installed
o	Android SDK build-Tools
o	Android SDK platform-Tools
o	Android SDK Tools
3. Node.js
Download and install Node.JS
Download Instruction: https://nodejs.org/en/ 
download LTS (Long term supported) version for your system (OS 32 bit/64bit)

4. Appium Dektop
Download Instruction: http://appium.io/downloads.html  scroll to bottom and find the Link  Appium-Desktop for OSX, Windows and Linux
click on this link and from the next page select download version https://github.com/appium/appium-desktop/releases/download/v1.12.1/Appium-windows-1.12.1.exe 
There are few more types of download option displayed, but we need to download simple version so download only setp.exe file.

5. Eclipse
Download instruction: https://www.eclipse.org/downloads/

6. TestNG
Once Eclipse is downloaded and launched.
Add TestNG from the menuEclipse MarkeplaceSearch for TestNG for Eclipse
 



Running Automation Test Script on real device

•	Connect your android device using USB Cable
•	Enable Developers mode 
•	Enable USB Debugging option and click allow
•	Remove any screen lock option(pin/fingerprint/face ID/pattern lock)  from the settings tab
•	Run Command Prompt in administrator mode
•	Run “adb devices” command
•	Command prompt list down the devices details
•	Copy the unique udid number mentioned
•	Enter the “udid” value mentioned in the main testNG.xml for parameter name “udidNumber”
•	Run Appium Desktop client and pass the Host and Port details under the parameter “serverURL” in testNG.xml
•	Click on “Start Server ”
•	Run testNG.xml file by right click Run AsTestNG Suite

 
Project layout

Project is divided into 3 parts:
•	Main
    o	Contains BaseTest.java 
    o	Contains Page specific functions
    o	Contains CommonUtils and implementation of Test
 
•	Test
    o	Contains Test workflow as per the test case steps
 
•	Resources
    o	Contains app apk location
    o	Contains ObjectMap for element locations
    o	Contains Test Specific testNG suite xml files 
 
 
Report Generation

•	Access emailable-report.html under test-output folder for the report and launch in chrome
Report Location: /MobileTestingCalculator/test-output/emailable-report.html


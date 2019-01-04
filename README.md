Patient Monitor App

Purpose
=======
This program demonstrates modularity which is a key concept for a sensor/monitor/display application. Sensors share a common interface and their display widgets share a common base class. 
Specifically, this program has the following sensors:
 - heart rate
 - diastolic and systolic blood pressure

Each sensor is depicted graphically by its display widget. 
Each display widget is uniquely different to allow for exploration in different graphical representations.

In the future, I look forward to adding the following sensors:
 - temperature
 - oxygen saturation
 - Respiration

Compile
=======
javac *.java

Run
===
java PatientMonitorApp

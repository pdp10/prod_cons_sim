

Application name: Producer - Consumer model

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Author:   Piero Dalle Pezze
Mail:     piero.dallepezze@gmail.com
Country:  Italy
Licence:  Open Source
Language: Java
Date:     14/05/2006
Version:  1.0

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


INTRODUCTION:
The producer-consumer model. This application simulates the behaviour of an abstract
producer-consumer situation. This model is at the base of some computers problems
like the processes scheduling per example. Cause the nature of Java programming
language, I must remember that the notify() of threads is casual both after a sleep()
call and after a wait() call. So Producer and Consumer object, which extends the same
class Thread, have a behaviour not predicible. In a process scheduling, this is not
a good thing!
---------------------------------------------------------------------------------------


JAVA VIRTUAL MACHINE
This application was written using JDK 5.0. So, if you have installed a previous 
version of the JVM (like 1.4.2 ..), you have to update to the last release.
---------------------------------------------------------------------------------------


DOCUMENTATION:
All documentation of the source code is in the folder javadoc/ .
---------------------------------------------------------------------------------------


SOURCE CODES:
The application is accomplished by the following files:
    - Producer.java
    - Consumer.java
    - Warehouse.java
    - Purchase.java
    - ProducerConsumer.java
All source code is in the folder src/producer_consumer/ .
---------------------------------------------------------------------------------------


MAKEFILE (for Linux and windows users)
Use makefile to install, execute, generate javadoc or remove the application. On detail,
open a console in the folder which is present the makefile. The use these comands:

make        : to compile the application and generate the .jar file.
make run    : to run the application.
make doc    : to generate the javadoc.
make clear  : to remove the .jar file, javadoc.

---------------------------------------------------------------------------------------


VERSIONS:
Version 1.0: A textual general purpose of the producer-consumer model.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

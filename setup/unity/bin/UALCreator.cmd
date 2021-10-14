@echo off

SETLOCAL

rem 
rem UALCreator.bat <EPP password>
rem 


set UNITY_HOME=%1
set BATCH_CLASSPATH=%UNITY_HOME%\tools\usecurity.jar;%UNITY_HOME%\tools\enttoolkit.jar

"%JAVA_HOME%"\bin\java -cp %BATCH_CLASSPATH% -Djava.library.path=%UNITY_HOME%/tools/ ca.teranet.unity.security.entrust.ServerLoginCredentialCreator C:\csp\entrust.ini C:\csp\CspInt.epf C:\csp\CspInt.ual AzzF0159

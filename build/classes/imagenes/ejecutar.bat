@echo off

FOR %%X IN ("C:\wamp64\wampmanager.exe*.*") DO rundll32 shell32.dll,ShellExec_RunDLL %%X
call runcrud.bat
if %ERRORLEVEL% == "0" goto runbrowser
echo Errors during server startup

:runbrowser
"C:\Program Files\Mozilla Firefox\firefox" -new-window http://localhost:8080/crud/v1/task/getTasks

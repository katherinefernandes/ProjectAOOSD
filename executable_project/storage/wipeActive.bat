@ECHO off
XCOPY "emptyData\clients.xml" "activeData" /Y
XCOPY "emptyData\containers.xml" "activeData" /Y
XCOPY "emptyData\history.xml" "activeData" /Y
XCOPY "emptyData\ports.xml" "activeData" /Y

pause
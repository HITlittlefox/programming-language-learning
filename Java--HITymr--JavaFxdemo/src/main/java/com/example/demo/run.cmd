set PATH_TO_FX="C:\Program Files\Java\javafx-sdk-17.0.1\lib"
javac --module-path %PATH_TO_FX% --add-modules=javafx.controls,javafx.media App15_12.java
java --module-path %PATH_TO_FX% --add-modules=javafx.controls,javafx.media App15_12
pause


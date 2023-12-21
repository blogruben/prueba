

@rem descargar JDK 
curl -L -o jdk17.zip https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.9+9.1/OpenJDK17U-jdk_x64_windows_hotspot_17.0.9_9.zip
tar -xf jdk17.zip
del /f /q "jdk17.zip"
ren jdk-17.0.9+9 jdk17 
move jdk17 ../jdk17


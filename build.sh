#!/bin/bash

jpackage \
    --input /home/juan/Escritorio/Generador_Datos/out/artifacts/data_sintec_jar/ \
    --main-jar data-sintec.jar \
    --main-class org.datasintetica.datasintec.Launcher \
    --name GeneradorDataSintetica \
    --app-version 1.0.0 \
    --vendor Escobarq \
    --icon /home/juan/Escritorio/Generador_Datos/src/main/resources/org/datasintetica/datasintec/assets/images/iconos.png \
    --type deb

echo "Packaging completed successfully."
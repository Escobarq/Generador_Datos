# Generator Data Sintetica

Generador de Datos Sintéticos para pruebas de carga Del portal silin, entidad etc..

## Requisitos
- Java JDK 17 
- Maven 3.6.0 o superior

## Configuración del Entorno

1. **Instalación de Java JDK**: Asegúrate de tener Java JDK 22 o superior instalado en tu sistema. Puedes descargarlo desde [Oracle](https://www.oracle.com/java/technologies/downloads/?er=221886#java22) o cualquier distribución de OpenJDK.

2. **Instalación de Maven**: Necesitas Maven para construir y gestionar el proyecto. Descarga e instala Maven desde [Apache Maven Project](https://maven.apache.org/download.cgi).

3. **Configuración de Variables de Entorno**: Configura las variables de entorno `JAVA_HOME` y `MAVEN_HOME` apuntando a las ubicaciones de instalación de JDK y Maven, respectivamente.

## Instalación

Clona este repositorio en tu máquina local usando:

```bash
git clone {url}
```

Después haberse dirigido al proyecto mediante terminal o con su editor de preferencia **recomendamos intellij idea** o VS CODE
y correr el proyecto para ver la siguiente pantalla principal.

![Generador Data Sintect](/images/generador.png "Generador Data Faker")

## Flujo de Control del aplicacion

```mermaid
graph TD;
    A[Inicio] -->|Elegir tipo de datos| B(Tipo de FT: 1, 6, 11, 12);
    B -->|Indicar cantidad de registros| C(Cantidad de registros);
    C -->|Seleccionar tipo de cliente| D(Tipo de Cliente: Antioquia, Palmira, GVC, Tuluá);
    D -->|Seleccionar tipo de archivo| E(Tipo de Archivo: Retroactivo, Ordinario);
    E --> F{Sale todo bien?};
    F -->|Sí| G(Muestra el Modal);
    G -->|Seleccionar delimitador| H(Seleccionar coma, punto y coma, onepipe, barra vertical partida);
    H -->|Seleccionar extension| I(Seleccionar csv o txt);
    I -->|Generar archivo| J(Generar archivo);
    J --> K[Fin];
    F -->|No| L[Muestra mensaje de alerta para rellenar los campos];
    L --> E;
```

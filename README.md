# LibrosApp - Práctica Alura

Una aplicación de línea de comandos desarrollada en Spring Boot que consume la API de Gutendex para buscar y analizar información sobre libros gratuitos.

## 📚 Descripción

Esta aplicación permite consultar información de libros desde la API pública de Gutendex, ofreciendo funcionalidades como:
- Top 10 de libros más descargados
- Búsqueda de libros por título
- Estadísticas de descargas
- Análisis de datos de libros

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 4.0.0**
- **Maven** (con Maven Wrapper)
- **Jackson** para procesamiento JSON
- **HTTP Client** para consumo de APIs

## 📋 Prerrequisitos

- Java 17 o superior
- Maven (opcional, ya que incluye Maven Wrapper)

## 🚀 Instalación y Ejecución

### Usando Maven Wrapper (Recomendado)

1. Clona el repositorio:
```bash
git clone [url-del-repositorio]
cd librosapp_pract_alura
```

2. Ejecuta la aplicación:
```bash
# En Linux/Mac
./mvnw spring-boot:run

# En Windows
mvnw.cmd spring-boot:run
```

### Usando Maven instalado

```bash
mvn spring-boot:run
```

## 🏗️ Estructura del Proyecto

```
src/main/java/com/librosappaplura/librosapp_pract_alura/
├── LibrosappPractAluraApplication.java  # Clase principal
├── Principal.java                        # Lógica de la aplicación
├── model/                               # Modelos de datos
│   ├── Datos.java
│   ├── DatosAutor.java
│   └── DatosLibros.java
└── services/                            # Servicios
    ├── ConsumeApi.java
    ├── ConvierteDatos.java
    └── IConvierteDatos.java
```

## 📖 Funcionalidades

### 1. Top 10 Libros Más Descargados
Muestra una lista de los 10 libros con mayor número de descargas.

### 2. Búsqueda de Libros
Permite buscar libros por título ingresando el nombre del libro deseado.

### 3. Estadísticas de Descargas
Proporciona estadísticas sobre las descargas de libros:
- Media de descargas
- Máximo de descargas
- Mínimo de descargas
- Cantidad de registros evaluados

## 🔧 Configuración

La aplicación se conecta automáticamente a la API de Gutendex en:
```
https://gutendex.com/books/
```

## 🧪 Pruebas

Para ejecutar las pruebas del proyecto:

```bash
./mvnw test
```

## 📊 Modelos de Datos

- **Datos**: Contiene la lista de libros obtenidos de la API
- **DatosLibros**: Información individual de cada libro (título, autor, idiomas, descargas)
- **DatosAutor**: Información del autor (nombre, fecha de nacimiento)

## 🎯 Características Técnicas

- **Patrón de diseño**: Uso de records para modelos inmutables
- **Consumo de APIs**: Implementación con HttpClient de Java
- **Procesamiento JSON**: Usando Jackson con alias personalizados
- **Programación funcional**: Uso de Streams y Optional
- **Maven Wrapper**: Permite ejecutar Maven sin instalación previa

## 📝 Notas

- La aplicación se ejecuta en modo consola
- Los datos se obtienen en tiempo real desde Gutendex
- No requiere base de datos local
- Incluye manejo de errores básico

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor, asegúrate de:
1. Seguir las convenciones de código existentes
2. Probar los cambios antes de enviar
3. Actualizar la documentación si es necesario

## 📄 Licencia

Este proyecto está bajo la Licencia Apache 2.0. Ver el archivo LICENSE para más detalles.
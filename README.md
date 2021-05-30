# quasar-fire
Herramienta de triangulacion de naves enemigas

## Arquitectura

La solucion esta hecha en base a Spring Boot. Como dependencias posee las siguientes:
- Spring Boot DevTools 
- Spring Web

## Instalacion

La gestion de dependencias se realiza atraves de maven, y para facilitar la instalacion del mismo, se provee un maven autocontenido (Maven Wrapper). Por lo que el manejo del building y el run lo haremos por medio de los scripts `mvnw` para linux y `mvnw.cmd` para windows.

```bash
sudo sh ./mvnw clean install
```

La primera vez descargara todas las dependencias de maven y las necesitadas por el proyecto.

## Run



```bash
sudo sh ./mvnw spring-boot:run
```
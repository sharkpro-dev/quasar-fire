# Diseño de la aplicacion

## Arquitectura
Se eligio SpringBoot como framework principal para la arquitectura de la aplicacion. 

La eleccion fue tal, porque SpringBoot provee lo necesario para una inicializacion rapida del proyecto y es muy robusto.

Solo se agregaron las siguientes dependencias:
 - Spring Web: Para facil implementacion de una API REST.
 - Spring Dev Tools: Para facilitar el desarrollo de la aplicacion.

A partir de esto, se agregaron los componentes y servicios necesarios, para solucionar el problema provisto.


### Modularizacion

Se decidio organizar la aplicacion en paquetes respecto a la responsabilidad de las clases. A groso modo son:

- Controller: exposicion de endpoints para la consulta de la API REST, con sus respectivos modelos.
- Business Logic: todo lo relacionado a la solucion particular del problema. 
- State: lo referente al estado global de la aplicacion.
- Model: Entidades relacionas fuertemente al problema a resolver.
- Configuration: mera configuracion de SpringBoot

### Libreria externas

A parte de las librerias necesarias de spring boot, se agrego la libreria [trilateration](https://github.com/lemmingapex/trilateration), que nos permite calcular, utilizando posiciones y distancias, una posicion por triangulacion.


### Testing

Se aprovecho la funcionalidad de SpringBoot para testear la correcta funcionalidad de los objetos. Solo se testeo lo que implica el mantenimiento de estado de la aplicacion o lo que implica logica de negocio importante.

Lo demas no se testeo. Se aprovecha la robustez de Spring. 

El enfoque estuvo puesto en realizar la menor cantidad de tests, pero que los mismos tengan la mayor eficacia posible.


### Modelado de Objetos

En principio, se intento enfocarse en el principio de responsabilidad unica. De esta manera, el modelo quedaria abierto a extension y con poco acoplamiento.


### Live Cloud Test
Para el test en vivo, se utilizo el beneficio de [AWS Free Tier](https://aws.amazon.com/free/?all-free-tier.sort-by=item.additionalFields.SortRank&all-free-tier.sort-order=asc&awsf.Free%20Tier%20Types=*all&awsf.Free%20Tier%20Categories=*all).

Se creo una instancia con Ubuntu 20 como S.O. La misma tiene la aplicacion corriendo. Con un nginx fowardeando lo del puerto 80 al 8080.




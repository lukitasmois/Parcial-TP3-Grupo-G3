# Parcial TP3 Grupo 3

## Alumnos
- **Esteban Grafeuille** - [EstebanGrafeuille](https://github.com/EstebanGrafeuille)  
- **Mila Pesa Mazzola** - [milapesa](https://github.com/milapesa)  
- **Miranda Leschinsky** - [miruleschinsky](https://github.com/miruleschinsky)  
- **Lucas Moix** - [lukitasmois](https://github.com/lukitasmois)  
  
  
  
## Preguntas

**_En el caso que se pida extender la app para otros tipos de funcionalidades, como hoteles, puntos turísticos o paquetes ¿la app es flexible? ¿Qué cambios realizaría?_**  
La app es flexible a cambios, contiene elementos reutilizables y que pueden llamarse de varias partes del codigo, como por ejemplo la api o interfaces para guardar el estado de los componentes, solo habria que trabajar en la implentacion y los estilos visuales  


**_¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla?_**  
Utilizamos una gran variedad de carpetas para poder tener todo correctamente separado, ademas de tener ids decriptivos para todos los elementos que se utilizen.  
Los objetos con los que trabajamos (Viajes, Vuelos y Aeropuertos) cuentan con sus respectivos modelos (Entidad, Dominio y Modelos de API) esto nos permite poder trabajar de una forma escalable y solo con las propiedades que necesitemos.

**_¿Qué mejoras detectan que podrían realizarle a la app?_**  
Las mejoras principales a realizar son en torno al diseño y correcciones de errores visuales. Tambien se podrian realizar mejoras en la arquitectura de la base de datos local, adaptandola a posibles cambios futuros.
En cuanto a funcionalidad se nos ocurre que se podria agregar un filtrado a la busqueda de viajes.  
Tambien se podria agregar la funcionalidad de loguear al usario y que una vez ingresado este pueda customizar algunos elementos como puede ser el nombre, foto de perfil y ademas implementar el guardado de favoritos en la nube.

**_¿Qué manejo de errores harían? ¿dónde los contemplan a nivel código?_**  
La aplicacion cuenta con la opcion de cargar los ultimos datos a los que se tuvo disponibilidad a la hora de conectarse sin conexion, permitiendo al usuario no solo ver los viajes que estaban disponibles en ese momento sino tambien ver los viajes que habian sido seleccionados como favoritos.  
En cuanto a validaciones y manejo de errores a implementar seria importante verificar los campos de entradas de datos como pueden ser en el menu de busqueda de viajes o inputs futuros, ademas de manejar correctamente los errores de mal funcionamiento al hacer las llamadas a la API.

**_En el caso de uso de persistencia para Favoritos, ¿que estrategia sugieren?_**  
Pensando en agregar nuevas funcionalidades como las mecionadas anteriormente (hoteles, puntos turísticos o paquetes) se podria seguir utilizando la estrategia actual, que es agregar un campo booleano en los modelos de dominio y entidad que nos permitan ver y cambiar el estado de "guardado" o no.

**_Si la tendríamos que convertir a Español y conservar el Inglés, qué estrategia utilizaría para extenderla. Y si necesitamos agregar otros idiomas?_**  
Se podria traducir directamente el archivo String.xml y cambiarian los textos utilizados. Lo mismo para los demas idiomas.

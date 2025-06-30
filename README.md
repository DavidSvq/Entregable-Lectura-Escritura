# Entregable - Lectura y Escritura

Tarea en Java centrada en la escritura y lectura de archivos.

Esta aplicación permite llevar un control de las películas vistas y almacenar información sobre ellas. El diseño y la estructura del programa quedan a elección propia.

## Características implementadas

- Lectura de ficheros.
- Creación de la clase `Pelicula` y la clase `Main`.
- Añadido extra al enunciado: creación de la clase `LectorCsv` para la lectura de archivos.
- Implementación de interfaces:
  - `Comparable` y `Comparator` para ordenar objetos.
  - Interfaz funcional para definir las acciones del menú principal y sus respectivas clases que las implementan.
- Creación de la clase `Constantes`, que centraliza todas las constantes utilizadas.

## Refactorización aplicada

Se ha realizado una mejora sustancial del código en **todas las clases del proyecto**, excepto en la clase `Pelicula` y en la interfaz principal, ya que estas solo contienen atributos y métodos básicos bien definidos desde el inicio.

Las mejoras aplicadas incluyen:

- Extracción de métodos con nombres descriptivos para mejorar la legibilidad.
- Eliminación de código duplicado.
- Reducción de parámetros innecesarios.
- Reemplazo de variables intermedias redundantes.
- Reestructuración del flujo de control para mayor claridad y mantenimiento.
- Eliminación de comentarios innecesarios (por ejemplo, descripciones de condicionales o bucles), sustituidos por nombres claros y autoexplicativos en métodos y variables.
- Sustitución de estructuras condicionales `switch` por un `Map` de acciones, aprovechando la interfaz funcional y sus implementaciones ya existentes.
  
Aunque la refactorización aplicada se nota claramente, fue posible realizarla de forma limpia y eficaz gracias a que el diseño previo ya seguía una estructura clara. Por ejemplo, la eliminación del `switch` fue directa, ya que la interfaz funcional y las clases asociadas estaban previamente creadas, lo que facilitó su integración posterior en un `Map` de acciones.
  
> 📝 Nota: El código refactorizado está escrito en inglés, mientras que el código original se mantiene en español, tanto en los nombres como en los comentarios. Esto permite comparar directamente ambos enfoques dentro del mismo proyecto.

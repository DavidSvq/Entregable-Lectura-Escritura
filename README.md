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

En una de las clases se ha realizado una mejora sustancial del código mediante:

- Extracción de métodos con nombres descriptivos para mejorar la legibilidad.
- Eliminación de código duplicado.
- Reducción de parámetros innecesarios.
- Reemplazo de variables intermedias redundantes.
- Reestructuración del flujo de control para mayor claridad y mantenimiento.
  
Aunque la refactorización aplicada se nota claramente, fue posible realizarla de forma limpia y eficaz gracias a que el diseño previo ya seguía una estructura clara. Por ejemplo, la eliminación del `switch` fue directa, ya que la interfaz funcional y las clases asociadas estaban previamente creadas, lo que facilitó su integración posterior en un `Map` de acciones.
  
  

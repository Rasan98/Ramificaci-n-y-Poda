# Problema de los envases
El problema de los envases consiste en buscar el mínimo de envases, con capacidad E, necesarios para empaquetar una series de objetos, de los cuales de sabe su volumen. 
Por ejemplo, teniendo envases con E = 4, y objetos con capacidades (2, 1, 3, 2), el resultado óptimo serían dos envases ([2,2] y [3,1]).

## Ramificación y poda
El algoritmo de ramificación y poda consiste en recorrer todas las posibles soluciones de un problema, para obtener así la solución óptima. La poda consiste en el uso de cotas optimistas y pesimistas para descartar los resultados que no van a llegar a solución óptima. 

## Contenido

* __GeneradorDePruebas.java:__ genera una lista aleatoria de capacidades de objetos según los valores de las variables. Esta se deberán incorporar al código de Main.java.
* __Main.java:__ contiene sets de pruebas para descomentar en el código.
* __Envasado.java:__ contiene el código del algoritmo. Hay tres versiones, para poder comparar datos entre ellas:
  * Sin cotas: no se utilizan cotas en el algoritmo. Expandirá muchos más nodos, tendrá un mayor tiempo de ejecución, pero un menor tiempo medio por nodo.
  * Cotas malas: usa una cota optimista y pesimista muy fácil de calcular, pero demasiado optimista/pesimista, por lo que no podará mucho el árbol de soluciones. 
  * Cotas buenas: usa una cota optimista y pesimista más difícil de calcular, aumentando el tiempo medio por nodo, pero podará mucho el árbol de soluciones, disminuyendo el número de nodos expandidos y el tiempo de ejecución.

## Análisis 

El resultado mostrará el número de nodos expandidos, el tiempo de ejecución y el tiempo medio por nodo. 

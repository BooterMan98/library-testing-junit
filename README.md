# consolBooks
https://github.com/BooterMan98/library-testing-junit

## Instrucciones de uso

Para correr el programa en la carpeta raíz es necesario ejecutar
```zsh
    mvn package
```
Una vez realizado esto, ejecutar:
```zsh
    java -cp target/consolBooks-1.0-SNAPSHOT.jar org.example.Main
```

Los comandos a utilizar durante el programa son los siguientes
- `add` para agregar un libro
- `edit <ISBN>` para editar un libro según el ISBN dado
- `remove <ISBN>` para eliminar un libro según el ISBN dado
- `exit` para salir del programa
- `find title` para buscar libros con un titulo en especial
- `find author` para buscar libros hechos por un autor específico
- `find isbn <ISBN>` para buscar un libro especifico según su ISBN

> Nota: todos estos comandos deben ser escritos en una linea y luego presionar enter

#### Opción editar
Si hace uso del comando editar, se le pedirá que ingrese un número para seleccionar la propiedad del libro a cambiar.

Si selecciona cambiar los autores (3), se solicitar denuevo que indique si va a agregar `add` o eliminar `remove` y luego podra colocar el nombre que quiere quitar/agregar

## Reporte de Preubas

Para acceder al reporte de pruebas, despues de haver ejecutado `mvn package` o `mvn jacoco:report` debe dirigirse a la carpeta target.>site->jacoco y abrir `index.html`

> Nota: Por algún motivo, al correr el reporte via terminal, no se corren todas las pruebas, entoces comparando con los resultados de eclipse se tiene la siguiente imagen

![Imagen de eclipse](./eclipse%20report.png)

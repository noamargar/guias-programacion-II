<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Clases y Objetos". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: ninguno.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->

# TEMA 1. Clases y objetos

## 1. ¿Cuáles son las cuatro características básicas de la programación orientada a objetos? Describe brevemente cada una

### Son la encapsulación, abstracción, herencia y polimorfismo.
### La encapsulación consiste en agrupar datos y funciones relacionadas dentro de una misma unidad (la clase), protegiendo los datos del acceso directo indebido.
### La abstracción permite centrarse en qué hace un objeto sin necesidad de conocer cómo lo hace internamente.
### La herencia permite crear nuevas vlases a partir de otras exitentes, reutilizando código y extendiendi funcionalidades.
### El polimorfismo permite que diferentes objetos respondan de manera distinta a una misma llamada de método, dependiendo de su tipo real.


## 2. Cita cuatro lenguajes populares que permitan la programación orientada a objetos

### Java, C++, Python y C#


## 3. Los paradigmas anteriores a la POO, ¿Qué es la **programación estructurada**? y, todavía mejor, ¿Qué es la **programación modular**?

### La programación estructurada es un paradigma que organiza el código en bloques de control bien definidos, como secuencias, condiciones y bucles, evitando el uso indiscriminado de saltos. El objetivo es hacer los programas más legibles y mantenibles. 
### La programación modular consiste en dividir un progrma en módulos o funciones independientes. Cada módulo se encarga de una tarea concreta, facilitando la reutilización y el mantenimiento. 

## 4. ¿Qué tres elementos definen a un objeto en programación orientada a objetos?

### El estado, comportamiento e indentidad, 
### El estado corresponde a los datos almacenados en el objeto (atributos)
### El comportamiento se refiere a las acciones que puede realizar (métodos)
### La identidad permite distinguir un objeto de otro (aunque tenga los mismos valores)

## 5. ¿Qué es una clase? ¿Es lo mismo que un objeto? ¿Qué es una instancia? ¿Todos los lenguajes orientados a objetos manejan el concepto de clase?

### Una clase es una plantilla que define cómo serán los objetos: que datos y operaciones podrán realizar. No es un objeto en sí, sino una definición.
## Un objeto es una instancia de una clase, es decir, una creación concreta basada en ese molde.


## 6. ¿Dónde se almacenan en memoria los objetos? ¿Es igual en todos los lenguajes? ¿Qué es la **recolección de basura**? 

### En muchos lenguajes, los objetos se almacenan en heap, una zona de memoria reservada par datos dinámicos. Esto es distinto de la pila stack, donde se suelen almacenar variables locales y llamadas a funciones.
### La recolección de basura (garbage collarion) es un mecanismo automático que libera memoria ocupada por objetos que ya no se utilizan, evitando fugas de memoria y simplificando el trabajo del programador.



## 7. ¿Qué es un método? ¿Qué es la **sobrecarga de métodos**? 

### Un método es una función asoiada a una clase u objeto. Define el comportamiento del objeto y puede acceder a sis datos internos.
### La sobrecarga de método permite definir varios métodos con el mismo nombre, pero con diferentes parámetros. El compilador decide cuál usar según los argumentos proporcionados. Esto permite eacribir código más claro y reutilizar nombres para operaciones conceptualmente similares.


## 8. Ejemplo mínimo de clase en Java, que se llame Punto, con dos atributos, x e y, con un método que se llame `calculaDistanciaAOrigen`, que calcule la distancia a la posición 0,0. Por sencillez, los atributos deben tener visibilidad por defecto. Crea además un ejemplo de uso con una instancia y uso del método

### Definimos la clase Punto y el metodo `calculaDistanciaAOrigen`
### class Punto {
###    double x; // visibilidad por defecto
###    double y; // visibilidad por defecto
###    double calculaDistanciaAOrigen() { // también por defecto
###        return Math.sqrt(x * x + y * y);
###    }
### }

### Ejemplo instancia y uso del método
### public class Main {
###    public static void main(String[] args) {
###        Punto p = new Punto(); // crear objeto
###        p.x = 3; // asignar valores
###        p.y = 4;

###        double distancia = p.calculaDistanciaAOrigen(); // usar método
###        System.out.println("Distancia al origen: " + distancia);
###    }
### }

## 9. ¿Cuál es el punto de entrada en un programa en Java? ¿Qué es `static` y para qué vale? ¿Sólo se emplea para ese método `main`? ¿Para qué se combina con `final`?

### El punto de entrada de un programa en Java es el método Main
### public static void main(String[] args)

### static: indica que un método o atributi pertenece a la clase en sí, no a un objeto en concreto
### los métodos static pueden llamarse sin crear una instancia de la clase
### En el caso de Main, se usa static porque no existe ningún objeto todavía cuandoJava empieza a ejecutarse

### Final significa que el valor o método no se puede cambiar, cuando se combina con static se crea una constante de clase.
### Esto permite usar constantes en cualquier parte del programa sin poder modificarlo.
### También se puede usar final en métodos o clases para evitar que se sobrescriban en herencia, pero lo más habitual en combianción con static es definir calores constantes.

## 10. Intenta ejecutar un poco de Java de forma básica, con los comandos `javac` y `java`. ¿Cómo podemos compilar el programa y ejecutarlo desde linea de comandos? ¿Java es compilado? ¿Qué es la **máquina virtual**? ¿Qué es el *byte-code* y los ficheros `.class`?

### En java primero se compila a un formsto intermedio llamado byte-code, y luego la máquina virtual de Java lo interpreta y ejecuta. Esto permite que un mismo programa funcione en cualquier sistema operativo.

### Para compilar un programa en java tenemos que guardar el código con el mismo nombre que la clase (con mayúsculas) y extensión .java. Lo ejecutamos con javac que crea el archivo .class (en byte-code) y a continuación ejecutamos java y el nombre, finalmente imprimiendo el resultado si es el caso.

### Byte-code es un lenguaje intermedio entre el código fuente y el código máquina. Es como un “idioma universal” que cualquier máquina con JVM puede entender.
### La máquina virtual de Java (JVM) es un programa que interpreta el byte-code y lo ejecuta en tu ordenador. Permite que el mismo programa funcione en Windows, macOS o Linux sin cambios en el código.
### Cada clase creada en java se convierte en un archivo .call, contiene el byte-code listo para ser ejecutado por ls JVM

## 11. En el código anterior de la clase `Punto` ¿Qué es `new`? ¿Qué es un **constructor**? Pon un ejemplo de constructor en una clase `Empleado` que tenga DNI, nombre y apellidos

### New sirve para crear un nuevo objeto en memoria. Al usarlo, se reserva espacio para los atributos y se inicializa el objeto.

### Un cosntructor es un métoo especial que se llama automaticamente al crear un objeto. Tiene el mismo nombre que la vlase y no tiene tipo de retorno. Sirve para inicializar los atributos del objeto desde el momento que se crea.

### public class Main {
###    public static void main(String[] args) {
###        Empleado emp = new Empleado("12345678A", "Ana", "García");
###        System.out.println(emp.nombre); // muestra "Ana"
###    }
### }

### Las diferencias con un método normal son que tienen el mimos nombre que la clase, no devuelve nadam se llama autmacamente con new y su funcion es inicializar el objeto.

## 12. ¿Qué es la referencia `this`? ¿Se llama igual en todos los lenguajes? Pon un ejemplo del uso de `this` en la clase `Punto`

### This es una referencia al objeto actual sobre el que se está ejecutando un método o constructor. Permite acceder a los atributos y métodos de ese objeto específico. Se usa principalmente cuando los nombres de los parámetros coinciden con los nombres de los atributos, evitando confusión. 
### En otros lenguajes se llaman this (C++) o self (Phyton)

### class Punto {
###    double x;
###    double y;

###    // Constructor
###    Punto(double x, double y) {
###        this.x = x; // el atributo x del objeto
###        this.y = y; // el atributo y del objeto
###    }

###    double distanciaAlOrigen() {
###        return Math.sqrt(this.x * this.x + this.y * this.y);
###    }
### }



## 13. Añade ahora otro nuevo método que se llame `distanciaA`, que reciba un `Punto` como parámetro y calcule la distancia entre `this` y el punto proporcionado

### Queremos contruir un metodo que reciba otro objeto Punto como parámetro
### double distanciaA(Punto otro) {
###    double dx = this.x - otro.x;
###    double dy = this.y - otro.y;
###    return Math.sqrt(dx*dx + dy*dy);
### }

### class Punto {
###    double x, y;
###
###    // Constructor
###    Punto(double x, double y) {
###        this.x = x;
###        this.y = y;
###    }

###    // Método para distancia al origen
###    double distanciaAlOrigen() {
###        return Math.sqrt(this.x*this.x + this.y*this.y);
###    }

###    // Método para distancia a otro punto
###    double distanciaA(Punto otro) {
###        double dx = this.x - otro.x;
###        double dy = this.y - otro.y;
###        return Math.sqrt(dx*dx + dy*dy);
###    }
### }

### public class Main {
###    public static void main(String[] args) {
###        Punto p1 = new Punto(3, 4);
###        Punto p2 = new Punto(6, 8);
###
###        System.out.println("Distancia al origen p1: " + p1.distanciaAlOrigen());
###        System.out.println("Distancia entre p1 y p2: " + p1.distanciaA(p2));
###    }
### }



## 14. El paso del `Punto` como parámetro a un método, es **por copia** o **por referencia**, es decir, si se cambia el valor de algún atributo del punto pasado como parámetro, dichos cambios afectan al objeto fuera del método? ¿Qué ocurre si en vez de un `Punto`, se recibiese un entero (`int`) y dicho entero se modificase dentro de la función? 

### Los objetos se pasan por valor de su referencia. Esto significa que cuando pasas un objeto a un método se copia la referencia, no el objeto
### En el caso de recibir un int como parametro (tipo primitivo), el método recibe una copia del valor

## 15. ¿Qué es el método `toString()` en Java? ¿Existe en otros lenguajes? Pon un ejemplo de `toString()` en la clase `Punto` en Java

### toString() es un método especial de Java que devuelve una representación en texto de un objeto.  Se llama automáticamente cuando se intenta imprimir un objeto con System.out.println(objeto) o cuando se concatena con un texto.

### En otros elnguajes existe con nombres diferentes
### class Punto {
###    double x, y;
###
###    Punto(double x, double y) {
###        this.x = x;
###        this.y = y;
###    }
###
###    // Método que devuelve la distancia al origen
###    double distanciaAlOrigen() {
###        return Math.sqrt(x*x + y*y);
###    }
###
###    // Sobrescribimos toString para mostrar el punto
   ### @Override
###    public String toString() {
###        return "Punto(" + x + ", " + y + ")";
###    }
### }

### public class Main {
###    public static void main(String[] args) {
###        Punto p = new Punto(3, 4);
###
###        // Usando toString implícitamente
###        System.out.println(p); // muestra: Punto(3.0, 4.0)
###
###
###        // Usando toString explícitamente
###        System.out.println(p.toString()); // también muestra: Punto(3.0, 4.0)
###    }
### }


## 16. Reflexiona: ¿una clase es como un `struct` en C? ¿Qué le falta al `struct` para ser como una clase y las variables de ese tipo ser instancias?


### Las clases y los struct en C sirvenpara agrupar datos relacionados bajo un mismo nombre pero los struct solo contienen datos, carecen de métodos, constructores, encapsulacion, visibilidad , herencia, polimorfisomm ...
### En Java, cuando se crea un objeto con new, esa variable se convierte en una instancia de la clase: ocupa menos memoria, tiene sus propios atributos y puede usar métodos de la clase.


## 17. Quitemos un poco de magia a todo esto: ¿Como se podría “emular”, con `struct` en C, la clase `Punto`, con su función para calcular la distancia al origen? ¿Qué ha pasado con `this`?

### struc para datos
### #include <stdio.h>
### #include <math.h>
### funcion externa para calcular la distancia al origen
### <struct Punto {
###    double x;
###    double y;
### };
### funcion apra el origen
### double distanciaAlOrigen(struct Punto p) {
###    return sqrt(p.x * p.x + p.y * p.y);
### }
### Simulamos un this con un puntero
### double distanciaAlOrigenPtr(struct Punto *p) {
###    return sqrt(p->x * p->x + p->y * p->y);
### }
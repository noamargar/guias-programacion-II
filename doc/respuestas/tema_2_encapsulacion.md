<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Encapsulación". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: Clases y Objetos.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->
# TEMA 2. Encapsulación

## 1. En Programación Orientada a Objetos (POO), ¿Qué buscan la **encapsulación** y **la ocultación** de información? Enumera brevemente algunas ventajas de la ocultación de información.

## La encapsulación busca agrupar en una misma unidad (la clase) tanto los datos como el comportamiento que los manipula. Por su parte, la ocultación de información persigue restringir el acceso directo a los detalles internos de dicha unidad, permitiendo que solo se interactúe con el objeto a través de mecanismos controlados. En términos de C, es como si en un archivo .c se definieran variables globales con static para que no sean visibles desde otros archivos, obligando a usar funciones específicas para consultarlas.

## Las ventajas principales incluyen el aislamiento de errores, ya que si un dato es incorrecto, el origen del problema se limita a los métodos de la propia clase. También facilita el mantenimiento, pues permite cambiar la estructura interna de los datos sin afectar a quienes usan la clase. Finalmente, mejora la legibilidad, al reducir la complejidad que el programador externo debe gestionar para utilizar un objeto.

## 2. ¿Qué se entiende por la **interfaz pública** de un objeto o clase en POO? Describe brevemente cómo se relaciona con la ocultación de información.

## La interfaz pública es el conjunto de métodos y constantes que una clase expone al exterior para que otros objetos puedan interactuar con ella. Se puede visualizar como el "contrato" o el manual de uso del objeto: define qué puede hacer el objeto sin revelar cómo lo hace internamente. Es el equivalente a los prototipos de funciones que se colocarían en un archivo de cabecera .h en C.

## La relación con la ocultación de información es de complementariedad. Mientras la ocultación "cierra las puertas" de la implementación interna (los atributos y métodos auxiliares), la interfaz pública "abre ventanas" específicas. Una buena ocultación requiere una interfaz pública bien definida; de lo contrario, el objeto sería una caja negra inútil con la que nadie podría comunicarse.


## 3. Brevemente: ¿Por qué hay que ser conscientes y diseñar con cuidado la **interfaz pública** de una clase? ¿Es fácil cambiarla?

## El diseño de la interfaz pública debe ser cuidadoso porque representa un compromiso a largo plazo con el resto del sistema. Una vez que otros programadores (o incluso otras partes del propio código) empiezan a usar esos métodos públicos, cualquier cambio en ellos obligará a modificar todo el código que los utiliza. Es el punto de mayor acoplamiento en el software, por lo que debe ser lo más minimalista y estable posible.

## No es fácil cambiar una interfaz pública una vez que la clase está en uso. Si se modifica el nombre de un método o los parámetros que recibe, se romperá la compatibilidad del programa, obligando a realizar refactorizaciones costosas. En cambio, si la interfaz se mantiene estable, se puede reescribir todo el código interno de la clase sin que el resto del sistema lo note.


## 4. ¿Qué son las **invariantes de clase** y por qué la ocultación de información nos ayuda?

## Las invariantes de clase son condiciones o reglas que deben cumplirse siempre para que un objeto sea considerado válido. Por ejemplo, en una clase que gestione una fecha, una invariante sería que el valor del "día" debe estar entre 1 y 31. Son verdades lógicas que el objeto garantiza desde que se crea hasta que se destruye.

## La ocultación de información es fundamental para proteger estas invariantes. Si los atributos fueran públicos, cualquier código externo podría asignar un valor absurdo (como el día 45), rompiendo la lógica del objeto. Al ocultar los datos y obligar a usar métodos, la clase puede validar la información antes de aceptarla, asegurando que sus reglas internas nunca se violen.


## 5. Pon un ejemplo de una clase `Punto` en `Java`, con dos coordenadas, `x` e `y`, de tipo `double`, con un método `calcularDistanciaAOrigen`, y que haga uso de la ocultación de información. ¿Cuál es la interfaz pública de la clase `Punto`? ¿Qué significa `public` y `private`?

### public class Punto {
###    private double x;
###    private double y;
###
###    public Punto(double x, double y) {
###        this.x = x;
###        this.y = y;
###    }
###
###    public double calcularDistanciaAOrigen() {
###        return Math.sqrt(x * x + y * y);
###    }
### }
### La interfaz pública de esta clase está compuesta por el constructor Punto(double x, double y) y el método calcularDistanciaAOrigen(). Estos son los únicos elementos que alguien externo a la clase puede invocar para trabajar con un punto.

### El modificador private indica que el miembro (en este caso los atributos x e y) solo es accesible desde el código que está dentro de la propia clase. Por el contrario, public indica que el miembro es accesible desde cualquier otra clase del programa, permitiendo la comunicación entre diferentes partes del software.

## 6. En Java, ¿A quiénes se pueden aplicar los modificadores `public` o `private`?

### En Java, estos modificadores se aplican principalmente a los miembros de una clase, lo que incluye tanto a los atributos (variables) como a los métodos y constructores. Al aplicar private a un método, este se convierte en una herramienta auxiliar que solo la propia clase puede usar para sus cálculos internos, ocultándolo de la vista externa.

### También se pueden aplicar a las clases en sí mismas, aunque con matices. Una clase de nivel superior suele ser public para ser utilizada en el resto del proyecto. No se puede declarar una clase externa como private (no tendría sentido, nadie podría usarla), pero sí se pueden crear "clases internas" privadas dentro de otra clase para tareas muy específicas de implementación.


## 7. En POO, la visibilidad puede ser pública o privada, pero ¿existen más tipos de visibilidad? ¿Qué ocurre en Java? ¿Y en otros lenguajes?

### Efectivamente, existen niveles intermedios de visibilidad que permiten un control más granular. En Java, además de public y private, existen el nivel protegido (protected), que permite el acceso a subclases, y el nivel por defecto (package-private), que ocurre cuando no se pone ningún modificador y permite el acceso solo a clases que estén en el mismo paquete.

### Otros lenguajes implementan conceptos similares pero con matices. Por ejemplo, en C++ existe el concepto de friend, que permite a una clase o función externa acceder a los miembros privados de otra. En lenguajes como Python, la visibilidad privada no es estricta por compilación, sino que se basa en convenciones de nombres (como empezar una variable con guion bajo _).


## 8. Responde: Los miembros de instancia privados de un objeto están ocultos para (a) otras clases o (b) otras instancias, aunque sean de la misma clase. Pon un ejemplo añadiendo un método `calcularDistanciaAPunto(Punto otro)` y explica la respuesta.

### La respuesta correcta es la (a): otras clases. En Java, la visibilidad es a nivel de clase, no de instancia. Esto significa que un objeto de la clase Punto puede acceder a los atributos privados de otro objeto de la clase Punto.
### public double calcularDistanciaAPunto(Punto otro) {
###    // Es legal acceder a 'otro.x' aunque sea privado porque estamos dentro de la clase Punto
###    double dx = this.x - otro.x;
###    double dy = this.y - otro.y;
###    return Math.sqrt(dx * dx + dy * dy);
### }
### Este diseño facilita operaciones comunes como la copia de objetos o comparaciones de igualdad. Aunque desde la perspectiva de una clase Main u otra clase cualquiera los datos de Punto son invisibles, dentro del código de Punto todos los objetos de ese tipo se "reconocen" y pueden leer sus partes privadas entre sí.

## 9. ¿Qué son los métodos "getter" y "setter" en los lenguajes orientados a objetos?

### Los métodos "getter" (accesores) y "setter" (mutadores) son la forma estándar de proporcionar acceso controlado a los atributos privados de una clase. Un getter es un método público que devuelve el valor de un atributo privado, mientras que un setter es un método público que recibe un valor y lo asigna al atributo privado.

### La importancia de estos métodos radica en que permiten añadir lógica de control. Un "setter" no solo asigna un valor, sino que puede verificar si ese valor es legal antes de guardarlo. De esta manera, se mantiene la ocultación de datos pero se permite que el exterior consulte o modifique el estado del objeto de forma segura y supervisada.


## 10. Cuando nos referimos a que la ocultación de información mejora la "seguridad" del programa, ¿nos referimos a que no pueda ser "hackeado"?

### No, en este contexto "seguridad" no se refiere a ciberseguridad o protección contra ataques maliciosos externos. Se refiere a la robustez e integridad del código. Un programa es "seguro" cuando es difícil que un programador cometa errores accidentales que dejen al sistema en un estado inconsistente o corrupto.

### La ocultación evita que una parte del programa dependa de los detalles internos de otra de forma frágil. Al impedir el acceso directo a los datos, se garantiza que nadie pueda modificar el estado de un objeto saltándose las reglas de validación, lo cual previene una gran cantidad de errores lógicos y fallos en tiempo de ejecución.


## 11. ¿Qué diferencia hay entre **miembro de instancia** y **miembro de clase**? ¿Los miembros de clase también se pueden ocultar?

### Un miembro de instancia pertenece a cada objeto individual; si creas mil puntos, cada uno tiene su propia coordenada x. Un miembro de clase (marcado con static en Java) pertenece a la estructura de la clase en sí y es compartido por todos los objetos. Es comparable a una variable global en C, pero restringida al ámbito de la clase.

### Los miembros de clase también pueden y deben ocultarse mediante el uso de private. Por ejemplo, se puede tener un contador estático privado que lleve la cuenta de cuántos objetos se han creado. Al ser privado, ninguna clase externa puede alterar ese contador, asegurando que la estadística sea veraz y solo modificada por los constructores de la propia clase.


## 12. Brevemente: ¿Tiene sentido que los constructores sean privados?

### Sí, tiene mucho sentido en varios patrones de diseño. Si un constructor es privado, ninguna clase externa puede crear instancias de esa clase usando new. Esto se hace habitualmente cuando queremos controlar estrictamente cómo y cuántos objetos se crean, obligando a usar métodos especiales llamados "métodos factoría".

### También se utiliza en clases que solo contienen utilidades estáticas (como la clase Math de Java), donde no tiene sentido crear un objeto porque no hay datos de instancia que guardar. En otros casos, se usa para el patrón Singleton, donde se garantiza que solo exista una única instancia de la clase en toda la ejecución del programa.


## 13. ¿Cómo se indican los **miembros de clase** en Java? Pon un ejemplo, en la clase `Punto` definida anteriormente, para que incluya miembros de clase que permitan saber cuáles son los valores `x` e `y` máximos que se han establecido en todos los puntos que se hayan creado hasta el momento.

### public class Punto {
###    private double x, y;
###    private static double xMax = Double.NEGATIVE_INFINITY;
###    private static double yMax = Double.NEGATIVE_INFINITY;
###
###    public Punto(double x, double y) {
###        this.x = x;
###        this.y = y;
###        if (x > xMax) xMax = x;
###        if (y > yMax) yMax = y;
###    }
###
###    public static double getXMax() { return xMax; }
###    public static double getYMax() { return yMax; }
### }

### En este ejemplo, xMax e yMax son compartidos por todos los puntos. Cada vez que se crea un nuevo objeto, se actualizan estos valores globales de la clase si el nuevo punto supera los máximos anteriores.

## 14. Como sería un método factoría dentro de la clase `Punto` para construir un `Punto` a partir de dos coordenadas, pero que las redondee al entero más cercano. Escribe sólo el código del método, no toda la clase ¿Has usado `static`? 

### public static Punto crearPuntoRedondeado(double x, double y) {
###    double xRedondeado = Math.round(x);
###    double yRedondeado = Math.round(y);
###    return new Punto(xRedondeado, yRedondeado);
### }

### Se ha utilizado el modificador static porque el método factoría debe poder invocarse sin que exista todavía un objeto de la clase Punto. Los métodos estáticos pertenecen a la clase, lo que permite que actúen como "fabricantes" de nuevas instancias tras procesar la lógica necesaria (en este caso, el redondeo).

## 15. Cambia la implementación de `Punto`. En vez de dos `double`, emplea un array interno de dos posiciones, intentando no modificar la interfaz pública de la clase.

### public class Punto {
###    private double[] coords = new double[2];
###
###    public Punto(double x, double y) {
###        this.coords[0] = x;
###        this.coords[1] = y;
###    }
###
###    public double getX() { return coords[0]; }
###    public double getY() { return coords[1]; }
###
###    public double calcularDistanciaAOrigen() {
###        return Math.sqrt(coords[0] * coords[0] + coords[1] * coords[1]);
###    }
### }

### Gracias a que la interfaz pública original se mantiene (mismos nombres de métodos y mismos parámetros), cualquier programa que usara la versión anterior de Punto seguirá funcionando perfectamente. Esta es la esencia de la encapsulación: hemos cambiado radicalmente cómo se guardan los datos (de dos variables a un array) sin que el usuario externo lo note.

## 16. Si un atributo va a tener un método "getter" y "setter" públicos, ¿no es mejor declararlo público? ¿Cuál es la convención más habitual sobre los atributos, que sean públicos o privados? ¿Tiene esto algo que ver con las "invariantes de clase"?

### No es mejor declararlo público. Aunque a primera vista parezca lo mismo, el uso de métodos permite mantener el control futuro. Si el atributo es público, estás "atado" a que ese dato exista siempre. Si usas métodos, podrías en el futuro eliminar el atributo y calcular el valor al vuelo, o añadir una línea de log cada vez que alguien consulte el dato, sin romper el código ajeno.

### La convención más habitual y recomendada es que todos los atributos sean privados. Esto protege las invariantes de clase, ya que incluso si el "setter" actual es sencillo, actúa como un guardián que impide que el objeto entre en estados ilegales. Exponer un atributo directamente es renunciar a la posibilidad de validar los cambios de estado en el futuro.


## 17. ¿Qué significa que una clase sea **inmutable**? ¿qué es un método modificador? ¿Un método modificador es siempre un "setter"? ¿Tiene ventajas que una clase sea inmutable?

### Una clase es inmutable cuando su estado (sus datos) no puede cambiar una vez que el objeto ha sido creado. Un método modificador es aquel que altera el estado del objeto. No siempre es un "setter" tradicional (como setX); cualquier método que realice un cálculo y cambie un atributo interno (por ejemplo, trasladar(double dx)) es un modificador.

### Las clases inmutables tienen grandes ventajas: son intrínsecamente seguras en entornos de hilos (multithreading), son más fáciles de entender y razonar, y pueden ser compartidas o cacheadas sin riesgo de que alguien las cambie inesperadamente. Si se necesita un "cambio", el método no modifica el objeto actual, sino que devuelve un nuevo objeto con los datos actualizados.


## 18. ¿Es recomendable incluir métodos "setter" siempre y como convención?

### No, no es recomendable incluirlos por defecto. La inclusión de un "setter" debe ser una decisión de diseño consciente. Si un atributo no necesita cambiar tras la creación del objeto, no se debe proporcionar un "setter", favoreciendo así la inmutabilidad y reduciendo los puntos por donde el estado del objeto puede corromperse.

### Muchos programadores novatos añaden getters y setters para cada atributo automáticamente, pero esto a menudo equivale a hacer los atributos públicos de facto. La buena práctica dicta que solo se deben exponer aquellos mecanismos de modificación que sean estrictamente necesarios para la lógica de negocio de la aplicación.

## 19. ¿La clase `String` en Java es mutable o inmutable? ¿Qué ocurre al concatenar dos cadenas? ¿Qué debemos hacer si vamos a hacer una operación que implique concatenar muchas veces para construir paso a paso una cadena muy larga?

### La clase String en Java es inmutable. Cuando se concatenan dos cadenas (por ejemplo, s1 + s2), no se modifica ninguna de las cadenas originales. En su lugar, Java crea un objeto String completamente nuevo en memoria que contiene la unión de ambas.

### Si se realizan miles de concatenaciones en un bucle, el rendimiento cae drásticamente y se genera mucha basura en memoria debido a la creación constante de objetos intermedios. En esos casos, se debe utilizar la clase StringBuilder, que está diseñada específicamente para ser mutable y construir cadenas largas de forma eficiente antes de convertirlas al String final.


## 20. En POO ¿Cómo se comparan objetos de una misma clase? ¿Por su contenido o por su identidad? ¿Qué es el método equals en Java? ¿Qué hace por defecto? ¿Cómo se deben comparar dos cadenas en Java? 

### En Java, el operador == compara la identidad (si ambos punteros apuntan a la misma dirección de memoria), no el contenido. Para comparar si dos objetos son "lógicamente iguales" (por ejemplo, dos puntos con las mismas coordenadas), se debe utilizar el método .equals().

### Por defecto, el método equals heredado de la clase base Object se comporta igual que ==. Por tanto, es responsabilidad del programador sobrescribirlo en su clase para definir qué significa que dos objetos sean iguales. En el caso de las cadenas (String), siempre se deben comparar con .equals(), ya que dos cadenas con el mismo texto podrían estar en posiciones de memoria distintas.

## 21. ¿Qué son las clases "wrapper" en un lenguaje de programación orientado a objetos? ¿Cómo se hace? ¿Es un proceso automático? ¿Qué ventajas tienen? ¿Todos los lenguajes orientados a objetos tienen tipos primitivos y necesitan wrappers? 

### Las clases "wrapper" (envoltorios) son clases que permiten tratar a los tipos primitivos (como int, double o boolean) como si fueran objetos. En Java, los primitivos no heredan de la clase base Object, por lo que no pueden usarse directamente en ciertas estructuras como las listas (ArrayList). Las clases wrapper correspondientes son Integer, Double, Boolean, etc.

### Java realiza este proceso de forma automática mediante el autoboxing (convertir de primitivo a objeto) y unboxing (de objeto a primitivo). La ventaja es que permiten integrar tipos simples en el ecosistema de objetos y colecciones. No todos los lenguajes los necesitan; por ejemplo, en Smalltalk o Ruby todo es un objeto desde el principio, mientras que C++ no tiene este sistema de wrappers automáticos.


## 22. ¿En POO qué es un **tipo de dato enumerado**? ¿En Java, un tipo de dato enumerado es una clase? ¿Qué ventajas tienen en términos de encapsulación los enumerados en Java?

### Un tipo enumerado (enum) es un tipo de dato que permite definir un conjunto de valores constantes con nombre, como los días de la semana o los meses. A diferencia de C, donde un enum es básicamente una lista de enteros, en Java un enum es una clase especial con capacidades completas.

### Esto aporta grandes ventajas en términos de encapsulación: los enumerados en Java pueden tener sus propios atributos, constructores y métodos. Esto permite asociar lógica a cada constante de forma protegida, garantizando que no se puedan crear más instancias que las definidas originalmente, lo cual es un nivel de seguridad y control muy superior al de los enteros constantes.


## 23. Crea un tipo enumerado en Java que se llame `Mes`, con doce posibles instancias y que además proporcione métodos para obtener cuántos días tiene ese mes, el ordinal de ese mes en el año (1-12), empleando atributos privados y constructores del tipo enumerado. Añade además cuatro métodos para devolver si ese mes tiene algunos días de invierno, primavera, verano u otoño, indicando con un booleano el hemisferio (norte o sur, parámetro `enHemisferioNorte`). Es decir: `esDePrimavera(boolean esHemisferioNorte)`, `esDeVerano(boolean esHemisferioNorte)`, `esDeOtoño(boolean esHemisferioNorte)`, `esDeInvierno(boolean esHemisferioNorte)`

### public enum Mes {
###    ENERO(31, 1), FEBRERO(28, 2), MARZO(31, 3), ABRIL(30, 4),
###    MAYO(31, 5), JUNIO(30, 6), JULIO(31, 7), AGOSTO(31, 8),
###    SEPTIEMBRE(30, 9), OCTUBRE(31, 10), NOVIEMBRE(30, 11), DICIEMBRE(31, 12);
###
###    private final int dias;
###    private final int ordinal;

###    private Mes(int dias, int ordinal) {
###        this.dias = dias;
### this.ordinal = ordinal;
###    }
###
###    public int getDias() { return dias; }
###    public int getOrdinal() { return ordinal; }

###    public boolean esDePrimavera(boolean norte) {
###        return norte ? (this == MARZO || this == ABRIL || this == MAYO) 
###                     : (this == SEPTIEMBRE || this == OCTUBRE || this == NOVIEMBRE);
###    }
###
###    public boolean esDeVerano(boolean norte) {
###        return norte ? (this == JUNIO || this == JULIO || this == AGOSTO) 
###                     : (this == DICIEMBRE || this == ENERO || this == FEBRERO);
###    }

###    public boolean esDeOtoño(boolean norte) {
###        return norte ? (this == SEPTIEMBRE || this == OCTUBRE || this == NOVIEMBRE) 
###                     : (this == MARZO || this == ABRIL || this == MAYO);
###    }

###    public boolean esDeInvierno(boolean norte) {
###        return norte ? (this == DICIEMBRE || this == ENERO || this == FEBRERO) 
###                     : (this == JUNIO || this == JULIO || this == AGOSTO);
###    }
### }
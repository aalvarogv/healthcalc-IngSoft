# Health Calculator - Ingenieria del Software Avanzada

Este es el primer proyecto para la asignatura de 'Ingenieria del Software' para el curso 2024.

Este proyecto consiste en desarrollar una calculadora que permita estimar varios parámetros de salud de una persona, como por ejemplo su peso ideal o su tasa metabólica basal (TMB).

- [Práctica 1: Implementación y Tests](#práctica-1-implementación-y-tests)
- [Práctica 2: Casos de Uso](#práctica-2-casos-de-uso)
- [Práctica 3: BDD](#práctica-3-bdd)
- [Práctica 4: Interfaz Gráfica](#práctica-4-interfaz-gráfica)
- [Práctica 6: Patrones de diseño](#práctica-6-patrones-de-diseño)
- [Práctica 7: Refactorings](#práctica-7-refactorings)



## Práctica 1: Implementación y Tests

<details>
<summary>Tests Ideal Weight</summary>

### Test método **HealthCalc.idealWeigth()**

1. **Test de Altura Cero** `testAlturaCeroIdealWeight` 

En este test se verifica que el sistema ofrece una excepción cuando la altura indicada por el usuario es 0. Este caso sería invalido ya que no tiene lógica para nuestro ejercicio.

2. **Test de Altura Negativa** `testAlturaNegativaIdealWeight` 

En este test se comprueba que, al ofrecer el usuario una altura < 0, es decir negativa, el programa lo reconoce y devuelve la excepción correspondiente.
Este caso sería invalido ya que no se contempla una altura negativa en ningún caso.

3. **Test de Altura Incorrecta Hombre** `testAlturaIncorrectaMdealWeight`

En este test se verifica que la entrada para el valor altura es incorrecta, entendiendo esto como una altura no contemplada en nuestros parámetros.
Hemos tomado como altura incorrecta para un hombre una altura de 250 cm.

4. **Test de Altura Incorrecta Mujer** `testAlturaIncorrectaWIdealWeight`

En este test se verifica que la entrada para el valor altura es incorrecta, entendiendo esto como una altura no contemplada en nuestros parámetros.
Hemos tomado como altura incorrecta para una mujer una altura de 230 cm.

5. **Test de Género Incorrecto** `testGeneroIncorrectoIdealWeight`

En este test se asegura que el sistema rechaza una entrada para la variable 'género' distinta de 'M'(Man/Hombre) o 'W'(Woman/Mujer).
Este caso sería invalido para nuestro proyecto particular.

6. **Test de Peso Ideal Incorrecto Hombre** `testPesoIdealIncorrectoM`

En este test se comprueba que, si el sistema devuelve un peso ideal incorrecto para un hombre, esto se detecta como un error y se lanza una excepción.
Entendemos como ***peso ideal incorrecto*** aquel que devuelva un valor negativo, lo cual no se contempla en nuestro proyecto.
Entendemos como ***error*** dos casos, el primero puede deberse a un error en el algoritmo empleado para calcular el peso ideal, y el otro es debido a una entrada incorrecta de los datos, lo que puede llevar en ambos casos a un peso ideal incorrecto.

7. **Test de Peso Ideal Incorrecto Mujer** `testPesoIdealIncorrectoW`

Este test es muy similar al anterior, pero para una mujer. Su funcionamiento es el mismo, pero hay que tener en cuenta diferentes criterios, ya que dependiendo del género seleccionado, la fórmula para calcular el peso ideal varía en sus parámetros. 

8. **Test de Peso Ideal Correcto Hombre** `testPesoIdealCorrectoM` 

En este test se comprueba ahora sí, el correcto funcionamiento del método para un hombre. Deberíamos confirmar que el resultado experimental obtenido es igual al valor esperado.

9. **Test de Peso Ideal Correcto Mujer** `testPesoIdealCorrectoW` 

Este test es muy similar al anterior, pero para una mujer. Al igual que en el test de peso ideal incorrecto para una mujer, varian los parámetros usados en comparación al del hombre, pero el resultado final debería ser el mismo.
En este caso, ese resultado final debería ser que el valor obtenido fuera igual al valor esperado.
</details>

<details>
<summary>Tests Basal Metabolic Rate</summary>

### Test método **HealthCalc.basalMetabolicRate()**

1. **Test de Altura Cero** `testAlturaCeroBasalMetabolicRate` 

En este test se verifica que el sistema ofrece una excepción cuando la altura indicada por el usuario es 0. Este caso sería invalido ya que no tiene lógica para nuestro ejercicio.

2. **Test de Altura Negativa** `testAlturaNegativaBasalMetabolicRate` 

En este test se comprueba que, al ofrecer el usuario una altura < 0, es decir negativa, el programa lo reconoce y devuelve la excepción correspondiente.
Este caso sería invalido ya que no se contempla una altura negativa en ningún caso.

3. **Test de Altura Incorrecta Hombre** `testAlturaIncorrectaMBasalMetabolicRate`

En este test se verifica que la entrada para el valor ***altura*** es incorrecta, entendiendo esto como una altura no contemplada en nuestros parámetros.
Hemos tomado como altura incorrecta para un hombre una altura de 250 cm.

4. **Test de Altura Incorrecta Mujer** `testAlturaIncorrectaWBasalMetabolicRate`

En este test se verifica que la entrada para el valor ***altura*** es incorrecta, entendiendo esto como una altura no contemplada en nuestros parámetros.
Hemos tomado como altura incorrecta para una mujer una altura de 230 cm.

5. **Test de Género Incorrecto** `testGeneroIncorrectoBasalMetabolicRate`

En este test se asegura que el sistema rechaza una entrada para la variable ***género*** distinta de 'M'(Man/Hombre) o 'W'(Woman/Mujer).
Este caso sería invalido para nuestro proyecto particular.

6. **Test de Peso Incorrecto** `testPesoIncorrecto`

En este test se comprueba que la entrada para la variable ***peso*** no sea incorrecta, entendiéndose esto como una entrada igual o menor que 0.

7. **Test de Edad Incorrecta** `testEdadIncorrecta`

Este test rechaza, lanzando una excepción, la entrada de un valor negativo o de un valor mayor a 140 para el parámetro ***edad***, ya que estas situaciones son tratadas de imposible para nuestro caso de estudio.

8. **Test de Tasa Metabólica Basal Incorrecta Hombre** `testBasalMetabolicRateIncorrectoM`

En este test se comprueba que, si el sistema devuelve una tasa metabólica Basal incorrecta para un hombre, esto se detecta como un error y se lanza una excepción.
Entendemos como ***tasa metabólica basal incorrecto*** aquel que devuelva un valor negativo, lo cual no se contempla en nuestro proyecto.
Entendemos como ***error*** dos casos, el primero puede deberse a un error en el algoritmo empleado para calcular la tasa metabólica basal, y el otro es debido a una entrada incorrecta de los datos, lo que puede llevar en ambos casos a una tasa metabólica basal incorrecta.

7. **Test de Tasa Metabólica Basal Incorrecta Mujer** `testBasalMetabolicRateIncorrectoW`

Este test es muy similar al anterior, pero para una mujer. Su funcionamiento es el mismo, pero hay que tener en cuenta diferentes criterios, ya que dependiendo del género seleccionado, la fórmula para calcular la tasa metabólica basal varía en sus parámetros. 

8. **Test de Tasa Metabólica Basal Correcta Hombre** `testBasalMetabolicRateCorrectoM` 

En este test se comprueba ahora sí, el correcto funcionamiento del método para un hombre. Deberíamos confirmar que el resultado experimental obtenido es igual al valor esperado.

9. **Test de Tasa Metabólica Basal Correcta Mujer** `testBasalMetabolicRateCorrectoW` 

Este test es muy similar al anterior, pero para una mujer. Al igual que en el test de tasa metabólica basal incorrecta para una mujer, varian los parámetros usados en comparación al del hombre, pero el resultado final debería ser el mismo.
En este caso, ese resultado final debería ser que el valor obtenido fuera igual al valor esperado.
</details>

<details>
<summary>Resultados</summary>

### Tests results

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/a8ac464071446698e956a27da134068de0cae2c5/tests.png" height="325" title="tests">
</p>


Siguiendo con el enunciado del proyecto, se han implementado tests para comprobar los casos vistos anteriormente.
Estos tests se han ejecutado de forma correcta, como se puede ver en la imagen.
</details>

<details>
<summary>Git</summary>

### Uso de git y gitHub

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/a8ac464071446698e956a27da134068de0cae2c5/gitk.png" height="250" title="gitk">
</p>

Como último apartado de este proyecto de momento, es importante ver el uso de git a lo largo del tiempo.
Como se puede ver, durante el desarrollo del proyecto se han ido produciendo cambios en ficheros existentes o incluso creaciones de nuevos ficheros. Estos cambios se han ido guardando y comentando mediante ***commits*** usando la herramienta ***git***. En todo momento hemos trabajado en la rama principal de nuestro proyecto, lo que se ve reflejado en la imágen y en el historial de cambios de nuestro repositorio en github.

Estos cambios se irán actualizando a medida que el proyecto vaya creciendo.
</details>


## Práctica 2: Casos de Uso

<details>
<summary>Diagrama Inicial Casos de Uso</summary>

### Diagrama de Casos de Uso

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/b16a1360f72b168ae7ad693e6bb782f1bdfca63a/doc/CasosDeUso-diagrInicial.jpg" height="350" title="diagrama">
</p>

El primer paso en un proyecto de este estilo sería realizar un diagrama de casos de uso, elemento esencial en el desarrollo de un trabajo ya que da una idea inicial y general sobre cuales serán las funcionalidades y características del sistema a implementar, además de qué podrán y qué no podrán hacer los actores involucrados como podrían ser los usuarios.

En este caso, el **sistema** del diagrama sería la propia *calculadora*.

Actualmente solo involucramos a un **actor**, el cual sería el *usuario* que accede al sistema.

En cuanto a las **funcionalidades/casos de uso**, hemos definido las dos ya implementadas en la práctica anterior. La acción principal de la calculadora sería *realizar un cálculo*, que se complementa mediante una generalización por *realizar un cálculo del peso ideal (IW)* y *realizar un cálculo de la tasa metabólica basal (BMR)*. A su vez, la realización del caso de uso *realizar cálculo* necesita de la acción *introducir datos* para poder funcionar. De esta forma, al igual que hemos descompuesto el cálculo en los dos casos posibles actualmente, el caso de uso *introducir datos* se complementa mediante una generalización de los casos para cada cálculo, una introducción para el caso de calcular el peso ideal y otra introducción distinta para calcular la tasa metabólica basal.
</details>

<details>
<summary>Actualización Diagrama Casos de Uso</summary>

### Actualización Diagrama de Casos de Uso

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/b16a1360f72b168ae7ad693e6bb782f1bdfca63a/doc/CasosDeUso-diagrActualizado.jpg" height="350" title="diagrama2">
</p>

Para este paso, se han implementado 2 nuevos casos de uso que no estaban contemplados en la calculadora inicial. Como los dos nuevos casos de uso siguen siendo nuevos métodos para los casos de uso ya existentes, se han añadido al diagrama de la misma forma que se añadieron los métodos anteriores.

El primer **caso de uso** implementado sería *calcular el índice de masa corporal (IMB)*. Este se calcula mediante la fórmula: `IMB = weight / height^2`

El segundo **caso de uso** implementado sería *calcular el requerimiento calórico* según unos parámetros introducidos. Para ello, será necesario introducir el peso actual, la actividad física de la persona (sedentaria, normal, deportista) y el objetivo (bajar de peso, mantenerse, subir de peso). Como su nombre indica, este caso de uso se basa en los parámetros obtenidos para devolver al usuario el requerimiento calórico diario (ej. 2000 calorías, 3500 calorías...)

</details>

<details>
<summary>Especificación Caso de Uso</summary>

### Especificación - idealWeight

**Nombre:** Cálculo Ideal Weight

**Actor principal:** Usuario

**Stakeholder (Individuo: Participación):**
    - Usuario: Realizar el cálculo de su peso ideal mediante la calculadora.
    - Desarrolladores: Verificar y controlar el buen funcionamiento del sistema (calculadora)
    
**Nivel de abstracción:** Nivel de usuario

**Precondiciones:**
    - El usuario puede ejecutar el programa de la calculadora con éxito
    
**Garantía:**
    - Mínima: Se devuelve información al usuario, principalmente mostrando el error que se ha cometido.
    - Éxito: Se devuelve el peso ideal del usuario.
    
**Trigger:** De entre las opciones, se selecciona la opción Calcular Ideal Weight.

**Escenario principal:**
    1. El usuario accede al sistema (calculadora) y selecciona la opción "Calcular Ideal Weight".
    2. El sistema solicita al usuario los parámetros necesarios para esa acción (altura, género)
    3. El usuario introduce los valores requeridos. 
    4. El sistema aplica la fórmula con los parámetros introducidos. 
    5. El sistema devuelve el resultado por pantalla.
    
**Extensiones:**
    3*. El usuario introduce parámetros no válidos (erróneos). Se muestra un mensaje de error específico para ese caso concreto.
    4*. El resultado está fuera de un rango. Se muestra un mensaje de error específico para ese caso concreto. 
</details>


## Práctica 3: BDD

<details>
<summary>Definiciones BDD</summary>

### Historias de Usuario (User-Stories)

Se usan para describir las características/funciones que un usuario desea que tenga una aplicación o proyecto. Se centran en los objetivos o necesidades, proporcionando una descripción de lo que se desea lograr.

Para este proyecto, hemos especificado 2 historias de usuario, 1 para cada uno de los métodos iniciales de nuestra calculadora (idealweight y basalmetabolicrate). Para cada una de esas historias de usuario, se han implementado 2 criterios de aceptación (requisitos/condiciones que deben cumplirse para considerar una historia de usuario como completa y funcional).

### As a-I want-So that

Para desarrollar las historias de usuario, se usa la estructura **As a** - se especifica el tipo de usuario, **I want** - las necesidades que tiene, **So that** - las características para cumplir el objetivo.

### Given-When-Then

Para desarollar los criterios de aceptación, se usa la típica estructura **Given** - se especifican las precondiciones, **When** - las condiciones de las acciones que se van a ejecutar, **Then** - el resultado esperado.

### Cucumber y Gherkin

Usando el patrón given-when.then, la herramienta que más se usa es Cucumber, la cual se basa en el lenguaje Gherkin. Se utiliza en el contexto de la automatización de pruebas y el desarrollo ágil de software. Gherkin presenta el comportamiento de la aplicación/proyecto, a partir de la cual Cucumber puede generar los casos de prueba de la aplicación.
</details>

<details>
<summary>Estructura Implementada</summary>

### .feature

En la carpeta *src/test* encontramos 2 carpetas *java/healthcalc* y *resources/healthcalc*.

En la carpeta *src/test/resources/healthcalc* encontramos 2 archivos **.feature**, 1 para cada método. Estos archivos contienen especificaciones de comportamiento escritas en lenguaje Gherkin. Son una forma efectiva de comunicar los requisitos del usuario y especificar el comportamiento de la aplicación en un formato legible, lo que facilita mucho la comunicación y la colaboración entre los miembros de un equipo.

### Steps

En la carpeta *src/test/java/healthcalc* encontramos a su vez otra nueva carpeta llamada *bdd*, la cual contiene 3 archivos.

El primer archivo, **RunCucumberTest.java**, es un archivo de entrada principal usado para ejecutar pruebas escritas con Cucumber. Contiene la configuración necesaria para iniciar la ejecución de las pruebas de Cucumber utilizando JUnit y ejecutar los archivos .feature definidos en el proyecto.

Los otros 2 archivos, **IdealWeightSteps.java** y **BasalMetabolicRate.java**, contienen métodos que implementan la lógica de prueba para los pasos definidos en los archivos .feature usando Gherkin. Estos métodos son responsables de realizar acciones en la aplicación y verificar que el comportamiento sea como se describe.
</details>


## Práctica 4: Interfaz Gráfica

<details>
<summary>Boceto Inicial</summary>

### Prototipo/Mockup de la calculadora

Se ha realizado un boceto de la interfaz gráfica mediante el software de diseño Balsamiq. Este boceto es útil para saber qué es obligatorio implementar a la hora de desarrollar la interfaz definitiva.

En él, se han implementado unos checkbox para marcar el género del usuario y unos testbox para escribir los valores para los atributos edad, altura y peso. Además, hay dos botones que se usan para calcular el peso ideal y la tasa metabólica basal, valores que se muestran en los testbox de abajo.

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/a45fb8e8da823e3c11b74fb376471b27962d0c19/doc/interfaz_boceto.png" height="350" title="boceto">
</p>
</details>

<details>
<summary>Interfaz definitiva</summary>

### Interfaz gráfica definitiva

Esta es la interfaz definitiva, desarrollada en visual studio code mediante la extensión *Window Builder*. Se ha seguido el patrón de diseño **Modelo-Vista-Controlador**. Para ello, primero se ha desarrollado la *Vista*, que serían los componentes de la interfaz gráfica, y después se ha desarrollado el *Controlador* que pone en comunicación la Vista con el *Modelo*, que ya teníamos implementado desde anteriores prácticas

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/a45fb8e8da823e3c11b74fb376471b27962d0c19/doc/interfaz_definitivo.png" height="350" title="definitiva">
</p>
</details>

## Práctica 6: Patrones de diseño

<details>
<summary>Patrón Singleton</summary>

### Aplicación patrón Singleton

Para el primer apartado de esta práctica, se ha implementado para nuestro proyecto el patrón de diseño **Singleton**. Este patrón permite asegurarse de que una clase tenga una sola instancia, al tiempo que proporciona un punto de acceso global a esta instancia.

### Diagrama de clases UML

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/2f38892659e2795864c896e34a458bae6979dbe3/doc/Singleton.png" height="350" title="singleton">
</p>
</details>

<details>
<summary>Patrón Adapter</summary>

### Aplicación patrón Adapter

En el hospital Costa del Sol de Marbella se han interesado por nuestra calculadora de salud y la quieren integrar en su sistema informático. Para ello, tenemos la interfaz **HealthHospital**, con los métodos *bmr(char genero, int edad, float altura, int peso)* y *pesoIdeal(char genero, float altura)*. El objetivo es implementar un patrón para reutilizar la calculadora ya implementada sin tener que volver a implementar los métodos.

Para conseguir esto vamos a implementar el patrón Adapter, el cual proporciona una interfaz unificada que permite a las calculadoras con interfaz incompatible colaborar.

### Diagrama de clases UML

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/2f38892659e2795864c896e34a458bae6979dbe3/doc/Adapter.png" height="350" title="adapter">
</p>
</details>

<details>
<summary>Patrón Proxy</summary>

### Aplicación patrón Proxy

Es necesario realizar un registro de las veces que se utiliza la calculadora, almacenando los datos de los pacientes y permitiendo obtener la media de los valores introducidos y calculados por la calculadora. Para ello, tenemos la interfaz **HealthStats** con los métodos *alturaMedia()*, *pesoMedio()*, *edadMedia()*, *bmrMedio()*, *numSexoH()*, *numSexoM()*, *numTotalPacientes()*.

Para ello, vamos a usar el patrón proxy o representante. Este patrón se encarga de proporcionar un sustituto o representante para otro objeto. Controla el acceso al objeto original, lo que le permite realizar algo antes o después de que la solicitud llegue al objeto original.

### Diagrama de clases UML

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/2f38892659e2795864c896e34a458bae6979dbe3/doc/Proxy.png" height="450" title="proxy">
</p>
</details>

<details>
<summary>Patrón Decorator</summary>

### Aplicación patrón Decorator

El último objetivo es el de disponer de 2 versiones de la calculadora: una versión europea (altura en metros y peso en gramos) y otra americana (altura en pies y peso en libras). 

Para lograr esto, se va a implementar el patrón Decorator. Este permite añadir nuevos comportamientos a los objetos colocando estos objetos dentro de objetos envolventes especiales que contienen los comportamientos.

En nuestro caso, vamos a envolver la calculadora en 2 objetos (versión europea y versión americana) a los que se les va a dar el comportamiento deseado.

Además, para cada clase de tipo 'europea' y 'americana', se implementa un método mensaje() que imprime por pantalla el cálculo del BMR y las medidas usadas según el modelo escogido.

### Diagrama de clases UML

<p align="center">
    <img src="https://github.com/aalvarogv/healthcalc-IngSoft/blob/2f38892659e2795864c896e34a458bae6979dbe3/doc/Decorator.png" height="450" title="decorator">
</p>
</details>


## Práctica 7: Refactorings

<details>
<summary>Enumerador Gender</summary>

### Cambiar el tipo de la variable género de 'char' a 'enum'

- bad smell -
El problema que trata este refactoring podría ser principalmente Primitive Obsession.
Este problema comenta el uso excesivo de tipos primitivos en ciertas variables, en lugar de tipos específicos más adecuados.

- refactorings aplicados -
Podemos decir que se han aplicado principalmente 2 refactorings..
El primero sería Introduce Enum; introducción de un enumerado para representar valores específicos.
El segundo sería Replace Value with Object; reemplazo del valor de datos primitivos con un objeto que represente mejor el concepto.

- tipo/categoría del refactoring -
Este campo es más fácil, ya que se trata claramente de un Attribute Refactoring.
Este tipo transforma un tipo de datos de caracter primitivo a uno más específico.

- descripción -
Se ha reemplazado la variable de tipo 'char' que representaba el género del usuario con un tipo 'enum'.
Esto mejor la legibilidad del código y reduce errores potenciales al restringir los valores posibles a un conjunto definido (MALE, FEMALE).
La refactorización incluye la creación del tipo enumerado y la actualización de las partes del código que usaban la variable de tipo 'char' para utilizar el nuevo 'enum'.

- registro de cambios manuales -
    - Creación del enumerado Gender | 4 lineas
    - HealthCalc: char gender -> Gender gender | 2 lineas
    - HealthCalcImpl: gender == 'm' -> gender.equals(Gender.MALE) | 4 lineas
    - HealthCalcImpl: gender == 'f' -> gender.equals(Gender.FEMALE) | 4 lineas
    - Controlador: gender = 'm' -> gender = Gender.MALE | 1 linea
    - Controlador: gender = 'w' -> gender = Gender.FEMALE | 1 linea
    - Tests: gender = 'm' -> gender = Gender.MALE | 8 lineas
    - Tests: gender = 'w' -> gender = Gender.FEMALE | 11 lineas
    - Tests: gender = 'x' -> gender = null | 2 lineas
</details>

<details>
<summary>Interfaz Person</summary>

### Agrupar los atributos 'height', 'weight', 'age' y 'gender' en una clase Person

- bad smell -
El problema que trata este refactoring podría ser principalmente Data Clumps.
Este problema consiste en que los mismos grupos de datos que tienden a estar juntos en varias partes del código, deberían estar encapsulados en una clase separada.

- refactorings aplicados -
Podemos decir que se han aplicado principalmente 2 refactorings.
El primero sería Move Field; mover los campos 'height', 'weight', 'age' y 'gender', de las clases a la nueva clase Person.
El segundo sería Encapsulate Field; encapsular los campos mencionados en la nueva clase Person con métodos de acceso.

- tipo/categoría del refactoring -
Este refactoring es de tipo Class Refactoring.
Consiste en una reestructuración y un cambio de las funcionalidades de ciertos atributos mediante las clases.

- descripción -
Se ha creado una clase nueva Person que agrupa los atributos 'height', 'weight', 'age' y 'gender'.
La refactorización incluye la modificación de ciertas clases para utilizar la instancia de Person en lugar de manejar esos campos de manera individual.
Este cambio mejora la cláridad del código, además de su organización. Facilita la reutilización de campos y la gestión de datos relacionados con el usuario.

- registro de cambios manuales -
    - Creación de la interfaz Person | 6 lineas
    - Usuario: atributos, constructor y métodos | 47 lineas
    - HealthCalc: float height, float weight, int age, Gender gender -> Persona user | 2 lineas
    - HealthCalcImpl: eliminación lanzamiento de errores | 46 lineas
    - HealthCalcImpl: float height, float weight, int age, Gender gender -> Persona user | 8 lineas
    - Controlador : float height, float weight, int age, Gender gender -> new Usuario(height, weight, age, gender) | 2 lineas
    - HealthHospitalAdapter: float height, float weight, int age, Gender gender -> new Usuario(height, weight, age, gender) | 2 lineas
    - HealthTest: float height, float weight, int age, Gender gender -> new Usuario(height, weight, age, gender) | 20 lineas
</details>

<details>
<summary>Interfaces CardiovascularMetrics, MetabolicMetrics</summary>

### Crear las interfaces CardiovascularMetrics y MetabolicMetrics

- bad smell -
El problema que trata este refactoring podría ser principalmente Large Class (Clase Dios).
Este problema consiste en que una clase tiene demasiadas responsabilidades, manejando ambos métodos.

- refactorings aplicados -
El refactoring que se ha aplicado ha sido Extract Class.
Este crea nuevas clases para encapsular responsabilidades específicas y mueve estos metodos a sus respectivas nuevas clases.

- tipo/categoría del refactoring -
Este refactoring es de tipo Class Refactoring.
Consiste en una reestructuración y un cambio de las funcionalidades de ciertos atributos mediante las clases.

- descripción -
Se han creado dos nuevas clases, CardiovascularMetrics y MetabolicMetrics, para manejar los cálculos del peso ideal y la tasa metabólica basal, respectivamente.
Esto mejora la cohesión y reduce las responsabilidades de la clase que contenía estos dos métodos.

- registro de cambios manuales -
    - Creación de la interfaz CardiovascularMetrics | 3 líneas
    - Creación de la interfaz MetabolicMetrics | 3 líneas
    - HealthCalcImpl: implements HealthCalc -> implements CardiovascularMetrics, MetabolicMetrics() | 1 línea
    - HealthCalcImpl: float idealWeight() -> double getIdealBodyWeight(), float basalMetabolicRate() -> double basalMetabolicRate() | 2 líneas
    - HealthHospitalAdapter: float idealWeight() -> double getIdealBodyWeight(), float basalMetabolicRate() -> double basalMetabolicRate() | 2 líneas
    - Controlador: float idealWeight() -> double getIdealBodyWeight(), float basalMetabolicRate() -> double basalMetabolicRate() | 2 líneas
    - Vista: setIdealWeight(float), setBMR(float) -> setIdealWeight(double), setBMR(double) | 2 líneas
    - HealthCalc: interfaz eliminada (sin función aparente)
</details>

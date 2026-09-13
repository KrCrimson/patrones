# UNIVERSIDAD PRIVADA DE TACNA
## FACULTAD DE INGENIERÍA
### ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS

---

<div align="center">

# GUÍA PRÁCTICA DE LABORATORIO Nº 01
## "Diseño Orientado a Objetos, Modelado UML y Principios SOLID"

**CURSO:** PATRONES DE SOFTWARE  
**DOCENTE:** Mag. Alberto Johantan Flor Rodríguez  

**AUTORES / EQUIPO DE TRABAJO:**
1. **ARCE BRACAMONTE, Sebastian Rodrigo** *(Integrante 1 - Arquitectura, UML y Contratos)*
2. **HERNANDEZ CRUZ, Angel Gadiel** *(Integrante 2 - Servicios Java Puro y DIP)*
3. **LAVARELLO VIDAURRE, Victoria Isabel** *(Integrante 3 - Pruebas Unitarias JUnit 5 y Calidad)*

**TACNA – PERÚ**  
**2026**

</div>

---

## Índice General

1. [Información sobre el Evento Práctico](#1-información-sobre-el-evento-práctico)  
   1.1. [Título del Evento Práctico](#11-título-del-evento-práctico)  
   1.2. [Objetivos](#12-objetivos)  
   1.3. [Tiempo de Duración](#13-tiempo-de-duración)  
   1.4. [Resultados de Aprendizaje (RA)](#14-resultados-de-aprendizaje-ra)  
   1.5. [Recursos Utilizados](#15-recursos-utilizados)  
2. [Introducción](#2-introducción)  
3. [Procedimiento o Metodología](#3-procedimiento-o-metodología)  
   3.1. [Paso 1: Abstracción y UML – Sensores Ambientales](#paso-1-abstracción-y-uml--sensores-ambientales)  
   3.2. [Paso 2: SOLID (SRP & OCP) – Centro de Control de Tráfico](#paso-2-solid-srp--ocp--centro-de-control-de-tráfico)  
   3.3. [Paso 3: SOLID (LSP & ISP) – Actuadores y Dispositivos Urbanos](#paso-3-solid-lsp--isp--actuadores-y-dispositivos-urbanos)  
   3.4. [Paso 4: SOLID (DIP) – Unidad de Respuesta de Emergencia](#paso-4-solid-dip--unidad-de-respuesta-de-emergencia)  
4. [Reto Académico: Subsistema de Movilidad Sostenible y Electromovilidad](#4-reto-académico-subsistema-de-movilidad-sostenible-y-electromovilidad)  
   4.1. [Diseño y Modelado UML (PlantUML)](#41-diseño-y-modelado-uml-plantuml)  
   4.2. [Implementación en Java Puro con Inyección de Dependencias](#42-implementación-en-java-puro-con-inyección-de-dependencias)  
   4.3. [Validación con Pruebas Unitarias JUnit 5](#43-validación-con-pruebas-unitarias-junit-5)  
5. [Cuestionario Crítico](#5-cuestionario-crítico)  
6. [Conclusiones](#6-conclusiones)  
7. [Referencias Bibliográficas](#7-referencias-bibliográficas)  

---

## 1. Información sobre el Evento Práctico

### 1.1. Título del evento práctico
**Implementación de Arquitecturas Sostenibles para Gestión Urbana.**

### 1.2. Objetivos
- **General:**
  - Diseñar un ecosistema de software escalable para una Smart City aplicando modelado UML y principios SOLID.
- **Específicos:**
  - Modelar abstracciones precisas mediante UML que aseguren la coherencia entre el diseño y la implementación.
  - Implementar los principios SRP y OCP para refactorizar lógica condicional rígida en estructuras extensibles.
  - Aplicar la Segregación de Interfaces (ISP) para fragmentar interfaces "gordas" en contratos específicos y granulares.
  - Desacoplar componentes críticos mediante la Inversión de Dependencias (DIP), facilitando la inyectabilidad y el testeo unitario sin dependencias de frameworks.

### 1.3. Tiempo de duración
Dos (02) horas.

### 1.4. Resultados de Aprendizaje (RA)
- El estudiante aplica principios de diseño orientado a objetos para resolver problemas de alta complejidad.
- El estudiante utiliza patrones y principios SOLID para garantizar la evolución y sostenibilidad del software.

### 1.5. Recursos
- PC con entorno de desarrollo Java (JDK 17+).
- Extensión PlantUML / Herramienta de diagramación en código.
- JUnit 5 como librería de testing unitario.

---

## 2. Introducción

La gestión de una **Smart City** representa uno de los retos de ingeniería más sofisticados de la actualidad. Estos ecosistemas no son meras acumulaciones de sensores, sino infraestructuras críticas donde la mantenibilidad determina la viabilidad técnica y financiera a largo plazo. Como advierte Robert C. Martin en *Clean Code*, el código incorrecto puede "acabar con la organización"; en una ciudad digital, un diseño deficiente es una deuda técnica que asfixia la evolución urbana y pone en riesgo la operatividad de servicios vitales (energía, transporte y respuesta ante emergencias).

Esta práctica se fundamenta en la premisa de que *"la honestidad por las cosas pequeñas no es algo menor"*. Siguiendo el principio **Seiri** (organización y discriminación de lo innecesario) de las 5S japonesas, establecemos que la integridad de la arquitectura comienza con nombres de variables, interfaces y funciones que revelen de forma inmediata su intención comercial y técnica.

Al emplear el paradigma de **"Diagramas como Código" (PlantUML)**, construimos abstracciones nítidas que actúan como el plano formal de construcción de una metrópoli digital sostenible. Solo mediante esta rigurosidad evitamos que el software degenere en una "maraña de zarzas" (anti-patrón Big Ball of Mud) y logramos que la arquitectura parezca creada específicamente para resolver los problemas de los ciudadanos.

---

## 3. Procedimiento o Metodología

La transición del "Código Espagueti" —donde más del 50% del tiempo de mantenimiento se dilapida intentando descifrar el flujo del sistema— a una arquitectura profesional exige disciplina metodológica. Para ello, aplicamos de forma inflexible la máxima de **"programar para una interfaz, no para una implementación"**, evitando el síndrome del programador desesperado y garantizando el reuso y la sustitución polimórfica.

```
+---------------------------------------------------------------------------------------+
| FASE DESARROLLADA POR INTEGRANTE 1: Sebastian Rodrigo ARCE BRACAMONTE                 |
+---------------------------------------------------------------------------------------+
```

### Paso 1: Abstracción y UML – Sensores Ambientales

#### Caso:
Monitoreo ambiental de calidad del aire (PPM - Partes por Millón) y nivel acústico (Decibelios). Se eliminan deliberadamente nombres crípticos y abreviaturas ambiguas como `s1`, `d` o `tempVal`.

#### Diagrama de Clases (PlantUML):
```plantuml
@startuml
skinparam style strictuml
monochrome true

interface ISensor {
    + getMeasurement() : double
}

class AirQualitySensor implements ISensor {
    - ppmValue : double
    + AirQualitySensor(ppmValue : double)
    + getMeasurement() : double
    + getPpmValue() : double
}

class NoiseSensor implements ISensor {
    - decibels : double
    + NoiseSensor(decibels : double)
    + getMeasurement() : double
    + getDecibels() : double
}
@enduml
```

#### Código Fuente Java:
```java
// Contrato base
public interface ISensor {
    double getMeasurement();
}

// Implementación concreta 1: Calidad de Aire
public class AirQualitySensor implements ISensor {
    private final double ppmValue; // Nombre coincide con UML para evitar desinformación

    public AirQualitySensor(double ppmValue) {
        this.ppmValue = ppmValue;
    }

    @Override
    public double getMeasurement() {
        return this.ppmValue;
    }

    public double getPpmValue() {
        return this.ppmValue;
    }
}

// Implementación concreta 2: Ruido Ambiental
public class NoiseSensor implements ISensor {
    private final double decibels;

    public NoiseSensor(double decibels) {
        this.decibels = decibels;
    }

    @Override
    public double getMeasurement() {
        return this.decibels;
    }

    public double getDecibels() {
        return this.decibels;
    }
}
```

#### Análisis Técnico:
1. **Abstracción Pura:** El sistema cliente no necesita saber si está interactuando con un sensor óptico de partículas o con un sensor piezoeléctrico de presión acústica; consume el contrato polimórfico `ISensor`.
2. **Clean Code (5S Seiri):** Se aplican identificadores autodescriptivos (`ppmValue`, `decibels`, `getMeasurement()`).

---

### Paso 2: SOLID (SRP & OCP) – Centro de Control de Tráfico

#### Concepto y Detección de Deuda Técnica:
El uso obsesivo de bloques condicionales `switch/case` o encadenamientos `if-else` para evaluar tipos de vehículos o modalidades de cobro constituye una violación flagrante del **Principio Abierto/Cerrado (OCP)**:
- Cada vez que la municipalidad decreta una nueva tarifa (ej. "Peaje Festivo" o "Peaje Nocturno"), el desarrollador se ve forzado a modificar el código fuente existente de la clase de cobro, elevando exponencialmente el riesgo de efectos colaterales y regresiones.
- Adicionalmente, mezclar la coordinación del tráfico con los algoritmos matemáticos de facturación viola el **Principio de Responsabilidad Única (SRP)**.

#### Solución Arquitectónica (Patrón Strategy):
Desacoplar el cálculo mediante la abstracción `ITollStrategy`, permitiendo que `TrafficControlCenter` permanezca **cerrado a la modificación, pero abierto a la extensión**.

#### Diagrama de Clases (PlantUML):
```plantuml
@startuml
skinparam style strictuml
monochrome true

interface ITollStrategy {
    + calculateFee(vehicleType : String) : double
}

class StandardToll implements ITollStrategy {
    + calculateFee(vehicleType : String) : double
}

class DynamicToll implements ITollStrategy {
    - congestionMultiplier : double
    + DynamicToll(congestionMultiplier : double)
    + calculateFee(vehicleType : String) : double
}

class TrafficControlCenter {
    - strategy : ITollStrategy
    + TrafficControlCenter(strategy : ITollStrategy)
    + setStrategy(strategy : ITollStrategy) : void
    + processToll(vehicle : String) : double
}

TrafficControlCenter o-> "1" ITollStrategy
@enduml
```

#### Código Fuente Java:
```java
public interface ITollStrategy {
    double calculateFee(String vehicleType);
}

public class StandardToll implements ITollStrategy {
    @Override
    public double calculateFee(String vehicleType) {
        if (vehicleType == null) return 5.0;
        return switch (vehicleType.toUpperCase()) {
            case "MOTO" -> 3.0;
            case "CAMION", "BUS" -> 12.0;
            default -> 6.5;
        };
    }
}

public class DynamicToll implements ITollStrategy {
    private final double congestionMultiplier;

    public DynamicToll(double congestionMultiplier) {
        this.congestionMultiplier = congestionMultiplier > 0 ? congestionMultiplier : 1.0;
    }

    @Override
    public double calculateFee(String vehicleType) {
        double baseFee = 6.5;
        if (vehicleType != null && (vehicleType.equalsIgnoreCase("CAMION") || vehicleType.equalsIgnoreCase("BUS"))) {
            baseFee = 12.0;
        } else if (vehicleType != null && vehicleType.equalsIgnoreCase("MOTO")) {
            baseFee = 3.0;
        }
        return baseFee * this.congestionMultiplier;
    }
}

public class TrafficControlCenter {
    private ITollStrategy strategy;

    public TrafficControlCenter(ITollStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ITollStrategy strategy) {
        if (strategy == null) throw new IllegalArgumentException("Estrategia nula");
        this.strategy = strategy;
    }

    public double processToll(String vehicle) {
        return this.strategy.calculateFee(vehicle);
    }
}
```

---

```
+---------------------------------------------------------------------------------------+
| FASE ASIGNADA A INTEGRANTE 2: ANGEL GADIEL HERNANDEZ CRUZ                             |
+---------------------------------------------------------------------------------------+
```

### Paso 3: SOLID (LSP & ISP) – Actuadores y Dispositivos Urbanos

#### Concepto:
El anti-patrón **"The God Interface" (Interfaces Gordas)** agrupa indiscriminadamente capacidades de monitoreo, telemetría y accionamiento físico en un único contrato mastodóntico. Esto fuerza a clases que solo son sensores a implementar métodos de accionamiento con excepciones `UnsupportedOperationException`, violando el Principio de Segregación de Interfaces (**ISP**) y comprometiendo el Principio de Sustitución de Liskov (**LSP**).

#### Modelado y Diseño:
- `IMonitoreable`: contrato granular para dispositivos que emiten flujos de información (`captureData()`).
- `IActuable`: contrato granular para dispositivos que ejecutan comandos físicos (`executeAction(command)`).
- `SmartCamera`: implementa exclusivamente `IMonitoreable`.
- `StreetLight`: implementa exclusivamente `IActuable`.

*(Diagrama PlantUML disponible en `docs/uml/paso3_dispositivos.puml`).*

---

### Paso 4: SOLID (DIP) – Unidad de Respuesta de Emergencia

#### Concepto:
El anti-patrón de **"Acoplamiento Rígido"** ocurre cuando una clase de alto nivel (el Centro de Despacho de Emergencias de la ciudad) instancia de forma directa con el operador `new` clases de bajo nivel volátiles (Bomberos, Policía, Ambulancias). Si el protocolo de comunicación de la policía cambia, el centro de control colapsa.
El **Principio de Inversión de Dependencias (DIP)** establece que los módulos de alto nivel no deben depender de los de bajo nivel, sino que ambos deben depender de abstracciones inyectadas por constructor (*Constructor Injection*).

*(Diagrama PlantUML disponible en `docs/uml/paso4_emergencias.puml`).*

---

## 4. Reto Académico: Subsistema de Movilidad Sostenible y Electromovilidad

### 4.1. Diseño y Modelado UML (PlantUML)
*Diseñado por Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1).*

Se modeló la arquitectura completa del subsistema garantizando:
1. **Segregación de Interfaces (ISP):**
   - `RentableVehicle`: capacidades de alquiler y control de estado de disponibilidad.
   - `Rechargeable`: capacidades de almacenamiento y recarga de energía eléctrica.
   - `TelemetrySource`: emisión de ubicación GPS y velocidad instantánea.
   - `AutonomousNavigable`: capacidades específicas de navegación autónoma y frenado de emergencia.
2. **Polimorfismo en Estaciones de Carga:**
   - La clase `ChargingStation` depende de la interfaz `Rechargeable`. Puede recargar un `Scooter`, un `AutonomousBus` o cualquier vehículo eléctrico sin sufrir modificaciones en su código (cumpliendo OCP y LSP).
3. **Inversión de Dependencias (DIP):**
   - `RentalService` no conoce implementaciones concretas de persistencia ni de cobro; recibe por constructor `VehicleRepository` y `PricingStrategy`.

*(Archivos fuente: `docs/uml/reto_clases.puml` y `docs/uml/reto_secuencia.puml`).*

### 4.2. Implementación en Java Puro con Inyección de Dependencias
*A cargo de ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2).*
- Implementación del repositorio en memoria `InMemoryVehicleRepository`.
- Implementación de estrategias de precios OCP (`StandardPricingStrategy`, `EcoStudentPricingStrategy`, `AutonomousBusFleetStrategy`).
- Implementación del orquestador `RentalService` y ejecución en `Main.java`.

### 4.3. Validación con Pruebas Unitarias JUnit 5
*A cargo de VICTORIA ISABEL LAVARELLO VIDAURRE (Integrante 3).*
- Cobertura de pruebas unitarias atómicas ("hacen una sola cosa y la hacen bien") sobre `RentalServiceTest`, `PricingStrategyTest` y `ChargingStationTest`.

---

## 5. Cuestionario Crítico

### Pregunta 1 [Asignada a: ANGEL GADIEL HERNANDEZ CRUZ]
*Analice cómo el anti-patrón "Fantasmas" (clases con mínimas responsabilidades) podría utilizarse erróneamente para intentar cumplir el SRP, ocultando en realidad un diseño inestable.*
> **Respuesta:**  
> *(Ángel redactará aquí la respuesta detallando la fragmentación excesiva de clases, el costo de indirección y cómo la falta de cohesión enmascara inestabilidad).*

### Pregunta 2 [Asignada a: ANGEL GADIEL HERNANDEZ CRUZ]
*Según la Ley de LeBlanc, ¿por qué la postergación de la limpieza del código en sistemas urbanos críticos garantiza el colapso del sistema?*
> **Respuesta:**  
> *(Ángel redactará aquí la respuesta explicando "Later equals never", el crecimiento exponencial de la deuda técnica y el riesgo fatal en servicios municipales).*

### Pregunta 3 [Asignada a: ANGEL GADIEL HERNANDEZ CRUZ]
*Explique por qué el uso de argumentos de indicador (booleanos) en funciones de control semafórico viola la legibilidad y el principio de "Hacer una sola cosa".*
> **Respuesta:**  
> *(Ángel redactará aquí la respuesta abordando los "Flag Arguments", la bifurcación obligatoria del flujo dentro de la función y la necesidad de separar en funciones explícitas).*

### Pregunta 4 [Asignada a: VICTORIA ISABEL LAVARELLO VIDAURRE]
*¿Cómo el anti-patrón "Golden Hammer" podría forzar el uso de una tecnología inadecuada (ej. bases de datos relacionales para todo) en un ecosistema de Smart City?*
> **Respuesta:**  
> *(Victoria redactará aquí la respuesta contrastando RDBMS con Time Series Databases y bases NoSQL para la ingesta de telemetría masiva de sensores).*

### Pregunta 5 [Asignada a: VICTORIA ISABEL LAVARELLO VIDAURRE]
*Evalúe cómo la honestidad en los nombres (nombres pronunciables y buscables) reduce el tiempo de diagnóstico durante una caída de servicios municipales.*
> **Respuesta:**  
> *(Victoria redactará aquí la respuesta analizando el Mean Time to Repair / MTTR, la técnica 5S Seiri y la prevención de errores por malinterpretación en crisis).*

---

## 6. Conclusiones
*(Mínimo 3 conclusiones analíticas redactadas por VICTORIA ISABEL LAVARELLO VIDAURRE)*

1. **Conclusión 1 (Segregación de Interfaces y Escalabilidad):**  
   *(Espacio reservado para redacción técnica).*
2. **Conclusión 2 (Inversión de Dependencias sin Frameworks):**  
   *(Espacio reservado para redacción técnica).*
3. **Conclusión 3 (Mantenibilidad y Erradicación de Deuda Técnica):**  
   *(Espacio reservado para redacción técnica).*

---

## 7. Referencias Bibliográficas

1. Martin, R. C. (2009). *Clean Code: A Handbook of Agile Software Craftsmanship*. Pearson Education / Robert C. Martin Series.
2. Martin, R. C. (2002). *Agile Software Development: Principles, Patterns, and Practices*. Prentice Hall.
3. Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
4. Bass, L., Clements, P., & Kazman, R. (2003). *Software Architecture in Practice*. Addison-Wesley.
5. González Sánchez, J. (2006). *Anti-patrones: la mejor forma de hacer un pésimo sistema de software*. SG Buzz #11.

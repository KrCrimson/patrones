# Guía Práctica de Laboratorio Nº 01 - Patrones de Software
## "Diseño Orientado a Objetos, Modelado UML y Principios SOLID"
**Universidad Privada de Tacna - Facultad de Ingeniería (EPIS 2026)**  
**Docente:** Mag. Alberto Johantan Flor Rodríguez  

---

## 👥 Integrantes del Equipo
| Rol | Nombre y Apellidos | Responsabilidad Principal |
| :--- | :--- | :--- |
| **Integrante 1** | **Sebastian Rodrigo ARCE BRACAMONTE** | Arquitectura, Modelado PlantUML, Contratos de Dominio (ISP), Pasos 1 y 2 |
| **Integrante 2** | **ANGEL GADIEL HERNANDEZ CRUZ** | Servicios de Negocio en Java Puro, Inyección de Dependencias (DIP), Pasos 3 y 4, Cuestionario Q1-Q3 |
| **Integrante 3** | **VICTORIA ISABEL LAVARELLO VIDAURRE** | Pruebas Unitarias JUnit 5 (SRP / Métodos atómicos), Cuestionario Q4-Q5, Conclusiones y Referencias |

---

## 🏛️ Reglas Arquitectónicas y del Curso (¡OBLIGATORIO!)
1. **CERO FRAMEWORKS DE NEGOCIO:** Prohibido usar Spring Boot, Micronaut, Quarkus o librerías de Inyección de Dependencias externas (Guice, etc.).
2. **JAVA 17+ PURO:** Todo se programa usando Programación Orientada a Objetos pura de Java.
3. **INVERSIÓN DE DEPENDENCIAS MANUAL (Pure / Poor Man's DI):** La inyección de dependencias se realiza exclusivamente a través de los **constructores** de las clases de servicio (como se muestra en el Paso 4 de la guía del docente).
4. **JUNIT 5 PARA PRUEBAS:** Única dependencia externa permitida (en `pom.xml` con `<scope>test</scope>`) para validar que cada función cumpla el principio de responsabilidad única (hace una sola cosa y la hace bien).
5. **DIAGRAMAS COMO CÓDIGO (PlantUML):** Todos los diagramas UML deben ser compatibles con PlantUML (`skinparam style strictuml`, `monochrome true`).

---

## 📁 Estructura del Repositorio

```text
Patrones/
├── pom.xml                                   # Configuración de compilación y JUnit 5
├── README.md                                 # Esta guía de trabajo para el equipo
├── docs/
│   ├── informe/
│   │   └── INFORME_LAB01.md                  # Informe final del laboratorio para entrega en PDF/Word
│   └── uml/                                  # Diagramas PlantUML listos y renderizables
│       ├── paso1_sensores.puml
│       ├── paso2_trafico.puml
│       ├── paso3_dispositivos.puml
│       ├── paso4_emergencias.puml
│       ├── reto_clases.puml                  # Diagrama de Clases del Reto de Movilidad
│       └── reto_secuencia.puml               # Diagrama de Secuencia del Reto de Movilidad
└── src/
    ├── main/java/com/smartcity/
    │   ├── Main.java                         # [Integrante 2] Simulación interactiva en consola
    │   ├── lab/                              # Demostraciones de la guía del docente
    │   │   ├── sensors/                      # [Integrante 1] Paso 1: ISensor, AirQuality, Noise
    │   │   ├── traffic/                      # [Integrante 1] Paso 2: ITollStrategy, TrafficControl
    │   │   ├── devices/                      # [Integrante 2] Paso 3: IMonitoreable, IActuable, SmartCamera, StreetLight
    │   │   └── emergency/                    # [Integrante 2] Paso 4: IEmergencyService, EmergencyCenter
    │   └── mobility/                         # RETO PRÁCTICO: Movilidad Sostenible y Electromovilidad
    │       ├── contracts/                    # [Integrante 1] Interfaces segregadas (ISP) y contratos DIP
    │       │   ├── RentableVehicle.java
    │       │   ├── Rechargeable.java
    │       │   ├── TelemetrySource.java
    │       │   ├── AutonomousNavigable.java
    │       │   ├── PricingStrategy.java
    │       │   └── VehicleRepository.java
    │       ├── model/                        # [Integrante 1] Entidades base y DTOs
    │       │   ├── VehicleStatus.java
    │       │   ├── Vehicle.java
    │       │   ├── Scooter.java
    │       │   ├── AutonomousBus.java
    │       │   ├── ChargingStation.java
    │       │   └── RentalTicket.java
    │       ├── repository/                   # [Integrante 2] Implementación del repositorio en memoria
    │       │   └── InMemoryVehicleRepository.java
    │       ├── pricing/                      # [Integrante 2] Estrategias OCP de tarifas
    │       │   ├── StandardPricingStrategy.java
    │       │   ├── EcoStudentPricingStrategy.java
    │       │   └── AutonomousBusFleetStrategy.java
    │       └── service/                      # [Integrante 2] Orquestador de negocio con DIP
    │           └── RentalService.java
    └── test/java/com/smartcity/mobility/     # [Integrante 3] Pruebas unitarias con JUnit 5
        ├── RentalServiceTest.java
        ├── PricingStrategyTest.java
        └── ChargingStationTest.java
```

---

## 📌 Guía de Trabajo para ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)

Hola Ángel, ya dejé creados todos los contratos (interfaces ISP), las clases del modelo (`Scooter`, `AutonomousBus`, `ChargingStation`, etc.) y los diagramas UML. Tu parte consiste en implementar la lógica de servicios en Java puro y responder 3 preguntas del informe:

### 1. Implementación de Clases de Demostración de la Guía:
- `src/main/java/com/smartcity/lab/devices/`:
  - `IMonitoreable.java`, `IActuable.java`, `SmartCamera.java`, `StreetLight.java` (siguiendo el Paso 3 del PDF).
- `src/main/java/com/smartcity/lab/emergency/`:
  - `IEmergencyService.java`, `PoliceDepartment.java`, `FireDepartment.java`, `EmergencyCenter.java` (siguiendo el Paso 4 del PDF con inyección por constructor).

### 2. Implementación del Reto de Movilidad:
- **Repositorio en Memoria:** Crea `src/main/java/com/smartcity/mobility/repository/InMemoryVehicleRepository.java` que implemente `VehicleRepository` utilizando un `Map<String, RentableVehicle>` interno.
- **Estrategias de Precios (OCP):** En `src/main/java/com/smartcity/mobility/pricing/`, implementa:
  - `StandardPricingStrategy.java`: calcula `horas * vehicle.getBaseHourlyRate()`.
  - `EcoStudentPricingStrategy.java`: aplica un descuento (ej. 25% de descuento) si es scooter o transporte ecológico.
  - `AutonomousBusFleetStrategy.java`: aplica una tarifa subsidiada municipal para buses autónomos.
- **Servicio Principal con DIP:** Crea `src/main/java/com/smartcity/mobility/service/RentalService.java`:
  - Debe recibir por constructor: `public RentalService(VehicleRepository repository, PricingStrategy pricingStrategy)`.
  - Métodos atómicos:
    - `RentalTicket rentVehicle(String vehicleId, int hours)`: busca en repo, valida que esté `AVAILABLE`, calcula precio con la estrategia inyectada, desbloquea el vehículo, cambia estado a `RENTED`, guarda en repo y retorna el `RentalTicket`.
    - `void returnVehicle(RentalTicket ticket)`: busca el vehículo, lo bloquea, cambia estado a `AVAILABLE` y actualiza el repositorio.
- **Simulación en Consola:** Crea `src/main/java/com/smartcity/Main.java` con un método `main` donde instancies manualmente los componentes (pure DI), registres un scooter y un bus, realices un alquiler, demuestres el cálculo de precio y recargues la batería en la estación de carga.

### 3. Cuestionario en el Informe (`docs/informe/INFORME_LAB01.md`):
- Desarrollar la respuesta de la **Pregunta 1:** Anti-patrón "Fantasmas" (Poltergeists) y cómo el exceso de clases minúsculas distorsiona el SRP generando dispersión.
- Desarrollar la respuesta de la **Pregunta 2:** Ley de LeBlanc ("Luego es igual a nunca") y el peligro de la deuda técnica en sistemas urbanos críticos.
- Desarrollar la respuesta de la **Pregunta 3:** Flag arguments (parámetros booleanos) en funciones de control de semáforos y violación del principio "Hacer una sola cosa".

---

## 📌 Guía de Trabajo para VICTORIA ISABEL LAVARELLO VIDAURRE (Integrante 3)

Hola Victoria, tu misión es asegurar la calidad del software con pruebas unitarias en JUnit 5 y redactar la parte analítica de cierre en el informe:

### 1. Pruebas Unitarias JUnit 5 (`src/test/java/com/smartcity/mobility/`):
Cada prueba debe validar una sola función atómica (SRP en testing). Crea:
- `RentalServiceTest.java`:
  - `testRentVehicleSuccess_ShouldGenerateTicketAndSetRentedStatus()`
  - `testRentVehicleUnavailable_ShouldThrowIllegalStateException()`
  - `testReturnVehicle_ShouldLockAndRestoreAvailableStatus()`
  - `testDependencyInjection_WithCustomMockOrStub()` (validar que el servicio funciona con cualquier repo o estrategia que se le inyecte).
- `PricingStrategyTest.java`:
  - `testStandardPricing_ShouldCalculateExactHourlyCost()`
  - `testEcoStudentPricing_ShouldApplyDiscountAccurately()`
  - `testAutonomousBusFleetStrategy_ShouldApplySubsidizedRate()`
- `ChargingStationTest.java`:
  - `testPlugAndRechargeScooter_ShouldIncreaseBattery()`
  - `testPlugAndRechargeAutonomousBus_ShouldIncreaseBatteryPolymorphically()`
  - `testRechargeWhenNoSlotsAvailable_ShouldThrowIllegalStateException()`

### 2. Cuestionario en el Informe (`docs/informe/INFORME_LAB01.md`):
- Desarrollar la respuesta de la **Pregunta 4:** Anti-patrón "Golden Hammer" (usar la misma herramienta para todo) y por qué usar una base de datos relacional para absolutamente todo en una Smart City (telemetría de millones de sensores) es un error arquitectónico crítico frente a bases de datos de series temporales (Time Series DB).
- Desarrollar la respuesta de la **Pregunta 5:** Honestidad en los nombres (nombres intencionales, buscables, pronunciables / 5S Seiri) y cómo reduce el Mean Time to Repair (MTTR) durante una caída de servicios municipales.

### 3. Conclusiones y Referencias:
- Redactar **3 conclusiones técnicas rigurosas** (mínimo) en la sección 3 del informe, enfocadas en:
  1. Impacto de la Segregación de Interfaces (ISP) en la extensibilidad de flotas heterogéneas.
  2. Beneficios de la Inversión de Dependencias (DIP) y pure DI para el desacoplamiento y testabilidad sin dependencias de frameworks.
  3. Reducción de la deuda técnica urbana mediante el principio Abierto/Cerrado (OCP) y el patrón Strategy.
- Revisar que las Referencias Bibliográficas sigan el formato académico solicitado por la guía (Robert C. Martin, Gang of Four, etc.).

---

## 🚀 Cómo Ejecutar y Probar el Proyecto

### Opción 1: Con Maven (Línea de Comandos o IDE)
```bash
# Compilar todo el código
mvn clean compile

# Ejecutar las pruebas unitarias de JUnit 5
mvn test

# Ejecutar la simulación principal en consola
mvn exec:java -Dexec.mainClass="com.smartcity.Main"
```

### Opción 2: Desde cualquier IDE (IntelliJ IDEA, VS Code, Eclipse)
- Abrir la carpeta `Patrones` como proyecto Maven.
- Ejecutar `Main.java` con clic derecho -> Run.
- Ejecutar los tests en `src/test/java` con clic derecho -> Run Tests.

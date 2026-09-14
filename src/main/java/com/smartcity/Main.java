package com.smartcity;

import com.smartcity.lab.devices.SmartCamera;
import com.smartcity.lab.devices.StreetLight;
import com.smartcity.lab.emergency.EmergencyCenter;
import com.smartcity.lab.emergency.FireDepartment;
import com.smartcity.lab.emergency.IEmergencyService;
import com.smartcity.lab.emergency.MedicalAmbulance;
import com.smartcity.lab.emergency.PoliceDepartment;
import com.smartcity.mobility.contracts.VehicleRepository;
import com.smartcity.mobility.model.AutonomousBus;
import com.smartcity.mobility.model.ChargingStation;
import com.smartcity.mobility.model.RentalTicket;
import com.smartcity.mobility.model.Scooter;
import com.smartcity.mobility.pricing.AutonomousBusFleetStrategy;
import com.smartcity.mobility.pricing.EcoStudentPricingStrategy;
import com.smartcity.mobility.repository.InMemoryVehicleRepository;
import com.smartcity.mobility.service.RentalService;

import java.util.List;

/**
 * Punto de entrada de la simulación en consola del Laboratorio 01.
 * Todas las dependencias se ensamblan manualmente con el operador {@code new}
 * en este único lugar (Pure / Poor Man's Dependency Injection): ninguna clase
 * de negocio conoce ni instancia sus propias dependencias.
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class Main {
    public static void main(String[] args) {
        demonstrateMobilityChallenge();
        demonstrateUrbanDevices();
        demonstrateEmergencyResponse();
    }

    /**
     * Reto Académico: Movilidad Sostenible y Electromovilidad.
     * Registra un scooter y un bus autónomo, realiza un alquiler, calcula el
     * precio con estrategias distintas por tipo de vehículo, devuelve el
     * scooter y recarga su batería en una estación de carga.
     */
    private static void demonstrateMobilityChallenge() {
        System.out.println("=== Reto: Movilidad Sostenible y Electromovilidad ===");

        VehicleRepository repository = new InMemoryVehicleRepository();

        Scooter scooter = new Scooter("SCOOTER-01", 5.0, "-18.0146,-70.2534", 40.0);
        AutonomousBus bus = new AutonomousBus("BUS-AUTO-01", 20.0, "-18.0066,-70.2463", 90.0, 40);
        repository.save(scooter);
        repository.save(bus);

        RentalService scooterRentalService = new RentalService(repository, new EcoStudentPricingStrategy(25.0));
        RentalTicket scooterTicket = scooterRentalService.rentVehicle("SCOOTER-01", 3);
        System.out.println("Ticket generado (scooter, tarifa eco-estudiante): " + scooterTicket);

        RentalService busRentalService = new RentalService(repository, new AutonomousBusFleetStrategy(2.5));
        RentalTicket busTicket = busRentalService.rentVehicle("BUS-AUTO-01", 5);
        System.out.println("Ticket generado (bus autónomo, tarifa subsidiada): " + busTicket);

        scooterRentalService.returnVehicle(scooterTicket);
        System.out.println("Scooter devuelto. Estado actual: " + scooter.getStatus());

        ChargingStation station = new ChargingStation("STATION-CENTRO", 4);
        station.plugAndRecharge(scooter, 30.0);
        System.out.println("Batería del scooter tras recarga: " + scooter.getBatteryLevel() + "%");
    }

    /**
     * Paso 3: SOLID (LSP & ISP) - demuestra que SmartCamera y StreetLight
     * usan contratos segregados e independientes entre sí.
     */
    private static void demonstrateUrbanDevices() {
        System.out.println("\n=== Paso 3: Dispositivos Urbanos (ISP) ===");
        SmartCamera camera = new SmartCamera("1080p");
        System.out.println("Cámara: " + camera.captureData());

        StreetLight streetLight = new StreetLight();
        streetLight.executeAction("ON");
        System.out.println("Luminaria encendida, brillo: " + streetLight.getBrightnessLevel());
    }

    /**
     * Paso 4: SOLID (DIP) - la central de emergencias recibe sus servicios
     * ya construidos por constructor, sin instanciarlos internamente.
     */
    private static void demonstrateEmergencyResponse() {
        System.out.println("\n=== Paso 4: Unidad de Respuesta de Emergencia (DIP) ===");
        List<IEmergencyService> services = List.of(
                new PoliceDepartment(),
                new FireDepartment(),
                new MedicalAmbulance()
        );
        EmergencyCenter emergencyCenter = new EmergencyCenter(services);
        emergencyCenter.dispatchAlert("Av. Bolognesi 1234, Tacna");
    }
}

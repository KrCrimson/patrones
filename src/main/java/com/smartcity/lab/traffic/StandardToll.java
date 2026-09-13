package com.smartcity.lab.traffic;

/**
 * Estrategia de peaje estándar con tarifas fijas por tipo de vehículo.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public class StandardToll implements ITollStrategy {
    @Override
    public double calculateFee(String vehicleType) {
        if (vehicleType == null) {
            return 5.0;
        }
        return switch (vehicleType.toUpperCase()) {
            case "MOTO" -> 3.0;
            case "CAMION", "BUS" -> 12.0;
            default -> 6.5; // Auto / camioneta convencional
        };
    }
}

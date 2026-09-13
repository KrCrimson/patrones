package com.smartcity.lab.traffic;

/**
 * Estrategia de peaje dinámico en función de factores contextuales (hora punta, congestión).
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public class DynamicToll implements ITollStrategy {
    private final double congestionMultiplier;

    public DynamicToll(double congestionMultiplier) {
        this.congestionMultiplier = congestionMultiplier > 0 ? congestionMultiplier : 1.0;
    }

    public DynamicToll() {
        this(1.5); // Multiplicador por defecto (hora punta)
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

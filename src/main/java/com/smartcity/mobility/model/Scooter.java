package com.smartcity.mobility.model;

import com.smartcity.mobility.contracts.Rechargeable;

/**
 * Representa un Scooter eléctrico para micromovilidad urbana.
 * Hereda de Vehicle e implementa Rechargeable.
 * Al no implementar AutonomousNavigable, respeta el principio ISP.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public class Scooter extends Vehicle implements Rechargeable {
    private double batteryLevel; // Porcentaje de 0.0 a 100.0
    private final double maxCapacityKWh;

    public Scooter(String id, double baseHourlyRate, String initialLocation, double initialBatteryLevel) {
        super(id, baseHourlyRate, initialLocation);
        this.batteryLevel = Math.max(0.0, Math.min(100.0, initialBatteryLevel));
        this.maxCapacityKWh = 0.5; // Capacidad típica de batería de scooter (0.5 kWh)
    }

    public Scooter(String id, double baseHourlyRate, String initialLocation) {
        this(id, baseHourlyRate, initialLocation, 100.0);
    }

    @Override
    public double getBatteryLevel() {
        return this.batteryLevel;
    }

    @Override
    public void recharge(double amountPercentage) {
        if (amountPercentage < 0) {
            throw new IllegalArgumentException("El monto de recarga no puede ser negativo");
        }
        this.batteryLevel = Math.min(100.0, this.batteryLevel + amountPercentage);
    }

    @Override
    public double getMaxBatteryCapacity() {
        return this.maxCapacityKWh;
    }

    /**
     * Consume batería durante el uso del scooter.
     */
    public void consumeBattery(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("El consumo no puede ser negativo");
        }
        this.batteryLevel = Math.max(0.0, this.batteryLevel - percentage);
    }
}

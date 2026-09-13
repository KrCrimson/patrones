package com.smartcity.mobility.model;

import com.smartcity.mobility.contracts.AutonomousNavigable;
import com.smartcity.mobility.contracts.Rechargeable;

/**
 * Representa un Bus Eléctrico Autónomo de transporte masivo urbano.
 * Cumple con Rechargeable y AutonomousNavigable a través de interfaces segregadas (ISP).
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public class AutonomousBus extends Vehicle implements Rechargeable, AutonomousNavigable {
    private double batteryLevel;
    private final double maxCapacityKWh;
    private String currentRouteId;
    private boolean autopilotEngaged;
    private final int passengerCapacity;

    public AutonomousBus(String id, double baseHourlyRate, String initialLocation, double initialBatteryLevel, int passengerCapacity) {
        super(id, baseHourlyRate, initialLocation);
        this.batteryLevel = Math.max(0.0, Math.min(100.0, initialBatteryLevel));
        this.maxCapacityKWh = 120.0; // Batería industrial de 120 kWh
        this.passengerCapacity = passengerCapacity > 0 ? passengerCapacity : 30;
        this.currentRouteId = "RUTA-DEFAULT";
        this.autopilotEngaged = false;
    }

    public AutonomousBus(String id, double baseHourlyRate, String initialLocation) {
        this(id, baseHourlyRate, initialLocation, 100.0, 30);
    }

    @Override
    public double getBatteryLevel() {
        return this.batteryLevel;
    }

    @Override
    public void recharge(double amountPercentage) {
        if (amountPercentage < 0) {
            throw new IllegalArgumentException("El porcentaje de recarga no puede ser negativo");
        }
        this.batteryLevel = Math.min(100.0, this.batteryLevel + amountPercentage);
    }

    @Override
    public double getMaxBatteryCapacity() {
        return this.maxCapacityKWh;
    }

    @Override
    public void setAutonomousRoute(String routeId) {
        if (routeId == null || routeId.isBlank()) {
            throw new IllegalArgumentException("El identificador de ruta no puede estar vacío");
        }
        this.currentRouteId = routeId;
    }

    public String getCurrentRouteId() {
        return this.currentRouteId;
    }

    @Override
    public boolean isAutopilotEngaged() {
        return this.autopilotEngaged;
    }

    public void engageAutopilot() {
        this.autopilotEngaged = true;
    }

    public void disengageAutopilot() {
        this.autopilotEngaged = false;
    }

    @Override
    public void emergencyBrake() {
        this.autopilotEngaged = false;
        setSpeedKmH(0.0);
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }
}

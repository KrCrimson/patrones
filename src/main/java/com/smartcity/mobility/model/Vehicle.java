package com.smartcity.mobility.model;

import com.smartcity.mobility.contracts.RentableVehicle;
import com.smartcity.mobility.contracts.TelemetrySource;

/**
 * Clase base abstracta para vehículos de la Smart City.
 * Implementa los contratos segregados de RentableVehicle y TelemetrySource.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public abstract class Vehicle implements RentableVehicle, TelemetrySource {
    private final String id;
    private final double baseHourlyRate;
    private VehicleStatus status;
    private String gpsLocation;
    private double speedKmH;

    public Vehicle(String id, double baseHourlyRate, String initialLocation) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El identificador del vehículo no puede ser nulo ni vacío");
        }
        if (baseHourlyRate < 0) {
            throw new IllegalArgumentException("La tarifa base no puede ser negativa");
        }
        this.id = id;
        this.baseHourlyRate = baseHourlyRate;
        this.status = VehicleStatus.AVAILABLE;
        this.gpsLocation = initialLocation != null ? initialLocation : "0.0,0.0";
        this.speedKmH = 0.0;
    }

    @Override
    public String getVehicleId() {
        return this.id;
    }

    @Override
    public double getBaseHourlyRate() {
        return this.baseHourlyRate;
    }

    @Override
    public VehicleStatus getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(VehicleStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("El estado del vehículo no puede ser nulo");
        }
        this.status = status;
    }

    @Override
    public void lock() {
        // Bloqueo físico / digital del vehículo
        this.speedKmH = 0.0;
    }

    @Override
    public void unlock() {
        // Desbloqueo listo para inicio de viaje
    }

    @Override
    public String getGpsCoordinates() {
        return this.gpsLocation;
    }

    public void setGpsCoordinates(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    @Override
    public double getSpeedKmH() {
        return this.speedKmH;
    }

    public void setSpeedKmH(double speedKmH) {
        this.speedKmH = Math.max(0.0, speedKmH);
    }
}

package com.smartcity.lab.sensors;

/**
 * Sensor ambiental para medición de calidad del aire en Partes Por Millón (PPM).
 * Los nombres de atributos coinciden con el diagrama UML para evitar desinformación (Clean Code / Seiri).
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public class AirQualitySensor implements ISensor {
    private final double ppmValue;

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

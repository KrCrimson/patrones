package com.smartcity.lab.sensors;

/**
 * Sensor acústico para medición de nivel de ruido urbano en Decibelios (dB).
 * Nombres descriptivos para evitar variables crípticas como 's1' o 'd'.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
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

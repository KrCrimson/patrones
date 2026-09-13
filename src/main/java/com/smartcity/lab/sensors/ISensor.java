package com.smartcity.lab.sensors;

/**
 * Contrato base para sensores urbanos.
 * Cumple el principio de Abstracción: "Programar para una interfaz, no para una implementación".
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public interface ISensor {
    /**
     * Obtiene la medición cuantitativa actual del sensor.
     * 
     * @return valor numérico de la medición
     */
    double getMeasurement();
}

package com.smartcity.lab.traffic;

/**
 * Estrategia de cálculo de peaje urbano (Patrón Strategy).
 * Permite cumplir el principio OCP (Open/Closed Principle):
 * el sistema está abierto a la extensión (nuevos peajes) pero cerrado a la modificación
 * (no requiere añadir más switch/cases en el centro de control).
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public interface ITollStrategy {
    /**
     * Calcula la tarifa de peaje según el tipo de vehículo.
     * 
     * @param vehicleType tipo de vehículo (e.g. "Auto", "Camion", "Moto")
     * @return monto de la tarifa de peaje
     */
    double calculateFee(String vehicleType);
}

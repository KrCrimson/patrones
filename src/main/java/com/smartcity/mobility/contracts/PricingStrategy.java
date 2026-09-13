package com.smartcity.mobility.contracts;

/**
 * Contrato del Patrón Strategy para el cálculo de costos de alquiler (OCP).
 * Permite añadir nuevas estrategias de precios (ej. descuentos para estudiantes,
 * flotas nocturnas, tarifas dinámicas) sin modificar la clase RentalService.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public interface PricingStrategy {
    /**
     * Calcula el costo total del alquiler en base al vehículo y las horas solicitadas.
     * 
     * @param vehicle vehículo a alquilar
     * @param hours duración en horas del alquiler
     * @return costo monetario calculado
     */
    double calculatePrice(RentableVehicle vehicle, int hours);
}

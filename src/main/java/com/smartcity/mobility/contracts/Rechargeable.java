package com.smartcity.mobility.contracts;

/**
 * Contrato ISP específico para cualquier elemento o vehículo con batería eléctrica recargable.
 * Permite que las estaciones de carga interactúen polimórficamente con scooters, buses u otros dispositivos
 * sin conocer sus detalles de implementación.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public interface Rechargeable {
    /**
     * Obtiene el porcentaje de batería actual (0.0 a 100.0).
     */
    double getBatteryLevel();

    /**
     * Recarga la batería en un porcentaje determinado.
     * 
     * @param amountPercentage porcentaje a incrementar
     */
    void recharge(double amountPercentage);

    /**
     * Obtiene la capacidad total de la batería en kWh.
     */
    double getMaxBatteryCapacity();
}

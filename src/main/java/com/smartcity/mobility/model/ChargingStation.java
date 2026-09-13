package com.smartcity.mobility.model;

import com.smartcity.mobility.contracts.Rechargeable;

/**
 * Estación de carga de electromovilidad urbana.
 * Aplica polimorfismo con el principio ISP: se acopla exclusivamente al contrato
 * 'Rechargeable', pudiendo recargar Scooters, Buses Autónomos o cualquier futuro
 * dispositivo sin modificar esta clase (OCP y LSP).
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public class ChargingStation {
    private final String stationId;
    private final int totalSlots;
    private int occupiedSlots;

    public ChargingStation(String stationId, int totalSlots) {
        if (stationId == null || stationId.isBlank()) {
            throw new IllegalArgumentException("El ID de la estación no puede ser nulo ni vacío");
        }
        if (totalSlots <= 0) {
            throw new IllegalArgumentException("La estación debe tener al menos un slot");
        }
        this.stationId = stationId;
        this.totalSlots = totalSlots;
        this.occupiedSlots = 0;
    }

    public String getStationId() {
        return this.stationId;
    }

    public int getTotalSlots() {
        return this.totalSlots;
    }

    public int getAvailableSlots() {
        return this.totalSlots - this.occupiedSlots;
    }

    /**
     * Conecta y recarga polimórficamente cualquier dispositivo que implemente Rechargeable.
     * 
     * @param device dispositivo eléctrico a recargar
     * @param amountPercentage porcentaje a inyectar
     */
    public void plugAndRecharge(Rechargeable device, double amountPercentage) {
        if (device == null) {
            throw new IllegalArgumentException("El dispositivo a recargar no puede ser nulo");
        }
        if (getAvailableSlots() <= 0) {
            throw new IllegalStateException("No hay slots de carga disponibles en la estación: " + this.stationId);
        }

        this.occupiedSlots++;
        try {
            device.recharge(amountPercentage);
        } finally {
            this.occupiedSlots--;
        }
    }
}

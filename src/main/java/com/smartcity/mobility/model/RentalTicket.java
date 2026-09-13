package com.smartcity.mobility.model;

import java.time.Instant;

/**
 * Representa el ticket / comprobante inmutable generado al concretar un alquiler.
 * Contiene datos del vehículo, tiempo acordado y costo total.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public class RentalTicket {
    private final String ticketId;
    private final String vehicleId;
    private final int hoursRented;
    private final double totalCost;
    private final Instant timestamp;

    public RentalTicket(String ticketId, String vehicleId, int hoursRented, double totalCost) {
        if (ticketId == null || ticketId.isBlank()) {
            throw new IllegalArgumentException("El ID del ticket no puede estar vacío");
        }
        if (vehicleId == null || vehicleId.isBlank()) {
            throw new IllegalArgumentException("El ID del vehículo no puede estar vacío");
        }
        if (hoursRented <= 0) {
            throw new IllegalArgumentException("Las horas de alquiler deben ser mayores a cero");
        }
        if (totalCost < 0) {
            throw new IllegalArgumentException("El costo total no puede ser negativo");
        }
        this.ticketId = ticketId;
        this.vehicleId = vehicleId;
        this.hoursRented = hoursRented;
        this.totalCost = totalCost;
        this.timestamp = Instant.now();
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public int getHoursRented() {
        return this.hoursRented;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return String.format("RentalTicket[id='%s', vehicle='%s', hours=%d, total=S/ %.2f, at=%s]",
                ticketId, vehicleId, hoursRented, totalCost, timestamp);
    }
}

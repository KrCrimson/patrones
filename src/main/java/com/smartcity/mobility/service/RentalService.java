package com.smartcity.mobility.service;

import com.smartcity.mobility.contracts.PricingStrategy;
import com.smartcity.mobility.contracts.RentableVehicle;
import com.smartcity.mobility.contracts.VehicleRepository;
import com.smartcity.mobility.model.RentalTicket;
import com.smartcity.mobility.model.VehicleStatus;

import java.util.UUID;

/**
 * Orquestador de negocio del alquiler de vehículos de movilidad sostenible.
 * No conoce implementaciones concretas de persistencia ni de tarifas: recibe
 * ambas abstracciones por constructor (Constructor Injection), cumpliendo el
 * Principio de Inversión de Dependencias (DIP). Sigue exactamente el flujo
 * descrito en {@code docs/uml/reto_secuencia.puml}.
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class RentalService {
    private final VehicleRepository repository;
    private PricingStrategy pricingStrategy;

    public RentalService(VehicleRepository repository, PricingStrategy pricingStrategy) {
        if (repository == null) {
            throw new IllegalArgumentException("El repositorio no puede ser nulo");
        }
        if (pricingStrategy == null) {
            throw new IllegalArgumentException("La estrategia de precios no puede ser nula");
        }
        this.repository = repository;
        this.pricingStrategy = pricingStrategy;
    }

    /**
     * Permite reemplazar la estrategia de precios en tiempo de ejecución
     * (OCP: nuevas tarifas se inyectan sin modificar esta clase).
     */
    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        if (pricingStrategy == null) {
            throw new IllegalArgumentException("La estrategia de precios no puede ser nula");
        }
        this.pricingStrategy = pricingStrategy;
    }

    /**
     * Alquila un vehículo disponible: valida su estado, calcula el costo con
     * la estrategia inyectada, lo desbloquea, cambia su estado a RENTED,
     * persiste el cambio y retorna el ticket generado.
     *
     * @param vehicleId identificador del vehículo a alquilar
     * @param hours     horas contratadas de alquiler
     * @return ticket con el costo total y los datos del alquiler
     * @throws IllegalStateException si el vehículo no existe o no está disponible
     */
    public RentalTicket rentVehicle(String vehicleId, int hours) {
        RentableVehicle vehicle = this.repository.findById(vehicleId)
                .orElseThrow(() -> new IllegalStateException("Vehículo no disponible: " + vehicleId));

        if (vehicle.getStatus() != VehicleStatus.AVAILABLE) {
            throw new IllegalStateException("Vehículo no disponible: " + vehicleId);
        }

        double totalCost = this.pricingStrategy.calculatePrice(vehicle, hours);

        vehicle.unlock();
        vehicle.setStatus(VehicleStatus.RENTED);
        this.repository.save(vehicle);

        String ticketId = "TCK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return new RentalTicket(ticketId, vehicleId, hours, totalCost);
    }

    /**
     * Registra la devolución de un vehículo: lo bloquea, restaura su estado a
     * AVAILABLE y persiste el cambio.
     *
     * @param ticket ticket emitido durante el alquiler original
     * @throws IllegalStateException si el vehículo del ticket ya no existe en el repositorio
     */
    public void returnVehicle(RentalTicket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("El ticket no puede ser nulo");
        }

        RentableVehicle vehicle = this.repository.findById(ticket.getVehicleId())
                .orElseThrow(() -> new IllegalStateException("Vehículo no encontrado: " + ticket.getVehicleId()));

        vehicle.lock();
        vehicle.setStatus(VehicleStatus.AVAILABLE);
        this.repository.save(vehicle);
    }
}

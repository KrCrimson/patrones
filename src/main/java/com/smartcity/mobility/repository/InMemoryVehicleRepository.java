package com.smartcity.mobility.repository;

import com.smartcity.mobility.contracts.RentableVehicle;
import com.smartcity.mobility.contracts.VehicleRepository;
import com.smartcity.mobility.model.VehicleStatus;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación en memoria de {@link VehicleRepository} basada en un
 * {@link Map} interno. Sirve como implementación de bajo nivel intercambiable:
 * {@code RentalService} depende únicamente de la abstracción, nunca de esta
 * clase concreta (DIP), lo que permite reemplazarla por una persistencia real
 * (SQL, NoSQL, Time Series DB) sin modificar la lógica de negocio.
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class InMemoryVehicleRepository implements VehicleRepository {
    private final Map<String, RentableVehicle> vehiclesById;

    public InMemoryVehicleRepository() {
        this.vehiclesById = new LinkedHashMap<>();
    }

    @Override
    public Optional<RentableVehicle> findById(String id) {
        return Optional.ofNullable(this.vehiclesById.get(id));
    }

    @Override
    public void save(RentableVehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehículo a guardar no puede ser nulo");
        }
        this.vehiclesById.put(vehicle.getVehicleId(), vehicle);
    }

    @Override
    public List<RentableVehicle> findAllAvailable() {
        return this.vehiclesById.values().stream()
                .filter(vehicle -> vehicle.getStatus() == VehicleStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentableVehicle> findAll() {
        return List.copyOf(this.vehiclesById.values());
    }
}

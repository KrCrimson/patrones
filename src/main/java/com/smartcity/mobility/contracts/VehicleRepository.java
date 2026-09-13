package com.smartcity.mobility.contracts;

import java.util.List;
import java.util.Optional;

/**
 * Abstracción de acceso a datos / almacenamiento para vehículos (DIP).
 * Permite que los servicios de alto nivel no dependan de bases de datos concretas
 * ni de colecciones en memoria específicas, facilitando el testeo con mocks.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public interface VehicleRepository {
    /**
     * Busca un vehículo por su identificador único.
     */
    Optional<RentableVehicle> findById(String id);

    /**
     * Guarda o actualiza un vehículo en el repositorio.
     */
    void save(RentableVehicle vehicle);

    /**
     * Retorna todos los vehículos que se encuentran disponibles para alquiler.
     */
    List<RentableVehicle> findAllAvailable();

    /**
     * Retorna la totalidad de vehículos registrados.
     */
    List<RentableVehicle> findAll();
}

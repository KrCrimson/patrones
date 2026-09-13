package com.smartcity.mobility.contracts;

import com.smartcity.mobility.model.VehicleStatus;

/**
 * Contrato ISP específico para vehículos que pueden ser alquilados.
 * Evita obligar a clases que no se alquilan a implementar estos métodos.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public interface RentableVehicle {
    String getVehicleId();
    double getBaseHourlyRate();
    VehicleStatus getStatus();
    void setStatus(VehicleStatus status);
    void lock();
    void unlock();
}

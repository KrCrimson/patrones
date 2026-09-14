package com.smartcity.mobility.pricing;

import com.smartcity.mobility.contracts.PricingStrategy;
import com.smartcity.mobility.contracts.RentableVehicle;

/**
 * Estrategia de tarifa estándar: cobra estrictamente la tarifa base del
 * vehículo multiplicada por las horas alquiladas. Es la implementación de
 * referencia del patrón Strategy (OCP): nuevas tarifas se añaden como nuevas
 * clases, sin modificar {@code RentalService} ni esta clase.
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(RentableVehicle vehicle, int hours) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        if (hours <= 0) {
            throw new IllegalArgumentException("Las horas deben ser mayores a cero");
        }
        return hours * vehicle.getBaseHourlyRate();
    }
}

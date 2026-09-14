package com.smartcity.mobility.pricing;

import com.smartcity.mobility.contracts.PricingStrategy;
import com.smartcity.mobility.contracts.Rechargeable;
import com.smartcity.mobility.contracts.RentableVehicle;

/**
 * Estrategia de tarifa ecológica-estudiantil: aplica un descuento porcentual
 * sobre la tarifa estándar cuando el vehículo es un transporte eléctrico
 * ligero (identificado polimórficamente por implementar {@link Rechargeable}
 * sin ser un bus autónomo). Extiende el sistema de precios sin tocar
 * {@code RentalService} (OCP / patrón Strategy).
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class EcoStudentPricingStrategy implements PricingStrategy {
    private final double discountPercentage;

    public EcoStudentPricingStrategy(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
        }
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(RentableVehicle vehicle, int hours) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        if (hours <= 0) {
            throw new IllegalArgumentException("Las horas deben ser mayores a cero");
        }
        double standardCost = hours * vehicle.getBaseHourlyRate();
        if (isEligibleForEcoDiscount(vehicle)) {
            return standardCost * (1 - (this.discountPercentage / 100.0));
        }
        return standardCost;
    }

    /**
     * Determina si el vehículo es micromovilidad ecológica elegible para el
     * descuento (recargable eléctricamente, pero no un bus de flota masiva).
     */
    private boolean isEligibleForEcoDiscount(RentableVehicle vehicle) {
        return vehicle instanceof Rechargeable && !isAutonomousBusFleet(vehicle);
    }

    private boolean isAutonomousBusFleet(RentableVehicle vehicle) {
        return vehicle instanceof com.smartcity.mobility.contracts.AutonomousNavigable;
    }
}

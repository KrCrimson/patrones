package com.smartcity.mobility.pricing;

import com.smartcity.mobility.contracts.AutonomousNavigable;
import com.smartcity.mobility.contracts.PricingStrategy;
import com.smartcity.mobility.contracts.RentableVehicle;

/**
 * Estrategia de tarifa subsidiada municipal para la flota de buses
 * autónomos. Se identifica polimórficamente al vehículo mediante el contrato
 * {@link AutonomousNavigable} (ISP), sin necesidad de conocer la clase
 * concreta {@code AutonomousBus}.
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class AutonomousBusFleetStrategy implements PricingStrategy {
    private final double operationalSubsidizedRate;

    public AutonomousBusFleetStrategy(double subsidizedRate) {
        if (subsidizedRate < 0) {
            throw new IllegalArgumentException("La tarifa subsidiada no puede ser negativa");
        }
        this.operationalSubsidizedRate = subsidizedRate;
    }

    @Override
    public double calculatePrice(RentableVehicle vehicle, int hours) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        if (hours <= 0) {
            throw new IllegalArgumentException("Las horas deben ser mayores a cero");
        }
        if (!(vehicle instanceof AutonomousNavigable)) {
            throw new IllegalArgumentException(
                    "AutonomousBusFleetStrategy solo aplica a vehículos autónomos de flota municipal");
        }
        return hours * this.operationalSubsidizedRate;
    }
}

package com.smartcity.lab.traffic;

/**
 * Centro de Control de Tráfico.
 * Cumple el principio SRP (Responsabilidad Única) al desacoplarse del algoritmo concreto de cálculo,
 * y OCP al permitir cambiar o añadir estrategias de peaje sin modificar el código interno.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public class TrafficControlCenter {
    private ITollStrategy strategy;

    public TrafficControlCenter(ITollStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ITollStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("La estrategia de peaje no puede ser nula");
        }
        this.strategy = strategy;
    }

    public ITollStrategy getStrategy() {
        return this.strategy;
    }

    /**
     * Procesa el cobro de peaje delegando el cálculo a la estrategia configurada.
     * 
     * @param vehicle tipo de vehículo
     * @return monto calculado
     */
    public double processToll(String vehicle) {
        if (this.strategy == null) {
            throw new IllegalStateException("No se ha configurado una estrategia de peaje válida");
        }
        return this.strategy.calculateFee(vehicle);
    }
}

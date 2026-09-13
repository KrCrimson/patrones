package com.smartcity.mobility.contracts;

/**
 * Contrato ISP específico para vehículos autónomos (buses o shuttles).
 * Un scooter convencional NO implementa esta interfaz, garantizando Segregación de Interfaces (ISP).
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public interface AutonomousNavigable {
    /**
     * Asigna una ruta digital autónoma.
     * 
     * @param routeId identificador de la ruta preprogramada
     */
    void setAutonomousRoute(String routeId);

    /**
     * Indica si el piloto automático está activo.
     */
    boolean isAutopilotEngaged();

    /**
     * Acciona el frenado de emergencia autónomo.
     */
    void emergencyBrake();
}

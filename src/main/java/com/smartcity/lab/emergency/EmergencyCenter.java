package com.smartcity.lab.emergency;

import java.util.List;

/**
 * Central de Despacho de Emergencias de la ciudad.
 * Módulo de alto nivel que NO instancia con {@code new} a Policía, Bomberos
 * o Ambulancias: recibe la lista completa de servicios por constructor
 * (Constructor Injection), cumpliendo el Principio de Inversión de
 * Dependencias (DIP) y evitando el anti-patrón de "Acoplamiento Rígido".
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class EmergencyCenter {
    private final List<IEmergencyService> services;

    public EmergencyCenter(List<IEmergencyService> services) {
        if (services == null || services.isEmpty()) {
            throw new IllegalArgumentException("La central debe recibir al menos un servicio de emergencia");
        }
        this.services = services;
    }

    /**
     * Despacha una alerta a todos los servicios de emergencia inyectados.
     *
     * @param location ubicación de la emergencia
     */
    public void dispatchAlert(String location) {
        this.services.forEach(service -> service.respond(location));
    }
}

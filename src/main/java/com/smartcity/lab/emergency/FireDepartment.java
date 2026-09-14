package com.smartcity.lab.emergency;

/**
 * Servicio de despacho de bomberos.
 * Implementación de bajo nivel de {@link IEmergencyService}, intercambiable
 * sin modificar {@link EmergencyCenter} (DIP).
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class FireDepartment implements IEmergencyService {
    @Override
    public void respond(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("La ubicación no puede ser nula ni vacía");
        }
        System.out.println("[Bomberos] Unidad despachada hacia: " + location);
    }
}

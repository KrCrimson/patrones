package com.smartcity.lab.emergency;

/**
 * Servicio de despacho policial.
 * Implementación de bajo nivel de {@link IEmergencyService}: puede cambiar su
 * protocolo interno de comunicación sin afectar a {@link EmergencyCenter}
 * gracias al DIP.
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class PoliceDepartment implements IEmergencyService {
    @Override
    public void respond(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("La ubicación no puede ser nula ni vacía");
        }
        System.out.println("[Policia] Unidad despachada hacia: " + location);
    }
}

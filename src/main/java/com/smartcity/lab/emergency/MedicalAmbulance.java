package com.smartcity.lab.emergency;

/**
 * Servicio de despacho de ambulancias médicas.
 * Implementación de bajo nivel de {@link IEmergencyService}, incluida para
 * mantener el código fiel al diagrama {@code docs/uml/paso4_emergencias.puml}
 * (DIP: intercambiable sin modificar {@link EmergencyCenter}).
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class MedicalAmbulance implements IEmergencyService {
    @Override
    public void respond(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("La ubicación no puede ser nula ni vacía");
        }
        System.out.println("[Ambulancia] Unidad médica despachada hacia: " + location);
    }
}

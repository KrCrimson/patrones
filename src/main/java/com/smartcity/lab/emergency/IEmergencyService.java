package com.smartcity.lab.emergency;

/**
 * Contrato de abstracción para servicios de emergencia municipal.
 * Cumple el Principio de Inversión de Dependencias (DIP): {@link EmergencyCenter}
 * (módulo de alto nivel) depende de esta abstracción, no de implementaciones
 * concretas y volátiles como Policía, Bomberos o Ambulancias.
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public interface IEmergencyService {
    /**
     * Despacha el servicio de emergencia hacia una ubicación determinada.
     *
     * @param location ubicación donde se requiere la respuesta
     */
    void respond(String location);
}

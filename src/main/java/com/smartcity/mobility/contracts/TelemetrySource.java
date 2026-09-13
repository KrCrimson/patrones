package com.smartcity.mobility.contracts;

/**
 * Contrato ISP para emisión de telemetría y geolocalización en tiempo real.
 * 
 * @author Sebastian Rodrigo ARCE BRACAMONTE (Integrante 1)
 */
public interface TelemetrySource {
    /**
     * Coordenadas GPS del dispositivo/vehículo.
     */
    String getGpsCoordinates();

    /**
     * Velocidad instantánea en km/h.
     */
    double getSpeedKmH();
}

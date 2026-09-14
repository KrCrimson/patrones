package com.smartcity.lab.devices;

/**
 * Cámara de vigilancia urbana.
 * Implementa exclusivamente {@link IMonitoreable}: solo captura video, no
 * implementa {@link IActuable} ni se le fuerza a exponer métodos de
 * accionamiento físico (cumple ISP y evita el anti-patrón "The God Interface").
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class SmartCamera implements IMonitoreable {
    private final String resolution;

    public SmartCamera(String resolution) {
        if (resolution == null || resolution.isBlank()) {
            throw new IllegalArgumentException("La resolución de la cámara no puede ser nula ni vacía");
        }
        this.resolution = resolution;
    }

    public String getResolution() {
        return this.resolution;
    }

    /**
     * Simula la captura de un flujo de video en la resolución configurada.
     *
     * @return descripción del flujo capturado
     */
    @Override
    public String captureData() {
        return "Video Stream [" + this.resolution + "]";
    }
}

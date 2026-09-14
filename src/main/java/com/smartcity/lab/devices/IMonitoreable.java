package com.smartcity.lab.devices;

/**
 * Contrato granular (ISP) para dispositivos urbanos que únicamente emiten
 * flujos de información/telemetría hacia el sistema central.
 * Un dispositivo que implemente esta interfaz NO debe verse forzado a
 * implementar también capacidades de accionamiento físico (ver {@link IActuable}).
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public interface IMonitoreable {
    /**
     * Captura y retorna la información recolectada por el dispositivo
     * (ej. flujo de video, lectura de sensor, etc.).
     *
     * @return dato capturado en formato textual
     */
    String captureData();
}

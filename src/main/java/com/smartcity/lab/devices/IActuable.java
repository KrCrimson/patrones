package com.smartcity.lab.devices;

/**
 * Contrato granular (ISP) para dispositivos urbanos que ejecutan
 * comandos físicos sobre el entorno (encender, apagar, mover, etc.).
 * Un dispositivo que implemente esta interfaz NO debe verse forzado a
 * implementar también capacidades de monitoreo (ver {@link IMonitoreable}).
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public interface IActuable {
    /**
     * Ejecuta un comando de actuación física sobre el dispositivo.
     *
     * @param command instrucción a ejecutar (ej. "ON", "OFF")
     */
    void executeAction(String command);
}

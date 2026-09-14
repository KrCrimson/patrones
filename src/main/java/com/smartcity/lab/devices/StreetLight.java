package com.smartcity.lab.devices;

/**
 * Luminaria urbana inteligente.
 * Implementa exclusivamente {@link IActuable}: solo ejecuta comandos físicos
 * (encender/apagar/regular intensidad), no implementa {@link IMonitoreable}
 * (cumple ISP: no se le obliga a capturar datos que no produce).
 *
 * @author ANGEL GADIEL HERNANDEZ CRUZ (Integrante 2)
 */
public class StreetLight implements IActuable {
    private int brightnessLevel;

    public StreetLight() {
        this.brightnessLevel = 0;
    }

    /**
     * Ejecuta un comando de encendido/apagado/regulación sobre la luminaria.
     * Comandos soportados: "ON" (brillo máximo), "OFF" (apagada),
     * "DIM:&lt;valor&gt;" (brillo específico entre 0 y 100).
     *
     * @param command instrucción a ejecutar
     */
    @Override
    public void executeAction(String command) {
        if (command == null || command.isBlank()) {
            throw new IllegalArgumentException("El comando no puede ser nulo ni vacío");
        }
        String normalized = command.trim().toUpperCase();
        if (normalized.equals("ON")) {
            this.brightnessLevel = 100;
        } else if (normalized.equals("OFF")) {
            this.brightnessLevel = 0;
        } else if (normalized.startsWith("DIM:")) {
            int requestedLevel = Integer.parseInt(normalized.substring("DIM:".length()).trim());
            this.brightnessLevel = Math.max(0, Math.min(100, requestedLevel));
        } else {
            throw new IllegalArgumentException("Comando no reconocido: " + command);
        }
    }

    public int getBrightnessLevel() {
        return this.brightnessLevel;
    }
}

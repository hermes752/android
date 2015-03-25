package com.example.cursomovil.terremoto.model;

/**
 * Created by cursomovil on 25/03/15.
 */
public class coordenada {

    private double longitud;
    private double latitud;
    private double depth;

    public coordenada(double longitud, double latitud, double depth) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.depth = depth;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
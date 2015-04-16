package com.example.cursomovil.terremoto.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by cursomovil on 25/03/15.
 */
public class EarthQuake {

    private String _id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = new Date(time);
    }

    public coordenada getCoords() {
        return coords;
    }

    public void setCoords(coordenada coords) {
        this.coords = coords;
    }

    public Double getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(Double magnitud) {
        this.magnitud = magnitud;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public EarthQuake() {
        this.coords = new coordenada(0.0, 0.0, 0.0);
    }



    public String getMagnitudeFormatted() {
        DecimalFormat format = new DecimalFormat("#0.00");
        return format.format(this.magnitud);
    }
    @Override
    public String toString() {
        return this.getPlace();
    }

    private String place;
    private Date time;
    private coordenada coords;



    private Double magnitud;
    private String url;

}

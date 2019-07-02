package e.miranda.aero;

import java.util.Date;

public class Vuelo {
int id_vuelo;
int origen;
int destino;
int avion;
Date fecha;
float economica;
float ejecutiva;
float primera;
String modelo;

    public Vuelo() {
    }

    public Vuelo(int id_vuelo, int origen, int destino, int avion, Date fecha, float economica, float ejecutiva, float primera, String modelo) {
        this.id_vuelo = id_vuelo;
        this.origen = origen;
        this.destino = destino;
        this.avion = avion;
        this.fecha = fecha;
        this.economica = economica;
        this.ejecutiva = ejecutiva;
        this.primera = primera;
        this.modelo = modelo;
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getAvion() {
        return avion;
    }

    public void setAvion(int avion) {
        this.avion = avion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getEconomica() {
        return economica;
    }

    public void setEconomica(float economica) {
        this.economica = economica;
    }

    public float getEjecutiva() {
        return ejecutiva;
    }

    public void setEjecutiva(float ejecutiva) {
        this.ejecutiva = ejecutiva;
    }

    public float getPrimera() {
        return primera;
    }

    public void setPrimera(float primera) {
        this.primera = primera;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id_vuelo=" + id_vuelo +
                ", origen=" + origen +
                ", destino=" + destino +
                ", avion=" + avion +
                ", fecha=" + fecha +
                ", economica=" + economica +
                ", ejecutiva=" + ejecutiva +
                ", primera=" + primera +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}

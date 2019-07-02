package e.miranda.aero;

import java.util.Date;

public class Vuelo {
    int id_vuelo;
    int origen;
    int destino;
    int avion;
    String fecha;
    Double economica;
    Double ejecutiva;
    Double primera;
    String modelo;

    public Vuelo() {
    }

    public Vuelo(int id_vuelo, int origen, int destino, int avion, String fecha, Double economica, Double ejecutiva, Double primera, String modelo) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getEconomica() {
        return economica;
    }

    public void setEconomica(Double economica) {
        this.economica = economica;
    }

    public Double getEjecutiva() {
        return ejecutiva;
    }

    public void setEjecutiva(Double ejecutiva) {
        this.ejecutiva = ejecutiva;
    }

    public Double getPrimera() {
        return primera;
    }

    public void setPrimera(Double primera) {
        this.primera = primera;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
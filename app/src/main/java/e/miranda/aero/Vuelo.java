package e.miranda.aero;

import java.util.Date;

public class Vuelo {

    int idVuelo,idAvion ;
    Date fecha;
    String origen, destino, modelo, solofecha,solohora;


    public Vuelo(int idVuelo, int idAvion, Date fecha, String origen, String destino, String modelo) {
        this.idVuelo = idVuelo;
        this.idAvion = idAvion;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.modelo = modelo;

    }

    public Vuelo(){

    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getSolofecha() {
        return solofecha;
    }

    public void setSolofecha(String solofecha) {
        this.solofecha = solofecha;
    }

    public String getSolohora() {
        return solohora;
    }

    public void setSolohora(String solohora) {
        this.solohora = solohora;
    }
}
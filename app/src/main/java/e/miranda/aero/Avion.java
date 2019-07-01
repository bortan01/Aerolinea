package e.miranda.aero;

public class Avion {
    int id_avion;
    int economico;
    int ejecutiva;
    int primera ;
    String modelo;

    public Avion(int id_avion, int economico, int ejecutiva, int primera, String modelo) {
        this.id_avion = id_avion;
        this.economico = economico;
        this.ejecutiva = ejecutiva;
        this.primera = primera;
        this.modelo = modelo;
    }

    public Avion() {

    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public int getEconomico() {
        return economico;
    }

    public void setEconomico(int economico) {
        this.economico = economico;
    }

    public int getEjecutiva() {
        return ejecutiva;
    }

    public void setEjecutiva(int ejecutiva) {
        this.ejecutiva = ejecutiva;
    }

    public int getPrimera() {
        return primera;
    }

    public void setPrimera(int primera) {
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
        return "Codigo " + id_avion + " ("+modelo+")";
    }
}

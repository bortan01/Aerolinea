package e.miranda.aero;

public class Aeropuerto {
    int idAerppuerto;
    String nombre;
    Double latiutd;
    Double longitud;

    public Aeropuerto(int idAerppuerto, String nombre, Double latiutd, Double longitud) {
        this.idAerppuerto = idAerppuerto;
        this.nombre = nombre;
        this.latiutd = latiutd;
        this.longitud = longitud;
    }

    public Aeropuerto() {

    }

    public int getIdAerppuerto() {
        return idAerppuerto;
    }

    public void setIdAerppuerto(int idAerppuerto) {
        this.idAerppuerto = idAerppuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatiutd() {
        return latiutd;
    }

    public void setLatiutd(Double latiutd) {
        this.latiutd = latiutd;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

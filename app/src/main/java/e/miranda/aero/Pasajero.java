package e.miranda.aero;

public class Pasajero {
    int id_pasajero;
    String nombre;
    String apellido;
    String nacionalidad;
    int edad;
    String genero;
    String pass;
    String user;
    int nivel ;

    public Pasajero(int id_pasajero, String nombre, String apellido, String nacionalidad, int edad, String genero, String pass, String user, int nivel) {
        this.id_pasajero = id_pasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.genero = genero;
        this.pass = pass;
        this.user = user;
        this.nivel = nivel;
    }

    public Pasajero(){

    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "id_pasajero=" + id_pasajero +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", pass='" + pass + '\'' +
                ", user='" + user + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}

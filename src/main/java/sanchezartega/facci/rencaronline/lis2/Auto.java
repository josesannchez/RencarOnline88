package sanchezartega.facci.rencaronline.lis2;

public class Auto {

    private String nombre;

    public Auto(String nombre, String propietario, String modelo, String precio, int img) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.modelo = modelo;
        this.precio = precio;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private String propietario;
    private String modelo;
    private String precio;
    private int img;
    public Auto(){


    }
}

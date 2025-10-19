package incripciondeclasev2;

public class Curso {
    private String nombre;
    private double costo;

    public Curso(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() { return nombre; }
    public double getCosto() { return costo; }

    @Override
    public String toString() {
        return nombre + " - $" + costo;
    }
}


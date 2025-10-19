package incripciondeclasev2;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    private List<Curso> cursosDisponibles;
    private List<Curso> cursosInscritos;

    public Inscripcion() {
        cursosDisponibles = new ArrayList<>();
        cursosInscritos = new ArrayList<>();
    }

    public void agregarCursoDisponible(Curso curso) {
        cursosDisponibles.add(curso);
    }

    public List<Curso> getCursosDisponibles() {
        return cursosDisponibles;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void inscribirCurso(Curso curso) {
        cursosDisponibles.remove(curso);
        cursosInscritos.add(curso);
    }

    public double calcularTotal() {
        return cursosInscritos.stream().mapToDouble(Curso::getCosto).sum();
    }
}


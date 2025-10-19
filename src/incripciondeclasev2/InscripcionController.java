package incripciondeclasev2;

import javax.swing.*;

public class InscripcionController {
    private Inscripcion modelo;
    private InscripcionView vista;

    public InscripcionController(Inscripcion modelo, InscripcionView vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Inicializar cursos
        modelo.agregarCursoDisponible(new Curso("Java Básico", 1200));
        modelo.agregarCursoDisponible(new Curso("Python Avanzado", 1500));
        modelo.agregarCursoDisponible(new Curso("Bases de Datos", 1000));
        modelo.agregarCursoDisponible(new Curso("Desarrollo Web", 1800));

        for (Curso c : modelo.getCursosDisponibles()) {
            vista.modeloDisponibles.addElement(c);
        }

        // Eventos
        vista.btnInscribir.addActionListener(e -> inscribirCurso());
        vista.btnFicha.addActionListener(e -> generarFicha());
    }

    private void inscribirCurso() {
        Curso seleccionado = vista.listaDisponibles.getSelectedValue();
        if (seleccionado != null) {
            modelo.inscribirCurso(seleccionado);
            vista.modeloDisponibles.removeElement(seleccionado);
            vista.modeloInscritos.addElement(seleccionado);
            actualizarTotal();
        }
    }

    private void generarFicha() {
        if (modelo.getCursosInscritos().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "No hay cursos inscritos.");
        } else {
            StringBuilder sb = new StringBuilder("===== FICHA DE PAGO =====\n");
            for (Curso c : modelo.getCursosInscritos()) {
                sb.append(c.getNombre()).append(" - $").append(c.getCosto()).append("\n");
            }
            sb.append("-------------------------\n");
            sb.append("TOTAL: $").append(modelo.calcularTotal());
            JOptionPane.showMessageDialog(vista, sb.toString());
        }
    }

    private void actualizarTotal() {
        vista.lblTotal.setText("Total: $" + modelo.calcularTotal());
    }
}


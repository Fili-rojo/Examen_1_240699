package incripciondeclasev2;

import javax.swing.SwingUtilities;

public class IncripcionDeClaseV2 {

    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
            Inscripcion modelo = new Inscripcion();
            InscripcionView vista = new InscripcionView();
            new InscripcionController(modelo, vista);
            vista.setVisible(true);
        });
    }
    
}
sssss
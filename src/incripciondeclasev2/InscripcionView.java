package incripciondeclasev2;

import javax.swing.*;
import java.awt.*;

public class InscripcionView extends JFrame {
    public JList<Curso> listaDisponibles;
    public JList<Curso> listaInscritos;
    public DefaultListModel<Curso> modeloDisponibles;
    public DefaultListModel<Curso> modeloInscritos;
    public JButton btnInscribir;
    public JButton btnFicha;
    public JLabel lblTotal;

    public InscripcionView() {
        setTitle("Sistema de Inscripción a Cursos (MVC)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modeloDisponibles = new DefaultListModel<>();
        modeloInscritos = new DefaultListModel<>();

        listaDisponibles = new JList<>(modeloDisponibles);
        listaInscritos = new JList<>(modeloInscritos);

        JPanel panelListas = new JPanel(new GridLayout(1, 2));
        panelListas.add(new JScrollPane(listaDisponibles));
        panelListas.add(new JScrollPane(listaInscritos));

        btnInscribir = new JButton("Inscribir >>");
        btnFicha = new JButton("Generar Ficha de Pago");

        JPanel panelInferior = new JPanel(new BorderLayout());
        lblTotal = new JLabel("Total: $0.0");
        panelInferior.add(lblTotal, BorderLayout.WEST);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnInscribir);
        panelBotones.add(btnFicha);
        panelInferior.add(panelBotones, BorderLayout.EAST);

        add(panelListas, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }
}

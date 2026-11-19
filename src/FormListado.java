import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormListado extends JFrame {
    private JLabel Titulo;
    private JList<Usuario> lstUsuarios;
    private JButton btnVerDetalle;
    private JPanel panelPrincipal;
    private ArrayList<Usuario> listaUsuarios;

    public FormListado(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        setContentPane(panelPrincipal);

        // Se pone el titulo de la ventana
        setTitle("BookUsers · Listado de Usuarios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);

        // Creamos el modelo de datos
        DefaultListModel<Usuario> modeloLista = new DefaultListModel<>();

        // Recorremos la lista e insertamos un usuario por renglon
        for (Usuario u : listaUsuarios) {
            modeloLista.addElement(u);
        }

        // Le pasamos el modelo a la JList visual para visualizar en la ventana
        lstUsuarios.setModel(modeloLista);

        // Accion boton ver detallez
        btnVerDetalle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = lstUsuarios.getSelectedIndex();

                // Si no hay selección devuelve -1
                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(FormListado.this,
                            "Por favor seleccione un usuario de la lista para ver su informacion.",
                            "Atencion",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // Si selecciono a alguien lo mostramos completo
                Usuario usuarioSeleccionado = listaUsuarios.get(indiceSeleccionado);

                FormDetalle ventanaDetalle = new FormDetalle(usuarioSeleccionado);
                ventanaDetalle.setVisible(true);

            }
        });
    }

}

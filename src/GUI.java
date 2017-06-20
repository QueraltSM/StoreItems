/**
 * Created by QSM on 11/6/17.
 */
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI extends JFrame {
    private JFrame frame = new JFrame();
    private JList<Articulo> articulos = new JList<Articulo>();
    private Tienda t;
    private DefaultListModel dlm = new DefaultListModel();
    private JPanel panel = new JPanel();
    private boolean count = false;

    private Articulo a, b, c;
    private Proveedor p1, p2, p3;
    private static Articulo articulo;



    public static Articulo getArticulo(){
        return articulo;
    }


    public GUI(){
        init();
        for (Articulo i : t.todosArticulos()) {
            dlm.addElement(i.toString());
        }
        articulos.setModel(dlm);
        panel.add(articulos);



        articulos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!count) {
                    count = true;
                    for (Articulo i : t.todosArticulos()) {
                        if (i.equals(articulos.getSelectedValue())) {
                            articulo = i;
                            System.out.print(articulo.getNombre());
                            new InformationGUI();
                        }
                    }

                }
            }
        });


        frame.add(panel);
        frame.pack();
        frame.setTitle("Articulos de mi tienda");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void init(){
        t = new Tienda("Mi tienda");
        a = new Articulo("Boli rojos", 10, 20.0);
        b = new Articulo("Mueble de porcelana", 1, 70.2);
        c = new Articulo("Tocadiscos antiguo", 3, 40.5);
        p1 = new Proveedor("Lucas");
        p2 = new Proveedor("Sonia");
        p3 = new Proveedor("Samuel");

        p1.proveer(a);
        p2.proveer(a);
        p2.proveer(c);
        p3.proveer(b);
        p3.proveer(a);

    }
}

/**
 * Created by QSM on 11/6/17.
 */
import javax.swing.*;

public class InformationGUI extends JFrame {
    private JFrame frame = new JFrame();
    private JTextArea text = new JTextArea(20, 20);

    public InformationGUI(){
        text.setText(GUI.getArticulo().toString());
        frame.add(text);
        frame.pack();
        frame.setTitle(GUI.getArticulo().getNombre() + "");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}

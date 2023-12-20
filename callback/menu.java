import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class menu {
    private JButton enviar;
    JPanel menuPrincipal;
    private JTextField textField1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;

    public menu(JFrame frame) {


        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //RECOGEMOS EL TEXTO DEL JTEXTFIELD
                String texto = textField1.getText();
                //imprimo el texto en el jtextarea
                textArea1.append(texto+"\n");
            }
        });
        textArea3.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //mostramos todo lo que salga por consola en el jtextarea
                //textArea3.append("No consigo mostrar lo de la salida por consola en el jtextarea");
            }
        });
    }
}

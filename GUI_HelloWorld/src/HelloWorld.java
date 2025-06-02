import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class HelloWorld {
  public void criaJanelaPrincipal() {
    JFrame frame = new JFrame("Hello World!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new FlowLayout());

    JLabel lbDigiteNome = new JLabel("Digite seu nome: ");
    contentPane.add(lbDigiteNome);
    JTextField tfNome = new JTextField(40);
    contentPane.add(tfNome);
    JButton btOk = new JButton("Ok");
    contentPane.add(btOk);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      (new HelloWorld()).criaJanelaPrincipal();
    });
    System.out.println("O main acabou ...");
  }
}

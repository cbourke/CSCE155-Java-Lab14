package unl.cse.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HelloWorld extends JFrame {

	public HelloWorld() {
        initUI();
    }

    public final void initUI() {

       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(new FlowLayout());

       JLabel hello = new JLabel("Hello World!");
       panel.add(hello);
       
       JButton quitButton = new JButton("Quit");
       quitButton.setBounds(50, 60, 80, 30);
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });

       panel.add(quitButton);

       setTitle("Quit button");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	HelloWorld ex = new HelloWorld();
                ex.setVisible(true);
            }
        });
    }
}
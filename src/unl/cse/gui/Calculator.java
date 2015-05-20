package unl.cse.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculator extends JFrame {

	private final JTextField inputA = new JTextField("0", 20);
	private final JTextField inputB = new JTextField("0", 20);
	private final JTextField output = new JTextField("0", 20);

	public Calculator() {
		initializeGUI();
	}
	
	private void initializeGUI() {

		output.setEditable(false);

		BoxLayout bl = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(bl);

		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(0, 2, 10, 10);
		panel.setLayout(gridLayout);

		getContentPane().add(inputA);
		getContentPane().add(inputB);
		getContentPane().add(output);
		getContentPane().add(panel);

		JButton addButton = new JButton("+");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				
				double a = 0.0, b = 0.0;
				try {
					a = Double.parseDouble(inputA.getText());
					b = Double.parseDouble(inputB.getText());
					output.setText(String.valueOf(a+b));
				} catch (Exception e) {
					output.setText("ERROR");
				}
			}
		});
		panel.add(addButton);

		JButton subButton = new JButton("-");
		subButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				
				double a = 0.0, b = 0.0;
				try {
					a = Double.parseDouble(inputA.getText());
					b = Double.parseDouble(inputB.getText());
					output.setText(String.valueOf(a-b));
				} catch (Exception e) {
					output.setText("ERROR");
				}
			}
		});
		panel.add(subButton);
		
		
		JButton multButton = new JButton( "*" );
		multButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event ){
				
				double a = 0.0, b = 0.0;
				try{
					a = Double.parseDouble( inputA.getText() );
					b = Double.parseDouble( inputB.getText() );
					output.setText(String.valueOf(a*b) );
				}catch ( Exception exp ){
					output.setText( "ERROR" );
				}
			}
		});
		panel.add(multButton);
		
		
		
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				inputA.setText("0");
				inputB.setText("0");
				output.setText("0");
			}
		});
		panel.add(clearButton);

		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		panel.add(quitButton);
	       
		setTitle("Simple Calculator");
		setSize(250, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Calculator calc = new Calculator();
            	calc.setVisible(true);
            }
        });
    }

}

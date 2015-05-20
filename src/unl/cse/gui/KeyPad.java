package unl.cse.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class KeyPad extends JFrame {

	private final JTextField input = new JTextField("", 20);
	private final String passwd = "1234";
	private final JLabel label = new JLabel("<html><span style='text-align: left; font-weight: bold; text-align: left'>User Access</span></html>");
	public KeyPad() {
		initializeGUI();
	}
	
	private void initializeGUI() {
		
		input.setEditable(false);
		
		label.setAlignmentX(Component.RIGHT_ALIGNMENT);
		//label.setBorder(BorderFactory.createRaisedBevelBorder());

		BoxLayout bl = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(bl);
		
		JPanel panel = new JPanel();
		getContentPane().add(label);
		getContentPane().add(Box.createHorizontalGlue());
		getContentPane().add(input);
		getContentPane().add(Box.createHorizontalGlue());
		getContentPane().add(panel);

		GridLayout gridLayout = new GridLayout(4,3);
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		panel.setLayout(gridLayout);

		JButton key7 = new JButton("7");
		key7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "7");
			}
		});
		panel.add(key7);

		JButton key8 = new JButton("8");
		key8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "8");
			}
		});
		panel.add(key8);
		
		JButton key9 = new JButton("9");
		key9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "9");
			}
		});
		panel.add(key9);

		JButton key4 = new JButton("4");
		key4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "4");
			}
		});
		panel.add(key4);

		JButton key5 = new JButton("5");
		key5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "5");
			}
		});
		panel.add(key5);

		JButton key6 = new JButton("6");
		key6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "6");
			}
		});
		panel.add(key6);
		
		JButton key1 = new JButton("1");
		key1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "1");
			}
		});
		panel.add(key1);

		JButton key2 = new JButton("2");
		key2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "2");
			}
		});
		panel.add(key2);

		JButton key3 = new JButton("3");
		key3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "3");
			}
		});
		panel.add(key3);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText("");
			}
		});
		panel.add(clear);

		JButton key0 = new JButton("0");
		key0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				input.setText(input.getText() + "0");
			}
		});
		panel.add(key0);

		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(passwd.equals(input.getText())) {
					label.setText("<html><span style='color: green; font-weight: bold'>Granted!</span></html>");
				} else {
					label.setText("<html><span style='color: red; font-weight: bold'>Denied!</span></html>");
				}
			}
		});
		panel.add(enter);
		
		setTitle("Key Pad");
		setSize(250, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	KeyPad kpad = new KeyPad();
            	kpad.setVisible(true);
            }
        });
    }
}

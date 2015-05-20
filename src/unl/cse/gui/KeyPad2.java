package unl.cse.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class KeyPad2 extends JFrame {

	private final JTextField input = new JTextField("", 20);
	private final String passwd = "1234";
	private final JLabel label = new JLabel("<html><span style='text-align: left; font-weight: bold; text-align: left'>User Access</span></html>");

	public KeyPad2() {
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

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Integer key = null;
				try {
					key = Integer.parseInt(event.getActionCommand());
				} catch (NumberFormatException nfe) {
					
				}
				if(key != null) {
					input.setText(input.getText() + key);
				} else if(event.getActionCommand().equals("Clear")) {
					input.setText("");
				} else if(event.getActionCommand().equals("Enter")) {
					if(passwd.equals(input.getText())) {
						label.setText("<html><span style='color: green; font-weight: bold'>Granted!</span></html>");
					} else {
						label.setText("<html><span style='color: red; font-weight: bold'>Denied!</span></html>");
					}
				} else {
					throw new IllegalStateException("unknown ActionCommand: "+event.getActionCommand());
				}
			}
		};

		List<String> buttonLabels = Arrays.asList("7", "8", "9", "4", "5", "6", "1", "2", "3", "Clear", "0", "Enter");
		
		for(String s : buttonLabels) {
			JButton b = new JButton(s);
			b.setActionCommand(s);
			b.addActionListener(listener);
			panel.add(b);
		}

		setTitle("Key Pad");
		setSize(250, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	KeyPad2 kpad = new KeyPad2();
            	kpad.setVisible(true);
            }
        });
    }
}

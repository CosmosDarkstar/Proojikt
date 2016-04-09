package thing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class VorpalFlop implements ActionListener {

	private JFrame frame;
	private JTextField ard;
	private static JButton btnClickMe;
	private static VorpalFlop window;
	private JLabel esa;
	private JTextPane wea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new VorpalFlop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VorpalFlop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnClickMe = new JButton("CLICK ME");
		btnClickMe.setBounds(168, 160, 89, 23);
		frame.getContentPane().add(btnClickMe);
		btnClickMe.addActionListener(this);

		ard = new JTextField();
		ard.setEditable(false);
		ard.setBounds(10, 58, 414, 20);
		frame.getContentPane().add(ard);
		ard.setColumns(10);

		esa = new JLabel("");
		esa.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(esa);

		wea = new JTextPane();
		wea.setBounds(10, 107, 424, 20);
		frame.getContentPane().add(wea);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ard.setText("This is it so far but I'm working on something more.");
		esa.setText("This is it so far but I'm working on something more.");
		wea.setText("This is it so far but I'm working on something more.");

	}
}

package thing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jaco.mp3.player.MP3Player;

public class Playerinator implements ActionListener {
	private static ActionListener a = new Playerinator();

	private static MP3Player player = new MP3Player();

	private static ArrayList<File> pill = new ArrayList<File>();
	private static ArrayList<File> pil;

	private static JFrame frame = new JFrame("MP3 Player");
	private static BorderLayout lay = new BorderLayout();
	private static JTextField vop = new JTextField();
	private static JButton der = new JButton("Click when directory entered.");
	private static JButton de = new JButton("Click here to move to player.");
	private static JLabel as = new JLabel("Enter directory here");

	private static String dirc;

	public static void main(String[] args) throws Exception {
		player.setRepeat(true);

		inputGUI();

	}

	private static ArrayList<File> listf(String grak, ArrayList<File> files) {
		File floobl = new File(grak);

		File[] fList = floobl.listFiles();
		for (File f : fList) {
			if (f.isFile()) {
				files.add(f);
			} else if (f.isDirectory()) {
				listf(f.getAbsolutePath(), files);
			}
		}
		return files;
	}

	private static void playlistAdd(String dirc) {
		if (!dirc.isEmpty()) {
			pil = listf(dirc, pill);
			for (File f : pil) {

				player.addToPlayList(f);
				System.out.println(f);

			}
		}

	}

	private static void inputGUI() {
		player.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

		lay.setHgap(10);
		lay.setVgap(5);
		frame.setLayout(lay);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(as, BorderLayout.NORTH);
		frame.add(vop, BorderLayout.CENTER);
		frame.add(der, BorderLayout.SOUTH);
		der.addActionListener(a);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	protected static void playerGUI() {
		frame.remove(as);
		frame.remove(vop);
		frame.remove(der);
		frame.remove(de);
		frame.add(player, BorderLayout.NORTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dirc = vop.getText();
		dirc.replace("\\", "/");
		playlistAdd(dirc);
		playerGUI();

	}

}

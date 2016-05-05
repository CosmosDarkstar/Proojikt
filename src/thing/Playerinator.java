package thing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	private static JTextField vop = new JTextField(findDir().getAbsolutePath());
	private static JButton der = new JButton("Click when directory entered.");
	private static JButton de = new JButton("Click here to move to player.");
	private static JLabel as = new JLabel("Enter directory here");

	private static String dirc;

	public static void main(String[] args) throws Exception {
		player.setRepeat(true);

		inputGUI();

	}

	
	// finds all files within the specified directory
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

	//adds all mp3 files to the playlist of the Jaco mp3 player
	private static void playlistAdd(String dirc) {
		if (!dirc.isEmpty()) {
			pil = listf(dirc, pill);
			for (File f : pil) {

				player.addToPlayList(f);
				System.out.println(f);

			}
		}

	}
	//creates the initial GUI where you specify the directory to collect files from
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
	//removes all items from the initial GUI and adds the Jaco player controls
	protected static void playerGUI() {
		frame.remove(as);
		frame.remove(vop);
		frame.remove(der);
		frame.remove(de);
		frame.add(player);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
	//when button der is clicked this method collects the directory and makes sure it is compatible with java's String system, runs the playlistAdd method, and runs the playerGUI method
	@Override
	public void actionPerformed(ActionEvent arg0) {

		dirc = vop.getText();
		dirc.replace("\\", "/");
		playlistAdd(dirc);
		playerGUI();

	}
	//creates a directory choosing box to choose your directory to find files from
	private static File findDir() {
		JFileChooser choose = new JFileChooser();
		choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		choose.showDialog(null, "Open Directory");

		return choose.getSelectedFile();
	}

}

package thing;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jaco.mp3.player.MP3Player;

public class Playerinator {

	public static void main(String[] args) throws Exception {

		MP3Player player = new MP3Player();
		player.setRepeat(true);

		ArrayList<File> pill = new ArrayList<File>();
		ArrayList<File> pil = listf("D:\\teh musics\\", pill);

		for (File f : pil) {

			player.addToPlayList(f);
			System.out.println(f);

		}

		JFrame frame = new JFrame("MP3 Player");
		BorderLayout lay = new BorderLayout();
		JTextField vop = new JTextField();
		frame.setSize(900, 200);
		player.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

		lay.setHgap(10);
		lay.setVgap(5);
		frame.setLayout(lay);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(player, BorderLayout.NORTH);
		frame.add(new JLabel("Enter directory here"), BorderLayout.CENTER);
		frame.add(vop, BorderLayout.SOUTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static ArrayList<File> listf(String grak, ArrayList<File> files) {
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

}

package thing;

import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import jaco.mp3.player.MP3Player;

public class Playerinator2 {

	public static void main(String[] args) throws Exception {

		MP3Player player = new MP3Player();
		player.setRepeat(true);

		ArrayList<File> pill = new ArrayList<File>();
		ArrayList<File> pil = listf("D:\\teh musics\\", pill);

		for (File f : pil) {

			player.addToPlayList(f);
			System.out.println(f);

		}

		player.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		JFrame frame = new JFrame("MP3 Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(player);
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

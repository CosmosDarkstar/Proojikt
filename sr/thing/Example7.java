
package thing;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import jaco.mp3.player.MP3Player;
import jaco.mp3.player.plaf.MP3PlayerUICompact;

public class Example7 {
	static String[] names;
	static int i = 0;

	public static void main(String[] args) throws Exception {

		MP3Player.setDefaultUI(MP3PlayerUICompact.class);

		MP3Player player = new MP3Player();

		player.setRepeat(true);
		File in = new File("D:\\teh musics\\Feared-Synder-MP3\\Feared\\Synder\\");
		File[] pile = in.listFiles();
		for (File f : pile) {
			player.addToPlayList(pile[i]);
			i++;
		}

		player.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

		JFrame frame = new JFrame("MP3 Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(player);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void listFilesForFolder(File folder) {
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				System.out.println(fileEntry.getName());
			}
		}
	}

}

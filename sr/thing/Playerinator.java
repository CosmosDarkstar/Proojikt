package thing;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.apache.tika.Tika;

import jaco.mp3.player.MP3Player;

public class Playerinator {
	static Tika tika = new Tika();
	static int i = 0;
	static File in = new File("C:\\Users\\CosmosDarkstar\\Desktop\\moonrise");

	public static void main(String[] args) throws Exception {

		MP3Player player = new MP3Player();

		player.setRepeat(true);

		File[] pile = in.listFiles();
		for (File f : pile) {

			if (tika.detect(f) == "mp3") {
				player.addToPlayList(pile[i]);
			}
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

}

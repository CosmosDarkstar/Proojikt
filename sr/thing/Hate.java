package thing;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.apache.tika.Tika;

import jaco.mp3.player.MP3Player;

public class Hate {
	static Tika tika = new Tika();
	static int i = 0;
	static File in = new File("The L-Train (and friends) - Moonrise - 01 Scene 1- Prelude.mp3");

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

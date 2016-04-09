
package thing;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import jaco.mp3.player.MP3Player;

public class Example7 {

	public static void main(String[] args) throws Exception {

		// MP3Player.setDefaultUI(MP3PlayerUICompact.class);

		MP3Player player = new MP3Player();

		player.setRepeat(true);

		player.addToPlayList(new File("01 Hello (Metal Cover) [feat. Pete C.mp3"));
		player.addToPlayList(new File("LMFAO - Shots.mp3"));
		player.addToPlayList(new File("LMFAO - Yes.mp3"));
		// player.addToPlayList(new URL("http://server.com/mp3s/test4.mp3"));

		//

		player.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

		JFrame frame = new JFrame("MP3 Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(player);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

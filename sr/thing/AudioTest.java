package thing;

import java.io.File;

import jaco.mp3.player.MP3Player;

public class AudioTest {
	private MP3Player player;
	PlayerThread thread;

	public static void main(String[] args) {
		new MP3Player(new File("01 Hello (Metal Cover) [feat. Pete C.m4a")).play();

	}

}

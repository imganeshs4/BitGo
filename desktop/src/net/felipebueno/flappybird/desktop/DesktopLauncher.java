package net.felipebueno.flappybird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.felipebueno.flappybird.FlappyBird;

import static net.felipebueno.flappybird.FlappyBird.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = WIDTH;
		config.height = HEIGHT;
		config.title = title;
		new LwjglApplication(new FlappyBird(), config);
	}
}

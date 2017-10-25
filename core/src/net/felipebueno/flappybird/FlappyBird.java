package net.felipebueno.flappybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.felipebueno.flappybird.states.GameStateManager;
import net.felipebueno.flappybird.states.MenuState;

public class FlappyBird extends Game {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String title = "Flappy Bird";

	private SpriteBatch batch;
	private GameStateManager manager;
	private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		Gdx.gl.glClearColor(0, .2f, 0, 1);
		manager.push(new MenuState(manager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		manager.update(Gdx.graphics.getDeltaTime());
		manager.render(batch);
	}

	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}
}

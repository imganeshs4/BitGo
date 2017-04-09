package net.felipebueno.flappybird.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static net.felipebueno.flappybird.FlappyBird.HEIGHT;
import static net.felipebueno.flappybird.FlappyBird.WIDTH;

public abstract class State {

	private final FitViewport viewPort;
	protected OrthographicCamera camera;
	protected Vector3 mouse;
	protected GameStateManager manager;

	public State(GameStateManager manager) {
		this.manager = manager;
		camera = new OrthographicCamera();
		this.viewPort = new FitViewport(WIDTH, HEIGHT, camera);
		camera.position.set(viewPort.getWorldWidth() / 2, viewPort.getWorldHeight() / 2, 0);

		mouse = new Vector3();
	}

	protected abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render(SpriteBatch batch);
	public abstract void dispose();

}

package net.felipebueno.flappybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static net.felipebueno.flappybird.FlappyBird.HEIGHT;
import static net.felipebueno.flappybird.FlappyBird.WIDTH;

public class MenuState extends State {

	private final String TAG = getClass().getSimpleName();
	private final Texture bg;
	private final Texture playbtn;

	public MenuState(GameStateManager manager) {
		super(manager);
		camera.setToOrtho(false, WIDTH / 2, HEIGHT / 2);

		bg = new Texture("bg.png");
		playbtn = new Texture("playbtn.png");
	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) {
			manager.set(new PlayState(manager));
			return;
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
			Gdx.app.exit();
	}

	@Override
	public void update(float dt) {
		camera.update();
		handleInput();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bg, 0, 0);
		batch.draw(playbtn, camera.position.x - (playbtn.getWidth() / 2), camera.position.y  - (playbtn.getHeight() / 2));
		batch.end();
	}

	@Override
	public void dispose() {
		bg.dispose();
		playbtn.dispose();
		Gdx.app.log(TAG, "disposed");
	}

}

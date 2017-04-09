package net.felipebueno.flappybird.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {

	private final String TAG = getClass().getSimpleName();
	private static final int GRAVITY = -15;
	private static final int MOVEMENT = 100;

	private final Vector3 position;
	private final Vector3 velocity;
	private final Texture texture;
	private final Sound flap;

	private Animation birdAnimation;

	private final Rectangle bounds;

	public Bird(int x, int y) {
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0, 0, 0);
		texture = new Texture("birdanimation.png");
		birdAnimation = new Animation(new TextureRegion(texture), 3, .5f);
		bounds = new Rectangle(position.x, position.y, texture.getWidth() / 3, texture.getHeight());
		flap = new Gdx().audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
	}

	public Vector3 getPosition() {
		return position;
	}

	public TextureRegion getTexture() {
		return birdAnimation.getFrame();
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void update(float dt) {
		birdAnimation.update(dt);
		if (position.y > 0)
			velocity.add(0, GRAVITY, 0);

		velocity.scl(dt);
		position.add(MOVEMENT * dt, velocity.y, 0);

		if (position.y < 0)
			position.y = 0;

		velocity.scl(1 / dt);
		bounds.setPosition(position.x, position.y);
	}

	public void jump() {
		flap.play(0.2f);
		velocity.y = 250;
	}

	public void dispose() {
		texture.dispose();
		flap.dispose();
		Gdx.app.log(TAG, "disposed");
	}

}

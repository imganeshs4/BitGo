package net.felipebueno.flappybird.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {

	private final String TAG = getClass().getSimpleName();
	private static final int FLUCTUATION = 130;
	private static final int TUBE_GAP = 100;
	private static final int LOWEST_OPENING = 120;
	public static final int TUBE_WIDTH = 52; // Texture width

	private final Texture topTube;
	private final Texture bottomTube;
	private final Random rand;
	private final Vector2 posTopTube;
	private final Vector2 posBotTube;
	private final Rectangle boundsTop;
	private final Rectangle boundsBot;

	public Tube(float x) {
		topTube = new Texture("toptube.png");
		bottomTube = new Texture("bottomtube.png");

		rand = new Random();

		posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
		posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

		boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
		boundsBot = new Rectangle(posBotTube.x, posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());


	}

	public Texture getTopTube() {
		return topTube;
	}

	public Texture getBottomTube() {
		return bottomTube;
	}

	public Vector2 getPosTopTube() {
		return posTopTube;
	}

	public Vector2 getPosBotTube() {
		return posBotTube;
	}


	public void reposition(float x) {
		posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
		posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

		boundsTop.setPosition(posTopTube.x, posTopTube.y);
		boundsBot.setPosition(posBotTube.x, posBotTube.y);
	}

	public boolean collides(Rectangle boundsBird) {
		final boolean isColliding = boundsBird.overlaps(boundsTop) || boundsBird.overlaps(boundsBot);
		return isColliding;
	}

	public void dispose() {
		topTube.dispose();
		bottomTube.dispose();
		Gdx.app.log(TAG, "disposed");
	}
}

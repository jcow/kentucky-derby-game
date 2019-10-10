package com.mygdx.kdg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.kdg.lib.creatures.Creature;
import com.mygdx.kdg.lib.game.MainGame;

import java.util.List;

public class KentuckyDerbyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	MainGame mainGame = new MainGame();

	Camera cam;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		// Constructs a new OrthographicCamera, using the given viewport width and height
		// Height is multiplied by aspect ratio.
		cam = new OrthographicCamera(800, 800);

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

	}

	@Override
	public void render () {

		// helper
		handleInput();


		// batch
		batch.setProjectionMatrix(cam.combined);

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();


		for(Creature creature : mainGame.getCreatureList()) {
			batch.draw(img, creature.getX(), creature.getY(), 20, 20);
		}

		batch.end();


		// camera
		cam.position.set(new Vector3(getLeaderX(mainGame.getCreatureList()), 0, 0));
		cam.update();


		// game tick
		mainGame.tick();








	}

	// TODO make faster
	private int getLeaderX(List<Creature> creatureList) {
		int maxX = 0;
		for(Creature creature : creatureList) {
			if(creature.getX() > maxX) {
				maxX = creature.getX();
			}
		}
		return maxX;
	}

	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			cam.translate(-3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			cam.translate(3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			cam.translate(0, -3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			cam.translate(0, 3, 0);
		}
	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

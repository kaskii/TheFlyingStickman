package fi.kask.flyingstickman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fi.kask.flyingstickman.States.GameStateManager;
import fi.kask.flyingstickman.States.MenuState;

public class FlyingStickman extends ApplicationAdapter {

	public static final int WIDTH = 400;
	public static final int HEIGHT = 800;
	public static final String TITLE = "The Flying Stickman";

	private GameStateManager _gameStateManager;
	private SpriteBatch _batch;

	@Override
	public void create () {
		_batch = new SpriteBatch();
		_gameStateManager = new GameStateManager();
		_gameStateManager.push(new MenuState(_gameStateManager));

		Gdx.gl.glClearColor(0, 0.74902f, 1, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		_gameStateManager.update(Gdx.graphics.getDeltaTime());
		_gameStateManager.render(_batch);
	}
	
	@Override
	public void dispose () {
		_batch.dispose();
	}
}

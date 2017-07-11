package fi.kask.flyingstickman.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by kask on 12.7.2017.
 */
public abstract class State {

    protected OrthographicCamera _camera;
    protected Vector3 _mouse;
    protected GameStateManager _gameStateManager;

    protected State(GameStateManager gsm) {
        _gameStateManager = gsm;
        _camera = new OrthographicCamera();
        _mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}

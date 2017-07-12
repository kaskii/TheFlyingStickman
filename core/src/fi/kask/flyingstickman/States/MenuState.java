package fi.kask.flyingstickman.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fi.kask.flyingstickman.FlyingStickman;

/**
 * Created by kask on 12.7.2017.
 */
public class MenuState extends State {

    private Texture _backgroundTexture;
    private Texture _playButtonTexture;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        _camera.setToOrtho(false, FlyingStickman.WIDTH, FlyingStickman.HEIGHT);

        _backgroundTexture = new Texture("background.png");
        _playButtonTexture = new Texture("playButton.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            _gameStateManager.set(new PlayState(_gameStateManager));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(_camera.combined);

        sb.begin();

        sb.draw(_backgroundTexture, 0, 0, FlyingStickman.WIDTH, FlyingStickman.HEIGHT);
        sb.draw(_playButtonTexture, FlyingStickman.WIDTH / 2 - _playButtonTexture.getWidth() / 2, 250);

        sb.end();
    }

    @Override
    public void dispose() {
        _backgroundTexture.dispose();
        _playButtonTexture.dispose();
    }
}

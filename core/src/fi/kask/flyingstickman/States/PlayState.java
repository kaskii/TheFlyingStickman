package fi.kask.flyingstickman.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fi.kask.flyingstickman.FlyingStickman;

/**
 * Created by kask on 12.7.2017.
 */
public class PlayState extends State {

    private Texture _stickmanTexture;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        _stickmanTexture = new Texture("stickman.png");
        _camera.setToOrtho(false, FlyingStickman.WIDTH / 2, FlyingStickman.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(_camera.combined);
        sb.begin();

        sb.draw(_stickmanTexture, 35, 50, 30, 15);

        sb.end();
    }

    @Override
    public void dispose() {
        _stickmanTexture.dispose();
    }
}

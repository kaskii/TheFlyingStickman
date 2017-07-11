package fi.kask.flyingstickman.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fi.kask.flyingstickman.FlyingStickman;
import fi.kask.flyingstickman.sprites.Stickman;

/**
 * Created by kask on 12.7.2017.
 */
public class PlayState extends State {

    private Stickman _stickman;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        _stickman = new Stickman(35, 100);
        _camera.setToOrtho(false, FlyingStickman.WIDTH / 2, FlyingStickman.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        _stickman.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(_camera.combined);
        sb.begin();

        sb.draw(_stickman.getStickman(), _stickman.getPosition().x, _stickman.getPosition().y, 30, 15);

        sb.end();
    }

    @Override
    public void dispose() {
        _stickman.dispose();
    }
}

package fi.kask.flyingstickman.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fi.kask.flyingstickman.FlyingStickman;
import fi.kask.flyingstickman.sprites.SpikePole;
import fi.kask.flyingstickman.sprites.Stickman;

/**
 * Created by kask on 12.7.2017.
 */
public class PlayState extends State {

    private Stickman _stickman;
    private Texture _backgroundTexture;
    private SpikePole _spikePole;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        _stickman = new Stickman(35, 100);
        _spikePole = new SpikePole(100);

        _backgroundTexture = new Texture("background.png");
        _camera.setToOrtho(false, FlyingStickman.WIDTH / 2, FlyingStickman.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            _stickman.hopUp();
        }
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

        sb.draw(_backgroundTexture, _camera.position.x - _camera.viewportWidth / 2, 0);
        sb.draw(_stickman.getStickman(), _stickman.getPosition().x, _stickman.getPosition().y, 30, 15);
        sb.draw(_spikePole.getTopSpikePoleTexture(), _spikePole.getTopSpikePolePosition().x,_spikePole.getTopSpikePolePosition().y);
        sb.draw(_spikePole.getBottomSpikePoleTexture(), _spikePole.getBottomSpikePolePosition().x,_spikePole.getBottomSpikePolePosition().y);

        sb.end();
    }

    @Override
    public void dispose() {
        _stickman.dispose();
        _spikePole.dispose();
        _backgroundTexture.dispose();
    }
}

package fi.kask.flyingstickman.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import fi.kask.flyingstickman.FlyingStickman;
import fi.kask.flyingstickman.sprites.SpikePole;
import fi.kask.flyingstickman.sprites.Stickman;

/**
 * Created by kask on 12.7.2017.
 */
public class PlayState extends State {

    private static final int SPIKE_SPACING = 125;
    private static final int SPIKE_COUNT = 4;

    private Stickman _stickman;
    private Texture _backgroundTexture;

    private Array<SpikePole> _spikePoles;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        _stickman = new Stickman(35, 100);

        _backgroundTexture = new Texture("background.png");
        _camera.setToOrtho(false, FlyingStickman.WIDTH / 2, FlyingStickman.HEIGHT / 2);

        _spikePoles = new Array<SpikePole>();

        for(int i = 2; i < SPIKE_COUNT + 2; i++) {
            _spikePoles.add(new SpikePole(i * (SPIKE_SPACING + SpikePole.SPIKE_WIDTH)));
        }
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
        _camera.position.x = _stickman.getPosition().x + 80;

        // Repos spike poles left side of the screen
        for(SpikePole spikePole : _spikePoles) {
            if(_camera.position.x - (_camera.viewportWidth / 2) > spikePole.getTopSpikePolePosition().x + spikePole.getTopSpikePoleTexture().getWidth()) {
                spikePole.reposition(spikePole.getBottomSpikePolePosition().x + ((SpikePole.SPIKE_WIDTH + SPIKE_SPACING) * SPIKE_COUNT));
            }
        }

        _camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(_camera.combined);
        sb.begin();

        sb.draw(_backgroundTexture, _camera.position.x - _camera.viewportWidth / 2, 0);
        sb.draw(_stickman.getStickman(), _stickman.getPosition().x, _stickman.getPosition().y, 30, 15);

        for(SpikePole spikePole : _spikePoles) {
            sb.draw(spikePole.getTopSpikePoleTexture(), spikePole.getTopSpikePolePosition().x, spikePole.getTopSpikePolePosition().y);
            sb.draw(spikePole.getBottomSpikePoleTexture(), spikePole.getBottomSpikePolePosition().x, spikePole.getBottomSpikePolePosition().y);
        }

        sb.end();
    }

    @Override
    public void dispose() {
        _stickman.dispose();
        _backgroundTexture.dispose();

        for(SpikePole spikePole : _spikePoles) {
            spikePole.dispose();
        }
    }
}

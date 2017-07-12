package fi.kask.flyingstickman.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by kask on 12.7.2017.
 */
public class SpikePole {

    public static final int SPIKE_WIDTH = 32;

    private static final int FLUCTUATION = 130;
    private static final int SPIKE_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Texture _topSpikePoleTexture;
    private Texture _bottomSpikePoleTexture;
    private Vector2 _topSpikePolePosition;
    private Vector2 _bottomSpikePolePosition;

    // For collision
    private Rectangle _boundsTop;
    private Rectangle _boundsBottom;

    private Random _random;

    public SpikePole(float x) {
        _topSpikePoleTexture = new Texture("topSpikePole.png");
        _bottomSpikePoleTexture = new Texture("bottomSpikePole.png");

        _random = new Random();

        _topSpikePolePosition = new Vector2(x, _random.nextInt(FLUCTUATION) + SPIKE_GAP + LOWEST_OPENING);
        _bottomSpikePolePosition = new Vector2(x, _topSpikePolePosition.y - SPIKE_GAP - _bottomSpikePoleTexture.getHeight());

        _boundsTop = new Rectangle(_topSpikePolePosition.x, _topSpikePolePosition.y, _topSpikePoleTexture.getWidth(), _topSpikePoleTexture.getHeight());
        _boundsBottom = new Rectangle(_bottomSpikePolePosition.x, _bottomSpikePolePosition.y, _bottomSpikePoleTexture.getWidth(), _bottomSpikePoleTexture.getHeight());
    }

    public void reposition(float x) {
        _topSpikePolePosition.set(x, _random.nextInt(FLUCTUATION) + SPIKE_GAP + LOWEST_OPENING);
        _bottomSpikePolePosition.set(x, _topSpikePolePosition.y - SPIKE_GAP - _bottomSpikePoleTexture.getHeight());

        _boundsTop.setPosition(_topSpikePolePosition.x, _topSpikePolePosition.y);
        _boundsBottom.setPosition(_bottomSpikePolePosition.x, _bottomSpikePolePosition.y);
    }

    public boolean collides(Rectangle playerRect) {
        return playerRect.overlaps(_boundsBottom) || playerRect.overlaps(_boundsTop);
    }

    public void dispose() {
        _topSpikePoleTexture.dispose();
        _bottomSpikePoleTexture.dispose();
    }

    public Texture getTopSpikePoleTexture() {
        return _topSpikePoleTexture;
    }

    public Texture getBottomSpikePoleTexture() {
        return _bottomSpikePoleTexture;
    }

    public Vector2 getTopSpikePolePosition() {
        return _topSpikePolePosition;
    }

    public Vector2 getBottomSpikePolePosition() {
        return _bottomSpikePolePosition;
    }
}

package fi.kask.flyingstickman.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by kask on 12.7.2017.
 */
public class Stickman {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 _position;
    private Vector3 _velocity;

    private Texture _stickman;

    public Stickman(int x, int y) {
        _position = new Vector3(x, y,0);
        _velocity = new Vector3(0,0,0);
        _stickman = new Texture("stickman.png");
    }

    public void update(float dt) {
        if(_position.y > 0) {
            _velocity.add(0, GRAVITY, 0);
        }

        _velocity.scl(dt);
        _position.add(MOVEMENT * dt,_velocity.y,0);

        // Normalize velocity back so we can use it on next frame
        _velocity.scl(1/dt);

        // Make sure player doesn't fall below the screen
        if(_position.y < 0) {
            _position.y = 0;
        }
    }

    public void dispose() {
        _stickman.dispose();
    }

    public void hopUp() {
        _velocity.y = 250;
    }

    public Vector3 getPosition() {
        return _position;
    }

    public Texture getStickman() {
        return _stickman;
    }
}

package fi.kask.flyingstickman.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by kask on 12.7.2017.
 */
public class GameStateManager {

    private Stack<State> _states;

    public GameStateManager() {
        _states = new Stack<State>();
    }

    public void push(State state) {
        _states.push(state);
    }

    public void pop() {
        _states.pop();
    }

    public void set(State state) {
        _states.pop();
        _states.push(state);
    }

    public void update(float dt) {
        _states.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        _states.peek().render(sb);
    }
}

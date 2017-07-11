package fi.kask.flyingstickman.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fi.kask.flyingstickman.FlyingStickman;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlyingStickman.WIDTH;
		config.height = FlyingStickman.HEIGHT;
		config.title = FlyingStickman.TITLE;

		new LwjglApplication(new FlyingStickman(), config);
	}
}

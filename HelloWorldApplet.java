import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorldApplet extends Applet {
    @Override
    public void init() {
        // Initialization code
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Hello, World!", 50, 50); // Draws "Hello, World!" on the applet
    }
}
import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a triangle on the screen
     */

    public void drawTriangle(){
        Pen pen = new Pen(100, 140, myCanvas);
        pen.setColor(Color.GREEN);

        // Draw actual triangle
        for(int i=0; i<3; i++){
            pen.move(300);
            pen.turn(120);
        }
    }

     /**
     * Draw a pentagon on the screen
     */

    public void drawPentagon(){
        Pen pen = new Pen(200, 200, myCanvas);
        pen.setColor(Color.BLACK);

        // Draw actual pentagon
        for(int i=0; i<5; i++){
            pen.turn(180-108);
            pen.move(80);
        }
    }

    /**
     * Draw a pentagon on the screen
     */

    public void drawPolygon(int n){
        // Check for valid polygon
        if(n<3){
            System.err.println("n must be greater than 2");
            return;
        }

        Pen pen = new Pen(150, 150, myCanvas);
        pen.setColor(Color.BLACK);

        // Calculate total angle
        int totalAngle = 180 * (n-2);
        int turnAngle = totalAngle/n;

        // Draw actual polygon
        for(int i=0; i<n; i++){
            pen.move(500/n);
            pen.turn(180-turnAngle);
        }
    }

    /**
     * Draw a spiral
     */
    public void drawSpiral(){
    Pen pen = new Pen(100, 100, myCanvas);
    pen.setColor(Color.BLACK);

    for(int i=0; i<30; i++){
        pen.move(80-(2*i));
        pen.turn(30);
    }
    }


    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}

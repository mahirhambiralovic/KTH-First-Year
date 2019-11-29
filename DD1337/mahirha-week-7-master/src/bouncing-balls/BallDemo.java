import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    public static void main(String[] args) {
        BallDemo demo = new BallDemo();
        demo.boxBounce();
    }

    private Canvas myCanvas;
    private Random randomizer;
    private final int canvasWidth = 600;
    private final int canvasHeight = 500;
    private final int xWallStart = (int) Math.round(canvasWidth *0.1);          // Start walls from 0.1 of canvas
    private final int yWallStart = (int) Math.round(canvasHeight *0.1);
    private final int xWallLength = (int) Math.round(canvasWidth *0.8);         // Wall length is 0.8 of canvas
    private final int yWallLength = (int) Math.round(canvasHeight *0.8);

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", canvasWidth, canvasHeight);
        randomizer = new Random();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int n)
    {
        if(n<1){
            System.err.println("At least one ball please");
            return;
        }

        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls and add them to a ballPit
        ArrayList<BouncingBall> ballPit = new ArrayList<>();
        for(int i=0; i<n; i++){
            BouncingBall ball = new BouncingBall(randomizer.nextInt(400), randomizer.nextInt(250), 16, Color.BLUE, ground, myCanvas);
            ballPit.add(ball);
            ball.draw();
        }

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay

            for(BouncingBall ball : ballPit){
                ball.move();
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= 550) {
                finished = true;
                }
            }
        }
    }

    public void boxBounce(){
        myCanvas.setVisible(true);

        // Add colors in an array
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.BLACK, Color.BLUE, Color.CYAN, 
        Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW));

        // Draw square
        drawSquare();

        // create and show a 10-40 balls and add them to a ballPit ArrayList
        ArrayList<BoxBall> ballPit = new ArrayList<>();
        for(int i=0; i < (randomizer.nextInt(30) +10); i++){
            // creates ball of random position (within box), random size (5 - 25), random color and random x and y speed (5-15)
            BoxBall ball = new BoxBall(randomizer.nextInt(xWallLength) + xWallStart, randomizer.nextInt(yWallLength) + yWallStart, 
                                        randomizer.nextInt(20) + 5, colors.get(randomizer.nextInt(9)), 
                                        xWallStart, yWallStart, xWallLength, yWallLength, randomizer.nextInt(10) +5, randomizer.nextInt(10) +5, myCanvas);
            ballPit.add(ball);
            ball.draw();
        }

        // Animation (infinite)
        while (true) {
            drawSquare();
            myCanvas.wait(50);           // small delay
            for(BoxBall ball : ballPit){
                ball.move();
            }
        }

    }

        private void drawSquare(){
            myCanvas.setForegroundColor(Color.BLACK);
            // Top wall
            myCanvas.drawLine(xWallStart, yWallStart, xWallStart + xWallLength, yWallStart);
            // Right wall
            myCanvas.drawLine(xWallStart + xWallLength, yWallStart, xWallStart + xWallLength, yWallStart + yWallLength);
            // Bottom wall
            myCanvas.drawLine(xWallStart + xWallLength, yWallStart + yWallLength, xWallStart, yWallStart + yWallLength);
            // Left wall
            myCanvas.drawLine(xWallStart, yWallStart + yWallLength, xWallStart, yWallStart);
        }
}

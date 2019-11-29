import java.awt.*;
import java.awt.geom.*;

/**
 * An extension of BouncingBall which sets balls inside a
 * box, where the balls bounce around in.
 */

public class BoxBall{

    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int xWallStart;
    private final int yWallStart;
    private final int xWallLength;
    private final int yWallLength;
    private Canvas canvas;
    private int xSpeed;
    private int ySpeed;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param xWallStart  the position of the wall x position (where the wall will bounce)
     * @param yWallStart  the position of the wall y position (where the wall will bounce)
     * @param xWallLength the length of xWall
     * @param yWallLength the length of yWall
     * @param xVelocity the xSpeed of the ball
     * @param yVelocity the ySpeed of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int xWall, int yWall, int xWallLeng, int yWallLeng, int xVelocity, int yVelocity, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        xWallStart = xWall;
        yWallStart = yWall;
        xWallLength = xWallLeng;
        yWallLength = yWallLeng;
        xSpeed = xVelocity;
        ySpeed = yVelocity;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // check if ball has touched wall and reverse x/y speed
        switch(touchedWall(xPosition, yPosition, diameter)){
            case 1: xSpeed = -xSpeed; break;
            case 2: ySpeed = -ySpeed; break;
        }

        // compute new position
        xPosition += xSpeed;
        yPosition += ySpeed;

        // draw again at new position
        draw();
    }

    /**
     * Checks if ball has touched any of the walls. Returns int for each wall.
     * @param x xPosition
     * @param y yPosition
     * @param d diameter
     * @return
     */
    private int touchedWall(int x, int y, int d){
        // Left wall
        if(x + xSpeed <= xWallStart){
            xPosition = (int)(xWallStart);
            return 1;
        }
        // Right wall
        if(x + xSpeed >= xWallStart + xWallLength - d){
            xPosition = (int)(xWallStart + xWallLength - d);
            return 1;
        }
        // Top wall
        if(y + ySpeed <= yWallStart){
            yPosition = (int)(yWallStart);
            return 2;
        }
        // Bottom wall
        if(y + ySpeed >= yWallStart + yWallLength - d){
            yPosition = (int)(yWallStart + yWallLength - d);
            return 2;
        }
        return 0;
    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}

//@Author: Olivia Sendelbach 10/16/24
//referenced @Nux Spot.java class from lecture


package com.example.hwb_sendelbach;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Random;

public class Raindrop extends SurfaceView
{
    private float xCORD;
    private float yCORD;
    private Paint paintColor;
    private final int radius = 30;
    private ArrayList<Raindrop> mainDrop = new ArrayList<>();  // List to store all raindrop objects

    // Constructor for the class that initializes random coordinates and color and allows the onDraw() to run
    public Raindrop(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);
    }

    // Creates a new color (tint) with random RGB values to generate a randomly selected color
    protected void setRandomColor() {
        int tint = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        paintColor = new Paint();
        paintColor.setColor(tint);
    }

    // Method to initialize a raindrop with random coordinates and color
    public static Raindrop createRandomRaindrop(Context context) {
        Raindrop raindrop = new Raindrop(context, null);
        Random random = new Random();
        raindrop.xCORD = random.nextFloat() * 800;
        raindrop.yCORD = random.nextFloat() * 800;
        raindrop.setRandomColor();
        return raindrop;
    }

    // Draw method that will generate random circles, or raindrops, with a random color and adds them to the array list
    @Override
    protected void onDraw(Canvas c)
    {
        super.onDraw(c);

        mainDrop.clear(); //Allows so that the raindrops have a fresh page every time the app runs

        Random random = new Random();
        int numberOfRaindrops = random.nextInt(7) + 6;

        for (int i = 0; i < numberOfRaindrops; i++) {

            Raindrop raindrop = Raindrop.createRandomRaindrop(getContext());

            mainDrop.add(raindrop);

            c.drawCircle(raindrop.xCORD, raindrop.yCORD, radius, raindrop.paintColor);
        }

    }
    // Method to check if two raindrops overlap
    private boolean isOverlapping(Raindrop other) {
        float checkXCoord = this.xCORD - other.xCORD;
        float checkYCoord = this.yCORD - other.yCORD;
        float distance = (float) Math.sqrt(checkXCoord * checkXCoord + checkYCoord * checkYCoord);
        return distance < (this.radius + other.radius); //AI used for the return method, specifically "this.radius + other.radius"
    }

    //** Last part of assignment (overlapping color averages started, but could not figure out. This is what I have started and gone back and forth on editing (last 20% on rubric)

    // Method to average two colors

    //private int averageColor(int color1, int color2) {
        //int r = ... / 2; // tint variable reference needed
        //int g = ... / 2;
        //int b = .../ 2;
        //return Color.rgb(r, g, b);
    //}

    // Method to handle raindrop absorption
    //public void absorbRaindrops() {
        //ArrayList<Raindrop> absorbedRaindrops = new ArrayList<>();

        //for (Raindrop otherRaindrop : mainDrop) {
            //if (this != otherRaindrop && isOverlapping(otherRaindrop)) {
                //// Absorb the other raindrop: remove it from the list and average the colors
                //this.paintColor.setColor(averageColor(this.paintColor.getColor(), otherRaindrop.paintColor.getColor()));
                //absorbedRaindrops.add(otherRaindrop); // Mark this raindrop for removal
            //}
        //}

        // Remove absorbed raindrops
        //mainDrop.removeAll(absorbedRaindrops);

        // Redraw to reflect the updated state
        //invalidate();
    }
}
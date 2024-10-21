//@Author: Olivia Sendelbach 10/20/24
//referenced @Nux ControllerExample class from lecture
package com.example.hwb_sendelbach;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class RaindropController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener
{

    private Raindrop raindrop;
    private SeekBar verticalSeekBar;
    private SeekBar horizontalSeekBar;

    //Seek bar's max value changed in XML file
    //deep copy of variables
    public RaindropController(Raindrop initRaindrop, SeekBar initVerticalSeekBar, SeekBar initHorizontalSeekBar)
    {
        this.raindrop = initRaindrop;
        this.verticalSeekBar = initVerticalSeekBar;
        this.horizontalSeekBar = initHorizontalSeekBar;

        // Set initial SeekBar progress to match the raindrop's starting position
        this.verticalSeekBar.setProgress((int) raindrop.getY());
        this.horizontalSeekBar.setProgress((int) raindrop.getX());

        // Set the listeners for SeekBars
        this.verticalSeekBar.setOnSeekBarChangeListener(this);
        this.horizontalSeekBar.setOnSeekBarChangeListener(this);

        // Set the touch listener for the raindrop view
        this.raindrop.setOnTouchListener(this);
    }

    //Handles the motion events and updates the raindrops position and Seek Bar's progress to the changed position
    @Override
    public boolean onTouch(View view, MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_MOVE) { // AI used for this line to reference the MotionEvent.ACTION_MOVE for syntax

            float touchX = event.getX();
            float touchY = event.getY();


            float newX = Math.max(0, Math.min(touchX, 800));
            float newY = Math.max(0, Math.min(touchY, 800));


            raindrop.setX(newX);
            raindrop.setY(newY);


            horizontalSeekBar.setProgress((int) newX);
            verticalSeekBar.setProgress((int) newY);


            raindrop.invalidate();
        }
        return true;


    }

    //Added methods that were "quick fix" from error messages
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {

    }
}
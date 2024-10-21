//@Author: Olivia Sendelbach 10/16/24
package com.example.hwb_sendelbach;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    Raindrop raindrop = findViewById(R.id.surfaceView);
    SeekBar verticalSeekBar = findViewById(R.id.seekBar1);
    SeekBar horizontalSeekBar = findViewById(R.id.horizontalSeekBar);

    RaindropController controller = new RaindropController(raindrop, verticalSeekBar, horizontalSeekBar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
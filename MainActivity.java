package com.example.light_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.imageView);

        SensorManager sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        //Sensor s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                float[] v = event.values;
                Log.d("", "*" + v[0]);

                if (v[0] < 10) {
                    img.setImageResource(R.drawable.sadflower);
                }

                else if (v[0] < 50) {

                    img.setImageResource(R.drawable.neutralflower);
                }

                else if (v[0] > 50) {

                    img.setImageResource(R.drawable.happyflower);
                }

            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, s, SensorManager.SENSOR_DELAY_FASTEST);


    }
}
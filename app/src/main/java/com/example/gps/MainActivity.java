package com.example.gps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    double latitude = 0, longitude = 0;
    Button button;
    TextView Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button1);
        Text = (TextView) findViewById(R.id.Text);


    button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        GPSTracker gps = new GPSTracker(MainActivity.this);
        if (gps.canGetLocation()) {

            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            if (latitude == 0.0) {

                Text.setText("Lat n Long Not Available");
            }
            if (longitude == 0.0) {

                Text.setText("Lat n Long Not Available");
            }

            Text.setText("Lat :"+latitude +"Long :"+ longitude);



        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
            return;
        }
    }
});


    }
}

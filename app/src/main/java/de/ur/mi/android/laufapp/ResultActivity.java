package de.ur.mi.android.laufapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {

    private TextView distanceView;
    private TextView paceView;
    private TextView kalorienView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Bundle extras = getIntent().getExtras();

        Double distance = Double.parseDouble(extras.getString("distance"));
        Double time = Double.parseDouble(extras.getString("time"));
        Double breaktime = Double.parseDouble(extras.getString("breaktime"));

        Log.i("Werte", "distance " + distance + " time " + time + " breaktime " + breaktime );

        StatsHelper statsHelper = new StatsHelper();
        statsHelper.setDistance(distance);
        statsHelper.setTime(time);
        statsHelper.setBreakTime(breaktime);

        distanceView = (TextView) findViewById(R.id.textResultDistance);
        Log.i("Distance" , distance.toString());
        distanceView.setText(distance.toString());
        paceView = (TextView) findViewById(R.id.textResultPace);
        Double pace = statsHelper.getPace();
        paceView.setText(pace.toString().replace(".", ":"));
        kalorienView = (TextView) findViewById(R.id.textResultKalorien);
        Double kalorien = statsHelper.getBurnedKilocalories();
        kalorienView.setText(kalorien.toString());


    }


}

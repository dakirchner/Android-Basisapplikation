package de.ur.mi.android.laufapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartActivity extends Activity implements View.OnClickListener{

    private TextView mainText;
    private EditText distance;
    private EditText time;
    private EditText breakTime;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Starten Sie hier mit Ihrer Implementierung
        initUI();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.main);
        mainText.setText(R.string.main_text);

        distance = (EditText)  findViewById(R.id.distance);
        time = (EditText)  findViewById(R.id.time);
        breakTime = (EditText)  findViewById(R.id.breakTime);

        button = (Button)  findViewById(R.id.button);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button) {
            Intent intent = new Intent(StartActivity.this, ResultActivity.class);

            intent.putExtra("distance", distance.getText().toString() );
            intent.putExtra("time", time.getText().toString() );
            intent.putExtra("breaktime", breakTime.getText().toString() );

            startActivity(intent);
        }

    }
}

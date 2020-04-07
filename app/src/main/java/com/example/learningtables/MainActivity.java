package com.example.learningtables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

     ListView timesTablesListView;
    public void generateTimesTable(int timesTableNumber)
    {
        TextView intro = (TextView) findViewById(R.id.textView2);
        intro.animate().rotationX(720).setDuration(1000);

        final ArrayList<String> timesTableContent = new ArrayList<String>();

        Log.i("Searched Value", Integer.toString(timesTableNumber));

        for(int i=1; i<=10; i++)
        {
            timesTableContent.add(Integer.toString(timesTableNumber) + " x " + Integer.toString(i) + " = " + Integer.toString(timesTableNumber*i));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intro.animate().scaleX(1000).scaleY(1000).setDuration(2000);

        final SeekBar timesTablesSeekBar = (SeekBar) findViewById(R.id.timesTablesSeekBar);
        timesTablesListView = (ListView) findViewById(R.id.timesTablesListView);
        int max=20;
        int startingPosition=10;
        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);
        generateTimesTable(startingPosition);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                int min =1;
                int timesTableNumber;
                if(progress < min)
                {
                    timesTableNumber=min;
                    timesTablesSeekBar.setProgress(min);
                }
                else
                {
                    timesTableNumber=progress;
                }
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}

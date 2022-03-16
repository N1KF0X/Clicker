package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Integer counter = 0;
    private Integer digitOfNumberOfCounter = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        if (savedInstanceState != null && savedInstanceState.containsKey("counter"))
        {
            counter = savedInstanceState.getInt("counter");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("counter"))
        {
            digitOfNumberOfCounter = savedInstanceState.getInt("counter2");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("height"))
        {
            params.height = savedInstanceState.getInt("height");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("width"))
        {
            params.width = savedInstanceState.getInt("width");
        }
        counterView.setLayoutParams(params);
        counterView.setText(counter.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        digitOfNumberOfCounter = savedInstanceState.getInt("counter2");
        params.height = savedInstanceState.getInt("height");
        params.width = savedInstanceState.getInt("width");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putInt("counter2", digitOfNumberOfCounter);
        outState.putInt("height", params.height);
        outState.putInt("width", params.width);
    }

    public void onClickPassTheMeter(View view)
    {
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        counter++;
        if(counter/10 == digitOfNumberOfCounter)
        {
            params.width += 20;
            params.height += 20;
            counterView.setLayoutParams(params);
            digitOfNumberOfCounter *= 10;
        }
        counterView.setText(counter.toString());
    }
}
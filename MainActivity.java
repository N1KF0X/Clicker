package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{
    private Integer counter = 0;
    private Integer counter2 = 10;
    public static final String TAG = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView counterView = findViewById(R.id.txt_counter);
        if (savedInstanceState != null && savedInstanceState.containsKey("counter"))
        {
            counter = savedInstanceState.getInt("counter");
        }
        counterView.setText(counter.toString());        
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    public void onClickBtnAddStudents(View view)
    {
        counter++;
        TextView counterView = findViewById(R.id.txt_counter);
        if(counter/10 == counter2)
        {
            TextView layout = findViewById(R.id.txt_counter);
            ViewGroup.LayoutParams params = layout.getLayoutParams();
            params.width += 20;
            params.height += 20;
            layout.setLayoutParams(params);
            counter2 *= 10;
        }
        counterView.setText(counter.toString());
        counterView.setWidth(150);
        counterView.setHeight(150);
    }
}

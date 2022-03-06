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
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
        resetUI();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private void resetUI()
    {
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());
        Log.d(TAG, "resetUI");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        Log.d(TAG, "onSaveInstanceState");
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
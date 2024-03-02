package com.example.multithreadinginandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startThread(View view){//link to button
        ExampleRunnable runnable = new ExampleRunnable(10);
//        start a new thread
        new Thread(runnable).start();
    }
    public void stopThread(View view){

    }
    class ExampleRunnable implements Runnable{
        int seconds;
        ExampleRunnable(int seconds){
            this.seconds=seconds;
        }
        @Override
        public void run() {
            for(int i =0; i< seconds; i++){
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000); // simulate heavy operations by freezing threads for 10 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
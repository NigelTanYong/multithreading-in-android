package com.example.multithreadinginandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button buttonStartThread;
    private Handler mainHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStartThread = findViewById(R.id.button_start_thread);
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
                if(i == 5){
                    /*Handler threadHandler = new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() { // can be replaced with mainHandler
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });*/
                    //or
                   /* buttonStartThread.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });*/
                    //or
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });
                }
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
package com.mfcwl.boundservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ServiceConnection serviceConnection;
    private boolean isServicesBound=false;
    private Intent serviceInten;

    private MyServices myservices;
    private TextView viewnumbers;
    private TextView startservice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Description
        //<editor-fold desc="Description">
        viewnumbers = (TextView) findViewById(R.id.viewnumbers);
        //</editor-fold>

        

        //endregion
        TextView startservice = (TextView) findViewById(R.id.startservice);
        TextView stopservice = (TextView) findViewById(R.id.stopservices);
        TextView onbind = (TextView) findViewById(R.id.onbind);
        TextView onunbind = (TextView) findViewById(R.id.onunbind);


        viewnumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("vvvv","vvvv");
                Log.e("vvvv","vvvv"+ viewnumbers.getText().toString());


            }
        });


        startservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("vvvv","vvvv");

              //  startservice();

            }
        });


        stopservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("vvvv","vvvv");

                // stopservice();
            }
        });
        onbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("vvvv","vvvv");

                //onbindservice();
            }
        });
        onunbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("vvvv","vvvv");

                // onunbindservice();
            }
        });
    }



   public void viewnumbers() {

       // if(isServicesBound){
          //  viewnumbers.setText("no data");

           // viewnumbers.setText("The Random No:="+myservices.getRamdomNumber());
       // }else{
        //    viewnumbers.setText("no data");
       // }
    }
 /*
    private void onunbindservice() {

        if(isServicesBound){
            unbindService(serviceConnection);
            isServicesBound=false;

        }
    }

    private void onbindservice() {

        if (serviceConnection == null) {

            serviceConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                    MyServices.MyServiceIBinder ibb=(MyServices.MyServiceIBinder)iBinder;

                    myservices=ibb.getServices();

                    isServicesBound=true;
                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                    isServicesBound=false;
                }
            };
        }

        bindService(serviceInten,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void stopservice() {
        stopService(serviceInten);
    }

    private void startservice() {

        startService(serviceInten);


    }*/



}

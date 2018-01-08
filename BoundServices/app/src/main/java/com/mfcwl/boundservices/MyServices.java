package com.mfcwl.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileDescriptor;
import java.util.Random;

/**
 * Created by HP 240 G4 on 21-12-2017.
 */

public class MyServices extends Service {

    private int ramdomNumber;
    private boolean ramdomGentOn;

    private final int MIN=0;
    private final int MAX=100;



    abstract class MyServiceIBinder implements IBinder {

        public MyServices getServices(){

            return MyServices.this;
        }

    }

    private IBinder iBinder= new MyServiceIBinder() {
        @Override
        public String getInterfaceDescriptor() throws RemoteException {
            return null;
        }

        @Override
        public boolean pingBinder() {
            return false;
        }

        @Override
        public boolean isBinderAlive() {
            return false;
        }

        @Override
        public IInterface queryLocalInterface(String s) {
            return null;
        }

        @Override
        public void dump(FileDescriptor fileDescriptor, String[] strings) throws RemoteException {

        }

        @Override
        public void dumpAsync(FileDescriptor fileDescriptor, String[] strings) throws RemoteException {

        }

        @Override
        public boolean transact(int i, Parcel parcel, Parcel parcel1, int i1) throws RemoteException {
            return false;
        }

        @Override
        public void linkToDeath(DeathRecipient deathRecipient, int i) throws RemoteException {

        }

        @Override
        public boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
            return false;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.e("Service Demo=","onBind Method=");
        return iBinder;
    }



    @Override
    public void onDestroy() {

        Log.e("service Demo= ","IN On destroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Service Demo=","in onUnBind ");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {

        Log.e("Service Demo=","in onReBind");
        super.onRebind(intent);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("Servid Demo=","in onStartCommand");

        ramdomGentOn=true;

        new Thread(new Runnable() {
            @Override
            public void run() {

                startRamdomNumberGern();

            }
        }).start();

        return START_STICKY;
    }

    private void startRamdomNumberGern(){

        while(ramdomGentOn){
            try{

                if(ramdomGentOn){

                    ramdomNumber=new Random().nextInt(MAX)+MIN;
                    Log.e("randomNumber=","randomNumber="+ramdomNumber);
                }

            }catch (Exception e){


            }
        }

    }


    private void stopRamdomNumberGen(){

        ramdomGentOn=false;
    }

    public int getRamdomNumber(){

        return ramdomNumber;
    }
}

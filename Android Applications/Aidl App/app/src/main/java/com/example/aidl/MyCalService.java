package com.example.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyCalService extends Service {

    private final calculator.Stub mBinder = new calculator.Stub(){
        @Override
        public int add(int a, int b) {
            return a + b;
        }

        @Override
        public int sub(int a, int b) throws RemoteException {
            return a-b;
        }

        @Override
        public int mul(int a, int b) throws RemoteException {
            return a*b;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}

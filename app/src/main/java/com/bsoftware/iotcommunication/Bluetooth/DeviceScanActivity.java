package com.bsoftware.iotcommunication.Bluetooth;

import android.Manifest;
import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.util.List;

public class DeviceScanActivity extends ListActivity {
    private BluetoothAdapter bluetoothAdapter;
    private boolean scanning;
    private Handler handler;

    private static final long SCAN_PERIOD = 10000;

    private ScanCallback LeScanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
        }
    };

    private void ScanBLEDevice(final boolean enable) {
        final BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
        if (enable) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                        if (ActivityCompat.checkSelfPermission(DeviceScanActivity.this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
                           if(ActivityCompat.shouldShowRequestPermissionRationale(DeviceScanActivity.this, Manifest.permission.BLUETOOTH_SCAN)){
                                //TODO : Empty logic
                            } else {
                               //TODO : Empty logic
                           }
                        } else {
                            Log.i("Permission Granted","Permission already Granted");
                        }
                    scanning = false;
                    bluetoothLeScanner.stopScan(LeScanCallback);
                }
            },SCAN_PERIOD);

            scanning = true;
            bluetoothLeScanner.startScan(LeScanCallback);
        } else {
            scanning = false;
            bluetoothLeScanner.stopScan(LeScanCallback);
        }
    }

    public void ShowResult(){
        private LeDeviceListAdapter
    }

}

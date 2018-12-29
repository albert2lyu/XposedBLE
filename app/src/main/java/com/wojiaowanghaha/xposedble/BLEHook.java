package com.wojiaowanghaha.xposedble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by wojiaowanghaha
 * time : 2018/12/30
 * 852172891@qq.com
 */

public class BLEHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.indexOf("com.") != -1) {
            Class bluetooth = lpparam.classLoader.loadClass("android.bluetooth.BluetoothGatt");
            try {
                if (bluetooth != null) {
                    XposedHelpers.findAndHookMethod(bluetooth, "writeCharacteristic", BluetoothGattCharacteristic.class, new XC_MethodHook() {
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) param.args[0];
                            byte[] mValue = bluetoothGattCharacteristic.getValue();

                            String str = "";
                            if (mValue != null) {
                                for (int i = 0; i < mValue.length; i++) {
                                    str += String.format("%x ", mValue[i]);
                                }
                            }
                            Log.e("packageName" + lpparam.packageName, "writeCharacteristic   str :" + str + " bluetoothGattCharacteristic" + bluetoothGattCharacteristic.getUuid().toString());

                        }
                    });

                    XposedHelpers.findAndHookMethod(bluetooth, "readCharacteristic", BluetoothGattCharacteristic.class, new XC_MethodHook() {
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) param.args[0];
                            byte[] mValue = bluetoothGattCharacteristic.getValue();

                            String str = "";
                            if (mValue != null) {
                                for (int i = 0; i < mValue.length; i++) {
                                    str += String.format("%x ", mValue[i]);
                                }
                            }
                            Log.e("packageName" + lpparam.packageName, "readCharacteristic   str :" + str + " bluetoothGattCharacteristic" + bluetoothGattCharacteristic.getUuid().toString());
                        }
                    });
                }
            } catch (Exception e) {
                Log.e("wanghaha", e.toString());
            }
        }
    }
}

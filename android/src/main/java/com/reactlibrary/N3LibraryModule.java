package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

//Import libraries
import com.nexgo.oaf.apiv3.DeviceEngine;
import com.nexgo.oaf.apiv3.SdkResult;
import com.nexgo.oaf.apiv3.APIProxy;

public class N3LibraryModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private String deviceSerialNo;

    public N3LibraryModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "N3Library";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    @ReactMethod
    public void getSerialNo(Callback errorCallback,Callback successCallback) {

        try{
        DeviceEngine deviceEngine = APIProxy.getDeviceEngine();
            deviceSerialNo = deviceEngine.getDeviceInfo().getSn().toString();
            successCallback.invoke(deviceSerialNo);
        }
        catch(Exception e){
            errorCallback.invoke(e.getMessage());
        }
    }
}

package com.reactlibrary;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

//Import libraries
import com.nexgo.oaf.apiv3.DeviceEngine;
import com.nexgo.oaf.apiv3.SdkResult;
import com.nexgo.oaf.apiv3.APIProxy;
import com.nexgo.oaf.apiv3.device.beeper.Beeper;
import com.nexgo.oaf.apiv3.device.printer.AlignEnum;
import com.nexgo.oaf.apiv3.device.printer.OnPrintListener;
import com.nexgo.oaf.apiv3.device.printer.Printer;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Base64;
import android.util.Log;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;

public class N3LibraryModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private String deviceSerialNo;

    //Init Printer
    private DeviceEngine deviceEngine;
    private Printer printer;
    private String TAG = "N3 Printer";
    Promise globalPromise;
    int res = 00;

    public N3LibraryModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        deviceEngine = APIProxy.getDeviceEngine();
        printer = deviceEngine.getPrinter();
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
    public void getSerialNo(Callback successCallback,Callback errorCallback) {

        try{
            DeviceEngine deviceEngine = APIProxy.getDeviceEngine();
            deviceSerialNo = deviceEngine.getDeviceInfo().getSn().toString();
            successCallback.invoke(deviceSerialNo);
        }
        catch(Exception e){
            errorCallback.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void print(String jsonData, Promise promise) {
      printer.initPrinter();
      printer.setTypeface(Typeface.MONOSPACE);
      //printer.setLetterSpacing(5);

      readJson(jsonData);
      printer.startPrint(true, new OnPrintListener() {
          @Override
          public void onPrintResult(int responseCode) {
              if (responseCode == 0) {
                  Log.d(TAG, "print finished " + responseCode);

              } else {
                  final Beeper beeper = deviceEngine.getBeeper();
                  beeper.beep(500);
                  Log.e(TAG, "print failed" + responseCode);
              }
              res = responseCode;
          }
      });

      if (res == 0) {
        promise.resolve("Success");
      }
      else{
        promise.reject("Failed");
      }

    }

    public void readJson(String jsonData){

      try {
          // the object data is inside a "global" JSONObject
          JSONObject data = new JSONObject(jsonData).getJSONObject("data");
          // get a JSONArray from inside an object
          JSONArray printDataWrapper = data.getJSONArray("printData");

          for(int index = 0; index < printDataWrapper.length(); index++){
              JSONObject printObj = printDataWrapper.getJSONObject(index);

              //Extract data from array
              String type = printObj.getString("type").toUpperCase();
              String printData = printObj.getString("data");
              String alignment = printObj.getString("alignment").toUpperCase();


              if(type != null) {
                  AlignEnum alignEnum;
                  if (alignment.equals("CENTER")) {
                      alignEnum = AlignEnum.CENTER;
                  } else if (alignment.equals("RIGHT")) {
                      alignEnum = AlignEnum.RIGHT;
                  } else {
                      alignEnum = AlignEnum.LEFT;
                  }

                  if (type.equals("TEXT")) {

                      String size = printObj.getString("size").toUpperCase();
                      Boolean isBold = printObj.getBoolean("isBold");

                      if (printData != null) {
                          //Set default Text size to NORMAL, which is 20
                          int fontSize = 20;
                          switch (size) {
                              case "SMALL":
                                  fontSize = 16;
                                  break;
                              case "LARGE":
                                  fontSize = 24;
                                  break;
                              case "X-LARGE":
                                  fontSize = 32;
                                  break;
                              default:
                                  break;
                          }
                          //Append Printer
                          printer.appendPrnStr(printData, fontSize, alignEnum, isBold);
                      }
                  } else if (type.equals("IMAGE")) {
                      if (printData != null) {
                          Bitmap image = getImage(printData);
                          if (image != null) {
                              printer.appendImage(image, alignEnum);
                          }
                      } else {
                          Log.e(TAG, "Image data is missing");
                      }

                  }
              }
              else{
                  Log.e(TAG, "Print data type is missing");
              }

          }


      }
      catch (Exception e){
          Log.e(TAG, e.toString());
      }

      //return  valid;
  }

  public Bitmap getImage(String base64String) {
      try {
          byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
          Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
          return decodedByte;
      } catch (Exception e) {
          Log.e(TAG, e.toString());
          return null;
      }
  }
}


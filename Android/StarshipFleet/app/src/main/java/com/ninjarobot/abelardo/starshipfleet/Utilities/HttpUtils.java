package com.ninjarobot.abelardo.starshipfleet.Utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ajmarquez on 09/08/16.
 */
public class HttpUtils {

    private Context utilsContext;

    public static void CheckNetworkStatus(Context context) {


        ConnectivityManager cManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo nInfo = cManager.getActiveNetworkInfo();

        if (nInfo != null && nInfo.isConnected()) {
            Log.d("NETWORK DATA", "All is good");
        } else {
            Log.d("ERROR", "There's been an error");
        }


    }

    public void downloadUrl(String myUrl) throws IOException {
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.

        try {
            URL url = new URL(myUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("DEBUG", "The response is: " + response);

            Log.d("DEBUG", "Content type: " + conn.getContentType());
            is = conn.getInputStream();

            // Read content
            BufferedReader reader =new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String webPage = "";
            String data;

            while ((data = reader.readLine()) != null){
                webPage += data + "\n";
            }

            Log.d("INFO", webPage);
            ObjectMapper mapper = new ObjectMapper();
            StarShip myObjects = mapper.readValue(webPage, new TypeReference<StarShip>(){});
            Log.d("works ..", myObjects.getName());

            // Convert the InputStream into a string

//            Log.d( "INFO", "Solution:" + contentAsString);


        }finally{
            if (is != null) {
                try {
                    is.close();
                } finally {
                    is.close();
                }
            }
        }




    }

}

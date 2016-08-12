package com.ninjarobot.abelardo.starshipfleet.Utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import com.ninjarobot.abelardo.starshipfleet.entities.StartShipWrapper;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by ajmarquez on 09/08/16.
 */
public class HttpUtils {

    private Context utilsContext;
    private List<StarShip> shipsData;
    private boolean beacon = false;

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

    public void downloadData(String myUrl) throws IOException {
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

            // Serialize JSON
            ObjectMapper mapper = new ObjectMapper();
            StartShipWrapper myObjects = mapper.readValue(webPage, new TypeReference<StartShipWrapper>(){});
            shipsData = myObjects.getResults();
            Log.d("DEBUG", "Number of elements:" + myObjects.getResults().size());



        }catch (IOException ex) {
            // LOG or output exception
            System.out.println(ex);
        } finally{
            beacon = true;
            if (is != null) {
                try {
                    is.close();
                } finally {
                    is.close();
                }
            }
        }


    }

    public List<StarShip> getShipsData() {
        return shipsData;
    }

    public boolean isReady () {
        return beacon;
    }
}

package com.example.jibba.birdwatcher;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.jibba.birdwatcher.objects.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BirdsCatalogActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> birdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_catalog);

        birdList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        new GetBirds().execute();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d(TAG, "onItemClick: " + position);
            }
        });
    }
    private class GetBirds extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(BirdsCatalogActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "http://birdobservationservice.azurewebsites.net/Service1.svc/birds";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {

                    // Getting JSON Array node
                    JSONArray birds = new JSONArray(jsonStr);
                    Log.d(TAG, "doInBackground: " + birds.length());

                    // looping through All Contacts
                    for (int i = 0; i < birds.length(); i++) {
                        JSONObject bobj = birds.getJSONObject(i);
                        String id = bobj.getString("Id");
                        String nameDanish = bobj.getString("NameDanish");
                        String nameEnglish = bobj.getString("NameEnglish");
                        String created = bobj.getString("Created");
                        String photoUrl = bobj.getString("PhotoUrl");


                        // tmp hash map for single bird
                        HashMap<String, String> bird = new HashMap<>();

                        // adding each child node to HashMap key => value
                        bird.put("Id", id);
                        bird.put("NameDanish", nameDanish);
                        bird.put("NameEnglish", nameEnglish);
                        bird.put("Created", created);
                        bird.put("PhotoUrl", photoUrl);


                        // adding bird to bird list
                        birdList.add(bird);
                        Log.d(TAG, "doInBackground: " + bird);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }



        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(BirdsCatalogActivity.this, birdList,
                    R.layout.list_item, new String[]{ "Id","NameDanish", "NameEnglish"},
                    new int[]{R.id.id, R.id.nameDanish, R.id.nameEnglish});
            lv.setAdapter(adapter);
        }
    }
}
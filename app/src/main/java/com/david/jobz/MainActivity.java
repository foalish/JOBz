package com.david.jobz;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends Activity {

    JSONObject jsonobject;
    JSONArray jsonarray;
    ProgressDialog mProgressDialog;
    ArrayList<String> worldlist;
    ArrayList<String> typesofjobs;
    ArrayList<AllTheJobs> world;
    ArrayList<String> typesofjobsunique;
    ArrayList<String> getWorldListForItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        Button orderButton = (Button)findViewById(R.id.login);
        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Chat_sign_up.class);
                startActivity(intent);
            }

        });


        // Download JSON file AsyncTask
        new DownloadJSON().execute();
    }

    // Download JSON file AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {
        public final static String EXTRA_MESSAGE = "com.david.jobz.MESSAGE";
        @Override
        protected Void doInBackground(Void... params) {
            // Locate the WorldPopulation Class
            world = new ArrayList<AllTheJobs>();
            // Create an array to populate my_spinner
            worldlist = new ArrayList<String>();
            // Create an array to populate spinner1
            typesofjobs = new ArrayList<String>();
            // Create an array to populate spinner1
            getWorldListForItem = new ArrayList<String>();

            // JSON file URL address
            jsonobject = JSONfunctions
                    .getJSONfromURL("http://217.199.187.199/robswebdevelopercourse.com/mysql/jobsdata_JSON.php");

            try {
                // Locate the NodeList name
                jsonarray = jsonobject.getJSONArray("AllTheJobs");
                for (int i = 0; i < jsonarray.length(); i++) {
                    jsonobject = jsonarray.getJSONObject(i);

                    AllTheJobs worldpop = new AllTheJobs();

                    worldpop.setGcses(jsonobject.optString("gcses"));
                    worldpop.setJob_title(jsonobject.optString("job_title"));
                    worldpop.setJob_description(jsonobject.optString("job_description"));
                    worldpop.setOther_qualifications(jsonobject.optString("other_qualifications"));
                    worldpop.setAlevels(jsonobject.optString("alevels"));
                    worldpop.setDegree(jsonobject.optString("degree"));
                    world.add(worldpop);

                    // Populate spinner1 with job types
                    typesofjobs.add(jsonobject.optString("job_type"));

                    // Populate my_spinner with job titles
                    getWorldListForItem.add(jsonobject.optString("job_title"));

                }
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {

            // Locate spinner1 in activity_main.xml
            Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);

            // Locate my spinner in activity_main.xml
           final Spinner mySpinner = (Spinner) findViewById(R.id.my_spinner);

            // Spinner adapter
            List<String> typesofjobsunique = new ArrayList<>(new LinkedHashSet<>(typesofjobs));
            spinner1.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_spinner_dropdown_item, typesofjobsunique));
            Collections.sort(typesofjobsunique);

     // spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
     //         public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
      //    mySpinner
       //                 .setAdapter(new ArrayAdapter<String>(MainActivity.this,
       //                        android.R.layout.simple_spinner_dropdown_item,
       //                       Collections.sort(getWorldListForItem(parent.getItemAtPosition(pos)))));
       //  }
      //      public void onNothingSelected(AdapterView<?> parent) {
                  // Another interface callback
       //        }
      //      });


            // Spinner adapter
            mySpinner
                    .setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getWorldListForItem));


            // Spinner on item click listener
            mySpinner
                    .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                    {
                        @Override
                        public void onItemSelected(AdapterView<?> arg0,
                                                   View arg1, int position, long arg3) {
                            // TODO Auto-generated method stub
                            // Locate the textviews in activity_main.xml
                            TextView txtgcses = (TextView) findViewById(R.id.gcses);
                            TextView txtdegree = (TextView) findViewById(R.id.degree);
                            TextView txtjob_description = (TextView) findViewById(R.id.job_description);
                            TextView txtother_qualifications = (TextView) findViewById(R.id.other_qualifications);
                            TextView txtalevels = (TextView) findViewById(R.id.alevels);

                            // Set the text followed by the position
                            txtgcses.setText(world.get(position).getGcses());
                            txtdegree.setText(world.get(position).getDegree());
                            txtjob_description.setText(world.get(position).getJob_description());
                            txtother_qualifications.setText(world.get(position).getOther_qualifications());
                            txtalevels.setText(world.get(position).getAlevels());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub
                        }
                    });


        }

    }


}





package com.w3learnteam.w3learn.learn;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.w3learnteam.w3learn.R;
import com.w3learnteam.w3learn.api.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class HTML_Learn extends AppCompatActivity {

    private String TAG = HTML_Learn.class.getSimpleName();

    private SweetAlertDialog pDialog;
    private RecyclerView H_Subject;
    ArrayList<HTML> list;
    private HTML_Adapter htmlAdapter;

    // URL to get contacts JSON
    private static String url = "http://192.168.43.170/!earn/api/learn/read_html.php";
    //private static String url = "https://my-json-server.typicode.com/JulioRahman/mynewrepo/db";

    TextView HTitle,HSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html__learn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HTitle = (TextView) findViewById(R.id.htitle);
        HSub = (TextView) findViewById(R.id.hsubtitle);

        list = new ArrayList<>();
        new GetLearn().execute();

        H_Subject = (RecyclerView) findViewById(R.id.html_subject);

        HSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HTML_Learn.this, List_Code.class);
                startActivity(intent);
            }
        });

    }

    private class GetLearn extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new SweetAlertDialog(HTML_Learn.this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#54E2FF"));
            pDialog.setTitleText("Please Wait");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray soals = jsonObj.getJSONArray("html");

                    // looping through All Contacts
                    for (int i = 0; i < soals.length(); i++) {
                        JSONObject s = soals.getJSONObject(i);

                        String title = s.getString("title");
                        String desc = s.getString("desc");

                        list.add(new HTML(title,desc));
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
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
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            HTitle.setTranslationX(-300);
            HSub.setTranslationX(300);

            HTitle.setAlpha(0);
            HSub.setAlpha(0);

            HTitle.animate().alpha(1).translationX(0).setDuration(500).setStartDelay(300);
            HSub.animate().alpha(1).translationX(0).setDuration(500).setStartDelay(600);

            htmlAdapter = new HTML_Adapter(list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HTML_Learn.this);
            H_Subject.setLayoutManager(layoutManager);
            H_Subject.setAdapter(htmlAdapter);

            if (pDialog.isShowing()){
                pDialog.dismiss();
            }
            else {
                Toast.makeText(HTML_Learn.this,"Error While Showing The Activity",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

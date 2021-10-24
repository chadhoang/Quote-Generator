package com.gmail.chadhoang.usa.quotegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateActivity extends AppCompatActivity {

    private final static String[][] APIARRAY = {
            {"ANIME", "https://animechan.vercel.app/api/random"},
            {"DAD JOKE", "https://icanhazdadjoke.com/"},
            {"QOTD", "https://favqs.com/api/qotd"},
            {"ZEN", "https://zenquotes.io/api/random"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        // Get intent and String Extra representing category selection.
        Intent intent = getIntent();
        String category = intent.getStringExtra("Category");

        // Assign value to generate button.
        Button generate_btn = findViewById(R.id.generate_btn);

        // Assign value to quote editText.
        EditText quote_et = findViewById(R.id.quote_et);

        // Set category TextView.
        TextView category_tv = findViewById(R.id.category_tv);
        category_tv.setText(category);

        // Click listener for generate button.
        generate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtain quote type and url from APIARRAY.
                String quote_type, url;
                if (category.equals("RANDOM")) {
                    int random_index = new Random().nextInt(APIARRAY.length);
                    quote_type = APIARRAY[random_index][0];
                    url = APIARRAY[random_index][1];
                } else {
                    quote_type = category;
                    url = intent.getStringExtra("URL");
                }

                // If quote type is ZEN, request is JSON array, else, JSON object.
                if (quote_type.equals("ZEN")) {
                    JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                JSONObject object = response.getJSONObject(0);
                                String output = "\"" + object.getString("q") + "\""
                                        + "\n\n — " + object.getString("a");
                                quote_et.setText(output);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(GenerateActivity.this, "Zen Error.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Add a request (in this example, called stringRequest) to your RequestQueue.
                    MySingleton.getInstance(GenerateActivity.this).addToRequestQueue(request);
                } else if (quote_type.equals("DAD JOKE")) {
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String output = "\"" + response.getString("joke") + "\"";
                                quote_et.setText(output);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(GenerateActivity.this, "Dad Joke Error.", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        // Set header for "DAD JOKE" category.
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> headers = new HashMap<String, String>();
                            // headers.put("Content-Type", "application/json");
                            headers.put("Accept", "application/json");
                            return headers;
                        }
                    };

                    // Add a request (in this example, called stringRequest) to your RequestQueue.
                    MySingleton.getInstance(GenerateActivity.this).addToRequestQueue(request);
                } else {
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Update quote editText to be the quote received from JSON GET request.
                            try {
                                if (quote_type.equals("ANIME")) {
                                    String output = "\"" + response.getString("quote") + "\""
                                            + "\n\n — " + response.getString("character") + "\n\n"
                                            + "Anime: " + response.getString("anime");
                                    quote_et.setText(output);
                                } else if (quote_type.equals("QOTD")) {
                                    JSONObject object = response.getJSONObject("quote");
                                    String output = "\"" + object.getString("body") + "\""
                                            + "\n\n — " + object.getString("author");
                                    quote_et.setText(output);
                                } else {
                                    Toast.makeText(GenerateActivity.this, "Unknown category.", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(GenerateActivity.this, "ANIME or QOTD Error.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Add a request (in this example, called stringRequest) to your RequestQueue.
                    MySingleton.getInstance(GenerateActivity.this).addToRequestQueue(request);
                }

            }
        });
    }
}
package com.david.jobz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Chat_sign_up extends AppCompatActivity {

    EditText email, username, password, birthdate, gender;
    Button insert, show;
    TextView result;
    RequestQueue requestQueue;
    String insertUrl = "http://217.199.187.199/robswebdevelopercourse.com/social_network/insertUser.php";
    String showUrl =   "http://217.199.187.199/robswebdevelopercourse.com/social_network/showUsers.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email =     (EditText) findViewById(R.id.inputEmail);
        username =  (EditText) findViewById(R.id.inputUsername);
        password =  (EditText) findViewById(R.id.inputPassword);
        birthdate = (EditText) findViewById(R.id.inputBirthdate);
        gender =    (EditText) findViewById(R.id.inputGender);

        insert = (Button)   findViewById(R.id.sign_up);
    //    show = (Button)   findViewById(R.id.show);
        result = (TextView) findViewById(R.id.textView);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                        showUrl, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray users = response.getJSONArray("users");
                            for (int i = 0; i < users.length(); i++) {
                                JSONObject user = users.getJSONObject(i);

                                String email     =  user.getString("inputEmail");
                                String username  =  user.getString("inputUsername");
                                String password  =  user.getString("inputPassword");
                                String birthdate =  user.getString("inputBirthdate");
                                String gender    =  user.getString("inputGender");

                                result.append(email + " " + username + "" + password + birthdate + " " + gender + "\n");
                            }
                            result.append("===\n");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.append(error.getMessage());

                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("email",    email.getText().toString());
                        parameters.put("username", username.getText().toString());
                        parameters.put("password", password.getText().toString());
                        parameters.put("birthdate",birthdate.getText().toString());
                        parameters.put("gender",   gender.getText().toString());

                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });

    }
}




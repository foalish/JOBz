package com.david.jobz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText name, pass;
    Button insert, link_to_signup;
    RequestQueue requestQueue;
    String insertUrl = "http://217.199.187.199/robswebdevelopercourse.com/social_network/insertUser.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button orderButton = (Button)findViewById(R.id.link_to_signup);

            link_to_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this,Chat_sign_up.class);
                startActivity(intent);
            }
        });








        name =  (EditText) findViewById(R.id.inputUsername);
        pass =  (EditText) findViewById(R.id.inputPassword);
        //    insert   = (Button)    findViewById(R.id.takemetochat);
        //    insert   = (Button)    findViewById(R.id.jobsbutton);
        insert   = (Button)    findViewById(R.id.insert);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

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

                        parameters.put("name", name.getText().toString());
                        parameters.put("pass", pass.getText().toString());
                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });


    }
}
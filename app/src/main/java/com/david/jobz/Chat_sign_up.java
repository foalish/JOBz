package com.david.jobz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Chat_sign_up extends AppCompatActivity {

    EditText email;
    EditText name;
    EditText pass;
    EditText birthdate;
    Switch gender;
    Button insert, link_to_login, sign_up;
    TextView result;
    RequestQueue requestQueue;
    String insertUrl = "http://217.199.187.199/robswebdevelopercourse.com/social_network/insertUser.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_sign_up);

        Button orderButton = (Button)findViewById(R.id.sign_up);
        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent( Chat_sign_up.this, ChatActivity.class );
                startActivity( intent );
    }
      });

        email           =  (EditText) findViewById(R.id.inputEmail);
        name            =  (EditText) findViewById(R.id.inputUsername);
        pass            =  (EditText) findViewById(R.id.inputPassword);
        birthdate       =  (EditText) findViewById(R.id.inputBirthdate);
       //   gender    =  (Switch)   findViewById(R.id.inputGender);
        insert          =  (Button)   findViewById(R.id.insert);
        link_to_login   =  (Button)   findViewById(R.id.link_to_login);
        sign_up         =  (Button)   findViewById(R.id.sign_up);

        result          =  (TextView) findViewById(R.id.email_label );

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
                        parameters.put("email",    email.getText().toString());
                        parameters.put("name",     name.getText().toString());
                        parameters.put("pass",     pass.getText().toString());
                        parameters.put("birthdate",birthdate.getText().toString());
                        parameters.put("gender",   gender.getText().toString());
                        return parameters;
                     }
                };
                requestQueue.add(request);

                Intent intent = new Intent( Chat_sign_up.this, ChatActivity.class );
                startActivity( intent );
            }
        });

        link_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  Intent intent = new Intent( Chat_sign_up.this, LoginActivity.class );
                    startActivity( intent );
                }
             });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( Chat_sign_up.this, ChatActivity.class );
                startActivity( intent );
            }
        });



    }
}





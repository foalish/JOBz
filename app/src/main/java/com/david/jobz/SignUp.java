// package com.david.jobz;

 // public class SignUp extends Activity {

    // Progress Dialog
//    private ProgressDialog pDialog;

 //   JSONParser jsonParser = new JSONParser();
//    EditText inputUsername;
 //   EditText inputPassword;
 //   EditText inputEmail;
 //   EditText inputGender;
 //   EditText inputBirthdate;



    // url to create new product
 //   private static String url_create_product = "http://api.androidhive.info/android_connect/create_product.php";

    // JSON Node names
 //   private static final String TAG_SUCCESS = "success";

  //  @Override
 //   public void onCreate(Bundle savedInstanceState) {
  //      super.onCreate(savedInstanceState);
 //       setContentView(R.layout.add_product);

        // Edit Text
 //       inputEmail = (EditText) findViewById(R.id.inputEmail);
 //       inputUsername = (EditText) findViewById(R.id.inputUsername);
 //       inputPassword = (EditText) findViewById(R.id.inputPassword);
 //       inputBirthdate = (EditText) findViewById(R.id.inputBirthdate);
 //       inputGender = (EditText) findViewById(R.id.inputGender);

        // Create button
  //      Button btnSignUp = (Button) findViewById(R.id.takemetochat);

        // button click event
  //      btnSignUp.setOnClickListener(new View.OnClickListener() {

  //          @Override
  //          public void onClick(View view) {
                // creating new product in background thread
 //               new CreateNewProduct().execute();
 //           }
 //        });
 //    }

    /**
     * Background Async Task to Create new product
     * */
//    class CreateNewProduct extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
 //       @Override
  //      protected void onPreExecute() {
  //          super.onPreExecute();
  //          pDialog = new ProgressDialog(NewProductActivity.this);
  //          pDialog.setMessage("Creating User..");
  //          pDialog.setIndeterminate(false);
  //          pDialog.setCancelable(true);
  //          pDialog.show();
  //      }

        /**
         * Creating product
         * */
  //      protected String doInBackground(String... args) {
   //         String price     = inputUsername.getText().toString();
  //          String name      = inputEmail.getText().toString();
  //          String password  = inputPassword.getText().toString();
  //          String birthdate = inputBirthdate.getText().toString();
  //          String gender    = inputGender.getText().toString();

            // Building Parameters
  //          List params = new ArrayList();
 //           params.add(new ("username", name));
 //           params.add(new ("email", price));
 //           params.add(new ("password", password));

            // getting JSON Object
            // Note that create product url accepts POST method
 //           JSONObject json = jsonParser.makeHttpRequest(url_create_product,
 //                   "POST", params);

            // check log cat fro response
 //           Log.d("Create Response", json.toString());

            // check for success tag
  //          try {
  //              int success = json.getInt(TAG_SUCCESS);

    //            if (success == 1) {
                    // successfully created product
  //                  Intent i = new Intent(getApplicationContext(), AllProductsActivity.class);
   //               startActivity(i);

                    // closing this screen
   //                finish();
   //             } else {
                    // failed to create product
 //               }
 //           } catch (JSONException e) {
 //               e.printStackTrace();
 //           }

//            return null;
 //       }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
  //      protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
  //           pDialog.dismiss();
 //       }

//    }}

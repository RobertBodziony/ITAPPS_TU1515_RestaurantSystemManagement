package pl_200204.wroc.pwr.student.itapps_project;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Keczaps on 2016-04-06.
 */
public class WelcomeActivity extends AppCompatActivity {

    ImageView welcomeIMG;
    Button standard_menu,create_pizza;
    int counter = 0;
    ShoppingCart shoppingCart = new ShoppingCart();

    private ProgressDialog pDialog;
    JSONParser jParser = new JSONParser();

    private static String url_all_types = "http://192.168.0.100/itapps/get_all.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCTS = "products";
    private static final String TAG_TYPE = "type";
    private static final String TAG_NAME = "name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_DESC = "description";

    JSONArray products = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        standard_menu = (Button) findViewById(R.id.standard_menu);
        create_pizza = (Button) findViewById(R.id.create_pizza);
        welcomeIMG = (ImageView) findViewById(R.id.welcome_img);

        new LoadAllProducts().execute();

        welcomeIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(counter == 5){

                    Toast toast = Toast.makeText(getApplicationContext(), "Yes, you've clicked here 5 times. Sorry, this functionality is not available yet.", Toast.LENGTH_SHORT);
                    toast.show();
                    counter = 0;
                }
            }
        });

        standard_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                intent.setClass(getApplicationContext(), TypesActivity.class);

                startActivity(intent);
            }
        });

        create_pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                intent.setClass(getApplicationContext(),CreateNewPizza.class);

                startActivity(intent);

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shoppingList = "";
                if(shoppingCart.getShoppingList().isEmpty()) {
                    shoppingList = "Your shopping list is empty.";

                } else {
                    shoppingList = "";
                    for(int i=0;i<shoppingCart.getShoppingList().size();i++) {
                        shoppingList = shoppingList + shoppingCart.getShoppingList().get(i);
                    }}
                Snackbar.make(view, shoppingList, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    class LoadAllProducts extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(WelcomeActivity.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        
        protected String doInBackground(String... args) {

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            JSONObject json = jParser.makeHttpRequest(url_all_types, "GET", params);

            Log.d("All Products: ", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    products = json.getJSONArray(TAG_PRODUCTS);
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject c = products.getJSONObject(i);

                        String type = c.getString(TAG_TYPE);
                        String name = c.getString(TAG_NAME);
                        String price = c.getString(TAG_PRICE);
                        String desc = c.getString(TAG_DESC);

                        if(MealInfo.TYPES.isEmpty()) {
                            MealInfo.TYPES.add("PIZZA");
                            MealInfo.TYPES.add("PASTA");
                            MealInfo.TYPES.add("SALADS");
                            MealInfo.TYPES.add("DRINKS");
                        }

                        switch(type){
                            case "PIZZA":
                                MealInfo.PIZZA_NAMESL.add(name);
                                MealInfo.PIZZA_DESCL.add(desc);
                                MealInfo.PIZZA_PRICEL.add(price);
                                break;
                            case "PASTA":
                                MealInfo.PASTA_NAMESL.add(name);
                                MealInfo.PASTA_DESCL.add(desc);
                                MealInfo.PASTA_PRICEL.add(price);
                                break;
                            case "SALAD":
                                MealInfo.SALAD_NAMESL.add(name);
                                MealInfo.SALAD_DESCL.add(desc);
                                MealInfo.SALAD_PRICEL.add(price);
                                break;
                            case "DRINK":
                                MealInfo.DRINK_NAMESL.add(name);
                                MealInfo.DRINK_DESCL.add(desc);
                                MealInfo.DRINK_PRICEL.add(price);
                                break;
                        }



                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            pDialog.dismiss();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.infomenuitem) {
            Toast toast = Toast.makeText(getApplicationContext(), "This app is made for ITapps project purpose." +
                    " \n You can contact us by emails: \n robertbodziony93@gmail.com \n 200204@student.pwr.edu.pl", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
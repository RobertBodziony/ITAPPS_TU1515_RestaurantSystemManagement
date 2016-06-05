package pl_200204.wroc.pwr.student.itapps_project;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keczaps on 2016-04-13.
 */
public class ShoppingCart extends Activity {

    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    public static String ipaddress;

    private static String url_create_product;

    private static final String TAG_SUCCESS = "success";
    String orderName = "", orderDesc = "";
    float orderPrice = 0;
    Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_layout);

        orderButton = (Button) findViewById(R.id.make_order);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < MealInfo.SHOPPING_CARD_NAME.size(); i++) {
                    orderName = MealInfo.SHOPPING_CARD_SIZE.get(i) + " " + MealInfo.SHOPPING_CARD_NAME.get(i);
                    orderPrice = Float.parseFloat(MealInfo.SHOPPING_CARD_PRICE.get(i).substring(0, 5));
                    orderDesc = MealInfo.SHOPPING_CARD_DESC.get(i);
                    ipaddress = "192.168.0.100";
                    url_create_product = "http://" + ipaddress + "/itapps/create_product.php";
                    new CreateNewProduct().execute(orderName, Float.toString(orderPrice), orderDesc, Integer.toString(MealInfo.TABLE_NO));
                    pDialog.dismiss();
                }
                pDialog.dismiss();

            }
        });

    }

    public ShoppingCart() {
    }

    public List<String> getShoppingList() {
        return MealInfo.SHOPPING_CARD_NAME;
    }

    public void addToList(String name, String description, String price, String size) {
        int counter = 0;

        for (int i = 0; i < MealInfo.SHOPPING_CARD_NAME.size(); i++) {
            if (MealInfo.SHOPPING_CARD_NAME.get(i).equals(name)) {
                counter++;
            }
        }
        MealInfo.SHOPPING_CARD_NAME.add(name);
        MealInfo.SHOPPING_CARD_DESC.add(description);
        MealInfo.SHOPPING_CARD_PRICE.add(price);
        MealInfo.SHOPPING_CARD_SIZE.add(size);

    }

    public int removeFromList(int id) {

        MealInfo.SHOPPING_CARD_NAME.remove(id);
        MealInfo.SHOPPING_CARD_DESC.remove(id);
        MealInfo.SHOPPING_CARD_PRICE.remove(id);
        MealInfo.SHOPPING_CARD_SIZE.remove(id);

        return 1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.infomenuitem) {
            Toast toast = Toast.makeText(getApplicationContext(), "This app is made for ITapps project purpose." +
                    " \n You can contact us by emails: \n robertbodziony93@gmail.com \n 200204@student.pwr.edu.pl", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    class CreateNewProduct extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ShoppingCart.this);
            pDialog.setMessage("Creating Product..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        protected String doInBackground(String... args) {

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", args[0]));
            params.add(new BasicNameValuePair("price", args[1]));
            params.add(new BasicNameValuePair("description", args[2]));
            params.add(new BasicNameValuePair("table", args[3]));

            JSONObject json = jsonParser.makeHttpRequest(url_create_product,
                    "POST", params);


            Log.d("Create Response", json.toString());

            return null;
        }

        protected void onPostExecute(String file_url) {
            pDialog.dismiss();
        }

    }
}

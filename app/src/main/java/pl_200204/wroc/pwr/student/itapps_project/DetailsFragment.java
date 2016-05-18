package pl_200204.wroc.pwr.student.itapps_project;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keczaps on 2016-04-06.
 */
public class DetailsFragment extends Fragment {

    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    ImageView image;
    EditText inputName;
    EditText inputPrice;
    EditText ipaddr;
    EditText inputDesc;
    int index, whichType;
    public static String ipaddress;


    private static String url_create_product;

    private static final String TAG_SUCCESS = "success";

    TextView textViewName, textViewPrice, textViewDesc;
    ShoppingCart shoppingCart = new ShoppingCart();
    Button addToButton;

    public static DetailsFragment newInstance(int index, int whichType){

        DetailsFragment f = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index",index);
        args.putInt("whichType",whichType);
        f.setArguments(args);

        return f;

    }

    public int[] getShownIndex(){

        int[] tab = new int[2];
        tab[0] = getArguments().getInt("index",0);
        tab[1] = getArguments().getInt("whichType",0);

        return tab;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.details_fragment, container, false);

        textViewName = (TextView) view.findViewById(R.id.textName);
        textViewDesc = (TextView) view.findViewById(R.id.textDesc);
        textViewPrice = (TextView) view.findViewById(R.id.textPrice);
        addToButton = (Button) view.findViewById(R.id.addToCartButt);
        image = (ImageView) view.findViewById(R.id.details_image);

        switch (getShownIndex()[1]) {
            case 1:
                textViewName.setText(MealInfo.PIZZA_NAMESL.get(getShownIndex()[0]));
                textViewDesc.setText(MealInfo.PIZZA_DESCL.get(getShownIndex()[0]));
                textViewPrice.setText("Price: " + MealInfo.PIZZA_PRICEL.get(getShownIndex()[0]) + " PLN");
                image.setImageResource(R.drawable.pizzaimg);
                break;
            case 2:
                textViewName.setText(MealInfo.PASTA_NAMESL.get(getShownIndex()[0]));
                textViewDesc.setText(MealInfo.PASTA_DESCL.get(getShownIndex()[0]));
                textViewPrice.setText("Price: " + MealInfo.PASTA_PRICEL.get(getShownIndex()[0]) + " PLN");
                break;
            case 3:
                textViewName.setText(MealInfo.SALAD_NAMESL.get(getShownIndex()[0]));
                textViewDesc.setText(MealInfo.SALAD_DESCL.get(getShownIndex()[0]));
                textViewPrice.setText("Price: " + MealInfo.SALAD_PRICEL.get(getShownIndex()[0]) + " PLN");
                break;
            case 4:
                textViewName.setText(MealInfo.DRINK_NAMESL.get(getShownIndex()[0]));
                textViewDesc.setText(MealInfo.DRINK_DESCL.get(getShownIndex()[0]));
                textViewPrice.setText("Price: " + MealInfo.DRINK_PRICEL.get(getShownIndex()[0]) + " PLN");
                break;

        }
        addToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ipaddress = "192.168.0.100";
                String name = textViewName.getText().toString();
                String price = textViewPrice.getText().toString().substring(7);
                String description = textViewDesc.getText().toString();
                url_create_product = "http://"+ipaddress+"/itapps/create_product.php";
                new CreateNewProduct().execute(name, price, description);

            }
        });


        return view;
    }
    class CreateNewProduct extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
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

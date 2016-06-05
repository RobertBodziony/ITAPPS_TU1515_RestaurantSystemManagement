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
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    ImageView image;
    TextView textViewName, textViewPrice, textViewDesc;
    RadioGroup radioGroup;
    ShoppingCart shoppingCart = new ShoppingCart();
    Button addToButton;

    public static DetailsFragment newInstance(int index, int whichType, int fromWhere) {

        DetailsFragment f = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        args.putInt("whichType", whichType);
        args.putInt("fromWhere", fromWhere);
        f.setArguments(args);

        return f;

    }

    public int[] getShownIndex() {

        int[] tab = new int[3];
        tab[0] = getArguments().getInt("index", 0);
        tab[1] = getArguments().getInt("whichType", 0);
        tab[2] = getArguments().getInt("fromWhere", 0);

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
        radioGroup = (RadioGroup) view.findViewById(R.id.radioSize);
        if (getShownIndex()[2] == 2) {
            addToButton.setText("REMOVE FROM LIST");
        }

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
                image.setImageResource(R.drawable.pizzaimg);
                break;
            case 3:
                textViewName.setText(MealInfo.SALAD_NAMESL.get(getShownIndex()[0]));
                textViewDesc.setText(MealInfo.SALAD_DESCL.get(getShownIndex()[0]));
                textViewPrice.setText("Price: " + MealInfo.SALAD_PRICEL.get(getShownIndex()[0]) + " PLN");
                image.setImageResource(R.drawable.pizzaimg);
                break;
            case 4:
                textViewName.setText(MealInfo.DRINK_NAMESL.get(getShownIndex()[0]));
                textViewDesc.setText(MealInfo.DRINK_DESCL.get(getShownIndex()[0]));
                textViewPrice.setText("Price: " + MealInfo.DRINK_PRICEL.get(getShownIndex()[0]) + " PLN");
                image.setImageResource(R.drawable.pizzaimg);
                break;
            case 5:
                textViewName.setText(MealInfo.SHOPPING_CARD_NAME.get(getShownIndex()[0]));
                textViewDesc.setText(MealInfo.SHOPPING_CARD_DESC.get(getShownIndex()[0]));
                textViewPrice.setText("Price: " + MealInfo.SHOPPING_CARD_PRICE.get(getShownIndex()[0]) + " PLN");
                image.setImageResource(R.drawable.pizzaimg);
                break;
        }


        addToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = textViewName.getText().toString();
                String price = textViewPrice.getText().toString().substring(7);
                String description = textViewDesc.getText().toString();
                int IDsize = radioGroup.getCheckedRadioButtonId();
                RadioButton size = (RadioButton) radioGroup.findViewById(IDsize);
                if (getShownIndex()[2] == 1) {
                    shoppingCart.addToList(name, description, price, size.getText().toString());
                } else {
                    shoppingCart.removeFromList(getShownIndex()[0]);
                }
            }
        });


        return view;
    }

}

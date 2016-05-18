package pl_200204.wroc.pwr.student.itapps_project;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keczaps on 2016-04-25.
 */
public class CreateNewPizza extends Activity {

    CheckBox mozarellacheck,tomatosaucecheck,salamicheck,hamcheck,mushroomscheck,tomatoescheck;
    List<CheckBox> standardCheckbox = new ArrayList<>();
    List<CheckBox> meatCheckbox = new ArrayList<>();
    List<CheckBox> vegeCheckbox = new ArrayList<>();
    EditText nameEdit;
    int priceCounter = 5,counter = 0;
    Button addPizza;
    String desc="",name="CREATED PIZZA",price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_pizza);
        setTheme(R.style.AppTheme);

        mozarellacheck = (CheckBox) findViewById(R.id.mozarellaCheckBox);
        tomatosaucecheck = (CheckBox) findViewById(R.id.sauceCheckBox);
        salamicheck = (CheckBox) findViewById(R.id.salamiCheckBox);
        hamcheck = (CheckBox) findViewById(R.id.hamCheckBox);
        mushroomscheck = (CheckBox) findViewById(R.id.mushroomsCheckBox);
        tomatoescheck = (CheckBox) findViewById(R.id.tomatoesCheckBox);
        addPizza = (Button) findViewById(R.id.add_pizza);
        nameEdit = (EditText) findViewById(R.id.pizza_name);

        standardCheckbox.add(mozarellacheck);
        standardCheckbox.add(tomatosaucecheck);

        meatCheckbox.add(salamicheck);
        meatCheckbox.add(hamcheck);

        vegeCheckbox.add(mushroomscheck);
        vegeCheckbox.add(tomatoescheck);

        addPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (counter == 0) {
                    for (int i = 0; i < standardCheckbox.size(); i++) {
                        if (standardCheckbox.get(i).isChecked()) {
                            desc = desc + standardCheckbox.get(i).getText() + ", ";
                            priceCounter = priceCounter + 2;
                        }
                    }


                for (int i = 0; i < meatCheckbox.size(); i++) {
                    if (meatCheckbox.get(i).isChecked()) {
                        desc = desc + meatCheckbox.get(i).getText() + ", ";
                        priceCounter = priceCounter + 4;
                    }
                }


                for (int i = 0; i < vegeCheckbox.size(); i++) {
                    if (vegeCheckbox.get(i).isChecked()) {
                        desc = desc + vegeCheckbox.get(i).getText() + ", ";
                        priceCounter = priceCounter + 3;
                    }
                }

                if (nameEdit.getText().length() != 0) {
                    name = nameEdit.getText().toString();
                }

                price = Integer.toString(priceCounter);

                MealInfo.PIZZA_NAMESL.add(name.toUpperCase());
                MealInfo.PIZZA_DESCL.add(desc.substring(0, desc.length() - 2));
                MealInfo.PIZZA_PRICEL.add(price);

                    Toast.makeText(getApplicationContext(),"Pizza successfully added to menu. If you" +
                            " want order it, go to \"STANDARD MENU\"->\"PIZZA\" and find the name of created pizza.",Toast.LENGTH_SHORT).show();
                counter++;
                if (counter == 2) counter = 0;
            } else {
                    Toast.makeText(getApplicationContext(),"This pizza is already in menu, because " +
                            "you've added it when you've clicked \"ADD PIZZA\" button. If you're sure " +
                            "that you want to add it again, click the button again.",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}

package pl_200204.wroc.pwr.student.itapps_project;

/**
 * Created by Keczaps on 2016-05-17.
 */


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TypesActivity extends AppCompatActivity {

    ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.types_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shoppingList = "";
                if (shoppingCart.getShoppingList().isEmpty()) {
                    shoppingList = "Your shopping list is empty.";
                } else {
                    shoppingList = "";
                    for (int i = 0; i < shoppingCart.getShoppingList().size(); i++) {
                        shoppingList = shoppingList + shoppingCart.getShoppingList().get(i);
                    }
                }
                Snackbar.make(view, shoppingList, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
}

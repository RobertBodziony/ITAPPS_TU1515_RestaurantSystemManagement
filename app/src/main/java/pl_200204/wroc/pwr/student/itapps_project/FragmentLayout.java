package pl_200204.wroc.pwr.student.itapps_project;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentLayout extends AppCompatActivity {

    ShoppingCart shoppingCart = new ShoppingCart();
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);

        Intent intent = getIntent();
        s = Integer.toString(intent.getIntExtra("indexOfType", 1));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shoppingList = "";
                if (shoppingCart.getShoppingList().isEmpty()) {
                    shoppingList = "Your shopping list is empty.";
                    Snackbar.make(view, shoppingList, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Intent intent = new Intent();

                    intent.setClass(getApplicationContext(), ShoppingCart.class);

                    startActivity(intent);
                }
            }
        });
    }

    public String getMyData() {
        return s;
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

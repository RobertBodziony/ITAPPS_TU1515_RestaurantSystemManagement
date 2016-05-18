package pl_200204.wroc.pwr.student.itapps_project;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MealInfo {

        //public static final String[] NAMES = new String[30];
        public static final List<String> TYPES = new ArrayList<String>();

        public static final List<String> PIZZA_NAMESL = new ArrayList<String>();
        public static final List<String> PIZZA_DESCL = new ArrayList<String>();
        public static final List<String> PIZZA_PRICEL = new ArrayList<String>();

        public static final List<String> PASTA_NAMESL = new ArrayList<String>();
        public static final List<String> PASTA_DESCL = new ArrayList<String>();
        public static final List<String> PASTA_PRICEL = new ArrayList<String>();

        public static final List<String> DRINK_NAMESL = new ArrayList<String>();
        public static final List<String> DRINK_DESCL = new ArrayList<String>();
        public static final List<String> DRINK_PRICEL = new ArrayList<String>();

        public static final List<String> SALAD_NAMESL = new ArrayList<String>();
        public static final List<String> SALAD_DESCL = new ArrayList<String>();
        public static final List<String> SALAD_PRICEL = new ArrayList<String>();

        public static final List<String> SHOPPING_CARD = new ArrayList<String>();


        public static final String[] PIZZA_NAMES =
            {
                    "ARIZONA",
                    "COLORADO",
                    "PIZZA",
                    "PIZZA",
                    "PIZZA",
                    "PIZZA"
            };

        public static final String[] PASTA_NAMES =
                {
                        "ARIZONA",
                        "COLORADO",
                        "PASTA",
                        "PASTA",
                        "PASTA",
                        "PASTA"

                };

        public static final String[] DRINK_NAMES =
                {
                        "DRINK",
                        "DRINK",
                        "DRINK",
                        "DRINK",
                        "DRINK",
                        "DRINK"


                };

        public static final String[] SALAT_NAMES =
                {
                        "SALAT",
                        "SALAT",
                        "SALAT",
                        "SALAT",
                        "SALAT",
                        "SALAT"

                };

        public static final String[] PIZZA_DESC =
            {
                    "Tomato sauce, Cheese, Oregano, Salami pepperoni.",
                    "Tomato sauce, Cheese, Oregano, Ham.",
                    "PIZZA",
                    "PIZZA",
                    "PIZZA",
                    "PIZZA",
                    "PIZZA"
                    /*"Tomato sauce, Cheese, Oregano, Salami pepperoni, Paprika.",
                    "Tomato sauce, Cheese, Oregano, Ham, Ananas.",
                    "Tomato sauce, Cheese, Oregano, Salami pepperoni, Paprika pepperoni, Mushrooms.",
                    "Tomato sauce, Cheese, Oregano, Mushrooms, Salami pepperoni, Tomato, Bacon.",*/
            };
        public static final String[] PASTA_DESC =
                {
                        "Tomato sauce, Cheese, Oregano, Salami pepperoni.",
                        "Tomato sauce, Cheese, Oregano, Ham.",
                        "pasta?",
                        "pasta?",
                        "pasta?",
                        "pasta?",
                        "pasta?"
                        /*"Tomato sauce, Cheese, Oregano, Chicken, Ananas.",
                        "Tomato sauce, Cheese, Oregano, Salami pepperoni, Paprika.",
                        "Tomato sauce, Cheese, Oregano, Ham, Ananas.",
                        "Tomato sauce, Cheese, Oregano, Salami pepperoni, Paprika pepperoni, Mushrooms.",
                        "Tomato sauce, Cheese, Oregano, Mushrooms, Salami pepperoni, Tomato, Bacon.",*/
                };
        public static final String[] DRINK_DESC =
                {
                        "COLADRINK?",
                        "COLADRINK?",
                        "COLADRINK?",
                        "COLADRINK?",
                        "COLADRINK?",
                        "COLADRINK?",
                        "COLADRINK?"

                };
        public static final String[] SALAT_DESC =
                {
                        "CRAZY SALAT?",
                        "CRAZY SALAT?",
                        "CRAZY SALAT?",
                        "CRAZY SALAT?",
                        "CRAZY SALAT?",
                        "CRAZY SALAT?",
                        "CRAZY SALAT?"

                };

        public static final float[] PIZZA_PRICE =
                {
                        15,
                        15,
                        20,
                        20,
                        25,
                        25,
                        25
                };

        public static final float[] PASTA_PRICE =
                {
                        15,
                        15,
                        20,
                        20,
                        25,
                        25,
                        25
                };

        public static final float[] DRINK_PRICE =
                {
                        15,
                        15,
                        20,
                        20,
                        25,
                        25,
                        25
                };

        public static final float[] SALAT_PRICE =
                {
                        15,
                        15,
                        20,
                        20,
                        25,
                        25,
                        25
                };

}
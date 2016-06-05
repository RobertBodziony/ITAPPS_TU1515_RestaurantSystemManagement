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

    public static final List<String> SHOPPING_CARD_NAME = new ArrayList<String>();
    public static final List<String> SHOPPING_CARD_DESC = new ArrayList<String>();
    public static final List<String> SHOPPING_CARD_PRICE = new ArrayList<String>();
    public static final List<String> SHOPPING_CARD_SIZE = new ArrayList<String>();


    public static final int TABLE_NO = 10;


}
package pl_200204.wroc.pwr.student.itapps_project;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBTools extends SQLiteOpenHelper {

    public DBTools(Context applicationcontext) {
        super(applicationcontext, "tablesANDpizzas.db", null, 1);
    }

    public void onCreate(SQLiteDatabase database) {
        String query = "CREATE TABLE tables ( tableNO INTEGER DEFAULT 1)";

        String query2 = "CREATE TABLE pizzas ( id INTEGER PRIMARY KEY, name TEXT, " +
                "description TEXT, price TEXT)";

        database.execSQL(query);
        database.execSQL(query2);

    }

    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query = "DROP TABLE IF EXISTS tables";

        database.execSQL(query);
        onCreate(database);
    }

    public void insertVal(HashMap<String, String> queryValues) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("tableNO", queryValues.get("tableNO"));
        database.insert("tables", null, values);

        database.close();
    }

    public int updateContact(HashMap<String, String> queryValues) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("tableNO", queryValues.get("tableNO"));
        // TO DO ARONOLMEN
        return database.update("tables", values,"contactId" + " = ?", new String[]{queryValues.get("contactId")});
    }

    public void deleteContact(String id) {

        SQLiteDatabase database = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM  tables where tableNO='" + id + "'";
        database.execSQL(deleteQuery);
    }

    public ArrayList<HashMap<String, String>> getAllContacts() {
        ArrayList<HashMap<String, String>> contactArrayList;

        contactArrayList = new ArrayList<HashMap<String, String>>();

        String selectQuery = "SELECT  * FROM tables";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> contactMap = new HashMap<String, String>();

                //contactMap.put("contactId", cursor.getString(0));


                contactArrayList.add(contactMap);
            } while (cursor.moveToNext()); // Move Cursor to the next row
        }

        // return contact list
        return contactArrayList;
    }

    public HashMap<String, String> getContactInfo(String id) {
        HashMap<String, String> contactMap = new HashMap<String, String>();

        // Open a database for reading only

        SQLiteDatabase database = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM contacts where contactId='" + id + "'";

        // rawQuery executes the query and returns the result as a Cursor

        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                contactMap.put("firstName", cursor.getString(1));
                contactMap.put("lastName", cursor.getString(2));
                contactMap.put("phoneNumber", cursor.getString(3));
                contactMap.put("emailAddress", cursor.getString(4));
                contactMap.put("homeAddress", cursor.getString(5));

            } while (cursor.moveToNext());
        }
        return contactMap;
    }
}
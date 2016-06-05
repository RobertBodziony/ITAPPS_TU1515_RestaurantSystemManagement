package pl_200204.wroc.pwr.student.itapps_project;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Keczaps on 2016-04-06.
 */
public class ShoppingCartFragment extends ListFragment {

    boolean mDuelPane;
    int mCurrCheckPosition = 0;
    int whichmealtype;
    ArrayAdapter<String> connectArrayToListView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        connectArrayToListView = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, MealInfo.SHOPPING_CARD_NAME);
        setListAdapter(connectArrayToListView);

        if (savedInstanceState != null) {
            mCurrCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("curChoice", mCurrCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    void showDetails(int index) {
        mCurrCheckPosition = index;
        int fromWhere = 2;
        whichmealtype = 5;

        Intent intent = new Intent();

        intent.setClass(getActivity(), DetailsActivity.class);

        intent.putExtra("index", index);
        intent.putExtra("whichType", whichmealtype);
        intent.putExtra("fromWhere", fromWhere);

        startActivity(intent);
    }
}
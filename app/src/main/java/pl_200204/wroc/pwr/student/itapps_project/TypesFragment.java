package pl_200204.wroc.pwr.student.itapps_project;

/**
 * Created by Keczaps on 2016-05-17.
 */

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TypesFragment extends ListFragment {

    int mCurrCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,MealInfo.TYPES);

        setListAdapter(connectArrayToListView);

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

    void showDetails(int index){
        mCurrCheckPosition = index;

            Intent intent = new Intent();

            intent.putExtra("indexOfType",index);

            intent.setClass(getActivity(), FragmentLayout.class);

            startActivity(intent);

    }
}



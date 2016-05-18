package pl_200204.wroc.pwr.student.itapps_project;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Keczaps on 2016-04-06.
 */
public class TitlesFragment extends ListFragment{

    boolean mDuelPane;
    int mCurrCheckPosition = 0;
    int whichmealtype;
    ArrayAdapter<String> connectArrayToListView;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentLayout activity = (FragmentLayout) getActivity();
        whichmealtype = Integer.parseInt(activity.getMyData())+1;

        switch (whichmealtype) {
            case 1:
                connectArrayToListView = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_activated_1, MealInfo.PIZZA_NAMESL);
                setListAdapter(connectArrayToListView);
                break;
            case 2:
                connectArrayToListView = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_activated_1, MealInfo.PASTA_NAMESL);
                setListAdapter(connectArrayToListView);
                break;
            case 3:
                connectArrayToListView = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_activated_1, MealInfo.SALAD_NAMESL);
                setListAdapter(connectArrayToListView);
                break;
            case 4:
                connectArrayToListView = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_activated_1, MealInfo.DRINK_NAMESL);
                setListAdapter(connectArrayToListView);
                break;
        }


        View detailsFrame = getActivity().findViewById(R.id.details);

        mDuelPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if(savedInstanceState != null) {
            mCurrCheckPosition = savedInstanceState.getInt("curChoice",0);
        }

        if(mDuelPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurrCheckPosition);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("curChoice",mCurrCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    void showDetails(int index){
        mCurrCheckPosition = index;


        if(mDuelPane){

            getListView().setItemChecked(index,true);

            DetailsFragment detailsFragment = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);

            if (detailsFragment == null || detailsFragment.getShownIndex()[0] != index) {

                detailsFragment = DetailsFragment.newInstance(index,whichmealtype);

                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.details,detailsFragment);

                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                ft.commit();
            }
        } else {

                Intent intent = new Intent();

                intent.setClass(getActivity(), DetailsActivity.class);

                intent.putExtra("index", index);
                intent.putExtra("whichType",whichmealtype);

                startActivity(intent);

            }

        }
}


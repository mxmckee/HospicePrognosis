package edu.ualr.mxmckee.hospiceprognosis;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {


    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_result, container, false);

        float HPEScore = getArguments().getFloat("final_score");
        TextView prognosisTextView = view.findViewById(R.id.prognosis);
        String prognosis;

        if (HPEScore < 9) {
            prognosis = "Weeks to months";
            //prognosisTextView.setTextColor(getResources().getColor(R.color.prognosisColorGreen, null));
        }
        else if (HPEScore >= 9 && HPEScore < 22) {
            prognosis = "Days to weeks";
            //prognosisTextView.setTextColor(getResources().getColor(R.color.prognosisColorYellow, null));
        }
        else {
            prognosis = "Hours to days";
            //prognosisTextView.setTextColor(getResources().getColor(R.color.prognosisColorRed, null));
        }

        prognosisTextView.setText(String.format("%s", prognosis));

        return view;
    }

}

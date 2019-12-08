package edu.ualr.mxmckee.hospiceprognosis.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.ualr.mxmckee.hospiceprognosis.R;
import edu.ualr.mxmckee.hospiceprognosis.activities.MainActivity;
import edu.ualr.mxmckee.hospiceprognosis.fragments.MainMenuFragment;
import edu.ualr.mxmckee.hospiceprognosis.models.Prognosis;


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

        int HPEScore = getArguments().getInt("final_score");
        TextView prognosisHeaderTextView = view.findViewById(R.id.prognosis_header);
        TextView prognosisTextView = view.findViewById(R.id.prognosis);
        final String prognosis;

        if (HPEScore < 9) {
            prognosis = "Weeks to months";
            prognosisTextView.setTextColor(getResources().getColor(R.color.prognosisColorGreen, null));
        }
        else if (HPEScore >= 9 && HPEScore < 22) {
            prognosis = "Days to weeks";
            prognosisTextView.setTextColor(getResources().getColor(R.color.prognosisColorYellow, null));
        }
        else {
            prognosis = "Hours to days";
            prognosisTextView.setTextColor(getResources().getColor(R.color.prognosisColorRed, null));
        }

        prognosisHeaderTextView.setText(String.format("Based on the provided symptoms and vital sign information, you have been assigned a hospice prognostic estimation score (HPES) of %d. Such a score corresponds to a prognosis of:", HPEScore));
        prognosisTextView.setText(String.format("%s", prognosis));

        MaterialButton saveButton = view.findViewById(R.id.save_button);
        MaterialButton discardButton = view.findViewById(R.id.discard_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                int count = manager.getBackStackEntryCount();
                for (int i = 0; i < count; i++) {
                    manager.popBackStack();
                }

                int prognosisID = MainActivity.prognosisDatabase.prognosisDao().getCount() + 1;

                Date currDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String date = dateFormat.format(currDate);


                Prognosis currPrognosis = new Prognosis();
                currPrognosis.setPrognosisID(prognosisID);
                currPrognosis.setUsername(getArguments().getString("username"));
                currPrognosis.setDate(date);
                currPrognosis.setPrognosis(prognosis);

                MainActivity.prognosisDatabase.prognosisDao().addPrognosis(currPrognosis);

                MainMenuFragment mainMenuFragment = new MainMenuFragment();
                Bundle bundle = new Bundle();
                bundle.putString("username", getArguments().getString("username"));
                mainMenuFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mainMenuFragment, "main_menu")
                        .addToBackStack(null)
                        .commit();

                Toast.makeText(getActivity(), "Prognosis successfully saved.", Toast.LENGTH_SHORT).show();
            }
        });

        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                int count = manager.getBackStackEntryCount();
                for (int i = 0; i < count; i++) {
                    manager.popBackStack();
                }

                MainMenuFragment mainMenuFragment = new MainMenuFragment();
                Bundle bundle = new Bundle();
                bundle.putString("username", getArguments().getString("username"));
                mainMenuFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mainMenuFragment)
                        .addToBackStack(null)
                        .commit();

                Toast.makeText(getActivity(), "Prognosis discarded.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}

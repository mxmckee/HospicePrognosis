package edu.ualr.mxmckee.hospiceprognosis;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPrognosesFragment extends Fragment {

    public ViewPrognosesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_prognoses, container, false);

        TextView prognosesTextView = view.findViewById(R.id.prognoses);

        final String username = getArguments().getString("username");
        List<Prognosis> prognosisList = MainActivity.prognosisDatabase.prognosisDao().getAllPrognoses(getArguments().getString("username"));

        if (prognosisList.isEmpty()) {
            prognosesTextView.setText("No historical prognoses.");
        }
        else {
            String prognosisInformation = "";
            int count = 0;
            for (Prognosis prognosisListItem : prognosisList) {
                String currDate = prognosisListItem.getDate();
                String currPrognosis = prognosisListItem.getPrognosis();

                String gap;
                if (count != 0) {
                    gap = "\n\n";
                }
                else {
                    gap = "";
                }

                prognosisInformation = prognosisInformation + gap + "Date: " + currDate + "\nPrognosis: " + currPrognosis;

                count += 1;
            }

            prognosesTextView.setText(prognosisInformation);
        }

        MaterialButton returnToMainMenuButton = view.findViewById(R.id.return_to_main_menu_button);
        returnToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.popBackStack();

                MainMenuFragment mainMenuFragment = new MainMenuFragment();
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                mainMenuFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mainMenuFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

}

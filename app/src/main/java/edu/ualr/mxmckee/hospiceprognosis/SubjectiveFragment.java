package edu.ualr.mxmckee.hospiceprognosis;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectiveFragment extends Fragment {

    public int initialHPE;

    public SubjectiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subjective, container, false);

        final MaterialCheckBox shortnessOfBreathCheckbox = view.findViewById(R.id.shortness_of_breath_checkbox);

        MaterialButton materialButton = view.findViewById(R.id.next_button);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*ObjectiveFragment objectiveFragment = new ObjectiveFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, objectiveFragment, "objective_data")
                        .addToBackStack(null)
                        .commit();*/

                initialHPE = 0;
                if (shortnessOfBreathCheckbox.isChecked()) {
                    initialHPE += 1;
                }

                ObjectiveFragment objectiveFragment = new ObjectiveFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("initial_score", initialHPE);
                objectiveFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, objectiveFragment, "objective_data")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}

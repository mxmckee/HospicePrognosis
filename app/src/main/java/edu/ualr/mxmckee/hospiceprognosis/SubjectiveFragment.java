package edu.ualr.mxmckee.hospiceprognosis;


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
        final MaterialCheckBox airwaySecretionsCheckbox = view.findViewById(R.id.airway_secretions_checkbox);
        final MaterialCheckBox agitationCheckbox = view.findViewById(R.id.agitation_checkbox);
        final MaterialCheckBox seizuresCheckbox = view.findViewById(R.id.seizures_checkbox);
        final MaterialCheckBox bleedingCheckbox = view.findViewById(R.id.bleeding_checkbox);
        final MaterialCheckBox mottlingOfExtremitiesCheckbox = view.findViewById(R.id.mottling_of_extremities_checkbox);
        final MaterialCheckBox confusionCheckbox = view.findViewById(R.id.confusion_checkbox);
        final MaterialCheckBox unableToGetOutOfBedCheckbox = view.findViewById(R.id.unable_to_get_out_of_bed_checkbox);
        final MaterialCheckBox apneaCheckbox = view.findViewById(R.id.apnea_checkbox);
        final MaterialCheckBox skinUlcerCheckbox = view.findViewById(R.id.skin_ulcer_checkbox);
        final MaterialCheckBox comatoseCheckbox = view.findViewById(R.id.comatose_checkbox);
        final MaterialCheckBox unableToSwallowPillsCheckbox = view.findViewById(R.id.unable_to_swallow_pills_checkbox);
        final MaterialCheckBox unableToSwallowLiquidsCheckbox = view.findViewById(R.id.unable_to_swallow_liquids_checkbox);
        final MaterialCheckBox minimalUrineOutputCheckbox = view.findViewById(R.id.minimal_urine_output_checkbox);
        final MaterialCheckBox unableToCommunicateCheckbox = view.findViewById(R.id.unable_to_communicate_checkbox);

        MaterialButton nextButton = view.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initialHPE = 0;
                if (shortnessOfBreathCheckbox.isChecked()) {
                    initialHPE += 1;
                }
                if (airwaySecretionsCheckbox.isChecked()) {
                    initialHPE += 2;
                }
                if (agitationCheckbox.isChecked()) {
                    initialHPE += 1;
                }
                if (seizuresCheckbox.isChecked()) {
                    initialHPE += 1;
                }
                if (bleedingCheckbox.isChecked()) {
                    initialHPE += 1;
                }
                if (mottlingOfExtremitiesCheckbox.isChecked()) {
                    initialHPE += 3;
                }
                if (confusionCheckbox.isChecked()) {
                    initialHPE += 1;
                }
                if (unableToGetOutOfBedCheckbox.isChecked()) {
                    initialHPE += 2;
                }
                if (apneaCheckbox.isChecked()) {
                    initialHPE += 3;
                }
                if (skinUlcerCheckbox.isChecked()) {
                    initialHPE += 2;
                }
                if (comatoseCheckbox.isChecked()) {
                    initialHPE += 3;
                }
                if (unableToSwallowPillsCheckbox.isChecked()) {
                    initialHPE += 1;
                }
                if (unableToSwallowLiquidsCheckbox.isChecked()) {
                    initialHPE += 1;
                }
                if (minimalUrineOutputCheckbox.isChecked()) {
                    initialHPE += 1;
                }
                if (unableToCommunicateCheckbox.isChecked()) {
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

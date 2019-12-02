package edu.ualr.mxmckee.hospiceprognosis;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectiveFragment extends Fragment {

    public float initialHPE;
    private ChipGroup chipGroup;

    public SubjectiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subjective, container, false);

        chipGroup = view.findViewById(R.id.chipGroup);

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
        addOrRemoveSymptom(shortnessOfBreathCheckbox);
        addOrRemoveSymptom(airwaySecretionsCheckbox);
        addOrRemoveSymptom(agitationCheckbox);
        addOrRemoveSymptom(seizuresCheckbox);
        addOrRemoveSymptom(bleedingCheckbox);
        addOrRemoveSymptom(mottlingOfExtremitiesCheckbox);
        addOrRemoveSymptom(confusionCheckbox);
        addOrRemoveSymptom(unableToGetOutOfBedCheckbox);
        addOrRemoveSymptom(apneaCheckbox);
        addOrRemoveSymptom(skinUlcerCheckbox);
        addOrRemoveSymptom(comatoseCheckbox);
        addOrRemoveSymptom(unableToSwallowPillsCheckbox);
        addOrRemoveSymptom(unableToSwallowLiquidsCheckbox);
        addOrRemoveSymptom(minimalUrineOutputCheckbox);
        addOrRemoveSymptom(unableToCommunicateCheckbox);

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
                bundle.putFloat("initial_score", initialHPE);
                objectiveFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, objectiveFragment, "objective_data")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    private void addOrRemoveSymptom(MaterialCheckBox checkBox) {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    addChipToChipGroup(compoundButton.getText().toString(), chipGroup);
                }
                else {
                    removeChipFromChipGroup(compoundButton.getText().toString(), chipGroup);
                }
            }
        });
    }

    private void addChipToChipGroup(String chipText, ChipGroup chipGroup) {
        Chip chip = new Chip(getContext(),null,R.attr.EntryChipStyle);
        chip.setText(chipText);
        chip.setTag(chipText);
        chipGroup.addView(chip);
    }

    private void removeChipFromChipGroup(String chipTag, ChipGroup chipGroup) {
        chipGroup.removeView(chipGroup.findViewWithTag(chipTag));
    }
}

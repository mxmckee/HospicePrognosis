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
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectiveFirstPageFragment extends Fragment {

    public int initialHPE;
    //private ChipGroup chipGroup;

    public SubjectiveFirstPageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subjective_first_page, container, false);

        //chipGroup = view.findViewById(R.id.chipGroup);

        final MaterialCheckBox shortnessOfBreathCheckbox = view.findViewById(R.id.shortness_of_breath_checkbox);
        final MaterialCheckBox agitationCheckbox = view.findViewById(R.id.agitation_checkbox);
        final MaterialCheckBox seizuresCheckbox = view.findViewById(R.id.seizures_checkbox);
        final MaterialCheckBox bleedingCheckbox = view.findViewById(R.id.bleeding_checkbox);
        final MaterialCheckBox confusionCheckbox = view.findViewById(R.id.confusion_checkbox);
        final MaterialCheckBox unableToSwallowPillsCheckbox = view.findViewById(R.id.unable_to_swallow_pills_checkbox);
        final MaterialCheckBox unableToSwallowLiquidsCheckbox = view.findViewById(R.id.unable_to_swallow_liquids_checkbox);
        final MaterialCheckBox minimalUrineOutputCheckbox = view.findViewById(R.id.minimal_urine_output_checkbox);
        final MaterialCheckBox unableToCommunicateCheckbox = view.findViewById(R.id.unable_to_communicate_checkbox);
        /*addOrRemoveSymptom(shortnessOfBreathCheckbox);
        addOrRemoveSymptom(agitationCheckbox);
        addOrRemoveSymptom(seizuresCheckbox);
        addOrRemoveSymptom(bleedingCheckbox);
        addOrRemoveSymptom(confusionCheckbox);
        addOrRemoveSymptom(unableToSwallowPillsCheckbox);
        addOrRemoveSymptom(unableToSwallowLiquidsCheckbox);
        addOrRemoveSymptom(minimalUrineOutputCheckbox);
        addOrRemoveSymptom(unableToCommunicateCheckbox);*/

        FloatingActionButton nextButton = view.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initialHPE = 0;
                if (shortnessOfBreathCheckbox.isChecked()) {
                    initialHPE += 1;
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
                if (confusionCheckbox.isChecked()) {
                    initialHPE += 1;
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

                SubjectiveSecondPageFragment subjectiveSecondPageFragment = new SubjectiveSecondPageFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("initial_score", initialHPE);
                subjectiveSecondPageFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, subjectiveSecondPageFragment, "subjective_data_second_page")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    /*private void addOrRemoveSymptom(MaterialCheckBox checkBox) {
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
    }*/
}

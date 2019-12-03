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
public class SubjectiveSecondPageFragment extends Fragment {

    public int tempHPE;
    //private ChipGroup chipGroup;

    public SubjectiveSecondPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subjective_second_page, container, false);

        //chipGroup = view.findViewById(R.id.chipGroup);

        final MaterialCheckBox airwaySecretionsCheckbox = view.findViewById(R.id.airway_secretions_checkbox);
        final MaterialCheckBox mottlingOfExtremitiesCheckbox = view.findViewById(R.id.mottling_of_extremities_checkbox);
        final MaterialCheckBox unableToGetOutOfBedCheckbox = view.findViewById(R.id.unable_to_get_out_of_bed_checkbox);
        final MaterialCheckBox apneaCheckbox = view.findViewById(R.id.apnea_checkbox);
        final MaterialCheckBox skinUlcerCheckbox = view.findViewById(R.id.skin_ulcer_checkbox);
        final MaterialCheckBox comatoseCheckbox = view.findViewById(R.id.comatose_checkbox);
        /*addOrRemoveSymptom(airwaySecretionsCheckbox);
        addOrRemoveSymptom(mottlingOfExtremitiesCheckbox);
        addOrRemoveSymptom(unableToGetOutOfBedCheckbox);
        addOrRemoveSymptom(apneaCheckbox);
        addOrRemoveSymptom(skinUlcerCheckbox);
        addOrRemoveSymptom(comatoseCheckbox);*/

        FloatingActionButton nextButton = view.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tempHPE = getArguments().getInt("initial_score");
                if (airwaySecretionsCheckbox.isChecked()) {
                    tempHPE += 2;
                }
                if (mottlingOfExtremitiesCheckbox.isChecked()) {
                    tempHPE += 3;
                }
                if (unableToGetOutOfBedCheckbox.isChecked()) {
                    tempHPE += 2;
                }
                if (apneaCheckbox.isChecked()) {
                    tempHPE += 3;
                }
                if (skinUlcerCheckbox.isChecked()) {
                    tempHPE += 2;
                }
                if (comatoseCheckbox.isChecked()) {
                    tempHPE += 3;
                }

                ObjectiveFragment objectiveFragment = new ObjectiveFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("temporary_score", tempHPE);
                objectiveFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, objectiveFragment, "objective_data")
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
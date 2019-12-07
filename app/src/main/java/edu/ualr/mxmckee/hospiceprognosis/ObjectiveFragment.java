package edu.ualr.mxmckee.hospiceprognosis;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectiveFragment extends Fragment {

    public int finalHPE;

    public ObjectiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_objective, container, false);

        final TextInputEditText temperatureEditText = view.findViewById(R.id.input_temperature);
        final TextInputEditText heartRateEditText = view.findViewById(R.id.input_heartRate);
        final TextInputEditText respiratoryRateEditText = view.findViewById(R.id.input_respiratoryRate);
        final TextInputEditText bloodPressureEditText = view.findViewById(R.id.input_bloodPressure);
        final TextInputEditText oxygenSaturationEditText = view.findViewById(R.id.input_oxygenSaturation);
        final TextInputEditText PPSEditText = view.findViewById(R.id.input_PPS);

        MaterialButton finishButton = view.findViewById(R.id.finish_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finalHPE = getArguments().getInt("initial_score");

                float temperature = Float.parseFloat(temperatureEditText.getText().toString());
                int heartRate = Integer.parseInt(heartRateEditText.getText().toString());
                int respiratoryRate = Integer.parseInt(respiratoryRateEditText.getText().toString());
                int bloodPressure = Integer.parseInt(bloodPressureEditText.getText().toString());
                int oxygenSaturation = Integer.parseInt(oxygenSaturationEditText.getText().toString());
                int PPS = Integer.parseInt(PPSEditText.getText().toString());

                if (temperature > 101) {
                    finalHPE += 2;
                }
                else {
                    finalHPE += 1;
                }
                if (heartRate > 120) {
                    finalHPE += 3;
                }
                else {
                    finalHPE += 1;
                }
                if (respiratoryRate > 35) {
                    finalHPE += 2;
                }
                else {
                    finalHPE += 1;
                }
                if (bloodPressure < 90) {
                    finalHPE += 3;
                }
                else {
                    finalHPE += 1;
                }
                if (oxygenSaturation < 90) {
                    finalHPE += 3;
                }
                else {
                    finalHPE += 1;
                }
                if (PPS < 20) {
                    finalHPE += 3;
                }
                else if (PPS < 30) {
                    finalHPE += 2;
                }
                else {
                    finalHPE += 1;
                }

                ResultFragment resultFragment = new ResultFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("final_score", finalHPE);
                resultFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, resultFragment, "result")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}

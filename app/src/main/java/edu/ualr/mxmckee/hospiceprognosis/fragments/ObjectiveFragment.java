package edu.ualr.mxmckee.hospiceprognosis.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import edu.ualr.mxmckee.hospiceprognosis.R;


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

                String temperatureText = temperatureEditText.getText().toString();
                String heartRateText = heartRateEditText.getText().toString();
                String respiratoryRateText = respiratoryRateEditText.getText().toString();
                String bloodPressureText = bloodPressureEditText.getText().toString();
                String oxygenSaturationText = oxygenSaturationEditText.getText().toString();
                String PPSText = PPSEditText.getText().toString();

                if (!temperatureText.matches("") && !heartRateText.matches("") && !respiratoryRateText.matches("") && !bloodPressureText.matches("") && !oxygenSaturationText.matches("") && !PPSText.matches("")) {

                    float temperature = Float.parseFloat(temperatureText);
                    int heartRate = Integer.parseInt(heartRateText);
                    int respiratoryRate = Integer.parseInt(respiratoryRateText);
                    int bloodPressure = Integer.parseInt(bloodPressureText);
                    int oxygenSaturation = Integer.parseInt(oxygenSaturationText);
                    int PPS = Integer.parseInt(PPSText);

                    finalHPE = getArguments().getInt("initial_score");
                    if (temperature > 101) {
                        finalHPE += 2;
                    } else {
                        finalHPE += 1;
                    }
                    if (heartRate > 120) {
                        finalHPE += 3;
                    } else {
                        finalHPE += 1;
                    }
                    if (respiratoryRate > 35) {
                        finalHPE += 2;
                    } else {
                        finalHPE += 1;
                    }
                    if (bloodPressure < 90) {
                        finalHPE += 3;
                    } else {
                        finalHPE += 1;
                    }
                    if (oxygenSaturation < 90) {
                        finalHPE += 3;
                    } else {
                        finalHPE += 1;
                    }
                    if (PPS < 20) {
                        finalHPE += 3;
                    } else if (PPS < 30) {
                        finalHPE += 2;
                    } else {
                        finalHPE += 1;
                    }

                    ResultFragment resultFragment = new ResultFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("final_score", finalHPE);
                    bundle.putString("username", getArguments().getString("username"));
                    resultFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, resultFragment, "result")
                            .addToBackStack(null)
                            .commit();
                }
                else {

                    Toast.makeText(getActivity(), "All fields must be populated.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}

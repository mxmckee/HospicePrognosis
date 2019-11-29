package edu.ualr.mxmckee.hospiceprognosis;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment implements View.OnClickListener {

    private MaterialButton getPrognosisButton;

    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        getPrognosisButton = view.findViewById(R.id.get_prognosis_button);
        getPrognosisButton.setText(getArguments().getString("USERNAME"));
        getPrognosisButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_prognosis_button:
                GetPrognosisActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SubjectiveFragment()).addToBackStack(null).commit();
                break;
        }
    }
}

package edu.ualr.mxmckee.hospiceprognosis;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;


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

        final MaterialButton materialButton = view.findViewById(R.id.last_button);
        materialButton.setText(String.valueOf(getArguments().getInt("initial_score")));
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Change this to display results
                MainMenuFragment mainMenuFragment = new MainMenuFragment();
                Bundle bundle = new Bundle();
                finalHPE = getArguments().getInt("initial_score");
                bundle.putInt("final_score", finalHPE);
                mainMenuFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mainMenuFragment, "main_menu")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}

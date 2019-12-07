package edu.ualr.mxmckee.hospiceprognosis;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment implements View.OnClickListener {

    private MaterialButton getPrognosisButton;
    private MaterialButton deleteAccountButton;

    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        getPrognosisButton = view.findViewById(R.id.get_prognosis_button);
        getPrognosisButton.setOnClickListener(this);
        deleteAccountButton = view.findViewById(R.id.delete_account_button);
        deleteAccountButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_prognosis_button:
                PrognosisActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SubjectiveFragment(), "subjective_data").addToBackStack(null).commit();
                break;
            case R.id.delete_account_button:
                User user = new User();
                user.setUsername(getArguments().getString("username"));
                MainActivity.userDatabase.userDao().deleteUser(user);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Account successfully deleted.", Toast.LENGTH_SHORT).show();
                getActivity().finish();
        }
    }
}

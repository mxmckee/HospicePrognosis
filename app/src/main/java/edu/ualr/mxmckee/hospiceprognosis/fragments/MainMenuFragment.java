package edu.ualr.mxmckee.hospiceprognosis.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import edu.ualr.mxmckee.hospiceprognosis.R;
import edu.ualr.mxmckee.hospiceprognosis.models.User;
import edu.ualr.mxmckee.hospiceprognosis.activities.MainActivity;
import edu.ualr.mxmckee.hospiceprognosis.activities.PrognosisActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment implements View.OnClickListener {

    private MaterialButton getPrognosisButton;
    private MaterialButton viewPrognosesButton;
    private MaterialButton clearPrognosisHistoryButton;
    private MaterialButton viewUpdateProfileButton;
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
        viewPrognosesButton = view.findViewById(R.id.view_prognoses_button);
        viewPrognosesButton.setOnClickListener(this);
        clearPrognosisHistoryButton = view.findViewById(R.id.clear_prognosis_history_button);
        clearPrognosisHistoryButton.setOnClickListener(this);
        viewUpdateProfileButton = view.findViewById(R.id.view_update_profile_button);
        viewUpdateProfileButton.setOnClickListener(this);
        deleteAccountButton = view.findViewById(R.id.delete_account_button);
        deleteAccountButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        Bundle bundle = new Bundle();
        bundle.putString("username", getArguments().getString("username"));

        switch (view.getId()) {
            case R.id.get_prognosis_button:
                SubjectiveFragment subjectiveFragment = new SubjectiveFragment();
                subjectiveFragment.setArguments(bundle);
                PrognosisActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, subjectiveFragment, "subjective_data").addToBackStack(null).commit();
                break;
            case R.id.view_prognoses_button:
                ViewPrognosesFragment viewPrognosesFragment = new ViewPrognosesFragment();
                viewPrognosesFragment.setArguments(bundle);
                PrognosisActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, viewPrognosesFragment, "prognosis_history").addToBackStack(null).commit();
                break;
            case R.id.clear_prognosis_history_button:
                MainActivity.prognosisDatabase.prognosisDao().clearPrognoses(getArguments().getString("username"));
                Toast.makeText(getActivity(), "Prognosis history successfully cleared.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_update_profile_button:
                UpdateProfileFragment updateProfileFragment = new UpdateProfileFragment();
                updateProfileFragment.setArguments(bundle);
                PrognosisActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, updateProfileFragment, "update_profile").addToBackStack(null).commit();
                break;
            case R.id.delete_account_button:
                MainActivity.prognosisDatabase.prognosisDao().clearPrognoses(getArguments().getString("username"));
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

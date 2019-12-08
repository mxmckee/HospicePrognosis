package edu.ualr.mxmckee.hospiceprognosis.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import edu.ualr.mxmckee.hospiceprognosis.R;
import edu.ualr.mxmckee.hospiceprognosis.activities.MainActivity;
import edu.ualr.mxmckee.hospiceprognosis.activities.PrognosisActivity;
import edu.ualr.mxmckee.hospiceprognosis.models.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateProfileFragment extends Fragment {

    private TextInputEditText usernameEditText, passwordEditText, nameEditText, emailEditText, securityQuestionEditText, answerEditText;
    private MaterialButton updateButton, returnToMainMenuButton;

    public UpdateProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_update_profile, container, false);

        usernameEditText = view.findViewById(R.id.input_username);
        passwordEditText = view.findViewById(R.id.input_password);
        nameEditText = view.findViewById(R.id.input_name);
        emailEditText = view.findViewById(R.id.input_email);
        securityQuestionEditText = view.findViewById(R.id.input_securityQuestion);
        answerEditText = view.findViewById(R.id.input_securityAnswer);
        updateButton = view.findViewById(R.id.update_button);
        returnToMainMenuButton = view.findViewById(R.id.return_to_main_menu_button);

        User user = MainActivity.userDatabase.userDao().getUser(getArguments().getString("username"));

        usernameEditText.setText(user.getUsername());
        usernameEditText.setEnabled(false);
        passwordEditText.setText(user.getPassword());
        nameEditText.setText(user.getName());
        emailEditText.setText(user.getEmail());
        securityQuestionEditText.setText(user.getSecurityQuestion());
        answerEditText.setText(user.getSecurityAnswer());

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = passwordEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String securityQuestion = securityQuestionEditText.getText().toString();
                String securityAnswer = answerEditText.getText().toString();

                if (!password.matches("") && !name.matches("") && !email.matches("") && !securityQuestion.matches("") && !securityAnswer.matches("")) {

                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    manager.popBackStack();

                    User currUser = MainActivity.userDatabase.userDao().getUser(getArguments().getString("username"));
                    User updatedUser = currUser;
                    updatedUser.setPassword(password);
                    updatedUser.setName(name);
                    updatedUser.setEmail(email);
                    updatedUser.setSecurityQuestion(securityQuestion);
                    updatedUser.setSecurityAnswer(securityAnswer);

                    MainActivity.userDatabase.userDao().deleteUser(currUser);
                    MainActivity.userDatabase.userDao().addUser(updatedUser);

                    MainMenuFragment mainMenuFragment = new MainMenuFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", getArguments().getString("username"));
                    mainMenuFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, mainMenuFragment, "main_menu")
                            .addToBackStack(null)
                            .commit();

                    Toast.makeText(getActivity(), "Profile successfully updated.", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(getActivity(), "All fields must be populated.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        returnToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainMenuFragment mainMenuFragment = new MainMenuFragment();
                Bundle bundle = new Bundle();
                bundle.putString("username", getArguments().getString("username"));
                mainMenuFragment.setArguments(bundle);
                PrognosisActivity.fragmentManager.beginTransaction().add(R.id.fragment_container, mainMenuFragment, "main_menu").commit();
            }
        });

        return view;
    }

}

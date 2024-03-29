package edu.ualr.mxmckee.hospiceprognosis.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import edu.ualr.mxmckee.hospiceprognosis.R;
import edu.ualr.mxmckee.hospiceprognosis.models.User;
import edu.ualr.mxmckee.hospiceprognosis.activities.MainActivity;
import edu.ualr.mxmckee.hospiceprognosis.activities.PrognosisActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private TextInputEditText usernameEditText, passwordEditText, nameEditText, emailEditText, securityQuestionEditText, answerEditText;
    private MaterialButton registerButton;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        usernameEditText = view.findViewById(R.id.input_username);
        passwordEditText = view.findViewById(R.id.input_password);
        nameEditText = view.findViewById(R.id.input_name);
        emailEditText = view.findViewById(R.id.input_email);
        securityQuestionEditText = view.findViewById(R.id.input_securityQuestion);
        answerEditText = view.findViewById(R.id.input_securityAnswer);
        registerButton = view.findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String securityQuestion = securityQuestionEditText.getText().toString();
                String answer = answerEditText.getText().toString();

                if (!username.matches("") && !password.matches("") && !name.matches("") && !email.matches("") && !securityQuestion.matches("") && !answer.matches("")) {

                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setName(name);
                    user.setEmail(email);
                    user.setSecurityQuestion(securityQuestion);
                    user.setSecurityAnswer(answer);

                    User testUser = MainActivity.userDatabase.userDao().getUser(username);

                    if (testUser == null) {
                        MainActivity.userDatabase.userDao().addUser(user);
                        Intent intent = new Intent(getActivity(), PrognosisActivity.class);
                        intent.putExtra("username", username);
                        startActivity(intent);
                        getActivity().finish();
                    } else {
                        Toast.makeText(getActivity(), "Username already exists.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {

                    Toast.makeText(getActivity(), "All fields must be populated.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}

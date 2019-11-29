package edu.ualr.mxmckee.hospiceprognosis;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


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

                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setName(name);
                user.setEmail(email);
                user.setSecurityQuestion(securityQuestion);
                user.setSecurityAnswer(answer);

                MainActivity.userDatabase.userDao().addUser(user);
                Toast.makeText(getActivity(), "User added successfully.", Toast.LENGTH_SHORT).show();

                usernameEditText.setText("");
                passwordEditText.setText("");
                nameEditText.setText("");
                emailEditText.setText("");
                securityQuestionEditText.setText("");
                answerEditText.setText("");


            }
        });

        return view;
    }

}

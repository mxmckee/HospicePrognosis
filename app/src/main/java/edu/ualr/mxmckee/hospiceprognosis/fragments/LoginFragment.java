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
import edu.ualr.mxmckee.hospiceprognosis.activities.ForgotPasswordActivity;
import edu.ualr.mxmckee.hospiceprognosis.activities.MainActivity;
import edu.ualr.mxmckee.hospiceprognosis.activities.PrognosisActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextInputEditText usernameEditText, passwordEditText;
    private MaterialButton loginButton;
    private MaterialButton forgotPasswordButton;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        usernameEditText = view.findViewById(R.id.input_username);
        passwordEditText = view.findViewById(R.id.input_password);
        loginButton = view.findViewById(R.id.login_button);
        forgotPasswordButton = view.findViewById(R.id.forgot_password_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                User user = MainActivity.userDatabase.userDao().verifyCredentials(username, password);

                if (user != null) {
                    Intent intent = new Intent(getActivity(), PrognosisActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    getActivity().finish();
                }
                else {
                    Toast.makeText(getActivity(), "Invalid credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ForgotPasswordActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

}

package edu.ualr.mxmckee.hospiceprognosis;


import android.content.Intent;
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
public class LoginFragment extends Fragment {

    private TextInputEditText usernameEditText, passwordEditText;
    private MaterialButton loginButton;

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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                User user = MainActivity.userDatabase.userDao().verifyCredentials(username, password);

                if (user != null) {
                    //Toast.makeText(getActivity(), "User logged in successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), GetPrognosisActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Invalid credentials.", Toast.LENGTH_SHORT).show();
                }

                usernameEditText.setText("");
                passwordEditText.setText("");
            }
        });

        return view;
    }

}

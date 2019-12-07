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


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends Fragment {

    private TextInputEditText passwordEditText;
    private TextInputEditText confirmPasswordEditText;
    private MaterialButton resetButton, cancelButton;

    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

        passwordEditText = view.findViewById(R.id.input_enterPassword);
        confirmPasswordEditText = view.findViewById(R.id.input_confirmPassword);
        resetButton = view.findViewById(R.id.reset_button);
        cancelButton = view.findViewById(R.id.cancel_button);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newPassword = passwordEditText.getText().toString();
                String confirmedPassword = confirmPasswordEditText.getText().toString();

                if (!newPassword.matches("") && !confirmedPassword.matches("")) {

                    if (newPassword.matches(confirmedPassword)) {

                        User currUser = MainActivity.userDatabase.userDao().getUser(getArguments().getString("username"));
                        User updatedUser = currUser;
                        updatedUser.setPassword(newPassword);

                        MainActivity.userDatabase.userDao().deleteUser(currUser);
                        MainActivity.userDatabase.userDao().addUser(updatedUser);

                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getActivity(), "Password reset successfully.", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    }
                    else {

                        Toast.makeText(getActivity(), "Passwords do not match.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {

                    Toast.makeText(getActivity(), "All fields must be populated.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

}

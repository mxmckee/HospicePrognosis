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
public class SecurityQuestionFragment extends Fragment {

    private TextInputEditText securityQuestionEditText;
    private TextInputEditText securityAnswerEditText;
    private MaterialButton submitButton;
    private MaterialButton returnToLoginButton;

    public SecurityQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_security_question, container, false);

        securityQuestionEditText = view.findViewById(R.id.input_securityQuestion);
        securityAnswerEditText = view.findViewById(R.id.input_securityAnswer);
        submitButton = view.findViewById(R.id.submit_button);
        returnToLoginButton = view.findViewById(R.id.return_to_login_button);

        final User user = MainActivity.userDatabase.userDao().checkIfUnique(getArguments().getString("username"));

        securityQuestionEditText.setHint(user.getSecurityQuestion());
        securityQuestionEditText.setEnabled(false);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String providedAnswer = securityAnswerEditText.getText().toString();
                if (providedAnswer.matches(user.getSecurityAnswer())) {

                }
                else {
                    Toast.makeText(getActivity(), "Answer is incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        returnToLoginButton.setOnClickListener(new View.OnClickListener() {
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

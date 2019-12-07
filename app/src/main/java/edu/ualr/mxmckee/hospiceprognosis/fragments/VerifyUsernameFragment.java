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
import edu.ualr.mxmckee.hospiceprognosis.activities.MainActivity;
import edu.ualr.mxmckee.hospiceprognosis.fragments.SecurityQuestionFragment;
import edu.ualr.mxmckee.hospiceprognosis.models.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyUsernameFragment extends Fragment {

    private TextInputEditText usernameEditText;
    private MaterialButton verifyButton;
    private MaterialButton returnToLoginButton;

    public VerifyUsernameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verify_username, container, false);

        usernameEditText = view.findViewById(R.id.input_username);
        verifyButton = view.findViewById(R.id.verify_button);
        returnToLoginButton = view.findViewById(R.id.return_to_login_button);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameEditText.getText().toString();

                User testUser = MainActivity.userDatabase.userDao().getUser(username);

                if (testUser == null) {
                    Toast.makeText(getActivity(), "Username doesn't exist.", Toast.LENGTH_SHORT).show();
                }
                else {
                    SecurityQuestionFragment securityQuestionFragment = new SecurityQuestionFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    securityQuestionFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, securityQuestionFragment, "security_question")
                            .addToBackStack(null)
                            .commit();
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

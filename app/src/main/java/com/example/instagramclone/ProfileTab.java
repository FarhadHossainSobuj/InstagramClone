package com.example.instagramclone;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileTab extends Fragment{

    private EditText edtProfileName, edtProfileBio, edtProfileProfession, edtProfileHobbies, edtProfileFavSport;
    private Button btnUpdateInfo;
    ParseUser parseUser;

    public ProfileTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_tab, container, false);
        edtProfileName = view.findViewById(R.id.edtProfileName);
        edtProfileBio = view.findViewById(R.id.edtBio);
        edtProfileProfession = view.findViewById(R.id.edtProfession);
        edtProfileHobbies = view.findViewById(R.id.edtHobbies);
        edtProfileFavSport = view.findViewById(R.id.edtFavoriteSport);
        btnUpdateInfo = view.findViewById(R.id.btnUpdate);

        final ParseUser parseUser = ParseUser.getCurrentUser();

        if(parseUser.get("profileName") == null){
            edtProfileName.setText("");
            edtProfileBio.setText("");
            edtProfileProfession.setText("");
            edtProfileHobbies.setText("");
            edtProfileFavSport.setText("");
        } else {
            edtProfileName.setText(parseUser.get("profileName") + "");
            edtProfileBio.setText(parseUser.get("profileBio") + "");
            edtProfileProfession.setText(parseUser.get("profileProfession") + "");
            edtProfileHobbies.setText(parseUser.get("profileHobbies") + "");
            edtProfileFavSport.setText(parseUser.get("profileFavSport") + "");
        }
        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseUser.put("profileName", edtProfileName.getText().toString());
                parseUser.put("profileBio", edtProfileBio.getText().toString());
                parseUser.put("profileProfession", edtProfileProfession.getText().toString());
                parseUser.put("profileHobbies", edtProfileHobbies.getText().toString());
                parseUser.put("profileFavSport", edtProfileFavSport.getText().toString());

                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){
                            FancyToast.makeText(getContext(), "Info Updated", Toast.LENGTH_SHORT, FancyToast.INFO, false).show();
                        } else {
                            FancyToast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                        }
                    }
                });
            }
        });

        return view;
    }
    public void btnUpdateClicked(View v){
        parseUser.put("profileName", edtProfileBio.getText().toString());
        parseUser.put("profileBio", edtProfileBio.getText().toString());
        parseUser.put("profileProfession", edtProfileProfession.getText().toString());
        parseUser.put("profileHobbies", edtProfileHobbies.getText().toString());
        parseUser.put("profileFavSport", edtProfileFavSport.getText().toString());

        parseUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    FancyToast.makeText(getContext(), "Info Updated", Toast.LENGTH_SHORT, FancyToast.INFO, true).show();
                } else {
                    FancyToast.makeText(getContext(), "Info Updated", Toast.LENGTH_SHORT, FancyToast.ERROR, true).show();
                }
            }
        });

    }
}

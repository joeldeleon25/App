package edu.udb.beautyapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_profile);
      FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
      Log.i("User Id",user.getUid());
    }

    public void onClick (View view) {

        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

        if (view.getId() == R.id.btnContinuar) {
        }

    }
}
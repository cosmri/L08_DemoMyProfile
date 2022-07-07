package sg.edu.rp.c346.id21001096.l08_demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        gpa = findViewById(R.id.gpa);








    }



    @Override
    protected void onPause() {
        super.onPause();

        // Step 1a: Get the user input from the EditText and store it in a variable
        String strName = name.getText().toString();
        float Gpa= Float.parseFloat(gpa.getText().toString());

        // Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        // Step 1d: Add the key-value pair
        prefEdit.putString("name", strName);
        // How to save GPA?


        // Step 1e: Call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }


    //Save the persistent data when the app is no longer (fully) visible
    @Override
    protected void onStop() {
        super.onStop();

        // Get the user input from the EditText and store it in a variable
        String strName = name.getText().toString();
        float intgpa = Float.parseFloat(gpa.getText().toString());//convert to float
        // Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Add the key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", intgpa);
        //Call commit() to save the changed into SharedPreferences
        prefEdit.commit();

    }
// To retrieve the saved data when the Activity is resumed (fully visible)
    @Override
    protected void onResume() {
        super.onResume();
    }}


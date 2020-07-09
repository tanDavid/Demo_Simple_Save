package sg.edu.rp.c346.id19002765.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        //String msg = "No greetings!";

        //Step 2a: Obtain an instance of sharedpreference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 2b: Retrieve the saved data with the key greeting from the sharedpreference object
        String msg = prefs.getString("greetings", "No greetings!");



        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Obtain an instance of the SHaredPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 1b Obtain an instancwe of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1c: Ass the key-value pair
        prefEdit.putString("greetings", "Hello!");

        //Step 1d: call commit() to save the changes into SharedPreferences
        prefEdit.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

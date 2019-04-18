package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3;



    EditText etreflect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.rg1);
        radioGroup2 = findViewById(R.id.rg2);
        radioGroup3 = findViewById(R.id.rg3);



        Button btnDone = findViewById(R.id.ok);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup1 = findViewById(R.id.rg1);
                int selectButtonId1 = radioGroup1.getCheckedRadioButtonId();
                RadioButton rb1 =findViewById(selectButtonId1);

                radioGroup2 = findViewById(R.id.rg2);
                int selectButtonId2 = radioGroup2.getCheckedRadioButtonId();
                RadioButton rb2 =findViewById(selectButtonId2);

                radioGroup3 = findViewById(R.id.rg3);
                int selectButtonId3 = radioGroup3.getCheckedRadioButtonId();
                RadioButton rb3 =findViewById(selectButtonId3);

                etreflect = findViewById(R.id.reflection);

                String[] info = {rb1.getText().toString(),rb2.getText().toString(),rb3.getText().toString(),etreflect.getText().toString()};

                Intent i = new Intent(MainActivity.this,SummaryActivity.class);

                i.putExtra("info",info);

                startActivity(i);


            }
        });


    }

    @Override
    protected void onPause(){
        super.onPause();
        radioGroup1 = findViewById(R.id.rg1);
        radioGroup2 = findViewById(R.id.rg2);
        radioGroup3 = findViewById(R.id.rg3);
        etreflect = findViewById(R.id.reflection);
        int selectButtonId1 = radioGroup1.getCheckedRadioButtonId();
        int selectButtonId2 = radioGroup2.getCheckedRadioButtonId();
        int selectButtonId3 = radioGroup3.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("material", selectButtonId1);
        editor.putInt("time", selectButtonId2);
        editor.putInt("problem", selectButtonId3);

        editor.putString("reflection", etreflect.getText().toString());
        editor.commit();
    }
    @Override
    protected void onResume(){
        super.onResume();
        etreflect = findViewById(R.id.reflection);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int id1 = prefs.getInt("material",0);
        int id2 = prefs.getInt("time",0);
        int id3 = prefs.getInt("problem",0);
        String reflection = prefs.getString("reflection", "");

        radioGroup1.check(id1);
        radioGroup2.check(id2);
        radioGroup3.check(id3);

        etreflect.setText(reflection);


    }

}

package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

Button cbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        cbtn = findViewById(R.id.closeButton);

        Intent i = getIntent();
        //        // Get the String array namd "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        // Get the TextView object
        TextView tv1 = findViewById(R.id.textView1);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);
        // Display the name and age on the TextView
        tv1.setText("Read up on materials before class : " + info[0]);
        tv2.setText("Arrive on time so as not to miss important part of the lesson : "+ info[1]);
        tv3.setText("Attempted the problem myself : "+ info[2]);
        tv4.setText("Reflection: "+ info[3]);

        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SummaryActivity.this.finish();
            }
        });

    }



}

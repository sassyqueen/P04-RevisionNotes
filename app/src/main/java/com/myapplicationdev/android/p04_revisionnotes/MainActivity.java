package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etRevision;
    RadioGroup rg;
    RadioButton rb;
    Button insert, showLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRevision = (EditText) findViewById(R.id.editTextNote);

        insert = (Button) findViewById(R.id.buttonInsertNote);
        showLists = (Button)findViewById(R.id.buttonShowList);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup) findViewById(R.id.radioGroupStars);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                DBHelper db = new DBHelper(MainActivity.this);
                String rbText = String.valueOf(rb.getText());
                final int intRadioButton = Integer.parseInt(rbText);

                // Insert a task
                db.insertNote(etRevision.getText().toString(), intRadioButton);
                db.close();

                Toast.makeText(getBaseContext(), "Inserted", Toast.LENGTH_SHORT).show();

            }
        });

        showLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup) findViewById(R.id.radioGroupStars);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                String rbText = String.valueOf(rb.getText());
                final int intRadioButton = Integer.parseInt(rbText);
                Intent i = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(i);

            }
        });


    }
}

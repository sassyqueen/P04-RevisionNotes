package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.NotSerializableException;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayList<Note> notes;
	RevisionNotesArrayAdapter revisionNotesArrayAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView

		lv = (ListView)findViewById(R.id.lv);
		notes = new ArrayList<Note>();

		DBHelper db = new DBHelper(SecondActivity.this);

		revisionNotesArrayAdapter = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, notes);


		// Insert a task
		ArrayList<Note> data = db.getAllNotes();

		db.close();


		for (int i = 0; i < data.size(); i++) {
			Log.d("Database Content", i +". "+data.get(i));


			notes.add(new Note(i, data.get(i).getNote_Content(), data.get(i).getStars() ));
		}
		lv.setAdapter(revisionNotesArrayAdapter);
		revisionNotesArrayAdapter.notifyDataSetChanged();

	}


}

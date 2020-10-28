package com.example.notetakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create our service to connect to the internet 
        GetNotes service = RetrofitClient.getRetrofitInstance().create(GetNotes.class);
        // send the GET request
        Call<List<Note>> call = service.getNotes();

        // Asynchronously send the request and notify callback of its response or
        // if an error occurred talking to the server, creating the request, or processing the response.
        // uses the Callback to occupy call down below
        call.enqueue(new Callback<List<Note>>() {
            @Override
            public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {

                if (response.isSuccessful()) {
                    List<Note> notes = new ArrayList<Note>(response.body());
                    Log.d("Second title:", notes.get(1).getTitle());

                    TableLayout table = (TableLayout) findViewById(R.id.table);

                    for (int i = 0; i < 2; i++) {
                        TextView t = new TextView(getApplicationContext());
                        t.setText(notes.get(i).getTitle() + ": " + notes.get(i).getBody());
                        t.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        table.addView(t);
                    }
                } else {
                    Log.d("ERROR:", "Response was not successful.");
                    return;
                }
            }

            @Override
            public void onFailure(Call<List<Note>> call, Throwable t) {
                Log.d("ERROR:", "No response was ever received.");
            }
        });
    }

    public void finishNote(View view) {
        TextInputEditText name = (TextInputEditText) findViewById(R.id.titleInput);
        TextInputEditText description = (TextInputEditText) findViewById(R.id.descriptionInput);

        TableLayout table = (TableLayout) findViewById(R.id.table);
        TextView t = new TextView(this); // allows access to the application's resources, letting you make a TextView
        t.setText(name.getText().toString() + ": " + description.getText().toString());
        t.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        table.addView(t);

        name.clearFocus();
        name.setText("");
        description.clearFocus();
        description.setText("");
    }
}
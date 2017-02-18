package br.com.vittorfl.quicknotes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private static final String TAG = "QuickNotesMainActivity";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Intent i = new Intent(this, WelcomeActivity.class);
        startActivity(i);

        Button insertButton = (Button)findViewById(R.id.insert_button);
        insertButton.setOnClickListener(mInsertListener);
    }

    // Definindo um OnClickListener para o botão "Inserir"
    private View.OnClickListener mInsertListener = new View.OnClickListener() {
        public void onClick(View v) {
            EditText editBox = (EditText)findViewById(R.id.edit_box);
            addNote(editBox.getText().toString());
            editBox.setText("");
        }
    };

    /*
    * Método responsável por inserir um registro no content provider
    */
    protected void addNote(String text) {
        ContentValues values = new ContentValues();
        values.put(QuickNotesProvider.Notes.TEXT, text);

        getContentResolver().insert(
                QuickNotesProvider.Notes.CONTENT_URI, values);
    }
}
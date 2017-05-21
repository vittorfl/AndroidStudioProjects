package sqlite.cursoandroid.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3))");

            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Vittor', 27)");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Vinícius', 19)");

            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas WHERE idade > 10", null);

            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));
                cursor.moveToNext();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

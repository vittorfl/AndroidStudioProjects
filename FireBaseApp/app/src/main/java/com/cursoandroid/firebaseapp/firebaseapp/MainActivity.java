package com.cursoandroid.firebaseapp.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia = databaseReferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Usuario usuario = new Usuario();

        usuario.setNome("Vittor");
        usuario.setSobrenome("Firmino de Lira");
        usuario.setIdade(27);
        usuario.setSexo("Masculino");

        Produto produto = new Produto();
        produto.setDescricao("iPhone");
        produto.setFabricante("Apple");
        produto.setCor("branco");

        usuarioReferencia.child("001").setValue(usuario);
        produtoReferencia.child("001").setValue(produto);*/

        usuarioReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

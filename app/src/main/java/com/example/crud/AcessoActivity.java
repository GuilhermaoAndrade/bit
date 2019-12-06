package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AcessoActivity extends AppCompatActivity {

    private EditText acessotext;
    private EditText acessotextlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acesso);
        acessotext = (EditText)findViewById(R.id.acessotext);
        acessotextlogin = (EditText) findViewById(R.id.acessotextlogin);
    }

    public void acessob(View view) {
        ModeloUsuario usu = new ModeloUsuario();
        usu.setLogin(acessotextlogin.getText().toString());
        usu.setSenha(acessotext.getText().toString());

        if(usu.ValidarLogin() == false){
            Toast.makeText(getApplicationContext(),"Usuário ou senha inválidos",Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(AcessoActivity.this, Menu.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }
}

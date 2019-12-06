package com.example.crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProdutoActivity extends AppCompatActivity {

    EditText firstname;
    TextView textView;
    DB_Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        controller = new DB_Controller(this);

        firstname = (EditText) findViewById(R.id.firstname_input_produto);
        textView = (TextView) findViewById(R.id.textviewproduto);

    }


    public void addprod(View view) {
        ModeloProduto MC = new ModeloProduto();
        MC.setProduto(firstname.getText().toString());
       controller.insert_produto(MC);

    }

    public void list(View view) {


        controller.list_all_produto(textView);
    }

    public void delete(View view) {
        controller.delete_produto(firstname.getText().toString());
    }

    public void update(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Novo nome");
        final EditText new_firstname = new EditText(ProdutoActivity.this);
        alertDialogBuilder.setView(new_firstname);

        alertDialogBuilder.setPositiveButton("Editar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        controller.update_produto(firstname.getText().toString(),new_firstname.getText().toString());
                    }
                });


        alertDialogBuilder.setNegativeButton("Voltar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}

package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ItemVendaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemvenda);

        Button botaoadd = (Button)findViewById(R.id.button_add);
        Button botaolist = (Button)findViewById(R.id.button_list);
        Button botaodelete = (Button)findViewById(R.id.button_delete);
        Button botaoupdate = (Button)findViewById(R.id.button_update);

        botaodelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB_Controller crud = new DB_Controller(getBaseContext());
                EditText idagenda = (EditText)findViewById(R.id.id_agenda);
                crud.delete_itemvenda(idagenda.getText().toString());
            }
        });

        botaoupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB_Controller crud = new DB_Controller(getBaseContext());
                EditText idagenda = (EditText)findViewById(R.id.id_agenda);
                EditText new_cliente = (EditText)findViewById(R.id.cliente_agenda);
                EditText new_funcionario = (EditText)findViewById(R.id.funcionario_agenda);
                //EditText new_reuniao = (EditText)findViewById(R.id.reuniao_agenda);
                crud.update_itemvenda(idagenda.getText().toString(),new_cliente.getText().toString(),new_funcionario.getText().toString());

            }
        });

        botaoadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB_Controller crud = new DB_Controller(getBaseContext());
                EditText cliente = (EditText)findViewById(R.id.cliente_agenda);
                EditText funcionario = (EditText)findViewById(R.id.funcionario_agenda);
               // EditText reuniao = (EditText)findViewById(R.id.reuniao_agenda);
                String scliente = cliente.getText().toString();
                String sfuncionario = funcionario.getText().toString();
                //String sreuniao = reuniao.getText().toString();
                String resultadoadd;
                resultadoadd = crud.insert_itemvenda(scliente,sfuncionario);
                Toast.makeText(getApplicationContext(), resultadoadd,Toast.LENGTH_LONG).show();
            }
        });

        botaolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB_Controller crud = new DB_Controller(getBaseContext());
                EditText cliente = (EditText)findViewById(R.id.cliente_agenda);
                EditText funcionario = (EditText)findViewById(R.id.funcionario_agenda);
                //EditText reuniao = (EditText)findViewById(R.id.reuniao_agenda);
                TextView tv = (TextView)findViewById(R.id.tvagenda);
                crud.listaitemvenda(tv);

            }
        });

    }


    public void delete_itemvenda(View view) {
    }

    public void update_itemvenda(View view) {
    }

    public void list_itemvenda(View view) {
    }
}

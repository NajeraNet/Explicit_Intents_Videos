package com.example.explicit_intents_videos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    //
    EditText etSurName;
    Button btnSubmit;
    Button btnCancell;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        //
        etSurName = findViewById(R.id.etSurName);
        btnSubmit = findViewById(R.id.btnEnviarNN);
        btnCancell = findViewById(R.id.btnCancell);
        //
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewNickNameToMA) {
                //Preguntamos si ingreso datos
                if (etSurName.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this, getText(R.string.rellena_los_campos),
                            Toast.LENGTH_SHORT).show();
                }else{
                    // agregamos los datos a un string
                    String surname = etSurName.getText().toString().trim();
                    //iniciamos el intent para pasar los datos
                    Intent intent = new Intent();
                    //Agregamos los datos a nuestro intent antes iniciado
                    intent.putExtra("surname", surname);
                    //Decimos que los datos son validos enviando un resultado como OK
                    setResult(RESULT_OK, intent);
                    //Cerramos el activity
                    Activity3.this.finish();
                }
            }
        });
        //
        btnCancell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewCanceled) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });
    }
}
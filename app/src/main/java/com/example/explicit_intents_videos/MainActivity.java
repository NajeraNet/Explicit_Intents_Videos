package com.example.explicit_intents_videos;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResults;
    //
    static int ACTIVITY3 = 3; // este es el valor unico creado para reconocer al activity 3
    //
    Button btnAct_ImplicitIntents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct_2);
        btnAct3 = findViewById(R.id.btnAct_3);
        tvResults = findViewById(R.id.tvResults);
        //
        btnAct_ImplicitIntents = findViewById(R.id.btnAct_ImplicitIntents);
        //
        //Se crea la nueva vista al hacer clic en el boton activity 2
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor introduce tu nombre",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String name = etName.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,
                            com.example.explicit_intents_videos.Activity2.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });
        //Se crea la nueva vista al hacer clic en el boton activity 3
        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                Intent intent = new Intent( MainActivity.this, com.example.explicit_intents_videos.Activity3.class);
                // aqui podriamos agregar un putExtra(para pasar los datos)
                startActivityForResult(intent, ACTIVITY3);
            }
        });
        //
        btnAct_ImplicitIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_implicit_intents);
                // TODO Implicit Intents function
            }
        });

    }
    @Override // verificamos si hay datos traidos desde activity 3
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // validamos que los datos provengan de activity 3, por su Key code "ACTIVITY3"
        if (requestCode == ACTIVITY3) {
            //Si se envia un intent con request code ok obtenemos sus datos
            if (resultCode == RESULT_OK) {
                // agregamos los datos que contenga data a nuestro text view results
                tvResults.setText(data.getStringExtra("surname"));
            }
            // si no hay datos avisamos que no ha han enviado datos desde nuestro activity 3
            if (resultCode == RESULT_CANCELED) {
                tvResults.setText(R.string.no_datos);
            }
        }
    }
}
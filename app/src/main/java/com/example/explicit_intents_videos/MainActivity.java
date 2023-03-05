package com.example.explicit_intents_videos;
import android.content.Intent;
import android.os.Bundle;
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
            }
        });
    }
}
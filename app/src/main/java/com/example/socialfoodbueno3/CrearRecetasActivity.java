package com.example.socialfoodbueno3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;
import java.util.Map;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class CrearRecetasActivity extends AppCompatActivity {

    private Button postDataBtn;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_crear_recetas);

        EditText titulo = findViewById(R.id.textView);
        EditText ingredientes = findViewById(R.id.textView2);
        EditText descripcion = findViewById(R.id.textView3);
        EditText nacionalidad = findViewById(R.id.textView4);
        EditText latitud = findViewById(R.id.textView5);
        EditText longitud = findViewById(R.id.textView6);

        postDataBtn = findViewById(R.id.button);

        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDataUsingVolley(titulo.getText().toString(), ingredientes.getText().toString(), descripcion.getText().toString(), nacionalidad.getText().toString(), longitud.getText().toString(), latitud.getText().toString());
            }
        });
    }

    public void postDataUsingVolley(String titulo, String ingredientes, String descripcion, String nacionalidad, String latitud, String longitud) {

        String url = "https://626afae6e5274e6664c628f8.mockapi.io/receta";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                response -> Toast.makeText(CrearRecetasActivity.this, "Añadido con éxito", Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(CrearRecetasActivity.this, "Error", Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("clave", titulo);
                params.put("clave2", ingredientes);
                params.put("clave3", descripcion);
                params.put("clave4", nacionalidad);
                params.put("clave5", latitud);
                params.put("clave6", longitud);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(CrearRecetasActivity.this);
        requestQueue.add(stringRequest);

        finish();
    }
}


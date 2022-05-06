package com.example.socialfoodbueno3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.socialfoodbueno3.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<RecetaDto> elementos;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CrearRecetasActivity.class));
            }
        });

        elementos = new ArrayList<>();
        elementos.add(new RecetaDto("Tortilla", "Plato típico de España.", "Patatas, jamón, huevos y acteite.", "España", "111", "111"));
        elementos.add(new RecetaDto("Raxo roquefort", "Delicioso plato para compartir.", "Patats fritas, raxo y queso.", "Galicia", "222", "222"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(elementos, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);

    }
}
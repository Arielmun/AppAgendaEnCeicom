package com.arielmondev.agendaescolar;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Registros extends AppCompatActivity {

    // Campos de registro
    EditText etNombres, etApellidos, etCorreo, etClave;
    Spinner spinnerTipoUsuario;
    Button btnRegistrar;
    TextView tvIrLogin;

    // Variables para guardar los datos
    String nombres = "", apellidos = "", correo = "", contrasena = "", tipoUsuario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        // Vincular vistas
        etNombres = findViewById(R.id.etNombresR);
        etApellidos = findViewById(R.id.etApellidosR);
        etCorreo = findViewById(R.id.etcarrera);
        etClave = findViewById(R.id.etContrasenaR);
        spinnerTipoUsuario = findViewById(R.id.spinner_tipo_usuario);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvIrLogin = findViewById(R.id.tvIrLogin);

        // Opciones para el Spinner
        String[] opciones = {"Estudiante", "Docente"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoUsuario.setAdapter(adapter);

        // Capturar selección del Spinner
        spinnerTipoUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoUsuario = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tipoUsuario = "Estudiante"; // Valor por defecto
            }
        });

        // Botón registrar
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valiarDatos();
            }
        });

        // Botón para regresar al login
        tvIrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // cierra esta actividad
            }
        });
    }

    // Función para validar datos y guardar en SQLite
    private void valiarDatos() {
        nombres = etNombres.getText().toString().trim();
        apellidos = etApellidos.getText().toString().trim();
        correo = etCorreo.getText().toString().trim();
        contrasena = etClave.getText().toString().trim();

        if (TextUtils.isEmpty(nombres)) {
            Toast.makeText(this, "Nombre está vacío", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(apellidos)) {
            Toast.makeText(this, "Apellido está vacío", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this, "Ingrese correo válido", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(contrasena) || contrasena.length() < 6) {
            Toast.makeText(this, "Contraseña necesita mínimo 6 caracteres", Toast.LENGTH_SHORT).show();
        } else {

                Toast.makeText(this, "Error: el correo ya está registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }


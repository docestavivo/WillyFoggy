package com.example.estefania.willyfoggy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, eContrasena;
    private Cursor fila;
    TextView cambiarFuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        cambiarFuente = (TextView) findViewById(R.id.welcomeText);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/ReklameScript-Regular_DEMO.otf");
        cambiarFuente.setTypeface(face);

        Button entrar = (Button) findViewById(R.id.aceptarLogin);
        eUsuario = (EditText) findViewById(R.id.rellenaEmail);
        eContrasena = (EditText) findViewById(R.id.rellenaPass);


        /*entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.rellenaEmail)).getText().toString();
                String contrasena = ((EditText) findViewById(R.id.rellenaPass)).getText().toString();


                if (usuario.equals("admin") && contrasena.equals("1234")){
                    Intent todoCorrecto = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(todoCorrecto);



                }else{
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                    eUsuario.setText("");
                    eContrasena.setText("");
                }

            }
        });*/


    }

    public void ingresar(View v){
        Log.i("INGRESAR", "Busca usuario.");
        DBHelper admin=new DBHelper(this,"instituto",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario =eUsuario.getText().toString();
        String contrasena=eContrasena.getText().toString();
        fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'",null);

        if (usuario.equals("admin") && contrasena.equals("1234")){
            Intent todoCorrecto = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(todoCorrecto);}

        if (fila.moveToFirst()){
            String usua=fila.getString(0);
            String pass=fila.getString(1);
            if (usuario.equals(usua)&&contrasena.equals(pass)){
                Intent ven=new Intent(this,MenuActivity.class);
                startActivity(ven);
                eUsuario.setText("");
                eContrasena.setText("");
            }

        }
    }

    public void registro(View v){
        Intent ven = new Intent(this,RegistrarActivity.class);
        startActivity(ven);
    }

    public void salir(View v){
        finish();
        //System.exit(0);
    }



}

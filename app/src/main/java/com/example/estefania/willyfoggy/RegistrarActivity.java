package com.example.estefania.willyfoggy;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrarActivity extends AppCompatActivity {

    EditText et2,et3;
    TextView cambiarFuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        cambiarFuente = (TextView) findViewById(R.id.textView5);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/ReklameScript-Regular_DEMO.otf");
        cambiarFuente.setTypeface(face);

        et2= (EditText) findViewById(R.id.etuser);
        et3= (EditText) findViewById(R.id.etcontra);
    }

    public void registrar(View view){

        DBHelper admin=new DBHelper(this,"instituto",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario=et2.getText().toString();
        String contraseña=et3.getText().toString();

        ContentValues values=new ContentValues();
        values.put("usuario",usuario);
        values.put("contrasena",contraseña);

        db.insert("usuarios",null,values);
        db.close();

        Intent ven=new Intent(this,LoginActivity.class);
        startActivity(ven);
        Log.i("REGISTRAR","Se ha metido el usuario");

    }

    public void cancelar(View view){
        finish();

    }
}

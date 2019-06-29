package e.miranda.aero;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.loopj.android.http.RequestParams;

public class RegistroAeropuertoActivity extends AppCompatActivity {

    TextInputLayout nombre,latitud,longitud;
    conexion conexion;
    ProgressDialog progress;
    RequestParams parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_aeropuerto);
        conexion = new conexion(this);
        nombre = findViewById(R.id.nombre);
        latitud = findViewById(R.id.latitud);
        longitud = findViewById(R.id.longitud);
        parametros = new RequestParams();

        latitud.setEnabled(false);
        longitud.setEnabled(false);

        progress = new ProgressDialog(this);
        progress.setTitle("titulo");
        progress.setMessage("espere...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCancelable(true);

        //  ObtenerDatos("ricardo","consultar");


    }

    public void obtener(View view) {
        Intent intent = new Intent(this,MapsActivity.class);
        startActivityForResult(intent,1);
    }

    public void guardarAeropuerto(View view) {
        if(nombre.getEditText().getText().toString().equals("")){
            nombre.setError("digite un nombre");
        }else if(latitud.getEditText().getText().toString().equals("")){
            latitud.setError("digite la latitud");
            nombre.setErrorEnabled(false);
        }else if(longitud.getEditText().getText().toString().equals("")){
            longitud.setError("digite la longitud");
            latitud.setErrorEnabled(false);
        }else {


            parametros.put("nombre" , nombre.getEditText().getText().toString());
            parametros.put("la",latitud.getEditText().getText().toString());
            parametros.put("lo",longitud.getEditText().getText().toString());
            parametros.put("accion", "guardarAeropuerto");
            conexion.escribir(parametros);
            limpiar();
        }
    }

    private void limpiar() {
        latitud.getEditText().setText("");
        longitud.getEditText().setText("");
        nombre.getEditText().setText("");

    }


    private void msg(String texto) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("INFORMACION");
        dialogo.setMessage(texto);


        dialogo.setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ////aqui se pone la accion si da click en aceptar
            }
        });

        dialogo.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode ==1){
            if(resultCode == RESULT_OK){
                latitud.getEditText().setText("" + MainActivity.latitud);
                longitud.getEditText().setText("" + MainActivity.longitud);
            }
        }

    }

    public  void menu(View view){
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }



}

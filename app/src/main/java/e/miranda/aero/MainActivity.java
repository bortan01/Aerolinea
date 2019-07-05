package e.miranda.aero;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    public static double latitud;
    public static double longitud;
    public static String opcion;
    public static String vuelo;
    public static int  idVuelo;
    public static  Pasajero pasajero ;
    TextInputLayout user,pass;
    AsyncHttpClient client ;
    String url ;


    public static ArrayList<Aeropuerto> listaAeropuertos;
    conexion con ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaAeropuertos = new ArrayList<>();
        con = new conexion(this);
        con.obteneAeropuerto();
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        RequestParams parametros = new RequestParams();
        pasajero = new Pasajero();
        pasajero.setNivel(100);
        client =  new AsyncHttpClient();
        url = "https://www.ma14049.comues.com/accesoremoto/conexion.php";
     //  url = "http://192.168.56.1/proyecto/conexion.php";


    }

    public void goHome(View view) {

        if(user.getEditText().getText().toString().equals("")){
           msg("ingesu su nombre de usuario");
        }else if(pass.getEditText().getText().toString().equals("")){
          msg("ingrese su contraseña");
        }else{
            RequestParams parametros = new RequestParams();
            parametros.put("user", user.getEditText().getText().toString());
            parametros.put("pass", pass.getEditText().getText().toString());
            con.obtenerLogin(parametros);

           // Toast.makeText(this,"nivel es" +pasajero.getNivel(),Toast.LENGTH_SHORT).show();

            if(pasajero.getNivel() ==1){
                Intent intent = new Intent(this,HomeRootActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }else if(pasajero.getNivel() == 0){
              //  Toast.makeText(this,"nivel es pasajero " +pasajero.getNivel(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,HomePasajeroActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }


        }


    }

    public void goCreateAccount(View view) {
        Intent intent = new Intent(this,RegistroUsiarioActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
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



}

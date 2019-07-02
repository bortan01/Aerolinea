package e.miranda.aero;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static double latitud;
    public static double longitud;
    public static String opcion;
    public static String vuelo;
    public static int  idVuelo;
    public static Pasajero pasajero ;
    TextInputLayout user,pass;


    public static ArrayList<Aeropuerto> listaAeropuertos;
    conexion con ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaAeropuertos = new ArrayList<>();
        con = new conexion(this);
        con.obteneAeropuerto();
        pasajero = new Pasajero();
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        RequestParams parametros = new RequestParams();
        parametros.put("user", "00000" );
        parametros.put("pass", "00000");
        con.obtenerLogin(parametros);

    }

    public void goHome(View view) {

        if(user.getEditText().getText().toString().equals("")){
            user.setError("ingrese su usuario");
        }else if(pass.getEditText().getText().toString().equals("")){
            pass.setError("ingrese su pass");
            user.setErrorEnabled(false);
        }else{
            RequestParams parametros = new RequestParams();
            parametros.put("user", user.getEditText().getText().toString());
            parametros.put("pass", pass.getEditText().getText().toString());
            con.obtenerLogin(parametros);

            Toast.makeText(this,"nivel " +pasajero.getNivel(),Toast.LENGTH_SHORT).show();

            if(pasajero.getNivel() ==1){
                Intent intent = new Intent(this,HomeRootActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }


        }



    }

    public void goCreateAccount(View view) {
        Intent intent = new Intent(this,RegistroUsiarioActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}

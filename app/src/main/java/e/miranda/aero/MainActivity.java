package e.miranda.aero;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static double latitud;
    public static double longitud;
    public static String opcion;
    public static String aterrisaje;
    public static String despeje;
    public static int  idAterrisaje;
    public static int idDespeje;

    public static ArrayList<Aeropuerto> listaAeropuertos;
    conexion con ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaAeropuertos = new ArrayList<>();
        con = new conexion(this);
        con.obteneAeropuerto();
    }

    public void goHome(View view) {
        Intent intent = new Intent(this,HomeRootActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void goCreateAccount(View view) {
    }
}

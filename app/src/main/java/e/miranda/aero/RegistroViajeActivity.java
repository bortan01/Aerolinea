package e.miranda.aero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.Date;

public class RegistroViajeActivity extends AppCompatActivity {
    ListView lista ;
    static ArrayList<Vuelo> listaVuelos;
    String idVuelo;
    conexion con ;
    public  static Button primera,ejecutiva,economica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_viaje);
        lista = findViewById(R.id.lista);
        con = new conexion(this);
        primera = findViewById(R.id.btnPrimera);
        ejecutiva = findViewById(R.id.btnEjecuta);
        economica = findViewById(R.id.btnEconomica);

        primera.setEnabled(false);
        ejecutiva.setEnabled(false);
        economica.setEnabled(false);
        idVuelo = "";
        listaVuelos = new ArrayList<>();
        con.obtenerVuelos();

        llenarLista();

    }
    private void llenarLista() {
        con.obtenerVuelos();
        Vuelo v = new Vuelo();
        v.setModelo("dddd");
        v.setFecha(new Date());
        v.setIdAvion(2);
        v.setDestino("san verapaz");
        v.setOrigen("por alla");
        v.setIdVuelo(2);
        listaVuelos.add(v);


        final Adaptador adaptador = new Adaptador(this, R.layout.activity_custom,listaVuelos);
        lista.setAdapter(adaptador);

        listaVuelos.remove(0);


    }


    public void onReservar(View view) {
        idVuelo = (String.valueOf(view.getTag()));
        RegistroViajeActivity.primera.setEnabled(true);
        RegistroViajeActivity.ejecutiva.setEnabled(true);
        RegistroViajeActivity.economica.setEnabled(true);

    }


    public void Guardar(String clase){
        RequestParams parametros = new RequestParams();
        parametros.put("idVuelo", idVuelo);
        parametros.put("idPasajero", MainActivity.pasajero.getId_pasajero());
        parametros.put("clase", clase);
        parametros.put("accion" , "guardarViaje");
        con.escribir(parametros);

        primera.setEnabled(false);
        ejecutiva.setEnabled(false);
        economica.setEnabled(false);


    }

    public void onPrimera(View view) {
        Guardar("Primera Clase");
    }

    public void onEjecutiva(View view) {
        Guardar("Clase Ejecutiva");
    }

    public void onEconomica(View view) {
        Guardar("Clase Economimca");
    }
}

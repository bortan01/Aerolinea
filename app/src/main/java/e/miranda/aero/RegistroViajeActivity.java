package e.miranda.aero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class RegistroViajeActivity extends AppCompatActivity {
    ListView lista ;
    static ArrayList<Vuelo> listaVuelos;
    conexion con ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_viaje);
        lista = findViewById(R.id.lista);
        con = new conexion(this);

        listaVuelos = new ArrayList<>();
        con.obtenerVuelos();

        llenarLista();

    }
    private void llenarLista() {
        con.obtenerVuelos();
        Vuelo v = new Vuelo();
        v.setModelo("dddd");
       listaVuelos.add(v);
        final Adaptador adaptador = new Adaptador(this, R.layout.activity_custom,listaVuelos);
        lista.setAdapter(adaptador);
    }

    public void onEditar(View view) {
        ///recuperamos los datos de la lista usando el tag, de el boton donde se
        //selecciono, en su interior tiene el id del elemento, el cual
        // ocuparemos para hacer la consulta a la base de datos
       // Vuelo d = MainActivity.conexionSQLite.consultar(String.valueOf(view.getTag()));
       // Intent intent = new Intent(getBaseContext(),EditarActivity.class);
       // intent.putExtra("clase", d);
       // startActivity(intent);
    }
}

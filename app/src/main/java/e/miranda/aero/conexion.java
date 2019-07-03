package e.miranda.aero;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.PreferenceActivity;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cz.msebera.android.httpclient.Header;

public  class conexion {

    AsyncHttpClient client ;
    String url ;
    Context context;
    public static ArrayList<Aeropuerto> listaDatos;


    public conexion(Context context) {
        client =  new AsyncHttpClient();
       //url = "https://www.ma14049.comues.com/proyecto/conexion.php";
        url = "http://192.168.56.1/proyecto/conexion.php";
        this.context = context;
        listaDatos = new ArrayList<>();
    }


    public  void  escribir(RequestParams parametros) {

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                msg("datos almacenados");
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                msg("datos no almacenados");
            }
        });
    }

    public void obtenerAvion(){
        RequestParams parametros = new RequestParams();
        parametros.put("accion","obtenerListaAvion" );


        client.post(url, parametros, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode ==200){
                    try {

                        JSONArray jsonArray = new JSONArray(new String( responseBody));
                        for (int i = 0 ; i<jsonArray.length(); i++){

                            Avion avionsito = new Avion();
                            avionsito.setId_avion(jsonArray.getJSONObject(i).getInt("id_avion"));
                            avionsito.setEconomico(jsonArray.getJSONObject(i).getInt("economico"));
                            avionsito.setEjecutiva(jsonArray.getJSONObject(i).getInt("ejecutiva"));
                            avionsito.setPrimera(jsonArray.getJSONObject(i).getInt("primera"));
                            avionsito.setModelo(jsonArray.getJSONObject(i).getString("modelo"));
                            RegistroVueloActivity.listaAviones.add(avionsito);
                        }
                    }catch (Exception e){
                        msg("Problema en obtener avio " + e.getMessage());
                    }
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                msg("No hay contacto con la BD");
            }
        });

    }

    public void obteneAeropuerto(){
        RequestParams parametros = new RequestParams();
        parametros.put("accion","obtenerListaAeropuerto" );
        final ArrayList<Avion> elementos = new ArrayList<>();

        client.post(url, parametros, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode ==200){
                    try {

                        JSONArray jsonArray = new JSONArray(new String( responseBody));
                        for (int i = 0 ; i<jsonArray.length(); i++){

                            Aeropuerto aero = new Aeropuerto();
                            aero.setIdAerppuerto(jsonArray.getJSONObject(i).getInt("idAeropuerto"));
                            aero.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
                            aero.setLongitud(jsonArray.getJSONObject(i).getDouble("longitud"));
                            aero.setLatiutd(jsonArray.getJSONObject(i).getDouble("latitud"));
                            MainActivity.listaAeropuertos.add(aero);
                //            Toast.makeText(context, "ciclo " + aero.getNombre(),Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        msg("Problema: " + e.getMessage());
                    }
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                msg("No hay contacto con la BD");
            }
        });

    }

    private void msg(String texto) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(context);
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

    public void obtenerLogin(RequestParams parametros){

        parametros.put("accion","consultarLogin" );

        client.post(url, parametros, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode ==200){
                    try {

                        JSONArray jsonArray = new JSONArray(new String( responseBody));
                        for (int i = 0 ; i<jsonArray.length(); i++){
                            MainActivity.pasajero = new Pasajero();
                            MainActivity.pasajero.setId_pasajero(jsonArray.getJSONObject(i).getInt("id_pasajero"));
                            MainActivity.pasajero.setNivel(jsonArray.getJSONObject(i).getInt("nivel"));
                         //   Toast.makeText(context, "el nivel dentro de try es " + MainActivity.pasajero.getNivel(),Toast.LENGTH_SHORT).show();

                        }
                    }catch (Exception e){
                        msg("Problema obtener login: " + e.getMessage());
                    }
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                msg("No hay contacto con la BD");
            }
        });
     //   Toast.makeText(context, "el nivel ahora es  " + MainActivity.pasajero.getNivel(),Toast.LENGTH_SHORT).show();
    }

    public void obtenerVuelos(){
        RequestParams parametros = new RequestParams();
        parametros.put("accion","obtenerListaVuelos" );


        client.post(url, parametros, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode ==200){
                    try {
                        RegistroViajeActivity.listaVuelos.clear();
                        JSONArray jsonArray = new JSONArray(new String( responseBody));
                        for (int i = 0 ; i<jsonArray.length(); i++){

                            Vuelo vuelo = new Vuelo();
                            vuelo.setIdVuelo(jsonArray.getJSONObject(i).getInt("id_vuelo"));
                            vuelo.setOrigen(jsonArray.getJSONObject(i).getString("origen"));
                            vuelo.setDestino(jsonArray.getJSONObject(i).getString("destino"));
                            vuelo.setIdAvion(jsonArray.getJSONObject(i).getInt("id_avion"));
                            vuelo.setModelo(jsonArray.getJSONObject(i).getString("modelo"));
                            vuelo.setEconomica("Primera Economica $"+jsonArray.getJSONObject(i).getDouble("costoEconomica"));
                            vuelo.setEjecutiva("Clase Ejecutiva $"+jsonArray.getJSONObject(i).getString("costoEjecutivo"));
                            vuelo.setPrimera("Primera Clase $"+jsonArray.getJSONObject(i).getString("costoPrimera"));
                            String strFecha = (jsonArray.getJSONObject(i).getString("fecha"));
                            vuelo.setSolofecha(strFecha.substring(0,10));
                            vuelo.setSolohora( strFecha.substring(strFecha.length()-8, strFecha.length()));
                            RegistroViajeActivity.listaVuelos.add(vuelo);


                        }
                    }catch (Exception e){
                        msg("obtener vuelos: " + e.getMessage());
                    }
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                msg("No hay contacto con la BD");
            }
        });

    }


public  void mandarNivel(int nivel){

}

}

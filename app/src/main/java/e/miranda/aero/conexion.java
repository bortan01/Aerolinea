package e.miranda.aero;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.PreferenceActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public  class conexion {

    AsyncHttpClient client ;
    String url ;
    Context context;

    public conexion(Context context) {
        client =  new AsyncHttpClient();
       //url = "https://www.ma14049.comues.com/proyecto/conexion.php";
        url = "http://192.168.56.1/proyecto/conexion.php";
        this.context = context;
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

    public ArrayList<Avion> obtenerAvion(){
        RequestParams parametros = new RequestParams();
        parametros.put("accion","obtenerListaAvion" );
        final ArrayList<Avion> elementos = new ArrayList<>();

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
                            elementos.add(avionsito);
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
        return  elementos;
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

}

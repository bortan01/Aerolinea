package e.miranda.aero;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.PreferenceActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

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

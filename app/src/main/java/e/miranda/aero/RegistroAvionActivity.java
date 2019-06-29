package e.miranda.aero;

import android.app.ProgressDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.RequestParams;

public class RegistroAvionActivity extends AppCompatActivity {

    TextInputLayout modelo, primera, ejecutiva,economica;
    conexion conexion;
    ProgressDialog progress;
    RequestParams parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_avion);
        modelo = findViewById(R.id.modelo);
        economica = findViewById(R.id.economicos);
        primera =findViewById(R.id.primera);
        ejecutiva = findViewById(R.id.ejecutivo);
        conexion = new conexion(this);
        parametros = new RequestParams();

        progress = new ProgressDialog(this);
        progress.setTitle("titulo");
        progress.setMessage("espere...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCancelable(true);

    }

    public void guardarAvion(View view) {
        if(modelo.getEditText().getText().toString().equals("")){
            modelo.setError("ingrese el modelo");
        }else if(economica.getEditText().getText().toString().equals("")){
            economica.setError("ingrese los asientos Economicos");
            modelo.setErrorEnabled(false);
        }else if(ejecutiva.getEditText().getText().toString().equals("")){
            ejecutiva.setError("digite los asientos Ejecutivos");
            economica.setErrorEnabled(false);
        }else if(primera.getEditText().getText().toString().equals("")){
            primera.setError("digite los asientos de Primera");
            ejecutiva.setErrorEnabled(false);
        }else {


            parametros.put("modelo" , modelo.getEditText().getText().toString());
            parametros.put("economica",economica.getEditText().getText().toString());
            parametros.put("ejecutiva",ejecutiva.getEditText().getText().toString());
            parametros.put("primera",primera.getEditText().getText().toString());
            parametros.put("accion", "guardarAvion");
            conexion.escribir(parametros);

            limpiar();
        }
    }

    private void limpiar() {
        modelo.getEditText().setText("");
        economica.getEditText().setText("");
        ejecutiva.getEditText().setText("");
        primera.getEditText().setText("");

        modelo.setError("");
        economica.setError("");
        ejecutiva.setError("");
        primera.setError("");
    }

    public void Cancelar(View view) {
      limpiar();
    }


}

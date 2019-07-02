package e.miranda.aero;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.loopj.android.http.RequestParams;

public class RegistroUsiarioActivity extends AppCompatActivity {

    TextInputLayout nombre,apellido,nacionalidad,edad,user,pass;
    RadioGroup rg;
    RadioButton masculino,femenino;
    RequestParams parametros;
    conexion con = new conexion(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usiario);
        parametros = new RequestParams();
        nombre = findViewById(R.id.nombreUsiarop);
        apellido = findViewById(R.id.apellidoUsu);
        nacionalidad = findViewById(R.id.nacionalidad);
        edad = findViewById(R.id.edad);
        user = findViewById(R.id.User);
        pass = findViewById(R.id.pass);
        rg = findViewById(R.id.radioGroup);
        masculino = findViewById(R.id.masculino);
        femenino = findViewById(R.id.femenino);

        masculino.setChecked(true);



    }

    public void guardarPasajero(View view) {
        if(nombre.getEditText().getText().toString().equals("")){
            nombre.setError("digite un nombre");
        }else if(apellido.getEditText().getText().toString().equals("")){
            apellido.setError("digite el apellido");
            nombre.setErrorEnabled(false);
        }else if(nacionalidad.getEditText().getText().toString().equals("")){
            nacionalidad.setError("digite la nacionalidad");
            apellido.setErrorEnabled(false);
        }else if(edad.getEditText().getText().toString().equals("")){
            edad.setError("digite la edad");
            nacionalidad.setErrorEnabled(false);
        }else if(user.getEditText().getText().toString().equals("")){
            user.setError("digite el usuario");
            edad.setErrorEnabled(false);
        }else if(pass.getEditText().getText().toString().equals("")){
            pass.setError("digite la pass");
            user.setErrorEnabled(false);
        }else{
            pass.setErrorEnabled(false);
            parametros.put("nombre",nombre.getEditText().getText().toString());
            parametros.put("apellido",apellido.getEditText().getText().toString());
            parametros.put("nacionalidad",nacionalidad.getEditText().getText().toString());
            parametros.put("edad",edad.getEditText().getText().toString());
            parametros.put("user",user.getEditText().getText().toString());
            parametros.put("pass",pass.getEditText().getText().toString());

            if(masculino.isChecked()){
                parametros.put("genero","masculino");
            }else {
                parametros.put("genero","femenino");
            }

            parametros.put("accion", "guardarUsuario");
            con.escribir(parametros);
        }
    }
}

package e.miranda.aero;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.Calendar;

public class RegistroVueloActivity extends AppCompatActivity {

    EditText fecha ,hora;
    int minut, second , hour;
    Spinner comboAvion;
    conexion conexion;
    EditText txtDespeje, txtAterrisaje;
    Button despeje, aterrisaje;
    int idDespeje;
    int idAterrisaje;
    RequestParams parametros;

    TextInputLayout  primera, ejecutiva,economica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vuelo);
        conexion = new conexion(this);
        fecha = findViewById(R.id.fecha);
        txtAterrisaje = findViewById(R.id.txtAterrisaje);
        txtDespeje = findViewById(R.id.txtDespeje);
        despeje = findViewById(R.id.despeje);
        primera = findViewById(R.id.primera);
        ejecutiva = findViewById(R.id.ejecutivo);
        economica = findViewById(R.id.economicos);
        aterrisaje = findViewById(R.id.aterrisaje);
        hora = findViewById(R.id.hora);
        comboAvion = findViewById(R.id.comboAvion);
        llenarComboAvion();
        idAterrisaje = 0;
        idDespeje = 0 ;
        parametros = new RequestParams();

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "on click " ,Toast.LENGTH_SHORT).show();

                showTimePickerDialog();
            }
        });

    }



    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = year + "-" + (month+1) + "-" + day;
                Toast.makeText(getBaseContext(), "on date" ,Toast.LENGTH_SHORT).show();
                fecha.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    private void showTimePickerDialog(){
        Toast.makeText(getBaseContext(), "show picker" ,Toast.LENGTH_SHORT).show();
        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                final String selectTime = hourOfDay + ":" + minute + ":00";
                hora.setText(selectTime);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }



    public  void llenarComboAvion(){
        String[] opciones = {"Mayuscula", "Minuscula"};
        ArrayList<Avion> datos = conexion.obtenerAvion();
        datos.add(new Avion(0,1,2,3,"Seleccione un Avion"));
        ArrayAdapter<Avion>adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,datos);
        comboAvion.setAdapter(adapter);
    }


    public void mapa(View view) {
        MainActivity.opcion= "obtenerAeropuerto";
        Intent intent = new Intent(this,MapsActivity.class);
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode ==1){
            if(resultCode == RESULT_OK){
                if(txtDespeje.getText().toString().equals("")){
                    txtDespeje.setText("" + MainActivity.vuelo);
                    idDespeje = MainActivity.idVuelo;
                }else{
                    txtAterrisaje.setText("" + MainActivity.vuelo);
                    idAterrisaje = MainActivity.idVuelo;
                }
            }
        }

    }
    public void guardarVuelo(View view) {
        Avion avion = (Avion) comboAvion.getSelectedItem();
        int idAvion =  avion.getId_avion();

        if(fecha.getText().toString().equals("")){
            msg("ingrese la fecha");
        }else if(hora.getText().toString().equals("")){
            msg("ingrese la hora");
        }else if(idAvion == 0){
            msg("Seleccione el avion");
        }else if(txtDespeje.getText().toString().equals("")){
            msg("seleccione el aeropuerto de despeje");
        }else if(txtAterrisaje.getText().toString().equals("")){
            msg("seleccione el aeropuerto de Aterrisaje");
        }else if(economica.getEditText().getText().toString().equals("")){
            msg("ingrese el precio de la clase economica");

        }else if(ejecutiva.getEditText().getText().toString().equals("")){
            msg("ingrese el precio de la clase Ejecutiva");

        }else if(primera.getEditText().getText().toString().equals("")){
            msg("ingrese el precio de la Primera Clase");

        }else {


            parametros.put("origen" , idDespeje);
            parametros.put("destino",idAterrisaje);
            parametros.put("id_avion",idAvion);
            parametros.put("fecha",fecha.getText().toString() +" " + hora.getText().toString());
            parametros.put("economica",economica.getEditText().getText().toString());
            parametros.put("ejecutiva",ejecutiva.getEditText().getText().toString());
            parametros.put("primera",primera.getEditText().getText().toString());
            parametros.put("accion", "guardarVuelo");
            conexion.escribir(parametros);

            limpiar();
        }

    }

    private void limpiar() {
        hora.setText("");
        fecha.setText("");
        txtAterrisaje.setText("");
        txtDespeje.setText("");
        economica.getEditText().setText("");
        ejecutiva.getEditText().setText("");
        primera.getEditText().setText("");
    }


    public void Cancelar(View view) {
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

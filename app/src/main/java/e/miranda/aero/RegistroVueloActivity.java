package e.miranda.aero;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vuelo);
        conexion = new conexion(this);
        fecha = findViewById(R.id.fecha);
        txtAterrisaje = findViewById(R.id.txtAterrisaje);
        txtDespeje = findViewById(R.id.txtDespeje);
        despeje = findViewById(R.id.despeje);
        aterrisaje = findViewById(R.id.aterrisaje);
        hora = findViewById(R.id.hora);
        comboAvion = findViewById(R.id.comboAvion);
        llenarComboAvion();

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

    public void guardarVuelo(View view) {
    }

    public void Cancelar(View view) {
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
}

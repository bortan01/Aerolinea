package e.miranda.aero;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vuelo);
        conexion = new conexion(this);
        fecha = findViewById(R.id.fecha);
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
                final String selectedDate = day + "-" + (month+1) + "-" + year;
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
                final String selectTime = hourOfDay + " : " + minute;
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
      //  ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,opciones);
        ArrayAdapter<Avion>adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,datos);
        comboAvion.setAdapter(adapter);
    }


    public void mapa(View view) {
        MainActivity.opcion= "obtenerCoordenada";
        Intent intent = new Intent(this,MapsActivity.class);
        startActivityForResult(intent,1);
    }
}

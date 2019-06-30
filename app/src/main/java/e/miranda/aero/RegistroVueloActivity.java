package e.miranda.aero;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class RegistroVueloActivity extends AppCompatActivity {

    EditText fecha ,hora;
    int minut, second , hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vuelo);

        fecha = findViewById(R.id.fecha);
        hora = findViewById(R.id.hora);

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
}

package e.miranda.aero;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Vuelo> {
    public Adaptador(Context context, int resource, ArrayList<Vuelo> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Vuelo datos = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom,parent,false);
            TextView fecha = convertView.findViewById(R.id.fechaCustom);
            TextView hora = convertView.findViewById(R.id.horaCustom);
            TextView avion = convertView.findViewById(R.id.avionCustom);
            TextView despeje = convertView.findViewById(R.id.despejeCustom);
            TextView aterrisaje = convertView.findViewById(R.id.destinoCustom);
            ImageButton btnReservar = convertView.findViewById(R.id.btnReservar);
             fecha.setText(datos.getSolofecha());
             hora.setText(datos.getSolohora());
            avion.setText("" + datos.getModelo());
            despeje.setText(datos.getOrigen());
            aterrisaje.setText(datos.getDestino());
            btnReservar.setTag(datos.getIdVuelo());
            return  convertView;
        }
        return  convertView;
    }
}


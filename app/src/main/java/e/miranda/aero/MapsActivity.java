package e.miranda.aero;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {


    private GoogleMap mMap;
//    ArrayList<Datos> listaDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
  //      listaDatos = new ArrayList<>();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

       if(MainActivity.opcion.equals("obtenerCoordenada")){
           LatLng ubicacion = new LatLng(13.637397,-88.787026);
           mMap.addMarker(new MarkerOptions()
                   .position(ubicacion)
                   .title("mi ubicacion")
                   .draggable(true));

           mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,8));
           mMap.setOnMarkerClickListener(this);
           mMap.setOnMarkerDragListener(this);
       }else if(MainActivity.opcion.equals("obtenerAeropuerto")){
           conexion con = new conexion(this);
           con.obteneAeropuerto();
           for(Aeropuerto d: MainActivity.listaAeropuertos){
               LatLng ubicacion = new LatLng(d.getLatiutd(),d.getLongitud());
               mMap.addMarker(new MarkerOptions()
                       .position(ubicacion)
                       .title(d.toString())).setTag(d.idAerppuerto);


               mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,8));
               mMap.setOnMarkerClickListener(this);
               mMap.setOnMarkerDragListener(this);
           }
       }


    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        MainActivity.latitud = marker.getPosition().latitude;
        MainActivity.longitud = marker.getPosition().longitude;

        if(marker.getTag() != null){
            MainActivity.idVuelo = (int)marker.getTag();
            MainActivity.vuelo = marker.getTitle();
        }



        setResult(RESULT_OK);
        finish();
        return true;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}



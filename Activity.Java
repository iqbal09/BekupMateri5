package com.nongkrong.medan;

import android.app.ProgressDialog;
import android.net.ParseException;
import android.os.AsyncTask;
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
import com.nongkrong.medan.setget.Nongkrong;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    ArrayList<Nongkrong> nongkrongList;

    String k = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        nongkrongList = new ArrayList<Nongkrong>();
        new JSONAsyncTask().execute("http://10.10.10.15/nongkrong/list_tempat.php");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);






    }



    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {


        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MapsActivity.this);
            dialog.setMessage("Sedang Mengambil Data...");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONObject jsono = new JSONObject(data);
                    JSONArray jarray = jsono.getJSONArray("tempat");

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);



                        Nongkrong nongkrong = new Nongkrong();
                        nongkrong.setId(object.getString("id_db"));
                        nongkrong.setNama(object.getString("nama"));
                        k += String.valueOf(object.getString("nama") + "|");
                        System.out.println("Nama" + object.getString("nama"));
                        nongkrong.setTempat(object.getString("koordinat"));
                        System.out.println("Koordinat" + object.getString("koordinat"));
                        nongkrongList.add(nongkrong);
                    }
                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();

            if(result == false)
                Toast.makeText(MapsActivity.this, "Unable to fetch data from server", Toast.LENGTH_LONG).show();

        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


//        System.out.println("Ukuran List" + nongkrongList.size() );
//
//        System.out.println("Nama Tempat"+ k);

        //Traversing through the whole list to get all the names
        for (int i = 0; i < nongkrongList.size(); i++) {
            //Storing names to string array

            String id = String.valueOf(nongkrongList.get(i).getId());
            String nama = String.valueOf(nongkrongList.get(i).getNama());
            String tempat = String.valueOf(nongkrongList.get(i).getTempat());

            String[] output = tempat.split(",");
            Double lati = Double.parseDouble(output[0]);
            Double logi = Double.parseDouble(output[1]);

            LatLng kodinat = new LatLng(lati, logi);
            mMap.addMarker(new MarkerOptions().position(kodinat).title(nama));


        }

        // Add a marker in Sydney and move the camera
        LatLng paladium = new LatLng(3.5901067, 98.6715549);
        LatLng sun = new LatLng(3.5824921, 98.66948);
        LatLng centerpoint = new LatLng(3.5920321, 98.6787132);
        mMap.addMarker(new MarkerOptions().position(paladium).title("Paladium"));
        mMap.addMarker(new MarkerOptions().position(centerpoint).title("Center Point"));
        mMap.addMarker(new MarkerOptions().position(sun).title("Sun"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sun));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sun, 15));

       
    }
}

package com.example.myapp.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.activities.ApiService;
import com.example.myapp.activities.ApiServiceGenerator;
import com.example.myapp.activities.models.Compra;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailVentaActivity extends AppCompatActivity {


    private static final String TAG = DetailVentaActivity.class.getSimpleName();
    private Integer id;
    private TextView txt_anumordcom;
    private TextView txt_afecordcom;
    private TextView txt_cliente;
    private TextView txt_formapago;
    private TextView txt_moneda;
    private TextView txt_total;

    private TextView txt_estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_venta);

        txt_anumordcom=(TextView)findViewById(R.id.txt_anumordcom);
        txt_afecordcom=(TextView) findViewById(R.id.txt_afecordcom);
        txt_cliente=(TextView)findViewById(R.id.txt_cliente);
        txt_formapago=(TextView)findViewById(R.id.txt_formapago);
        txt_moneda= (TextView)findViewById(R.id.txt_moneda);
        txt_total= (TextView) findViewById(R.id.txt_total);

        id= getIntent().getExtras().getInt("ID");

        Log.e(TAG, "id:" + id);
        initialize();
    }

    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<Compra>call = service.showCompra(id);

        call.enqueue(new Callback<Compra>() {
            @Override
            public void onResponse(Call<Compra> call, Response<Compra> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        Compra compra = response.body();
                        Log.d(TAG, "compra: " + compra);

                        txt_anumordcom.setText(compra.getAnumordcom());
                        txt_afecordcom.setText(compra.getAfecordcom());
                        txt_cliente.setText(compra.getCliente());
                        txt_formapago.setText(compra.getFormapago());
                        txt_moneda.setText(compra.getMoneda());
                        txt_total.setText("s/. "+compra.getTotal());



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(DetailVentaActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<Compra> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(DetailVentaActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }


    //metodo para aprobar la orden de compra mediante un checkbox
    public void onCheckboxClicked(View view) {
    }



}

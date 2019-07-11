package com.example.myapp.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.activities.service.ApiService;
import com.example.myapp.activities.service.ApiServiceGenerator;
import com.example.myapp.activities.models.Compra;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailVentaActivity extends AppCompatActivity {

    private static final String TAG = DetailVentaActivity.class.getSimpleName();

    private Integer id;
    private TextView anumordcom;
    private TextView afecordcom;
    private TextView cliente;
    private TextView formapago;
    private TextView moneda;
    private TextView total;

    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_venta);
        anumordcom=(TextView)findViewById(R.id.txt_anumordcom);
        afecordcom=(TextView) findViewById(R.id.txt_afecordcom);
        cliente=(TextView)findViewById(R.id.txt_cliente);
        formapago=(TextView)findViewById(R.id.txt_formapago);
        moneda= (TextView)findViewById(R.id.txt_moneda);
        total= (TextView) findViewById(R.id.txt_total);


        updateButton = findViewById(R.id.btn_aprobar);
        updateButton.setOnClickListener( (v)->{ callUpdate();});

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

                        anumordcom.setText(compra.getAnumordcom());
                        afecordcom.setText(compra.getAfecordcom());
                        cliente.setText(compra.getCliente());


                        formapago.setText(compra.getFormapago());
                        moneda.setText(compra.getMoneda());
                        total.setText("s/. "+compra.getTotal());


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

    public void callUpdate(){


    }


    //metodo para aprobar la orden de compra mediante un checkbox
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox)view ).isChecked();
        switch(view.getId()){
            case R.id.checkbox_estado:
                if(checked)

                    Log.d(TAG, "la orden de compra es aprobada y el estado cambia a 1" );
                else
                    Log.d(TAG, "orden de compra en porceso de aprobación");
                break;
        }
    }






}

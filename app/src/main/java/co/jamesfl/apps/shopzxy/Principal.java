package co.jamesfl.apps.shopzxy;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;

public class Principal extends AppCompatActivity {
    private TextView tvValor, tvTotal;
    private Spinner spSexo, spTipoZ, spMarca;
    private EditText etCant;
    private NumberPicker npCant;
    private Resources src;
    private int[][][] precios;
    private AdapterView.OnItemSelectedListener cambioSp;
    private NumberPicker.OnValueChangeListener cambioNp;
    private DecimalFormatSymbols symbols;
    private DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tvValor = (TextView) findViewById(R.id.tvValor);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        spSexo = (Spinner) findViewById(R.id.spSexo);
        spTipoZ = (Spinner) findViewById(R.id.spTipoZapato);
        spMarca = (Spinner) findViewById(R.id.spMarca);
        npCant = (NumberPicker) findViewById(R.id.npCant);
        npCant.setMinValue(1);
        npCant.setMaxValue(20);
        npCant.setWrapSelectorWheel(true);
        src = getResources();
        ArrayAdapter<String> adpSexo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adpSexo.add(src.getString(R.string.item_seleccione));
        adpSexo.addAll(src.getStringArray(R.array.sexo));
        spSexo.setAdapter(adpSexo);
        ArrayAdapter<String> adpTipoZ = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adpTipoZ.add(src.getString(R.string.item_seleccione));
        adpTipoZ.addAll(src.getStringArray(R.array.tiposZapato));
        spTipoZ.setAdapter(adpTipoZ);
        ArrayAdapter<String> adpMarca = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adpMarca.add(src.getString(R.string.item_seleccione));
        adpMarca.addAll(src.getStringArray(R.array.marcas));
        spMarca.setAdapter(adpMarca);

        cambioSp = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                traerValor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        };

        cambioNp = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                if (!tvValor.getText().toString().isEmpty()) {
                    String v = tvValor.getText().toString().replace(".","");
                    int vlr = Integer.parseInt(v);
                    int res = i1 * vlr;
                    tvTotal.setText(df.format(res));
                }
            }
        };

        spSexo.setOnItemSelectedListener(cambioSp);
        spTipoZ.setOnItemSelectedListener(cambioSp);
        spMarca.setOnItemSelectedListener(cambioSp);
        npCant.setOnValueChangedListener(cambioNp);

        symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        df = new DecimalFormat("###,###.##", symbols);
    }

    public void traerValor() {
        if (spSexo.getSelectedItemPosition() > 0 &&
                spTipoZ.getSelectedItemPosition() > 0 &&
                spMarca.getSelectedItemPosition() > 0) {
            int valor = Metodos.calcularTotal(spSexo.getSelectedItemPosition() - 1,
                    spTipoZ.getSelectedItemPosition() - 1,
                    spMarca.getSelectedItemPosition() - 1, 1);
            tvValor.setText(df.format(valor));
            cambioNp.onValueChange(npCant, 0, npCant.getValue());
        } else {
            tvValor.setText("");
            tvTotal.setText("");
        }
    }
}

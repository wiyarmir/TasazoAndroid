package com.wosoft.tasazo;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class CalculadoraTasazoActivity extends Activity {
	private Button bCalcular;
	private RadioButton rGrado;
	private RadioButton rMaster;
	private EditText eC1M;
	private EditText eC2M;
	private EditText eC3M;
	private EditText eC4M;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
			setTheme(android.R.style.Theme_Holo);
		}
		setContentView(R.layout.main);
		bCalcular = (Button) findViewById(R.id.calcular);
		rGrado = (RadioButton) findViewById(R.id.grado);
		rMaster = (RadioButton) findViewById(R.id.master);
		eC1M = (EditText) findViewById(R.id.numcred1);
		eC2M = (EditText) findViewById(R.id.numcred2);
		eC3M = (EditText) findViewById(R.id.numcred3);
		eC4M = (EditText) findViewById(R.id.numcred4);
		bCalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				AlertDialog d = (new AlertDialog.Builder(
						CalculadoraTasazoActivity.this)).setTitle("Resultados")
						.setCancelable(true)
						.setNeutralButton("Cerrar", new OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();

							}
						}).create();

				StringBuilder sb = new StringBuilder();
				DecimalFormat df = new DecimalFormat("0.00");
				int precioCredito = rGrado.isChecked() ? 102 : 238;
				float min1m = 0;
				float max1m = 0;
				if (!eC1M.getText().toString().equals("")) {
					min1m = Float.parseFloat(eC1M.getText().toString()) * 0.15f
							* precioCredito;
					max1m = Float.parseFloat(eC1M.getText().toString()) * 0.25f
							* precioCredito;
					sb.append("Coste total de créditos de primera matrícula:");
					sb.append("\nCoste mínimo:");
					sb.append(df.format(min1m));
					sb.append("€");
					sb.append("\nCoste máximo:");
					sb.append(df.format(max1m));
					sb.append("€");
				}
				float min2m = 0;
				float max2m = 0;
				if (!eC2M.getText().toString().equals("")) {
					min2m = Float.parseFloat(eC2M.getText().toString()) * 0.3f
							* precioCredito;
					max2m = Float.parseFloat(eC2M.getText().toString()) * 0.4f
							* precioCredito;
					sb.append("\nCoste total de créditos de segunda matrícula:");
					sb.append("\nCoste mínimo:");
					sb.append(df.format(min2m));
					sb.append("€");
					sb.append("\nCoste máximo:");
					sb.append(df.format(max2m));
					sb.append("€");
				}
				float min3m = 0;
				float max3m = 0;
				if (!eC3M.getText().toString().equals("")) {
					min3m = Float.parseFloat(eC3M.getText().toString()) * 0.65f
							* precioCredito;
					max3m = Float.parseFloat(eC3M.getText().toString()) * 0.75f
							* precioCredito;
					sb.append("\nCoste total de créditos de tercera matrícula:");
					sb.append("\nCoste mínimo:");
					sb.append(df.format(min3m));
					sb.append("€");
					sb.append("\nCoste máximo:");
					sb.append(df.format(max3m));
					sb.append("€");
				}
				float min4m = 0;
				float max4m = 0;
				if (!eC4M.getText().toString().equals("")) {
					min4m = Float.parseFloat(eC4M.getText().toString()) * 0.9f
							* precioCredito;
					max4m = Float.parseFloat(eC4M.getText().toString())
							* precioCredito;

					sb.append("\nCoste total de créditos de cuarta matrícula:");
					sb.append("\nCoste mínimo:");
					sb.append(df.format(min4m));
					sb.append("€");
					sb.append("\nCoste máximo:");
					sb.append(df.format(max4m));
					sb.append("€");
				}
				sb.append("\nCoste total de créditos:");
				sb.append("\nCoste mínimo:");
				sb.append(df.format(min1m + min2m + min3m + min4m));
				sb.append("€");
				sb.append("\nCoste máximo:");
				sb.append(df.format(max1m + max2m + max3m + max4m));
				sb.append("€");
				d.setMessage(sb.toString());
				d.show();
			}
		});
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_mas:

			AlertDialog d = (new AlertDialog.Builder(this))
					.setTitle(R.string.infoheader)
					.setMessage(R.string.infotext).setCancelable(true)
					.setNeutralButton("Cerrar", new OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();

						}
					}).create();

			d.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity, menu);
		return true;
	}

}
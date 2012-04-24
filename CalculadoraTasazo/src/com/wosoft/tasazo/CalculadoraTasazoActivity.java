package com.wosoft.tasazo;

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

				int precioCredito = rGrado.isChecked() ? 102 : 238;
				float min1m = Float.parseFloat(eC1M.getText().toString()
						.equals("") ? "0" : eC1M.getText().toString())
						* 0.15f * precioCredito;
				float max1m = Float.parseFloat(eC1M.getText().toString()
						.equals("") ? "0" : eC1M.getText().toString())
						* 0.25f * precioCredito;
				float min2m = Float.parseFloat(eC2M.getText().toString()
						.equals("") ? "0" : eC2M.getText().toString())
						* 0.3f * precioCredito;
				float max2m = Float.parseFloat(eC2M.getText().toString()
						.equals("") ? "0" : eC2M.getText().toString())
						* 0.4f * precioCredito;
				float min3m = Float.parseFloat(eC3M.getText().toString()
						.equals("") ? "0" : eC3M.getText().toString())
						* 0.65f * precioCredito;
				float max3m = Float.parseFloat(eC3M.getText().toString()
						.equals("") ? "0" : eC3M.getText().toString())
						* 0.75f * precioCredito;
				float min4m = Float.parseFloat(eC4M.getText().toString()
						.equals("") ? "0" : eC4M.getText().toString())
						* 0.9f * precioCredito;
				float max4m = Float.parseFloat(eC4M.getText().toString()
						.equals("") ? "0" : eC4M.getText().toString())
						* precioCredito;
				StringBuilder sb = new StringBuilder();
				sb.append("Coste total de créditos de primera matrícula:");
				sb.append("\nCoste mínimo:");
				sb.append(min1m);
				sb.append("€");
				sb.append("\nCoste máximo:");
				sb.append(max1m);
				sb.append("€");
				sb.append("\nCoste total de créditos de segunda matrícula:");
				sb.append("\nCoste mínimo:");
				sb.append(min2m);
				sb.append("€");
				sb.append("\nCoste máximo:");
				sb.append(max2m);
				sb.append("€");
				sb.append("\nCoste total de créditos de tercera matrícula:");
				sb.append("\nCoste mínimo:");
				sb.append(min3m);
				sb.append("€");
				sb.append("\nCoste máximo:");
				sb.append(max3m);
				sb.append("€");
				sb.append("\nCoste total de créditos de cuarta matrícula:");
				sb.append("\nCoste mínimo:");
				sb.append(min4m);
				sb.append("€");
				sb.append("\nCoste máximo:");
				sb.append(max4m);
				sb.append("€");
				sb.append("\nCoste total de créditos:");
				sb.append("\nCoste mínimo:");
				sb.append(min1m + min2m + min3m + min4m);
				sb.append("€");
				sb.append("\nCoste máximo:");
				sb.append(max1m + max2m + max3m + max4m);
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
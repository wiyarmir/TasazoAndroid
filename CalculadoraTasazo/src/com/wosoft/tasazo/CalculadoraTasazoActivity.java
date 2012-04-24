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

public class CalculadoraTasazoActivity extends Activity {
	private Button bCalcular;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
			setTheme(android.R.style.Theme_Holo);
		}
		setContentView(R.layout.main);
		bCalcular = (Button) findViewById(R.id.calcular);
		bCalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				AlertDialog d = (new AlertDialog.Builder(
						CalculadoraTasazoActivity.this))
						.setTitle(R.string.infoheader)
						.setMessage(R.string.infotext).setCancelable(true)
						.setNeutralButton("Cerrar", new OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();

							}
						}).create();
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
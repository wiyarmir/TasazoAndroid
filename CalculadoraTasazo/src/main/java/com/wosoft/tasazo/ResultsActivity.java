package com.wosoft.tasazo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ResultsActivity extends Activity {


    protected static double[][][][] mData = {
            { // Grado
                    { // 2010
                            {11.70, 13.50, 18.00, 18.00},
                            {11.70, 13.50, 18.00, 18.00},
                            {11.70, 13.50, 18.00, 18.00},
                            {11.70, 13.50, 18.00, 18.00},
                            {11.70, 13.50, 18.00, 18.00},
                    },
                    { // 2011
                            {12.20, 14.10, 18.30, 18.30},
                            {12.20, 14.10, 18.30, 18.30},
                            {12.20, 14.10, 18.30, 18.30},
                            {12.20, 14.10, 18.30, 18.30},
                            {12.20, 14.10, 18.30, 18.30},
                    },
                    { // 2012
                            {12.49, 24.97, 47.59, 63.46},
                            {12.49, 24.97, 50.28, 67.04},
                            {12.49, 24.97, 54.10, 74.91},
                            {12.49, 24.97, 54.10, 74.91},
                            {12.49, 24.97, 54.10, 74.91},
                    },
                    { //2013
                            {12.62, 25.25, 48.13, 64.17},
                            {12.62, 25.25, 50.84, 67.79},
                            {12.62, 25.25, 54.71, 75.75},
                            {12.62, 25.25, 54.71, 75.75},
                            {12.62, 25.25, 54.71, 75.75},
                    }
            },

            { // Master Habilitante
                    { // 2010
                            {27.60, 31.70, 41.40, 41.40},
                            {27.60, 31.70, 41.40, 41.40},
                            {27.60, 31.70, 41.40, 41.40},
                            {27.60, 31.70, 41.40, 41.40},
                            {27.60, 31.70, 41.40, 41.40},
                    },
                    {
                            {28.60, 32.90, 42.90, 42.90},
                            {28.60, 32.90, 42.90, 42.90},
                            {28.60, 32.90, 42.90, 42.90},
                            {28.60, 32.90, 42.90, 42.90},
                            {28.60, 32.90, 42.90, 42.90},
                    },
                    {
                            {29.51, 59.02, 112.49, 149.99},
                            {29.51, 59.02, 118.84, 158.46},
                            {29.51, 59.02, 127.88, 177.06},
                            {29.51, 59.02, 127.88, 177.06},
                            {29.51, 59.02, 127.88, 177.06},
                    },
                    {
                            {19.50, 39.00, 74.34, 99.12},
                            {19.50, 39.00, 78.53, 104.71},
                            {19.50, 39.00, 84.50, 117.01},
                            {19.50, 39.00, 84.50, 117.01},
                            {19.50, 39.00, 84.50, 117.01},
                    }
            },

            { // Master No Habilitante
                    { // 2010
                            {27.60, 31.70, 41.40, 41.40},
                            {27.60, 31.70, 41.40, 41.40},
                            {27.60, 31.70, 41.40, 41.40},
                            {27.60, 31.70, 41.40, 41.40},
                            {27.60, 31.70, 41.40, 41.40},
                    },
                    {
                            {28.60, 32.90, 42.90, 42.90},
                            {28.60, 32.90, 42.90, 42.90},
                            {28.60, 32.90, 42.90, 42.90},
                            {28.60, 32.90, 42.90, 42.90},
                            {28.60, 32.90, 42.90, 42.90},
                    },
                    {
                            {60.00, 97.50, 97.50, 97.50},
                            {63.38, 103.00, 103.00, 103.00},
                            {71.53, 116.24, 116.24, 116.24},
                            {75.61, 122.87, 122.87, 122.87},
                            {78.69, 127.88, 127.88, 127.88},
                    },
                    {
                            {41.50, 67.44, 67.44, 67.44},
                            {41.50, 67.44, 67.44, 67.44},
                            {41.50, 67.44, 67.44, 67.44},
                            {41.50, 67.44, 67.44, 67.44},
                            {41.50, 67.44, 67.44, 67.44},
                    }
            }
    };

    private double total_12;
    private double total_13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle b = getIntent().getExtras();
        int section = b.getInt("section");
        int careerGroup = b.getInt("careerGroup") - 1;
        float cr1 = b.getFloat("credits1", 0);
        float cr2 = b.getFloat("credits2", 0);
        float cr3 = b.getFloat("credits3", 0);
        float cr4 = b.getFloat("credits4", 0);
        double p1_11 = cr1 * mData[section][1][careerGroup][0];
        double p1_12 = cr1 * mData[section][2][careerGroup][0];
        double p1_13 = cr1 * mData[section][3][careerGroup][0];

        double p2_11 = cr2 * mData[section][1][careerGroup][1];
        double p2_12 = cr2 * mData[section][2][careerGroup][1];
        double p2_13 = cr2 * mData[section][3][careerGroup][1];

        double p3_11 = cr3 * mData[section][1][careerGroup][2];
        double p3_12 = cr3 * mData[section][2][careerGroup][2];
        double p3_13 = cr3 * mData[section][3][careerGroup][2];

        double p4_11 = cr4 * mData[section][1][careerGroup][3];
        double p4_12 = cr4 * mData[section][2][careerGroup][3];
        double p4_13 = cr4 * mData[section][3][careerGroup][3];

        double total_cr = cr1 + cr2 + cr3 + cr4;
        double total_11 = p1_11 + p2_11 + p3_11 + p4_11;
        total_12 = p1_12 + p2_12 + p3_12 + p4_12;
        total_13 = p1_13 + p2_13 + p3_13 + p4_13;

        DecimalFormat df = new DecimalFormat("#,##");
        NumberFormat dfPrice = NumberFormat.getCurrencyInstance(Locale.GERMANY);

        TextView tCr1 = (TextView) findViewById(R.id.creditos1);
        tCr1.setText(df.format(cr1));
        TextView tP1_11 = (TextView) findViewById(R.id.precio1_11);
        tP1_11.setText(dfPrice.format(p1_11));
        TextView tP1_12 = (TextView) findViewById(R.id.precio1_12);
        tP1_12.setText(dfPrice.format(p1_12));
        TextView tP1_13 = (TextView) findViewById(R.id.precio1_13);
        tP1_13.setText(dfPrice.format(p1_13));

        TextView tCr2 = (TextView) findViewById(R.id.creditos2);
        tCr2.setText(df.format(cr2));
        TextView tP2_11 = (TextView) findViewById(R.id.precio2_11);
        tP2_11.setText(dfPrice.format(p2_11));
        TextView tP2_12 = (TextView) findViewById(R.id.precio2_12);
        tP2_12.setText(dfPrice.format(p2_12));
        TextView tP2_13 = (TextView) findViewById(R.id.precio2_13);
        tP2_13.setText(dfPrice.format(p2_13));

        TextView tCr3 = (TextView) findViewById(R.id.creditos3);
        tCr3.setText(df.format(cr3));
        TextView tP3_11 = (TextView) findViewById(R.id.precio3_11);
        tP3_11.setText(dfPrice.format(p3_11));
        TextView tP3_12 = (TextView) findViewById(R.id.precio3_12);
        tP3_12.setText(dfPrice.format(p3_12));
        TextView tP3_13 = (TextView) findViewById(R.id.precio3_13);
        tP3_13.setText(dfPrice.format(p3_13));

        TextView tCr4 = (TextView) findViewById(R.id.creditos4);
        tCr4.setText(df.format(cr4));
        TextView tP4_11 = (TextView) findViewById(R.id.precio4_11);
        tP4_11.setText(dfPrice.format(p4_11));
        TextView tP4_12 = (TextView) findViewById(R.id.precio4_12);
        tP4_12.setText(dfPrice.format(p4_12));
        TextView tP4_13 = (TextView) findViewById(R.id.precio4_13);
        tP4_13.setText(dfPrice.format(p4_13));

        TextView tTotCr = (TextView) findViewById(R.id.creditos_total);
        tTotCr.setText(df.format(total_cr));
        TextView tTot_11 = (TextView) findViewById(R.id.precio_total_11);
        tTot_11.setText(dfPrice.format(total_11));
        TextView tTot_12 = (TextView) findViewById(R.id.precio_total_12);
        tTot_12.setText(dfPrice.format(total_12));
        TextView tTot_13 = (TextView) findViewById(R.id.precio_total_13);
        tTot_13.setText(dfPrice.format(total_13));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.results, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        NumberFormat f = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        switch (item.getItemId()) {
            case R.id.action_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = getString(R.string.sharetext) + f.format(total_13);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Calculadora Tasazo");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Compartir..."));
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }
}

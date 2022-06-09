package com.example.asynctaksapp;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowResults extends AsyncTask<Integer, Integer, Void> {
    /* Declarações */
    Button btnStart;
    TextView txtResultViewNumber;
    TextView txtFeedBack;

    /* Construtor */
    public ShowResults(Button btnStart, TextView txtResultViewNumber, TextView txtFeedBack){
        this.btnStart = btnStart;
        this.txtResultViewNumber = txtResultViewNumber;
        this.txtFeedBack = txtFeedBack;
    }

    /* Ao executar:
    *   */
    @Override
    protected void onPreExecute() {
        btnStart.setEnabled(false);
        txtFeedBack.setVisibility(View.INVISIBLE);
        txtResultViewNumber.setVisibility(View.VISIBLE);
        txtResultViewNumber.setText("0");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        txtResultViewNumber.setText(Integer.toString(values[0]));
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];
        for (int i=0; i<max; i++){
            SystemClock.sleep(1000);
            this.publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        String resultFinal = "A contagem Terminou.";
        btnStart.setEnabled(true);
        txtFeedBack.setText(resultFinal);
        txtFeedBack.setVisibility(View.VISIBLE);
        txtResultViewNumber.setVisibility(View.INVISIBLE);
    }
}

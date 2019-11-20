package com.example.lesson90asynctaskstatus;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MyTask extends AsyncTask<Void, Void, Void> {

    private TextView mTV;

    public MyTask(TextView mTV) {
        this.mTV = mTV;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mTV.setText("Begin");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mTV.setText("End");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        mTV.setText("Cancel");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for (int i = 0; i < 5; i++) {
                if (isCancelled()) return null;
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

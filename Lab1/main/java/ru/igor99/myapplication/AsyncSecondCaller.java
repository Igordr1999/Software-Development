package ru.igor99.myapplication;

import android.os.AsyncTask;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class AsyncSecondCaller extends AsyncTask<FirstActivity, Void, Void> {
    @Override
    protected Void doInBackground(FirstActivity... params) {
        try {
            Thread.sleep(2000);
            FirstActivity callingActivity = params[0];
            callingActivity.callSecondAndDie();
        } catch (Exception e) {
            //Ignore
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {

    }
}
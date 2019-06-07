package com.example.lab2.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lab2.PageFragment;

import org.json.JSONArray;
import org.json.JSONException;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private JSONArray data;

    public ViewPagerAdapter(FragmentManager fm, JSONArray data) {
        super(fm);
        this.data = data;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Header";
    }

    @Override
    public Fragment getItem(int position) {
        position++;
        String graphic = "";
        String helptext = "Helptext";
        try {
            graphic = data.getJSONObject(position).getString("graphic");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            helptext = data.getJSONObject(position).getString("helptext");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new PageFragment(graphic, helptext);
    }

    @Override
    public int getCount() {
        return data.length();
    }
}
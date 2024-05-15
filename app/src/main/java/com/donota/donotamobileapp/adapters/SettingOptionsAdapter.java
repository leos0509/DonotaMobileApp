package com.donota.donotamobileapp.adapters;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.models.SettingOptions;

import java.util.List;

public class SettingOptionsAdapter extends BaseAdapter {
    Activity activity;
    int setting_items_layout;
    List<SettingOptions> settingOptionsList;

    public SettingOptionsAdapter(Activity activity, int setting_items_layout, List<SettingOptions> settingOptionsList) {
        this.activity = activity;
        this.setting_items_layout = setting_items_layout;
        this.settingOptionsList = settingOptionsList;
    }


    @Override
    public int getCount() {
        return settingOptionsList.size();
    }

    @Override
    public Object getItem(int position) {
        return settingOptionsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(setting_items_layout, null);
            holder.imvSettingIcon = view.findViewById(R.id.imvSettingIcon);
            holder.txtSettingName = view.findViewById(R.id.txtSettingName);
            holder.imvNext = view.findViewById(R.id.imvNext);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        SettingOptions settingOptions = settingOptionsList.get(position);
        holder.imvSettingIcon.setImageResource(settingOptions.getSettingIcon());
        holder.txtSettingName.setText(settingOptions.getSettingName().toString());
        holder.imvNext.setImageResource(R.drawable.baseline_navigate_next);
        return view;
    }
    public static class ViewHolder{
        ImageView imvSettingIcon, imvNext;
        TextView txtSettingName;
    }
}


package com.rafyee.rafyee_rajiv.pstuprofile.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rafyee.rafyee_rajiv.pstuprofile.R;
import com.rafyee.rafyee_rajiv.pstuprofile.Models.TeacherUnit;

import java.util.List;

public class TeacherAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<TeacherUnit> teacherUnits;

    public TeacherAdapter(Activity activity, List<TeacherUnit> teacherUnits) {
        this.activity = activity;
        this.teacherUnits = teacherUnits;
    }

    @Override
    public int getCount() {
        return teacherUnits.size();
    }

    @Override
    public Object getItem(int position) {
        return teacherUnits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.teacher_list_item_layout, null);
        }

        TeacherUnit tu = teacherUnits.get(position);
        TextView teacherName = convertView.findViewById(R.id.teacherListItemLayout_teacherName);
        teacherName.setText(tu.getT_name());

        return convertView;

    }
}

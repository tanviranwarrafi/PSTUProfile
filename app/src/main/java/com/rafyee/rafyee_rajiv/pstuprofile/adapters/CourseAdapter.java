package com.rafyee.rafyee_rajiv.pstuprofile.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rafyee.rafyee_rajiv.pstuprofile.R;
import com.rafyee.rafyee_rajiv.pstuprofile.models.CourseUnit;

import java.util.List;

public class CourseAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<CourseUnit> courseUnits;

    public CourseAdapter(Activity activity, List<CourseUnit> courseUnits) {
        this.activity = activity;
        this.courseUnits = courseUnits;
    }

    @Override
    public int getCount() {
        return courseUnits.size();
    }

    @Override
    public Object getItem(int position) {
        return courseUnits.get(position);
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
            convertView = inflater.inflate(R.layout.course_list_item_layout, null);
        }

        CourseUnit su = courseUnits.get(position);
        TextView courseTitle = convertView.findViewById(R.id.courseListItemLayout_coureseTitle);
        courseTitle.setText(su.getCourse_title());

        final String course_title = su.getCourse_title();
        String course_code = su.getCourse_code();
        String course_credit = su.getCredit();

        final View finalConvertView = convertView;

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog courseDialog = new Dialog(finalConvertView.getContext());
                courseDialog.setContentView(R.layout.dialog_course);
                courseDialog.setCancelable(true);

                courseDialog.getWindow().getAttributes().windowAnimations = R.style.LeftToRight;
                courseDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                courseDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                TextView dialogCourseTitle = courseDialog.findViewById(R.id.dialog_course_title);
                dialogCourseTitle.setText(course_title);
                courseDialog.show();
            }
        });
        return convertView;
    }
}


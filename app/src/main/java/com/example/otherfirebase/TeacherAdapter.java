package com.example.otherfirebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class TeacherAdapter extends ArrayAdapter<Teacher> {


    private Activity context;
    private List<Teacher> teacherList;

    public TeacherAdapter(Activity context, List<Teacher> teacherList) {
        super(context, R.layout.sample_layout, teacherList);
        this.context=context;
        this.teacherList = teacherList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);

        Teacher teacher = teacherList.get(position);

        TextView t1=view.findViewById(R.id.nameTextViewId);
        TextView t2=view.findViewById(R.id.ageTextViewId);

        t1.setText("Name: "+ teacher.getName());
        t2.setText("Age: "+ teacher.getAge());

        return view;
    }
}

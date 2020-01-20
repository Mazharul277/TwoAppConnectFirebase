package com.example.otherfirebase;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsStudent extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;

    private List<Teacher> teacherList;
    private TeacherAdapter teacherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        databaseReference= FirebaseDatabase.getInstance().getReference("students");

        teacherList =new ArrayList<>();

        teacherAdapter =new TeacherAdapter(DetailsStudent.this, teacherList);

        listView=findViewById(R.id.listViewId);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                teacherList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Teacher teacher =dataSnapshot1.getValue(Teacher.class);
                    teacherList.add(teacher);
                }
                listView.setAdapter(teacherAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}

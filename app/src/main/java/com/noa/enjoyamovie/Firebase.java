package com.noa.enjoyamovie;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Firebase {
    private DatabaseReference mDatabase;

    public Firebase() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }



    public void saveIntList(List<List<Integer>> intList, String childName,String date) {
        //הפעולה הופכת רשימה דו מימדית למפה ושומרת את המפה בפיירבייס
        Map<String, Object> map = new HashMap<>();
        int i = 0;
        for (List<Integer> list : intList) {
            map.put(Integer.toString(i), list);
            i++;
        }
        mDatabase.child(childName).child(date).setValue(map);
    }


    public interface OnDataLoadedListener{
        void onDataLoaded(List<List<Integer>> arrayList);
    }

    public void  readIntList(OnDataLoadedListener listener,String childName,String date) {
        //הפעולה נכנסת לפיירבייס ובודקת אם יש מידע על השם של הסרט ובתאריך של הסרט ואם המידע קיים היא בונה רשימה דו מימדית שבה היא שמה כל איבר ומחזירה את הרשימה
        List<List<Integer>> intList = new ArrayList<>();
        mDatabase.child(childName).child(date).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                //הפעולה קוראת את המידע מהפיירבייס
                List<List<Integer>> arrayList = new ArrayList<>();
                for (DataSnapshot rowSnapshot : dataSnapshot.getChildren()) {
                    List<Integer> rowList = new ArrayList<>();
                    for (DataSnapshot colSnapshot : rowSnapshot.getChildren()) {
                        int num = colSnapshot.getValue(Integer.class);
                        rowList.add(num);
                    }
                    arrayList.add(rowList);
                }
                listener.onDataLoaded(arrayList);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                // Handle error
            }
        });


    }


}
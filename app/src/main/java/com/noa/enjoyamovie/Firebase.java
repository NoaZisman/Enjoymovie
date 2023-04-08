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

    public int[] flatten(int[][] arr){
        int[] arr2 = new int[4*7];
        for(int i =0;i<4;i++){
            for(int j = 0;j<7;j++){
                arr2[i*4+j] = arr[i][j];
            }
        }
        return arr2;
    }


    public void saveIntList(List<List<Integer>> intList, String childName,String date) {
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
        List<List<Integer>> intList = new ArrayList<>();
        mDatabase.child(childName).child(date).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
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
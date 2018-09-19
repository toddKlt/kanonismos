package world.mania.kanonismos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database

        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference msgRef = database.getReference("message");
//        DatabaseReference updateRef = database.getReference("updates");
        DatabaseReference sectionsRef = database.getReference("sections");

//        msgRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String TAG = "Firebase data";
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                String TAG = "Error";
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//
//        updateRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String TAG = "FIR solution 1";
//                String TAG2 = "FIR solution 2";
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    String childKey = ds.getKey();
////                    String childValue = ds.getValue(String.class);
//                    Log.d(TAG,">>> Key: "+ childKey); //displays the key for the node
//                    Log.d(TAG,">>> Value: "+ ds.getValue());   //gives the value for given keyname
//                }
//
//                Long lastUpdate = dataSnapshot.child("lastUpdate").getValue(long.class);
//                String updateBy = dataSnapshot.child("updateBy").getValue(String.class);
//
//                Log.d(TAG2, "Last update is: " + lastUpdate);
//                Log.d(TAG2, "Last update by: " + updateBy);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                String TAG = "Error";
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });

        sectionsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String TAG = "Section";

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String childKey = ds.getKey();
                    String order = ds.child("order").getValue(String.class);
                    String title = ds.child("title").getValue(String.class);
                    Log.d(TAG,">>> Section Key: "+ childKey +", order: "+order+", title: "+title); //displays the key for the node
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                String TAG = "Error";
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}

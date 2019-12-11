package com.jd.assignemnt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    TextView tv,tv2;
    Button addBtn,OpenGLSbtn;
    ListView list;
    ArrayList <String>addString=new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = findViewById(R.id.sample_text);
        tv2 = findViewById(R.id.sample_textSecond);
        addBtn=findViewById(R.id.addBtn);
        OpenGLSbtn=findViewById(R.id.OpenGLS);
        list=findViewById(R.id.list);

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,addString);

        tv.setText(stringFromJNI());
        tv2.setText(stringFromJNISecond());

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addString.add(stringFromJNISecond());
                list.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Log.d("value",""+addString.size());
                Log.d("value1",addString.toString());
            }
        });

        OpenGLSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,OpenGLS.class));
            }
        });
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String stringFromJNISecond();
}

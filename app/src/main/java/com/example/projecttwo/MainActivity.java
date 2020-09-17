package com.example.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] richName;
    String[] topRich;
    Button infoBtn;
    TextView nameView;
    ListView listView;
    MyAdaptor adapter;
    int[] image={R.drawable.jeffbezos,R.drawable.billgates,R.drawable.bernard,
            R.drawable.warren,R.drawable.larry,R.drawable.amancio,R.drawable.zuckerberg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoBtn = findViewById(R.id.submitBtnId);
        nameView=findViewById(R.id.textViewId);
        listView=findViewById(R.id.listViewId);


        richName=getResources().getStringArray(R.array.Rich_Man);
        topRich=getResources().getStringArray(R.array.Top);

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = nameView.getText().toString();

                Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                intent.putExtra("rich_name",value);
                startActivity(intent);
            }
        });

        adapter=new MyAdaptor(richName,topRich,image,MainActivity.this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                nameView.setText(richName[position]);
            }
        });

    }
}
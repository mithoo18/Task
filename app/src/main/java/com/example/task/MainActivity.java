package com.example.task;

import static com.example.task.R.drawable.index2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String txt1,txt2,imgt1;
    ImageView btn1,btn2,btn3,img1;
    TextView tx1,tx2,tx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        btn1 = findViewById(R.id.btn1);
        img1 = findViewById(R.id.img1);

        ReadConfig readConfig = new ReadConfig();
        final JSONObject jsonObject = readConfig.loadJSONFromAsset(this,"config.json");
        try {
            if(jsonObject !=null){
                txt1 = jsonObject.getString("txt1");
                txt2 = jsonObject.getString("txt2");
                imgt1 = jsonObject.getString("imgt1");
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Null", Toast.LENGTH_SHORT).show();
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Load", Toast.LENGTH_SHORT).show();
                btn1.setImageResource(R.drawable.book1);
                tx1.setText(txt1);
                tx2.setText(txt2);
                Picasso.get().load(imgt1).into(img1);
            }
        });
    }
}
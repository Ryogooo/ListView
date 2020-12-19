package sample.android.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String selectText = intent.getStringExtra("Text");
        int selectPhot = intent.getIntExtra("Phot",0);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(selectText);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(selectPhot);
    }
}

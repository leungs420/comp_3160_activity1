package project.cs.t00531851.comp3160_activity1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    String result = "";
    String text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String result = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            result = extras.getString("send");
        }

        text = result.toUpperCase();
        System.out.println(text);

        Button btn = (Button) findViewById(R.id.btn3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send_back = new Intent(Main2Activity.this, MainActivity.class);
                send_back.putExtra("back", text);
                if(send_back.resolveActivity(getPackageManager()) != null) {
                    startActivity(send_back);
                }
                Log.d("This", text);
            }
        });
    }
}

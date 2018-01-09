package project.cs.t00531851.comp3160_activity1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String result = "";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            result = extras.getString("back");
        }

        TextView textView = (TextView) findViewById(R.id.result_view);
        textView.setText(result);

        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText);
                String text = editText.getText().toString();

                Intent send = new Intent(MainActivity.this, Main2Activity.class);
                send.putExtra("send", text);

                //check if the intent is here and safe to send
                if(send.resolveActivity(getPackageManager()) != null) {
                    startActivity(send);
                }
            }
        });
    }
}

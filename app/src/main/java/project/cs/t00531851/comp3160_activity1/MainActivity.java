package project.cs.t00531851.comp3160_activity1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);

        String result = "";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            result = extras.getString("back");
        }

        TextView textView = (TextView) findViewById(R.id.result_view);
        textView.setText(result);



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String text = preferences.getString("original", "");
        editText.setText(text);

        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("original", editText.getText().toString());
                editor.apply();

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

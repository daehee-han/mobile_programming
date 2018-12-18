
package com.kmu.ndhs;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.EditText;
        import android.widget.TextView;

        import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomMessage = (TextView) findViewById(R.id.welcomMessage);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");
        String message = "환영합니다, " + userID + "님!";

        welcomMessage.setText(message);
    }
}

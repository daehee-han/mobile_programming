
package com.kmu.ndhs;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomMessage = (TextView) findViewById(R.id.welcomMessage);
        final Button boardButton = (Button) findViewById(R.id.boardButton);
        final Button menuButton = (Button) findViewById(R.id.menuButton);

        boardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boardIntent = new Intent(MainActivity.this, BoardActivity.class);
                MainActivity.this.startActivity(boardIntent);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(MainActivity.this, MenuActivity.class);
                MainActivity.this.startActivity(menuIntent);
            }
        });

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");
        String message = "환영합니다, " + userID + "님!";

        welcomMessage.setText(message);
    }
}

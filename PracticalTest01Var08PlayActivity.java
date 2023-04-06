package ro.pub.cs.systems.eim.practicaltest01var08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08PlayActivity extends AppCompatActivity {

    private EditText second_riddle;
    private EditText second_answer;

    private String main_answer;
    private Button check;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08PlayActivity.class);
            switch (view.getId()) {
                case R.id.check_button:
                    if(second_answer.getText().toString() == main_answer)
                        setResult(RESULT_OK, intent);
                    else
                        setResult(RESULT_CANCELED, intent);
                    break;
                case R.id.back_button:
                    String riddle = second_riddle.getText().toString();
                    String answer = main_answer;
                    intent.putExtra(Constants.SECOND_RIDDLE, riddle);
                    intent.putExtra(Constants.SECOND_ANSWER, answer);
                    startActivityForResult(intent, Constants.REQUEST_CODE_SECOND);
            }
            finish();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_play);

        second_riddle = (EditText) findViewById(R.id.riddle_edit_text);
        second_answer = findViewById(R.id.answer_edit_text);

        check = (Button)findViewById(R.id.check_button);
        check.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.MAIN_RIDDLE)) {
            String riddle = intent.getStringExtra(Constants.MAIN_RIDDLE);
            main_answer = intent.getStringExtra(Constants.MAIN_ANSWER);
            second_riddle.setText(riddle);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Resultat oke", Toast.LENGTH_LONG).show();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Resultat not oke", Toast.LENGTH_LONG).show();
            }
        }
    }

}
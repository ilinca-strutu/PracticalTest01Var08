package ro.pub.cs.systems.eim.practicaltest01var08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08 extends AppCompatActivity {
    private Button navigateToSecondaryActivityButton;

    private EditText main_riddle;
    private EditText main_answer;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.main_play_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08PlayActivity.class);
                    String riddle = main_riddle.getText().toString();
                    intent.putExtra(Constants.MAIN_RIDDLE, riddle);
                    String answer = main_answer.getText().toString();
                    intent.putExtra(Constants.MAIN_ANSWER, riddle);
                    startActivityForResult(intent, Constants.REQUEST_CODE);
                    break;
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        main_riddle = findViewById(R.id.main_riddle_edit_text);
        main_answer = findViewById(R.id.main_answer_edit_text);

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.main_play_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

//        Intent intent = getIntent();
//        if (intent != null  && intent.getExtras().containsKey(Constants.SECOND_RIDDLE)) {
//            String riddle = intent.getStringExtra(Constants.SECOND_RIDDLE);
//            String answer = intent.getStringExtra(Constants.SECOND_ANSWER);
//            main_riddle.setText(riddle);
//            main_answer.setText(answer);
//            }
    }


}
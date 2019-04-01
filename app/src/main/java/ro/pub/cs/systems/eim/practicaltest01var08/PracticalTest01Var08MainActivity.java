package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private Button nextActiv = null;
    private EditText riddle = null;
    private EditText answer = null;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.go_next:
                    if (riddle.getText().toString().compareTo("") == 0 || answer.getText().toString().compareTo("") == 0){
                    break;
                }
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
                    intent.putExtra("riddle", riddle.getText().toString());
                    intent.putExtra("answer", answer.getText().toString());
                    startActivityForResult(intent, 1);
                    break;

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        riddle = (EditText)findViewById(R.id.riddle_text);
        answer = (EditText)findViewById(R.id.answer_text);
        nextActiv = (Button)findViewById(R.id.go_next);
        nextActiv.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("riddle", riddle.getText().toString());
        savedInstanceState.putString("rightCount", answer.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("riddle")) {
            riddle.setText(savedInstanceState.getString("riddle"));
        } else {
            riddle.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("answer")) {
            answer.setText(savedInstanceState.getString("answer"));
        } else {
            answer.setText(String.valueOf(0));
        }
    }
}

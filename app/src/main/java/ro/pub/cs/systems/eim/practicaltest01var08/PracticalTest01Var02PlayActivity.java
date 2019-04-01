package ro.pub.cs.systems.eim.practicaltest01var08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var02PlayActivity extends Activity {

    private Button check = null;
    private Button back = null;
    private EditText riddle = null;
    private EditText answer = null;
    private String recvAnswer = null;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    public PracticalTest01Var02PlayActivity ctx;
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.back:
                    setResult(RESULT_OK, null);
                    finish();
                    break;
                case R.id.check:
                    if (answer.getText().toString().compareTo(recvAnswer) == 0) {
                        Toast.makeText(ctx, "correct", Toast.LENGTH_LONG).show();
                    } else {
//                        Toast.makeText(PracticalTest01Var02PlayActivity.context, "correct", Toast.LENGTH_LONG).show();
//                        Log.d("incorrect", "incorrect");
                        Toast.makeText(ctx, "incorrect", Toast.LENGTH_LONG).show();
                    }
                    break;
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        riddle = (EditText)findViewById(R.id.riddle_text);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("riddle")) {
            riddle.setText(intent.getStringExtra("riddle"));
        }
        if (intent != null && intent.getExtras().containsKey("answer")) {
            recvAnswer = new String(intent.getStringExtra("answer"));
        }

        ctx = this;

        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(buttonClickListener);

        check = (Button)findViewById(R.id.check);
        check.setOnClickListener(buttonClickListener);

        answer = (EditText)findViewById(R.id.answer_text);

    }
}

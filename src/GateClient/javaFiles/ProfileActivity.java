package es.gate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView textView = findViewById(R.id.title);
        textView.setPaintFlags(textView.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

    }

    public void editText(View v){
        final int id = Integer.parseInt(v.getTag().toString().substring(2));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set text");
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_Text = input.getText().toString();
                TextView tv;
                switch(id){
                    case 1:
                        tv = findViewById(R.id.profile_sub_text1);
                        tv.setText(m_Text);
                        break;
                    case 2:
                        tv = findViewById(R.id.profile_sub_text2);
                        tv.setText(m_Text);
                        break;
                    case 3:
                        tv = findViewById(R.id.profile_sub_text3);
                        tv.setText(m_Text);
                        break;
                    case 4:
                        tv = findViewById(R.id.profile_sub_text4);
                        tv.setText(m_Text);
                        break;
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

}

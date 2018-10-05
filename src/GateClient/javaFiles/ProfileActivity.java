package es.gate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView userInfo[];
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {


            Log.d("Message", "a");
            userInfo[0].setText(msg.getData().getString("userInfo1"), TextView.BufferType.EDITABLE);
            userInfo[1].setText(msg.getData().getString("userInfo2"), TextView.BufferType.EDITABLE);
            userInfo[2].setText(msg.getData().getString("userInfo3"), TextView.BufferType.EDITABLE);
            userInfo[3].setText(msg.getData().getString("userInfo4"), TextView.BufferType.EDITABLE);
            userInfo[4].setText(msg.getData().getString("userInfo5"), TextView.BufferType.EDITABLE);
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userInfo = new TextView[5];

        userInfo[0] = findViewById(R.id.profile_name);
        userInfo[1] = findViewById(R.id.profile_sub_text1);
        userInfo[2] = findViewById(R.id.profile_sub_text2);
        userInfo[3] = findViewById(R.id.profile_sub_text3);
        userInfo[4] = findViewById(R.id.profile_sub_text4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(249, 143, 116)));

        TextView textView = findViewById(R.id.title);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        new Thread(new ServerConnect("getInfo", "")).start();
    }

    public void editText(View v) {
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
                String changes = "";
                switch (id) {
                    case 1:
                        tv = findViewById(R.id.profile_sub_text1);
                        tv.setText(m_Text);
                        changes = "Inst";
                        break;
                    case 2:
                        tv = findViewById(R.id.profile_sub_text2);
                        tv.setText(m_Text);
                        changes = "Unit";
                        break;
                    case 3:
                        tv = findViewById(R.id.profile_sub_text3);
                        tv.setText(m_Text);
                        changes = "Date";
                        break;
                    case 4:
                        tv = findViewById(R.id.profile_sub_text4);
                        tv.setText(m_Text);
                        changes = "Inter";
                        break;
                }

                changes = String.format("%s&%s&%s", "!setInfo", changes, m_Text);

                new Thread(new ServerConnect("setInfo", changes)).start();
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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class ServerConnect implements Runnable {

        String request;
        String setInfo;
        String communication;

        public ServerConnect(String request, String setInfo) {
            this.request = request;
            this.setInfo = setInfo;
        }

        @Override
        public void run() {
            ServerConnection srv = ServerConnection.getInstance();
            Log.d("threadRun", "start");

            switch (request) {
                case "getInfo": {
                    communication = String.format("!getProfileInfo");
                    break;
                }
                case "setInfo": {
                    communication = String.format("%s", setInfo);
                }
            }

            communication = srv.sendMessage(communication);


            if (request.equals("getInfo")) {
                String strAr[] = communication.split("&");

                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("userInfo1", strAr[0]);
                bundle.putString("userInfo2", strAr[1]);
                bundle.putString("userInfo3", strAr[2]);
                bundle.putString("userInfo4", strAr[3]);
                bundle.putString("userInfo5", strAr[4]);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        }
    }
}

package in.neha.texteditor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnEdit;
    private EditText mEditName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditName = findViewById(R.id.Edt_Name);
        mBtnEdit = findViewById(R.id.Btn_Edit);

        mBtnEdit.setOnClickListener(new BtnEditOnCliclickListener());

    }


    private class BtnEditOnCliclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String name = mEditName.getText().toString();

            Intent intentNextActivity = new Intent(MainActivity.this, NextActivity.class);

            intentNextActivity.putExtra("name", name);

            startActivityForResult(intentNextActivity, 1);

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                String result = data.getStringExtra("EditString");
                mEditName.setText(result);
            }

        }
    }
}


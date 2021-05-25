package in.neha.texteditor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.lang.StringBuffer;


public class NextActivity extends AppCompatActivity {

    String name;
    private TextView mTxtName;
    private EditText mEditName;
    private RadioGroup mRadioGroup;
    private CheckBox mCheckBox;
    private Button mBtnCancel,mBtnSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);
        init();
        String name = getIntent().getStringExtra("name");
        mTxtName.setText(name);


        radioBtnFun();
        reverseString();

        mBtnCancel.setOnClickListener(new CancelBtnOnClickListener());
        mBtnSet.setOnClickListener(new SetBtnOnClickListener());

    }

    public void init(){

        mTxtName = findViewById(R.id.Txt_Name);
        mEditName=findViewById(R.id.Edt_Name);
        mRadioGroup = findViewById(R.id.Rbtn_Group);
        mCheckBox =(CheckBox) findViewById(R.id.checkbox);
        mBtnSet = findViewById(R.id.btn_set);
        mBtnCancel =findViewById(R.id.btn_Cancel);
    }


    public void radioBtnFun() {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.Rbtn_Upper) {

                    String name = mTxtName.getText().toString().toUpperCase();
                    mTxtName.setText(name);

                }


                if (checkedId == R.id.Rbtn_Lower) {

                    String name = mTxtName.getText().toString().toLowerCase();
                    mTxtName.setText(name);

                }

                if (checkedId == R.id.Rbtn_Initcap) {


                    String name = mTxtName.getText().toString().substring(0, 1).toUpperCase() + mTxtName.getText().toString().substring(1).toLowerCase();
                    mTxtName.setText(name);

                }
            }
        });
    }


    public  void reverseString(){

       mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    StringBuffer sb = new StringBuffer(mTxtName.getText().toString());
                    sb.reverse();
                     mTxtName.setText(sb.toString());
                }
            }
        });

        }

       private class  CancelBtnOnClickListener implements View.OnClickListener{

           @Override
           public void onClick(View v) {

               finish();
           }
       }

       private class  SetBtnOnClickListener implements View.OnClickListener{

            @Override
            public void onClick(View v) {

                String name=mTxtName.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("EditString",name);
                setResult(RESULT_OK,intent1);
                finish();

        }
    }

}




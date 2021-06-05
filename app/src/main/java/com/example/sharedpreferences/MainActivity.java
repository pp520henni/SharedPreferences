package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SPUser mSPUser;
    private EditText mPutDataEdit;
    private Button mPutDataButton;
    private Button mGetDataButton;
    private TextView mDataTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化SPUser类
        mSPUser = SPUser.getInstance(this);

        mPutDataEdit = findViewById(R.id.edit_data);
        mPutDataButton = findViewById(R.id.put_data_button);
        mPutDataButton.setOnClickListener(this);
        mGetDataButton = findViewById(R.id.get_data_button);
        mGetDataButton.setOnClickListener(this);
        mDataTextView = findViewById(R.id.data_textview);
    }

    @Override
    public void onClick(View view) {
        if(view == mPutDataButton){
            //提交数据
            SPUser.putString("content", mPutDataEdit.getText().toString());
            Toast.makeText(this,"保存数据成功:" + mPutDataEdit.getText().toString(), Toast.LENGTH_SHORT).show();
        }else if(view == mGetDataButton){
            //获取数据
            String content = SPUser.getString("content");
            mDataTextView.setText(content);
        }
    }
}
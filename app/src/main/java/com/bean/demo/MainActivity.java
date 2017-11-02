package com.bean.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bean.demo.widget.GomeBeanLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText mEditView;

    private GomeBeanLayout mBeanLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBeanLayout = this.findViewById(R.id.bean_layout);
        mEditView = this.findViewById(R.id.bean_edit);
    }

    public void onClickView(View view) {

        if(!mBeanLayout.isAnimFinish()){

            Toast.makeText(this,"动画还没有结束",Toast.LENGTH_SHORT);
            return;
        }

        if(TextUtils.isEmpty(mEditView.getText().toString())){

            Toast.makeText(this,"输入框为空",Toast.LENGTH_SHORT);
            return;
        }
        String beanNumber = mEditView.getText().toString();
        if(!isNumeric(beanNumber)){
            Toast.makeText(this,"输入框为中只能输入数字",Toast.LENGTH_SHORT);
            return;
        }
        mBeanLayout.setBeanText(beanNumber);
    }

    public  boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}

package com.enjoylife.ironghui.enjoylife.login.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.enjoylife.ironghui.enjoylife.R;
import com.enjoylife.ironghui.enjoylife.login.service.RegisterCodeTimerService;
import com.enjoylife.ironghui.enjoylife.login.time.RegisterCodeTimer;
import com.enjoylife.ironghui.enjoylife.mainactivity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginTwoActivity extends AppCompatActivity {
    private TextView tv_code1;
    private TextView tv_code2;
    private TextView tv_code3;
    private TextView tv_code4;
    private TextView tv_code5;
    private TextView tv_code6;
    private View v1;
    private View v2;
    private View v3;
    private View v4;
    private View v5;
    private View v6;
    private EditText et_code;
    private List<String> codes = new ArrayList<>();
    private TextView textView;
    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logintwo);
        initView();
        initEvent();
        initClick();
    }

    private void initClick() {
        RegisterCodeTimerService.setHandler(mCodeHandler);
        mIntent = new Intent(LoginTwoActivity.this, RegisterCodeTimerService.class);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setEnabled(false);
                startService(mIntent);
            }
        });

    }

    Handler mCodeHandler = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void handleMessage(Message msg) {
            if (msg.what == RegisterCodeTimer.IN_RUNNING) {// 正在倒计时
                textView.setText(msg.obj.toString());
                textView.setBackground(getResources().getDrawable(R.drawable.sendmsg));
                textView.setTextColor(getResources().getColor(R.color.fasongduanxziti));
            } else if (msg.what == RegisterCodeTimer.END_RUNNING) {// 完成倒计时
                textView.setEnabled(true);
                textView.setText(msg.obj.toString());
                textView.setBackground(getResources().getDrawable(R.drawable.sendretry));
                textView.setTextColor(getResources().getColor(R.color.white));
                Toast.makeText(LoginTwoActivity.this, "链接java接口发送短信", Toast.LENGTH_SHORT).show();
            }
        }

    };

    //注销服务
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(mIntent);
    }

    private void initView() {
        tv_code1 = (TextView) findViewById(R.id.tv_code1);
        tv_code2 = (TextView) findViewById(R.id.tv_code2);
        tv_code3 = (TextView) findViewById(R.id.tv_code3);
        tv_code4 = (TextView) findViewById(R.id.tv_code4);
        tv_code5 = (TextView) findViewById(R.id.tv_code5);
        tv_code6 = (TextView) findViewById(R.id.tv_code6);
        et_code = (EditText) findViewById(R.id.et_code);
        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
        v4 = findViewById(R.id.v4);
        v5 = findViewById(R.id.v5);
        v6 = findViewById(R.id.v6);
        textView = findViewById(R.id.timer);
    }

    //监听输入操作
    private void initEvent() {
        //验证码输入
        et_code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    et_code.setText("");
                    if (codes.size() < 6) {
                        codes.add(editable.toString());
                        showCode();
                    }
                }
                if (codes.size() == 6) {
                    StringBuilder sb = new StringBuilder();
                    for (String code : codes) {
                        sb.append(code);
                    }
                    String code = sb.toString();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        // 监听验证码删除按键
        et_code.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_DEL && keyEvent.getAction() == KeyEvent.ACTION_DOWN && codes.size() > 0) {
                    codes.remove(codes.size() - 1);
                    showCode();
                    return true;
                }
                return false;
            }
        });
    }

    //显示输入的验证码
    private void showCode() {
        String code1 = "";
        String code2 = "";
        String code3 = "";
        String code4 = "";
        String code5 = "";
        String code6 = "";
        if (codes.size() >= 1) {
            code1 = codes.get(0);
        }
        if (codes.size() >= 2) {
            code2 = codes.get(1);
        }
        if (codes.size() >= 3) {
            code3 = codes.get(2);
        }
        if (codes.size() >= 4) {
            code4 = codes.get(3);
        }
        if (codes.size() >= 5) {
            code5 = codes.get(4);
        }
        if (codes.size() >= 6) {
            code6 = codes.get(5);
        }
        tv_code1.setText(code1);
        tv_code2.setText(code2);
        tv_code3.setText(code3);
        tv_code4.setText(code4);
        tv_code5.setText(code5);
        tv_code6.setText(code6);

    }

}

package com.xunz.commonproject.center.view;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xunz.commonproject.MainActivity;
import com.xunz.commonproject.R;
import com.xunz.commonproject.base.BaseActivity;
import com.xunz.commonproject.center.callback.IPhoneCodeCallback;
import com.xunz.commonproject.center.callback.IRegisterCallback;
import com.xunz.commonproject.center.presenter.PhoneCodePresenter;
import com.xunz.commonproject.center.presenter.RegisterPresenter;
import com.xunz.commonproject.common.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册页面
 * 作者: liangzixun
 * 时间: 2017/12/14 10:02
 * 邮箱: liangzixun@eims.com.cn
 */
public class RegisterActivity extends BaseActivity implements IRegisterCallback,
        IPhoneCodeCallback {


    @BindView(R.id.ivBack)
    ImageView ivBack;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.rlTop)
    RelativeLayout rlTop;
    @BindView(R.id.etAccount)
    EditText etAccount;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etCode)
    EditText etCode;
    @BindView(R.id.ivCorrect)
    ImageView ivCorrect;
    @BindView(R.id.tvGetCode)
    TextView tvGetCode;
    @BindView(R.id.ivRegister)
    ImageView ivRegister;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.tvRules)
    TextView tvRules;
    @BindView(R.id.tvLoginRec)
    TextView tvLoginRec;
    @BindView(R.id.llRoot)
    LinearLayout llRoot;
    private boolean flag = false;
    private String code;

    private RegisterPresenter mRegisterPresenter;
    private PhoneCodePresenter mPhoneCodePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (flag) {
                    checkbox.setChecked(false);
                    flag = false;
                } else {
                    checkbox.setChecked(true);
                    flag = true;
                }
            }
        });

        etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals(code)) {
                    ivCorrect.setVisibility(View.VISIBLE);
                } else {
                    ivCorrect.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void initData() {
        tvTitle.setVisibility(View.GONE);
        mRegisterPresenter = new RegisterPresenter(mContext);
        mRegisterPresenter.setIRegisterView(this);
        mPhoneCodePresenter = new PhoneCodePresenter(mContext);
        mPhoneCodePresenter.setIFindPasswordView(this);
    }

    CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            int time = (int) (millisUntilFinished / 1000);
            tvGetCode.setText(time + "秒后重发");
            tvGetCode.setEnabled(false);
        }

        @Override
        public void onFinish() {
            tvGetCode.setText("获取验证码");
            tvGetCode.setEnabled(true);
        }
    };

    @OnClick({R.id.ivBack, R.id.tvGetCode, R.id.ivRegister, R.id.tvRules, R.id.tvLoginRec})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.tvGetCode:
                getCode();
                break;
            case R.id.ivRegister:
                register();
                break;
            case R.id.tvRules:

                break;
            case R.id.tvLoginRec:
//                startTo(LoginActivity.class);
                finish();
                break;
        }
    }

    private void register() {
        String mobile = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        String code = etCode.getText().toString();
        if (StringUtil.isEmpty(mobile)) {
            showToast("请输入手机号");
            return;
        }
        if (StringUtil.isEmpty(password)) {
            showToast("请输入密码");
            return;
        }
        if (StringUtil.isEmpty(code)) {
            showToast("请输入验证码");
            return;
        }
        if (!flag) {
            showToast("没有同意协议");
            return;
        }
        mRegisterPresenter.appRegister(code, password, mobile);
    }

    private void getCode() {
        String mobile = etAccount.getText().toString();
        if (StringUtil.isEmpty(mobile)) {
            showToast("请输入手机号");
            return;
        }
        mPhoneCodePresenter.getValidateCode(mobile, "1");
    }

    @Override
    public void onRegisterSuccess() {
        showToast("注册成功");
//        startTo(LoginActivity.class);
        startTo(MainActivity.class);
        finish();
    }

    @Override
    public void onGetPhoneCodeSuccess(String code) {
        showToast("验证码获取成功");
        timer.start();
        this.code = code;
    }

    @Override
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();
        }
        super.onDestroy();
    }
}

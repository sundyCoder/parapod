package com.parapod.main;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.parapod.main.R;
import com.parapod.util.MD5Util;
import com.parapod.util.NetWorkUtil;
import com.parapod.util.PostandGetConnectionUtil;
import com.parapod.util.SharedPreferenceUtil;
import com.parapod.util.ToastUtil;
import com.parapod.util.GetIntentInstance;

import android.os.Bundle;
import android.os.Message;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.NameValuePair;

public class MainActivity extends Activity {

	Button btLogin;
	private ProgressDialog pd;
	Intent intent = GetIntentInstance.getIntent();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_login);

		btLogin = (Button)findViewById(R.id.bt_login);
		btLogin.setOnClickListener(new MyOnClickListener(0));
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {// handler���յ���Ϣ��ͻ�ִ�д˷���
			pd.dismiss();// �ر�ProgressDialog
			String out = (String) msg.obj;
			if (out.equals("ok")) {
				ToastUtil.show(getApplicationContext(), "��¼�ɹ���");
				setResult(RESULT_OK, intent);
				MainActivity.this.finish();
			} else if (out.equals("not_exist")) {
				ToastUtil.show(getApplicationContext(), "�ʺŲ����ڣ������µ�¼");
			} else if (out.equals("password_error")) {
				ToastUtil.show(getApplicationContext(), "���벻��ȷ������������");
			} else {
				ToastUtil.show(getApplicationContext(), "��¼ʧ���˰���");
			}
		}
	};

	public void login() {
		if (!NetWorkUtil.isNetworkConnected(this.getApplicationContext())) {
			ToastUtil.show(getApplicationContext(), "������񲻿��ã���������״̬��");
			return;
		}

		pd = ProgressDialog.show(MainActivity.this, "��¼��", "�����У����Ժ󡭡�");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				EditText user_name = (EditText) findViewById(R.id.et_username);
				EditText user_password = (EditText) findViewById(R.id.et_password);
				String username = user_name.getText().toString();
				String password = user_password.getText().toString();
				HttpResponse httpResponse = null;
				List<NameValuePair> list = new ArrayList<NameValuePair>();
//				String passwordMd5 = MD5Util.encryptToMD5(password); //encryption have some problems.
				String passwordMd5 = password;
				list.add(new BasicNameValuePair("username", username));
				list.add(new BasicNameValuePair("password", passwordMd5));
				if (username.length() == 0 || password.length() == 0) {
					ToastUtil.show(getApplicationContext(), "�������û���������");
					return;
				}
				PostandGetConnectionUtil.setParm(list);
				try {
					httpResponse = PostandGetConnectionUtil
							.postConnect(PostandGetConnectionUtil.loginUrl);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (httpResponse != null
						&& PostandGetConnectionUtil.responseCode(httpResponse) == 200) {
					String message = PostandGetConnectionUtil
							.GetResponseMessage(httpResponse);
					// Toast.makeText(getApplicationContext(), message,
					// Toast.LENGTH_SHORT).show();
					JsonRet o = new DecodeJson().jsonRet(message);
					if (o.getRet().equals("ok")) {
//						SharedPreferenceUtil.setLogin(true);
						String o1 = "ok";
						Message msg = new Message();
						msg.obj = o1;
						handler.sendMessage(msg);
					} else if (o.getRet().equals("not_exist")) {
						String o1 = "not_exist";
						Message msg = new Message();
						msg.obj = o1;
						handler.sendMessage(msg);
						// ToastUtil.show(getApplicationContext(),
						// "�ʺŲ����ڣ������µ�¼");
					} else if (o.getRet().equals("password_error")) {
						String o1 = "password_error";
						Message msg = new Message();
						msg.obj = o1;
						handler.sendMessage(msg);
						// ToastUtil.show(getApplicationContext(),
						// "���벻��ȷ������������");
					} else {
						String o1 = "error";
						Message msg = new Message();
						msg.obj = o1;
						handler.sendMessage(msg);
						// ToastUtil.show(getApplicationContext(), "��¼ʧ���˰���");
					}
				} else {
					String o1 = "error";
					Message msg = new Message();
					msg.obj = o1;
					handler.sendMessage(msg);
					// ToastUtil.show(getApplicationContext(),
					// "������������⣬��Ҳ��֪����ô��Ŷ��");
				}
				// handler.sendEmptyMessage(0);// ִ�к�ʱ�ķ���֮��������handler
			}
		}).start();
	}
	
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;
		public MyOnClickListener(int i) {
			index = i;
		}

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.bt_login: {
				login();
				break;
			}
			}
		}
	}
}

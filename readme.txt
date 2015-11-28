1. 我的代码全部放在client\app\src\main\java\com\parapod下面在，其实你的那个example目录可以去掉，直接更改我的main目录下面的文件 MainActivity.java
  把里面的
   EditText user_name = (EditText) findViewById(R.id.et_username);
	
   EditText user_password = (EditText) findViewById(R.id.et_password);
这两行改成你的username和pasword标签的名字
  应该是这样:
   AutoCompleteTextView mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
   EditText mPasswordView = (EditText) findViewById(R.id.password);

这个是登录按钮:
   btLogin = (Button)findViewById(R.id.bt_login);
   应该是改成你的:
   btLogin = (Button) findViewById(R.id.email_sign_in_button);


还有指定layout：
  setContentView(R.layout.layout_login);
  应该是改成你的
  setContentView(R.layout.activity_login)；


2. 加各种访问权限
   在AndroidManifest.xml文件的
  <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
  这一行下面加上如下代码:
  <uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	<uses-permission android:name="android.permission.CHANGE_CONFIGURATION" />
  <uses-permission android:name="android.permission.WRITE_SETTINGS" /> 
  
你先这样改，试试可行否。
  
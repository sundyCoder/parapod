1. �ҵĴ���ȫ������client\app\src\main\java\com\parapod�����ڣ���ʵ����Ǹ�exampleĿ¼����ȥ����ֱ�Ӹ����ҵ�mainĿ¼������ļ� MainActivity.java
  �������
   EditText user_name = (EditText) findViewById(R.id.et_username);
	
   EditText user_password = (EditText) findViewById(R.id.et_password);
�����иĳ����username��pasword��ǩ������
  Ӧ��������:
   AutoCompleteTextView mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
   EditText mPasswordView = (EditText) findViewById(R.id.password);

����ǵ�¼��ť:
   btLogin = (Button)findViewById(R.id.bt_login);
   Ӧ���Ǹĳ����:
   btLogin = (Button) findViewById(R.id.email_sign_in_button);


����ָ��layout��
  setContentView(R.layout.layout_login);
  Ӧ���Ǹĳ����
  setContentView(R.layout.activity_login)��


2. �Ӹ��ַ���Ȩ��
   ��AndroidManifest.xml�ļ���
  <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
  ��һ������������´���:
  <uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	<uses-permission android:name="android.permission.CHANGE_CONFIGURATION" />
  <uses-permission android:name="android.permission.WRITE_SETTINGS" /> 
  
���������ģ����Կ��з�
  
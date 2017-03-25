package com.example.anmolsharma.minifinance;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class Loginpage extends AppCompatActivity {

    Registerpage rp;
    DatabaseHelper db;
   static int loginenroll,loginlone,famount,fmonth,finterest;
  static   String loginpass,loginph;
    TextView welcometext,infotext;
    Button doneb,updateb;


    //yha ?no batao classrkea register page par
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
try{
        welcometext=(TextView)findViewById(R.id.welcometextview);
        infotext=(TextView) findViewById(R.id.infotextview);
        doneb=(Button) findViewById(R.id.donebutton);
        updateb=(Button) findViewById(R.id.updatebutton);
        rp=new Registerpage();


            db = new DatabaseHelper(this);
            db.getReadableDatabase();
            loginenroll=rp.logenroll;
            loginpass=rp.logpass;
            loginlone=rp.loglone;
            loginph=rp.logph;
    Log.e("ERROR",""+loginlone+loginenroll+loginph+loginpass);
        }catch(Exception e){e.printStackTrace();}

        finterest=((loginlone/14));
        famount=loginlone+finterest;
        fmonth=(famount/12);

        welcometext.setText("WELCOME " + loginenroll);
        infotext.setText("HELLO, YOUR LOAN AMOUNT IS " + loginlone + ",Now by adding 14% interest in your loan amount,Your final amount per annum becomes  "+ famount + ",Your per month amount pay will be "+ fmonth );

       /* final Intent intent=new Intent(getApplicationContext(),Loginpage.class);
        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

        SmsManager sms= SmsManager.getDefault();
        sms.sendTextMessage(loginph, null, "Please Pay you due amount of this month " + fmonth, pi,null);*/

    }

    public void ubutton(View v)
    {
       Intent i = new Intent(Loginpage.this,Signuppage.class);
        startActivity(i);
    }

    public void dbutton(View v)
    {
      //  final Intent intent=new Intent(getApplicationContext(),Loginpage.class);
        //PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
try{
        SmsManager sms = SmsManager.getDefault();
        PendingIntent sentPI;
        String SENT =  "Please Pay you due amount of this month " + fmonth;

        sentPI = PendingIntent.getBroadcast(this, 0,new Intent(SENT), 0);

        sms.sendTextMessage(loginph, null,  "Please Pay you due amount of this month " + fmonth, sentPI, null);






           // SmsManager sms = SmsManager.getDefault();
           // sms.sendTextMessage(loginph, null, "Please Pay you due amount of this month " + fmonth, pi, null);
            Toast.makeText(getApplicationContext(),"sms sent",Toast.LENGTH_LONG).show();
        }catch (Exception e){e.printStackTrace();}

        final Intent j =new Intent(Loginpage.this,Registerpage.class);
        startActivity(j);
    }
}

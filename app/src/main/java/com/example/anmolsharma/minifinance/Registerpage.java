package com.example.anmolsharma.minifinance;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Registerpage extends AppCompatActivity {

    Button signup;
    Button login;
    EditText enrollid;
    EditText password;
    RelativeLayout registerlayout;
    TextView forgettext;
   static int enroll = 0,getenrollid,result=0,logenroll=0,loglone=0,getlone=0;
   static String pass,getpassword,logpass,logph,getph;
    MyDb dbnew;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);


      //  registerlayout = (RelativeLayout) findViewById(R.id.registerlayout);
        //registerlayout.setVisibility(View.VISIBLE);
        signup = (Button) findViewById(R.id.Signup);
        login = (Button) findViewById(R.id.Login);
        enrollid = (EditText) findViewById(R.id.enrollid);
        password = (EditText) findViewById(R.id.password);
        forgettext = (TextView) findViewById(R.id.forgettext);







      //  pass = password.getText().toString();

        signup.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                final Intent intent = new Intent(Registerpage.this,Signuppage.class);
                Registerpage.this.startActivity(intent);
            }

        });

        login.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                db = new DatabaseHelper(Registerpage.this);
                //dbnew.get();
                try {
                    enroll = Integer.parseInt(enrollid.getText().toString());
                }catch(Exception e){System.out.println(e);}
                 pass = password.getText().toString();
                Cursor cr=db.getalldata();
                while(cr.moveToNext())
                {

                        getenrollid=cr.getInt(1);
                        getpassword=cr.getString(2);
                    getph=cr.getString(4);
                    getlone=cr.getInt(5);
                        Log.e("AS","" + "done");
                        if(getenrollid==(enroll)&&getpassword.equals(pass)) {
                            try {
                                logpass = getpassword;
                                logph=getph;
                                loglone=getlone;
                                logenroll = getenrollid;
                                Log.e("AS", logpass + "done" + logenroll + logph + loglone);
                               // logenroll = getenrollid;
                                final Intent intent = new Intent(Registerpage.this, Loginpage.class);
                               Registerpage.this.startActivity(intent);
                                Toast.makeText(getApplicationContext(), "login sucessful", Toast.LENGTH_LONG).show();
                                result = 1;
                                break;
                            }catch (Exception e){e.printStackTrace();}
                        }
                }

               if(result==0)
                {

                    Toast.makeText(getApplicationContext(),"check enrollid or password",Toast.LENGTH_LONG).show();
                }

                /*getting the values */

                //tumhara code bhee sahi hoga
                //actually value tum tab read karoage jab tum button dabaoge samjhe haan sir
                //but sir apne onclicklistener ko comment kar dia shayad

                //na sahi hn
                //


                Log.e("SJ","done ");


            }


        });

    }
}

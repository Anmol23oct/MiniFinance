package com.example.anmolsharma.minifinance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Signuppage extends AppCompatActivity {


    EditText nameedit;
    EditText enrolledit;
    EditText passedit;
    EditText addressedit;
    EditText loanedit;
    EditText phnoedit;
    Button donebutton;
    String nedit,aedit,pedit,phedit;
    int eedit,ledit,length;
    MyDb dbnew;
    Registerpage rp;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);


        nameedit=(EditText) findViewById(R.id.nameedit);
        enrolledit=(EditText) findViewById(R.id.enrolledit);
        passedit=(EditText) findViewById(R.id.passedit);
        addressedit=(EditText) findViewById(R.id.addressedit);
        loanedit=(EditText) findViewById(R.id.loanedit);
        phnoedit=(EditText) findViewById(R.id.phnoedit);
        donebutton=(Button) findViewById(R.id.donebutton);
        //signuppage=(RelativeLayout) findViewById(R.id.signuplayout);

        //signuppage.setVisibility(View.VISIBLE);


        db =new DatabaseHelper(Signuppage.this);

      donebutton.setOnClickListener(new Button.OnClickListener()
      {
          public void onClick(View v){

              try
              {
                  eedit = Integer.parseInt(enrolledit.getText().toString());
                  //  length = (int) Math.log10(eedit) + 1;

              }catch (NumberFormatException nfe){
                  Log.i("Could not parse ", nfe.toString());

              }
   try {
          phedit = phnoedit.getText().toString();
               }catch(Exception e){e.printStackTrace();}
           try{
                ledit = Integer.parseInt(loanedit.getText().toString());
               }catch (Exception e ){e.printStackTrace();}
              pedit = passedit.getText().toString();
              nedit = nameedit.getText().toString();
              aedit=addressedit.getText().toString();

              Log.e("SJ","done ");

            boolean isinserted= db.insertdata(eedit, pedit, aedit, phedit, ledit, nedit);
              if(isinserted=true)
              {
                  Toast.makeText(getApplicationContext(),"data inserted",Toast.LENGTH_LONG).show();
                  startActivity(new Intent(Signuppage.this, Registerpage.class));
              }
              else
              {
                  Toast.makeText(getApplicationContext(),"data not inserted",Toast.LENGTH_LONG).show();
              }
          }
      });

    }


}

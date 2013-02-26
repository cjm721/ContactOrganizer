package com.example.Assignment2;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	int button = 0;
	

	static int numIntContacts = 0;
	static String[][] internalContacts = new String[5][4];
	
	static int numExtContacts = 0;
	static String[][] externalContacts = new String[5][4];

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RadioGroup choice = (RadioGroup) findViewById(R.id.radioGroup1);
		choice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener () {
		    public void onCheckedChanged(RadioGroup group, int id) {
		        System.out.println(id);
		    	if(id == 0x7f070018){
		        	internal();
		        }else{
		        	external();
		        }
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void internal(){
		button = 0;
		((TextView)findViewById(R.id.mainText)).setText("Internal Contact Informaion");
		((TextView)findViewById(R.id.FIELD3)).setText("Department:");
		((TextView)findViewById(R.id.FIELD4)).setText("Extension:");
	}
	
	public void external(){
		button = 1;
		((TextView)findViewById(R.id.mainText)).setText("External Contact Informaion");
		((TextView)findViewById(R.id.FIELD3)).setText("Company:");
		((TextView)findViewById(R.id.FIELD4)).setText("Phone Number:");
	}
	
	public void addContact(View v){
		if(!checkInput()){
			return;
		}else{
		
			int mode; //0 is Internal 1 is external
			if(((RadioGroup)findViewById(R.id.radioGroup1)).getCheckedRadioButtonId() == R.id.internal){
				internalContacts[numIntContacts][0] = ((EditText)findViewById(R.id.firstName)).getText().toString();
				internalContacts[numIntContacts][1] = ((EditText)findViewById(R.id.lastName)).getText().toString();
				internalContacts[numIntContacts][2] = ((EditText)findViewById(R.id.company)).getText().toString();
				internalContacts[numIntContacts][3] = ((EditText)findViewById(R.id.phoneNumber)).getText().toString();
			
				numIntContacts++;
				mode = 0;
			}else{
				externalContacts[numExtContacts][0] = ((EditText)findViewById(R.id.firstName)).getText().toString();
				externalContacts[numExtContacts][1] = ((EditText)findViewById(R.id.lastName)).getText().toString();
				externalContacts[numExtContacts][2] = ((EditText)findViewById(R.id.company)).getText().toString();
				externalContacts[numExtContacts][3] = ((EditText)findViewById(R.id.phoneNumber)).getText().toString();
				
				numExtContacts++;
				mode = 1;
			}
			showContacts(mode);
		}
	}
	
	public boolean checkInput(){
		boolean pass = true;
		
		AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
		ad.setTitle("Data entry error");
		
		
		if(((EditText)findViewById(R.id.firstName)).getText().toString() == null 
				|| ((EditText)findViewById(R.id.firstName)).getText().toString().equals("")){
			ad.setMessage("Must enter a first name");
			ad.show();
			return false;
		}else if(((EditText)findViewById(R.id.lastName)).getText().toString() == null
				|| ((EditText)findViewById(R.id.lastName)).getText().toString().equals("")){
			ad.setMessage("Must enter a last name");
			ad.show();
			return false;
		}else if(((EditText)findViewById(R.id.company)).getText().toString() == null
				|| ((EditText)findViewById(R.id.company)).getText().toString().equals("")){
			ad.setMessage("Must enter a "+ ((TextView)findViewById(R.id.FIELD3)).getText().toString().toLowerCase() + "name");
			ad.show();
			return false;
		}else if(((EditText)findViewById(R.id.phoneNumber)).getText().toString() == null
				|| ((EditText)findViewById(R.id.phoneNumber)).getText().toString().equals("")){
			ad.setMessage("Must enter a " + ((TextView)findViewById(R.id.FIELD4)).getText().toString().toLowerCase() + " name");
			ad.show();
			return false;
		}
		
		return pass;
	}
	
	public void showContacts(int mode){
		
	}
}

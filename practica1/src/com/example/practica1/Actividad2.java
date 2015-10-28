package com.example.practica1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad2 extends Activity implements OnClickListener {
	String nombre_usuario=getIntent().getExtras().getString("USUARIO");
	String contrasena=getIntent().getExtras().getString("PASS");
	
	TextView user;
	TextView pass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actividad2);
		
		View btn = findViewById(R.id.button1);
		btn.setOnClickListener(this);
		
		user=(TextView)findViewById(R.id.txtUser);
		pass=(TextView)findViewById(R.id.txtPass);
		user.setText(nombre_usuario);
		pass.setText(contrasena);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent regresar = new Intent(this,MainActivity.class);
		startActivity(regresar);
		Toast.makeText(this, "Regresando a la actividad 1", Toast.LENGTH_LONG).show();
		
	}
}

package com.example.practica1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	//declaracion de los elementos del XML que usaremos en el programa
	EditText usuario;
	EditText pass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Boton que cambia de activity
		View btn = findViewById(R.id.button1);
		btn.setOnClickListener(this);
		
		//Boton que activa el fragment
		View btn2 = findViewById(R.id.button2);
		btn2.setOnClickListener(this);
		
		//ASOCIAR LOS OBJETOS EN JAVA CON SUS CORRESPONDIENTES ELEMENTOS XML MEDIANTE EL METODO FINDVIEWBYID
		usuario=(EditText)findViewById(R.id.editUser);
		pass=(EditText)findViewById(R.id.editPass);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
		String user=usuario.getText().toString();
		String password=pass.getText().toString();
		Intent abrir = new Intent(this,Actividad2.class);
		abrir.putExtra("USUARIO",user);
		abrir.putExtra("PASS", password);
		startActivity(abrir);
		Toast.makeText(this, "Pasando a los fragments", Toast.LENGTH_LONG).show();
	}
}

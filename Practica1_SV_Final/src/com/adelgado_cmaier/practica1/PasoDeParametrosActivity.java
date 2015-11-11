package com.adelgado_cmaier.practica1;

import android.app.*;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.*;
import android.os.*;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

public class PasoDeParametrosActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_paso_de_parametros);
		
		//Metodo Bundle para recuperar los parametros del fragment anterior
		//Introducimos los parametros en Strings para poder utilizarlos
		Bundle recupero_parametros=getIntent().getExtras();
		String usuario=recupero_parametros.getString("USER");
		String pass=recupero_parametros.getString("PASS");
		String dir_red=recupero_parametros.getString("DIR_RED");
		String puerto=recupero_parametros.getString("PUERTO");
		
		EditText texto1 = (EditText)findViewById(R.id.prueba1);
		texto1.setText("Usuario: "+usuario+" Pass: "+pass+" Dir: "+dir_red+" Port: "+puerto);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()){
		case R.id.menu_preferencias:
			Toast.makeText(this, "Preferencias", Toast.LENGTH_LONG).show();
			break;
		case R.id.menu_buscar:
			break;
		case R.id.menu_acerca:
			ImageView imagen_acerca_de = new ImageView(this);
			imagen_acerca_de.setImageResource(R.drawable.logo_adcm_3);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(Html.fromHtml("<p><b><u>Práctica 1</u></b> Versión: <b><i><u>7.0</u></i></b></p>"
					+ "<p>Desarrollada por: </p>"
					+ "<p><i><b># Antonio Delgado Pamos</b></i></p>"
					+ "<p><i><b># Cristian Maier </b></i></p>"));
			builder.setPositiveButton("OK", new OnClickListener() {                     
                @Override
                public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                }
            }).setView(imagen_acerca_de);
			builder.create().show();
			break;
		}
		return false;
	}
}

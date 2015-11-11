package com.adelgado_cmaier.practica1;

import android.app.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.os.*;
import android.widget.*;
import android.content.*;

public class DinamicoFragmentDatos extends Fragment{
	
	//Declaramos el objeto de la clase Credencial, despues de almacenar en este objeto los datos
	//nos será más sencillo pasarlos de activity a través del botón del final de esta clase.
	private Credencial credenciales;
	
	//Declaramos los nombres que vamos a darle a los EditText
	private EditText user;
	private EditText pass;
	private EditText red;
	private EditText port;
	
	//Constructor
	public DinamicoFragmentDatos(){
		
	}
	@Override
	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Conservamos información ante cambios de configuración del fragment .
        setRetainInstance(true);
    }

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_dinamico_datos, container, false);
		
		//Declaramos los EditText de nuestro fragment de recogida de datos
		user = (EditText)rootView.findViewById(R.id.editUser);
		pass = (EditText)rootView.findViewById(R.id.editPass);
		red = (EditText)rootView.findViewById(R.id.editRed);
		port = (EditText)rootView.findViewById(R.id.editPuerto);
		
		
		
		
		//Con esto hemos hecho un boton de regreso para que vuelva al fragment primero
		ImageButton boton = (ImageButton)rootView.findViewById(R.id.button$fragment_dinamico_datos$RegresarFragmentIntroduccion);
		boton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DinamicoFragmentInformacion fragmentInfo = new DinamicoFragmentInformacion();
				getFragmentManager().beginTransaction().replace(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos, fragmentInfo).commit();
			}
		});
		
		//Esto es para pasar a la actividad que realizamos el paso de parametros
		//Cuando creamos un activity nuevo, que no se nos olvide declararlo en el AndroidManifest!! Si no, da error
		Button botonActivity = (Button)rootView.findViewById(R.id.button$fragment_dinamico_datos$ActivityPasoParametros);
		botonActivity.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//Almacenamos en Strings la información recogida en los getTexts de nuestro fragment
				String nombre_usuario=user.getText().toString();
				String password=pass.getText().toString();
				String dir_red=red.getText().toString();
				String puerto=port.getText().toString();
				
				//Utilizacion de la clase creada para almacenar las credenciales
				//Usamos el constructor para almacenar todos los datos en un objeto de la clase.
				credenciales = new Credencial(nombre_usuario,password,dir_red,puerto);
				
				Intent act = new Intent(getActivity(),PasoDeParametrosActivity.class);
				//Paso de parametros a la nueva actividad a traves de nuestra clase de almacenamiento CREDENCIAL
				//Tambien podriamos haber pasado los parametros con lo recogido en los EditText, pero ya que hemos
				//realizado esta clase resulta mucho más sencillo.
				act.putExtra("USER", credenciales.getNom_usuario());
				act.putExtra("PASS", credenciales.getPassword());
				act.putExtra("DIR_RED", credenciales.getDir_red());
				act.putExtra("PUERTO", credenciales.getPuerto());
				//Comienzo de la siguiente actividad
				startActivity(act);
			}
		});
		return rootView;
	}
	
}

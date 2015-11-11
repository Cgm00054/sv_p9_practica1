package com.adelgado_cmaier.practica1;

import android.app.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.os.*;
import android.text.Html;
import android.widget.*;
import android.widget.TextView.BufferType;

public class DinamicoFragmentInformacion extends Fragment{
	
	//Constructor
	public DinamicoFragmentInformacion(){
	
	}
	@Override
	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Conservamos información ante cambios de configuración del fragment .
        setRetainInstance(true);
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		setRetainInstance(true);
		View rootView = inflater.inflate(R.layout.fragment_dinamico_introduccion, container, false);
		
		//Con este metodo vamos a escribir texto en un TextView como si fuese HTML para poder
		//formatearlo en negrita, cursiva y demás cada parte del texto.
		TextView texto = (TextView)rootView.findViewById(R.id.textoIntroductorio);
		texto.setText(Html.fromHtml("<p align='justify'>Esta aplicacion"
				+ " ha sido diseñada para la realización de la <b><i>Práctica 1</i></b>"
				+ " de <b><i>Servicios Móviles</i></b>, cuyos objetivos son: "),BufferType.SPANNABLE);
		
		TextView texto2 = (TextView)rootView.findViewById(R.id.caracteristica1);
		texto2.setText(Html.fromHtml("<i><b># Familiarizarse</b> con Android</i>"),BufferType.SPANNABLE);
		
		TextView texto3 = (TextView)rootView.findViewById(R.id.caracteristica2);
		texto3.setText(Html.fromHtml("<i># Crear <b>Apps Sencillas</b> en Android</i>"),BufferType.SPANNABLE);
		
		TextView texto4 = (TextView)rootView.findViewById(R.id.caracteristica3);
		texto4.setText(Html.fromHtml("<i># Diseño de <b>Interfaces de Usuario</b> en Android</i>"),BufferType.SPANNABLE);
		
		TextView texto5 = (TextView)rootView.findViewById(R.id.caracteristica4);
		texto5.setText(Html.fromHtml("<i># Familiarizarse con <b>Gestion de cambios de config.</b></i>"),BufferType.SPANNABLE);
		
		TextView texto6 = (TextView)rootView.findViewById(R.id.caracteristica5);
		texto6.setText(Html.fromHtml("<i># Gestión <b>dinámica</b> del interfaz con <b>Fragments</b></i>"),BufferType.SPANNABLE);
		
		TextView texto7 = (TextView)rootView.findViewById(R.id.caracteristica6);
		texto7.setText(Html.fromHtml("<i># Famil. con el <b>entorno de desarrollo</b></i>"),BufferType.SPANNABLE);
		
		TextView texto8 = (TextView)rootView.findViewById(R.id.caracteristica7);
		texto8.setText(Html.fromHtml("<i><b># Recursos</b> de Referencia de <b>Internet</b></i>"),BufferType.SPANNABLE);
		
		Button boton = (Button)rootView.findViewById(R.id.button$fragment_dinamico_introduccion$PasarFragmentDatos);
		boton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DinamicoFragmentDatos fragmentDatos = new DinamicoFragmentDatos();
				getFragmentManager().beginTransaction().replace(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos, fragmentDatos).commit();
			}
		});
		return rootView;
	}
}

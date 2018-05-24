package com.example.usrgam.dialogoapp;



         import android.app.AlertDialog;
         import android.content.DialogInterface;
         import android.content.Intent;
         import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.util.Log;
         import android.view.LayoutInflater;
         import android.view.View;
         import android.widget.ArrayAdapter;
         import android.widget.Toast;

         import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarDialogo(View view) {
        dialogoMultiChose();
    }

    public void dialogoAlert() {

        AlertDialog.Builder alertDialogo = new AlertDialog.Builder(this);//ES IMPORTANTE VER DE QUE LIBRERIA LLAMAMO ES LA DE LA APP, el contexto es this o getapplication context si estoy en un meoto
        alertDialogo.setTitle("mensaje - titulo");
        alertDialogo.setMessage("cuerpo del mensaje");
        alertDialogo.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Si", Toast.LENGTH_LONG).show();// estoy denttro de un metodo getaplicationcontext
            }
        });
        alertDialogo.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogo.setNeutralButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Cancelar", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogo.setCancelable(false);//para cancelar sin aplastar el boton de cancelar
        alertDialogo.create();
        alertDialogo.show();

    }

    public void dialogoLista() {
        final CharSequence[] items = {"articulo 1", "art 2", "art 3", "art 4"};

        AlertDialog.Builder alertDialogo = new AlertDialog.Builder(this);//ES IMPORTANTE VER DE QUE LIBRERIA LLAMAMO ES LA DE LA APP, el contexto es this o getapplication context si estoy en un meoto
        alertDialogo.setTitle("mensaje - titulo");


        alertDialogo.setNeutralButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Cancelar", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogo.setCancelable(false);//para cancelar sin aplastar el boton de cancelar

        alertDialogo.setItems(items, new DialogInterface.OnClickListener() {
            @Override

            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_LONG).show();
            }
        });

        alertDialogo.create();
        alertDialogo.show();


    }

    private void dialogoSingleChose() {
        final CharSequence[] items = {"articulo 1", "art 2", "art 3", "art 4"};

        AlertDialog.Builder alertDialogo = new AlertDialog.Builder(this);//ES IMPORTANTE VER DE QUE LIBRERIA LLAMAMO ES LA DE LA APP, el contexto es this o getapplication context si estoy en un meoto
        alertDialogo.setTitle("mensaje - titulo");


        alertDialogo.setNeutralButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Cancelar", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogo.setCancelable(false);//para cancelar sin aplastar el boton de cancelar

        alertDialogo.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_LONG).show();
            }
        });

        alertDialogo.create();
        alertDialogo.show();
    }


    private void dialogoMultiChose() {
        final CharSequence[] items = {"articulo 1", "art 2", "art 3", "art 4"};

        final ArrayList seleccionados = new ArrayList();


        AlertDialog.Builder alertDialogo = new AlertDialog.Builder(this);//ES IMPORTANTE VER DE QUE LIBRERIA LLAMAMO ES LA DE LA APP, el contexto es this o getapplication context si estoy en un meoto
        alertDialogo.setTitle("mensaje - titulo");


        alertDialogo.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                String a = "";
                for (int j=0;i<seleccionados.size();j++){
                    Log.e("valor", items[Integer.parseInt(seleccionados.get(j).toString())].toString());

                }
                //
            }
        });
        alertDialogo.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogo.setNeutralButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Cancelar", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogo.setCancelable(false);//para cancelar sin aplastar el boton de cancelar

        alertDialogo.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i, boolean b) {
                if (b){
                    seleccionados.add(i);

                }else{
                    seleccionados.remove(i);
                }

            }
        });

        alertDialogo.create();
        alertDialogo.show();
    }
 public void dialogoPersona(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo_personalizado,null));
        builder.setCancelable(true);
        builder.create();
        builder.show();
 }
}

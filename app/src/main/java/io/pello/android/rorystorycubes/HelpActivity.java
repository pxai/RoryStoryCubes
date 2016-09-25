package io.pello.android.rorystorycubes;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Así es como cargamos un fichero que tenemos en
        // la carpeta RAW de los resources
        InputStream iFile = getResources().openRawResource(R.raw.help);

        // Cargamos el textview donde pondremos la chapa
        TextView helpText = (TextView) findViewById(R.id.textViewHelp);

        // Cargamos el contenido del fichero
        String strFile = leerFichero(iFile);

        // Y ponemos ese contenido en el TextView
        helpText.setText(strFile);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * leerFichero
     * Le pasamos un inputStream y se encarga en devolver todo el contenido
     * en forma de un único String.
     * Versión impresionante y rápida  tal y como se cuenta en:
     * http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html
     *  reading files like a pro
     * @param iFile
     * @return String
     */
    private String leerFichero(InputStream iFile) {
        try {
            return new java.util.Scanner(iFile,"UTF-8").useDelimiter("\\A").next();
        } catch (java.util.NoSuchElementException e) {
            return "";
        }

    }
}

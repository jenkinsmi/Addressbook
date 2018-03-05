package com.example.a2jenkm59.addressbook;

import android.app.AlertDialog;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String info;
        if(item.getItemId() == R.id.save)
        {
            EditText et = (EditText) findViewById(R.id.et1);
            info = et.getText().toString();
        try
        {
             PrintWriter pw =
                     new PrintWriter(new FileWriter( Environment.getExternalStorageDirectory().getAbsolutePath() + "/textedit.txt"));
             pw.println(info);
             pw.close();
        }
        catch(IOException e)
            {
            new AlertDialog.Builder(this).setMessage("I/O Error: " + e).setPositiveButton("OK", null).show();
        }
        }
        return true;
    }

}

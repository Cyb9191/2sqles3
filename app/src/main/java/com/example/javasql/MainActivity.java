package com.example.javasql;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.javasql.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Connection connect;
    String connectionResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void GetConectionSql(View v){
        try{
            Connectorsql connectorsql= new Connectorsql();
            connect = connectorsql.connectionclass();
            if (connect!=null){
                String query="";
                ArrayList surname= new ArrayList();
                Statement st=connect.createStatement();
                ResultSet rs=st.executeQuery(query);
                rs.next();
                System.out.print("name1 "+rs.getString("first_name")+", ");
                surname.add(rs.getString("last_name"));
                rs.next();
                System.out.print("name2"+rs.getString("first_name")+", ");
                surname.add(rs.getString("last_name"));
                rs.next();
                System.out.print("name3"+rs.getString("first_name")+", ");
                surname.add(rs.getString("last_name"));
                rs.next();
                System.out.print("name4"+rs.getInt("first_name")+", ");
                surname.add(rs.getString("last_name"));
                System.out.print(surname);

            } else {
                connectionResult= "check connection";
            }
                    } catch (Exception e){

    }}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
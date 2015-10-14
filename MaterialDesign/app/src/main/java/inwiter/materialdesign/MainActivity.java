package inwiter.materialdesign;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private recyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.dashboard_list1);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        adapter = new recyclerAdapter(MainActivity.this, getData());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), toolbar);



    }

    public static List<dataSet> getData(){
        List<dataSet> dataSetList = new ArrayList<>();
        int[] icons = {R.drawable.contact, R.drawable.contact, R.drawable.contact, R.drawable.contact, R.drawable.contact};
        String[] titles = {"Dummy title 0","Dummy title 1","Dummy title 2","Dummy title 3","Dummy title 4"};
        for(int i=0; i<titles.length && i < icons.length; i++){
            dataSet current = new dataSet();
            current.iconId = icons[i];
            current.title = titles[i];
            dataSetList.add(current);
        }
        return dataSetList;
    }


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
            Toast.makeText(this, "Hey you just clicked: "+item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        if(id == R.id.navigate_createEvent){
            startActivity(new Intent(this, createEvent_activity.class));
        }

        return super.onOptionsItemSelected(item);
    }


}

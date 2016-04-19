package tv.estreams.estreams;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        if (id == R.id.action_deleteDB) {

            //reference de database and, if it exists, delete it
            File dbFile = getDatabasePath("database");
            if (dbFile.exists())
            {
                dbFile.delete();
                Toast.makeText(this, "Deleted Database.", Toast.LENGTH_SHORT).show();
            }
            //if it does not exist it tells that database does not exists
            else
            {
                Toast.makeText(this, "Database does not exists.", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        //next code opens database and shows its content by another fragment called FavoriteActivityFragment
        if (id == R.id.action_favorite) {
            File dbFile = getDatabasePath("database");
            if (dbFile.exists())
            {
                Intent favoriteIntent = new Intent(this, FavoriteActivity.class);
                startActivity(favoriteIntent);
            }
            //if db does not exists just tells that db is empty
            else
            {
                Toast.makeText(this, "Database is empty.", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

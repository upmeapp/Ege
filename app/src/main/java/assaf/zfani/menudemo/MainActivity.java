package assaf.zfani.menudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu); // מנפח את הקסמל למצב לייאאוט
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.editTextItem1)
        {
            Toast.makeText(this,"editPressed",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.editTextItem2)
        {
            Toast.makeText(this,"edit2Pressed",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.ImageTextItem1)
        {
            Toast.makeText(this,"ImageItemPressed",Toast.LENGTH_LONG).show();
        }

        return super.onContextItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //ContextMenuInfo = אינטרפייס שאין בו שום דבר! מעין מרקר אינטרפייס
        if(v==editText)
        {
            getMenuInflater().inflate(R.menu.editmenu,menu);
        }
        if(v==imageView)
        {
            getMenuInflater().inflate(R.menu.imagemenu,menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        editText = (EditText)findViewById(R.id.editText);
        registerForContextMenu(imageView);
        registerForContextMenu(editText);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int option = item.getItemId();
        if(option==R.id.item1) {
            Toast.makeText(this, "the item clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

package apprecycler.simbirsoft.com.androidrecyclerview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ViewAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ViewAdapter viewAdapter;

    private EditText editText;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(android.R.id.list);

        createLayoutManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(R.string.app_title);
        setSupportActionBar(toolbar);

        // I didn't implement a menu, but here is an icon of menu
        getSupportActionBar().setIcon(android.R.drawable.ic_menu_sort_by_size);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void createLayoutManager() {
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setUpAdapter();
    }

    private void setUpAdapter() {
        viewAdapter = new ViewAdapter(generateData(), this);
        recyclerView.setAdapter(viewAdapter);
    }

    private List<Data> generateData() {

        List<Data> listData = new ArrayList<>();
        String tempImage = getBaseContext().getString(R.string.image_base_name);
        String tempName = getBaseContext().getString(R.string.text_base_name);

        for (int ind = 0; ind <= 6; ++ind)
        {
            Data data = new Data();
            data.image = new ImageView(this);

            // Using index only for taking images in setData method later
            data.index = ind;

            String imageFullName = "android.resource://" + this.getPackageName() + "/";
            Uri resourceURI = Uri.parse(imageFullName + "R.drawable." + tempImage + ind);

            data.resStr = imageFullName;
            data.image.setImageURI(resourceURI);

            data.text = tempName + ind;
            listData.add(data);
        }
        
        return listData;
    }

    private int getSize() {
        return viewAdapter != null ? viewAdapter.getItemCount() : 0;
    }

    @Override
    public void onClick(int position, String value) {

    }
}

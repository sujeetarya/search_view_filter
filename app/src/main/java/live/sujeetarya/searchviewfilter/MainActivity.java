package live.sujeetarya.searchviewfilter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<SuperheroModel> superheroList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superheroList = new ArrayList<>();

        superheroList.add(new SuperheroModel("Iron Man", "Tony Stark", "Robert Downey Jr"));
        superheroList.add(new SuperheroModel("Captain America", "Steve Roger", "Chris Evans"));
        superheroList.add(new SuperheroModel("Hulk", "Bruce Banner", "Mark Ruffalo"));
        superheroList.add(new SuperheroModel("Thor", "Thor", "Chris Hemsworth"));
        superheroList.add(new SuperheroModel("Black Widow", "Natasha", "Scarlett Johansson"));
        superheroList.add(new SuperheroModel("Caption Marvel", "Carol Danvers", "Brie Larson"));


        superheroList.add(new SuperheroModel("cIron Man", "Tony Stark", "Robert Downey Jr"));
        superheroList.add(new SuperheroModel("Captain America", "Steve Roger", "Chris Evans"));
        superheroList.add(new SuperheroModel("bHulk", "Bruce Banner", "Mark Ruffalo"));
        superheroList.add(new SuperheroModel("Thor", "Thor", "Chris Hemsworth"));
        superheroList.add(new SuperheroModel("TBlack Widow", "Natasha", "Scarlett Johansson"));
        superheroList.add(new SuperheroModel("Caption Marvel", "Carol Danvers", "Brie Larson"));

        SearchView search_view = findViewById(R.id.search_view);
        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        SuperheroAdapter superheroAdapter = new SuperheroAdapter(superheroList);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(superheroAdapter);

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                superheroAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }


}
package com.example.test1111;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.test1111.adapters.AfricanFoodAdapter;
import com.example.test1111.adapters.AmericanFoodAdapter;
import com.example.test1111.model.AfricaFood;

import java.util.ArrayList;

public class AfricanActivity extends AppCompatActivity implements AfricanFoodAdapter.AdapterClick {

    private RecyclerView recyclerView;
    public AfricanFoodAdapter.AdapterClick adapterClick;

    private static AfricaFood africaFoodModel;
    public static ArrayList<AfricaFood> africaFoodArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_africanactivity);

        recyclerView =(RecyclerView)findViewById(R.id.recyclerView);

        //Listing Item Click Interface giving refernce of this class , so it cannot be null
        adapterClick=this;

        //Title Bar of APP Toolbar
        getSupportActionBar().setTitle("African Restaurants");

        //Setting Up Layout Manager For RecyclerView which is Impportant to set View
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //Adding divider to listing rows
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        addFoodData();

        //Saving this ArrayList to Application Class so i can use this list in whole app which adding data again and again
        DiningApp.africaFoodArrayList = africaFoodArrayList;

        //Setting Up Adapter RecyclerView
        AfricanFoodAdapter africanFoodAdapter = new AfricanFoodAdapter(africaFoodArrayList, adapterClick);
        recyclerView.setAdapter(africanFoodAdapter);
    }

    /**
     * This method used to add Data Model Class
     * and lastly added up in Arraylist so i can set adapter using Arraylist
     */
    public static void addFoodData() {
        africaFoodModel = new AfricaFood();
        africaFoodModel.setName("Alloco");
        africaFoodModel.setDescription("Fried plantain snack with chilli pepper, onions and tomato sauce. ");
        africaFoodModel.setPrice("€8");
        africaFoodModel.setImage(R.drawable.alloco);
        africaFoodArrayList.add(africaFoodModel);

        africaFoodModel = new AfricaFood();
        africaFoodModel.setName("Bobotie");
        africaFoodModel.setDescription("National food of South Africa – a delicious mixture of curried meat and fruit with a creamy golden egg-based topping.");
        africaFoodModel.setPrice("€10");
        africaFoodModel.setImage(R.drawable.bombitie);
        africaFoodArrayList.add(africaFoodModel);

        africaFoodModel = new AfricaFood();
        africaFoodModel.setName("Kachumbari");
        africaFoodModel.setDescription("Fresh salad with chopped tomatoes, onions and chilli peppers.");
        africaFoodModel.setPrice("€6");
        africaFoodModel.setImage(R.drawable.kachu);
        africaFoodArrayList.add(africaFoodModel);

        africaFoodModel = new AfricaFood();
        africaFoodModel.setName("Nyama Choma");
        africaFoodModel.setDescription("Three sticks of roasted beef meat that fits very well to Kachumbari.");
        africaFoodModel.setPrice("€6");
        africaFoodModel.setImage(R.drawable.nyama);
        africaFoodArrayList.add(africaFoodModel);

        africaFoodModel = new AfricaFood();
        africaFoodModel.setName("Chakalaka");
        africaFoodModel.setDescription("Vegan spicy meal consisting of tomatoes, onions and beans. We also use carrots, peas, bell peppers and ginger. It is served with a piece of bread.");
        africaFoodModel.setPrice("€9");
        africaFoodModel.setImage(R.drawable.chakala);
        africaFoodArrayList.add(africaFoodModel);

        africaFoodModel = new AfricaFood();
        africaFoodModel.setName("Akara");
        africaFoodModel.setDescription("Vegan black eyed peas fritters, this spicy, crispy and crunchy fritter are served with a fresh sauce and fresh leaf salad.");
        africaFoodModel.setPrice("€8");
        africaFoodModel.setImage(R.drawable.akara);
        africaFoodArrayList.add(africaFoodModel);
    }

    /**
     * RecyclerView Row Item Click Listener
     */
    @Override
    public void onEditClick(int position) {
        startActivity(new Intent(this, CheckoutActivity.class).putExtra("id", position));
    }
}


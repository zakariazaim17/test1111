package com.example.test1111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.test1111.adapters.AmericanFoodAdapter;
import com.example.test1111.model.NorthAmericaFood;
import java.util.ArrayList;

public class Northamericaactivity extends AppCompatActivity implements AmericanFoodAdapter.AdapterClick {

    private RecyclerView recyclerView;
    public AmericanFoodAdapter.AdapterClick adapterClick;

    private static NorthAmericaFood northAmericanModel;
    public static ArrayList<NorthAmericaFood> northAmericanList = new ArrayList<>();

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northamericaactivity);

        //Listing Item Click Interface
        adapterClick = this;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        getSupportActionBar().setTitle("North America Restaurants");

        //Setting Up Layout Manager For RecyclerView which is Impportant to set View
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //Adding divider to listing rows
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        addFoodData();

        //Saving this ArrayList to Application Class so i can use this list in whole app which adding data again and again
        DiningApp.americaFoodArrayList = northAmericanList;

        //Setting Up Adapter RecyclerView
        AmericanFoodAdapter foodItemsAdapter = new AmericanFoodAdapter(northAmericanList, adapterClick);
        recyclerView.setAdapter(foodItemsAdapter);
    }


    public static void addFoodData() {
        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Fried Chicken");
        northAmericanModel.setDescription("A 12 piece bucket of chicken, served with 4 biscuits, mashed potatoes, gravy, and coleslaw.");
        northAmericanModel.setPrice("€18");
        northAmericanModel.setImage(R.drawable.fried_chicken);
        northAmericanList.add(northAmericanModel);

        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Baby Back Ribs");
        northAmericanModel.setDescription("Tender succulent ribs glazed with BBQ sauce. Served with fries and coleslaw.");
        northAmericanModel.setPrice("€15");
        northAmericanModel.setImage((R.drawable.baby_rack_ribs));
        northAmericanList.add(northAmericanModel);

        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Krispy Kreme Burger");
        northAmericanModel.setDescription("Our classic burger with american cheese, bacon, lettuce and tomato. served with steal fries.");
        northAmericanModel.setPrice("€10");
        northAmericanModel.setImage((R.drawable.krispy_creme_burger));
        northAmericanList.add(northAmericanModel);

        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Ulcerator");
        northAmericanModel.setDescription("Served on a toasted jalapeño cheddar bun; dusted with Cajun spices and topped with smoked ham, fried\n" +
                "onions. Served with steak fries.");
        northAmericanModel.setPrice("€12");
        northAmericanModel.setImage((R.drawable.ulcerator));
        northAmericanList.add(northAmericanModel);

        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Angelina Special Pizza");
        northAmericanModel.setDescription("Pepperoni, salami, sausage, mushrooms, bell peppers, onions, and black olives.");
        northAmericanModel.setPrice("€19");
        northAmericanModel.setImage((R.drawable.angelina_special_pizza));
        northAmericanList.add(northAmericanModel);

        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Deluxe pizza");
        northAmericanModel.setDescription("Cheese, pepperoni, mushrooms, sausage, green peppers, onions. and a sprinkling of extra cheese.");
        northAmericanModel.setPrice("€15");
        northAmericanModel.setImage((R.drawable.deluxe_pizza));
        northAmericanList.add(northAmericanModel);

        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Gordon pizza");
        northAmericanModel.setDescription("Four types of cheese including feta, mushrooms, black olives, onions, and sliced tomatoes.");
        northAmericanModel.setPrice("€15");
        northAmericanModel.setImage((R.drawable.gardon_pizza));
        northAmericanList.add(northAmericanModel);

        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Meat pizza");
        northAmericanModel.setDescription("Cheese, pepperoni, ham, sausage, bacon, and a sprinkling of extra cheese");
        northAmericanModel.setPrice("€15");
        northAmericanModel.setImage((R.drawable.meatpizza));
        northAmericanList.add(northAmericanModel);

        northAmericanModel = new NorthAmericaFood();
        northAmericanModel.setName("Homemade Cheesecake");
        northAmericanModel.setDescription("Chef Jose’s Homemade Cheesecake");
        northAmericanModel.setPrice("€6s");
        northAmericanModel.setImage((R.drawable.cheesecake));
        northAmericanList.add(northAmericanModel);

    }

    /**
     * RecyclerView Row Item Click Listener
     */
    @Override
    public void onEditClick(int position) {
        startActivity(new Intent(this, CheckoutActivity.class).putExtra("id", position));

    }
}

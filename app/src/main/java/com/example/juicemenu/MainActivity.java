package com.example.juicemenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductAdapter.CallBackUs, ProductAdapter.HomeCallBack {

    public static ArrayList<ProductModel> arrayList = new ArrayList<>();
    public static int cart_count = 0;
    ProductAdapter productAdapter;
    RecyclerView productRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addProduct();
        productAdapter = new ProductAdapter(arrayList, this, this);
        productRecyclerView = findViewById(R.id.product_recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(productAdapter);

    }


    private void addProduct() {
        ProductModel productModel = new ProductModel("apple", "70", "20", R.drawable.apple);
        arrayList.add(productModel);
        ProductModel productModel1 = new ProductModel("orange", "60", "10", R.drawable.orange);
        arrayList.add(productModel1);
        ProductModel productModel2 = new ProductModel("grapes", "70", "10", R.drawable.grape);
        arrayList.add(productModel2);

        ProductModel productModel3 = new ProductModel("pineapple", "70", "20", R.drawable.pineapple);
        arrayList.add(productModel3);
        ProductModel productModel12 = new ProductModel("strawberry", "80", "10", R.drawable.strawberry);
        arrayList.add(productModel12);
        ProductModel productModel23 = new ProductModel("papaya", "70", "10", R.drawable.papaya);
        arrayList.add(productModel23);

        ProductModel productModel4 = new ProductModel("mango", "70", "20", R.drawable.mango);
        arrayList.add(productModel4);
        ProductModel productModel14 = new ProductModel("bannana", "80", "10", R.drawable.banana);
        arrayList.add(productModel14);
        ProductModel productModel25 = new ProductModel("kiwi", "90", "10", R.drawable.kiwi);
        arrayList.add(productModel25);

        ProductModel productModel5 = new ProductModel("guava", "100", "20", R.drawable.guava);
        arrayList.add(productModel5);
        ProductModel productModel16 = new ProductModel("watermelon", "80", "10", R.drawable.watermelon);
        arrayList.add(productModel16);

    }

    @Override
    public void addCartItemView() {
        //addItemToCartMethod();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.cart_action:
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, CartActivity.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }

    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }
}

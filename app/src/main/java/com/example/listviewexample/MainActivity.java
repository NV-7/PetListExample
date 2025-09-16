package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import model.Pet;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayList<Pet> petList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        petList = new ArrayList<Pet>();
        petList.add(new Pet("Scooby", "Labrador", 3));
        petList.add(new Pet("Doo", "Dog", 2));
        petList.add(new Pet("Courage", "Scooby", 1));

        listView = findViewById(R.id.listView);

        int selection = 2;
        populateListView(selection);
    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String[] petList = getResources().getStringArray(R.array.pet_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, petList);
        listView.setAdapter(adapter);

    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {
    listView.setAdapter(new ArrayAdapter<Pet>(this, android.R.layout.simple_list_item_2, android.R.id.text1, petList));

    }
}
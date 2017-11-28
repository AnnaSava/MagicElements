package com.example.android.magicelements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int maxAddingNumber = 10;

    int fire = 0;
    int water = 0;
    int earth = 0;
    int air = 0;

    int ice = 0;
    int steam = 0;
    int silt = 0;
    int sand = 0;
    int spark = 0;
    int lava = 0;

    int fireNext = 1;
    int waterNext = 1;
    int earthNext = 1;
    int airNext = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("fire", fire);
        outState.putInt("water", water);
        outState.putInt("earth", earth);
        outState.putInt("air", air);

        outState.putInt("ice", ice);
        outState.putInt("steam", steam);
        outState.putInt("silt", silt);
        outState.putInt("sand", sand);
        outState.putInt("spark", spark);
        outState.putInt("lava", lava);

        outState.putInt("fireNext", fireNext);
        outState.putInt("waterNext", waterNext);
        outState.putInt("earthNext", earthNext);
        outState.putInt("airNext", airNext);

        TextView messageView = (TextView) findViewById(R.id.message);
        String message = messageView.getText().toString();
        outState.putString("message", message);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        fire = savedInstanceState.getInt("fire");
        water = savedInstanceState.getInt("water");
        earth = savedInstanceState.getInt("earth");
        air = savedInstanceState.getInt("air");

        ice = savedInstanceState.getInt("ice");
        steam = savedInstanceState.getInt("steam");
        silt = savedInstanceState.getInt("silt");
        sand = savedInstanceState.getInt("sand");
        spark = savedInstanceState.getInt("spark");
        lava = savedInstanceState.getInt("lava");

        fireNext = savedInstanceState.getInt("fireNext");
        waterNext = savedInstanceState.getInt("waterNext");
        earthNext = savedInstanceState.getInt("earthNext");
        airNext = savedInstanceState.getInt("airNext");

        displayAllScores();

        displayAllNexts();

        String message = savedInstanceState.getString("message");
        displayMessage(message);

        super.onRestoreInstanceState(savedInstanceState);
    }

    public void addFire(View view) {
        fire += fireNext;
        checkElements();

        Random random = new Random();
        fireNext = random.nextInt(maxAddingNumber) + 1;

        displayFireNext(fireNext);
    }

    public void addWater(View view) {
        water += waterNext;
        checkElements();

        Random random = new Random();
        waterNext = random.nextInt(maxAddingNumber) + 1;

        displayWaterNext(waterNext);
    }

    public void addEarth(View view) {
        earth += earthNext;
        checkElements();

        Random random = new Random();
        earthNext = random.nextInt(maxAddingNumber) + 1;

        displayEarthNext(earthNext);
    }

    public void addAir(View view) {
        air += airNext;
        checkElements();

        Random random = new Random();
        airNext = random.nextInt(maxAddingNumber) + 1;

        displayAirNext(airNext);
    }

    public void checkElements() {
        String message = "No matches";

        if(air > 0 && water > 0 && air == water) {
            ice++;
            air = water = 0;
            message = ice == 1 ? "First Ice!" : "Plus Ice!";
        } else
        if(fire > 0 && water > 0 && fire == water) {
            steam++;
            fire = water = 0;
            message = steam == 1 ? "First Steam!" : "Plus Steam!";
        } else
        if(earth > 0 && water > 0 && earth == water) {
            silt++;
            earth = water = 0;
            message = silt == 1 ? "First Silt!" : "Plus Silt!";
        } else
        if(air > 0 && earth > 0 && air == earth) {
            sand++;
            air = earth = 0;
            message = sand == 1 ? "First Sand!" : "Plus Sand!";
        } else
        if(fire > 0 && air > 0 && fire == air) {
            spark++;
            fire = air = 0;
            message = spark == 1 ? "First Spark!" : "Plus Spark!";
        } else
        if(fire > 0 && earth > 0 && fire == earth) {
            lava++;
            fire = earth = 0;
            message = lava == 1 ? "First Lava!" : "Plus Lava!";
        }

        displayMessage(message);

        displayAllScores();
    }

    public void resetGame(View view) {
        fire = water = earth = air = 0;
        ice = steam = silt = sand = spark = lava = 0;
        fireNext = waterNext = earthNext = airNext = 1;

        displayAllScores();

        displayMessage(getString(R.string.game_message));

        displayAllNexts();
    }

    public void displayAllScores() {
        displayFire(fire);
        displayWater(water);
        displayEarth(earth);
        displayAir(air);

        displayIce(ice);
        displaySteam(steam);
        displaySilt(silt);
        displaySand(sand);
        displaySpark(spark);
        displayLava(lava);
    }

    public void  displayAllNexts()    {
        displayFireNext(fireNext);
        displayWaterNext(waterNext);
        displayEarthNext(earthNext);
        displayAirNext(airNext);
    }

    public void displayFire(int score) {
        TextView scoreView = (TextView) findViewById(R.id.fire_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displayWater(int score) {
        TextView scoreView = (TextView) findViewById(R.id.water_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displayEarth(int score) {
        TextView scoreView = (TextView) findViewById(R.id.earth_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAir(int score) {
        TextView scoreView = (TextView) findViewById(R.id.air_count);
        scoreView.setText(String.valueOf(score));
    }


    public void displayFireNext(int score) {
        Button addButton = (Button) findViewById(R.id.add_fire);
        addButton.setText("+" + String.valueOf(score));
    }

    public void displayWaterNext(int score) {
        Button addButton = (Button) findViewById(R.id.add_water);
        addButton.setText("+" + String.valueOf(score));
    }

    public void displayEarthNext(int score) {
        Button addButton = (Button) findViewById(R.id.add_earth);
        addButton.setText("+" + String.valueOf(score));
    }

    public void displayAirNext(int score) {
        Button addButton = (Button) findViewById(R.id.add_air);
        addButton.setText("+" + String.valueOf(score));
    }


    public void displayIce(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ice_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySteam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.steam_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySilt(int score) {
        TextView scoreView = (TextView) findViewById(R.id.silt_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySand(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sand_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySpark(int score) {
        TextView scoreView = (TextView) findViewById(R.id.spark_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displayLava(int score) {
        TextView scoreView = (TextView) findViewById(R.id.lava_count);
        scoreView.setText(String.valueOf(score));
    }

    public void displayMessage(String message) {
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(String.valueOf(message));
    }
}

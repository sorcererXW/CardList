package com.sorcererxw.demo.cardlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_main)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
    }

    public void toPlan(View view) {
        String tag = (String) view.getTag();
        switch (tag) {
            case "A":
                startActivity(
                        new Intent(this, com.sorcererxw.demo.cardlist.planA.PlanActivity.class));
                break;
            case "B":
                startActivity(
                        new Intent(this, com.sorcererxw.demo.cardlist.planB.PlanActivity.class));
                break;
            case "C":
                startActivity(
                        new Intent(this, com.sorcererxw.demo.cardlist.planC.PlanActivity.class));
                break;
            default:
                startActivity(
                        new Intent(this, com.sorcererxw.demo.cardlist.planD.PlanActivity.class));
                break;
        }
    }
}

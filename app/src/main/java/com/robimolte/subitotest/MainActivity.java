package com.robimolte.subitotest;

import android.app.ProgressDialog;
import android.content.Intent;
;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.robimolte.subitotest.model.Stargazer;
import com.robimolte.subitotest.util.Utils;

public class MainActivity extends AppCompatActivity implements  MainScreenStargazer.View{



    @Inject
    MainScreenStargazer.Presenter mainPresenter;

    EditText nameRepoEditText;
    EditText ownerRepoEditText;

    ProgressDialog progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((App) getApplication()).getMainScreenComponent().inject(this);


        nameRepoEditText = (EditText) findViewById(R.id.nameRepo);
        ownerRepoEditText = (EditText) findViewById(R.id.ownerRepo);

        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.setView(this);
    }
    public void myClickHandler(View target) {

        String ownerRepoString = ownerRepoEditText.getText().toString();
        String nameRepoString = nameRepoEditText.getText().toString();

        if(Utils.checkInputFields(ownerRepoString, nameRepoString)){

             // disable dismiss by tapping outside of the dialog
            progress.show();
            mainPresenter.getStargazers(ownerRepoString,nameRepoString);

        }
        else
        {
            Toast.makeText(this, "One or more fields are empty. Check again",
                    Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void showStargazers(List<Stargazer> stargazer) {

        if(progress != null)
            progress.dismiss();

        if(stargazer.size() <= 0) {
            Toast.makeText(this, "No result found",
                    Toast.LENGTH_LONG).show();
        }
        else {

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("stargazer",(Serializable) stargazer);
            startActivity(intent);

        }
    }

    @Override
    public void showError(String message) {

        if(progress != null)
            progress.dismiss();

        Toast.makeText(this, "Something went wrong.No result found",
                Toast.LENGTH_LONG).show();

    }





}

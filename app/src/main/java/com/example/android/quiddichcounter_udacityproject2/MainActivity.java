package com.example.android.quiddichcounter_udacityproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity {


    private String points;
    private int teamOneScore;
    private int teamTwoScore;
    // Variables for all the dynamic views being used
    private TextView teamOnePointsTv;
    private TextView teamTwoPointsTv;
    private Button teamOneQuaffleButton;
    private Button teamTwoQuaffleButton;
    private Button teamOneSnitchButton;
    private Button teamTwoSnitchButton;
    private TextView gameOverTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wiring up views from XML
        teamOnePointsTv = (TextView) findViewById(R.id.team_one_points_tv);

        teamTwoPointsTv = (TextView) findViewById(R.id.team_two_points_tv);

        teamOneQuaffleButton = (Button) findViewById(R.id.team_one_quaffle_button);
        teamOneQuaffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Method to update score and print in relevant points textview.
                // Input number represents team number.
                ScoreQuaffle(1);
            }
        });

        teamTwoQuaffleButton = (Button) findViewById(R.id.team_two_quaffle_button);
        teamTwoQuaffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Method to update score and print in relevant points textview.
                // Input number represents team number.
                ScoreQuaffle(2);
            }
        });

        teamOneSnitchButton = (Button) findViewById(R.id.team_one_snitch_button);
        teamOneSnitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //method to update score, print to relevant Textview, and end the game.
                ScoreSnitch(1);
            }
        });

        teamTwoSnitchButton = (Button) findViewById(R.id.team_two_snitch_button);
        teamTwoSnitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //method to update score, print to relevant Textview, and end the game.
                ScoreSnitch(2);
            }
        });

        gameOverTv = (TextView) findViewById(R.id.game_over_tv);

        Button resetButton = (Button) findViewById(R.id.reset_button);

          points = " " + getString(R.string.points);

          startGame();


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });


    }

    private void startGame(){
        //reset score and score display
        teamOneScore = 0;
        teamTwoScore = 0;
        teamOnePointsTv.setText(String.valueOf(teamOneScore));
        teamOnePointsTv.append(points);
        teamTwoPointsTv.setText(String.valueOf(teamTwoScore));
        teamTwoPointsTv.append(points);
        gameOverTv.setVisibility(View.INVISIBLE);
        //reenable buttons
        teamOneQuaffleButton.setEnabled(true);
        teamTwoQuaffleButton.setEnabled(true);
        teamOneSnitchButton.setEnabled(true);
        teamTwoSnitchButton.setEnabled(true);
    }



    //Method for scoring Quaffle. Takes team number as input, increases their score by 10,
    // and the updated score is printed on screen.
    public void ScoreQuaffle (int teamNumber){
        if (teamNumber == 1) {
            teamOneScore = teamOneScore + 10;
            teamOnePointsTv.setText(String.valueOf(teamOneScore));
            teamOnePointsTv.append(points);
        }else if (teamNumber == 2){
            teamTwoScore = teamTwoScore + 10;
            teamTwoPointsTv.setText(String.valueOf(teamTwoScore));
            teamTwoPointsTv.append(points);
        }
    }

    //Method for scoring Snitch. Takes team number as input, increases their score by 150,
    // the updated score is printed on screen, game ends and buttons disabled.
    public void ScoreSnitch (int teamNumber){
        if (teamNumber == 1) {
            teamOneScore = teamOneScore + 150;
            teamOnePointsTv.setText(String.valueOf(teamOneScore));
            teamOnePointsTv.append(points);
        }else if (teamNumber == 2){
            teamTwoScore = teamTwoScore + 150;
            teamTwoPointsTv.setText(String.valueOf(teamTwoScore));
            teamTwoPointsTv.append(points);
        }
        //disable score buttons
        teamOneQuaffleButton.setEnabled(false);
        teamTwoQuaffleButton.setEnabled(false);
        teamOneSnitchButton.setEnabled(false);
        teamTwoSnitchButton.setEnabled(false);

        // Show "Game Over" text.
        gameOverTv.setVisibility(View.VISIBLE);
    }
}

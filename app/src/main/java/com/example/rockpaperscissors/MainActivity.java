package com.example.rockpaperscissors;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button rockBtn;
    private Button paperBtn;
    private Button scissorBtn;
    private ImageView playerOneImage;
    private ImageView computerImage;
    private TextView playerOneScore;
    private TextView computerScore;
    private TextView gameStatus;
    private int playerOneCurrentScore;
    private int computerCurrentScore;
    private String[] choices = {"Rock", "Paper", "Scissor"};
    private String guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rockBtn = findViewById(R.id.rockBtn);
        paperBtn = findViewById(R.id.paperBtn);
        scissorBtn = findViewById(R.id.scissorBtn);
        playerOneImage = findViewById(R.id.playerOneImage);
        computerImage = findViewById(R.id.computerImage);
        playerOneScore = findViewById(R.id.playerOneScore);
        computerScore = findViewById(R.id.computerScore);
        gameStatus = findViewById(R.id.gameStatus);
        playerOneCurrentScore = 0;
        computerCurrentScore = 0;


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rockBtnOption();
        paperBtnOption();
        scissorBtnOption();
    }
    public String getRandomOpponentChoice() {
        Random random = new Random();
        int randomIndex = random.nextInt(choices.length);

        return choices[randomIndex];
    }
    public void rockBtnOption() {
        rockBtn.setOnClickListener(view -> {
            guess = getRandomOpponentChoice();

            playerOneImage.setImageResource(R.drawable.rock);
            computerImageSet();

            if(guess.equals("Rock")) {
                gameStatus.setText("Tie");
            } else if(guess.equals("Paper")) {
                gameStatus.setText("Computer wins");
                computerCurrentScore++;
                computerScore.setText(String.valueOf(computerCurrentScore));
            } else if(guess.equals("Scissor")) {
                gameStatus.setText("Player 1 wins");
                playerOneCurrentScore++;
                playerOneScore.setText(String.valueOf(playerOneCurrentScore));
            }

        });
    }
    public void paperBtnOption() {
        paperBtn.setOnClickListener(view -> {
            guess = getRandomOpponentChoice();

            playerOneImage.setImageResource(R.drawable.paper);
            computerImageSet();

            if(guess.equals("Rock")) {
                gameStatus.setText("Player one wins");
                playerOneCurrentScore++;
                playerOneScore.setText(String.valueOf(playerOneCurrentScore));
            } else if(guess.equals("Paper")) {
                gameStatus.setText("Tie");
            } else if(guess.equals("Scissor")) {
                gameStatus.setText("Compuer wins");
                computerCurrentScore++;
                computerScore.setText(String.valueOf(computerCurrentScore));
            }

        });
    }
    public void scissorBtnOption() {
        scissorBtn.setOnClickListener(view -> {
            guess = getRandomOpponentChoice();
            playerOneImage.setImageResource(R.drawable.scissors);

            computerImageSet();

            if(guess.equals("Rock")) {
                gameStatus.setText("Computer wins");
                computerCurrentScore++;
                computerScore.setText(String.valueOf(computerCurrentScore));
            } else if(guess.equals("Paper")) {
                gameStatus.setText("Player 1 wins");
                playerOneCurrentScore++;
                playerOneScore.setText(String.valueOf(playerOneCurrentScore));
            } else if(guess.equals("Scissor")) {
                gameStatus.setText("Tie");

            }

        });
    }
    public void computerImageSet() {
        if (guess.equals("Rock")) {
            computerImage.setImageResource(R.drawable.rock);
        } else if (guess.equals("Paper")) {
            computerImage.setImageResource(R.drawable.paper);
        } else {
            computerImage.setImageResource(R.drawable.scissors);
        }
    }
}
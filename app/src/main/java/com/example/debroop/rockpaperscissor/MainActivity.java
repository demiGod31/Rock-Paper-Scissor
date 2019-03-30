package com.example.debroop.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock,b_paper,b_scissor;
    ImageView i_human,i_computer;
    TextView t_score;
    int h=0,c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_rock=(Button)findViewById(R.id.button4);
        b_paper=(Button)findViewById(R.id.button5);
        b_scissor=(Button)findViewById(R.id.button6);

        i_human=(ImageView)findViewById(R.id.imageViewH);
        i_computer=(ImageView)findViewById(R.id.imageViewC);

        t_score=(TextView)findViewById(R.id.score);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i_human.setImageResource(R.drawable.rock);
                String message=play_turn(1);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                t_score.setText("SCORE: Human "+Integer.toString(h)+" Computer "+Integer.toString(c));
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i_human.setImageResource(R.drawable.paper);
                String message=play_turn(2);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                t_score.setText("SCORE: Human "+Integer.toString(h)+" Computer "+Integer.toString(c));

            }
        });

        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i_human.setImageResource(R.drawable.scissor);
                String message=play_turn(3);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                t_score.setText("SCORE: Human "+Integer.toString(h)+" Computer "+Integer.toString(c));

            }
        });
    }
    public String play_turn(int k)
    {
        Random r=new Random();
        int comp=r.nextInt(3)+1;
        if(comp==1)
        {
            i_computer.setImageResource(R.drawable.rock);
        }
        else if(comp==2)
        {
            i_computer.setImageResource(R.drawable.paper);
        }
        else if(comp==3)
        {
            i_computer.setImageResource(R.drawable.scissor);
        }
        if(k==1 && comp==1)
        {
            return("Nobody Wins. Draw!");
        }
        else if(k==2 && comp==2)
        {
            return("Nobody Wins. Draw!");
        }
        else if(k==3 && comp==3)
        {
            return("Nobody Wins. Draw!");
        }
        else if(k==1 && comp==2)
        {
            c++;
            return("Paper covers rock. Computer wins!");

        }
        else if(k==1 && comp==3)
        {
            h++;
            return("Rock crushes scissors. You win!");
        }
        else if(k==2 && comp==1)
        {
            h++;
            return("Paper covers rock. You win!");
        }
        else if(k==2 && comp==3)
        {
            c++;
            return("Scissors cut paper. Computer wins!");
        }
        else if(k==3 && comp==1)
        {
            c++;
            return("Rock smashes scissors. Computer wins!");
        }
        else if(k==3 && comp==2)
        {
            h++;
            return("Scissors cut paper. You win!");
        }
        else
        {
            return ("Not Sure about the result!");
        }
    }
}

package we.be.ibidlo.Ibidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

import we.be.ibidlo.R;

public class Level_1 extends AppCompatActivity {

    private ImageView img_right;
    private ImageView img_left;
    private int[] bankCountImages = { 1, 2};
    private int voult = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_universal);

        CountLevel point = new CountLevel(); //Не забыть про тебя

        img_right = (ImageView) findViewById(R.id.image_right);
        img_left = (ImageView) findViewById(R.id.image_left);

        img_right.setClipToOutline(true);
        img_left.setClipToOutline(true);

        randomImage();
        gameChose();

        Button back_levels = (Button) findViewById(R.id.back_button_in_level_cuba);
        back_levels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent chose_level_menu = new Intent(Level_1.this, levels.class);
                    startActivity(chose_level_menu);
                    finish();
                } catch (Exception e) {

                }
            }
        });

        Window wes = getWindow();
        wes.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void onBackPressed() {
        try {
            Intent act = new Intent(Level_1.this, levels.class);
            startActivity(act);
            finish();
        } catch (Exception e) {

        }
    }

    private void gameChose(){
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comparisonCountImages(img_left);
            }
        });
        img_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comparisonCountImages(img_right);
            }
        });
    }

    private void comparisonCountImages(ImageView imagep){
//        if(
//
//        )
//        else()
    }

    private int countImage(){
        Random number = new Random();
        int returnNumber = number.nextInt(11);
        if (returnNumber == voult){
            returnNumber = number.nextInt(11);
            voult = returnNumber;
        }
        bankCountImages = add(bankCountImages, returnNumber);
        return returnNumber;
    }

    private void randomImage() {
        int first = countImage();
        int second = countImage();

        chose_level(img_left, first);
        chose_level(img_right, second);
    }

    private static int[] add(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    private void chose_level(ImageView chosenImageView, int levelImageView) {
        switch (levelImageView) {
            case 0:
                chosenImageView.setImageResource(R.drawable.kimersen);
                break;
            case 1:
                chosenImageView.setImageResource(R.drawable.colonelmarine);
                break;
            case 2:
                chosenImageView.setImageResource(R.drawable.andropov);
                break;
            case 3:
                chosenImageView.setImageResource(R.drawable.colonelmarina);
                break;
            case 4:
                chosenImageView.setImageResource(R.drawable.stalichnaya);
                break;
            case 5:
                chosenImageView.setImageResource(R.drawable.breznev);
                break;
            case 6:
                chosenImageView.setImageResource(R.drawable.che);
                break;
            case 7:
                chosenImageView.setImageResource(R.drawable.lenin);
                break;
            case 8:
                chosenImageView.setImageResource(R.drawable.hochimin);
                break;
            case 9:
                chosenImageView.setImageResource(R.drawable.genius);
                break;
            case 10:
                chosenImageView.setImageResource(R.drawable.obeme);
                break;
        }
    }
}
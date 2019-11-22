package we.be.ibidlo.Ibidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

import we.be.ibidlo.R;
import we.be.ibidlo.levels;

public class Level_1 extends AppCompatActivity {
    private TextView countlevelinprogressbar;
    private ImageView img_right;
    private ImageView img_left;
    private int[] bankCountImages = {0};
    private int voult = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_universal);

        changeprogressbarlevel(CountLevel.getCountlevel());

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

    //"Слушатели" для левого и правого ImageView
    private void gameChose(){
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comparisonCountImages(img_left);
            }
        });
        img_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { comparisonCountImages(img_right);
            }
        });
    }

    //Сравнение последних "значений" картинок, которые записаны в массив bankCountImages
    private void comparisonCountImages(ImageView imagep){
        if(imagep == img_left && bankCountImages[bankCountImages.length-1] < bankCountImages[bankCountImages.length-2]){
            CountLevel.countlevelPlus();
            if (CountLevel.getCountlevel() == 30){
                onBackPressed();
            }
            System.out.println("Сработал левый вариант");
            Intent act = new Intent(Level_1.this, Level_1.class);
            startActivity(act);
            finish();
        }
        else if(imagep == img_right && bankCountImages[bankCountImages.length-1] > bankCountImages[bankCountImages.length-2]){
            CountLevel.countlevelPlus();
            if (CountLevel.getCountlevel() == 30){
                onBackPressed();
            }
            System.out.println("Сработал правый вариант");
            Intent act = new Intent(Level_1.this, Level_1.class);
            startActivity(act);
            finish();
        }
        else{
            Toast gag;
            gag = Toast.makeText(getBaseContext(), "You lose", Toast.LENGTH_SHORT);
            gag.show();
            onBackPressed();
        }
    }

    //Функция генерации случайного числа, добавления его в массив bankCountImages
    private int countImage(){
        Random number = new Random();
        int returnNumber = number.nextInt(11);
        if (returnNumber == voult){
            returnNumber = number.nextInt(11);
        }
        voult = returnNumber;
        System.out.println("Добавлено число в массив - "+returnNumber);
        bankCountImages = add(bankCountImages, returnNumber);
        return returnNumber;
    }

    //Код со StacOverFlow, который я позаимствовал
    private static int[] add(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    //Присваивание ImageView картинок
    private void randomImage() {
        int first = countImage();
        int second = countImage();

        chose_level(img_left, first);
        chose_level(img_right, second);
    }

    //Выбор картинки для ImageView
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

    //это нужно будет укоротить
    private void changeprogressbarlevel(int level){
        switch (level){
            case 1:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_1);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 2:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_2);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 3:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_3);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 4:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_4);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 5:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_5);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 6:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_6);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 7:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_7);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 8:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_8);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 9:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_9);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 10:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_10);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 11:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_11);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 12:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_12);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 13:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_13);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 14:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_14);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 15:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_15);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 16:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_16);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 17:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_17);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 18:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_18);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 19:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_19);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 20:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_20);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 21:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_21);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 22:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_22);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 23:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_23);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 24:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_24);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 25:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_25);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 26:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_26);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 27:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_27);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 28:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_28);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 29:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_29);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
            case 30:
                countlevelinprogressbar = (TextView)findViewById(R.id.point_30);
                countlevelinprogressbar.setBackgroundResource(R.drawable.progress_point_yellow);
                break;
        }
    }
}
package we.be.ibidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class Level_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_universal);

        final ImageView img_right = (ImageView)findViewById(R.id.image_right);
        img_right.setClipToOutline(true);

        final ImageView img_left = (ImageView)findViewById(R.id.image_left);
        img_left.setClipToOutline(true);

        Button back_levels = (Button) findViewById(R.id.back_button_in_level_cuba);
        back_levels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent chose_level_menu = new Intent(Level_1.this, levels.class);
                    startActivity(chose_level_menu); finish();
                }
                catch (Exception e){

                }
            }
        });

        final ImageView right_clik = (ImageView) findViewById(R.id.image_right);
        right_clik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Window wes = getWindow();
        wes.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void onBackPressed() {
        try {
            Intent act = new Intent(Level_1.this, levels.class);
            startActivity(act); finish();
        }
        catch (Exception e){

        }
    }

    public void random_picture() {

    }
}


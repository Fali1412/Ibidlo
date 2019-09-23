package we.be.ibidlo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chose_minigames);

        Button launchbuttononmenu = (Button) findViewById(R.id.button_choose_CUBA);
        launchbuttononmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent chose_level = new Intent(levels.this, Level_1.class);
                    startActivity(chose_level); finish();
                }
                catch (Exception e){

                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button back_butt = (Button)findViewById(R.id.button_back);
        back_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent act = new Intent(levels.this, MainActivity.class);
                    startActivity(act); finish();
                }
                catch (Exception e){

                }
            }
        });


    }
    @Override
    public void onBackPressed() {
        try {
            Intent act = new Intent(levels.this, MainActivity.class);
            startActivity(act); finish();
        }
        catch (Exception e){

        }
    }
}

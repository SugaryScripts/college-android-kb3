package fryctze.college.kb3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI(){
        TextView myTv = new TextView(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, //width
                ViewGroup.LayoutParams.WRAP_CONTENT //height
        );
        myTv.setLayoutParams(params);
        myTv.setText("Hello there");
        myTv.setTextSize(40);

        LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);
        //layout.addView(myTv);

        createContent("Call me", android.R.drawable.ic_menu_call, layout);
        createContent("Oops, deleted", android.R.drawable.ic_delete, layout);
        createContent("Need key", android.R.drawable.ic_lock_lock, layout);
        createContent("Saved", android.R.drawable.ic_menu_save, layout);
        createContent("Selfie pls", android.R.drawable.ic_menu_camera, layout);
    }

    private void createContent(String title, int imgSrc, LinearLayout parent){
        View content_layout = getLayoutInflater().inflate(R.layout.content_layout, null);

        ImageView img = content_layout.findViewById(R.id.img_content);
        img.setImageResource(imgSrc);

        TextView tvContent = content_layout.findViewById(R.id.tv_content);
        tvContent.setText(title);

        Button btnContent = content_layout.findViewById(R.id.btn_content);

        parent.addView(content_layout);
    }
}
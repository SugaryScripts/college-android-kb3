package fryctze.college.kb3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("It's a Dialog!!");
        builder.setMessage("Hello its message");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yuhuu OK is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("canceledered", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Your cancel is typo", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();

        Button btnContent = content_layout.findViewById(R.id.btn_content);
        btnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        parent.addView(content_layout);
    }
}
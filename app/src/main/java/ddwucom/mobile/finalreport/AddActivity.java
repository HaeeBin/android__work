package ddwucom.mobile.finalreport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etActor;
    EditText etDay;
    EditText etScore;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.addTitle);
        etActor = findViewById(R.id.addActor);
        etDay = findViewById(R.id.addDay);
        etScore = findViewById(R.id.addScore);

        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addOk:
                boolean result = movieDBManager.addMovie(
                        new MovieData(etTitle.getText().toString(), etActor.getText().toString(),
                                etDay.getText().toString(),
                                etScore.getText().toString()));

                if(result) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("movie", etTitle.getText().toString() );
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    Toast.makeText(this, "새로운 영화 추가 실패", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.addCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
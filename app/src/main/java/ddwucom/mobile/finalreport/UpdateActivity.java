package ddwucom.mobile.finalreport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    MovieData movie;

    EditText etTitle;
    EditText etActor;
    EditText etDay;
    EditText etScore;
    EditText etTime;
    EditText etDirector;
    TextView etStory;
    ImageView etImg;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        movie = (MovieData) getIntent().getSerializableExtra("movie");

        etTitle = findViewById(R.id.upTitle);
        etImg = findViewById(R.id.updateImg);
        etActor = findViewById(R.id.upActor);
        etDay = findViewById(R.id.upDay);
        etScore = findViewById(R.id.upScore);
        etTime = findViewById(R.id.upTime);
        etDirector = findViewById(R.id.upDirector);
        etStory = findViewById(R.id.story);

        etTitle.setText(movie.getTitle());
        etActor.setText(movie.getActor());
        etDay.setText(movie.getDay());
        etScore.setText(movie.getScore());
        etTime.setText(movie.getTime());
        etDirector.setText(movie.getDirector());
        etStory.setText(movie.getStory());
        etImg.setImageResource(movie.getImg());

        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updateOk:
                movie.setTitle(etTitle.getText().toString());
                movie.setActor(etActor.getText().toString());
                movie.setDay(etDay.getText().toString());
                movie.setScore(etScore.getText().toString());
                movie.setTime(etTime.getText().toString());
                movie.setDirector(etDirector.getText().toString());
                movie.setStory(etStory.getText().toString());
                movie.setImg(etImg.getId());

                if (movieDBManager.modifyMovie(movie)) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("movie", movie);
                    setResult(RESULT_OK, resultIntent);
                }
                else
                    setResult(RESULT_CANCELED);
                break;
            case R.id.updateCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
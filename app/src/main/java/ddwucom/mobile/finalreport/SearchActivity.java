package ddwucom.mobile.finalreport;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    MovieDBHelper movieDBHelper;
    EditText search;
    TextView searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        movieDBHelper = new MovieDBHelper(this);
    }

    public void onClick(View v) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getReadableDatabase();
        search = findViewById(R.id.searchTitle);
        searchResult = findViewById(R.id.searchResult);

        switch (v.getId()) {
            case R.id.search:
                String[] columns = {"title", "actor", "day", "score", "time", "director", "story"};
                String selection = "title=?";
                String[] selectionArgs = new String[] {search.getText().toString()};

                Cursor cursor = sqLiteDatabase.query(MovieDBHelper.TABLE_NAME, columns, selection, selectionArgs,
                        null, null, null, null);

                String result = "";

                while (cursor.moveToNext()) {
                    String title = cursor.getString(0);
                    String actor = cursor.getString(1);
                    String day = cursor.getString(2);
                    String score = cursor.getString(3);
                    String time = cursor.getString(4);
                    String director = cursor.getString(5);
                    String story = cursor.getString(6);

                    result += "영화 제목 : " + title + "\n" + "주연 : " + actor + "\n" +
                            "개봉일 : " + day + "\n" + "평점 : " + score + "\n" +
                            "상영 시간 : " + time + "\n" + "감독 : " + director + "\n" +
                            "줄거리 : " + story + "\n\n";
                 }
                searchResult.setText(result);

                cursor.close();

                break;

            case R.id.searchOk:
                finish();
                break;

            case R.id.searchCancel:
                finish();
                break;
        }
    }
}
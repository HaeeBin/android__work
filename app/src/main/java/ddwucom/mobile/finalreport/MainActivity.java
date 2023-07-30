//과제명 : 영화 정보 관리 앱
//분반 : 02
//학번 : 20180961 성명 : 김해빈
//제출일 : 2021년 06월 23일
package ddwucom.mobile.finalreport;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ArrayList<MovieData> movieDataList = null;
    MovieAdapter movieAdapter;
    ListView listView;
    MovieDBManager movieDBManager;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieDataList = new ArrayList<MovieData>();
        listView = (ListView) findViewById(R.id.customListView);
        movieAdapter = new MovieAdapter(this, R.layout.custom_adapter_view, movieDataList);
        listView.setAdapter(movieAdapter);
        movieDBManager = new MovieDBManager(this);

        //수정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieData movie = movieDataList.get(position);
                Intent updateIntent = new Intent(MainActivity.this, UpdateActivity.class);
                updateIntent.putExtra("movie", movie);
                startActivityForResult(updateIntent, UPDATE_CODE);
            }
        });
        //삭제
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("영화 삭제")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (movieDBManager.removeMovie(movieDataList.get(pos).get_id())) {
                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    movieDataList.clear();
                                    movieDataList.addAll(movieDBManager.getAllMovie());
                                    movieAdapter.notifyDataSetChanged();
                                } else
                                    Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        movieDataList.clear();
        movieDataList.addAll(movieDBManager.getAllMovie());
        movieAdapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void onMenuItemClick(MenuItem item) {

        final ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate(this, R.layout.introduce_layout, null);

        switch (item.getItemId()) {
            case R.id.menuAdd:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;

            case R.id.menuSearch:
                Intent Intent2 = new Intent(this, SearchActivity.class);
                startActivity(Intent2);
                break;

            case R.id.menuIntroduce:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("개발자 소개")
                        .setView(constraintLayout)
                        .setPositiveButton("확인", null)
                        .setCancelable(false)
                        .show();
                break;

            case R.id.menuEnd:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("앱 종료")
                        .setMessage("앱을 종료하시겠습니까?")
                        .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                break;
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    String movie = data.getStringExtra("movie");
                    Toast.makeText(this, movie + " 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "영화 추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if(requestCode == UPDATE_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "영화 평점 변경 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "평점 수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
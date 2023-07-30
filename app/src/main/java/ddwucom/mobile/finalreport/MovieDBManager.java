package ddwucom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MovieDBManager {

    MovieDBHelper movieDBHelper = null;
    Cursor cursor = null;

    public MovieDBManager(Context context) {
        movieDBHelper = new MovieDBHelper(context);
    }

    public ArrayList<MovieData> getAllMovie() {
        ArrayList movieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + movieDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(MovieDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_TITLE));
            String actor = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_ACTOR));
            String day = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_DAY));
            String director = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_DIRECTOR));
            String time = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_TIME));
            String score = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_SCORE));
            String story = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_STORY));
            int img = cursor.getInt(cursor.getColumnIndex(MovieDBHelper.COL_IMG));

            movieList.add (new MovieData(id, img, title, actor, day, score, time, director, story));
        }
        cursor.close();
        movieDBHelper.close();
        return movieList;
    }

    public boolean addMovie(MovieData newMovie) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MovieDBHelper.COL_TITLE, newMovie.getTitle());
        value.put(MovieDBHelper.COL_ACTOR, newMovie.getActor());
        value.put(MovieDBHelper.COL_DAY, newMovie.getDay());
        value.put(MovieDBHelper.COL_SCORE, newMovie.getScore());

        long count = db.insert(MovieDBHelper.TABLE_NAME, null, value);
        movieDBHelper.close();
        if (count > 0) return true;
        return false;
    }

    public boolean modifyMovie(MovieData movie) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(MovieDBHelper.COL_SCORE, movie.getScore());
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] {String.valueOf(movie.get_id())};
        int result = sqLiteDatabase.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();
        if(result > 0) return true;
        return false;
    }

    public boolean removeMovie(long id) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = sqLiteDatabase.delete(MovieDBHelper.TABLE_NAME, whereClause, whereArgs);
        movieDBHelper.close();
        if(result > 0) return true;
        return false;
    }

//    public ArrayList<MovieData> getMovieByName(String movieTitle) {
//        SQLiteDatabase sqLiteDatabase = movieDBHelper.getReadableDatabase();
//        String[] selectArgs = new String[]
//        return null;
//    }

    public MovieData getMovieById(long id) {

        return null;
    }

    public void close() {
        if(movieDBHelper != null) movieDBHelper.close();
        if(cursor != null) cursor.close();
    }
}

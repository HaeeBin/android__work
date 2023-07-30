package ddwucom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MovieDBHelper extends SQLiteOpenHelper {
    final static String TAG = "MovieDBHelper";

    final static String DB_NAME = "movies.db";
    public final static String TABLE_NAME = "movie_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_SCORE = "score";
    public final static String COL_DIRECTOR = "director";
    public final static String COL_TIME = "time";
    public final static String COL_ACTOR = "actor";
    public final static String COL_DAY = "day";
    public final static String COL_STORY = "story";
    public final static String COL_IMG = "img";



    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                 COL_IMG + " integer, " + COL_TITLE + " TEXT, " + COL_ACTOR + " TEXT, " + COL_DAY +
                " TEXT, " + COL_SCORE + " TEXT, " + COL_TIME + " TEXT, " + COL_DIRECTOR + " TEXT, " + COL_STORY + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, 'R.mipmap.cruella', 'cruella', '엠마 스톤', '2021.05.26', '9.34', '133분', '크레이그 길레스피', '처음부터 난 알았어. 내가 특별하단 걸\n 그게 불편한 인간들도 있겠지만 모두의 비위를 맞출 수는 없잖아?\n 그러다 보니 결국, 학교를 계속 다닐 수가 없었지\n 우여곡절 런던에 오게 된 나, 에스텔라는 재스퍼와 호레이스를 운명처럼 만났고\n 나의 뛰어난 패션 감각을 이용해 완벽한 변장과 빠른 손놀림으로 런던 거리를 싹쓸이 했어\n 도둑질이 지겹게 느껴질 때쯤, 꿈에 그리던 리버티 백화점에 낙하산(?)으로 들어가게 됐어\n 거리를 떠돌았지만 패션을 향한 나의 열정만큼은 언제나 진심이었거든\n 근데 이게 뭐야, 옷에는 손도 못 대보고 하루 종일 바닥 청소라니\n 인내심에 한계를 느끼고 있을 때, 런던 패션계를 꽉 쥐고 있는 남작 부인이 나타났어\n 천재는 천재를 알아보는 법! 난 남작 부인의 브랜드 디자이너로 들어가게 되었지\n\n 꿈을 이룰 것 같았던 순간도 잠시, 세상에 남작 부인이‘그런 사람’이었을 줄이야…\n 그래서 난 내가 누군지 보여주기로 했어\n 잘가, 에스텔라\n\n 난 이제 크루엘라야!');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'R.mipmap.earwing', '아야와 마녀', '', '2021.06.10', '7.50', '83분', '미야자키 고로', '마녀지망생‘아야’의 신비롭고 미스터리한 모험이 시작된다!\n동료 마녀12명을 완전히 따돌리면 아이를 찾으러 오겠다는 수수께끼 같은 편지와 함께 성 모어발트의 집에 맡겨진 아야. 10살이 된 어느 날, 아야는 갑자기 찾아온 마법사 벨라와 맨드레이크를 따라 미스터리한 저택에 발을 들이게 된다. 순간이동할 수 있는 문부터 비밀의 방까지 신비로움으로 가득 찬 그곳에서의 생활이 시작되고, 아야는 벨라를 돕는 조건으로 마법을 배우기로 한다. 하지만 마법은 알려주지 않고 잔심부름만 시키는 마녀 벨라.\n 벨라를 골탕 먹이기 위한 마녀지망생 아야와\n 말하는 고양이 토마스의 아주 특별한 주문이 시작된다!');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'R.mipmap.fast', '분노의 질주', '빈 디젤, 존 시나, 성강', '2021.05.19', '7.65', '142분', '저스틴 린', '기다림은 끝났다!\n전 세계가 기다려온 단 하나의 액션블록버스터!\n도미닉(빈 디젤)은 자신과 가장 가까웠던 형제 제이콥(존 시나)이 사이퍼(샤를리즈 테론)와 연합해\n 전 세계를 위기로 빠트릴 위험천만한 계획을 세운다는 사실을 알게 되고,\n 이를 막기 위해 다시 한 번 패밀리들을 소환한다.\n 가장 가까운 자가 한순간, 가장 위험한 적이 된 상황\n 도미닉과 패밀리들은 이에 반격할 놀라운 컴백과 작전을 세우고\n 지상도, 상공도, 국경도 경계가 없는 불가능한 대결이 시작되는데…');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'R.mipmap.pipline', '파이프라인', '서인국, 이수혁, 음문석', '2021.05.26', '7.16', '108분', '유하', '목표는 하나, 목적은 여섯!\n화끈하게 뚫고, 완벽하게 빼돌려라!\n손만 대면 대박을 터트리는 도유 업계 최고 천공기술자‘핀돌이’는\n 수천억의 기름을 빼돌리기 위해 거대한 판을 짠 대기업 후계자‘건우’의\n 거부할 수 없는 제안에 빠져 위험천만한 도유 작전에 합류한다.\n 프로 용접공 접새, 땅 속을 장기판처럼 꿰고 있는 나과장,\n 괴력의 인간 굴착기 큰삽, 이 모든 이들을 감시하는 카운터까지!\n 그러나 저마다 다른 목적을 가진 이들이 서로를 속고 속이면서\n 계획은 예상치 못한 방향으로 흘러가기 시작하는데...\n 인생 역전을 꿈꾸는 여섯 명의 도유꾼들\n 그들의 막장 팀플레이가 시작된다!');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'R.mipmap.summer', '500일의 썸머', '조셉 고든레빗, 주이 디샤넬', '2021.05.26', '8.43', '95분', '마크 웹', '운명적 사랑을 믿는 남자‘톰’\n 모든 것이 특별한 여자‘썸머’에 완전히 빠졌다.\n 사랑은 환상일 뿐이라고 생각하는 여자‘썸머’\n 친구인 듯 연인 같은‘톰’과의 부담 없는 썸이 즐겁다.\n“저기… 우리는 무슨 관계야?”\n 설렘으로 가득한 시간도 잠시\n 두 사람에게도 피할 수 없는 선택의 순간이 찾아오는데…\n\n “우리 모두의 단짠단짠 연애담!”\n 설레는1일부터 씁쓸한500일까지\n 서로 다른 남녀의 극사실주의 하트시그널!\n');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}

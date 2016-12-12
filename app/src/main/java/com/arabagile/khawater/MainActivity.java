package com.arabagile.khawater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvKhawater)
    RecyclerView recyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        SharedPreferences prefs = this.getSharedPreferences(
                "com.arabagile.khawater", Context.MODE_PRIVATE);

        // Current user language
        String userLang = prefs.getString("user_language", "en");

        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        Locale locale = new Locale(userLang);
        Locale.setDefault(locale);
        conf.setLocale(locale);
        conf.setLayoutDirection(locale);
        conf.locale = locale;
        res.updateConfiguration(conf, dm);


        List<Khatera> items = new ArrayList();
        createDummyItems(items, 20);

        setTitle(getString(R.string.app_name));

        recyclerView.setAdapter(new KhawaterAdapter(MainActivity.this, items));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Goto New Activity
                Intent intent = new Intent(MainActivity.this, NewKhateraActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createDummyItems(List<Khatera> items, int numberOfItems) {

        // Dummy content
//        for (int i=0; i<numberOfItems; i++) {
//            items.add(new Khatera("", randomText(20),
//                    getString(R.string.days_ago, randomMinutes()), randomText(255), randomLikes()));
//        }

        items.add(new Khatera("1", "عمار الرفاعي",
                getString(R.string.days_ago, randomMinutes()),
                "وماشيا مرحاً يلهيه موطنه .. أبعد حمص تغرُّ المرء أوطانُ؟ - أبو البقاء الرندي \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("4", "Mohammed Abdullah",
                getString(R.string.days_ago, randomMinutes()),
                "“Always deliver more than expected.” —Larry Page \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("2", "عبد الرحمن سعد الدين",
                getString(R.string.days_ago, randomMinutes()),
                "رب اغفر لي ولوالدي رب ارحمهما كما ربياني صغيرا\n \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("3", "Maryam Bint Ahmed",
                getString(R.string.days_ago, randomMinutes()),
                "“Ideas are easy. Implementation is hard.” - Guy Kawasaki \n#ArabicAndroidCourse",
                randomLikes()));


        items.add(new Khatera("5", "مصطفى الجندلي",
                getString(R.string.days_ago, randomMinutes()),
                "The people who are crazy enough to think they can change the world are the ones who do! - Steve Jobs \n#ArabicAndroidCourse",
                randomLikes()));


        items.add(new Khatera("1", "عمار أبو ياسر",
                getString(R.string.days_ago, randomMinutes()),
                "انتهى الجزء الأول من هذا الكورس بحمد الله وفضله ومنه. له الحمد والنعمة والفضل والثناء الحسن.\nاليوم هو الثلاثاء ١٣ ديسمبر ٢٠١٦، والساعة الواحدة بعد منتصف الليل \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("3", "مريم بنت أحمد",
                getString(R.string.days_ago, randomMinutes()),
                "أهل القرآن هم أهل الله وخاصته... \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("5", "محمد عبد الله",
                getString(R.string.days_ago, randomMinutes()),
                "سيفتح باب إذا سد باب ... نعم وتهون الأمور الصعاب - الشافعي \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("4", "يوسف سامي الشامي",
                getString(R.string.days_ago, randomMinutes()),
                "It's time to go to Rwaq.com to complete Gamification in education course\n\n" +
                        "#التلعيب_في_التعليم #رواق\n" +
                        "دورة مفيدة حقا @AmjedAlderbi  \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("1", "عدنان ربيع الحسن",
                getString(R.string.days_ago, randomMinutes()),
                "أنا عند ظن عبدي بي.. اللهم إنا نظن بك كل خير، فخذ بنواصينا إلى ما فيه رضاك عنّا \n#ArabicAndroidCourse",
                randomLikes()));


        items.add(new Khatera("2", "سالم عبد الحميد الخالدي",
                getString(R.string.days_ago, randomMinutes()),
                "الرّأيُ قَبلَ شَجاعةِ الشّجْعانِ\tهُوَ أوّلٌ وَهيَ المَحَلُّ الثّاني\n" +
                        "فإذا همَا اجْتَمَعَا لنَفْسٍ حُرّةٍ\tبَلَغَتْ مِنَ العَلْياءِ كلّ مكانِ \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("4", "حسام المنلا",
                getString(R.string.days_ago, randomMinutes()),
                "لكل شيءٍ إذا ما تم نقصانُ\tفلا يُغرُّ بطيب العيش إنسانُ\n" +
                        "هي الأيامُ كما شاهدتها دُولٌ\tمَن سَرَّهُ زَمنٌ ساءَتهُ أزمانُ\n \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("3", "رجب أبو الوفا",
                getString(R.string.days_ago, randomMinutes()),
                "كـن بـلـسماً إن صار دهرك أرقما وحـلاوة إن صـار غـيـرك عـلـقما \n" +
                        "إن الـحـيـاة حـبـتـك كـلَّ كـنـوزهـا لا تـبخلنَّ على الحياة ببعض ما ..  \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("5", "محمد عبد الله",
                getString(R.string.days_ago, randomMinutes()),
                "Family is not an important thing. It's everything - Michael J. Fox \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("4", "مهند محمد العزازي",
                getString(R.string.days_ago, randomMinutes()),
                "يلا عساها في الجنان ... تنعم بخيرات حِسان! \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("1", "موسى عقيل أحمد",
                getString(R.string.days_ago, randomMinutes()),
                "The way to get started is to quit talking and begin doing. – Walt Disney \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("3", "Alia Mohammed Najeeb",
                getString(R.string.days_ago, randomMinutes()),
                "Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it. – Steve Jobs \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("2", "نزار خورشيد",
                getString(R.string.days_ago, randomMinutes()),
                "It’s not that I’m so smart, it’s just that I stay with problems longer. – Albert Einstein \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("5", "هادي زين الدين",
                getString(R.string.days_ago, randomMinutes()),
                "“To any entrepreneur: if you want to do it, do it now. If you don’t, you’re going to regret it.” - Catherine Cook \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("2", "مازن أبو عبدو الشيخ",
                getString(R.string.days_ago, randomMinutes()),
                "“It’s not about ideas. It’s about making ideas happen.” - Scott Belsky \n#ArabicAndroidCourse",
                randomLikes()));

        items.add(new Khatera("4", "همام محمد",
                getString(R.string.days_ago, randomMinutes()),
                "\"A person who never made a mistake never tried anything new.\" - Albert Einstein \n#ArabicAndroidCourse",
                randomLikes()));


    }

    public static String randomText(int maxLength) {
        char[] chars = "abcd efgh ijklm nopqr stuvw xyz ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++){
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static int randomLikes() {
        Random r = new Random();
        return r.nextInt(300 - 0 + 1) + 0;
    }

    public static int randomMinutes() {
        Random r = new Random();
        return r.nextInt(59 - 0 + 1) + 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_change_language:
                changeLanguage();
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeLanguage() {

        SharedPreferences prefs = this.getSharedPreferences(
                "com.arabagile.khawater", Context.MODE_PRIVATE);

        // Current user language
        String userLang = prefs.getString("user_language", "en");
        String newLang  = "";
        if (userLang.contentEquals("ar")) {
            // Change to English
            newLang = "en";
        } else {
            // Change to Arabic
            newLang = "ar";
        }

        // Save new lang to DB
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("user_language", newLang);
        editor.apply();

        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        Locale locale = new Locale(newLang);
        Locale.setDefault(locale);
        conf.setLocale(locale);
        conf.setLayoutDirection(locale);
        conf.locale = locale;
        res.updateConfiguration(conf, dm);

        // Refresh current activity
        Intent i = getIntent();
        finish();
        startActivity(i);
        overridePendingTransition(0, 0);
    }
}


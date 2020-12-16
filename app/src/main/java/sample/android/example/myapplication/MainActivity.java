package sample.android.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String[] names = {
            "one",
            "two",
            "three",
            "five"
    };
    private static final int[] photos = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.five
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //文字列配列　emails　を、配列 names の文字列の数だけ作成
        String[] emails = new String[names.length];

        //メールアドレスを配列namesの数だけ作成
        for (int i = 0 ; i < names.length ; i++){
            emails[i] = String.format(Locale.US,"%s@mail.co.jp",names[i]);
        }
        //ListViewのインスタンスを作成
        ListView listView = (ListView)findViewById(R.id.listView);
        //レイアウトファイルlist_itemをactivity_mainにinflateするために adapter に引数として渡す
        BaseAdapter adapter = new TestAdapter(this.getApplicationContext(),
                R.layout.list_items,names,emails,photos);

        //ListViewにアダプターをセット
        listView.setAdapter(adapter);
    }
}

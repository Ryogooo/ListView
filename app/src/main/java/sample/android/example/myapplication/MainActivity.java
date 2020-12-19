package sample.android.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this.getApplicationContext(),SubActivity.class);

        //クリックされたpositionの names と photos のID
        String selectText = names[position];
        int selectPhot = photos[position];

        //インテントにセット
        intent.putExtra("Text",selectText);
        intent.putExtra("Phot",selectPhot);

        startActivity(intent);
    }
}

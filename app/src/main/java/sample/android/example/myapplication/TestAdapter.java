package sample.android.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.sql.Struct;

public class TestAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private int layoutID;
    private String[] namelist;
    private String[] emaillist;
    private Bitmap[] photolist;

    static class ViewHolder{
        TextView text;
        TextView email;
        ImageView img;
    }

    public TestAdapter(Context context, int itemLayoutID, String[] names, String[] emails, int[] photos) {
        inflater = LayoutInflater.from(context);
        layoutID = itemLayoutID;
        namelist = names;
        emaillist = emails;
        photolist = new Bitmap[photos.length];
        for (int i = 0 ; i < photos.length ; i++){
            photolist[i] = BitmapFactory.decodeResource(context.getResources(),photos[i]);
        }
    }

    @Override
    public int getCount() {
        return namelist.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder Holder;
        if (convertView == null){
            convertView = inflater.inflate(layoutID,null);
            Holder = new ViewHolder();
            Holder.img = convertView.findViewById(R.id.img_item);
            Holder.email = convertView.findViewById(R.id.text_mail);
            Holder.text = convertView.findViewById(R.id.text_view);
            convertView.setTag(Holder);
        }else {
            Holder = (ViewHolder)convertView.getTag();
        }

        Holder.img.setImageBitmap(photolist[position]);

        String str = "staffID.10000" + String.valueOf(position + 1)
                + "\n\nEmail:" + emaillist[position]
                +"\nTell: 090-0000-0000" + String.valueOf(position + 1);
        Holder.text.setText(namelist[position]);

        Holder.email.setText(str);
        return convertView;


    }
}

package com.kmu.ndhs;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MenuActivity extends AppCompatActivity {

    TextView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu = (TextView) findViewById(R.id.menu);

        new MenuAsynTask(menu).execute("http://portal.ndhs.or.kr/studentLifeSupport/carte/list","tr");
    }
}


class MenuAsynTask extends AsyncTask<String,Void,String> {

    TextView textView;

    public MenuAsynTask(TextView textView){
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... params) {

        String URL = params[0];
        String E1 = params[1];
        String result = "";

        try{
            Document document = Jsoup.connect(URL).get();
            Elements elements = document.select(E1);

            for(Element element : elements){
                result = result+element.text()+"\n";
            }
            return result;
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);

        textView.setText(s);
    }
}
package com.example.savelifehome;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsOrAnnouncements extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter aAdapter;

    private String[] news = {"Montreal-area daycares are set to reopen June 1.",
            "Outdoor pools, splash pads, playgrounds and washrooms can now reopen.",
            "Montreal's state of emergency has been extended to June 4."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_or_announcements);

        mListView = findViewById(R.id.newslist);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, news);
        mListView.setAdapter(aAdapter);

        /*
        final TextView  jsonValue = findViewById(R.id.textView29);
        Button btn = findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask asyncTask = new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();
                        Request request = new Request.Builder()
                                .url("https://newsapi.org/v2/everything?q=COVID&from=2020-05-16&sortBy=publishedAt&apiKey=eef9095b8dfa4f76bcd8e2990dbaecf9&pageSize=2&page=1")
                                .method("GET", null)
                                .addHeader("Cookie", "__cfduid=d8f978037fc501a3b0c984ba4b187bbd01592347123")
                                .build();
                        try {
                            Response response = client.newCall(request).execute();
                            Log.v("sanjay", String.valueOf(response.body()));
                            return response.body().toString();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    protected void onPostExecute(Object o){

                            jsonValue.setText(o.toString());
                    }
                };

            }
        }); */


//
    }

}
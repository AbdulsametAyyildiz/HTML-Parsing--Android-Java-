package com.example.parsing;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String url = "http://saffatdergisi.com/degisim-liderligini-birlik-mefkuresiyle-okumak/";

    TextView text,text2;
    Document document,documentControl;
    Elements p;
    Elements h1;
    Elements elements,elementsText,ss,rr;
    String b,h3,h4,txt,cite,kaynak,figure,figurecapture,getUrl,previousUrl;
    Elements li;
    String imgUrl,ol,h2;
    String wright;
    Bitmap bitmap;
    ImageView imageView;
    WebView webView;
    List<Model> list;
    ListView listView;
    Document.OutputSettings outputSettings = new Document.OutputSettings();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new getHtml().execute();
    }

    public class getHtml extends AsyncTask <Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            text = findViewById(R.id.text);
            text2 = findViewById(R.id.text2);
            imageView = findViewById(R.id.image);

        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                outputSettings.prettyPrint(false);
                document = Jsoup.connect("http://saffatdergisi.com/medreseden-misak-i-maaarife/").ignoreContentType(true).get();
                elementsText = document.getElementsByClass("nv-content-wrap");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            String a="",b="",c="";
            list = new ArrayList<>();

            listView = findViewById(R.id.listView);

            for(int i=0; i<elementsText.first().children().size() ; i++){

                if(elementsText.first().child(i).getElementsByTag("h2").text().equals("")){
                    h2="";
                }else
                    h2=elementsText.first().child(i).getElementsByTag("h2").text();

                if(elementsText.first().child(i).getElementsByTag("h3").text().equals("")){
                    h3="";
                }else
                    h3=elementsText.first().child(i).getElementsByTag("h3").text();
                if(elementsText.first().child(i).getElementsByTag("p").text().equals("")){
                    txt="";
                }else
                    txt=elementsText.first().child(i).getElementsByTag("p").text();

                if(elementsText.first().child(i).getElementsByTag("ol").text().equals("")){
                    ol="";
                }else{
                    ol= Jsoup.clean(elementsText.first().child(i).getElementsByTag("ol").html().replace("</p>","\n\n"), "", Whitelist.none(), outputSettings);
                }

                if(elementsText.first().child(i).getElementsByTag("h4").text().equals("")){
                    h4="";
                }else
                    h4=elementsText.first().child(i).getElementsByTag("h4").text();

                if(elementsText.first().child(i).getElementsByTag("cite").text().equals("")){
                    cite="";
                }else cite=elementsText.first().child(i).getElementsByTag("cite").text();

                if(elementsText.first().child(i).getElementsByClass("wp-block-group__inner-container").text().equals("")){
                    kaynak="";
                }else
                    kaynak=Jsoup.clean(elementsText.first().child(i).getElementsByClass("wp-block-group__inner-container").html().replace("</p>","\n\n"), "", Whitelist.none(), outputSettings);

                if(elementsText.first().child(i).getElementsByTag("figure").first().getElementsByTag("a").attr("href").equals("")){
                    figure="";
                }else {figure=elementsText.first().child(i).getElementsByTag("figure").first().getElementsByTag("a").attr("href");
                    figurecapture=elementsText.first().child(i).getElementsByTag("figure").tagName("img").text();
                }

                Log.i("hatayok",i+".terim"+h3+"  "+txt+" "+ol);
                Model model = new Model(txt,h3,ol,h4,cite,kaynak,h2,figure,figurecapture);
                list.add(model);
            }

            Adapter adapter = new Adapter(list,getApplicationContext(),MainActivity.this);
            listView.setAdapter(adapter);
           for(int x=0; x<elementsText.first().children().size();x++){
            Log.i("hatayooook",(elementsText.first().child(x)+""));}
        }
;

    }




}


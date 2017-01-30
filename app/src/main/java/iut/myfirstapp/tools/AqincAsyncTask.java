package iut.myfirstapp.tools;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import iut.myfirstapp.MainActivity;
import iut.myfirstapp.R;

/**
 * Created by amanda on 30/01/2017.
 */

public class AqincAsyncTask extends AsyncTask<String, Integer, String> {

    private Activity act;

    public AqincAsyncTask(MainActivity act) {
        this.act=act;
    }

    protected String doInBackground(String... urlBase) {
        String strFileContents=null;
            try {
                URL url=new URL(urlBase[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                byte[] contents = new byte[1024];
                int bytesRead=0;

                while( (bytesRead = in.read(contents)) != -1){
                    strFileContents = new String(contents, 0, bytesRead);
                }
                in.close();
                urlConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return strFileContents;
    }

    protected void onProgressUpdate(Integer... progress) {

    }


    protected void onPostExecute(String result) {
        TextView myTextView=(TextView) act.findViewById(R.id.info);
        myTextView.setText(result);
    }



}

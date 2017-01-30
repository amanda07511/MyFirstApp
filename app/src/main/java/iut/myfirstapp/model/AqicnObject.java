package iut.myfirstapp.model;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by amanda on 30/01/2017.
 */

public class AqicnObject {
    public  AqicnObject() throws IOException {
        getDataFronUrl();
    }

    public void getDataFronUrl()throws IOException{
        URL url = new URL("http://api.waqi.info/feed/shanghai/?token=demo");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);
        } finally {
            urlConnection.disconnect();
        }
    }

    private void readStream(InputStream in) throws IOException {
        byte[] contents = new byte[1024];

        int bytesRead=0;
        String strFileContents;

        while( (bytesRead = in.read(contents)) != -1){

            strFileContents = new String(contents, 0, bytesRead);
            System.out.print(strFileContents);
        }

    }

}

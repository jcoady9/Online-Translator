package edu.ycp.coady.translator.models;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.Socket;


/**
 * An implementation of Database to access a English-German database on a separate server powered by JDictd.
 */
public class DictionaryDB implements Database {

    private final String url = "http://localhost:2626";  //url of the dictionary server;

    public String getData(DBQueryComponents queryComponents){

        DictQueryComponents query = (DictQueryComponents)queryComponents;
        String params = "/?db=" + query.getDatabaseName() + "&word=" + query.getWord();

        CloseableHttpClient client = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet(url + params);
        HttpClientContext context = HttpClientContext.create();

        CloseableHttpResponse resp = null;
        try {
            resp = client.execute(httpGet, context);
            if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = resp.getEntity();
                String result = parseForResult(EntityUtils.toString(entity));
                if(result == null){
                    return query.getWord();
                }
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (resp != null) {
                    resp.close();
                }
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "";
    }

    public boolean dbFileExists(){
        return false;
    }

    public boolean isActive(){
        Socket socket = null;
        try {
            socket = new Socket("localhost",2626);
        } catch (IOException e) {
            return false;
        }finally{
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

    private String parseForResult(String response){
        if(!response.contains("<pre>")){
            return null;
        }
        String result = response.substring(response.indexOf("<pre>"), response.indexOf("</pre>"));
        result = result.substring(result.lastIndexOf('/') + 1, result.length());
        int index = result.indexOf(';');
        if(index > 0){
            result = result.substring(0, index);
        }
        result = result.trim();
        return result.replace("<f>", "").trim();
    }

}

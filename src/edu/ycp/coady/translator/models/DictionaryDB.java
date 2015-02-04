package edu.ycp.coady.translator.models;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;


/**
 * An implementation of Database to access a English-German database on a separate server powered by JDictd.
 */
public class DictionaryDB implements Database {

    private final String url = "http://localhost:2628";  //url of the dictionary server;

    public String getData(String query){

        String params = "";

        CloseableHttpClient client = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet(url + params);
        HttpClientContext context = HttpClientContext.create();

        CloseableHttpResponse resp = null;
        try {
            resp = client.execute(httpGet, context);
            if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = resp.getEntity();
                return entity.getContent().toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                resp.close();
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
        return false;
    }

}

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
import java.net.InetAddress;


/**
 * An implementation of Database to access a English-German database on a separate server powered by JDictd.
 */
public class DictionaryDB implements Database {

    private final String url = "http://localhost:2626";  //url of the dictionary server;

    public String getData(String query){

        String params = "/?db=" + query.substring(0, query.indexOf(' ')) + "&word=" + query.substring(query.indexOf(' ') + 1);

        CloseableHttpClient client = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet(url + params);
        HttpClientContext context = HttpClientContext.create();

        CloseableHttpResponse resp = null;
        try {
            resp = client.execute(httpGet, context);
            if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = resp.getEntity();
                return EntityUtils.toString(entity);
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
        try {
            if(InetAddress.getByName("localhost:2626").isReachable(5000)){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

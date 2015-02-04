package edu.ycp.coady.translator.models;

/**
 * An implementation of Database to access a English-German database on a separate server.
 */
public class DictionaryDB implements Database {

    private final String url = "";  //url of the dictionary server;

    public String getData(String query){

        return "";
    }

    public boolean dbFileExists(){
        return false;
    }

    public boolean isActive(){
        return false;
    }

}

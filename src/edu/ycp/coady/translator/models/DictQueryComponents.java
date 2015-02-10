package edu.ycp.coady.translator.models;

/**
 *
 */
public class DictQueryComponents implements DBQueryComponents {

    private String dbName, word;

    public DictQueryComponents(String dbName, String word){
        this.dbName = dbName;
        this.word = word;
    }

    public String getDatabaseName(){
        return dbName;
    }

    public String getWord(){
        return word;
    }


}

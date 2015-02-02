package edu.ycp.coady.translator.models;

/**
 * Translates a string of text from its source language to the targeted language it is desired in
 */
public class Translator {

    private String sourceLanguage, targetLanguage;

    //constructor
    public Translator(String sourceLang, String targetLang){
        sourceLanguage = sourceLang;
        targetLanguage = targetLang;
    }

    //setter for source language
    void setSourceLanguage(String sourceLang){
        sourceLanguage = sourceLang;
    }

    //getter for source language
    String getSourceLanguage(){
        return sourceLanguage;
    }

    //setter for target language
    void setTargetLanguage(String targetLang){
        targetLanguage = targetLang;
    }

    //getter for target language
    String getTargetLanguage(){
        return targetLanguage;
    }

    //translates text from the source language to the target language
   public String translate(String text){
        return text;
    }
}

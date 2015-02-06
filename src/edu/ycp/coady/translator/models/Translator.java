package edu.ycp.coady.translator.models;

/**
 * Translates a string of text from its source language to the targeted language it is desired in
 */
public class Translator {
    
    private TranslationComponents components;

    //constructor
    public Translator(String sourceLang, String targetLang){
        components = new TranslationComponents(sourceLang, targetLang);
    }

    //setter for source language
    public void setSourceLanguage(String sourceLang){
        components.setSourceLanguage(sourceLang);
    }

    //getter for source language
    public String getSourceLanguage(){
        return components.getSourceLanguage();
    }

    //setter for target language
    public void setTargetLanguage(String targetLang){
        components.setTargetLanguage(targetLang);
    }

    //getter for target language
    public String getTargetLanguage(){
        return components.getTargetLanguage();
    }

    //translates text from the source language to the target language
    public String translate(String text){
        return text;
    }
}

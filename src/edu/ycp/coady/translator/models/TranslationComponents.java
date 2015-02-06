package edu.ycp.coady.translator.models;

/**
 *
 */
public class TranslationComponents {
    private String source_language, target_language, source_text;       //the components necessary for translation: source & target languages as well as the source text

    //constructor
    public TranslationComponents(String sourceLang, String targetLang, String sourceText){
        source_language = sourceLang;
        target_language = targetLang;
        source_text = sourceText;
    }

    //constructor
    public TranslationComponents(String sourceLang, String targetLang){
        source_language = sourceLang;
        target_language = targetLang;
        source_text = "";
    }

    //setter for the source language
    public void setSourceLanguage(String sourceLang){
        source_language = sourceLang;
    }

    //getter for the source language
    public String getSourceLanguage(){
        return source_language;
    }

    //setter for the target language
    public void setTargetLanguage(String targetLang){
        target_language = targetLang;
    }

    //getter for the target language
    public String getTargetLanguage(){
        return target_language;
    }

    //setter for the source text
    public void setSourceText(String sourceText){
        source_text = sourceText;
    }

    //getter for the source text
    public String getSourceText(){
        return source_text;
    }
}

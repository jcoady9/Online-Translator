package edu.ycp.coady.translator.models;

/**
 *
 */
public class TranslationComponents {
    private String source_language, target_language, source_text;

    public TranslationComponents(String sourceLang, String targetLang, String sourceText){
        source_language = sourceLang;
        target_language = targetLang;
        source_text = sourceText;
    }

    public TranslationComponents(String sourceLang, String targetLang){
        source_language = sourceLang;
        target_language = targetLang;
        source_text = "";
    }

    public void setSourceLanguage(String sourceLang){
        source_language = sourceLang;
    }

    public String getSourceLanguage(){
        return source_language;
    }

    public void setTargetLanguage(String targetLang){
        target_language = targetLang;
    }

    public String getTargetLanguage(){
        return target_language;
    }

    public void setSourceText(String sourceText){
        source_text = sourceText;
    }

    public String getSourceText(){
        return source_text;
    }
}

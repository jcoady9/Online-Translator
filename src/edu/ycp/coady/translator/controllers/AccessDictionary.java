package edu.ycp.coady.translator.controllers;

import edu.ycp.coady.translator.models.Database;
import edu.ycp.coady.translator.models.DictQueryComponents;
import edu.ycp.coady.translator.models.DictionaryDB;
import edu.ycp.coady.translator.models.TranslationComponents;

import java.util.ArrayList;

/**
 * A controller to access the correct dictionary database and find a word for word translation of the souce text
 */
public class AccessDictionary {

    public String determineDict(String sourceLang, String targetLang) {
        if (sourceLang.equals("en") && targetLang.equals("de")) {
            return "eng-deu";
        }else if(sourceLang.equals("de") && targetLang.equals("en")){
            return "deu-eng";
        }else{
            throw new UnsupportedOperationException("Dictionary is not supported.");
        }
    }

    public ArrayList<String> splitText(String text){
        ArrayList<String> words = new ArrayList<String>();

        int pos = 0;
        while(text.indexOf(' ', pos) > 0){
            int nextPos = text.indexOf(' ', pos);
            String word = text.substring(pos, nextPos);
            pos = nextPos + 1;
            words.add(word);
        }
        words.add(text.substring(pos));

        return words;
    }

    public String lookUpWord(String dict, String word){
        Database dictDB = new DictionaryDB();
        DictQueryComponents query = new DictQueryComponents(dict, word);
        return dictDB.getData(query);
    }

    public String getTranslation(TranslationComponents components){
        String translation = "";
        String dict = determineDict(components.getSourceLanguage(), components.getTargetLanguage());
        ArrayList<String> words = splitText(components.getSourceText());

        for(String word : words){
            translation = translation.concat(lookUpWord(dict, word) + " ");
        }

        return translation;
    }

}

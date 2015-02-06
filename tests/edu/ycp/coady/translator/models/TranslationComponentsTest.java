package edu.ycp.coady.translator.models;

import junit.framework.TestCase;

public class TranslationComponentsTest extends TestCase {

    TranslationComponents translationComponents;
    String text = "This is some text.";

    public void setUp() throws Exception {
        super.setUp();
        translationComponents = new TranslationComponents("en", "de", text);
    }

    public void testSetSourceLanguage() throws Exception {
        TranslationComponents testSetSource = new TranslationComponents("de", "en");
        assert(testSetSource.getSourceLanguage().equals("de"));
        testSetSource.setSourceLanguage("fr");
        assert(testSetSource.getSourceLanguage().equals("fr"));
    }

    public void testGetSourceLanguage() throws Exception {
        assert(translationComponents.getSourceLanguage().equals("en"));
    }

    public void testSetTargetLanguage() throws Exception {
        TranslationComponents testSetTarget = new TranslationComponents("ru", "jp");
        assert(testSetTarget.getTargetLanguage().equals("jp"));
        testSetTarget.setTargetLanguage("sp");
        assert(testSetTarget.getTargetLanguage().equals("sp"));
    }

    public void testGetTargetLanguage() throws Exception {
        assert(translationComponents.getTargetLanguage().equals("de"));
    }

    public void testSetSourceText() throws Exception {
        TranslationComponents testSetEmptySource = new TranslationComponents("en", "fr");
        assert(testSetEmptySource.getSourceText().equals(""));
        testSetEmptySource.setSourceText("stuff and things");
        assert(testSetEmptySource.getSourceText().equals("stuff and things"));
    }

    public void testGetSourceText() throws Exception {
        TranslationComponents testGetEmptySource = new TranslationComponents("en", "fr");
        assert(testGetEmptySource.getSourceText().equals(""));
        testGetEmptySource.setSourceText("Hello");
        assert(testGetEmptySource.getSourceText().equals("Hello"));
        assert(translationComponents.getSourceText().equals(text));
    }
}
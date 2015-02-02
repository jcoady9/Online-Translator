package edu.ycp.coady.translator.models;

public class TranslatorTest {

    Translator translator;

    @org.junit.Before
    public void setUp() throws Exception {
        translator = new Translator("one", "two");
    }

    @org.junit.Test
    public void testSetSourceLanguage() throws Exception {
        translator.setSourceLanguage("english");
        assert(translator.getSourceLanguage().equals("english"));
    }

    @org.junit.Test
    public void testGetSourceLanguage() throws Exception {
        translator.setSourceLanguage("belgian");
        assert(translator.getSourceLanguage().equals("belgian"));
    }

    @org.junit.Test
    public void testSetTargetLanguage() throws Exception {
        translator.setTargetLanguage("deutsch");
        assert(translator.getTargetLanguage().equals("deutsch"));
    }

    @org.junit.Test
    public void testGetTargetLanguage() throws Exception {
        translator.setTargetLanguage("russian");
        assert(translator.getTargetLanguage().equals("russian"));
    }

    @org.junit.Test
    public void testTranslate() throws Exception {
        assert(translator.translate("some text").equals("some text"));
    }
}
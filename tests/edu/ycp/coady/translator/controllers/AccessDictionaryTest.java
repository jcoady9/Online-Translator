package edu.ycp.coady.translator.controllers;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AccessDictionaryTest extends TestCase {

    AccessDictionary accessDB;

    public void setUp()throws Exception{
        accessDB = new AccessDictionary();
    }

    public void testDetermineDict() throws Exception {
        assertEquals(accessDB.determineDict("en", "de"), "dc");
        try{
            accessDB.determineDict("fr", "ru").equals("jp");
            fail("failed DetermineDict throwing UnsupportedOperationException");
        }catch(UnsupportedOperationException e){
            assertEquals(e.getMessage(), "Dictionary is not supported.");
        }

    }

    public void testSplitText() throws Exception {
        String str = "This is a test";
        ArrayList<String> arrList = accessDB.splitText(str);
        assert(arrList.size() == 4);
        int[] indices = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++){
            indices[i] = str.indexOf(arrList.get(i));
        }
        for(int i = 1; i < arrList.size() - 1; i++){
           assert(indices[i] > indices[i - 1] && indices[i] < indices[i + 1]);
        }

    }

    public void testLookUpWord() throws Exception {
        assert(accessDB.lookUpWord("dc", "printer").equals("Drucker"));
    }

    public void testGetTranslation() throws Exception {

    }
}
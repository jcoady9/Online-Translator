package edu.ycp.coady.translator.models;

import junit.framework.TestCase;

public class DictionaryDBTest extends TestCase {

    DictionaryDB dictDB;

    public void setUp() throws Exception {
        super.setUp();
        dictDB = new DictionaryDB();
    }

    public void testGetData() throws Exception {

    }

    public void testDbFileExists() throws Exception {
        //not implemented
    }

    public void testIsActive() throws Exception {
        assert(dictDB.isActive());
    }
}
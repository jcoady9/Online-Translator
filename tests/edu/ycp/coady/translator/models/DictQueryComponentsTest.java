package edu.ycp.coady.translator.models;

import junit.framework.TestCase;

public class DictQueryComponentsTest extends TestCase {

    DictQueryComponents dictQuery;

    public void setUp() throws Exception{
        dictQuery = new DictQueryComponents("database", "word");
    }

    public void testGetDatabaseName() throws Exception {
        assert(dictQuery.getDatabaseName().equals("database"));
    }

    public void testGetWord() throws Exception {
        assert(dictQuery.getWord().equals("word"));
    }
}
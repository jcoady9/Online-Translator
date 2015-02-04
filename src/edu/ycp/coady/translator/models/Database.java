package edu.ycp.coady.translator.models;

/**
 * A simple interface for creating different implementations of database management systems (SQL, ORACLE, DERBY, and all that other crap) as necessary
 */
public interface Database {
    public String getData();
    public boolean dbFileExists();
    public boolean isActive();
}

package com.bindstone.graphbank.repository;

/**
 * General Mapper for Database operations.
 */
public interface DatabaseMapper {
    /**
     * Clear all Nodes and Relations
     */
    void clear();

    /**
     * Load the Neo4J example CSV in the database from:
     * https://neo4j.com/developer/example-project/
     */
    void initData();
}

package com.piscessera.unittest.rdb.datasource;

public enum RdbDatabaseType {
    MYSQL("com.mysql.jdbc.Driver")
    ;

    private String namespace;

    RdbDatabaseType(String namespace) {
        this.namespace = namespace;
    }

    public String getNamespace() {
        return namespace;
    }
}

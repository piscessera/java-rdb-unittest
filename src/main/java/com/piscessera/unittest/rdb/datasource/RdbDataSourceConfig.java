package com.piscessera.unittest.rdb.datasource;

import lombok.*;

@EqualsAndHashCode
public class RdbDataSourceConfig {
    @Getter @Setter
    private RdbDatabaseType driver;
    @Getter @Setter
    private String jdbcUrl;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;
}

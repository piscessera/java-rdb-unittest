package com.piscessera.unittest.rdb.datasource;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class RdbMySqlDataSource implements RdbDataSourceInterface {
    private RdbDataSourceConfig dataSourceConfig;

    public void loadConfig(RdbDataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public DataSource createDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(this.dataSourceConfig.getJdbcUrl());
        dataSource.setUsername(this.dataSourceConfig.getUsername());
        dataSource.setPassword(this.dataSourceConfig.getPassword());
        dataSource.setDriverClassName(this.dataSourceConfig.getDriver().getNamespace());
        return dataSource;
    }
}

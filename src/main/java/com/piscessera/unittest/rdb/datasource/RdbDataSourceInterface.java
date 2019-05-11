package com.piscessera.unittest.rdb.datasource;

import javax.sql.DataSource;

public interface RdbDataSourceInterface {
    public void loadConfig(RdbDataSourceConfig dataSourceConfig);
    public DataSource createDataSource();
}

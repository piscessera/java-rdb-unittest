package com.piscessera.unittest.rdb.repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public interface RdbRepositoryInterface {
    public void createTable(DataSource dataSource) throws IOException;
    public void dropTable(DataSource dataSource);
    public void loadData(List<Object> datas);
    public void loadData(DataSource dataSource);
    public void cleanData(DataSource dataSource);
}

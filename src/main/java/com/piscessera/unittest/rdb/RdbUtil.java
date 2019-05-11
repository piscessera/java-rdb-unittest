package com.piscessera.unittest.rdb;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;
import org.apache.commons.io.FileUtils;

public class RdbUtil {
    private final static String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String readStatementFromFile(String path) throws IOException {
        File file = new File(path);
        return FileUtils.readFileToString(file, "UTF-8");
    }

    private static String replaceSqlTableName(String sql, String tableName) {
        return sql.replace("#", tableName);
    }

    public static String generateTableSessionName() {
        String result = "";
        Random random = new Random();
        result = text.charAt(random.nextInt(text.length() - 1)) + String.format("%04d", random.nextInt(10000));
        return result;
    }

    public static void createTable(DataSource dataSource, String schemaPath, String tableName) {
        try {
            String sql = replaceSqlTableName(readStatementFromFile(schemaPath), tableName);

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createData(DataSource dataSource, String dataPath, String tableName) {
        try {
            String sql = replaceSqlTableName(readStatementFromFile(dataPath), tableName);

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String[] queries = sql.split("\n");
            for (String query : queries) {
                statement.addBatch(query);
            }
            statement.executeBatch();
            statement.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dropTable(DataSource dataSource, String tableName) {
        try {
            String sql = "DROP TABLE " + tableName;

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cleanData(DataSource dataSource, String tableName) {
        try {
            String sql = "TRUNCATE TABLE " + tableName;

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

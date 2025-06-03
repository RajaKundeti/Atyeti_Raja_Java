package org.pp1.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseUtilTest {

    @BeforeAll
    public static void setup() {
        // Connect to in-memory H2 database
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"; // keep DB open
        DatabaseUtil.setConnection(url, "sa", "");
    }

    @Test
    public void testConnectionSuccess() throws SQLException {
        Connection con = DatabaseUtil.con;
        assertNotNull(con);
        assertFalse(con.isClosed());
        assertEquals("H2", con.getMetaData().getDatabaseProductName());
    }

    @Test
    public void testCreateAndSelectTable() {
        String createTable = "CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255))";
        String insert = "INSERT INTO users VALUES (1, 'Alice')";
        String select = "SELECT * FROM users";

        // No exceptions should be thrown
        assertDoesNotThrow(() -> DatabaseUtil.executeUserQuery(createTable));
        assertDoesNotThrow(() -> DatabaseUtil.executeUserQuery(insert));
        assertDoesNotThrow(() -> DatabaseUtil.executeUserQuery(select));
    }

    @Test
    public void testInvalidQuery() {
        String badQuery = "SELECT * FROM non_existing_table";
        assertDoesNotThrow(() -> DatabaseUtil.executeUserQuery(badQuery)); // It logs error but doesn’t throw
    }

}
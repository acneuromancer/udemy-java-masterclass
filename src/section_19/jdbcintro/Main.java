package section_19.jdbcintro;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/armitage/NetBeansProjects/TestDB/testjava.db");
             Statement statement = conn.createStatement()) {
            // Class.forName("org.sql.JDBC");
            // conn.setAutoCommit(false);

            // insertIntoDB(statement);
            // updateRecord(statement);
            /// deleteRecord(statement);
            // select(statement);
            select2(statement);

            //conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertIntoDB(Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
        statement.execute("INSERT INTO contacts (name, phone, email) "
                + "VALUES ('Tim', 6545678, 'tim@email.com')");
        statement.execute("INSERT INTO contacts (name, phone, email) "
                + "VALUES ('Joe', 45632, 'joe@email.com')");
        statement.execute("INSERT INTO contacts (name, phone, email) "
                + "VALUES ('Jane', 4829484, 'jane@somewhere.com')");
        statement.execute("INSERT INTO contacts (name, phone, email) "
                + "VALUES ('Fido', 9038, 'dog@email.com')");
    }

    public static void updateRecord(Statement statement) throws SQLException {
        boolean result = statement.execute("UPDATE contacts SET phone=5566789 WHERE name='Jane'");
        System.out.println("Updating record(s): " + result);
    }

    public static void deleteRecord(Statement statement) throws SQLException {
        statement.execute("DELETE FROM contacts WHERE name='Joe'");
    }

    public static void select(Statement statement) throws SQLException {
        ResultSet results = null;
        statement.execute("SELECT * FROM contacts");
        results = statement.getResultSet();
        while (results.next()) {
            System.out.println(results.getString("name") + " "
                    + results.getInt("phone") + " "
                    + results.getString("email"));
        }
        if (results != null) {
            results.close();
        }
    }

    public static void select2(Statement statement) throws SQLException {
        ResultSet results = null;
        results = statement.executeQuery("SELECT * FROM contacts");
        while (results.next()) {
            System.out.println(results.getString("name") + " "
                    + results.getInt("phone") + " "
                    + results.getString("email"));
        }
        if (results != null) {
            results.close();
        }
    }

}

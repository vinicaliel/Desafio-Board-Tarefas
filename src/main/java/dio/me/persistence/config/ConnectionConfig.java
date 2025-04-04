package dio.me.persistence.config;
import static lombok.AccessLevel.PRIVATE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.NoArgsConstructor;


@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {


public static Connection getConnection() throws SQLException {

    var url = "jdbc:postgresql://localhost:5432/BOARD-PROJECT";

    var user = "postgres";

    var password = "123a123a";

    var connection = DriverManager.getConnection(url, user, password);

    connection.setAutoCommit(false);
    return connection;


}
    



}

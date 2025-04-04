package dio.me;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dio.me.persistence.config.ConnectionConfig;
import dio.me.persistence.migration.MigrationStrategy;

@SpringBootApplication
public class DesafioBoardDeTarefasApplication {

	public static void main(String[] args) throws SQLException{
		try(var connection = ConnectionConfig.getConnection()){
			new MigrationStrategy(connection).executeMigration();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

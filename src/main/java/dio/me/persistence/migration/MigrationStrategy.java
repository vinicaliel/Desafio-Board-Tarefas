package dio.me.persistence.migration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import dio.me.persistence.config.ConnectionConfig;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.AllArgsConstructor;




@AllArgsConstructor
public class MigrationStrategy {

    private final Connection connection;

    public void executeMigration(){
        var originalOut = System.out;
        var originalErr = System.err;

        
            try( 
            var fos = new FileOutputStream("liquebase.log")){

            System.setOut(new PrintStream(fos));
            System.setErr(new PrintStream(fos));
            
           
            
            try (
                var connection = ConnectionConfig.getConnection();
                var jdbcConnection = new JdbcConnection(connection);
                ){
                
                try (var liquibase = new Liquibase(
                    "db/changelog/db.changelog-master.yml", 
                    new ClassLoaderResourceAccessor(), 
                    jdbcConnection)) {

                    liquibase.update();
                }

            }catch(SQLException | LiquibaseException ex ){
                ex.printStackTrace();
            }
            


        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
  



}}

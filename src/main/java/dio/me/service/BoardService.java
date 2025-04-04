package dio.me.service;

import java.sql.Connection;

import java.sql.SQLException;

import dio.me.persistence.dao.BoardColumnDAO;
import dio.me.persistence.dao.BoardDAO;
import dio.me.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BoardService {

    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException{
        var dao = new BoardDAO(connection);
        var BoardCollumnDAO = new BoardColumnDAO(connection);
        try  {
            dao.insert(entity);
           var columns = entity.getBoardColumns().stream().map(c -> {
                c.setBoard(entity);
                return c;

            }).toList();
            for (var column : columns) {
                BoardCollumnDAO.insert(column);
            } 
            connection.commit(); 
            return entity;
        } catch (Exception e) {
            connection.rollback(); 
            throw e; 
        }
    }

    public boolean delete (final Long id) throws SQLException{
        var dao = new BoardDAO(connection);
        try  {
            if(!dao.exists(id)){
                    return false;

            }
            dao.delete(id);
            connection.commit();

            return true;
        } catch (Exception e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

}

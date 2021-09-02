package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArenaRepository {

    @Autowired
    private DataSource dataSource;

    public List<Arena> getAll() {
        List<Arena> arenaList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ARENA");) {
            //preparedStatement.setString();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Arena arena = rsArena(rs);
                arenaList.add(arena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arenaList;
    }

    private Arena rsArena(ResultSet rs) throws SQLException {
        return new Arena(rs.getInt("id"),
                rs.getString("arena_name"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getInt("arena_capacity"));
    }

    public Arena getArenaById(Integer arenaId) {
        Arena arena = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ARENA WHERE id =?");) {
            preparedStatement.setInt(1, arenaId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                arena = rsArena(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arena;
    }
}

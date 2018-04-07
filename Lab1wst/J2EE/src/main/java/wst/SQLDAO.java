package wst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLDAO {
    private List<Laptop> returnResultSetAsList(ResultSet resultSet) {
        List<Laptop> laptops = new ArrayList<>();
        try {
            while (resultSet.next())
                laptops.add(new Laptop(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("CPU"),
                        resultSet.getString("RAM"),
                        resultSet.getString("video_card"),
                        resultSet.getString("HDD")));
        } catch (SQLException e) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return laptops;
    }

    private void setStringFilterFiledValue(PreparedStatement statement, int index, String value) throws SQLException {
        if (value == null)
            statement.setNull(index, Types.VARCHAR);
        else
            statement.setString(index, value);
    }

    private void setLongFilterFiledValue(PreparedStatement statement, int index, Long value) throws SQLException {
        if (value == null)
            statement.setNull(index, Types.INTEGER);
        else
            statement.setLong(index, value);
    }

    public List<Laptop> getLaptops() {
        try (Connection connection = ConnectionLab.getConnection()) {
            Statement statement = connection.createStatement();
            return returnResultSetAsList(statement.executeQuery("SELECT * FROM laptops"));
        } catch (SQLException e) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return new ArrayList<>();
    }

    public List<Laptop> findLaptops(LaptopFilter laptopFilter) {
        try (Connection connection = ConnectionLab.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM laptops WHERE name LIKE ? OR CPU LIKE ? OR RAM LIKE ? OR video_card LIKE ? OR HDD LIKE ?");

            setStringFilterFiledValue(preparedStatement, 1, laptopFilter.getName());
            setStringFilterFiledValue(preparedStatement, 2, laptopFilter.getCPU());
            setStringFilterFiledValue(preparedStatement, 3, laptopFilter.getRAM());
            setStringFilterFiledValue(preparedStatement, 4, laptopFilter.getVideo_card());
            setStringFilterFiledValue(preparedStatement, 5, laptopFilter.getHDD());

            return returnResultSetAsList(preparedStatement.executeQuery());
        } catch (SQLException e) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return new ArrayList<>();
    }
}
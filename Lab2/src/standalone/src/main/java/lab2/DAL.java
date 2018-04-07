package lab2;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import lab2.StatusOperation.*;

public class DAL {

    Connection connection = null;

    public DAL(Connection conn){
        this.connection = conn;
    }

    private  void setPrepareStatementParamsForInsOrUpdate(PreparedStatement stmt, Laptop laptop) throws SQLException{
        if(laptop.getName() != null) {
            stmt.setString(1, laptop.getName());
        }
        else{
            stmt.setNull(1, Types.VARCHAR);
        }

        if(laptop.getCPU() != null) {
            stmt.setString(2, laptop.getCPU());
        }
        else{
            stmt.setNull(2, Types.VARCHAR);
        }

        if(laptop.getRAM() != null) {
            stmt.setString(3, laptop.getRAM());
        }
        else{
            stmt.setNull(3, Types.VARCHAR);
        }

        if(laptop.getVideo_card() != null) {
            stmt.setString(4, laptop.getVideo_card());
        }
        else{
            stmt.setNull(4, Types.VARCHAR);
        }

        if(laptop.getHDD() != null) {
            stmt.setString(5, laptop.getHDD());
        }
        else{
            stmt.setNull(5, Types.VARCHAR);
        }
    }

    private void setPrepareStatementParams (PreparedStatement stmt, LaptopFilter laptopFilter)throws SQLException {
        if(laptopFilter.getName() != null) {
            stmt.setString(1, laptopFilter.getName());
        }
        else{
            stmt.setNull(1, Types.VARCHAR);
        }

        if(laptopFilter.getCPU() != null) {
            stmt.setString(2, laptopFilter.getCPU());
        }
        else{
            stmt.setNull(2, Types.VARCHAR);
        }

        if(laptopFilter.getRAM() != null) {
            stmt.setString(3, laptopFilter.getRAM());
        }
        else{
            stmt.setNull(3, Types.VARCHAR);
        }

        if(laptopFilter.getVideo_card() != null) {
            stmt.setString(4, laptopFilter.getVideo_card());
        }
        else{
            stmt.setNull(4, Types.VARCHAR);
        }

        if(laptopFilter.getHDD() != null) {
            stmt.setString(5, laptopFilter.getHDD());
        }
        else{
            stmt.setNull(5, Types.VARCHAR);
        }

    }

    private void setResultSetToArrayList(ResultSet rs, ArrayList<Laptop> laptops) throws  SQLException{
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String CPU = rs.getString("CPU");
            String RAM = rs.getString("RAM");
            String video_card = rs.getString("video_card");
            String HDD = rs.getString("HDD");

            Laptop laptop = new Laptop(id,
                    name,
                    CPU,
                    RAM,
                    video_card,
                    HDD);
            laptops.add(laptop);
        }
    }

    public List<Laptop> getLaptopsByFilter(LaptopFilter filter){
        ArrayList<Laptop> laptops = new ArrayList<Laptop>();
        try{
            String sql = "select * from laptops where name like ? or CPU like ? or RAM like ? or video_card like ? or HDD like ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            this.setPrepareStatementParams(stmt, filter);
            ResultSet rs = stmt.executeQuery();
            this.setResultSetToArrayList(rs, laptops);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return laptops;
    }

    public List<Laptop> getLaptops(){
        ArrayList<Laptop> laptops = new ArrayList<Laptop>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from laptops");
            this.setResultSetToArrayList(rs, laptops);
        }
        catch(SQLException e){
            e.printStackTrace();
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, e);
        }
        return laptops;
    }

    public ResultStatusOperation deleteLaptop(int id){
        ResultStatusOperation res = null;
        try{
            String sql = "DELETE FROM laptops where id = ?";
            PreparedStatement preparedSt = connection.prepareStatement(sql);
            preparedSt.setInt(1, id);
            int countDelete = preparedSt.executeUpdate();
            if(countDelete != 0) {
                res = new ResultStatusOperation(StatusCrudOperation.DeleteSuccess, "Удалено " + countDelete + " записей с id = " + id);
                System.out.println("Произведено удаление записи с id = " + id);
            }
            else
                res = new ResultStatusOperation(StatusCrudOperation.DeleteEmpty, "Не удалено ни одной записи.");
        }
        catch(SQLException e){
            e.printStackTrace();
            res = new ResultStatusOperation(StatusCrudOperation.DeleteError, "Ошибка удаления записи из БД: \n" + e.getStackTrace());
        }
        return res;
    }

    public ResultStatusOperation updateLaptop(Laptop laptop){
        ResultStatusOperation res = null;
        try{
            String sql = "UPDATE laptops SET " +
                    "name like ?,  " +
                    "CPU like ?, " +
                    "RAM like ?, " +
                    "video_card like ?, " +
                    "HDD like ?" +
                    "where id = ?";
            PreparedStatement preparedSt = connection.prepareStatement(sql);

            setPrepareStatementParamsForInsOrUpdate(preparedSt, laptop);

            preparedSt.setInt(6, laptop.getId());

            int countUpdate = preparedSt.executeUpdate();

            if(countUpdate != 0) {
                System.out.println("Обновление информации произведено успешно: \n" + laptop.toString());
                res = new ResultStatusOperation(StatusCrudOperation.UpdateSuccess, "Обновлено " + countUpdate + " записей");
            }
            else
                res = new ResultStatusOperation(StatusCrudOperation.UpdateEmpty, "Не найдено ни одной записи для обновления с id = " + laptop.getId());
        }
        catch (SQLException e){
            e.printStackTrace();
            res = new ResultStatusOperation(StatusCrudOperation.UpdateError, "Ошибка обновления таблицы БД: \n" + e.getStackTrace());
        }
        return res;
    }

    public ResultStatusOperation insertLaptop(Laptop laptop){
        ResultStatusOperation res = null;
        try{
            String sql = "INSERT  " +
                    "INTO laptops (name, CPU, RAM, video_card, HDD) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedSt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setPrepareStatementParamsForInsOrUpdate(preparedSt, laptop);
            if(preparedSt.executeUpdate() > 0){
                int id = -1;
                ResultSet generatedKeys = preparedSt.getGeneratedKeys();
                if(generatedKeys.next()){
                    id = generatedKeys.getInt(1);
                    System.out.println("Вставка записи произведена успешно");
                    res = new ResultStatusOperation(StatusCrudOperation.InsertSuccess, "Вставка новой записи успешна", id);
                }
            }
            else{
                res = new ResultStatusOperation(StatusCrudOperation.InsertError, "Непредвиденная ошибка при вставке записи");
            }
        }
        catch(SQLException e){
            res = new ResultStatusOperation(StatusCrudOperation.InsertError, "При вставке записи возникла ошибка: \n" + e.getStackTrace());
        }
        return res;
    }

    public ResultStatusOperation deleteAllLaptops(){
        ResultStatusOperation res = null;
        try{
            Statement st = connection.createStatement();
            st.executeQuery("DELETE * FROM laptops");
            res = new ResultStatusOperation(StatusCrudOperation.DeleteSuccess, "Таблица успешно очищена");
        }
        catch(SQLException e){
            e.printStackTrace();
            res = new ResultStatusOperation(StatusCrudOperation.DeleteError, "Удаление данных произошло с ошибкой: \n" + e.getStackTrace());
        }
        return res;
    }
}

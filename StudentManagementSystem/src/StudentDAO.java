import java.sql.*;

public class StudentDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;

    public StudentDAO(){
        connection = DatabaseConnection.getConnection();
    }

    public void addStudentProfile(String name , String domain , String address){

        try {
            String sql = "INSERT INTO student(name,domain,address) VALUES(?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,domain);
            preparedStatement.setString(3,address);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayStudentProfiles(){

        try {
            String sql = "SELECT * FROM student;";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String domain = resultSet.getString("domain");
                String address = resultSet.getString("address");

                System.out.println("ID:" + id);
                System.out.println("Name:" + name);
                System.out.println("Domain:" + domain);
                System.out.println("Address:" + address);
                System.out.println("--------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayStudentProfilesByID(int id){

        try {
            String sql = "SELECT * FROM student WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int ID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String domain = resultSet.getString("domain");
                String address = resultSet.getString("address");

                System.out.println("ID:" + ID);
                System.out.println("Name:" + name);
                System.out.println("Domain:" + domain);
                System.out.println("Address:" + address);
                System.out.println("--------------------");
            }
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteStudentProfile(int id){
        try {
            String sql = "DELETE FROM student WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateStudentDomain(String domain , int id){
        try {
            String sql = "UPDATE student SET domain = ? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,domain);
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateStudentAddress( String address , int id){
        try {
            String sql = "UPDATE student SET address = ? WHERE id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,address);
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

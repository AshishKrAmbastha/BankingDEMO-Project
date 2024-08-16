import java.sql.*;
import java.util.Scanner;

public class YoutubeJdbcDemo {

    private static final String url = "jdbc:mysql://localhost:3306/banking";
    private static final String userName = "root";
    private static final String password = "Ashish123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
//Retrieving from table
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            Statement statement = connection.createStatement();
//            String query = "select * from students";
//            ResultSet resultset = statement.executeQuery(query);
//            while (resultset.next()){
//                int id = resultset.getInt("id");
//                String name = resultset.getString("name");
//                int age = resultset.getInt("age");
//                double marks = resultset.getDouble("marks");
//                System.out.println("ID : "+id);
//                System.out.println("NAME : "+name);
//                System.out.println("AGE : "+age);
//                System.out.println("MARKS : "+marks);
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//// insert into table
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            Statement statement = connection.createStatement();
//            String query = String.format("INSERT INTO students (name, age, marks) VALUES ('%s', %o, %f)", "Shyam", 20, 50.5);
//            int rowsAffected = statement.executeUpdate(query);
//            if (rowsAffected>0){
//                System.out.println("Data Inserted");
//            }
//            else{
//                System.out.println("Data not Inserted");
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//        // update into table
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            Statement statement = connection.createStatement();
//            String query = String.format("UPDATE students SET marks = %f WHERE id = %d", 98.75, 2);
//            int rowsAffected = statement.executeUpdate(query);
//            if (rowsAffected>0){
//                System.out.println("Data Updated");
//            }
//            else{
//                System.out.println("Data not Updated");
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
        // delete from table
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            Statement statement = connection.createStatement();
//            String query = "DELETE FROM students WHERE id = 3";
//            int rowsAffected = statement.executeUpdate(query);
//            if (rowsAffected>0){
//                System.out.println("Deleted successfully");
//            }
//            else{
//                System.out.println("Not deleted");
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
        // retrieving data using prepared statement
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            String query = "SELECT * FROM students WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            preparedStatement.setInt(1,1);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()){
//                double marks = resultSet.getDouble("marks");
//                System.out.println("Marks : " +marks);
//            }
//            else{
//                System.out.println("Marks not Found");
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }

        // insert into table using prepared statement
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            String query = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            preparedStatement.setString(1,"Sita");
//            preparedStatement.setInt(2,26);
//            preparedStatement.setDouble(3,91.75);
//
//            preparedStatement.setString(1,"Radha");
//            preparedStatement.setInt(2,19);
//            preparedStatement.setDouble(3,100.0);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected>0){
//                System.out.println("Data Inserted Successfully");
//            }
//            else{
//                System.out.println("Data not Inserted");
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//        // update into table using prepared statement
//
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            String query = "UPDATE students SET marks = ? WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setDouble(1, 99.45);
//            preparedStatement.setInt(2,1);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected>0){
//                System.out.println("Data Updated");
//            }
//            else{
//                System.out.println("Data not Updated");
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }

        // Delete from table using prepared statement

//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            String query = "DELETE FROM students WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,5);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected>0){
//                System.out.println("Data Deleted");
//            }
//            else{
//                System.out.println("Data not Deleted");
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }

        //Batch processing
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            Scanner scanner = new Scanner(System.in);
//            Statement statement = connection.createStatement();
//            while (true) {
//                System.out.print("Enter name : ");
//                String name = scanner.next();
//                System.out.print("Enter age : ");
//                int age = scanner.nextInt();
//                System.out.print("Enter Marks  : ");
//                double marks = scanner.nextDouble();
//                System.out.print("Enter more data(Y/N) : ");
//                String choice = scanner.next();
//                String query = String.format("INSERT INTO students (name, age, marks) VALUES ('%s', %d, %f)", name, age, marks);
//                statement.addBatch(query);
//                if (choice.toUpperCase().equals("N")) {
//                    break;
//                }
//            }
//
//            int [] arr = statement.executeBatch();
//            for (int i=0; i<arr.length; i++){
//                if(arr[i]==0){
//                    System.out.println("Query " +i+ " not executed successfully");
//                }
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

        //Batch processing using prepared statement
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            String query = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            Scanner scanner = new Scanner(System.in);
//            while (true) {
//                System.out.print("Enter name : ");
//                String name = scanner.next();
//                System.out.print("Enter age : ");
//                int age = scanner.nextInt();
//                System.out.print("Enter Marks  : ");
//                double marks = scanner.nextDouble();
//                System.out.print("Enter more data(Y/N) : ");
//                String choice = scanner.next();
//                preparedStatement.setString(1, name);
//                preparedStatement.setInt(2, age);
//                preparedStatement.setDouble(3, marks);
//
//                preparedStatement.addBatch();
//                if (choice.toUpperCase().equals("N")) {
//                    break;
//                }
//            }
//
//            int [] arr = preparedStatement.executeBatch();
//            for (int i=0; i<arr.length; i++){
//                if(arr[i]==0){
//                    System.out.println("Query " +i+ " not executed successfully");
//                }
//            }
//
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

        // transaction handling from one account to other

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

            PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Please Enter the account number : ");
            int account_number = scanner.nextInt();

            System.out.print("Please Enter the amount : ");
            double amount = scanner.nextDouble();

            debitPreparedStatement.setDouble(1, amount);
            debitPreparedStatement.setInt(2, account_number);

            creditPreparedStatement.setDouble(1, amount);
            creditPreparedStatement.setInt(2, 21);

            debitPreparedStatement.executeUpdate();
            creditPreparedStatement.executeUpdate();


            if (isSufficient(connection, account_number, amount)){
                connection.commit();

                System.out.println("Transaction Successful");
                System.out.println("Thanks! Visit Again!");
            }
            else {
                connection.rollback();
                System.out.println("Insufficient Balance");
                System.out.println("Transaction Unsuccessful");
                System.out.println("Thanks! Visit Again!");
            }

        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

     static boolean isSufficient (Connection connection, int account_number, double amount){
        try {
            String query = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, account_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                double current_balance = resultSet.getDouble("balance");
                if (amount>current_balance)
                {
                    return  false;
                }
                else
                {
                    return  true;
                }
            }

        }
                catch (SQLException e){
                System.out.println (e.getMessage());
            }
         return false;
     }
    }



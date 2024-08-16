import java.sql.*;
import java.util.Scanner;

public class YouTubeJdbcDemo1 {

    private static final String url = "jdbc:mysql://localhost:3306/banking";
    private static final String userName = "root";
    private static final String password = "Ashish123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }

        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

            try {
                Connection connection = DriverManager.getConnection(url, userName, password);
                String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
                String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

                PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
                PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);

                Scanner scanner = new Scanner(System.in);

                System.out.print("Type 1 for Debit\n2 for credit\n3 for transfer money\n4 for Checking Balance : ");
                int choice = scanner.nextInt();

                if(choice==1) {
                    System.out.print("Please Enter the account number : ");
                    int account_number = scanner.nextInt();

                    System.out.print("Please Enter the amount : ");
                    double amount = scanner.nextDouble();

                    if (isSufficient(connection, account_number, amount)) {
                        debitPreparedStatement.setDouble(1, amount);
                        debitPreparedStatement.setInt(2, account_number);
                        debitPreparedStatement.executeUpdate();
                        System.out.println(+amount+ " debited from account number " +account_number+ " successfully");

                        String query = "SELECT balance FROM accounts WHERE account_number = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1, account_number);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            double current_balance = resultSet.getDouble("balance");
                            System.out.println("Your Current Balance is :" + current_balance);
                        }
                        System.out.println("Thanks! Visit Again!");
                    }

                    else {
                        System.out.println("Insufficient Balance");
                        System.out.println("Thanks! Visit Again!");
                    }

                }
                else if (choice == 2){

                        System.out.print("Please Enter the account number : ");
                        int account_number = scanner.nextInt();

                        System.out.print("Please Enter the amount : ");
                        double amount = scanner.nextDouble();

                        creditPreparedStatement.setDouble(1, amount);
                        creditPreparedStatement.setInt(2, account_number);

                        creditPreparedStatement.executeUpdate();

                        System.out.println(+amount+ " credited in account number "+account_number+ " successfully");

                    String query = "SELECT balance FROM accounts WHERE account_number = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, account_number);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        double current_balance = resultSet.getDouble("balance");
                        System.out.println("Your Current Balance is :" + current_balance);
                    }
                    System.out.println("Thanks! Visit Again!");
                }

                else if (choice == 3) {

                    System.out.print("Please Enter your account number : ");
                    int sender_account_number = scanner.nextInt();

                    System.out.print("Please Enter the account number of receiver : ");
                    int receiver_account_number = scanner.nextInt();

                    System.out.print("Please Enter the amount : ");
                    double amount = scanner.nextDouble();

                    if (isSufficient(connection, sender_account_number, amount)) {
                        debitPreparedStatement.setDouble(1, amount);
                        debitPreparedStatement.setInt(2, sender_account_number);

                        creditPreparedStatement.setDouble(1, amount);
                        creditPreparedStatement.setInt(2, receiver_account_number);

                        debitPreparedStatement.executeUpdate();
                        creditPreparedStatement.executeUpdate();

                        System.out.println(+amount+ " debited from account number " +sender_account_number+ " successfully and credited to receiver " +
                                "account number "+receiver_account_number+ " successfully");

                        String query = "SELECT balance FROM accounts WHERE account_number = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1, sender_account_number);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            double current_balance = resultSet.getDouble("balance");
                            System.out.println("Your Current Balance is :" + current_balance);
                        }
                        System.out.println("Thanks! Visit Again!");
                    }

                    else {
                        System.out.println("Insufficient Balance");
                    }

                } else if (choice == 4) {

                   try {
                       System.out.print("Please Enter the account number : ");
                       int account_number = scanner.nextInt();

                       String query = "SELECT balance FROM accounts WHERE account_number = ?";
                       PreparedStatement preparedStatement = connection.prepareStatement(query);
                       preparedStatement.setInt(1, account_number);
                       ResultSet resultSet = preparedStatement.executeQuery();
                       if (resultSet.next()) {
                           double current_balance = resultSet.getDouble("balance");
                           System.out.println("Your Current Balance is :" + current_balance);
                       }
                       else{
                           System.out.println("Data Not found\nTry Again\nThank You!");
                       }
                   }
                   catch (SQLException e){
                       System.out.println(e.getMessage());
                   }
                }
            }
            catch (SQLException e)

            {
                System.out.println(e.getMessage());
            }

        }

        static boolean isSufficient (Connection connection,int account_number, double amount){
            try {
                String query = "SELECT balance FROM accounts WHERE account_number = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, account_number);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    double current_balance = resultSet.getDouble("balance");
                    if (amount > current_balance) {
                        return false;
                    } else {
                        return true;
                    }
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }
    }


import java.sql.*;

/**
 * Created by aln on 31/07/14.
 */
public class MyJdbc {

    public String checkUserOrEmailexit(String userName, String email) {
        Connection koneksi = null;
        Statement stat = null;
        String str = "Accepted";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/shopkartdb", "shopkart", "welcome");
            System.out.println(koneksi);
            stat = koneksi.createStatement();
            ResultSet hasil = stat.executeQuery("SELECT userName, emailID  FROM loginInfo WHERE userName='"+userName+"' OR emailID='"+email+"';" );
            if(hasil.next())
                str ="Rejected";
            stat.close();
            koneksi.close();
        } catch (SQLException sqle) {
            str = "SQLException error";
        } catch (ClassNotFoundException cnfe) {
            str = "ClassNotFoundException error";
        } catch (InstantiationException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return str;
    }
    public void addToDataBase(String userName, String email)
    {
        Connection koneksi = null;
        PreparedStatement pstmt = null;
        String str = "";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/shopkartdb","shopkart","welcome");
            System.out.println("I am Here " +koneksi);

            String sql = "INSERT INTO loginInfo("
                    + "userName,"
                    + "emailID) "
                    +  "VALUES(?,?)";

            pstmt = koneksi.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Hello");


            koneksi.close();
        } catch (SQLException sqle) {
            str = "SQLException error";
        } catch (ClassNotFoundException cnfe) {
            str = "ClassNotFoundException error";
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void addPasswordToDataBase(String password, int iD)
    {
        Connection koneksi = null;
        PreparedStatement pstmt = null;
        String str = "";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/shopkartdb","shopkart","welcome");
            System.out.println("I am Here " +koneksi);

            String sql = "INSERT INTO loginPass("
                    + "iD,"
                    + "passWord) "
                    +  "VALUES(?,?)";

            pstmt = koneksi.prepareStatement(sql);
            pstmt.setInt(1, iD);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("Hello");


            koneksi.close();
        } catch (SQLException sqle) {
            str = "SQLException error";
        } catch (ClassNotFoundException cnfe) {
            str = "ClassNotFoundException error";
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public int getPrimaryID(String userName)
    {

        Connection koneksi = null;
        Statement stat = null;
        String str ="";
        int iD = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/shopkartdb","shopkart","welcome");
            System.out.println(koneksi);
            stat = koneksi.createStatement();
            ResultSet hasil = stat.executeQuery("SELECT iD FROM loginInfo where userName='" +userName+"'");
            if(hasil.next())
                    iD = hasil.getInt(1);

            stat.close();
            koneksi.close();
        } catch (SQLException sqle) {
            str = "SQLException error";
        } catch (ClassNotFoundException cnfe) {
            str = "ClassNotFoundException error";
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        return iD;

    }

    public String addUserToDataBase(String userName, String email, String password)
    {

        String str ="NotAdded";
        if(checkUserOrEmailexit(userName, email).equals("Accepted") ) {
            str = "Added";
            addToDataBase(userName, email);
            addPasswordToDataBase( password, getPrimaryID(userName));
        }
        return str;
    }
    public String selectionQuery() {
        Connection koneksi = null;
        Statement stat = null;
        String str = "";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/shopkartdb","shopkart","welcome");
            System.out.println(koneksi);
            stat = koneksi.createStatement();
            ResultSet hasil = stat.executeQuery("SELECT * FROM loginInfo");
            while (hasil.next()) {
                str = str + (hasil.getString(1)) + hasil.getString(2);
            }
            stat.close();
            koneksi.close();
        } catch (SQLException sqle) {
            str = "SQLException error";
        } catch (ClassNotFoundException cnfe) {
            str = "ClassNotFoundException error";
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return str;

    }


}


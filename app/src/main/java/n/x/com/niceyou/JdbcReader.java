package n.x.com.niceyou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcReader {

    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://qdm114539642.my3w.com:3306/qdm114539642_db";
    public String username = "qdm114539642";
    public String password = "rootABC123";
    public Connection conn = null;
    public PreparedStatement pstmt=null;



    public void  init() {
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(List<String> image_list) {
        String sql = "select * from image_add";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
           // System.out.println("============================");
            while (rs.next()) {
                image_list.add(rs.getString(1));
                    }
          //  System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]){
        //List<String> mDatas= new ArrayList<String>();
        JdbcReader jb = new JdbcReader();
       // jb.init();
       // jb.select(mDatas);
        //System.out.println(mDatas);
    }

}


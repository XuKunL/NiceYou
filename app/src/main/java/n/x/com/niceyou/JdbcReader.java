package n.x.com.niceyou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcReader{

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://qdm114539642.my3w.com:3306/qdm114539642_db";
    private static String username = "qdm114539642";
    private static String password = "rootABC123";
    private static Connection conn = null;
    private static PreparedStatement pstmt=null;
    private static List<String> mDatas= new ArrayList<String>();
public JdbcReader(List<String> li){
    this.mDatas=li;
    }

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

    public  List<String> select(List<String> image_list) {
        String sql = "select * from image_add";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
           // System.out.println("============================");
            while (rs.next()) {
                if(!image_list.contains(rs.getString(1)))
                image_list.add(rs.getString(1));
                    }
          //  System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image_list;
    }

    Runnable rn=  new Runnable(){
        public void run(){
            init();
            select(mDatas);
        }
    };
    public void dw(){
        new Thread(rn).start();
    }

}


package n.x.com.niceyou;


import android.os.Environment;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class TextRead {
    List<String> textList;
    public static String readTxtFile(String name){
        String content = "" ;
        // name = "/test_0913.txt";
        String name_sd = "/test_0913_sd.txt";
        try {
            String encoding="UTF-8";
            InputStream in = new FileInputStream(name);
            //判断文件是否存在
            String a= Environment.getRootDirectory().getPath()+name;
            System.out.println("a====================="+a);
            InputStreamReader read = new InputStreamReader(
                    in,encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;

            while((lineTxt = bufferedReader.readLine()) != null){
                content += lineTxt + "\n" ;
            }
            read.close();
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return content;
    }
}

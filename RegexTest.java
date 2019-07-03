import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class RegexTest{
    private static String xml = "sample.xml";
    private static List<String> list = new ArrayList<String>();
    public static void main(String args[]){
        if(args.length!=1){
            System.out.println("Error: java RegexTest .txt");
            System.exit(1);
        }
        List<String> list = new ArrayList<String>();


        readLine(args[0]);
        String ansName=checkLine();
        writeLine(args[0]);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        if(ansName==""){
            System.out.println("End Test\n");
            System.exit(0);
        }

    }

    public static void readLine(String fileName){
        try{
            /* ファイルの定義 */
            File txtFile = new File(fileName);
            //File xmlFile = new File(xml);

            BufferedReader reader = new BufferedReader(new FileReader(txtFile));

            String line = reader.readLine();
            while(line!=null){
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e) {
            System.out.println(e);
        }
    
    }

    public static String checkLine(){
        boolean checkFlag=false;
        String temp="";
        String selectName="";
        for(int i=0;i<list.size();i++){
            temp=list.get(i);
            if(checkFlag==false){
                if(temp.indexOf("*")==-1){
                    list.set(i,"*"+temp);
                    selectName=temp;
                    checkFlag=true;
                }
            }
        }
        return selectName;
    }

    public static void writeLine(String fileName){
        try{
            File txtfile = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(txtfile));

            for(int i=0;i<list.size();i++){
                writer.write(list.get(i)+"\n");
            }
            writer.close();
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}

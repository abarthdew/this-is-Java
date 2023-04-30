import java.io.FileReader;
import java.io.Reader;

public class ReaderExam3 {
    public static void main(String[] args) throws Exception {
        
        Reader reader = new FileReader("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.reader\\test.txt");
        int readCharNo;
        char[] cbuf = new char[4];
        readCharNo = reader.read(cbuf, 1, 2);
        for (int i=0; i<cbuf.length; i++) {
            System.out.println(cbuf[i]);
            /*
                        
            s
            t

             */
        }
        reader.close();

    }
}

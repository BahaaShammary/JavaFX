
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayListOfStringObjects {

    public static void main(String[] args) {

        // create ArrayList and inserts values
        ArrayList<String> leadersOfHistory = new ArrayList<String>();

        // add values to ArrayList
        leadersOfHistory.add("Me");
        leadersOfHistory.add("You");
        leadersOfHistory.add("Us");
        leadersOfHistory.add("Him");
        leadersOfHistory.add("Her");
        leadersOfHistory.add("Them");


        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            // for writing or saving binary data
            fos = new FileOutputStream("SaveArrayList.ser");

            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);

            // writing or saving ArrayList values to stream
            oos.writeObject(leadersOfHistory);
            oos.flush();
            oos.close();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }

        System.out.println("ArrayList object saved"
                + " to SaveArrayList.ser file");
    }
}
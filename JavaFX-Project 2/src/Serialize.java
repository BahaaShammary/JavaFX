import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialize {

    public Serialize() {

    }

    public void serializeArrayList(ArrayList<Product> productsList) {
        // create ArrayList and inserts values
        List<Product> products = new ArrayList<Product>();

        // add values to ArrayList
        products.addAll(productsList);

        for (int i = 0; i<products.size();i++) {
            System.out.println(products.get(i).getName());

        }

        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            // for writing or saving binary data
            fos = new FileOutputStream("products.ser");

            // converting java-object to binary-format
            oos = new ObjectOutputStream(fos);

            // writing or saving ArrayList values to stream
//            for (int i = 0; i<products.size();i++) {
//                oos.writeObject(products.get(i));
//            }
            oos.writeObject(products);

            oos.flush();
            oos.close();
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

        System.out.println("ArrayList object saved"
                + " to products.txt file");
    }

    public ArrayList<Product> deSerializeArrayList() {

        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        // creating List reference to hold AL values
        // after de-serialization
        ArrayList<Product> leadersOfHistory = null;

        try {
            // reading binary data
            fis = new FileInputStream("products.ser");

            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);

            // reading object's value and casting ArrayList<String>
            leadersOfHistory = (ArrayList<Product>) ois.readObject();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }

        System.out.println("ArrayList object de-serialized"
                + " from SaveArrayList.ser file\n");

        // iterating & printing ArrayList values to console
//        for(Product p : leadersOfHistory){
//            System.out.println(p.getName() + " " + p.getModel());
//        }

        return leadersOfHistory;
    }

}
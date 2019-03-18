import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialize {

    public Serialize() {

    }

    public void serializeArrayList(ArrayList<Car> carsList) {
        // create ArrayList and inserts values
        List<Car> cars = new ArrayList<>();

        // add values to ArrayList
        cars.addAll(carsList);

        for (int i = 0; i<cars.size();i++) {
            System.out.println(cars.get(i).getName());

        }

        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            // for writing or saving binary data
            fos = new FileOutputStream("cars.txt");

            // converting java-object to binary-format
            oos = new ObjectOutputStream(fos);

            oos.writeObject(cars);

            oos.flush();
            oos.close();
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

        System.out.println("ArrayList object saved"
                + " to cars.txt file");
    }

    public ArrayList<Car> deSerializeArrayList() {

        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        // creating List reference to hold AL values
        // after de-serialization
        ArrayList<Car> cars = null;

        try {
            // reading binary data
            fis = new FileInputStream("cars.txt");

            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);

            // reading object's value and casting ArrayList<String>
            cars = (ArrayList<Car>) ois.readObject();
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
                + " from cars.txt file\n");

        return cars;
    }

}
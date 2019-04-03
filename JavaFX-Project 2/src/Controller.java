import java.util.ArrayList;

public class Controller {
    Serialize s;
    ArrayList<Product> productsList;

public Controller() {
    //Product car = new Product();
//    ArrayList<Product> productArrayList = new ArrayList<>();
//    productArrayList.add(new Product("Nissan", "Almera", 2000));
//    productArrayList.add(new Product("BMW", "8 Series", 4000));
//    productArrayList.add(new Product("Nissan", "Qashqai", 8000));
//    productArrayList.add(new Product("Nissan", "Sunny", 3500));
      s = new Serialize();

    System.out.println("\n*****************\n");
}
public ArrayList<Product> readList() {
    productsList = s.deSerializeArrayList();
    for (int i = 0; i<productsList.size(); i++) {
        System.out.println(productsList.get(i).getName());

    }
    return productsList;
}
public void addtoList(Product p) {
    productsList.add(p);
}

public void writeListToFile() {
    s.serializeArrayList(productsList);
}

public void removeFromList(Product p) {
    Product removeP;
    for (int i = 0; i<productsList.size(); i++) {
        //System.out.println(productsList.get(i).getName());
        removeP = productsList.get(i);
        if (removeP.getName() == p.getName()) {
            productsList.remove(removeP);
        }

    }

}
}

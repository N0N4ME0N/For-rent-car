package For_rent_the_car;

import java.io.*;

public class FileHandler {
    
    public static void saveData(String fileName, Object data) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(data);
            System.out.println("Save success " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail for save: " + e.getMessage());
        }
    }
    
    public static Object loadData(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fail for load: " + e.getMessage());
        }
        return null;
    }
}

package grocerylist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GroceryList {


    public static String[] getItemsArray(int numItems) throws Exception {
        if (numItems < 0)
            throw new Exception();

        String []items = new String[numItems];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<5; i++){
            System.out.print("Enter item to be added: ");
            items[i] = scanner.next();
        }
        return items;
    }

    public static void writeItems(String[]items, String filename){
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(filename);
            for (String item : items) {
                myWriter.append(item + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readItems(String filename) {
        ArrayList<String> items = new ArrayList<>();
        File myObj = new File(filename);
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                items.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void printList(ArrayList<String> items){
        for(String item:items){
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        try
        {
            String [] items = getItemsArray(5);
            writeItems(items, "items.txt");
            ArrayList<String> itemList = readItems("items.txt");
            printList(itemList);
        }
        catch(Exception e)
        {
            String errorMsg = e.getMessage();
            System.out.println(errorMsg);
        }
    }
}

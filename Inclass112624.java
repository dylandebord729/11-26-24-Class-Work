/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dgdebordpstcc.inclass112624;

/**
 *
 * @author dgdeb_b82hwq2
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Inclass112624 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Part 1 (Lines 20 - 31)
        System.out.print("Enter Your Items: ");
            String sList = input.nextLine();
        String filename = "Shopping List.txt";
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename,true)));
            out.println(sList);
            out.close();
            System.out.print("Ran Successfully.");
            System.out.print("File read successfully");
        } catch(IOException e){
                System.out.println("File not found. Sorry.");
        }
        
        
        
        //Part 2 (Lines 36-46)
        try{
            BufferedReader in = new BufferedReader(new FileReader (filename));
                String line = in.readLine();
                while (line != null){
                    System.out.println(line);
                        line =in.readLine();
                }in.close();
                System.out.print("File read successfully");
        } catch(IOException err){
                System.out.println("An error occurred while reading from the file: "+err.getMessage());
        }
        
        //Part 3(Lines 49-)
           //Uses existing Shopping List we made.
           ArrayList<String>shoppingList = new ArrayList<>();
           try{
           BufferedReader reader = new BufferedReader(new FileReader(filename));
           String line;
           while((line = reader.readLine()) != null){
               shoppingList.add(line);
                }
           reader.close();
           } catch (FileNotFoundException e){
               System.out.println("Shopping List not found. Sorry.");
           } catch(IOException e){
               System.out.println("An error occurred while reading from the file: "+e.getMessage());
           }
           while(true){
               System.out.println("\nShopping List Manager");
               System.out.println("1. View Shopping List");
               System.out.println("2. Add Item");
               System.out.println("3. Delete Item");
               System.out.println("4. Save and Exit");
               System.out.println("Enter your choice");
                    int choice = Integer.parseInt(input.nextLine());
               switch (choice){
                   case 1: //Viewing the shopping list
                       System.out.println("\nYour Shopping List");
                       if (shoppingList.isEmpty()){
                           System.out.println("The Shopping List is empty");
                       } else {
                           for(int i = 0; i < shoppingList.size(); i++){
                            System.out.println((i+1) + "."+ shoppingList.get(i));
                           }
                       }
                    break;
                    
                   case 2: //Add Item
                       System.out.print("Enter your item to add: ");
                       String newItem = input.nextLine();
                       System.out.print(newItem + " has been added to your shopping list.");
                    break;
                    
                    
                   case 3: //Delete an item
                      System.out.println("\nYour Shopping List");
                      for(int i = 0; i < shoppingList.size(); i++){
                          System.out.println((i+1) + "."+ shoppingList.get(i));
                        }
                      System.out.print("Enter the number of the item to delete: ");
                      int itemNumber;
                      try{
                      itemNumber = Integer.parseInt(input.nextLine());
                      if (itemNumber > 0 && itemNumber <= shoppingList.size()){
                         String removedItem = shoppingList.remove(itemNumber - 1);
                         System.out.println(removedItem + " has beenremoved from the shopping list.");
                        } else {
                          System.out.print("Invalid item number.");
                        }
                      }catch(NumberFormatException e){
                          System.out.print("Invalid input. Please enter a number.");
                      }
                    break;
                    
                    case 4:
                        // Save and exit
                        System.out.print("Enter the name of the new file to save the list: ");
                        String newFilename = input.nextLine();
                        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newFilename)))) {
                            for (String item : shoppingList) {
                                out.println(item);
                            }
                            System.out.println("Shopping list saved successfully to " + newFilename);
                        } catch (IOException e) {
                            System.out.println("Error saving the file: " + e.getMessage());
                        }
                    break;
                    
                    default:
                        System.out.println("Invalid option. Please try again.");   
               }
                input.close();
           }  
    }
}

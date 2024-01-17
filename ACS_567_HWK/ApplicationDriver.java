package ACS_567_HWK;
import java.io.IOException;
import java.util.*;

public class ApplicationDriver {
   public static HashMap <Integer,String> options = new HashMap<>();
    public static DataManager dataManager;
    public static void main(String[] args)  throws IOException{
        dataManager = DataManager.getInstance();

        System.out.println("This app lest you track calories in a day");
        System.out.println("Enter Todays Calories : ");
          Scanner sc = new Scanner(System.in);
        
        while(true){
            int k = DisplayOptions();
            int q =0;
            switch (k) {
                case 0:
                    System.out.println("Thank you bye!");
                    q=1;
                    break;

                 case 2:
                 
                    System.out.println("Please enter calories : ");
                    String content = sc.nextLine();
                    dataManager.writeData(content);
                    break;

                 case 1:
                    dataManager.readAllData(1);
                    break;
                case 3:
                  dataManager.readAllData(1);
                  System.out.println("Please enter position you want to edit: ");
                  int linq= Integer.parseInt(sc.nextLine());
                  System.out.println("Please enter content: ");
                    String content2 = sc.nextLine();
                    dataManager.editData(content2, linq);
                    break;

                case 4:
                  dataManager.readAllData(1);
                  System.out.println("Please enter position you want to delete: ");
                  int delData= Integer.parseInt(sc.nextLine());                 
                    dataManager.deleteData(delData);;
                    break;

                
                case 5:
                  
                  System.out.println("Please enter 1 fro asending and 2 for desencding: ");
                  int order= Integer.parseInt(sc.nextLine());
                  String desc = "ascending";  
                  if(order != 1){
                        desc = "descending";
                    }
                     dataManager.readInOrder(desc);
    
                    break;

                        
                case 6:
                  
                  dataManager.mean();
    
                    break;

                
                case 7:
                  
                  dataManager.medain();
    
                    break;

                
            
                case -1:
                    System.out.println("Please enter a valid option");
                    break;
            
            }
            if(q==1){
                break;
            }
        }
        
    }
    public static int DisplayOptions() {
        System.out.println("Select an option");
        options.put(1, "Read Data");
        options.put(2, "Add Data");
        options.put(3, "Edits data");
        options.put(4, "Delete Data");

        options.put(5, "Filter data in ascending order or descending order");

        options.put(6, "Mean Calories");
        options.put(7, "Median Calories");

        options.put(0, "Quite");

        for(Integer i : options.keySet()){
            System.out.println(i+" to "+options.get(i));
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        if(options.containsKey(k)){
            return k;
        }
        return -1;

        
    }
}

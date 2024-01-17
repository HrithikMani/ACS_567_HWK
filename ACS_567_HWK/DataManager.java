package ACS_567_HWK;

import java.io.IOException;

public class DataManager {
    public static DataEncapsulation dataEncapsulation=null;
    public static DataManager dataManager=null;
    DataManager(){
       dataEncapsulation = new DataEncapsulation();
    }
    public static DataManager getInstance(){
        if(dataManager == null){
            dataManager = new DataManager();
        }
       
        return dataManager;
    }

    public static void writeData(String content) throws IOException{
     dataEncapsulation.writeAndReadFile(content+"\n");
    }

    public static void editData(String content,int line) throws IOException{
     dataEncapsulation.insertLineToFile(line, content);
    }


    public static void deleteData(int line) throws IOException{
     dataEncapsulation.deleteLineFromFile(line);
    }

    
    public static void readAllData(int line) throws IOException{
     dataEncapsulation.readAllData();
    }

    public static void readInOrder(String s) throws IOException{
     dataEncapsulation.readAllDataInIOrder(s);;
    }


    public static void mean() throws IOException{
        dataEncapsulation.calculateMean();
    }
    
    public static void medain() throws IOException{
        dataEncapsulation.calculateMedian();
    }

}

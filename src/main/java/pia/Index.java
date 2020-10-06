package pia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Index {
    //Atributes
    public ArrayList files;
    
    //Constructor
    public Index(String path) {
        File file = new File(path);
        files = new ArrayList();
        
        if(file.isDirectory()) {
            File[] temp = file.listFiles((File dir1, String filename) -> filename.toLowerCase().endsWith(".json"));
            
            files.addAll(Arrays.asList(temp));
        }
        else
            this.files.add(file);
    }
    
    //Methods
    public void generateIndex(int messagesPerPage, File targetFolder) {
        JSONObject index = new JSONObject();
        JSONArray pages = new JSONArray();
        int remainingMessages = 0;
        
        index.put("messagesPerPage", messagesPerPage);
        
        Iterator iter = this.files.iterator();
        
        while(iter.hasNext()) {
            File file = (File) iter.next();
            
            try {
                JSONParser jP = new JSONParser();
                JSONObject json = (JSONObject) jP.parse(new FileReader(file.getAbsolutePath()));
                JSONArray messages = (JSONArray) json.get("messages");
                int totalMessages = messages.size();
                int currentMessage = remainingMessages;
                
                System.out.println(file.getName() +"-"+ totalMessages);
                
                while(currentMessage < totalMessages) {
                    JSONObject page = new JSONObject();
                    
                    page.put("file", file.getName());
                    page.put("message", currentMessage);
                    pages.add(page);
                    
                    currentMessage += messagesPerPage;
                }
                
                remainingMessages = currentMessage - totalMessages;
            }
            catch(FileNotFoundException e) {
                System.out.println("FileNotFoundException");
            }
            catch(IOException e) {
                System.out.println("IOException");
            }
            catch(ParseException e) {
                System.out.println("ParseException");
            }
            catch(Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        
        index.put("pages", pages);
        
        File file = new File("Files/Converted Files/" +targetFolder.getName()+ "/index.json");
        
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            pw.write( index.toJSONString() );
        }
        catch(IOException e) {
            System.out.println(e);
        }
        finally {
            if(pw != null)
                pw.close();
        }
        
        //System.out.println(index);
        
    }
}
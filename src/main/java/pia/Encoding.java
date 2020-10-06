package pia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//Este comentario antes no estaba
public class Encoding {
    public static void fixDirectory(String path, File targetFolder) {
        File originalFolder = new File(path);  //Folder with the original files
        File newFolder; //Folder where the files will be saved
        
        if(targetFolder != null)
            newFolder = new File("Files/Converted Files/" + targetFolder.getName() + "/Converted Files");
        else
            newFolder = Utilities.generateFolder(path);
        
        newFolder.mkdir();
        
        //Files from the original folder
        File[] files = originalFolder.listFiles((File dir1, String filename) -> filename.toLowerCase().endsWith(".json"));
        
        for(File file : files) {
            //tag.setText(file.getName());
            fixEncoding(file.getAbsolutePath(), targetFolder, newFolder.getName());
        }
    }

    public static void fixEncoding(String originalFilePath, File targetFolder, String folderName) {
        File originalFile = new File(originalFilePath);  //Se crea un archivo con la ruta seleccionada
        String fileName = originalFile.getName();
        String noExtensionFileName = fileName.substring(0, fileName.indexOf("."));
        String targetFolderName = "";
        
        if(targetFolder != null)
            targetFolderName = targetFolder.getName() + "/";
        
        if(!folderName.isEmpty())
            folderName += "/";
        
        //Converted File Name
        File newFile = new File("Files/Converted Files/" + targetFolderName + folderName + fileName);
        if(newFile.exists()) {
            int i = 1;
            while(true) {
                newFile = new File("Files/Converted Files/" + folderName + noExtensionFileName + i + ".json");
                if(newFile.exists())
                    i++;
                else
                    break;
            }
        }
        
        //Fix Uri
        try {
            JSONParser jP = new JSONParser();
            JSONObject json = (JSONObject) jP.parse(new FileReader(originalFilePath));
            JSONArray messages = (JSONArray) json.get("messages");
            Iterator messageIter = messages.iterator();
            
            while(messageIter.hasNext()) {
                JSONObject nextMessage = (JSONObject) messageIter.next();
                JSONArray mediaArray = null;

                if(nextMessage.get("sticker") != null)
                    changeUri((JSONObject) nextMessage.get("sticker"));
                else if(nextMessage.get("photos") != null)
                    mediaArray = (JSONArray) nextMessage.get("photos");
                else if(nextMessage.get("audio_files") != null)
                    mediaArray = (JSONArray) nextMessage.get("audio_files");
                else if(nextMessage.get("videos") != null)
                    mediaArray = (JSONArray) nextMessage.get("videos");
                else if(nextMessage.get("files") != null)
                    mediaArray = (JSONArray) nextMessage.get("files");
                else if(nextMessage.get("gifs") != null)
                    mediaArray = (JSONArray) nextMessage.get("gifs");

                if(mediaArray != null) {
                    Iterator mediaIter = mediaArray.iterator();

                    while(mediaIter.hasNext()) {
                        JSONObject temp = (JSONObject) mediaIter.next();
                        //changeUri( (JSONObject) mediaIter.next() );
                        //System.out.println(temp.get("uri"));
                        changeUri((JSONObject) temp);
                    }
                }
            }
            //Write new JSON File
            PrintWriter pw = null;
            try {
                pw = new PrintWriter( newFile );
                pw.write( json.toJSONString() );
            }
            catch(IOException e) {
                System.out.println(e);
            }
            finally {
                if(pw != null)
                    pw.close();
            }
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
    
    public static void changeUri(JSONObject file) {
        String[] temp = String.valueOf( file.get("uri") ).split("/");
        String newUri = "Media/";
        
        if(!String.valueOf( file.get("uri") ).contains("stickers_used"))
            newUri += temp[3] + "/" + temp[4];
        else
            newUri += temp[1] + "/" + temp[2];
        
        file.put("uri", newUri);
    }
}
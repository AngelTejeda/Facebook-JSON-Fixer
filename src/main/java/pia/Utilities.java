package pia;

import java.io.File;

public class Utilities {
    public static File generateFolder(String path) {
        String folderName = new File(path).getName();    //Name of the original folder or file
        
        if(folderName.toLowerCase().endsWith( ".json" ))
            folderName = folderName.substring(0, folderName.indexOf("."));
        
        File newFolder = new File("Files/Converted Files/" + folderName);   //Folder where the files will be saved
        if(newFolder.exists()) {
            int i = 1;
            while(true) {
                newFolder = new File("Files/Converted Files/" + folderName + i);
                if(newFolder.exists())
                    i++;
                else
                    break;
            }
        }

        newFolder.mkdir();
        
        return newFolder;
    }
}
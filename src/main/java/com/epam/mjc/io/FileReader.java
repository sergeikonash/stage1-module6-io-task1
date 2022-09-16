package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        String[] subStr = new String[4];
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            int ch;
            StringBuilder builder = new StringBuilder();
            while((ch = fileInputStream.read()) != -1) {
                builder.append((char)ch);
            }
            String fromFile = builder.toString();
            String delimeter = "\n";
            subStr = fromFile.split(delimeter);
            String deleteName = "Name: ";
            String deleteAge = "Age: ";
            String deleteEmail = "Email: ";
            String deletePhone = "Phone: ";
            for (int i = 0; i < subStr.length; i++) {
                subStr[i] = subStr[i].replace(deleteName, "");
                subStr[i] = subStr[i].replace(deleteAge, "");
                subStr[i] = subStr[i].replace(deleteEmail, "");
                subStr[i] = subStr[i].replace(deletePhone, "");
            }
        } catch (IOException e) {
            e.getMessage();
        }
        profile.setName(subStr[0]);
        try {
            profile.setAge(Integer.parseInt(subStr[1].trim()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        profile.setEmail(subStr[2]);
        try {
            profile.setPhone(Long.parseLong(subStr[3].trim()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return profile;
    }
}

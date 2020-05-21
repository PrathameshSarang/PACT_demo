package com.afourtech.utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataUtility {

    public JsonElement getJsonRequestBody(String filename)  {
        JsonElement jsonElement = null;
        try {
            jsonElement = new JsonParser().parse(new FileReader(System.getProperty("user.dir") + "/testdata/requestbody/" + filename));
        } catch (FileNotFoundException e) {
            System.out.println("");
        }
        return jsonElement;
    }
}

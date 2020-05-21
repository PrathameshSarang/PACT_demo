package com.afourtech.dao.data;

import com.afourtech.model.CategoryData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.*;

public class CategoryDataDAO {


    // Level 0 Category Map
    public static Map<String, CategoryData> categoryDataMapLevelZero=new HashMap<>();
    //5 Vehicles Level 1 Category Map
    public static Map<String, CategoryData> categoryDataMapLevelOne_5=new HashMap<>();
    //5.9 Auto Parts & Accessories Level 2 Category Map
    public static Map<String, CategoryData> categoryDataMapLevelTwo_5_9=new HashMap<>();
    public static Map<String, CategoryData> categoryDataMapLevelTwo_5_10=new HashMap<>();

    public static Map<String, CategoryData> categoryDataMapLevelOne_6=new HashMap<>();
    //5.9 Auto Parts & Accessories Level 2 Category Map
    public static Map<String, CategoryData> categoryDataMapLevelTwo_6_8=new HashMap<>();
    public static Map<String, CategoryData> categoryDataMapLevelTwo_6_1=new HashMap<>();

    static{
        //=================================================================
        //Insertion of Values in 5.9 Auto Parts & Accessories Level 2 Category Map
        categoryDataMapLevelTwo_5_9.put("5.9.16",
                new CategoryData(
                        "5.9.16",
                        Integer.valueOf(3),
                        "Glass",
                        Arrays.asList(new String[]{"5","5.9"}),
                        true,
                        CategoryAttributeDataDAO.glassCategoryAttributeValues));
        categoryDataMapLevelTwo_5_9.put("5.9.15",
                new CategoryData(
                        "5.9.15",
                        Integer.valueOf(3),
                        "Gauges",
                        Arrays.asList(new String[]{"5","5.9"}),
                        true,
                        CategoryAttributeDataDAO.gaugesCategoryAttributeValues));

        //Insertion of Values in 5 Vehicles Level 1 Category Map
        categoryDataMapLevelOne_5.put("5.9",
                new CategoryData(
                        "5.9",
                        Integer.valueOf(2),
                        "Auto Parts & Accessories",
                        Arrays.asList(new String[]{"5"}),
                        true,
                        categoryDataMapLevelTwo_5_9));

        categoryDataMapLevelTwo_5_10=null;
        categoryDataMapLevelOne_5.put("5.10",
                new CategoryData(
                        "5.10",
                        Integer.valueOf(2),
                        "Other - Vehicles",
                        Arrays.asList(new String[]{"5"}),
                        true,
                        categoryDataMapLevelTwo_5_10));


        ;

        //Insertion of Values in Level 0 Category Map
        categoryDataMapLevelZero.put("5",
                new CategoryData(
                        "5",
                        Integer.valueOf(1),
                        "Vehicles",
                        true,
                        categoryDataMapLevelOne_5
                ));

        //===============================================================
        categoryDataMapLevelTwo_6_8=null;
        categoryDataMapLevelOne_6.put("6.8",
                new CategoryData(
                        "6.8",
                        Integer.valueOf(2),
                        "Other - Toys, Games, & Hobbies",
                        Arrays.asList(new String[]{"6"}),
                        true,
                        categoryDataMapLevelTwo_6_8));


        categoryDataMapLevelTwo_6_1.put("6.1.3",
                new CategoryData(
                        "6.1.3",
                        Integer.valueOf(3),
                        "Building Toys",
                        Arrays.asList(new String[]{"6","6.1"}),
                        true,
                        CategoryAttributeDataDAO.buildingToysCategoryAttributeValues));
        categoryDataMapLevelTwo_6_1.put("6.1.4",
                new CategoryData(
                        "6.1.4",
                        Integer.valueOf(3),
                        "Remote Control Toys & Vehicles",
                        Arrays.asList(new String[]{"6","6.1"}),
                        true,
                        CategoryAttributeDataDAO.rcToysCategoryAttributeValues));


        categoryDataMapLevelOne_6.put("6.1",
                new CategoryData(
                        "6.1",
                        Integer.valueOf(2),
                        "Toys",
                        Arrays.asList(new String[]{"6"}),
                        true,
                        categoryDataMapLevelTwo_6_1));


        categoryDataMapLevelZero.put("6",
                new CategoryData(
                        "6",
                        Integer.valueOf(1),
                        "Toys, Games, & Hobbies",
                        true,
                        categoryDataMapLevelOne_6
                ));
        /*data=new CategoryData(
                true,
                categoryDataMapLevelZero
        );*/

    }

    public CategoryData getAllCategories(){
        return new CategoryData(
                true,
                categoryDataMapLevelZero
        );
    }

    public CategoryData getSpecificCategory(String catagoryId){
        return categoryDataMapLevelZero.get(catagoryId);

    }


    public static void main(String[] args) throws JsonProcessingException {

        //ObjectMapper objectMapper=new ObjectMapper();
        //System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
    }
}

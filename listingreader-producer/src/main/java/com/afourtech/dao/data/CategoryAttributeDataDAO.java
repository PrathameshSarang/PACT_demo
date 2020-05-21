package com.afourtech.dao.data;

import com.afourtech.model.CategoryAttributeData;
import com.afourtech.model.RequirementLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryAttributeDataDAO {

    public static ArrayList<CategoryAttributeData> categoryAttributeValues=new ArrayList<CategoryAttributeData>();
    public static ArrayList<CategoryAttributeData> glassCategoryAttributeValues=new ArrayList<CategoryAttributeData>();
    public static ArrayList<CategoryAttributeData> gaugesCategoryAttributeValues=new ArrayList<CategoryAttributeData>();
    public static ArrayList<CategoryAttributeData> buildingToysCategoryAttributeValues=new ArrayList<CategoryAttributeData>();
    public static ArrayList<CategoryAttributeData> rcToysCategoryAttributeValues=new ArrayList<CategoryAttributeData>();


    static {
        //Attribute Brand
        categoryAttributeValues.add(new CategoryAttributeData(
                "brand",
                "Brand",
                0,
                "The name of the manufacturer.",
                RequirementLevel.Required,
                RequirementLevel.Recommended,
                Arrays.asList(new String[]{"Unknown", "Unbranded ", "ADA Sign Factory", "Chewbarka"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));

        //Attribute Color
        categoryAttributeValues.add(new CategoryAttributeData(
                "color",
                "Color",
                0,
                "The primary exterior color of the item.",
                RequirementLevel.Recommended,
                RequirementLevel.Recommended,
                Arrays.asList(new String[]{"Black", "Blue ", "Brown", "Gold", "Green"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));
        categoryAttributeValues.add(new CategoryAttributeData(
                "features",
                "Features",
                0,
                "The features of the item.",
                RequirementLevel.Optional,
                RequirementLevel.Optional,
                Arrays.asList(new String[]{"Adjustable Height", "Double-sided ", "Frosted", "Includes Hardware", "Lockable"}), //Brand Names
                0,
                5,
                true,
                "SimpleList"));

        glassCategoryAttributeValues.add(new CategoryAttributeData(
                "brand",
                "Brand",
                0,
                "The name of the manufacturer.",
                RequirementLevel.Required,
                RequirementLevel.Recommended,
                Arrays.asList(new String[]{"1-800 Radiator", "1A Auto ", "1 Factory Radio", "2Crave"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));

        //Attribute Color
        glassCategoryAttributeValues.add(new CategoryAttributeData(
                "placementOnVehicle",
                "Placement On Vehicle",
                0,
                "The primary exterior color of the item.",
                RequirementLevel.Optional,
                RequirementLevel.Optional,
                Arrays.asList(new String[]{"Front", "Left ", "Lower", "Rear"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));

        gaugesCategoryAttributeValues.add(new CategoryAttributeData(
                "brand",
                "Brand",
                0,
                "The name of the manufacturer.",
                RequirementLevel.Required,
                RequirementLevel.Recommended,
                Arrays.asList(new String[]{"1-800 Radiator", "1A Auto ", "1 Factory Radio", "2Crave"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));
        gaugesCategoryAttributeValues.add(new CategoryAttributeData(
                "fitmentType",
                "Fitment Type",
                0,
                RequirementLevel.Optional,
                RequirementLevel.Optional,
                Arrays.asList(new String[]{"Direct Replacement", "Performance/Custom"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));


        buildingToysCategoryAttributeValues.add(new CategoryAttributeData(
                "ageLevel",
                "Age Level",
                0,
                RequirementLevel.Optional,
                RequirementLevel.Optional,
                Arrays.asList(new String[]{"12 Months & Under", "1-2 Years","3-4 Years"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));
        buildingToysCategoryAttributeValues.add(new CategoryAttributeData(
                "modelTheme",
                "Model Theme",
                0,
                RequirementLevel.Optional,
                RequirementLevel.Optional,
                Arrays.asList(new String[]{"Airplane", "Alarm Clock","Animals & Zoo"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));
        rcToysCategoryAttributeValues.add(new CategoryAttributeData(
                "fuelType",
                "Fuel Type",
                0,
                RequirementLevel.Optional,
                RequirementLevel.Optional,
                Arrays.asList(new String[]{"Electric", "Gasoline","Jet Fuel/Kerosene"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));
        rcToysCategoryAttributeValues.add(new CategoryAttributeData(
                "scale",
                "Scale",
                0,
                RequirementLevel.Optional,
                RequirementLevel.Optional,
                Arrays.asList(new String[]{"1:4", "1:5","1:6","1.7","1.8"}), //Brand Names
                0,
                1,
                true,
                "SimpleList"));
    }
}

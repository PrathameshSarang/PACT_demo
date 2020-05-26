package com.afourtech.beans;

import com.afourtech.model.CategoryData;
import com.afourtech.model.StatusV2;
import com.afourtech.model.StatusV3;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CategoryDataResponseV3 {

    private StatusV3 status;
    private CategoryData data;

    public StatusV3 getStatus() {
        return status;
    }

    public CategoryData getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CategoryDataResponse{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }

    public CategoryDataResponseV3(StatusV3 status, CategoryData data) {
        this.status = status;
        this.data = data;
    }

    public static void main(String[] args) throws JsonProcessingException {

        /*CategoryDataResponse categoryDataResponse=new CategoryDataResponse(new Status(),CategoryDataDAO.data);
        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(categoryDataResponse));
*/    }
}

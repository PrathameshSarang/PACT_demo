package com.afourtech.beans;

import com.afourtech.dao.data.CategoryDataDAO;
import com.afourtech.model.CategoryData;
import com.afourtech.model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.stream.StreamSupport;

public class CategoryDataResponse {

    private Status status;
    private CategoryData data;

    public Status getStatus() {
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

    public CategoryDataResponse(Status status, CategoryData data) {
        this.status = status;
        this.data = data;
    }

    public static void main(String[] args) throws JsonProcessingException {

        /*CategoryDataResponse categoryDataResponse=new CategoryDataResponse(new Status(),CategoryDataDAO.data);
        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(categoryDataResponse));
*/    }
}

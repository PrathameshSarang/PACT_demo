package com.afourtech.api;


import com.afourtech.model.CategoryData;
import com.afourtech.model.Status;

public class CategoryDataResponse {

    public CategoryDataResponse() {
    }

    private Status status;
    private CategoryData data;

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setData(CategoryData data) {
        this.data = data;
    }

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
}
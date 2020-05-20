package com.afourtech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryAttributeData {

  private String attributeName;
  private String uiAttributeName;
  private Integer priority;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String description;
  private RequirementLevel merchantRequirement;
  private RequirementLevel consumerRequirement;
  private List<String> values;
  private Integer minValues;
  private Integer maxValues;
  private boolean allowOther;
  private String selectionMode;

  @Override
  public String toString() {
    return "CategoryAttributeData{" +
            "attributeName='" + attributeName + '\'' +
            ", uiAttributeName='" + uiAttributeName + '\'' +
            ", priority=" + priority +
            ", description='" + description + '\'' +
            ", merchantRequirement=" + merchantRequirement +
            ", consumerRequirement=" + consumerRequirement +
            ", values=" + values +
            ", minValues=" + minValues +
            ", maxValues=" + maxValues +
            ", allowOther=" + allowOther +
            ", selectionMode='" + selectionMode + '\'' +
            '}';
  }

  public CategoryAttributeData(String attributeName, String uiAttributeName, Integer priority, String description, RequirementLevel merchantRequirement, RequirementLevel consumerRequirement, List<String> values, Integer minValues, Integer maxValues, boolean allowOther, String selectionMode) {
    this.attributeName = attributeName;
    this.uiAttributeName = uiAttributeName;
    this.priority = priority;
    this.description = description;
    this.merchantRequirement = merchantRequirement;
    this.consumerRequirement = consumerRequirement;
    this.values = values;
    this.minValues = minValues;
    this.maxValues = maxValues;
    this.allowOther = allowOther;
    this.selectionMode = selectionMode;
  }

  public CategoryAttributeData(String attributeName, String uiAttributeName, Integer priority, RequirementLevel merchantRequirement, RequirementLevel consumerRequirement, List<String> values, Integer minValues, Integer maxValues, boolean allowOther, String selectionMode) {
    this.attributeName = attributeName;
    this.uiAttributeName = uiAttributeName;
    this.priority = priority;
    this.merchantRequirement = merchantRequirement;
    this.consumerRequirement = consumerRequirement;
    this.values = values;
    this.minValues = minValues;
    this.maxValues = maxValues;
    this.allowOther = allowOther;
    this.selectionMode = selectionMode;
  }

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public String getUiAttributeName() {
    return uiAttributeName;
  }

  public void setUiAttributeName(String uiAttributeName) {
    this.uiAttributeName = uiAttributeName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public RequirementLevel getMerchantRequirement() {
    return merchantRequirement;
  }

  public void setMerchantRequirement(RequirementLevel merchantRequirement) {
    this.merchantRequirement = merchantRequirement;
  }

  public RequirementLevel getConsumerRequirement() {
    return consumerRequirement;
  }

  public void setConsumerRequirement(RequirementLevel consumerRequirement) {
    this.consumerRequirement = consumerRequirement;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }

  public Integer getMinValues() {
    return minValues;
  }

  public void setMinValues(Integer minValues) {
    this.minValues = minValues;
  }

  public Integer getMaxValues() {
    return maxValues;
  }

  public void setMaxValues(Integer maxValues) {
    this.maxValues = maxValues;
  }

  public boolean isAllowOther() {
    return allowOther;
  }

  public void setAllowOther(boolean allowOther) {
    this.allowOther = allowOther;
  }

  public String getSelectionMode() {
    return selectionMode;
  }

  public void setSelectionMode(String selectionMode) {
    this.selectionMode = selectionMode;
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (!(o instanceof CategoryAttributeData)) {
//      return false;
//    }
//    CategoryAttributeData that = (CategoryAttributeData) o;
//    return allowOther == that.allowOther &&
//        Objects.equals(attributeName, that.attributeName) &&
//        Objects.equals(uiAttributeName, that.uiAttributeName) &&
//        Objects.equals(priority, that.priority) &&
//        Objects.equals(description, that.description) &&
//        merchantRequirement == that.merchantRequirement &&
//        consumerRequirement == that.consumerRequirement &&
//        Objects.equals(values, that.values) &&
//        Objects.equals(minValues, that.minValues) &&
//        Objects.equals(maxValues, that.maxValues) &&
//        Objects.equals(selectionMode, that.selectionMode);
//  }
}

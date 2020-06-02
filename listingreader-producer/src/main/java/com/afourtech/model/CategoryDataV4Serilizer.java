package com.afourtech.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.io.StringWriter;

public class CategoryDataV4Serilizer extends JsonSerializer<CategoryDataV4> {

  private ObjectMapper mapper = new ObjectMapper();
  @Override
  public void serialize(CategoryDataV4 value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {
    StringWriter writer = new StringWriter();
    mapper.writeValue(writer, value);
    gen.writeFieldName(writer.toString());
  }
}

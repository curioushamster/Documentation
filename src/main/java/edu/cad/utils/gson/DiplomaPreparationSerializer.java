package edu.cad.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import edu.cad.entities.DiplomaPreparation;
import java.lang.reflect.Type;

public class DiplomaPreparationSerializer extends AbstractEntitySerializer<DiplomaPreparation>{

    @Override
    public JsonElement serialize(DiplomaPreparation instance, Type type, JsonSerializationContext jsc) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        JsonElement jsonElement = gson.toJsonTree(instance);
        
        addProperty(jsonElement, "workType", instance.getWorkType(), false);
        addProperty(jsonElement, "workplan", instance.getWorkplan(), false);
        addProperty(jsonElement, "department", instance.getDepartment(), true);
       
        return jsonElement.getAsJsonObject();
    }
    
}

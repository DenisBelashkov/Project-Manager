package oop.sructure.converter;

import com.google.gson.*;
import oop.sructure.employers.employer.analyst.Analyst;
import oop.sructure.employers.employer.developer.Developer;
import oop.sructure.employers.employer.tester.Tester;
import oop.sructure.sprint.Sprint;
import oop.sructure.sprint.Task;

import java.lang.reflect.Type;
import java.util.List;

public class CustomConverter implements JsonSerializer<Sprint>, JsonDeserializer<Sprint>  {
/*   @Override
    public Sprint deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }

    @Override
    public JsonElement serialize(Sprint sprint, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }*/
    public JsonElement serialize(Sprint src, Type type,
                                 JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("name", src.getName()); // создать отдельный серил для остальных классов или apperObject
   /*     object.addProperty("openTaskList", (Number) src.getOpenTaskList());
        object.addProperty("devTaskList", (Number) src.getDevTaskList());
        object.addProperty("prodTaskList", (Number) src.getProdTaskList());
        object.addProperty("analysts", (Number) src.getAnalysts());
        object.addProperty("developers", (Number) src.getDevelopers());
        object.addProperty("testers", (Number) src.getTesters());*/
        object.addProperty("timeDev", src.getTimeDev());
        object.addProperty("currentDay", src.getCurrentDay());


        //добавление остальных зависимостей
        return object; //спец объект sprintDataTransfer
    }
    @Override

    public Sprint deserialize(JsonElement json, Type type,
                              JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        //создание этих блядских зависимостей
        String name = object.get("name").getAsString();
        int timeDev = object.get("timeDev").getAsInt();
        int currentDay = object.get("currentDay").getAsInt();
/*
         List<Task> openTaskList;
         List<Task> devTaskList;
         List<Task> prodTaskList;
         List<Analyst> analysts;
         List<Developer> developers;
         List<Tester> testers;*/
        // todo тут, по-хорошему, нужен словарь, но хз, с ним мороки больше
        // private List<Employer> employers;


        return new Sprint(name, timeDev,currentDay);
    }


}

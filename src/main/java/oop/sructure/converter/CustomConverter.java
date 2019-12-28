package oop.sructure.converter;

import com.google.gson.*;
import oop.sructure.employers.employer.Employer;
import oop.sructure.sprint.Sprint;
import oop.sructure.sprint.Task;

import java.lang.reflect.Type;

public class CustomConverter implements JsonSerializer<Sprint>, JsonDeserializer<Sprint> {
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
        object.addProperty("name", src.getName()); // создать отдельный серил для остальных классов или apperObjectobject.addProperty("openTaskList", (Number) src.getOpenTaskList());
        JsonArray devTask = new JsonArray();
        object.add("devTaskList", devTask);
        if (src.getDevTaskList() != null)

            for (Task task : src.getDevTaskList()) {
                devTask.add(
                        context.serialize(task)
/*
                        task instanceof Task ? context.serialize(task) : new JsonPrimitive(task.getName())
*/
                );
            }

        JsonArray prodTaskList = new JsonArray();
        object.add("prodTaskList", prodTaskList);
        if (src.getProdTaskList() != null)

            for (Task task : src.getProdTaskList()) {
                prodTaskList.add(
                        context.serialize(task)
                        /*
                        task instanceof Task ? context.serialize(task) : new JsonPrimitive(task.getName())
               */);
            }
        JsonArray openTaskList = new JsonArray();
        object.add("openTaskList", openTaskList);
        if (src.getOpenTaskList() != null)

            for (Task task : src.getOpenTaskList()) {
                prodTaskList.add(
                        context.serialize(task)
/*
                        task instanceof Task ? context.serialize(task) : new JsonPrimitive(task.getName())
*/
                );
            }
        JsonArray analysts = new JsonArray();
        object.add("analysts", analysts);
        if (src.getAnalysts() != null)

            for (Employer employer : src.getAnalysts()) {
                analysts.add(
                        context.serialize(employer)
                );
            }


        JsonArray testers = new JsonArray();
        object.add("testers", testers);
        if (src.getTesters() != null)
            for (
                    Employer employer : src.getTesters()) {
                testers.add(
                        context.serialize(employer));

            }


        JsonArray developers = new JsonArray();
        object.add("developers", developers);
        if (src.getDevelopers() != null)

            for (
                    Employer employer : src.getDevelopers()) {
                developers.add(
                        context.serialize(employer));

            }
        object.addProperty("timeDev", src.getTimeDev());
        // object.addProperty("currentDay", src.getCurrentDay());


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
Здесь мы создаем листы из массивов наших тасков, листы сотрудников по полученным данным и прочее говно, добавляем к спринту
 */
   /*      List<Task> openTaskList;
         List<Task> devTaskList;
         List<Task> prodTaskList;
         List<Analyst> analysts;
         List<Developer> developers;
         List<Tester> testers;*/
        // todo тут, по-хорошему, нужен словарь, но хз, с ним мороки больше
        // private List<Employer> employers;


        return new Sprint(name, timeDev, currentDay);
    }


}

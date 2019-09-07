package ExploreRabbitMq;

import com.google.gson.Gson;

public class JsonConverter {

    Gson gson = new Gson();

    public String objectToJsonConvert(UserMessage userMessage) {

        return gson.toJson(userMessage);
    }

    public UserMessage jsonToObjectConvert(String jsonData) {
        return gson.fromJson(jsonData, UserMessage.class);
    }

}

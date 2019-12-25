package utilFunctions;

import com.google.gson.Gson;

public class JsonValidCheck {
    private static final Gson gson = new Gson();

    private JsonValidCheck(){}

    public static boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch(com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }
}

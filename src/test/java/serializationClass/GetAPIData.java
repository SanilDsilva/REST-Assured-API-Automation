package serializationClass;
//import com.google.gson.JsonObject;

import com.google.gson.JsonObject;

public class GetAPIData {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String expected_output;


    public String getExpected_output() {
        return expected_output;
    }

    public void setExpected_output(String expected_output) {
        this.expected_output = expected_output;
    }

    @Override
    public String toString() {
        JsonObject data = new JsonObject();
        data.addProperty("id", id);
        data.addProperty("expected_output", expected_output);
        return data.toString();

    }
}

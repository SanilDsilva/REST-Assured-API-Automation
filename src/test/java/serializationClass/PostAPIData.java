package serializationClass;
//import com.google.gson.JsonObject;

import com.google.gson.JsonObject;

public class PostAPIData {
    private String firstname;
    private String lastname;
    private String age;
    private String expected_output;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLasttname() {
        return lastname;
    }

    public void setLasttname(String lasttname) {
        this.lastname = lasttname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getExpected_output() {
        return expected_output;
    }

    public void setExpected_output(String expected_output) {
        this.expected_output = expected_output;
    }

    @Override
    public String toString() {
        JsonObject data = new JsonObject();
        data.addProperty("firstname", firstname);
        data.addProperty("lastname", lastname);
        data.addProperty("age", age);
        data.addProperty("expected_output", expected_output);
        return data.toString();

    }
}

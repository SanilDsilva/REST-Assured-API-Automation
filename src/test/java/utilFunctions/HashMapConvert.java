package utilFunctions;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class HashMapConvert {
    public static Map<String,String> ConvertKeyValue(String dataString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(dataString, Map.class);
    }

}

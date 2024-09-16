package sakbuilder;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.Map;

public class HelloLambda implements RequestHandler<Object, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(final Object input, final Context context) {
        // Create response map
        Map<String, Object> response = new HashMap<>();
        try (InputStream inputStream = getClass().getResourceAsStream("/index.html");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            
            StringBuilder htmlContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                htmlContent.append(line).append("\n");
            }

            // Set response details
            response.put("statusCode", 200);
            response.put("headers", Map.of("Content-Type", "text/html"));
            response.put("body", htmlContent.toString());
        } catch (Exception e) {
            context.getLogger().log("Error reading file: " + e.getMessage());
            response.put("statusCode", 500);
            response.put("body", "Error reading file!");
        }

        return response;
    }
}

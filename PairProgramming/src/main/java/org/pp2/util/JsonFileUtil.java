package org.pp2.util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pp2.pojo.Response;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

public class JsonFileUtil {

    private static final Logger logger = Logger.getLogger("JsonFileUtil.class");

    public static void updateData(String path, Map<String, Object> properties) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Response response = mapper.readValue(new File(path), Response.class);

            System.out.println("Before Update: " + response);

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                updateFieldByName(response, entry.getKey(), entry.getValue());
            }

            System.out.println("After Update: " + response);

            // Save updated object back to file
            mapper.writeValue(new File(path), response);

        } catch (Exception e) {
            logger.severe("Error updating data: " + e.getMessage());
        }
    }

    // Helper method to update field by name at any nested level
    private static void updateFieldByName(Object object, String fieldName, Object newValue) {
        if (object == null) return;

        Class<?> clazz = object.getClass();
        if (clazz.getName().startsWith("java.")) return;

        for (Field field : clazz.getDeclaredFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) continue;

                field.setAccessible(true);
                Object value = field.get(object);

                if (field.getName().equals(fieldName)) {
                    field.set(object, newValue);
                    return;
                }

                // Recurse into objects and collections
                if (value != null) {
                    if (value instanceof Collection<?>) {
                        for (Object item : (Collection<?>) value) {
                            updateFieldByName(item, fieldName, newValue);
                        }
                    } else if (value.getClass().isArray()) {
                        for (Object item : (Object[]) value) {
                            updateFieldByName(item, fieldName, newValue);
                        }
                    } else if (value instanceof Map<?, ?>) {
                        for (Object entryVal : ((Map<?, ?>) value).values()) {
                            updateFieldByName(entryVal, fieldName, newValue);
                        }
                    } else if (!isPrimitiveOrWrapper(value.getClass()) && !(value instanceof String)) {
                        updateFieldByName(value, fieldName, newValue);
                    }
                }

            } catch (Exception e) {
                logger.warning("Error accessing field: " + field.getName() + " in " + clazz.getSimpleName());
            }
        }
    }

    private static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        return clazz.isPrimitive() ||
                clazz == Boolean.class || clazz == Integer.class || clazz == Character.class ||
                clazz == Byte.class || clazz == Short.class || clazz == Double.class ||
                clazz == Long.class || clazz == Float.class;
    }
}

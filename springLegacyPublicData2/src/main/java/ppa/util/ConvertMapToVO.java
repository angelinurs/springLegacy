package ppa.util;

import java.lang.reflect.Field;
import java.util.*;

public class ConvertMapToVO {
	public static <T> T convertToValueObject(Map<String, Object> map, Class<T> type) {
        try {
            Objects.requireNonNull(type, "Class cannot be null");
            T instance = type.getConstructor().newInstance();

            if (map == null || map.isEmpty()) {
                return instance;
            }

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field[] fields = type.getDeclaredFields();

                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();

                    boolean isSameType = entry.getValue().getClass().equals( getReferenceType(field.getType()));
                    boolean isSameName = entry.getKey().equals(name);

                    if (isSameType && isSameName) {
                        field.set(instance, map.get(name));
                        break;
                    }
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	private static Class<?> getReferenceType(Class<?> type) {
        switch ( type.getName() ) {
            case "boolean" : return Boolean.class;
            case "byte"    : return Byte.class;
            case "short"   : return Short.class;
            case "char"    : return Character.class;
            case "int"     : return Integer.class;
            case "long"    : return Long.class;
            case "float"   : return Float.class;
            case "double"  : return Double.class;
            default        : return type;
        }
    }
}

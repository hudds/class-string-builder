package br.com.hudson.stringbuilder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class StringBuilderWithReflection {

	/**
	 * Uses the getters of the object to build a readable string. It will work only
	 * on fields that have public getters.
	 * 
	 * @param object - Object to be turned into string
	 * @return String based on the getters of the object
	 */
	public static String build(Object object) {
		Field[] declaredFields = object.getClass().getDeclaredFields();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(object.getClass().getSimpleName());
		stringBuilder.append("{");
		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			try {
				String fieldName = field.getName();
				String firstCharUpperCase = Character.valueOf(fieldName.charAt(0)).toString().toUpperCase();
				fieldName = fieldName.replaceAll("^[A-z]", firstCharUpperCase);
				Method method = object.getClass().getMethod("get" + fieldName);
				stringBuilder.append(field.getName());
				stringBuilder.append("=");
				Object fieldValue = method.invoke(object, new Object[] {});
				stringBuilder.append(fieldValue);
				if (i < declaredFields.length - 1) {
					stringBuilder.append(", ");
				}
			} catch (SecurityException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
				continue;
			}
		}
		stringBuilder.append("}");
		return stringBuilder.toString();

	}

}
package net.letscode.nau.utiled;

import java.util.Arrays;

public class ArrayUtil {
    public static boolean containsInArray(char[] array, char object) {
        for(char element : array) {
            if(element == object) return true;
        }

        return false;
    }

    public static char[] addToArray(char[] array, char object) {
        char[] newArray = Arrays.copyOf(array, array.length+1);
        newArray[array.length] = object;
        return newArray;
    }
    public static <t>t[] addToArray(t[] array, t object) {
        t[] newArray = Arrays.copyOf(array, array.length+1);
        newArray[array.length] = object;
        return newArray;
    }

    public static <t>t[] addToArray(t[] array, t... object) {
        t[] newArray = Arrays.copyOf(array, array.length + object.length);

        for (int i = array.length; i < newArray.length; i++) {
            newArray[i] = object[i - array.length];
        }

        return newArray;
    }
}

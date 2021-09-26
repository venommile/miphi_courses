package ru.miphi.dz1;

import java.util.Objects;

public class Comparator {

    public boolean equals(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return Objects.deepEquals(obj, obj2);
        } else {
            return Objects.deepEquals(obj, obj2) && obj.equals(obj2);
        }
    }
}

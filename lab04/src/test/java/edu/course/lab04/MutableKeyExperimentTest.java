package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MutableKeyExperimentTest {

    static final class MutableKey {
        private String code;
        private int number;

        MutableKey(String code, int number) {
            this.code = code;
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MutableKey)) return false;
            MutableKey other = (MutableKey) o;
            return number == other.number && code.equals(other.code);
        }

        @Override
        public int hashCode() {
            return 31 * code.hashCode() + number;
        }
    }

    @Test
    void mutatingKeyBreaksLookup() {
        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey("PROJ", 1);
        map.put(key, "value");

        assertEquals("value", map.get(new MutableKey("PROJ", 1)));

        key.number = 2;

        assertNull(map.get(new MutableKey("PROJ", 1)),
                "Ожидалось, что поиск сломается после мутации ключа");

        assertNull(map.get(new MutableKey("PROJ", 2)));

        assertEquals(1, map.size());
    }
}
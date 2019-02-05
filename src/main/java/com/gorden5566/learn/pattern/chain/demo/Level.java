package com.gorden5566.learn.pattern.chain.demo;

import java.util.Objects;

public class Level {
    public static Level LOW_LEVEL;
    public static Level MIDDLE_LEVEL;
    public static Level HIGH_LEVEL;

    static {
        LOW_LEVEL = new Level(1);
        MIDDLE_LEVEL = new Level(2);
        HIGH_LEVEL = new Level(3);
    }

    private int level;

    private Level(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level1 = (Level) o;
        return level == level1.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}

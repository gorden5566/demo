package com.gorden5566.learn.pattern.manual.memento.multiple.extend;

import com.gorden5566.learn.pattern.manual.memento.multiple.Memento;

import java.util.HashMap;
import java.util.Map;

public class Caretaker {
    private Map<String, Memento> mementoMap = new HashMap<>();

    public Memento getMemento(String idx) {
        return mementoMap.get(idx);
    }

    public void setMemento(String idx, Memento memento) {
        this.mementoMap.put(idx, memento);
    }
}

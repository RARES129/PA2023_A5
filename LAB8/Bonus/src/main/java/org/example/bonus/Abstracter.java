package org.example.bonus;

import java.sql.SQLException;

public abstract class Abstracter {

    protected int counter;
    protected Object dao;

    public abstract void setDao(Object dao);

    public abstract Object getDao();

    public abstract int getCounter();
}

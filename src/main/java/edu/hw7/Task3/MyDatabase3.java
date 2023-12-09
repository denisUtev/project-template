package edu.hw7.Task3;

import java.util.HashMap;
import java.util.List;

public class MyDatabase3 implements PersonDatabase {

    private final HashMap<Integer, Person> database = new HashMap<>();

    @Override
    public void add(Person person) {
        synchronized (database) {
            database.put(person.id(), person);
        }
    }

    @Override
    public void delete(int id) {
        synchronized (database) {
            database.remove(id);
        }
    }

    @Override
    public List<Person> findByName(String name) {
        synchronized (database) {
            return database.values().stream().filter(person -> person.name().equals(name)).toList();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        synchronized (database) {
            return database.values().stream().filter(person -> person.address().equals(address)).toList();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        synchronized (database) {
            return database.values().stream().filter(person -> person.phoneNumber().equals(phone)).toList();
        }
    }
}

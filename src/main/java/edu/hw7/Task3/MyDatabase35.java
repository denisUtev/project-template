package edu.hw7.Task3;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyDatabase35 implements PersonDatabase {

    private final HashMap<Integer, Person> database = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock writeLock = lock.writeLock();
    private Lock readLock = lock.readLock();

    @Override
    public void add(Person person) {
        try {
            writeLock.lock();
            database.put(person.id(), person);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void delete(int id) {
        try {
            writeLock.lock();
            database.remove(id);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        try {
            readLock.lock();
            return database.values().stream().filter(person -> person.name().equals(name)).toList();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        try {
            readLock.lock();
            return database.values().stream().filter(person -> person.address().equals(address)).toList();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        try {
            readLock.lock();
            return database.values().stream().filter(person -> person.phoneNumber().equals(phone)).toList();
        } finally {
            readLock.unlock();
        }
    }
}

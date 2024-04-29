package org.example.service;

import java.util.List;

public interface ITicketService <T> {




    public boolean modifyById(T element);
    public boolean deleteById(int id);

    public T getById(int id);

    public List<T> getAll(int id);


}

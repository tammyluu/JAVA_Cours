package dao;

import java.util.Date;
import java.util.List;

public interface DAOInterface <T> {

    public List<T> selectAll();

    public T selectById(int id);

    public boolean addNew(T t);

    public void update(T t, int id);

    public void delete(int id);
    public List<T> searchByPrice(Double prix);

    public List<T> getByStock(int stock);
}

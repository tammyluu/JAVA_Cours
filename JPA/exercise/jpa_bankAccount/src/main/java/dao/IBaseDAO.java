package dao;

import entity.BranchBank;

import java.util.List;

public interface IBaseDAO <T>{
    boolean createAndSave (T element);


    boolean update (T element);



    T  getById(Long id);
    boolean deleteById(Long id);
    List<T> getAll();
}

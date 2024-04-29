package dao;

import entity.Info;
import entity.Task;

import java.util.List;

public interface InfoDAO {
    public boolean addInfo(Info info);

    public List<Info> getAllInfos();

    public boolean deleteInfo(Long infoId);


}

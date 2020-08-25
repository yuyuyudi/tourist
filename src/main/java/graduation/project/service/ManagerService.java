package graduation.project.service;

import graduation.project.model.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerService {

    Manager queryManagerById(Integer id);

    List<Manager> queryManager(String manager, String password);

    void put(String manager, String password);

    String get(String manager);

    List<Manager> queryAllSpot();
}

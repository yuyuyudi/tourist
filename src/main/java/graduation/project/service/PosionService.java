package graduation.project.service;

import graduation.project.model.Location;
import graduation.project.model.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PosionService {
    Integer insertLocation(String name, String coordinateX, String coordinateY);

    List<Location> queryAllPosition(String name);
}

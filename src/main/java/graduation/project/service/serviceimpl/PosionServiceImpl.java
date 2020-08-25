package graduation.project.service.serviceimpl;

import graduation.project.mapper.LocationMapper;
import graduation.project.model.Location;
import graduation.project.service.PosionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosionServiceImpl implements PosionService {
    @Autowired
    private LocationMapper locationMapper;
    @Override
    public Integer insertLocation(String name, String coordinateX, String coordinateY) {
        Location location = new Location();
        location.setName(name);
        location.setCoordinateX(Double.valueOf(coordinateX));
        location.setCoordinateY(Double.valueOf(coordinateY));
        return locationMapper.insertSelective(location);
    }

    @Override
    public List<Location> queryAllPosition(String name) {
        return locationMapper.queryLoactionByName(name);
    }
}

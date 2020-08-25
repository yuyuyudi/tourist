package graduation.project.service.serviceimpl;


import graduation.project.mapper.ManagerMapper;
import graduation.project.model.Manager;
import graduation.project.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper manangerMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public Manager queryManagerById(Integer id) {
        return manangerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Manager> queryManager(String manager, String password) {
        return manangerMapper.selectByManageAndPassword(manager,password);
    }

    @Override
    public void put(String manager, String password) {
        redisTemplate.opsForValue().set(manager,password);
    }

    @Override
    public String get(String manager) {
        return (String) redisTemplate.opsForValue().get(manager);
    }

    @Override
    public List<Manager> queryAllSpot() {
        return manangerMapper.queryAllManager();
    }
}

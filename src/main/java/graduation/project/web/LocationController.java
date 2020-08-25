package graduation.project.web;

import graduation.project.model.Location;
import graduation.project.model.Manager;
import graduation.project.service.ManagerService;
import graduation.project.service.PosionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private PosionService posionService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/add/location")
    public String addLocation(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String coordinateX = request.getParameter("coordinateX");
        String coordinateY = request.getParameter("coordinateY");
        posionService.insertLocation(name,coordinateX,coordinateY);
        return "success";
    }

    @RequestMapping("/location/display")
    public @ResponseBody Object displayLocation(HttpServletRequest request){
        String name = request.getParameter("name");
        List<Location> locationList = posionService.queryAllPosition(name);
        if (locationList.size() != 0){
            return locationList;
        }
        return null;
    }


    @RequestMapping("/spot/display")
    public @ResponseBody Object displaySpot(HttpServletRequest request){
        List<Manager> spotList = managerService.queryAllSpot();
        if (spotList.size() != 0){
            return spotList;
        }
        return null;
    }
}

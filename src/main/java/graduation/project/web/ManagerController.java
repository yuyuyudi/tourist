package graduation.project.web;

import graduation.project.model.Manager;
import graduation.project.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/managerName/login/authentication")
    public String loginManager(Model model,String manager,String password){
        List<Manager> managerList = managerService.queryManager(manager,password);
        if (managerList.size() != 0){
            managerService.put(manager,password);
            model.addAttribute("manager",managerList.get(0));
            return  "managePage";
        }
        model.addAttribute("message","用户或密码不存在，请重新登录");
        return "managerLogin";

    }
}

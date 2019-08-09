package git.leslie.controller;

import git.leslie.entity.User;
import git.leslie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param key
     * @param model
     * @return
     */
    @RequestMapping("/getUser")
    public String getUsers(String key, Model model){
        if (null==key || key.isEmpty() ){
            List<User> all = userService.allUser();
            model.addAllAttributes(all);
            model.addAttribute("formLists",all);
            return "formlists/form";
        }else {
            List<User> list = userService.searchShoes(key);
            model.addAllAttributes(list);
            model.addAttribute("formLists",list);
            return "formlists/form";
        }

    }

    /**
     *
     * @param username
     * @param no
     * @return
     */
    @PostMapping(value = "/add")
    public String addUser(String username, String no){
        User user = new User(null,username, no);
        userService.addUser(user);
        System.out.println(user.hashCode());
        return  "redirect:/getUser";
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}" )
    public ModelAndView delUser(@PathVariable Integer id){
        userService.delUser(id);
        return new ModelAndView("redirect:/getUser");
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/modify/{id}" )
    public String modifyUser(@PathVariable Integer id, Model model){
        User student = userService.getUserById(id);
        model.addAttribute("stu",student);
        model.addAttribute("stuId",id);
        return "formlists/modify";
    }

    /**
     *
     * @param stuId
     * @param username
     * @param no
     * @return
     */
    @RequestMapping(value = "/update/{stuId}" )
    public String updateUser(@PathVariable Integer stuId, String username, String no){
        userService.updateUser(new User(stuId,username,no));
        return "redirect:/getUser";
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/getUser/{id}" )
    @ResponseBody
    public String getUserById(@PathVariable int id, Model model){
        User student = userService.getUserById(id);
        model.addAttribute("students",student);
        return student.toString();
    }
}

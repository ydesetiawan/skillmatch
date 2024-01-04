package id.web.skillmatch.controller;

import id.web.skillmatch.dto.request.SaveUserCmd;
import id.web.skillmatch.usecase.saveuser.SaveUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final SaveUser saveUser;

    @GetMapping("/admin/users")
    public String getUsers(
        Model model,
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("size") Optional<Integer> size,
        @RequestParam("query") Optional<String> query) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(100);

        return "user";
    }

    @GetMapping("/admin/user/add")
    public String addUser(Model model) {

        model.addAttribute("cmd", new SaveUserCmd().withActionType(ActionType.ADD));

        return "add_user";
    }

    @PostMapping("/admin/user/add")
    public String addUser(
        @ModelAttribute @Valid SaveUserCmd cmd,
        BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            model.addAttribute("result", result);
            model.addAttribute("cmd", cmd);
            return "add_user";
        }

        saveUser.save(cmd);

        return "redirect:/admin/users";
    }

}

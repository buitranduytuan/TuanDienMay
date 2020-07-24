package tuanbtd.com.controller;

import java.util.HashSet;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tuanbtd.com.entity.Role;
import tuanbtd.com.entity.ThanhVien;
import tuanbtd.com.model.ForgotPasswordForm;
import tuanbtd.com.model.ThanhVienFrom;
import tuanbtd.com.service.RoleService;
import tuanbtd.com.service.ThanhVienService;
import tuanbtd.com.serviceImpl.UserDetailsServiceImpl;
import tuanbtd.com.validator.ThanhVienValidator;

@Controller
public class ThanhVienController {

    @Autowired
    ThanhVienService thanhVienService;

    @Autowired
    RoleService roleService;

    @Autowired
    ThanhVienValidator thanhVienValidator;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JavaMailSender emailSender;

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    private final Logger logger = Logger.getLogger(ThanhVienController.class);
    private static final String LOGIN = "login";
    private static final String REGISTER = "register";
    private static final String FORGOT_PASSWORD = "forgot_password";

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerTVGetMethod(Model model) {
        model.addAttribute("thanhVien", new ThanhVienFrom());
        return REGISTER;
    }

    @RequestMapping(value = "/register-action", method = RequestMethod.POST)
    public String registerThanhVien(@ModelAttribute("thanhVien") ThanhVienFrom thanhVien, BindingResult bindingResult,
            Model model) {
        thanhVienValidator.validate(thanhVien, bindingResult);
        if (bindingResult.hasErrors()) {
            logger.error("Register fail");
            model.addAttribute("thanhVien", thanhVien);
            return REGISTER;
        }
        boolean isUserNameExisting = thanhVienService.isUserNameExisting(thanhVien.getUsername());
        boolean isEmailExisting = thanhVienService.isEmailExisting(thanhVien.getEmail());

        if (isUserNameExisting) {
            model.addAttribute("errorSignUp", "Username '" + thanhVien.getUsername() + "' already existing");
            thanhVien.setUsername("");
            model.addAttribute("thanhVien", thanhVien);
            return "register";
        }

        if (isEmailExisting) {
            model.addAttribute("errorSignUp", "Email '" + thanhVien.getEmail() + "' already existing");
            thanhVien.setEmail("");
            model.addAttribute("thanhVien", thanhVien);
            return "register";
        }

        thanhVien.setPassword(passwordEncoder.encode(thanhVien.getPassword()));
        HashSet<Role> roles = new HashSet<Role>();
        roles.add(roleService.getRoleByRoleName("ROLE_MEMBER"));
        ThanhVien tv = new ThanhVien(thanhVien.getUsername(), thanhVien.getPassword(), true, thanhVien.getDiaChi(),
                thanhVien.getEmail(), thanhVien.getHoTen(), thanhVien.getSoDienThoai(), roles);

        thanhVienService.registerThanhVien(tv);

        // đăng ký xong thì gửi mail thông báo đến người dùng
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(thanhVien.getEmail());
        message.setSubject("Tạo Acount thành Công - TuanDienMay");
        message.setText("Bạn đã tạo thành công Account với Username là: " + thanhVien.getUsername());

        // Send Message!
        emailSender.send(message);
        model.addAttribute("RegisterSuccess", "Account registration successful");
        return LOGIN;
    }

    
    // ví dụ về gửi Email định dạng HTML
    @GetMapping("/forgotPassword")
    @ResponseBody
    public String quenMauKhau(@RequestParam("username") String username, Model model, HttpSession session)
            throws MessagingException {

        ThanhVien thanhVien = thanhVienService.getThanhVienByUsername(username);
        if (thanhVien == null) {
            return "Tài khoản không được tìm thấy";
        }

        session.setAttribute("username", username);

        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");

        Random random = new Random();
        int min = 100000, max = 999999;
        int codeNumber = min + random.nextInt(max - min + 1);
        session.setAttribute("codeNumber", codeNumber);

        String htmlMsg = "<h2>Hi " + thanhVien.getUsername() + "</h2>"
                + messageSource.getMessage("createNewPasswork.image", null, null)
                + messageSource.getMessage("createNewPasswork.content", null, null) + "<h4>" + codeNumber + "</h4>"
                + messageSource.getMessage("createNewPasswork.link", null, null);

        message.setContent(htmlMsg, "text/html");
        helper.setTo(thanhVien.getEmail());
        helper.setSubject("Quên mật khẩu - TuanDienMay");
        emailSender.send(message); // Send Message!

        return "Bạn hãy truy cập email: " + thanhVien.getEmail() + " để lấy mã code";
    }

    @GetMapping("/creatNewPassword")
    public String creatNewPassword(Model model, HttpSession session) {
        if (session.getAttribute("codeNumber") == null) {
            return "redirect:/";
        }
        model.addAttribute("forgotPassword", new ForgotPasswordForm());
        return FORGOT_PASSWORD;
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@ModelAttribute("forgotPassword") ForgotPasswordForm fpf, Model model,
            HttpSession session) {
        int code = (int) session.getAttribute("codeNumber");
        if (code != fpf.getCodeNumber()) {
            model.addAttribute("codeIncorrect", "Bạn nhập mã code không đúng");
            return FORGOT_PASSWORD;
        }
        
        ThanhVien thanhVien = thanhVienService.getThanhVienByUsername(fpf.getUsername());
        thanhVien.setPassword(passwordEncoder.encode(fpf.getPassword()));
        thanhVienService.updateMemberInfo(thanhVien);

        session.removeAttribute("codeNumber");
        model.addAttribute("username", fpf.getUsername());
        model.addAttribute("createNewPassSuccess", "Bạn đã đặt mật khẩu mới thành công. Mời bạn đăng nhập lại");
        return LOGIN;
    }
}

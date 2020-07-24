package tuanbtd.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import tuanbtd.com.model.DanhMucSanPhamDTO;
import tuanbtd.com.service.SanPhamService;

@Controller
@ControllerAdvice
public class ShareModelAttributeController {

    @Autowired
    SanPhamService sanPhamService;
    
    @ModelAttribute("listDanhMuc")
    public List<DanhMucSanPhamDTO> getDanhMucSP() {
        return sanPhamService.getDanhMucSP();
    }
}

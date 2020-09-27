package tuanbtd.com.RESTController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tuanbtd.com.DTO.NSX_DTO;
import tuanbtd.com.entity.NhaSanXuat;
import tuanbtd.com.service.NhaSanXuatService;

@RestController
@RequestMapping("/api")
public class REST_API_NSX {

    @Autowired
    NhaSanXuatService nhaSanXuatService;

    @GetMapping(value = "/list_nsx")
    public ResponseEntity<?> getListNhaSanXuat() {
        List<NSX_DTO> listNSX = nhaSanXuatService.getListNSX();
        return ResponseEntity.ok(listNSX);
    }

    @GetMapping(value = "/getNSXById/{id}")
    public NhaSanXuat getNhaSanXuatById(@PathVariable("id") int id) {
        return nhaSanXuatService.getNSXById(id);
    }

    @PostMapping(value = "/addNSX")
    public boolean addNhaSanXuat(@RequestBody NhaSanXuat nsx) {
        return nhaSanXuatService.addNSX(nsx);
    }

    @PutMapping(value = "/editNSX")
    public boolean editNhaSanXuat(@RequestBody NhaSanXuat nsx) {
        return nhaSanXuatService.updateNSX(nsx);
    }
    
    @DeleteMapping("/deleteNSX/{id}")
    public boolean deleteNSX(@PathVariable("id") int id) {
        return nhaSanXuatService.deleteNSX(id);
    }
}

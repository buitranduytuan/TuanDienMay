package tuanbtd.com.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tuanbtd.com.entity.NhaSanXuat;
import tuanbtd.com.serviceImpl.NhaSanXuatService;

@RestController
public class RESTNhaSanXuatController {

    @Autowired
    NhaSanXuatService nhaSanXuatService;
    
    @RequestMapping(value = "/list_nsx", method = RequestMethod.GET)
    public List<NhaSanXuat> getListNhaSanXuat(){
        return nhaSanXuatService.getListNSX();
    }
    
    @RequestMapping(value = "/getNSXById/{id}", method = RequestMethod.GET)
    public NhaSanXuat getNhaSanXuatById(@PathVariable("id") int id) {
        return nhaSanXuatService.getNSXById(id);
    }

    @RequestMapping(value = "/addNSX", method = RequestMethod.POST)
    public boolean addNhaSanXuat(@RequestBody NhaSanXuat nsx) {
        return nhaSanXuatService.addNSX(nsx);
    }

    @RequestMapping(value = "/editNSX", method = RequestMethod.PUT)
    public boolean editNhaSanXuat(@RequestBody NhaSanXuat nsx) {
        return nhaSanXuatService.updateNSX(nsx);
    }
    
    
}

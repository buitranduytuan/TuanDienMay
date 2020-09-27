package tuanbtd.com.admin.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tuanbtd.com.entity.ChiTietDonDatHang;
import tuanbtd.com.entity.DonDatHang;
import tuanbtd.com.service.DatHangService;

@Controller
@RequestMapping("/admin")
public class OrderManagementController {

    @Autowired
    DatHangService datHangService;

    private static final String ORDERED_LIST = "admin/orderedList";
    private static final String DUYET_DON_HANG = "admin/duyetDonDatHang";

    @GetMapping("/orderedList")
    public String getProduct(Model model) {
        model.addAttribute("ChuaThanhToan", datHangService.getDonHangChuaThanhToan());
        model.addAttribute("DaThanhToanChuaGiao", datHangService.getDonHangDaThanhToanChuaGiao());
        model.addAttribute("DaThanhToanDaGiao", datHangService.getDonHangDaThanhToanDaGiao());
        return ORDERED_LIST;
    }

    @GetMapping("/duyetDonDatHang/{maDDH}")
    public String duyetDonDatHang(@PathVariable(name = "maDDH", required = true) int maDDH, Model model) {

        model.addAttribute("donDatHang", datHangService.getDDHByMaDDH(maDDH));
        List<ChiTietDonDatHang> chiTietDDHs = datHangService.getChiTietDDHByMaDHH(maDDH);
        model.addAttribute("chiTietDDHs", chiTietDDHs);

        BigDecimal tongTien = new BigDecimal(0);
        for (ChiTietDonDatHang ct : chiTietDDHs) {
            BigDecimal soLuong = new BigDecimal(ct.getSoLuong());
            tongTien = tongTien.add(ct.getDonGia().multiply(soLuong));
        }

        model.addAttribute("tongTienThanhToan", tongTien);
        return DUYET_DON_HANG;
    }

    @PostMapping("/duyetDDH")
    public String updateDDH(Model model, @ModelAttribute(name = "donDatHang") DonDatHang donDatHang) {
        DonDatHang ddhByMaDDH = datHangService.getDDHByMaDDH(donDatHang.getMaDDH());
        ddhByMaDDH.setTinhTrangGiaoHang(donDatHang.getTinhTrangGiaoHang());
        ddhByMaDDH.setDaThanhToan(donDatHang.getDaThanhToan());
        ddhByMaDDH.setNgayDat(donDatHang.getNgayDat());
        ddhByMaDDH.setNgayGiao(donDatHang.getNgayGiao());
        datHangService.updateDDH(ddhByMaDDH);
        // sent a mail to the customer
        return "redirect:/" + ORDERED_LIST;
    }

}

package tuanbtd.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import tuanbtd.com.entity.SanPham;
import tuanbtd.com.service.SanPhamService;

@Controller
public class SanPhamController {

    private static final String PRODUCTS = "products";
    private static final String PRODUCT_DETAIL = "product_detail";

    // Info Pagination
    private static final int PRODUCTS_PER_PAGE = 9;
    private static int totalPage = 0;
    private static int soLuongSP = 0;
    private static int soDong = 0;
    private static List<SanPham> listProductOnPage = new ArrayList<SanPham>();

    @Autowired
    SanPhamService sanPhamService;

    public void infoOfPage(Model model, int pageCurrent) {
        soLuongSP = listProductOnPage.size();
        soDong = (soLuongSP % 3 == 0) ? soLuongSP / 3 : soLuongSP / 3 + 1;
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("soLuongSP", soLuongSP);
        model.addAttribute("soDong", soDong);
        model.addAttribute("listProduct", listProductOnPage);
        model.addAttribute("pageCurrent", pageCurrent);
    }

    @GetMapping("/productByCategory/{loaiSP}/{page}")
    public String getProductByLoaiSP(@PathVariable(name = "loaiSP", required = true) String loaiSP,
            @PathVariable(name = "page", required = true) int page, Model model) {
        List<SanPham> listProductByLoaiSP = sanPhamService.getSanPhamByLoaiSP(loaiSP);
        int numberProducts = listProductByLoaiSP.size();
        totalPage = (int) Math.ceil((double) numberProducts / PRODUCTS_PER_PAGE);
        if (page > totalPage || page < 1) {
            return "redirect:/";
        }
        listProductOnPage = getListProductsOnPageFromAList(listProductByLoaiSP, page);
        // check để phân Pagination
        model.addAttribute("check", 1);
        model.addAttribute("loaiSP", loaiSP);
        infoOfPage(model, page);
        return PRODUCTS;
    }

    @GetMapping("/product/{loaiSP}/{tenNSX}/{page}")
    public String getProductByLoaiSPAndNSX(@PathVariable(name = "loaiSP", required = true) String loaiSP,
            @PathVariable(name = "tenNSX", required = true) String tenNSX,
            @PathVariable(name = "page", required = true) int page, Model model) {
        List<SanPham> listProduct = sanPhamService.getSanPhamByLoaiSP_NSX(loaiSP, tenNSX);
        int numberProducts = listProduct.size();
        totalPage = (int) Math.ceil((double) numberProducts / PRODUCTS_PER_PAGE);

        if (page > totalPage || page < 1) {
            return "redirect:/";
        }
        listProductOnPage = getListProductsOnPageFromAList(listProduct, page);
        // check để phân Pagination
        model.addAttribute("check", 2);
        model.addAttribute("loaiSP", loaiSP);
        model.addAttribute("tenNSX", tenNSX);
        infoOfPage(model, page);
        return PRODUCTS;
    }

    @GetMapping("/findProductByName")
    public String findProductByName(@RequestParam(value = "productName") String productName,
            @RequestParam(value = "page") int page, Model model) {
        List<SanPham> listProduct = sanPhamService.findSanPhamByName(productName);
        int numberProducts = listProduct.size();
        totalPage = (int) Math.ceil((double) numberProducts / PRODUCTS_PER_PAGE);
        if (page > totalPage || page < 1) {
            return "redirect:/";
        }
        listProductOnPage = getListProductsOnPageFromAList(listProduct, page);
        // check để phân Pagination
        model.addAttribute("check", 3);
        model.addAttribute("productName", productName);
        infoOfPage(model, page);
        return PRODUCTS;
    }

    @GetMapping("/productDetail/{id}")
    public String getProductByLoaiSPAndNSX(@PathVariable("id") int id, Model model) {
        SanPham sp = sanPhamService.getSanPhamById(id);
        model.addAttribute("sp", sp);
        return PRODUCT_DETAIL;
    }

    public List<SanPham> getListProductsOnPageFromAList(List<SanPham> listProduct, int page) {
        List<SanPham> listProductPerPage = new ArrayList<SanPham>();
        int numberProducts = listProduct.size();
        int start = PRODUCTS_PER_PAGE * (page - 1);
        int end = start + PRODUCTS_PER_PAGE - 1;
        if (end >= numberProducts) {
            end = numberProducts - 1;
        }

        for (int i = start; i <= end; i++) {
            listProductPerPage.add(listProduct.get(i));
        }

        return listProductPerPage;
    }

}

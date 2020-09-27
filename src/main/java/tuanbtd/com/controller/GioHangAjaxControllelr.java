package tuanbtd.com.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tuanbtd.com.DTO.OrderDTO;
import tuanbtd.com.DTO.OrderItemDTO;
import tuanbtd.com.entity.SanPham;
import tuanbtd.com.service.SanPhamService;

@Controller
@RequestMapping("/giohang")
public class GioHangAjaxControllelr {

    @Autowired
    SanPhamService sanPhamService;

    private static final String CHITIETGIOHANG = "chitietgiohang";

    @GetMapping("/xemgiohang")
    public String cartDetail(HttpServletRequest request, HttpSession session) {
        String tongTien = "";
        if (session.getAttribute("order") != null) {
            OrderDTO orderDTO = (OrderDTO) session.getAttribute("order");
            BigDecimal totalMoney = totalMoney(orderDTO);
            DecimalFormat df = new DecimalFormat("#,###");
            tongTien = df.format(totalMoney);
            request.setAttribute("tongTien", tongTien);
        }

        return CHITIETGIOHANG;
    }
    
    @GetMapping("/themgiohang/{maSP}")
    @ResponseBody
    public String addToCart(@PathVariable(name = "maSP", required = true) int maSP, HttpSession session,
            HttpServletRequest request) {
        String soSP = "";
        OrderDTO orderDTO;
        if (session.getAttribute("order") != null) {
            orderDTO = (OrderDTO) session.getAttribute("order");
            List<OrderItemDTO> orderItems = orderDTO.getOrderItems();
            boolean flag = false;

            for (OrderItemDTO orderItem : orderItems) {
                if (orderItem.getSanPham().getMaSP() == maSP) {
                    int number = orderItem.getNumber() + 1;
                    orderItem.setNumber(number);
                    soSP += number;
                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                OrderItemDTO orderItemDTO = new OrderItemDTO();
                orderItemDTO.setNumber(1);
                soSP += 1;
                orderItemDTO.setSanPham(sanPhamService.getSanPhamById(maSP));
                orderDTO.getOrderItems().add(orderItemDTO);
            }

        } else {
            orderDTO = new OrderDTO();
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setNumber(1);
            soSP += 1;
            orderItemDTO.setSanPham(sanPhamService.getSanPhamById(maSP));
            List<OrderItemDTO> orderItems = new ArrayList<OrderItemDTO>();
            orderItems.add(orderItemDTO);
            orderDTO.setOrderItems(orderItems);
        }

        session.setAttribute("order", orderDTO);
        return soSP;
    }

    @GetMapping("/xoagiohang/{maSP}")
    @ResponseBody
    public String deleteOrderItems(@PathVariable(name = "maSP", required = true) int maSP, HttpSession session) {
        String tongTien = "";
        if (session.getAttribute("order") != null) {
            OrderDTO orderDTO = (OrderDTO) session.getAttribute("order");
            List<OrderItemDTO> orderItems = orderDTO.getOrderItems();
            for (OrderItemDTO orderItem : orderItems) {
                SanPham sanPham = orderItem.getSanPham();
                if (sanPham.getMaSP() == maSP) {
                    orderItems.remove(orderItem);
                    break;
                }
            }

            session.setAttribute("order", orderDTO);

            if (orderItems.size() == 0) {
                session.removeAttribute("order");
            }

            BigDecimal totalMoney = totalMoney(orderDTO);
            DecimalFormat df = new DecimalFormat("#,###");
            tongTien = df.format(totalMoney);
        }

        return tongTien;
    }

    @GetMapping("/update")
    @ResponseBody
    public String updateGioHang(@RequestParam(name = "maSP", required = true) int maSP,
            @RequestParam(name = "number", required = true) int number, HttpSession session) {
        String tongTien = "";

        if (session.getAttribute("order") != null) {
            OrderDTO orderDTO = (OrderDTO) session.getAttribute("order");
            List<OrderItemDTO> orderItems = orderDTO.getOrderItems();

            for (OrderItemDTO orderItem : orderItems) {
                SanPham sanPham = orderItem.getSanPham();
                if (sanPham.getMaSP() == maSP) {
                    orderItem.setNumber(number);
                    break;
                }
            }

            session.setAttribute("order", orderDTO);
            BigDecimal totalMoney = totalMoney(orderDTO);
            DecimalFormat df = new DecimalFormat("#,###");
            tongTien = df.format(totalMoney);
        }

        return tongTien;
    }

    public BigDecimal totalMoney(OrderDTO orderDTO) {
        BigDecimal totalMoney = new BigDecimal(0);
        List<OrderItemDTO> orderItems = orderDTO.getOrderItems();

        for (OrderItemDTO orderItem : orderItems) {
            BigDecimal donGia = orderItem.getSanPham().getDonGia();
            int number = orderItem.getNumber();
            BigDecimal soluong = new BigDecimal(number);
            totalMoney = totalMoney.add(donGia.multiply(soluong));
        }

        return totalMoney;
    }

}

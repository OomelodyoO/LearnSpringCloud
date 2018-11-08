package win.zhangzhixing.springcloudeurekaclientproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import win.zhangzhixing.springcloudeurekaclientproduct.service.ProductService;

@RestController
@RequestMapping("/ap1/v1//product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("list")
    public Object list() {
        return productService.listProduct();
    }

    @RequestMapping("find")
    public Object findById(@RequestParam("id") int id) {
        return productService.findById(id);
    }
}

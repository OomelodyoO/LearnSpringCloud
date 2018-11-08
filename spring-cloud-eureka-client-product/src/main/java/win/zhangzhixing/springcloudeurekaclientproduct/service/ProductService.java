package win.zhangzhixing.springcloudeurekaclientproduct.service;


import win.zhangzhixing.springcloudeurekaclientproduct.domain.Product;
import java.util.List;

public interface ProductService {
    List<Product> listProduct();

    Product findById(int id);
}

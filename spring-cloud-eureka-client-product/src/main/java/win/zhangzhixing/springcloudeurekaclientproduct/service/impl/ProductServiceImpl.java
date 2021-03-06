package win.zhangzhixing.springcloudeurekaclientproduct.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import win.zhangzhixing.springcloudeurekaclientproduct.domain.Product;
import win.zhangzhixing.springcloudeurekaclientproduct.service.ProductService;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public static Map<Integer, Product> daoMap = new HashMap<>();

    static {
        Product p1 = new Product(1, "iphonx", 9999, 10);
        Product p2 = new Product(2, "冰箱", 9999, 10);
        Product p3 = new Product(3, "洗衣机", 9999, 10);
        Product p4 = new Product(4, "电话", 9999, 10);
        Product p5 = new Product(5, "汽车", 9999, 10);
        Product p6 = new Product(6, "椅子", 9999, 10);
        Product p7 = new Product(7, "java编程思想", 9999, 10);

        daoMap.put(p1.getId(), p1);
        daoMap.put(p2.getId(), p2);
        daoMap.put(p3.getId(), p3);
        daoMap.put(p4.getId(), p4);
        daoMap.put(p5.getId(), p5);
        daoMap.put(p6.getId(), p6);
        daoMap.put(p7.getId(), p7);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(int id) {
        logger.info("service findById");
        return daoMap.get(id);
    }
}

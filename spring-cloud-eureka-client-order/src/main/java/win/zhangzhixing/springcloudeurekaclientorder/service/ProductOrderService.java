package win.zhangzhixing.springcloudeurekaclientorder.service;

import win.zhangzhixing.springcloudeurekaclientorder.domain.ProductOrder;

public interface ProductOrderService {
    ProductOrder save(int userId, int productId);
}

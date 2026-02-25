package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.payload.ProductDTO;
import com.ecommerce.sb_ecom.payload.ProductResponse;


public interface ProductService {

    ProductDTO addProduct(Long categoryId, ProductDTO product);

    ProductResponse getAllProduct();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchByKeyword(String keyword);

    ProductDTO updateProduct(ProductDTO product, Long productId);

    ProductDTO deleteProduct(Long productId);
}

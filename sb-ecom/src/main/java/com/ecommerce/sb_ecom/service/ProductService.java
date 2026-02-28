package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.payload.ProductDTO;
import com.ecommerce.sb_ecom.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface ProductService {

    ProductDTO addProduct(Long categoryId, ProductDTO product);

    ProductResponse getAllProduct(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    ProductResponse searchByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    ProductResponse searchByKeyword(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder,String keyword);

    ProductDTO updateProduct(ProductDTO product, Long productId);

    ProductDTO deleteProduct(Long productId);

    ProductDTO updateImage(Long productId, MultipartFile image) throws IOException;

}

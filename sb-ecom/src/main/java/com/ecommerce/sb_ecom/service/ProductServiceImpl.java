package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.exception.ResourceNotFoundException;
import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.payload.ProductDTO;
import com.ecommerce.sb_ecom.payload.ProductResponse;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import com.ecommerce.sb_ecom.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository ;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Long categoryId, ProductDTO productDTO) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));

        Product product = modelMapper.map(productDTO,Product.class);

        product.setImage("default.png");
        product.setCategory(category);
        double specialPrice = product.getPrice() -
                ((product.getDiscount() * 0.01) *product.getPrice());
        product.setSpecialPrice(specialPrice);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct,ProductDTO.class);
    }

    @Override
    public ProductResponse getAllProduct() {
       List<Product> products = productRepository.findAll();
       List<ProductDTO> productDTOS = products.stream()
               .map(product->modelMapper.map(product,ProductDTO.class))
               .toList();
       ProductResponse productResponse = new ProductResponse();
       productResponse.setContent(productDTOS);

        return productResponse;
    }

    @Override
    public ProductResponse searchByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));

        List<Product> products = productRepository.findByCategoryOrderByPriceAsc(category);


        List<ProductDTO> productDTOS = products.stream()
                .map(product->modelMapper.map(product,ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOS);

        return productResponse;
    }

    @Override
    public ProductResponse searchByKeyword(String keyword) {

        List<Product> products = productRepository.findByProductNameLikeIgnoreCase('%' + keyword+ '%');


        List<ProductDTO> productDTOS = products.stream()
                .map(product->modelMapper.map(product,ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOS);

        return productResponse;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long productId) {
        // Get Existing product from the database
        Product productFromDB = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("product","productId",productId));

        Product product = modelMapper.map(productDTO,Product.class);

        // Update the product info with the one in request body
        productFromDB.setProductName(product.getProductName());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setQuantity(product.getQuantity());
        productFromDB.setPrice(product.getPrice());
        productFromDB.setDiscount(product.getDiscount());
        productFromDB.setSpecialPrice(product.getSpecialPrice());

        Product savedProduct = productRepository.save(productFromDB);


        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO deleteProduct(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product","ProductId",productId));

        productRepository.delete(product);
        return modelMapper.map(product,ProductDTO.class);
    }
}

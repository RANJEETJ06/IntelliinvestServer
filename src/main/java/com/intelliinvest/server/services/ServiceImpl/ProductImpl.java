package com.intelliinvest.server.services.ServiceImpl;


import com.intelliinvest.server.entities.Product;
import com.intelliinvest.server.exceptions.ResourcesNotFoundException;
import com.intelliinvest.server.payloads.ProductDto;
import com.intelliinvest.server.repositories.ProductRepo;
import com.intelliinvest.server.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product saved=this.productRepo.save(this.DtoToProduct(productDto));
        return this.productToDto(saved);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product=this.productRepo.findById(productDto.getId()).orElseThrow(()->new ResourcesNotFoundException("Product","Product Id",productDto.getId()));
        product.setDesc(productDto.getDesc());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        return this.productToDto(this.productRepo.save(product));
    }

    @Override
    public void DeleteProduct(Integer id) {
        Product product=this.productRepo.findById(id).orElseThrow(()->new ResourcesNotFoundException("Product","Product Id",id));
        this.productRepo.delete(product);
    }
    public ProductDto productToDto(Product product){
        return this.modelMapper.map(product,ProductDto.class);
    }
    public Product DtoToProduct(ProductDto productDto){
        return this.modelMapper.map(productDto,Product.class);
    }
}

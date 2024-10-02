package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;

import vn.hoidanit.laptopshop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(long id);

}

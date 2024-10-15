package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

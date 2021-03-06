import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshopping.admindao.ProductRepository;
import com.onlineshopping.adminentity.Product;
import com.onlineshopping.adminexception.ProductNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Product addProduct(Product product) {
// TODO Auto-generated method stub
		return repository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
// TODO Auto-generated method stub
		Optional<Product> productDb = this.repository.findById(product.getId());

		if (productDb.isPresent()) {
			Product productUpdate = productDb.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setPrice(product.getPrice());
			return productUpdate;
		} else {
			throw new ProductNotFoundException("product not found with id :" + product.getId());
		}
	}

	@Override
	public List<Product> getAllproduct() {
// TODO Auto-generated method stub
		return (List<Product>) this.repository.findAll();
	}

	@Override
	public Product getProductById(long productId) {
// TODO Auto-generated method stub
		Optional<Product> productDb = this.repository.findById(productId);
		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			throw new ProductNotFoundException("product not found with id :" + productId);
		}
	}

	@Override
	public void deleteProduct(long productId) {
// TODO Auto-generated method stub
		Optional<Product> productDb = this.repository.findById(productId);
		if (productDb.isPresent()) {
			this.repository.delete(productDb.get());
		} else {
			throw new ProductNotFoundException("product not found with id :" + productId);
		}
	}
}
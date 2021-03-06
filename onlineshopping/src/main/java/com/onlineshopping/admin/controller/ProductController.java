import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.adminentity.Product;
import com.onlineshopping.adminservice.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/")
	public List<Product> getAllproduct() {
		System.out.println(service.getAllproduct());
		return service.getAllproduct();
	}

	@PostMapping("/add")
	public void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}

	@DeleteMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable(required = true) long productId) {
		service.deleteProduct(productId);
	}

	@GetMapping("/get/{productId}")
	public Product getProductById(@PathVariable(required = true) long productId) {
		return service.getProductById(productId);
	}

	@PostMapping("/update/{productId}")
	public void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
	/**
	 * ResponseEntity<List<Product>> getAllproduct(){ return
	 * ResponseEntity.ok().body(service.getAllproduct()); }
	 */

}
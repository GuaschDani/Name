package com.immune.tienda.controller;

import com.immune.tienda.entity.Product;
import com.immune.tienda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

   
    //Registra un nuevo usuario.
    @PostMapping("/registrar")
	public ModelAndView registerProduct(Product product, @RequestParam Integer rolID) throws Exception {
		
		try {	
            //Definimos la fecha de ceración y guardamos el producto.
            product.setLM();
			productService.registerProduct(product);

            //Devolvemos la página de create confirmando la creacion del producto.
            ModelAndView model = new ModelAndView("create");
            model.addObject("respuesta", false);
            model.addObject("rolID", rolID );
            return model;

        //En caso de que haya ocurrido un error delolvemos la paginad e update comunicando el error.
		} catch (Exception e) {
            ModelAndView model = new ModelAndView("create");
            model.addObject("respuesta", true);
            return model; 
		}
        
	}
    @PostMapping("/deleteProduct")
	public ModelAndView deleteProductByID(@RequestParam Integer rolID, @RequestParam Integer ID) throws Exception {
		
		try {	
            //Borramos el producto con el ID correspondiente.		
			productService.deleteProductByID(ID);

            //Devolvemos la página de delete y confirmamos que se ha eliminado.
            ModelAndView model = new ModelAndView("delete");
            model.addObject("respuesta", false);
            model.addObject("rolID", rolID );
            return model;

        //En caso de que haya ocurrido un error delolvemos la paginad e update comunicando el error.
		} catch (Exception e) {
            ModelAndView model = new ModelAndView("delete");
            model.addObject("respuesta", true);
            model.addObject("rolID", rolID );
            return model; 
		}  
	}	
   
    @PostMapping("/productByID")
    public ModelAndView productByID(@RequestParam Integer ID,@RequestParam Integer rolID){
        try {		
            //Devolvemos una página con todos los productos y sus datos	
            ModelAndView model = new ModelAndView("read");
            Product product = productService.findById(ID);
            //Sus datos
            model.addObject("products", productService.getProducts());
            model.addObject("respuesta", false);
            model.addObject("product", product);
            model.addObject("rolID", rolID );
            return model;

        //En caso de que haya ocurrido un error delolvemos la paginad e update comunicando el error.
		} catch (Exception e) {
            ModelAndView model = new ModelAndView("read");
            model.addObject("products", productService.getProducts());
            model.addObject("respuesta", true);
            model.addObject("rolID", rolID );
            return model; 
		}  
    }
     //Cuando se edita un producto
    @RequestMapping("/updateProduct")
    public ModelAndView updateProduct(@RequestParam Integer rolID, @RequestParam Integer ID, @RequestParam String newName, @RequestParam Integer newPrice ){
        try {		
            //Recogemos el producto por si ID y le cambiamos los valores.	
            Product product = productService.findById(ID);
            productService.updateProduct(product, newName, newPrice);
            
            //Devolvemos de nuevo la pantalla de update pero confirmando la edición
            ModelAndView model = new ModelAndView("update");
            model.addObject("respuesta", false);
            model.addObject("rolID", rolID );
            return model;
            
        //En caso de que haya ocurrido un error delolvemos la paginad e update comunicando el error.
		} catch (Exception e) {
            ModelAndView model = new ModelAndView("update");
            model.addObject("respuesta", true);
            model.addObject("rolID", rolID );
            return model; 
		}  
    }

    //Consulta que saca todos los productos. 
	@GetMapping("/getProducts")
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<Object>(productService.getProducts(), HttpStatus.OK);
	}
    //Para acceder al menu desde las funciones.
    @PostMapping("/menu")
    public ModelAndView menu1(@RequestParam Integer rolID){
        ModelAndView model = new ModelAndView("inicio");
        model.addObject("rolID", rolID );
        return model;
    }
	//Si el usuario quiere crear un producto.
    @PostMapping("/create")
    public ModelAndView create1(@RequestParam Integer rolID){
        ModelAndView model = new ModelAndView("create");
        model.addObject("rolID", rolID );
        return model;
    }
    //Si el usuario quiere editar un producto
    @PostMapping("/update")
    public ModelAndView update1(@RequestParam Integer rolID){
        ModelAndView model = new ModelAndView("update");
        model.addObject("rolID", rolID );
        return model;
    }

	//Si el usuario quiere eliminar un producto.
    @PostMapping("/delete")
    public ModelAndView deleteP(@RequestParam Integer rolID){
        ModelAndView model = new ModelAndView("delete");
        model.addObject("rolID", rolID );
        return model;
    } 
    //Intentamos controlar cualquier tipo de error general que pudiera generar.
    @GetMapping("/error")
    public ModelAndView error(){
        ModelAndView model = new ModelAndView("login");
        return model;
    } 
     //Si el usuario quiere ver todos los productos.
	@PostMapping("/read")
    public ModelAndView read(@RequestParam Integer rolID){
        ModelAndView model = new ModelAndView("read");
        model.addObject("products", productService.getProducts());
        model.addObject("rolID", rolID );
        return model;
    }
}
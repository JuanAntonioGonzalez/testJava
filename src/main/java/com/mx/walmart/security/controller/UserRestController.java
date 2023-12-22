package com.mx.walmart.security.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.walmart.request.AgregaProductoRequest;
import com.mx.walmart.request.Response;
import com.mx.walmart.security.JwtTokenUtil;
import com.mx.walmart.security.JwtUser;
import com.mx.walmart.security.model.Productos;
import com.mx.walmart.security.repository.ProductosRepository;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private ProductosRepository productoRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
    
    @RequestMapping(value = "user/listaProducto", method = RequestMethod.GET)
    public List<Productos> getListaProducto() {
        return productoRepository.findAll();
    }
    
    @RequestMapping(value = "user/agregaProducto", method = RequestMethod.POST)
    public Response addProduct(@RequestBody AgregaProductoRequest request) {
    	Response response = new Response();
    	try{
	    	Productos productoNuevo = new Productos();
	    	productoNuevo.setNombre(request.getNombre());
	    	productoNuevo.setDescription(request.getDescripcion());
	    	productoNuevo.setPrice(request.getPrecio());
	    	System.out.println("precio " + request.getPrecio());
	    	productoRepository.save(productoNuevo);
	    	response.setMessage("Producto Agregado");
    	}catch(Exception e){
    		response.setMessage("Error al agregar " + e.getMessage());
    	}
        return response;
    }
    
//    @RequestMapping(value = "user/listaProducto", method = RequestMethod.GET)
//    public List<Productos> getListaProducto() {
//        return productoRepository.findAll();
//    }

}

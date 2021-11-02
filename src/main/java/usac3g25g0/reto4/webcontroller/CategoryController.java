package usac3g25g0.reto4.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import usac3g25g0.reto4.model.Category;
import usac3g25g0.reto4.service.ImplementsCategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    
    @Autowired
    ImplementsCategoryService serviciosCategoria;

    @GetMapping("/all")
    public List<Category> listadoCategorias() {
        return serviciosCategoria.listarCategorias();              
    }

    @GetMapping("/{id}")
    public Optional<Category> detalleCategoria(@PathVariable("id") Integer id){
        return serviciosCategoria.listarCategoriaId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Category anadirCategoria(@RequestBody Category categoria){
        return serviciosCategoria.crearCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCategoria(@PathVariable("id") Integer id){
        return serviciosCategoria.borrarCategoria(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category actualizarCategoria(@RequestBody Category categoria){
        return serviciosCategoria.actualizaCategoria(categoria);
    }
}

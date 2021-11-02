package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import usac3g25g0.reto4.model.Category;

@Component
public interface CategoryService {

    public List<Category> listarCategorias();
    public Optional<Category> listarCategoriaId(Integer id);
    public Category crearCategoria(Category categoria);
    public boolean borrarCategoria(Integer id);
    public Category actualizaCategoria(Category categoria);
}

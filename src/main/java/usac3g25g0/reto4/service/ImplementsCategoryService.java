package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usac3g25g0.reto4.model.Category;
import usac3g25g0.reto4.repository.CategoryRepository;

@Service
public class ImplementsCategoryService implements CategoryService{
    
    @Autowired
    CategoryRepository repositorioCategoria;

    @Override
    public List<Category> listarCategorias() {
        return (List<Category>) repositorioCategoria.findAll();
    }

    @Override
    public Optional<Category> listarCategoriaId(Integer id) {
        return repositorioCategoria.findById(id);
    }

    @Override
    public Category crearCategoria(Category categoria) {
        return repositorioCategoria.save(categoria);
    }

    @Override
    public boolean borrarCategoria(Integer id) {
        boolean estado=true;
        if (repositorioCategoria.findById(id).isPresent()){
            repositorioCategoria.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }
    
    @Override
    public Category actualizaCategoria(Category categoria){
        if (repositorioCategoria.findById(categoria.getId()).isPresent()){
            
            Optional<Category> categoriaCopia = repositorioCategoria.findById(categoria.getId());

            if(categoria.getName()!=categoriaCopia.get().getName()
                &&categoria.getName()!=null){
                    categoriaCopia.get().setName(categoria.getName());
                }
            
            if(categoria.getDescription()!=categoriaCopia.get().getDescription()
                &&categoria.getDescription()!=null){
                    categoriaCopia.get().setDescription(categoria.getDescription());
                }

            return repositorioCategoria.save(categoriaCopia.get());
        }
        else{
            return null;
        }    
    }

    /**
    @Override
    public Client crearCategoria(Category categoria) {
        // TODO Auto-generated method stub
        return null;
    }
    */

}

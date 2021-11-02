package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usac3g25g0.reto4.model.Costume;
import usac3g25g0.reto4.repository.CostumeRepository;

@Service
public class ImplementsCostumeService implements CostumeService{
 
    @Autowired
    CostumeRepository repositorioDisfraz;

    @Override
    public List<Costume> listarDisfraces() {
        return (List<Costume>) repositorioDisfraz.findAll();
    }

    @Override
    public Optional<Costume> listarDisfrazId(Integer id) {
        return repositorioDisfraz.findById(id);
    }

    @Override
    public Costume crearDisfraz(Costume disfraz) {
        return repositorioDisfraz.save(disfraz);
    }

    @Override
    public boolean borrarDisfraz(Integer id) {
        boolean estado=true;
        if (repositorioDisfraz.findById(id).isPresent()){
            repositorioDisfraz.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Costume actualizaDisfraz(Costume disfraz) {

        if (repositorioDisfraz.findById(disfraz.getId()).isPresent()){

            Optional<Costume> disfrazCopia = repositorioDisfraz.findById(disfraz.getId());
            
            if(disfraz.getName()!=disfrazCopia.get().getName()
                &&!disfraz.getName().isEmpty()){
                    disfrazCopia.get().setName(disfraz.getName());
                }
                
            if(disfraz.getBrand()!=disfrazCopia.get().getBrand()
                &&!disfraz.getBrand().isEmpty()){
                    disfrazCopia.get().setBrand(disfraz.getBrand());
                }

            if(disfraz.getYear()!=disfrazCopia.get().getYear()
                &&disfraz.getYear()!=null){
                    disfrazCopia.get().setYear(disfraz.getYear());
                }

            if(disfraz.getDescription()!=disfrazCopia.get().getDescription()
                &&!disfraz.getDescription().isEmpty()){
                    disfrazCopia.get().setDescription(disfraz.getDescription());
                }

            return repositorioDisfraz.save(disfrazCopia.get());
        }
        else{
            return null;
        }
    }

    /** 
    @Override
    public Costume crearDisfraz(Costume disfraz) {
        // TODO Auto-generated method stub
        return null;
    }
    */

}

package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usac3g25g0.reto4.model.Client;
import usac3g25g0.reto4.repository.ClientRepository;

@Service
public class ImplementsClientService implements ClientService{
    
    @Autowired
    ClientRepository repositorioCliente;
    
    @Override
    public List<Client> listarClientes() {
        return (List<Client>) repositorioCliente.findAll();
    }

    @Override
    public Optional<Client> listarClienteId(Integer id) {
        return repositorioCliente.findById(id);
    }

    @Override
    public Client crearCliente(Client cliente) {
        return repositorioCliente.save(cliente);
    }

    @Override
    public boolean borrarCliente(Integer id) {
        boolean estado=true;
        if (repositorioCliente.findById(id).isPresent()){
            repositorioCliente.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Client actualizaCliente(Client cliente) {

        if (repositorioCliente.findById(cliente.getIdClient()).isPresent()){
            
            Optional<Client> clienteCopia = repositorioCliente.findById(cliente.getIdClient());

            if(cliente.getName()!=clienteCopia.get().getName()
                &&cliente.getName()!=null){
                    clienteCopia.get().setName(cliente.getName());
                }
            
            if(cliente.getEmail()!=clienteCopia.get().getEmail()
                &&cliente.getEmail()!=null){
                    clienteCopia.get().setEmail(cliente.getEmail());
                }

            if(cliente.getPassword()!=clienteCopia.get().getPassword()
                &&cliente.getPassword()!=null){
                    clienteCopia.get().setPassword(cliente.getPassword());
                }
            
            if(cliente.getAge()!=clienteCopia.get().getAge()
                &&cliente.getAge()!=null){
                    clienteCopia.get().setAge(cliente.getAge());
            }

            return repositorioCliente.save(clienteCopia.get());
        }
        else{
            return null;
        }
    }

}
package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import usac3g25g0.reto4.model.Client;

@Component
public interface ClientService {

    public List<Client> listarClientes();
    public Optional<Client> listarClienteId(Integer id);
    public Client crearCliente(Client cliente);
    public boolean borrarCliente(Integer id);
    public Client actualizaCliente(Client cliente);
}
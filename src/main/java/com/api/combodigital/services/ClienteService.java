package com.api.combodigital.services;

import com.api.combodigital.entities.Cliente;
import com.api.combodigital.entities.Suscripcion;
import com.api.combodigital.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listaClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarCliente(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Collection<Suscripcion> buscarSuscripcionCliente(Long id) {
        return  clienteRepository.findById(id).get().getSuscripciones();
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

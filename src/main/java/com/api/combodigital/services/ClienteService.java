package com.api.combodigital.services;

import com.api.combodigital.entities.Cliente;
import com.api.combodigital.entities.Suscripcion;
import com.api.combodigital.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    @Transactional
    public List<Cliente> listaClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Cliente> buscarCliente(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional
    public Collection<Suscripcion> buscarSuscripcionCliente(Long id) {
        return  clienteRepository.findById(id).get().getSuscripciones();
    }

    @Override
    @Transactional
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente editarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

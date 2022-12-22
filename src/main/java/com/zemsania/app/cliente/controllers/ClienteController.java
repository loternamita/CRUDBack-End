package com.zemsania.app.cliente.controllers;

import com.zemsania.app.cliente.dto.ClienteCreateDto;
import com.zemsania.app.cliente.entity.Cliente;
import com.zemsania.app.cliente.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zemsania.app.cliente.dto.ClienteDto;
import com.zemsania.app.cliente.exceptions.response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, maxAge = 3600, originPatterns = "true")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public List<Cliente> listarAll() {
        return clienteService.findAll();
    }

    @GetMapping(value = "/listarTipoAndNumero", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> buscarTipoAndNumero(@RequestParam(name = "tipoCedula") String tipoCedula, @RequestParam(name = "numeroCedula") String numeroCedula) {

        log.info("Log tipoCedula: " + tipoCedula + " numeroCedula: " + numeroCedula);
        try {
            if ("C".equals(tipoCedula) || "P".equals(tipoCedula)) {

                Cliente entity = clienteService.findByNumeroAndTipo(tipoCedula, numeroCedula);
                ClienteDto dto = new ClienteDto(entity);
                return new ResponseEntity<>(new response(200, "Se consulto exitosamente", dto), HttpStatus.OK);

            } else {

                return new ResponseEntity<>(
                        new response(400, "No se permite esta tipologia en el tipo cedula: " + tipoCedula),
                        HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException npex) {
            return new ResponseEntity<>(new response(404, "No se encontro el cliente con cedula: " + numeroCedula), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(new response(500, "Internal Server Error: " + ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/crearCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> crearCliente(@Valid @RequestBody Cliente request) {

        log.info("Log request Body cliente:" + request);
        try {

            Cliente entity = clienteService.saveClient(request);
            ClienteCreateDto dto = new ClienteCreateDto(entity);
            return new ResponseEntity<>(new response(200, "El cliente " + dto.getNumeroCedula() +" se agrego exitosamente",dto), HttpStatus.OK);

        } catch (NullPointerException npex) {
            return new ResponseEntity<>(new response(404, "No se pudo crear el cliente: " + npex ), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(new response(500, "Internal Server Error: " + ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(value = "/actualizarCliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> updateCliente(@Valid @RequestBody Cliente request, @PathVariable("id") Long id) {

        log.info("Log request Body cliente:" + request);
        try {
            Cliente entity = clienteService.updateClient(request, id);
            ClienteCreateDto dto = new ClienteCreateDto(entity);
            return new ResponseEntity<>(new response(200, "El cliente " + dto.getNumeroCedula() +" se actualizo exitosamente",dto), HttpStatus.OK);

        } catch (NullPointerException npex) {
            return new ResponseEntity<>(new response(404, "No se pudo crear el cliente: " + npex ), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(new response(500, "Internal Server Error: " + ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @DeleteMapping(value = "/eliminarCliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> updateCliente(@PathVariable("id") Long id) {

        log.info("Log request Body cliente:" + id);
        try {
            clienteService.deleteClient(id);
            return new ResponseEntity<>(new response(200, "El cliente se elimino exitosamente"), HttpStatus.OK);
        } catch (NullPointerException npex) {
            return new ResponseEntity<>(new response(404, "No se pudo crear el cliente: " + npex ), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(new response(500, "Internal Server Error: " + ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

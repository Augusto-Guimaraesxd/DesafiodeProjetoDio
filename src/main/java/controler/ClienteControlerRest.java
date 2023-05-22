package controler;

import model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClienteService;

public class ClienteControlerRest {

    private ClienteService clienteService;
    public ResponseEntity<Iterable<Cliente>>buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Cliente>inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping
    public ResponseEntity<Cliente>atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id,cliente);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

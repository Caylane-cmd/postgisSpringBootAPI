
package br.com.example.controller;

import br.com.example.model.EixoRodoviario;
import br.com.example.model.EixoRodoviarioVO;
import br.com.example.repository.EixoRodoviarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eixos-rodoviarios")
public class EixoRodoviarioController {

    @Autowired
    private EixoRodoviarioRepository eixoRodoviarioRepository;

    @GetMapping("/tipo/{tipo}")
    public List<EixoRodoviario> buscarPorTipoPavimento(@PathVariable String tipo) {
        return eixoRodoviarioRepository.findByTipoPavimento(tipo);
    }

    @GetMapping("/codigo/{codigo}")
    public List<EixoRodoviario> buscarPorCodigo(@PathVariable String codigo) {
        return eixoRodoviarioRepository.findByCodigo(codigo);
    }

    @GetMapping("/descricao/{descricao}")
    public List<EixoRodoviario> buscarPorDescricao(@PathVariable String descricao) {
        return eixoRodoviarioRepository.findByDescricaoSegmentoContainingIgnoreCase(descricao);
    }

    @GetMapping("/objectid-maior-que/{objectid}")
    public List<EixoRodoviario> buscarPorObjectid(@PathVariable Integer objectid) {
        return eixoRodoviarioRepository.findByObjectidGreaterThan(objectid);
    }

    @GetMapping("/tipo-vo/{tipo}")
    public List<EixoRodoviarioVO> buscarPorTipoComVO(@PathVariable String tipo) {
        return eixoRodoviarioRepository.buscarPorTipoPavimento(tipo);
    }
}


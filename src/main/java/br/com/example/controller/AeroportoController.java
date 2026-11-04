
package br.com.example.controller;

import br.com.example.model.Aeroporto;
import br.com.example.model.AeroportoVO;
import br.com.example.repository.AeroportoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @GetMapping("/uf/{uf}")
    public List<Aeroporto> buscarPorUf(@PathVariable String uf) {
        return aeroportoRepository.findByUf(uf);
    }

    @GetMapping("/municipio/{municipio}")
    public List<Aeroporto> buscarPorMunicipio(@PathVariable String municipio) {
        return aeroportoRepository.findByMunicipioContainingIgnoreCase(municipio);
    }

    @GetMapping("/estado/{nomeUf}")
    public List<Aeroporto> buscarPorNomeUf(@PathVariable String nomeUf) {
        return aeroportoRepository.findByNomeUf(nomeUf);
    }

    @GetMapping("/passageiros/{quantidade}")
    public List<AeroportoVO> buscarPorMovimentoDePassageiros(
            @PathVariable Double quantidade) {
        return aeroportoRepository.buscarPorMovimentoDePassageiros(quantidade);
    }

    @GetMapping("/maiores-movimentos")
    public List<Aeroporto> buscarCincoMaioresMovimentos() {
        return aeroportoRepository.findTop5ByOrderByPassageiros2010Desc();
    }
}


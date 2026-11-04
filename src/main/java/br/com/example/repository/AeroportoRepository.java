
package br.com.example.repository;

import br.com.example.model.Aeroporto;
import br.com.example.model.AeroportoVO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer> {

    List<Aeroporto> findByUf(String uf);

    List<Aeroporto> findByMunicipioContainingIgnoreCase(String municipio);

    List<Aeroporto> findByNomeUf(String nomeUf);

    @Query("SELECT new br.com.example.model.AeroportoVO(a.municipio, a.uf, a.nomeUf, a.passageiros2010, a.geometria) " +
           "FROM Aeroporto a WHERE a.passageiros2010 > :quantidade")
    List<AeroportoVO> buscarPorMovimentoDePassageiros(Double quantidade);

    List<Aeroporto> findTop5ByOrderByPassageiros2010Desc();
}


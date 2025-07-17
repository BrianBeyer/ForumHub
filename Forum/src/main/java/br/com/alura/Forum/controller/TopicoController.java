package br.com.alura.Forum.controller;

import br.com.alura.Forum.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public void cadastrarTopico(@RequestBody @Valid DadosTopico dadosTopico){
        topicoRepository.save(new Topico(dadosTopico));
    }

    @GetMapping
    public List<DadosListagemTopicos> listar(){
        return topicoRepository.findAll().stream().map(DadosListagemTopicos::new).toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable("id") Long id){
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dadosAtualizacaoTopico) {
        var topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacoes(dadosAtualizacaoTopico);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTopico(@PathVariable("id") Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

//Os dados do tópico (título, mensagem, autor e curso) devem ser enviados no corpo da requisição, no formato JSON.
//Sugestão: para auxiliar na validação dos dados, experimente utilizar a anotação Java integrada ao Spring @Valid.
//
//Regras de negócio
//Todos os campos são obrigatórios, nesse caso, é necessário realizar a verificação se todos os campos estão sendo inseridos corretamente.
//
//A API não deve permitir o cadastro de tópicos duplicados (contendo o mesmo título e mensagem).
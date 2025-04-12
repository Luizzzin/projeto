package com.escola.projeto.service;
import com.escola.projeto.model.Aluno;
import com.escola.projeto.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    //Metodo para cadastrar aluno

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    //metodo para buscar
    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    //buscar por ID
    public Optional<Aluno> buscarPorId(Long id){
        return alunoRepository.findById(id);
    }

    //atualizar (update)
    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado){
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNomeAluno(alunoAtualizado.getNomeAluno());
                    aluno.setIdadeAluno(alunoAtualizado.getIdadeAluno());
                    aluno.setMatriculaAluno(alunoAtualizado.getMatriculaAluno());
                    return alunoRepository.save(aluno);
                })
                .orElseThrow(() ->new RuntimeException("Aluno não encontrado com o ID" + id));
    }

    //exclui
    public void deletarPorId(Long id){
        alunoRepository.deleteById(id);
    }
}

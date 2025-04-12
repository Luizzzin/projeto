package com.escola.projeto.service;

import com.escola.projeto.model.Aluno;
import com.escola.projeto.model.Professor;
import com.escola.projeto.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    //inserir
    public Professor salvarProfessor(Professor professor){
        return professorRepository.save(professor);
    }
    public List<Professor> listarTodos(){
        return professorRepository.findAll();
    }
    //buscar por ID
    public Optional<Professor> buscarPorId(Long id){
        return professorRepository.findById(id);
    }

    public Professor atualizarProfessor(Long id, Professor professorAtualizado){
        return professorRepository.findById(id)
                .map(aluno -> {
                    aluno.setNomeAluno(alunoAtualizado.getNomeAluno());
                    aluno.setIdadeAluno(alunoAtualizado.getIdadeAluno());
                    aluno.setMatriculaAluno(alunoAtualizado.getMatriculaAluno());
                    return alunoRepository.save(aluno);
                })
                .orElseThrow(() ->new RuntimeException("Aluno não encontrado com o ID" + id));
    }
}

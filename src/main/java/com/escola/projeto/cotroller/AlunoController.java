package com.escola.projeto.cotroller;

import com.escola.projeto.model.Aluno;
import com.escola.projeto.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    //Listar Todos(READ)
    @GetMapping
    public String listarAlunos(Model model) {
        List<Aluno> alunos = alunoService.listarTodos();
        model.addAttribute("alunos", alunos);
        return ("alunos/lista");
    }

    //criando formulario para novo aluno(Create)
    @GetMapping("/novo")
    public String novoAlunoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/form";
    }

    //editar aluno (Edit)
    @GetMapping("/editar/{id}")
    public String editarAlunoForm(@PathVariable Long id, Model model) {

        Aluno aluno = alunoService.buscarPorId(id)
                .orElseThrow(() -> new
                        RuntimeException("Aluno não encontrado com o ID" + id));

        model.addAttribute("aluno", aluno);
        return "aluno/form";
    }

    //atualizar aluno
    @GetMapping("/atualizar/{id}")
    public String atualizarAlunos(@PathVariable Long id, @ModelAttribute Aluno aluno) {
        alunoService.atualizarAluno(id, aluno);
        return "redirect:/alunos";
    }
    //salvar
    @GetMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        alunoService.salvarAluno(aluno);
        return "redirect:/alunos";
    }

    //deletar
    @GetMapping("/deletar/{id}")
    public String atualizarAlunos(@PathVariable Long id) {
        alunoService.deletarPorId(id);
        return "redirect:/alunos";
    }


}

package com.escola.projeto.cotroller;

import com.escola.projeto.model.Aluno;
import com.escola.projeto.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    //Listar Todos(READ)
    @GetMapping
    public String listarAlunos(Model model){
        List<Aluno> alunos = alunoService.listarTodos();
        model.addAttribute("alunos", alunos);
        return ("alunos/lista");

    }

}

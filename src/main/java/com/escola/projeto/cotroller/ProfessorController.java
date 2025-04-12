package com.escola.projeto.cotroller;

import com.escola.projeto.model.Professor;
import com.escola.projeto.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService ProfessorService;

    //Listar Todos(READ)
    @GetMapping
    public String listarProfessores(Model model) {
        List<Professor> professors = ProfessorService.listarTodos();
        model.addAttribute("professores", professors);
        return ("professores/lista");
    }

    //criando formulario para novo professor(Create)
    @GetMapping("/novo")
    public String novoProfessorForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/form";
    }

    //editar professor (Edit)
    @GetMapping("/editar/{id}")
    public String editarProfesssorForm(@PathVariable Long id, Model model) {

        Professor professor = ProfessorService.buscarPorId(id)
                .orElseThrow(() -> new
                        RuntimeException("professor não encontrado com o ID" + id));

        model.addAttribute("professor", professor);
        return "professor/form";
    }

    //atualizar professor
    @GetMapping("/atualizar/{id}")
    public String atualizarProfessores(@PathVariable Long id, @ModelAttribute Professor professor) {
        ProfessorService.atualizarProfessor(id, professor);
        return "redirect:/professores";
    }
    //salvar
    @GetMapping("/salvar")
    public String salvarProfessor(@ModelAttribute Professor professor) {
        ProfessorService.salvarProfessor(professor);
        return "redirect:/professores";
    }

    //deletar
    @GetMapping("/deletar/{id}")
    public String atualizarProfessores(@PathVariable Long id) {
        ProfessorService.deletarProfessor(id);
        return "redirect:/professores";
    }


}

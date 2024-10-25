package com.ufrn.imd.Web2Atividade2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstoqueController {

    private List<Item> itens = new ArrayList<>();

    @GetMapping("/user/estoque")
    public String listarEstoque(Model model) {
        model.addAttribute("itens", itens);
        return "estoque";
    }

    @GetMapping("/admin/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("item", new Item());
        return "cadastro";
    }

    @PostMapping("/admin/cadastrar")
    public String cadastrarItem(@ModelAttribute Item item) {
        itens.add(item);
        return "redirect:/user/estoque";
    }

    // Implementar lógica para editar e remover itens
}

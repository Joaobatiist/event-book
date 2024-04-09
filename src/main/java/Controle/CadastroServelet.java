package Controle;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dados.Armazena;
import BancoDeDados.Inserir;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter os dados do formulário
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");

        // Criar um objeto Armazena
        Armazena armazena = new Armazena();
        armazena.setCpf(cpf);
        armazena.setEmail(email);
        armazena.setNome(nome);
        armazena.setSenha(senha);
        armazena.setTelefone(telefone);

        // Inserir os dados no banco de dados
        Inserir inserir = new Inserir();
        inserir.inserirCadastro(Armazena.arm);

        // Responder ao frontend
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Cadastro realizado com sucesso!");
    }
}

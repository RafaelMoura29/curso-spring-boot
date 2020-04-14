package io.github.rafaelmoura29;

import io.github.rafaelmoura29.domain.entity.Cliente;
import io.github.rafaelmoura29.domain.repositories.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando");
            clientes.save( new Cliente( "Rafael"));
            clientes.save(new Cliente( "Outro Cliente"));

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Verificando se cliente existe");
            System.out.println(clientes.existsByNome(("Rafael")));

            System.out.println("Atualizando");

            todosClientes.forEach(c ->{
                c.setNome(c.getNome() + " atualizado");
                clientes.save(c);
            });
            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando por nome");
            List<Cliente> result = clientes.encontrarPorNome("Rafael");
            result.forEach(System.out::println);

            System.out.println("Deletando");
            clientes.findAll().forEach(c ->{
                clientes.delete(c);
            });

            todosClientes = clientes.findAll();

            if (todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else{
                todosClientes.forEach(System.out::println);
            }


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

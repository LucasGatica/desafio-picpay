package com.gatica.desafio.picpay.livros.repository;


import com.gatica.desafio.picpay.livros.model.livro.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String> {
}

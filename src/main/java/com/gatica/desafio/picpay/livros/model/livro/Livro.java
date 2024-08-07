package com.gatica.desafio.picpay.livros.model.livro;


import com.gatica.desafio.picpay.livros.utils.pdfUtils.PdfUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Livro {
    @Id
    private String id;
    private String capa;
    private String autor;
    private String titulo;
    private String texto;
    private String keyWords;
    private int posicaoAtual;
    private int quantidadePaginas;
    private int tamanhoPosicao;

    private PdfUtils pdfUtils;


    public Livro(String path) {
        try {
            this.pdfUtils = new PdfUtils(path);
            this.capa = pdfUtils.gerarCapa();
            this.titulo = pdfUtils.getTitulo();
        }catch (Exception ignored){
        }
    }
}

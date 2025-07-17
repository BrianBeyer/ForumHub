package br.com.alura.Forum;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Embeddable
@Getter
public class Data {
    private LocalDateTime data;
    private String dataFormatada;

    public Data() {
        this.data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataFormatada = this.data.format(formatter);
    }
}

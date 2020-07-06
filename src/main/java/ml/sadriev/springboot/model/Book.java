package ml.sadriev.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "table_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(length = 60, unique = true, updatable = false, nullable = false)
    private String name;

    @Column(length = 60, unique = false, updatable = false, nullable = false)
    private String author;

    @Column(unique = false, updatable = true, nullable = false)
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
}
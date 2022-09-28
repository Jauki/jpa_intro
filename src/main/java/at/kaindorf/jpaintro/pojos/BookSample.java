package at.kaindorf.jpaintro.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSample {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_sample_id", nullable = false)
    private Long bookSampleId;

    @ManyToOne
    @JoinColumn(name = "bookid")
    private Book book;
}

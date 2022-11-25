package free.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "book")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "book_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "nxb_id")
    private NXB nxb;

//    @ManyToMany(mappedBy = "memberBook")
//    private Set<Member> member;

}

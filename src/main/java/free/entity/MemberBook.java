package free.entity;

import javax.persistence.*;

@Entity
@Table(name = "member_book")
public class MemberBook {

    @EmbeddedId
    private MemberBookPK id;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

//    @Id
//    private Long bookId;
//
//    @Id
//    private Long memberId;
}

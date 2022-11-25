package free.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MemberBookPK implements Serializable {
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "book_id")
    private Long bookId;

}

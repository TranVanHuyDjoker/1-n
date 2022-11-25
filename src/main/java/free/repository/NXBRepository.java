package free.repository;

import free.entity.NXB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NXBRepository extends JpaRepository<NXB, Long> {
    boolean existsNXBByName(String name);

    boolean existsNXBById(Long id);
}

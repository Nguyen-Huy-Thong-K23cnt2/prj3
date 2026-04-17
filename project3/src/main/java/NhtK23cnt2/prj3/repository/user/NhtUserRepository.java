package NhtK23cnt2.prj3.repository.user;

import NhtK23cnt2.prj3.entity.user.NhtUser;
import NhtK23cnt2.prj3.entity.user.NhtUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhtUserRepository extends JpaRepository<NhtUser, Long> {

    List<NhtUser> findByRole(NhtUserRole role);

    Optional<NhtUser> findByEmail(String email);

    Optional<NhtUser> findByEmailAndPassword(String email, String password);
}

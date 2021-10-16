package apap.tugas.sielekthor.repository;

import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PembelianDB extends JpaRepository<PembelianModel, Long> {
    Optional<PembelianModel> findPembelianById(Long id);
    List<PembelianModel> findPembelianByMemberAndIsCash(MemberModel member, Boolean isCash);
}
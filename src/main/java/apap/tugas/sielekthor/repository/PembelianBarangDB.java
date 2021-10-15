package apap.tugas.sielekthor.repository;

import apap.tugas.sielekthor.model.PembelianBarangModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PembelianBarangDB extends JpaRepository<PembelianBarangModel, Long> {
    Optional<PembelianBarangModel> findPembelianBarangById(Long id);
}

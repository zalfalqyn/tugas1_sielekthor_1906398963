package apap.tugas.sielekthor.repository;

import apap.tugas.sielekthor.model.PembelianModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PembelianDB extends JpaRepository<PembelianModel, Long> {
    Optional<PembelianModel> findByIdPembelian(Long idPembelian);
}
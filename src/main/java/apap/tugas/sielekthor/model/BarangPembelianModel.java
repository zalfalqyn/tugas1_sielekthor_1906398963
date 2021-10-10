package apap.tugas.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "barangPembelian")

public class BarangPembelianModel {
    @NotNull
    @Column(nullable = false)
    private Integer quantity;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime tanggalGaransi;
}

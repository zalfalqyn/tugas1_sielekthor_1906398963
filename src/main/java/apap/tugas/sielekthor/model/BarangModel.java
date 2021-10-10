package apap.tugas.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "barang")

public class BarangModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(nullable = false)
    private String kodeBarang;

    @NotNull
    @Column(nullable = false)
    private Integer hargaBarang;

    @NotNull
    @Size(max = 15)
    @Column(nullable = false)
    private String merk;

    @NotNull
    @Column(nullable = false)
    private String deskripsiBarang;

    @NotNull
    @Column(nullable = false)
    private Integer stok;

    @NotNull
    @Column(nullable = false)
    private Integer jumlahGaransi;
}

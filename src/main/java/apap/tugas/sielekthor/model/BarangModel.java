package apap.tugas.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    //Relasi dengan TipeModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipe", referencedColumnName = "idTipe", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TipeModel tipe;
}

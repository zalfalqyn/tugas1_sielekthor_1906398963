package apap.tugas.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pembelian")

public class PembelianModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String namaAdmin;

    @NotNull
    @Column(nullable = false)
    private Integer total;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime tanggalPembelian;

    @NotNull
    @Column(nullable = false)
    private Boolean isCash;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String noInvoice;

    //Relasi dengan MemberModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "no_member", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MemberModel member;

    //Relasi dengan BarangPembelianModel
    @OneToMany(mappedBy = "pembelian", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BarangPembelianModel> listBarangPembelian;
}

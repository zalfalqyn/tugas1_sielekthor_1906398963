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
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "member")

public class MemberModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String namaMember;

    @NotNull
    @Column(nullable = false)
    private Integer jenisKelamin;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime tanggalPendaftaran;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime tanggalLahir;

    //Relasi dengan PembelianModel
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PembelianModel> listPembelian;
}

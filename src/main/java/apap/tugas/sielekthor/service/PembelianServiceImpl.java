package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianBarangModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.repository.PembelianDB;
import apap.tugas.sielekthor.repository.PembelianBarangDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.List;

@Service
@Transactional
public class PembelianServiceImpl implements PembelianService{
    @Autowired
    PembelianDB pembelianDB;
    @Autowired
    PembelianBarangDB pembelianBarangDB;
    @Autowired
    MemberService memberService;

    @Override
    public List<PembelianModel> getPembelianList() {
        return pembelianDB.findAll();
    }

    @Override
    public void generateInvoice(PembelianModel pembelian) {
        MemberModel member = memberService.getMemberById(pembelian.getMember().getId());
        String namaMember = member.getNamaMember().toUpperCase();
        int valFirstChar = ((int)namaMember.charAt(0) - 64) % 10;
        String namaMemberOrder = Integer.toString(valFirstChar);

        String namaAdmin = pembelian.getNamaAdmin();
        char lastCharNamaAdmin = namaAdmin.charAt(namaAdmin.length()-1);
        String lastNamaAdmin = String.valueOf(lastCharNamaAdmin).toUpperCase();

        LocalDateTime tglBeli = pembelian.getTanggalPembelian();
        Integer intTglBeli = tglBeli.getDayOfMonth();
        Integer intBulanBeli = tglBeli.getMonthValue();
        String strTglBeli = Integer.toString(intTglBeli);
        String strBulanBeli = Integer.toString(intBulanBeli);
        if(strBulanBeli.length()==1) {
            strBulanBeli = '0'+strBulanBeli;
        }

        String kodeBayar = "01";
        if(pembelian.getIsCash()) {
            kodeBayar = "02";
        }

        int tanggalXbulan = (intTglBeli+intBulanBeli)*5;
        String strTanggalXBulan = Integer.toString(tanggalXbulan);
        if(strTanggalXBulan.length()==2) {
            strTanggalXBulan='0'+strTanggalXBulan;
        }

        int rand1 = new Random().nextInt(24) + 65;
        int rand2 = new Random().nextInt(24) + 65;
        String randomLetter = String.valueOf(Character.toChars(rand1)) + String.valueOf(Character.toChars(rand2));

        String noInvoice = namaMemberOrder + lastNamaAdmin + strTglBeli + strBulanBeli + kodeBayar + strTanggalXBulan + randomLetter;
        pembelian.setNoInvoice(noInvoice);
    }

    @Override
    public PembelianModel getPembelianById(Long id) {
        return pembelianDB.getById(id);
    }

    @Override
    public void addPembelian(PembelianModel pembelian) {
        int totalHarga = 0;
        List<PembelianBarangModel> allBarangPembelian = pembelian.getListPembelianBarang();
        pembelian.setTanggalPembelian(LocalDateTime.now());

        for(PembelianBarangModel barangPembelian: allBarangPembelian) {
            Integer jmlGaransi = barangPembelian.getBarang().getJumlahGaransi();
            LocalDateTime tglGaransi = pembelian.getTanggalPembelian().plusDays(jmlGaransi);
            barangPembelian.setTanggalGaransi(tglGaransi);

            int hargaBarang = barangPembelian.getBarang().getHargaBarang();
            totalHarga += barangPembelian.getQuantity() * hargaBarang;

            barangPembelian.setPembelian(pembelian);
        }


        pembelian.setTotal(totalHarga);
        generateInvoice(pembelian);
        pembelianDB.save(pembelian);
    }

    @Override
    public Integer getTotalPembelian(PembelianModel pembelian) {
        List<PembelianBarangModel> listPembelianBarang = pembelian.getListPembelianBarang();
        Integer totalHarga = 0;
        for (PembelianBarangModel pembelianBarang: listPembelianBarang) {
            Integer qty = pembelianBarang.getQuantity();
            Integer harga = pembelianBarang.getBarang().getHargaBarang();
            totalHarga += qty*harga;
        }
        return totalHarga;
    }

    @Override
    public void deletePembelian(PembelianModel pembelian){
        pembelian.getMember().getListPembelian().remove(pembelian);
        pembelianDB.delete(pembelian);
    }

    @Override
    public List<PembelianModel> getPembelianListFilter(Long idMember, Boolean isCash){
        MemberModel member = memberService.getMemberById(idMember);
        return pembelianDB.findPembelianByMemberAndIsCash(member, isCash);
    }
}

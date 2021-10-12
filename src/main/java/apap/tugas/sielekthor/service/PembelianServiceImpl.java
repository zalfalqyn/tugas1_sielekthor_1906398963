package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.repository.PembelianDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.List;

@Service
@Transactional
public class PembelianServiceImpl implements PembelianService{
    @Autowired
    PembelianDB pembelianDB;

    @Override
    public List<PembelianModel> getPembelianList() {
        return pembelianDB.findAll();
    }

    @Override
    public void generateInvoice(PembelianModel pembelian) {
        String namaAdmin = pembelian.getNamaAdmin().toUpperCase();

        int valFirstChar = ((int)namaAdmin.charAt(0) - 64) % 10;
        String namaAdminOrder = Integer.toString(valFirstChar);

        char lastCharNamaAdmin = namaAdmin.charAt(namaAdmin.length()-1);
        String lastNamaAdmin = String.valueOf(lastCharNamaAdmin);

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

        String sumTanggalBulan = Integer.toString(intTglBeli+intBulanBeli);
        if(sumTanggalBulan.length()==2) {
            sumTanggalBulan='0'+sumTanggalBulan;
        }

        int rand1 = new Random().nextInt(24) + 65;
        int rand2 = new Random().nextInt(24) + 65;
        String randomLetter = String.valueOf(Character.toChars(rand1)) + String.valueOf(Character.toChars(rand2));

        String noInvoice = namaAdminOrder + lastNamaAdmin + strTglBeli + strBulanBeli + kodeBayar + sumTanggalBulan + randomLetter;
        pembelian.setNoInvoice(noInvoice);
    }
}

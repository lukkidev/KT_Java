import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GiaoDich {
	String maGiaoDich = "";
	double donGia = 0;
	double dienTich = 0;
	Date ngayGiaoDich = null;

	GiaoDich(String _maGiaoDich, double _donGia, double _dienTich, String _ngayGiaoDich) {
		maGiaoDich = _maGiaoDich;
		donGia = _donGia;
		dienTich = _dienTich;
		try {
			ngayGiaoDich = new SimpleDateFormat("dd/MM/yyyy").parse(_ngayGiaoDich);
		} catch (ParseException ex) { // trường hợp người dùng nhập vào định dạng ngày không hợp lệ sẽ không báo ra đây
			System.out.println("Lỗi định dạng ngày");

		}
	}
	
	double thanhTien() {
		return 0;
	}

}


public class GiaoDichNha extends GiaoDich {

	int loaiNha = 0; // "1" là nhà thường "2" là nhà cao cấp
	String diaChi = "";

	GiaoDichNha(String _maGiaoDich, double _donGia, double _dienTich, String _ngayGiaoDich, int _loaiNha,
			String _diaChi) {
		super(_maGiaoDich, _donGia, _dienTich, _ngayGiaoDich);
		loaiNha = _loaiNha;
		diaChi = _diaChi;
	}

	double thanhTien() {
		if (loaiNha == 1) {
			return dienTich * donGia;
		}else if(loaiNha == 2) {
			return dienTich * donGia * 0.9;
		}
		return 0; // Lỗi: không phải nhà thường với cao cấp
	}

}

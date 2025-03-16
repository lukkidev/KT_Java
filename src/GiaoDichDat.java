
public class GiaoDichDat extends GiaoDich{

	String loaiDat = "";
	GiaoDichDat(String _maGiaoDich, double _donGia, double _dienTich, String _ngayGiaoDich,String _loaiDat) {
		super(_maGiaoDich, _donGia, _dienTich, _ngayGiaoDich);
		loaiDat = _loaiDat;
	}
	double ThanhTien() {
		if("B".equalsIgnoreCase(loaiDat) || "C".equalsIgnoreCase(loaiDat)) {
			return dienTich * donGia;
		}else if("A".equalsIgnoreCase(loaiDat)) {
			return dienTich * donGia * 1.5;
		}
		return 0; // Lỗi: không phải a,b,c
	}

}

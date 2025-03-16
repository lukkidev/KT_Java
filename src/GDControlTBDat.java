
public class GDControlTBDat {
	DSGDStorage storage;
	GDControlTBDat(){
		storage = new DSGDStorage();
	}
	void thanhTienGDD() {
		double tong = 0;
		int counts = 0;
		for (GiaoDichDat dat : storage.getGDDAT()) { 
			tong += dat.thanhTien(); 
			counts++;
		}
		if (counts > 0) {
			System.out.println("-Thành tiền của giao dịch đất: " + tong / counts);
		} else {
			System.out.println("Lỗi: Giao dịch đất chưa có dư liệu");
		}
	}

}

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GDControlGDThang {
	DSGDStorage storage;
	GDControlGDThang(){
		storage = new DSGDStorage();
	}
	
	void giaoDichThang(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner scan =new Scanner(System.in);
		System.out.println("----- XUẤT GIAO DỊCH THÁNG -----");
		System.out.println("Nhập tháng: ");
		String thang = scan.nextLine();
		System.out.println("Nhập tháng: ");
		System.out.println("VD: 1.Giao dịch nhà 2.Giao dịch đất \rChọn:");
		int choseMonth = scan.nextInt();
		if (choseMonth == 1) {
			for (GiaoDichDat frdat : storage.getGDDAT()) {
				// chuyển int thành string để so sánh với ngày giao dịch đã chuyển thành string
				// dùng split để lấy ra tháng cần vd: 15/05/2006 split("/")[1] thì sẽ lấy 05 và index [0] sẽ lấy 15
				// so sánh tháng người dùng nhập vào với tháng trong danh sách giao dịch đất
				String ngayStr = sdf.format(frdat.ngayGiaoDich); // chuyển Date thành string để tách lấy tháng
				String[] tachNgay = ngayStr.split("/"); // tách ra thành ngày,tháng, năm
				if (tachNgay.length >= 2) { // kiểm tra đúng địng dạng ngày không
					if (tachNgay[1].contentEquals(thang)) {
						System.out.println("Giao dịch tháng (" + choseMonth + ") - ngày(" +tachNgay[0]+ ") là: "+ frdat.thanhTien());
					}
				} else {
					System.out.println("Không tìm thấy tháng: " + thang);
				}				
			}

		}else if (choseMonth == 2) {
			for (GiaoDichNha frNha : storage.getGDNHA()) {
				String ngayStr = sdf.format(frNha.ngayGiaoDich); // chuyển Date thành string để tách lấy tháng
				String[] tachNgay = ngayStr.split("/"); // tách ra thành ngày,tháng, năm
				if (tachNgay.length >= 2) { // kiểm tra đúng địng dạng ngày không
					if (tachNgay[1].contentEquals(thang)) {
						System.out.println("Giao dịch tháng (" + choseMonth + ") - ngày(" +tachNgay[0]+ ") là: "+ frNha.thanhTien());
					}
				} else {
					System.out.println("Không tìm thấy tháng: " + thang);
				}		
			}
		}else {
			System.out.println("Giao dịch không tồn tại");
		}
	}
}

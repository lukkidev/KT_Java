import java.util.ArrayList;
import java.util.Scanner;

public class GDControlSearch {
	DSGDStorage gdSto;  
	
	GDControlSearch(){
		gdSto = new DSGDStorage();
	}
	
	
	void searchGiaoDich() {
		Scanner scan = new Scanner(System.in);
		System.out.println("----- TÌM KIẾM GIAO DỊCH-----");
		System.out.println("VD: 1.Giao dịch nhà 2.Giao dịch đất \rChọn:");
		int choseFind = scan.nextInt();
		System.out.println("Nhập mã giao dịch:");
		scan.nextLine();
		String transCodeFind = scan.nextLine();
		if (choseFind == 1) {
			ArrayList<GiaoDichNha> findGDN = gdSto.getGDNHA(); // lấy tất cả list gd nhà
			if (findGDN.size() == 0) {
				System.out.println("Bạn chưa nhập giao dịch gì lấy gì mà tìm kiếm");
				return;

			} else {
				for (int i = 0; i < findGDN.size(); i++) {
					if (findGDN.get(i).maGiaoDich.equals(transCodeFind)) { // lấy tất cả list so sánh xem có giống mã giao dịch không nếu đúng cho sửa
						System.out.println("ĐÃ TÌM THẤY GIAO DỊCH CÓ MÃ LÀ: " + transCodeFind);
						System.out.println("-Mã giao dịch: " + findGDN.get(i).maGiaoDich);
						System.out.println("-Nngày giao dich: " + findGDN.get(i).ngayGiaoDich);
						System.out.println("-Đơn giá: " + findGDN.get(i).donGia);
						System.out.println("-Loại nhà: " + (findGDN.get(i).loaiNha == 1 ? "Thường" : "Cao cấp")); // sài toán tử để kiểm tra nhà thường hay cao cấp
						System.out.println("-Thành tiền: " + findGDN.get(i).thanhTien());
					}
				}
			}

		}else if (choseFind == 2) {
			ArrayList<GiaoDichDat> findGDD = gdSto.getGDDAT();// lấy tất cả list gd đất
			if (findGDD.size() == 0) {
				System.out.println("Bạn chưa nhập giao dịch gì lấy gì mà tìm kiếm");
				return;

			} else {
				for (int i = 0; i < findGDD.size(); i++) {
					if (findGDD.get(i).maGiaoDich.equals(transCodeFind)) // lấy tất cả list so sánh xem cógiống mã giao dịch không nếu đúng cho sửa 
					{
						System.out.println("ĐÃ TÌM THẤY GIAO DỊCH CÓ MÃ LÀ: " + transCodeFind);
						System.out.println("-Mã giao dịch: " + findGDD.get(i).maGiaoDich);
						System.out.println("-Nngày giao dich: " + findGDD.get(i).ngayGiaoDich);
						System.out.println("-Đơn giá: " + findGDD.get(i).donGia);
						System.out.println("-Loại đất: " + findGDD.get(i).loaiDat);
						System.out.println("-Thành tiền: " + findGDD.get(i).thanhTien());
					}
				}
			}

		}else {
			System.out.println("Giao dịch không tồn tại");
		}
	}
}

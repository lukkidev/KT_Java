import java.util.Scanner;

public class GDInput {
	Scanner scan = new Scanner(System.in);

	void input() {
		String maGiaoDich = "";
		String ngayGiaoDich = "";
		double donGia = 0;
		double dienTich = 0;
		System.out.print("Nhập mã giao dịch:");
		maGiaoDich = scan.nextLine();
		System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
		ngayGiaoDich = scan.nextLine();
		while (true) {
			if (ngayGiaoDich.split("/").length >= 2) { // kiểm tra định dạng ngày xem đúng hay không rồi mới thực hiện
														// tiếp
				break;
			} else {
				System.out.println("Định dạng ngày bạn nhập sai vui lòng nhập lại!");
				System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
				ngayGiaoDich = scan.nextLine();
			}
		}
		System.out.print("Nhập đơn giá:");
		donGia = scan.nextDouble();
		System.out.print("Nhập diện tích:");
		dienTich = scan.nextDouble();
		System.out.print("Chọn loại giao dịch \r1.Giao dịch đất\r2.Giao dịch nhà\rChọn:");
		int chose = scan.nextInt();
		if (chose == 1) {
			
			System.out.println("----- GIAO DỊCH ĐẤT -----");
			System.out.println("Chọn loại đất VD: A,B,C \rChọn:");
			scan.nextLine();
			String loaiDat = scan.nextLine();
			GiaoDichDB.addGDDat( new GiaoDichDat(maGiaoDich, donGia, dienTich, ngayGiaoDich, loaiDat));	
			System.out.println("-------------------------");
		} else if (chose == 2) {
			System.out.println("----- GIAO DỊCH NHÀ -----");
			System.out.print("Chọn loại nhà VD: 1.Cao cấp 2.Thường\rChọn:");
			int typeHome = scan.nextInt();
			String diaChi = scan.nextLine();
			GiaoDichDB.addGDNha(new GiaoDichNha(maGiaoDich, donGia, dienTich, ngayGiaoDich, typeHome, diaChi));
			System.out.println("-------------------------");
			
		} else {
			System.out.print("Lỗi: Giao dịch không tồn tại");
		}

	}
	static Scanner scanst = new Scanner(System.in);
	
	static GiaoDichDat updateGDDAT() {
		System.out.println("----- CẬP NHẬT GIAO DỊCH ĐẤT -----");
		String maGiaoDich = "";
		String ngayGiaoDich = "";
		double donGia = 0;
		double dienTich = 0;
		System.out.print("Nhập mã giao dịch:");
		maGiaoDich = scanst.nextLine();
		System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
		ngayGiaoDich = scanst.nextLine();
		while (true) {
			if (ngayGiaoDich.split("/").length >= 2) { // kiểm tra định dạng ngày xem đúng hay không rồi mới thực hiện tiếp									
				break;
			} else {
				System.out.println("Định dạng ngày bạn nhập sai vui lòng nhập lại!");
				System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
				ngayGiaoDich = scanst.nextLine();
			}
		}
		System.out.println("Chọn loại đất VD: A,B,C \rChọn:");
		scanst.nextLine();
		String loaiDat = scanst.nextLine();
		return  new GiaoDichDat(maGiaoDich, donGia, dienTich, ngayGiaoDich, loaiDat);
	}
	
	static GiaoDichNha updateGDNHA() {
		System.out.println("----- CẬP NHẬT GIAO DỊCH NHÀ -----");
		String maGiaoDich = "";
		String ngayGiaoDich = "";
		double donGia = 0;
		double dienTich = 0;
		System.out.print("Nhập mã giao dịch:");
		maGiaoDich = scanst.nextLine();
		System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
		ngayGiaoDich = scanst.nextLine();
		while (true) {
			if (ngayGiaoDich.split("/").length >= 2) { // kiểm tra định dạng ngày xem đúng hay không rồi mới thực hiện tiếp									
				break;
			} else {
				System.out.println("Định dạng ngày bạn nhập sai vui lòng nhập lại!");
				System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
				ngayGiaoDich = scanst.nextLine();
			}
		}
		System.out.print("Chọn loại nhà VD: 1.Cao cấp 2.Thường\rChọn:");
		int typeHome = scanst.nextInt();
		String diaChi = scanst.nextLine();
		return new GiaoDichNha(maGiaoDich, donGia, dienTich, ngayGiaoDich, typeHome, diaChi);
		
	}
}

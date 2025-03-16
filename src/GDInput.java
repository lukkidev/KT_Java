import java.util.Scanner;

public class GDInput {
	Scanner scan = new Scanner(System.in);

	void input() {
		String maGiaoDich = "";
		String ngayGiaoDich = "";
		double donGia = 0;
		double dienTich = 0;
		GDStorage gdSt = new GDStorage();
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
			gdSt.insertGDDat( new GiaoDichDat(maGiaoDich, donGia, dienTich, ngayGiaoDich, loaiDat));	
			System.out.println("-------------------------");
		} else if (chose == 2) {
			System.out.println("----- GIAO DỊCH NHÀ -----");
			System.out.print("Chọn loại nhà VD: 1.Cao cấp 2.Thường\rChọn:");
			int typeHome = scan.nextInt();
			String diaChi = scan.nextLine();
			gdSt.insertGDNha(new GiaoDichNha(maGiaoDich, donGia, dienTich, ngayGiaoDich, typeHome, diaChi));
			System.out.println("-------------------------");
			
		} else {
			System.out.print("Lỗi: Giao dịch không tồn tại");
		}

	}
	
}

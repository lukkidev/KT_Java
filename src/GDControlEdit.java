import java.util.ArrayList;
import java.util.Scanner;

public class GDControlEdit {
	
	DSGDStorage gdSto;
	GDControlEdit(){
		gdSto = new DSGDStorage();
	}
	
	void editGiaoDich(){
		Scanner scan = new Scanner(System.in);
		System.out.println("----- SỬA GIAO DỊCH -----");
		System.out.println("VD: 1.Giao dịch nhà 2.Giao dịch đất \rChọn:");
		int choseUpdate = scan.nextInt();
		System.out.println("Nhập mã giao dịch:");
		scan.nextLine();
		String transCode = scan.nextLine();
		if (choseUpdate == 1) {
			ArrayList<GiaoDichNha> updateGN = gdSto.getGDNHA(); // lấy tất cả list gd nhà
			if (updateGN.size() == 0) {
				System.out.println("Bạn chưa nhập giao dịch gì lấy gì mà sửa");
				return;

			} else {
				for (int i = 0; i < updateGN.size(); i++) {
					if (updateGN.get(i).maGiaoDich.equals(transCode)) { // lấy tất cả list so sánh xem có giống mã giao dịch không nếu đúng cho sửa
						System.out.println("----- CẬP NHẬT GIAO DỊCH NHÀ -----");
						String maGiaoDich = "";
						String ngayGiaoDich = "";
						double donGia = 0;
						double dienTich = 0;
						System.out.print("Nhập mã giao dịch:");
						maGiaoDich = scan.nextLine();
						System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
						ngayGiaoDich = scan.nextLine();
						while (true) {
							if (ngayGiaoDich.split("/").length >= 2) { // kiểm tra định dạng ngày xem đúng hay không rồi mới thực hiện tiếp									
								break;
							} else {
								System.out.println("Định dạng ngày bạn nhập sai vui lòng nhập lại!");
								System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
								ngayGiaoDich = scan.nextLine();
							}
						}
						System.out.print("Chọn loại nhà VD: 1.Cao cấp 2.Thường\rChọn:");
						int typeHome = scan.nextInt();
						String diaChi = scan.nextLine();
						updateGN.set(i, new GiaoDichNha(maGiaoDich, donGia, dienTich, ngayGiaoDich, typeHome, diaChi)); // cập nhât thông tin cho phần tử 						
					}	
				}
			}

		} else if (choseUpdate == 2) {
			ArrayList<GiaoDichDat> updateGD = gdSto.getGDDAT();// lấy tất cả list gd đất
			if (updateGD.size() == 0) {
				System.out.println("Bạn chưa nhập giao dịch gì lấy gì mà sửa");
				return;

			} else {
				for (int i = 0; i < updateGD.size(); i++) {
					if (updateGD.get(i).maGiaoDich.equals(transCode)) { // lấy tất cả list so sánh xem có giống mã giao dịch không nếu đúng cho sửa
						System.out.println("----- CẬP NHẬT GIAO DỊCH ĐẤT -----");
						String maGiaoDich = "";
						String ngayGiaoDich = "";
						double donGia = 0;
						double dienTich = 0;
						System.out.print("Nhập mã giao dịch:");
						maGiaoDich = scan.nextLine();
						System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
						ngayGiaoDich = scan.nextLine();
						while (true) {
							if (ngayGiaoDich.split("/").length >= 2) { // kiểm tra định dạng ngày xem đúng hay không rồi mới thực hiện tiếp									
								break;
							} else {
								System.out.println("Định dạng ngày bạn nhập sai vui lòng nhập lại!");
								System.out.print("Nhập ngày giao dịch (dd/mm/yyyy):");
								ngayGiaoDich = scan.nextLine();
							}
						}
						System.out.println("Chọn loại đất VD: A,B,C \rChọn:");
						scan.nextLine();
						String loaiDat = scan.nextLine();
						updateGD.set(i, new GiaoDichDat(maGiaoDich, donGia, dienTich, ngayGiaoDich, loaiDat)); // cập nhât thông tin cho phần tử 		
					}
				}
			}

		}else {
			System.out.println("Giao dịch không tồn tại");
		}
	}
	
}

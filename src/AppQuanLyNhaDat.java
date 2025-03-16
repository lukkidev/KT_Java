import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class AppQuanLyNhaDat {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		GDInput gd = new GDInput();
		while (true) {
			System.out.println("----- MENU -----");
			System.out.println("1. Thêm mới giao dịch");
			System.out.println("2. Xóa giao dịch");
			System.out.println("3. Sửa giao dịch");
			System.out.println("4. Tìm kiếm giao dịch");
			System.out.println("5. Tính tổng số lượng cho từng loại");
			System.out.println("6. Tính trung bình thành tiền của giao dịch đất");
			System.out.println("7. Xuất ra các giao dịch của tháng nào đó");
			System.out.println("8. Thoát");
			System.out.print("Chọn chức năng: ");
			int chose = scanner.nextInt();
			scanner.nextLine();
			switch (chose) {
			case 1:
				gd.input();
				break;
			case 2:
				System.out.println("----- XÓA GIAO DỊCH -----");
				System.out.println("VD: 1.Giao dịch nhà 2.Giao dịch đất \rChọn:");
				int choseDel = scanner.nextInt();
				if (choseDel == 1) { // lấy trực tiếp danh sách gd nhà bằng static method không cần tạo đối tượng
					ArrayList<GiaoDichNha> delNha = new GiaoDichDB().getNha(); // lấy danh sách gd nhà trong database ra
					delNha.clear(); // thực hiện xóa tất cả dữ liệu trong gd nhà
				} else if (choseDel == 2) {
					ArrayList<GiaoDichDat> delDat = new GiaoDichDB().getDat(); // lấy danh sách gd đất trong database ra
					delDat.clear();// thực hiện xóa tất cả dữ liệu trong gd đất
				}else {
					System.out.println("Giao dịch không tồn tại");
				}
				break;
			case 3:
				System.out.println("----- SỬA GIAO DỊCH -----");
				System.out.println("VD: 1.Giao dịch nhà 2.Giao dịch đất \rChọn:");
				int choseUpdate = scanner.nextInt();
				System.out.println("Nhập mã giao dịch:");
				scanner.nextLine();
				String transCode = scanner.nextLine();
				if (choseUpdate == 1) {
					ArrayList<GiaoDichNha> updateGN = new GiaoDichDB().getNha(); // lấy tất cả list gd nhà
					if (updateGN.size() == 0) {
						System.out.println("Bạn chưa nhập giao dịch gì lấy gì mà sửa");
						break;

					} else {
						for (int i = 0; i < updateGN.size(); i++) {
							if (updateGN.get(i).maGiaoDich.equals(transCode)) { // lấy tất cả list so sánh xem có giống
																				// mã giao dịch không nếu đúng cho sửa
								updateGN.set(i, GDInput.updateGDNHA()); // sài static method không cần khởi tạo đối
																		// tượng đến
							}
						}
					}

				} else if (choseUpdate == 2) {
					ArrayList<GiaoDichDat> updateGD = new GiaoDichDB().getDat();// lấy tất cả list gd đất
					if (updateGD.size() == 0) {
						System.out.println("Bạn chưa nhập giao dịch gì lấy gì mà sửa");
						break;

					} else {
						for (int i = 0; i < updateGD.size(); i++) {
							if (updateGD.get(i).maGiaoDich.equals(transCode)) { // lấy tất cả list so sánh xem có giống
																				// mã giao dịch không nếu đúng cho sửa
								updateGD.set(i, GDInput.updateGDDAT()); // sài static method không cần khởi tạo đối
																		// tượng đến
							}
						}
					}

				}else {
					System.out.println("Giao dịch không tồn tại");
				}

				break;
			case 4:
				System.out.println("----- TÌM KIẾM GIAO DỊCH-----");
				System.out.println("VD: 1.Giao dịch nhà 2.Giao dịch đất \rChọn:");
				int choseFind = scanner.nextInt();
				System.out.println("Nhập mã giao dịch:");
				scanner.nextLine();
				String transCodeFind = scanner.nextLine();
				if (choseFind == 1) {
					ArrayList<GiaoDichNha> findGDN = new GiaoDichDB().getNha(); // lấy tất cả list gd nhà
					if (findGDN.size() == 0) {
						System.out.println("Bạn chưa nhập giao dịch gì lấy gì mà tìm kiếm");
						break;

					} else {
						for (int i = 0; i < findGDN.size(); i++) {
							if (findGDN.get(i).maGiaoDich.equals(transCodeFind)) { // lấy tất cả list so sánh xem có giống mã giao dịch không nếu đúng cho sửa
								System.out.println("ĐÃ TÌM THẤY GIAO DỊCH CÓ MÃ LÀ: " + transCodeFind);
								System.out.println("-Mã giao dịch: " + findGDN.get(i).maGiaoDich);
								System.out.println("-Nngày giao dich: " + findGDN.get(i).ngayGiaoDich);
								System.out.println("-Đơn giá: " + findGDN.get(i).donGia);
								System.out.println("-Loại nhà: " + (findGDN.get(i).loaiNha == 1 ? "Thường" : "Cao cấp")); // sài toán tử để kiểm tra nhà thường hay cao cấp
								System.out.println("-Thành tiền: " + findGDN.get(i).ThanhTien());
							}
						}
					}

				} else if (choseFind == 2) {
					ArrayList<GiaoDichDat> findGDD = new GiaoDichDB().getDat();// lấy tất cả list gd đất
					if (findGDD.size() == 0) {
						System.out.println("Bạn chưa nhập giao dịch gì lấy gì mà tìm kiếm");
						break;

					} else {
						for (int i = 0; i < findGDD.size(); i++) {
							if (findGDD.get(i).maGiaoDich.equals(transCodeFind)) { // lấy tất cả list so sánh xem cógiống mã giao dịch không nếu đúng cho sửa
								System.out.println("ĐÃ TÌM THẤY GIAO DỊCH CÓ MÃ LÀ: " + transCodeFind);
								System.out.println("-Mã giao dịch: " + findGDD.get(i).maGiaoDich);
								System.out.println("-Nngày giao dich: " + findGDD.get(i).ngayGiaoDich);
								System.out.println("-Đơn giá: " + findGDD.get(i).donGia);
								System.out.println("-Loại đất: " + findGDD.get(i).loaiDat);
								System.out.println("-Thành tiền: " + findGDD.get(i).ThanhTien());
							}
						}
					}

				}else {
					System.out.println("Giao dịch không tồn tại");
				}
				break;
			case 5:
				System.out.println("Tổng số lượng giao dịch đất: " + new GiaoDichDB().getDat().size()); // lấy ra tất cả số lượng phầm tử trong database đất
				System.out.println("Tổng số lượng giao dịch nhà: " + new GiaoDichDB().getNha().size());// lấy ra tất cả số lượng phầm tử trong database nhà
				break;
			case 6:
				double tong = 0;
				int counts = 0;
				for (GiaoDichDat dat : GiaoDichDB.lstGiaoDichDat) { // sài foreach để lấy
					tong += dat.ThanhTien(); // lấy hàm tính tiền của phần tử rồi cộng vô tổng để tính trung bình
					counts++;
				}
				if (counts > 0) {
					System.out.println("-Thành tiền của giao dịch đất: " + tong / counts);
				} else {
					System.out.println("Lỗi: Giao dịch đất chưa có dư liệu");
				}
				break;
			case 7:
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("----- XUẤT GIAO DỊCH THÁNG -----");
				System.out.println("Nhập tháng: ");
				String thang = scanner.nextLine();
				System.out.println("Nhập tháng: ");
				System.out.println("VD: 1.Giao dịch nhà 2.Giao dịch đất \rChọn:");
				int choseMonth = scanner.nextInt();
				if (choseMonth == 1) {
					for (GiaoDichDat frdat : GiaoDichDB.lstGiaoDichDat) {
						// chuyển int thành string để so sánh với ngày giao dịch đã chuyển thành string
						// dùng split để lấy ra tháng cần vd: 15/05/2006 split("/")[1] thì sẽ lấy 05 và index [0] sẽ lấy 15
						// so sánh tháng người dùng nhập vào với tháng trong danh sách giao dịch đất
						String ngayStr = sdf.format(frdat.ngayGiaoDich); // chuyển Date thành string để tách lấy tháng
						String[] tachNgay = ngayStr.split("/"); // tách ra thành ngày,tháng, năm
						if (tachNgay.length >= 2) { // kiểm tra đúng địng dạng ngày không
							if (tachNgay[1].contentEquals(thang)) {
								System.out.println("Giao dịch tháng (" + choseMonth + ") - ngày(" +tachNgay[0]+ ") là: "+ frdat.ThanhTien());
							}
						} else {
							System.out.println("Không tìm thấy tháng: " + thang);
						}				
					}

				}else if (choseMonth == 2) {
					for (GiaoDichNha frNha : GiaoDichDB.lstGiaoDichNha) {
						String ngayStr = sdf.format(frNha.ngayGiaoDich); // chuyển Date thành string để tách lấy tháng
						String[] tachNgay = ngayStr.split("/"); // tách ra thành ngày,tháng, năm
						if (tachNgay.length >= 2) { // kiểm tra đúng địng dạng ngày không
							if (tachNgay[1].contentEquals(thang)) {
								System.out.println("Giao dịch tháng (" + choseMonth + ") - ngày(" +tachNgay[0]+ ") là: "+ frNha.ThanhTien());
							}
						} else {
							System.out.println("Không tìm thấy tháng: " + thang);
						}		
					}
				}else {
					System.out.println("Giao dịch không tồn tại");
				}
				
				break;
			case 8:
				System.exit(0); // kết thúc chương trinh ngay lặp tức
				break;
			case 9: // TEST HIỂN THỊ DANH SÁCH
				ArrayList<GiaoDichDat> listShow = new GiaoDichDB().getDat();
				for (int i = 0; i < listShow.size(); i++) {
					System.out.print(listShow.get(i).maGiaoDich);
				}
				break;
			default:
				System.out.print("Lỗi: Giá trị không tồn tại trong Menu");
				break;
			}
		}

	}

}

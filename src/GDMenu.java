import java.util.Scanner;

public class GDMenu {
	GDInput gd;
	GDControlDel delGD;
	GDControlEdit editGD;
	GDControlSearch sreachGD;
	GDControlAmount amountGD;
	GDControlTBDat tbGD;
	GDControlGDThang thangDG;
	Scanner scanner = new Scanner(System.in);
	
	GDMenu(){
		gd = new GDInput();
		delGD = new GDControlDel();
		editGD= new GDControlEdit();
		amountGD = new GDControlAmount();
		tbGD= new GDControlTBDat();
		thangDG = new GDControlGDThang();
	}
	
	void controlLoop() {
	
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
				add();
				break;
			case 2:
			    delete();
				break;
			case 3:
				edit();
				break;
			case 4:
				search();
				break;
			case 5:
			    amount();
				break;
			case 6:
				trungbinh();
				break;
			case 7:
				giaodichthang();
				break;
			case 8:
				System.exit(0); // kết thúc chương trinh ngay lặp tức
				break;
			default:
				System.out.print("Lỗi: Giá trị không tồn tại trong Menu");
				break;
			}
		}

	}

	void giaodichthang() {
		
		thangDG.giaoDichThang();
	}

	void trungbinh() {
		tbGD.thanhTienGDD();		
	}

	void amount() {
		
		amountGD.amountGiaoDich();
	}

	void search() {
		sreachGD.searchGiaoDich();
	}

	void edit() {
		editGD.editGiaoDich();
	}

	void delete() {
		delGD.delGiaoDich();
	}

	void add() {
		gd.input();	
	}

}

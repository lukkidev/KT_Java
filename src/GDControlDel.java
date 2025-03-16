import java.util.ArrayList;
import java.util.Scanner;

public class GDControlDel {
	DSGDStorage gdSto;
	GDControlDel(){
		gdSto = new DSGDStorage();
	}
	
	void delGiaoDich() {
		Scanner scan = new Scanner(System.in);
		System.out.println("----- XÓA GIAO DỊCH -----");
		System.out.println("VD: 1.Giao dịch nhà 2.Giao dịch đất \rChọn:");
		int choseDel = scan.nextInt();
		System.out.print("Nhập mã giao dịch:");
		scan.nextLine();
		String code = scan.nextLine();
		if (choseDel == 1) { 
			ArrayList<GiaoDichNha> delNha = gdSto.getGDNHA();
			for (int i = 0; i < delNha.size(); i++) {
				if(delNha.get(i).maGiaoDich.equals(code)) { // kiểm tra mã giao dịch ở phần tử đó có trùng với mã giao dịch cần xóa không
					delNha.remove(i); // xóa phần tử tại index đ
				}
			}
		
		} else if (choseDel == 2) {
			ArrayList<GiaoDichDat> delDat = gdSto.getGDDAT();
			for (int i = 0; i < delDat.size(); i++) {
				if(delDat.get(i).maGiaoDich.equals(code)) { // kiểm tra mã giao dịch ở phần tử đó có trùng với mã giao dịch cần xóa không
					delDat.remove(i); // xóa phần tử tại index đ
				}
			}
		}else {
			System.out.println("Giao dịch không tồn tại");
		}
	}

}

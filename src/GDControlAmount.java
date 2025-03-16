
public class GDControlAmount {
	DSGDStorage storage;
	
	GDControlAmount(){
		storage = new DSGDStorage();
	}
	
	void amountGiaoDich() {
		System.out.println("Tổng số lượng giao dịch đất: " + storage.getGDDAT().size()); // lấy ra tất cả số lượng phầm tử trong database đất
		System.out.println("Tổng số lượng giao dịch nhà: " + storage.getGDNHA().size());// lấy ra tất cả số lượng phầm tử trong database nhà
	}

}

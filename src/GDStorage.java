
public class GDStorage {
	
	GDStorage(){
		
	}
	
	void insertGDNha(GiaoDichNha nha) {
		GiaoDichDB.addGDNha(nha);
	}
	void insertGDDat(GiaoDichDat dat) {
		GiaoDichDB.addGDDat(dat);
	}
}

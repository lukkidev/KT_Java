import java.util.ArrayList;
public class GiaoDichDB {
	//DATABASE Giao dịch
	static ArrayList<GiaoDichDat> lstGiaoDichDat = new ArrayList<GiaoDichDat>();
	static ArrayList<GiaoDichNha> lstGiaoDichNha = new ArrayList<GiaoDichNha>();
	
	static void addGDDat(GiaoDichDat dat) {
		lstGiaoDichDat.add(dat);
	}
	
	static void addGDNha(GiaoDichNha nha) {
		lstGiaoDichNha.add(nha);
	}
	static ArrayList<GiaoDichDat> getDat() {
		return lstGiaoDichDat;
	}
	static ArrayList<GiaoDichNha> getNha() {
		return lstGiaoDichNha;
	}
	

}

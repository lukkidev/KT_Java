import java.util.ArrayList;

public class DSGDStorage {
	DSGDStorage(){
		
	}
	ArrayList<GiaoDichDat> getGDDAT(){
		return GiaoDichDB.getDat();
	}
	ArrayList<GiaoDichNha> getGDNHA(){
		return GiaoDichDB.getNha();
	}
}

package classes;
//======================이하 필드 영역======================================
// CRUD기능
public class FriendApp {
	//필드 : 친구정보를 저장할 수 있는 배열.
	String friends[];
//======================이하 생성자 영역=====================================
	public FriendApp() {
		friends = new String[10]; 
	}
//======================이하 메서드 영역=====================================	
//구현코자 하는 메뉴 : 1.등록 2.목록 3.수정 4.삭제 9.종료.	
	// 1.등록에 관한 동작
	public boolean add(Friend ftd) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = ftd;
				return true;
			}
		}return false;
		
	}
	// 2. 목록 출력에 관한 동작
	public Friend[] list() {
		return friends;
	}
	
	// 3. 수정에 관한 동작
	public boolean modify(String fname, String ftel) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].getFname().equals(fname)) {
				friends[i].setFtel(ftel);
				return true;
			}
		}
		return false;
	}
	// 4. 삭제에 관한 동작
	public boolean remove(String fname) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].getFname().equals(fname)) {
				friends[i] = null;
				return true;
			}
		}
		return false;
	}
	// 9. 종료에 관한 동작 -> 단순하므로 Exe에서 처리하기로 함.
	
	
	
	
	
	
	
	
	
}
